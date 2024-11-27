Feature: PERA Authorization Flow
  As a PERA Admin
  I want to facilitate customer authentication and consent through their chosen Financial Institution
  So that customers can securely access their PERA accounts

  Background:
    Given the PERA Admin is registered in the system
    And the Financial Institution is registered in the system
    And the customer has chosen their Financial Institution
    And the PERA Admin has valid client credentials

  Scenario: Successful Authorization Flow with Customer Consent
    Given the PERA Admin initiates authorization request with the following details:
      | Parameter     | Value                                    |
      | response_type | code                                     |
      | client_id    | pera_admin_client_123                    |
      | redirect_uri | https://peraadmin.com/callback           |
      | scope        | openid profile accounts.basic accounts.details |
      | state        | abc123xyz                                |
    When the PERA Admin sends a POST request to "/oauth/par"
    Then the response status code should be 201
    And the response should contain a "request_uri"
    And the response should contain an "expires_in" value

    When the PERA Admin redirects the customer to the FI's authorization endpoint with the request_uri
    Then the FI should display their login page
    
    When the customer enters valid credentials
    Then the FI should authenticate the customer
    And display the consent page with requested permissions

    When the customer grants consent for the requested permissions
    Then the FI should redirect to the PERA Admin's callback URL
    And the redirect should include an authorization code
    And the redirect should include the original state "abc123xyz"

    When the PERA Admin exchanges the authorization code for tokens
    Then the response status code should be 200
    And the response should contain an "access_token"
    And the response should contain a "refresh_token"
    And the response should contain an "id_token"

  Scenario: Failed Authorization - Invalid Client Credentials
    Given the PERA Admin has invalid client credentials
    When the PERA Admin sends a POST request to "/oauth/par"
    Then the response status code should be 401
    And the response should contain an error message "invalid_client"

  Scenario: Failed Authorization - Customer Denies Consent
    Given the PERA Admin initiates a valid authorization request
    And the customer successfully authenticates with the FI
    When the customer denies consent for the requested permissions
    Then the FI should redirect to the PERA Admin's callback URL
    And the redirect should include an error "access_denied"
    And the redirect should include the original state

  Scenario: Failed Authorization - Invalid Scope
    Given the PERA Admin initiates authorization with invalid scope:
      | Parameter     | Value                                    |
      | response_type | code                                     |
      | client_id    | pera_admin_client_123                    |
      | redirect_uri | https://peraadmin.com/callback           |
      | scope        | invalid.scope                            |
      | state        | abc123xyz                                |
    When the PERA Admin sends a POST request to "/oauth/par"
    Then the response status code should be 400
    And the response should contain an error message "invalid_scope"

  Scenario: Timeout During Authorization Process
    Given the PERA Admin initiates a valid authorization request
    And the customer is redirected to the FI's login page
    When the session expires after inactivity
    Then the FI should redirect to the PERA Admin's callback URL
    And the redirect should include an error "login_timeout"
    And the redirect should include the original state

  Scenario: Authorization with Step-up Authentication
    Given the PERA Admin initiates a request requiring step-up authentication
    And the customer successfully completes primary authentication
    When the FI requests additional authentication factors
    And the customer successfully provides the required factors
    Then the FI should proceed to the consent page
    And complete the authorization process successfully
