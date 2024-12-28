Feature: Common API Endpoints
  As an OFxPERA participant
  I want to retrieve customer information
  So that I can provide PERA services

  Background:
    Given I have valid OFxPERA headers
      | header                      | value                    |
      | participant-id              | test-participant         |
      | x-v                         | 1                        |
      | x-fapi-auth-date            | 2024-03-19T10:00:00Z     |
      | x-fapi-customer-ip-address  | 192.168.1.1              |
      | Content-Type                | application/json         |

  Scenario: Successfully retrieve customer details
    Given I have a valid access token
    And I have a valid customer ID "test-customer-123"
    When I send a GET request to "/common/customers/test-customer-123/detail"
    Then the response status code should be 200
    And the response should contain customer information
      | field           |
      | sub             |
      | pii             |
      | cdd             |
      | presentedIds    |

  Scenario: Retrieve customer details with invalid ID
    Given I have a valid access token
    When I send a GET request to "/common/customers/invalid-id/detail"
    Then the response status code should be 404

  Scenario: Attempt to retrieve customer details without access token
    Given I have a valid customer ID "test-customer-123"
    When I send a GET request to "/common/customers/test-customer-123/detail"
    Then the response status code should be 401

  Scenario: Successfully retrieve complete customer profile
    Given I have a valid access token
    And I have a valid customer ID "test-customer-123"
    When I send a GET request to "/common/customers/test-customer-123/detail"
    Then the response status code should be 200
    And the response should contain personal information
      | field         |
      | givenName     |
      | lastName      |
      | mobileNumber  |
      | email         |
      | birthdate     |
      | nationality   |
    And the response should contain customer due diligence
      | field            |
      | employmentStatus |
      | pepIndicator     |
      | fundSource       |
      | cddIndicator     |
    And the response should contain presented IDs
      | field       |
      | idNumber    |
      | idType      | 