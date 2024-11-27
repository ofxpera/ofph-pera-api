Feature: PERA Central Hub API Registry
  As a PERA Central Hub Administrator
  I want to manage and monitor registered APIs from Financial Institutions and PERA Administrators
  So that I can ensure secure and standardized API access across the PERA ecosystem

  Background:
    Given the Central Hub system is operational
    And the administrator has valid authentication credentials
    And required security certificates are in place

  Scenario: Register New Financial Institution API Endpoints
    Given a Financial Institution "Sample Bank" prepares to register their APIs:
      | API Type             | Endpoint                                 | Version | Status    |
      | Authorization Server | https://auth.samplebank.com              | v1.0    | Active    |
      | Resource Server      | https://api.samplebank.com               | v1.0    | Active    |
      | PERA Account API     | https://pera.samplebank.com              | v1.0    | Active    |
    When the Financial Institution sends a POST request to "/admin/registry/institution"
    Then the response status code should be 201
    And the response should contain a unique registry ID
    And the response should include API validation status
    And the system should initiate endpoint health checks

  Scenario: Register PERA Administrator API Endpoints
    Given a PERA Administrator "PERA Admin Corp" prepares to register their APIs:
      | API Type              | Endpoint                                 | Version | Status    |
      | Customer Portal       | https://portal.peraadmin.com             | v1.0    | Active    |
      | Institution Gateway   | https://gateway.peraadmin.com            | v1.0    | Active    |
    When the Administrator sends a POST request to "/admin/registry/administrator"
    Then the response status code should be 201
    And the response should contain administrator-specific configurations
    And the system should verify portal accessibility

  Scenario: Retrieve All Registered APIs
    Given multiple institutions have registered their APIs
    When an administrator sends a GET request to "/admin/registry"
    Then the response status code should be 200
    And the response should contain a list of all registered APIs:
      | Institution     | API Type          | Status  | Last Health Check |
      | Sample Bank     | Authorization     | Active  | [timestamp]       |
      | Another Bank    | PERA Account      | Active  | [timestamp]       |
      | PERA Admin Corp | Customer Portal   | Active  | [timestamp]       |

  Scenario: Filter APIs by Institution Type
    Given various types of institutions are registered
    When an administrator sends a GET request to "/admin/registry?type=FINANCIAL_INSTITUTION"
    Then the response status code should be 200
    And the response should only contain Financial Institution APIs
    And each entry should include compliance status

  Scenario: Update API Endpoint Configuration
    Given an institution "Sample Bank" has registered APIs
    When they send a PATCH request to update their endpoint:
      | Field           | Old Value                      | New Value                      |
      | resourceServer  | https://api.samplebank.com     | https://api-v2.samplebank.com  |
      | version         | v1.0                           | v2.0                           |
    Then the response status code should be 200
    And the system should validate the new endpoint
    And maintain a history of endpoint changes

  Scenario: Monitor API Health Status
    Given multiple APIs are registered in the system
    When the health check service runs
    Then each endpoint should be verified
    And the system should record health metrics:
      | Metric              | Threshold |
      | Response Time       | 500ms     |
      | Availability        | 99.9%     |
      | SSL Certificate     | Valid     |
      | Security Headers    | Complete  |

  Scenario: Handle API Version Deprecation
    Given an institution wants to deprecate API version "v1.0"
    When they send a POST request to "/admin/registry/deprecation"
    Then the response status code should be 200
    And the system should:
      | Action                    | Timeline     |
      | Notify Consumers          | Immediate    |
      | Set Grace Period          | 90 days      |
      | Schedule Deactivation     | [date]       |
      | Archive Specifications    | Yes          |

  Scenario: API Security Compliance Check
    Given a registered API endpoint
    When the compliance service performs a security audit
    Then it should verify:
      | Security Requirement        | Status |
      | mTLS Support               | Pass   |
      | OAuth 2.0 Implementation   | Pass   |
      | FAPI Compliance            | Pass   |
      | Certificate Strength       | Pass   |
      | Security Headers           | Pass   |

  Scenario: API Documentation Management
    Given an institution has registered APIs
    When they upload API documentation to "/admin/registry/docs"
    Then the response status code should be 201
    And the system should:
      | Action                          | Status    |
      | Validate OpenAPI Specification  | Complete  |
      | Generate Developer Portal       | Success   |
      | Create SDK Documentation        | Complete  |
      | Version Documentation           | Success   |

  Scenario: API Analytics and Usage Metrics
    Given multiple APIs are actively being used
    When an administrator requests usage metrics
    Then the response should include:
      | Metric                  | Period    | Format      |
      | Total Requests          | 24h       | Count       |
      | Average Response Time   | 24h       | Milliseconds|
      | Error Rate              | 24h       | Percentage  |
      | Active Consumers        | Current   | Count       |
      | Bandwidth Usage         | 24h       | GB          |

  Scenario: Emergency API Shutdown
    Given a security incident is reported for institution "Compromised Bank"
    When the administrator initiates emergency shutdown
    Then the system should:
      | Action                    | Timeline     |
      | Revoke Access Tokens      | Immediate    |
      | Block API Endpoints       | Immediate    |
      | Notify Stakeholders       | Immediate    |
      | Generate Incident Report  | 1 hour       |
      | Create Recovery Plan      | 24 hours     |
