Feature: PERA Admin Bootstrapping Process
  As a PERA Administrator
  I want to manage and monitor Financial Institution registrations
  So that I can oversee the PERA ecosystem

  Background:
    Given the PERA Admin has valid administrative credentials
    And the PERA Admin has a valid mTLS certificate

  Scenario: Retrieve All Registered Organizations
    Given there are multiple organizations registered in the system:
      | Organization ID | Organization Name | Organization Type      |
      | bank_123       | Sample Bank       | CONTRIBUTOR_INSTITUTION|
      | bank_456       | Another Bank      | CONTRIBUTOR_INSTITUTION|
    When the PERA Admin sends a GET request to "/admin/organization"
    Then the response status code should be 200
    And the response should contain a list of registered organizations
    And each organization should have valid endpoint URIs
    And each organization should have a valid participant-id

  Scenario: Retrieve Single Organization Details
    Given an organization with ID "bank_123" exists in the system
    When the PERA Admin sends a GET request to "/admin/organization/bank_123"
    Then the response status code should be 200
    And the response should contain detailed organization information
    And the response should include all registered endpoints
    And the response should include organization status

  Scenario: Retrieve Organization Certificate
    Given an organization with ID "bank_123" exists in the system
    When the PERA Admin sends a GET request to "/admin/organization/bank_123/certificate"
    Then the response status code should be 200
    And the response should contain a valid X.509 certificate
    And the certificate should be in PEM format
    And the certificate details should include:
      | Field        | Value                    |
      | validFrom   | [current_date]           |
      | validUntil  | [current_date + 1 year]  |
      | subject     | CN=Sample Bank,O=Sample Bank Corporation |

  Scenario: Filter Organizations by Type
    Given there are organizations of different types in the system:
      | Organization ID | Organization Name | Organization Type      |
      | bank_123       | Sample Bank       | CONTRIBUTOR_INSTITUTION|
      | admin_456      | Admin Corp        | ADMINISTRATOR         |
    When the PERA Admin sends a GET request to "/admin/organization?type=CONTRIBUTOR_INSTITUTION"
    Then the response status code should be 200
    And the response should only contain organizations of type "CONTRIBUTOR_INSTITUTION"

  Scenario: Monitor Organization Status
    Given there are organizations with different statuses:
      | Organization ID | Status    |
      | bank_123       | ACTIVE    |
      | bank_456       | INACTIVE  |
      | bank_789       | SUSPENDED |
    When the PERA Admin sends a GET request to "/admin/organization/status"
    Then the response status code should be 200
    And the response should contain status information for all organizations
    And each status entry should include last update timestamp

  Scenario: Verify Organization Endpoints Availability
    Given an organization with ID "bank_123" exists in the system
    When the PERA Admin initiates endpoint verification for "bank_123"
    Then the response status code should be 200
    And the system should verify all registered endpoints
    And the response should include endpoint health status
    And the response should include last successful connection timestamp

  Scenario: Certificate Expiry Monitoring
    Given there are organizations with different certificate expiry dates:
      | Organization ID | Days Until Expiry |
      | bank_123       | 30                |
      | bank_456       | 60                |
      | bank_789       | 5                 |
    When the PERA Admin sends a GET request to "/admin/organization/certificate/status"
    Then the response status code should be 200
    And the response should contain certificate expiry information
    And organizations with certificates expiring within 30 days should be flagged
