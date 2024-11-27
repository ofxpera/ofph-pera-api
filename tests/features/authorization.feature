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
    Given the PERA Admin prepares an authorization URL with the following parameters:
      | Parameter     | Value                                           |
      | response_type | code                                            |
      | client_id     | pera_admin_client_123                           |
      | redirect_uri  | https://peraadmin.com/callback                  |
      | scope         | openid profile accounts.basic accounts.details  |
      | state         | abc123xyz                                       |
      | nonce         | n-0S6_WzA2Mj                                    |
    When the PERA Admin redirects the customer to the FI's authorization endpoint
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
    And the id_token should contain the original nonce value

  Scenario: Failed Authorization - Invalid Client ID
    Given the PERA Admin prepares an authorization URL with invalid client_id:
      | Parameter     | Value                                    |
      | response_type | code                                     |
      | client_id     | invalid_client_123                       |
      | redirect_uri  | https://peraadmin.com/callback           |
      | scope         | openid profile                           |
      | state         | abc123xyz                                |
    When the PERA Admin redirects the customer to the FI's authorization endpoint
    Then the FI should display an error page
    And the error message should indicate "invalid_client"

  Scenario: Failed Authorization - Customer Denies Consent
    Given the PERA Admin initiates a valid authorization request
    And the customer successfully authenticates with the FI
    When the customer denies consent for the requested permissions
    Then the FI should redirect to the PERA Admin's callback URL
    And the redirect should include an error "access_denied"
    And the redirect should include the original state

  Scenario: Failed Authorization - Invalid Scope
    Given the PERA Admin prepares an authorization URL with invalid scope:
      | Parameter     | Value                                    |
      | response_type | code                                     |
      | client_id     | pera_admin_client_123                    |
      | redirect_uri  | https://peraadmin.com/callback           |
      | scope         | invalid.scope                            |
      | state         | abc123xyz                                |
    When the PERA Admin redirects the customer to the FI's authorization endpoint
    Then the FI should display an error page
    And the error message should indicate "invalid_scope"

  Scenario: Failed Authorization - Invalid Redirect URI
    Given the PERA Admin prepares an authorization URL with unregistered redirect URI:
      | Parameter     | Value                                    |
      | response_type | code                                     |
      | client_id     | pera_admin_client_123                    |
      | redirect_uri  | https://malicious-site.com/callback      |
      | scope         | openid profile                           |
      | state         | abc123xyz                                |
    When the PERA Admin redirects the customer to the FI's authorization endpoint
    Then the FI should display an error page
    And the error message should indicate "invalid_redirect_uri"

  Scenario: Timeout During Authorization Process
    Given the PERA Admin initiates a valid authorization request
    And the customer is redirected to the FI's login page
    When the session expires after inactivity
    Then the FI should redirect to the PERA Admin's callback URL
    And the redirect should include an error "login_timeout"
    And the redirect should include the original state

  Scenario: Authorization with Step-up Authentication
    Given the PERA Admin initiates a request requiring step-up authentication:
      | Parameter     | Value                                    |
      | response_type | code                                     |
      | client_id     | pera_admin_client_123                    |
      | redirect_uri  | https://peraadmin.com/callback           |
      | scope         | openid profile accounts.high_value       |
      | state         | abc123xyz                                |
      | acr_values    | urn:openbanking:psd2:sca                 |
    And the customer successfully completes primary authentication
    When the FI requests additional authentication factors
    And the customer successfully provides the required factors
    Then the FI should proceed to the consent page
    And complete the authorization process successfully

  Scenario: CSRF Protection with State Parameter
    Given the PERA Admin prepares an authorization URL with state parameter
    When the authorization process completes successfully
    Then the callback should include the exact same state value
    And the PERA Admin should verify the state before proceeding

  Scenario: Replay Attack Prevention
    Given the PERA Admin receives a callback with authorization code
    When the PERA Admin successfully exchanges the code for tokens
    And attempts to use the same authorization code again
    Then the token endpoint should return an error
    And the error should indicate "invalid_grant"
