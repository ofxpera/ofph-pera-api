Feature: Bootstrap API Endpoints
  As an OFxPERA participant
  I want to register and manage my system information
  So that I can participate in the OFxPERA ecosystem

  Background:
    Given I have valid OFxPERA headers
      | header                      | value                    |
      | participant-id              | test-participant         |
      | x-v                         | 1                        |
      | x-fapi-auth-date            | 2024-03-19T10:00:00Z     |
      | x-fapi-customer-ip-address  | 192.168.1.1              |
      | Content-Type                | application/json         |
      | participant-key             | test-key-123             |

  Scenario: Successfully register a new participant
    Given I have valid participant configuration data
      | field            | value                    |
      | participant_name | Test OFxPERA Admin       |
      | participant_type | PERA_ADMIN               |
      | registered_name  | Test OFxPERA Admin Inc.  |
    When I send a POST request to "/ofxpera/participants"
    Then the response status code should be 201
    And the response should contain a client_id
    And the response should contain a registration_access_token
    And the response should contain a registration_client_uri

  Scenario: Attempt to register participant with invalid data
    Given I have invalid participant configuration data
      | field            | value           |
      | participant_name | Test PERA Admin |
    When I send a POST request to "/ofxpera/participants"
    Then the response status code should be 400
    And the response should contain error details

  Scenario: Successfully update an existing participant
    Given I have a registered participant
    And I have a valid registration access token
    And I have updated participant configuration data
      | field  | value        |
      | status | MAINTENANCE  |
    When I send a PUT request to "/ofxpera/participants"
    Then the response status code should be 201
    And the response should contain updated participant details

  Scenario: Successfully retrieve list of participants
    Given there are registered participants in the system
    And I have a valid registration access token
    When I send a GET request to "/ofxpera/participants"
    Then the response status code should be 200
    And the response should contain a list of participants
    And each participant should have required fields
      | field            |
      | participant_id   |
      | participant_name |
      | endpoint_uris    |

  Scenario Outline: Attempt operations with missing required headers
    Given I have valid participant configuration data
    But I am missing the "<missing_header>" header
    When I send a POST request to "/ofxpera/participants"
    Then the response status code should be 401

    Examples:
      | missing_header              |
      | participant-id              |
      | x-v                         |
      | x-fapi-auth-date            |
      | x-fapi-customer-ip-address  |
      | participant-key             | 