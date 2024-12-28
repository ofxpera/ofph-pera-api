from behave import given, when, then
import requests
import json
from uuid import uuid4

@given('I have valid OFxPERA headers')
def step_impl(context):
    context.headers = {}
    for row in context.table:
        context.headers[row['header']] = row['value']
    # Add interaction ID
    context.headers['x-fapi-interaction-id'] = str(uuid4())

@given('I have valid participant configuration data')
def step_impl(context):
    context.participant_config = {
        "participant": {
            "endpoint_uris": {
                "issuer": "https://auth.testperaadmin.ph",
                "authorization_endpoint": "https://auth.testperaadmin.ph/oauth/authorize",
                "token_endpoint": "https://auth.testperaadmin.ph/oauth/token",
                "jwks_uri": "https://auth.testperaadmin.ph/.well-known/jwks.json"
            },
            "internal_uris": {
                "redirect_uris": ["https://testperaadmin.ph/callback"],
                "jwks_uri": "https://testperaadmin.ph/.well-known/jwks.json"
            },
            "jwks": {
                "keys": [{
                    "kty": "RSA",
                    "kid": "test-key-1",
                    "use": "sig",
                    "alg": "RS256",
                    "n": "sample-modulus",
                    "e": "AQAB"
                }]
            }
        }
    }
    
    for row in context.table:
        if row['field'] in ['participant_type']:
            context.participant_config['participant'][row['field']] = [row['value']]
        else:
            context.participant_config['participant'][row['field']] = row['value']

@when('I send a {method} request to "{endpoint}"')
def step_impl(context, method, endpoint):
    base_url = context.config.userdata.get('base_url', 'https://api.ofxpera.ph/v1')
    url = f"{base_url}{endpoint}"
    
    if hasattr(context, 'participant_config'):
        data = context.participant_config
    else:
        data = None
        
    context.response = requests.request(
        method=method,
        url=url,
        headers=context.headers,
        json=data
    )

@then('the response status code should be {status_code:d}')
def step_impl(context, status_code):
    assert context.response.status_code == status_code

@then('the response should contain a {field}')
def step_impl(context, field):
    data = context.response.json()
    assert field in data, f"Response does not contain field: {field}"

@given('I have invalid participant configuration data')
def step_impl(context):
    context.participant_config = {
        "participant": {}
    }
    for row in context.table:
        context.participant_config['participant'][row['field']] = row['value']

@then('the response should contain error details')
def step_impl(context):
    data = context.response.json()
    assert 'error' in data

@given('I have a registered participant')
def step_impl(context):
    # First register a participant
    context.execute_steps('''
        Given I have valid participant configuration data
            | field            | value           |
            | participant_name | Test PERA Admin |
            | participant_type | PERA_ADMIN      |
        When I send a POST request to "/ofxpera/participants"
        Then the response status code should be 201
    ''')
    context.registered_participant = context.response.json()

@given('I am missing the "{header}" header')
def step_impl(context, header):
    if header in context.headers:
        del context.headers[header]

@then('the response should contain a list of participants')
def step_impl(context):
    data = context.response.json()
    assert isinstance(data, list)

@then('each participant should have required fields')
def step_impl(context):
    data = context.response.json()
    required_fields = [row['field'] for row in context.table]
    
    for participant in data:
        for field in required_fields:
            assert field in participant, f"Participant missing required field: {field}" 

@given('I have a valid registration access token')
def step_impl(context):
    token = context.registered_participant['registration_access_token']
    context.headers['Authorization'] = f"Bearer {token}"
    # Remove participant-key as it's not needed for authenticated requests
    if 'participant-key' in context.headers:
        del context.headers['participant-key']
