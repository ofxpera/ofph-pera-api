Feature: OAuth API Endpoints
  As an OFxPERA participant
  I want to authenticate and authorize users
  So that they can access protected resources securely

  Background:
    Given I have valid OFxPERA headers
      | header                      | value                    |
      | participant-id              | test-participant         |
      | x-v                         | 1                        |
      | x-fapi-auth-date            | 2024-03-19T10:00:00Z     |
      | x-fapi-customer-ip-address  | 192.168.1.1              |
      | Content-Type                | application/json         |

  Scenario: Successfully initiate authorization flow
    Given I have valid authorization parameters
      | parameter        | value                                |
      | client_id        | test-client-123                      |
      | response_type    | code                                 |
      | scope            | openid profile                       |
      | redirect_uri     | https://test-client.com/callback     |
      | code_challenge   | test-challenge                       |
      | code_challenge_method | S256                            |
      | state           | test-state-123                        |
      | nonce           | test-nonce-456                        |
    When I send a GET request to "/oauth/auth"
    Then the response status code should be 302
    And the response should contain a Location header
    And the Location header should contain an authorization code
    And the Location header should contain the original state

  Scenario: Successfully exchange code for tokens
    Given I have a valid authorization code
    When I send a POST request to "/oauth/token" with form data
      | field          | value                                |
      | grant_type     | authorization_code                   |
      | code           | {authorization_code}                 |
      | redirect_uri   | https://test-client.com/callback     |
      | client_id      | test-client-123                      |
    Then the response status code should be 200
    And the response should contain an access_token
    And the response should contain a token_type
    And the response should contain an expires_in
    And the response should contain an id_token
    And the response should contain a refresh_token

  Scenario: Successfully refresh access token
    Given I have a valid refresh token
    When I send a POST request to "/oauth/token" with form data
      | field          | value                                |
      | grant_type     | refresh_token                        |
      | refresh_token  | {refresh_token}                      |
      | client_id      | test-client-123                      |
    Then the response status code should be 200
    And the response should contain an access_token
    And the response should contain a token_type
    And the response should contain an expires_in

  Scenario: Successfully retrieve user information
    Given I have a valid access token
    When I send a GET request to "/oauth/userinfo"
    Then the response status code should be 200
    And the response should contain user details
      | field             |
      | sub              |
      | name             |
      | email            |
      | email_verified   |

  Scenario: Successfully introspect token
    Given I have a valid access token
    When I send a GET request to "/oauth/introspect" with parameters
      | parameter | value           |
      | token    | {access_token}  |
    Then the response status code should be 200
    And the response should contain token information
      | field      |
      | active     |
      | client_id  |
      | scope      |
      | exp        | 