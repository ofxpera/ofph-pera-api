from behave import given, when, then
from behave.runner import Context
import requests
import json
from urllib.parse import urlparse, parse_qs

class AuthorizationTestContext:
    def __init__(self):
        self.base_url = "https://api.ofxpera.ph/v1"
        self.pera_admin_client_id = "pera_admin_client_123"
        self.pera_admin_client_secret = "client_secret_123"
        self.fi_auth_endpoint = "https://fi.example.com/authorize"
        self.request_uri = None
        self.auth_code = None
        self.tokens = None
        self.state = None

@given('the PERA Admin is registered in the system')
def step_impl(context: Context):
    context.auth = AuthorizationTestContext()
    # Setup test data or mock responses as needed
    context.auth.is_registered = True

@given('the Financial Institution is registered in the system')
def step_impl(context: Context):
    # Verify FI registration or setup mock data
    context.auth.fi_registered = True

@given('the customer has chosen their Financial Institution')
def step_impl(context: Context):
    # Set the chosen FI details
    context.auth.chosen_fi = {
        "id": "fi_123",
        "name": "Sample Bank",
        "auth_endpoint": "https://fi.example.com/authorize"
    }

@given('the PERA Admin has valid client credentials')
def step_impl(context: Context):
    context.auth.client_credentials_valid = True

@given('the PERA Admin initiates authorization request with the following details')
def step_impl(context: Context):
    context.auth.auth_request = {row['Parameter']: row['Value'] for row in context.table}

@when('the PERA Admin sends a POST request to "{endpoint}"')
def step_impl(context: Context, endpoint: str):
    url = context.auth.base_url + endpoint
    headers = {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Authorization': f'Basic {context.auth.pera_admin_client_id}:{context.auth.pera_admin_client_secret}'
    }
    response = requests.post(url, data=context.auth.auth_request, headers=headers)
    context.auth.response = response

@then('the response status code should be {status_code:d}')
def step_impl(context: Context, status_code: int):
    assert context.auth.response.status_code == status_code

@then('the response should contain a "{field}"')
def step_impl(context: Context, field: str):
    response_data = context.auth.response.json()
    assert field in response_data

@when('the PERA Admin redirects the customer to the FI\'s authorization endpoint with the request_uri')
def step_impl(context: Context):
    # Simulate redirect to FI's authorization endpoint
    context.auth.redirect_url = (
        f"{context.auth.fi_auth_endpoint}"
        f"?request_uri={context.auth.request_uri}"
        f"&state={context.auth.state}"
    )

@then('the FI should display their login page')
def step_impl(context: Context):
    # Mock verification that login page is displayed
    assert context.auth.redirect_url.startswith(context.auth.fi_auth_endpoint)

@when('the customer enters valid credentials')
def step_impl(context: Context):
    # Simulate customer login
    context.auth.customer_authenticated = True

@then('the FI should authenticate the customer')
def step_impl(context: Context):
    assert context.auth.customer_authenticated

@then('display the consent page with requested permissions')
def step_impl(context: Context):
    # Verify consent page display
    scopes = context.auth.auth_request['scope'].split()
    context.auth.requested_permissions = scopes

@when('the customer grants consent for the requested permissions')
def step_impl(context: Context):
    # Simulate consent grant
    context.auth.consent_granted = True
    context.auth.auth_code = "sample_auth_code_123"

@then('the FI should redirect to the PERA Admin\'s callback URL')
def step_impl(context: Context):
    callback_url = context.auth.auth_request['redirect_uri']
    assert callback_url.startswith("https://peraadmin.com/callback")

@then('the redirect should include an authorization code')
def step_impl(context: Context):
    assert context.auth.auth_code is not None

@when('the PERA Admin exchanges the authorization code for tokens')
def step_impl(context: Context):
    # Simulate token exchange
    url = context.auth.base_url + "/oauth/token"
    data = {
        "grant_type": "authorization_code",
        "code": context.auth.auth_code,
        "redirect_uri": context.auth.auth_request['redirect_uri']
    }
    headers = {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Authorization': f'Basic {context.auth.pera_admin_client_id}:{context.auth.pera_admin_client_secret}'
    }
    response = requests.post(url, data=data, headers=headers)
    context.auth.token_response = response

@then('the response should contain an error message "{error}"')
def step_impl(context: Context, error: str):
    response_data = context.auth.response.json()
    assert 'error' in response_data
    assert response_data['error'] == error

@given('the PERA Admin has invalid client credentials')
def step_impl(context: Context):
    context.auth.pera_admin_client_secret = "invalid_secret"

@given('the PERA Admin initiates a valid authorization request')
def step_impl(context: Context):
    context.auth.auth_request = {
        "response_type": "code",
        "client_id": context.auth.pera_admin_client_id,
        "redirect_uri": "https://peraadmin.com/callback",
        "scope": "openid profile accounts.basic accounts.details",
        "state": "abc123xyz"
    }

@when('the customer denies consent for the requested permissions')
def step_impl(context: Context):
    context.auth.consent_granted = False

@then('the redirect should include an error "{error}"')
def step_impl(context: Context, error: str):
    redirect_url = context.auth.redirect_url
    parsed_url = urlparse(redirect_url)
    query_params = parse_qs(parsed_url.query)
    assert 'error' in query_params
    assert query_params['error'][0] == error

@given('the PERA Admin initiates authorization with invalid scope')
def step_impl(context: Context):
    context.auth.auth_request = {row['Parameter']: row['Value'] for row in context.table}

@when('the session expires after inactivity')
def step_impl(context: Context):
    context.auth.session_expired = True

@given('the PERA Admin initiates a request requiring step-up authentication')
def step_impl(context: Context):
    context.auth.requires_step_up = True
    context.auth.auth_request = {
        "response_type": "code",
        "client_id": context.auth.pera_admin_client_id,
        "redirect_uri": "https://peraadmin.com/callback",
        "scope": "openid profile accounts.basic accounts.details",
        "state": "abc123xyz",
        "acr_values": "urn:openbanking:psd2:sca"
    }

@when('the FI requests additional authentication factors')
def step_impl(context: Context):
    context.auth.step_up_requested = True

@then('the FI should proceed to the consent page')
def step_impl(context: Context):
    assert context.auth.step_up_completed
    assert context.auth.ready_for_consent
