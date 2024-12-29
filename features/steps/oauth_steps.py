from behave import given, when, then
import requests
from urllib.parse import urlparse, parse_qs

@given('I have valid authorization parameters')
def step_impl(context):
    context.auth_params = {}
    for row in context.table:
        context.auth_params[row['parameter']] = row['value']

@given('I have a valid authorization code')
def step_impl(context):
    # First get an auth code
    context.execute_steps('''
        Given I have valid authorization parameters
            | parameter        | value                                |
            | client_id        | test-client-123                      |
            | response_type    | code                                 |
            | scope            | openid profile                       |
            | redirect_uri     | https://test-client.com/callback     |
            | code_challenge   | test-challenge                       |
            | code_challenge_method | S256                            |
            | state           | test-state-123                        |
        When I send a GET request to "/oauth/auth"
    ''')
    location = context.response.headers['Location']
    query = parse_qs(urlparse(location).query)
    context.authorization_code = query['code'][0]

@when('I send a POST request to "{endpoint}" with form data')
def step_impl(context, endpoint):
    base_url = context.config.userdata.get('base_url', 'https://api.ofxpera.ph/v1')
    url = f"{base_url}{endpoint}"
    
    form_data = {}
    for row in context.table:
        value = row['value']
        if value.startswith('{') and value.endswith('}'):
            # Replace placeholder with actual value
            key = value[1:-1]  # Remove braces
            value = getattr(context, key)
        form_data[row['field']] = value
        
    context.response = requests.post(
        url=url,
        headers=context.headers,
        data=form_data
    )

@when('I send a GET request to "{endpoint}"')
def step_impl(context, endpoint):
    base_url = context.config.userdata.get('base_url', 'https://api.ofxpera.ph/v1')
    url = f"{base_url}{endpoint}"
    params = context.auth_params if hasattr(context, 'auth_params') else None
    context.response = requests.get(url=url, headers=context.headers, params=params)

@when('I send a GET request to "{endpoint}" with parameters')
def step_impl(context, endpoint):
    base_url = context.config.userdata.get('base_url', 'https://api.ofxpera.ph/v1')
    url = f"{base_url}{endpoint}"
    
    params = {}
    for row in context.table:
        value = row['value']
        if value.startswith('{') and value.endswith('}'):
            key = value[1:-1]
            value = getattr(context, key)
        params[row['parameter']] = value
        
    context.response = requests.get(
        url=url,
        headers=context.headers,
        params=params
    )

@then('the response should contain a Location header')
def step_impl(context):
    assert 'Location' in context.response.headers

@then('the Location header should contain an authorization code')
def step_impl(context):
    location = context.response.headers['Location']
    query = parse_qs(urlparse(location).query)
    assert 'code' in query

@then('the Location header should contain the original state')
def step_impl(context):
    location = context.response.headers['Location']
    query = parse_qs(urlparse(location).query)
    assert query['state'][0] == context.auth_params['state']

@then('the response should contain an {field}')
def step_impl(context, field):
    data = context.response.json()
    assert field in data, f"Response does not contain field: {field}"

@given('I have a valid refresh token')
def step_impl(context):
    # First get tokens using auth code
    context.execute_steps('''
        Given I have a valid authorization code
        When I send a POST request to "/oauth/token" with form data
            | field          | value                                |
            | grant_type     | authorization_code                   |
            | code           | {authorization_code}                 |
            | redirect_uri   | https://test-client.com/callback     |
            | client_id      | test-client-123                      |
    ''')
    context.refresh_token = context.response.json()['refresh_token']

@given('I have a valid access token')
def step_impl(context):
    # Get access token using auth code
    context.execute_steps('''
        Given I have a valid authorization code
        When I send a POST request to "/oauth/token" with form data
            | field          | value                                |
            | grant_type     | authorization_code                   |
            | code           | {authorization_code}                 |
            | redirect_uri   | https://test-client.com/callback     |
            | client_id      | test-client-123                      |
    ''')
    context.access_token = context.response.json()['access_token']
    context.headers['Authorization'] = f"Bearer {context.access_token}"

@then('the response should contain user details')
def step_impl(context):
    data = context.response.json()
    required_fields = [row['field'] for row in context.table]
    for field in required_fields:
        assert field in data, f"Response does not contain field: {field}"

@then('the response should contain token information')
def step_impl(context):
    data = context.response.json()
    required_fields = [row['field'] for row in context.table]
    for field in required_fields:
        assert field in data, f"Response does not contain field: {field}" 