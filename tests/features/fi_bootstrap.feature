Feature: Financial Institution Bootstrapping Process
  As a Financial Institution
  I want to register my API endpoints and upload my certificates
  So that I can participate in the PERA ecosystem

  Background:
    Given the Financial Institution has valid registration credentials
    And the Financial Institution has a valid mTLS certificate
    And the Financial Institution has their API endpoints ready

  Scenario: Successful Financial Institution Registration
    Given the Financial Institution prepares registration details:
      | Field               | Value                                    |
      | organizationId      | bank_123                                 |
      | organizationName    | Sample Bank                              |
      | organizationType    | CONTRIBUTOR_INSTITUTION                  |
      | registeredName      | Sample Bank Corporation                  |
      | contactDetails      | {"email": "api@samplebank.com", "phone": "6328123456"} |
      | endpointURIs        | {"authorizationEndpoint": "https://auth.samplebank.com/authorize", "tokenEndpoint": "https://auth.samplebank.com/token", "resourceEndpoint": "https://api.samplebank.com"} |
    When the Financial Institution sends a POST request to "/admin/organization"
    Then the response status code should be 201
    And the response should contain the registered organization details
    And the response should include a unique participant-id header

  Scenario: Failed Registration - Missing Required Fields
    Given the Financial Institution prepares incomplete registration details:
      | Field            | Value                                    |
      | organizationId   | bank_123                                 |
      | organizationName | Sample Bank                              |
    When the Financial Institution sends a POST request to "/admin/organization"
    Then the response status code should be 400
    And the response should contain validation errors for missing fields

  Scenario: Failed Registration - Duplicate Organization ID
    Given an organization with ID "bank_123" already exists
    When the Financial Institution attempts to register with the same ID:
      | Field               | Value                                    |
      | organizationId      | bank_123                                 |
      | organizationName    | Another Bank                             |
      | organizationType    | CONTRIBUTOR_INSTITUTION                  |
      | registeredName      | Another Bank Corporation                 |
      | contactDetails      | {"email": "api@anotherbank.com", "phone": "6328123457"} |
      | endpointURIs        | {"authorizationEndpoint": "https://auth.anotherbank.com/authorize"} |
    Then the response status code should be 409
    And the response should indicate a duplicate organization ID

  Scenario: Update Organization Endpoints
    Given a Financial Institution is registered with ID "bank_123"
    When the Financial Institution updates their endpoints:
      | Field               | Value                                    |
      | endpointURIs        | {"authorizationEndpoint": "https://auth-new.samplebank.com/authorize", "tokenEndpoint": "https://auth-new.samplebank.com/token", "resourceEndpoint": "https://api-new.samplebank.com"} |
    Then the response status code should be 200
    And the response should contain the updated endpoint URIs

  Scenario: Upload Organization Certificate
    Given a Financial Institution is registered with ID "bank_123"
    And the Financial Institution has a valid X.509 certificate
    When the Financial Institution uploads their certificate to "/admin/organization/bank_123/certificate"
    Then the response status code should be 201
    And the response should confirm successful certificate upload

  Scenario: Certificate Renewal Process
    Given a Financial Institution's certificate is near expiry
    When the Financial Institution requests a new certificate
    Then the response status code should be 200
    And the response should contain a new valid certificate
    And the new certificate should have a future expiry date
    And the old certificate should still be valid until expiry
