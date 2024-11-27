from behave import given, when, then
from behave.runner import Context
import requests
import json
from datetime import datetime, timedelta
import OpenSSL.crypto as crypto
from base64 import b64decode
import os

class BootstrappingContext:
    def __init__(self):
        self.base_url = "https://api.ofxpera.ph/v1"
        self.registration_token = None
        self.mtls_cert = None
        self.mtls_key = None
        self.participant_id = None
        self.test_data = {}

@given('the Financial Institution has valid registration credentials')
def step_impl(context: Context):
    context.bootstrap = BootstrappingContext()
    context.bootstrap.registration_token = "test_registration_token"

@given('the Financial Institution has a valid mTLS certificate')
def step_impl(context: Context):
    # In a real implementation, this would load actual certificates
    context.bootstrap.mtls_cert = "test_certificate"
    context.bootstrap.mtls_key = "test_private_key"

@given('the Financial Institution has their API endpoints ready')
def step_impl(context: Context):
    context.bootstrap.endpoints = {
        "authorizationEndpoint": "https://auth.samplebank.com/authorize",
        "tokenEndpoint": "https://auth.samplebank.com/token",
        "resourceEndpoint": "https://api.samplebank.com"
    }

@given('the Financial Institution prepares registration details')
def step_impl(context: Context):
    context.bootstrap.registration_details = {
        row['Field']: row['Value'] for row in context.table
    }
    # Parse JSON strings in the data
    for key in ['contactDetails', 'endpointURIs']:
        if key in context.bootstrap.registration_details:
            context.bootstrap.registration_details[key] = json.loads(
                context.bootstrap.registration_details[key]
            )

@when('the Financial Institution sends a POST request to "{endpoint}"')
def step_impl(context: Context, endpoint: str):
    url = context.bootstrap.base_url + endpoint
    headers = {
        'Content-Type': 'application/json',
        'Authorization': f'Bearer {context.bootstrap.registration_token}'
    }
    response = requests.post(
        url,
        json=context.bootstrap.registration_details,
        headers=headers,
        cert=(context.bootstrap.mtls_cert, context.bootstrap.mtls_key)
    )
    context.bootstrap.response = response

@then('the response should contain the registered organization details')
def step_impl(context: Context):
    response_data = context.bootstrap.response.json()
    assert 'organizationId' in response_data
    assert 'organizationName' in response_data
    assert 'endpointURIs' in response_data
    context.bootstrap.participant_id = response_data['organizationId']

@then('the response should include a unique participant-id header')
def step_impl(context: Context):
    assert 'participant-id' in context.bootstrap.response.headers
    participant_id = context.bootstrap.response.headers['participant-id']
    assert participant_id is not None and participant_id != ''

@given('there are multiple organizations registered in the system')
def step_impl(context: Context):
    # Setup test data with multiple organizations
    context.bootstrap.test_data['organizations'] = [
        {
            'organizationId': 'bank_123',
            'organizationName': 'Sample Bank',
            'organizationType': 'CONTRIBUTOR_INSTITUTION'
        },
        {
            'organizationId': 'bank_456',
            'organizationName': 'Another Bank',
            'organizationType': 'CONTRIBUTOR_INSTITUTION'
        }
    ]

@when('a GET request is sent to "{endpoint}"')
def step_impl(context: Context, endpoint: str):
    url = context.bootstrap.base_url + endpoint
    headers = {
        'Authorization': f'Bearer {context.bootstrap.registration_token}'
    }
    response = requests.get(
        url,
        headers=headers,
        cert=(context.bootstrap.mtls_cert, context.bootstrap.mtls_key)
    )
    context.bootstrap.response = response

@then('the response should contain a list of registered organizations')
def step_impl(context: Context):
    response_data = context.bootstrap.response.json()
    assert isinstance(response_data, list)
    assert len(response_data) > 0

@then('each organization should have valid endpoint URIs')
def step_impl(context: Context):
    response_data = context.bootstrap.response.json()
    for org in response_data:
        assert 'endpointURIs' in org
        uris = org['endpointURIs']
        assert 'authorizationEndpoint' in uris
        assert 'tokenEndpoint' in uris
        assert 'resourceEndpoint' in uris
        # Validate URI format
        for endpoint in uris.values():
            assert endpoint.startswith('https://')

@then('each organization should have a valid participant-id')
def step_impl(context: Context):
    response_data = context.bootstrap.response.json()
    for org in response_data:
        assert 'organizationId' in org
        assert org['organizationId'] is not None and org['organizationId'] != ''

@given('a Financial Institution is registered with ID "{org_id}"')
def step_impl(context: Context, org_id: str):
    context.bootstrap.test_data['current_org_id'] = org_id

@then('the response should contain a valid X.509 certificate')
def step_impl(context: Context):
    response_data = context.bootstrap.response.json()
    assert 'certificate' in response_data
    cert_data = response_data['certificate']
    # Validate certificate format
    try:
        cert = crypto.load_certificate(
            crypto.FILETYPE_PEM,
            cert_data.encode('utf-8')
        )
        assert cert is not None
    except Exception as e:
        assert False, f"Invalid certificate format: {str(e)}"

@then('the certificate should be in PEM format')
def step_impl(context: Context):
    response_data = context.bootstrap.response.json()
    cert_data = response_data['certificate']
    assert cert_data.startswith('-----BEGIN CERTIFICATE-----')
    assert cert_data.endswith('-----END CERTIFICATE-----\n')

@then('the certificate details should include')
def step_impl(context: Context):
    response_data = context.bootstrap.response.json()
    for row in context.table:
        field = row['Field']
        expected_value = row['Value']
        
        if field == 'validFrom':
            assert datetime.fromisoformat(response_data['validFrom']).date() == datetime.now().date()
        elif field == 'validUntil':
            assert datetime.fromisoformat(response_data['validUntil']).date() == (datetime.now() + timedelta(days=365)).date()
        elif field == 'subject':
            assert response_data['subject'] == expected_value

@given('the Financial Institution prepares incomplete registration details')
def step_impl(context: Context):
    context.bootstrap.registration_details = {
        row['Field']: row['Value'] for row in context.table
    }

@then('the response should contain validation errors for missing fields')
def step_impl(context: Context):
    response_data = context.bootstrap.response.json()
    assert 'errors' in response_data
    errors = response_data['errors']
    assert len(errors) > 0
    # Verify that each error has a field and message
    for error in errors:
        assert 'field' in error
        assert 'message' in error

@given('an organization with ID "{org_id}" already exists')
def step_impl(context: Context, org_id: str):
    context.bootstrap.test_data['existing_org_id'] = org_id

@when('the Financial Institution attempts to register with the same ID')
def step_impl(context: Context):
    context.bootstrap.registration_details = {
        row['Field']: row['Value'] for row in context.table
    }
    url = context.bootstrap.base_url + "/admin/organization"
    headers = {
        'Content-Type': 'application/json',
        'Authorization': f'Bearer {context.bootstrap.registration_token}'
    }
    response = requests.post(
        url,
        json=context.bootstrap.registration_details,
        headers=headers,
        cert=(context.bootstrap.mtls_cert, context.bootstrap.mtls_key)
    )
    context.bootstrap.response = response

@then('the response should indicate a duplicate organization ID')
def step_impl(context: Context):
    response_data = context.bootstrap.response.json()
    assert 'errors' in response_data
    errors = response_data['errors']
    assert any(error['code'] == 'DUPLICATE_ORGANIZATION_ID' for error in errors)

@when('the Financial Institution updates their endpoints')
def step_impl(context: Context):
    endpoint_updates = json.loads(context.table[0]['Value'])
    url = f"{context.bootstrap.base_url}/admin/organization/{context.bootstrap.test_data['current_org_id']}"
    headers = {
        'Content-Type': 'application/json',
        'Authorization': f'Bearer {context.bootstrap.registration_token}'
    }
    response = requests.put(
        url,
        json={'endpointURIs': endpoint_updates},
        headers=headers,
        cert=(context.bootstrap.mtls_cert, context.bootstrap.mtls_key)
    )
    context.bootstrap.response = response

@given('an unregistered organization ID "{org_id}"')
def step_impl(context: Context, org_id: str):
    context.bootstrap.test_data['invalid_org_id'] = org_id

@then('the response should indicate organization not found')
def step_impl(context: Context):
    response_data = context.bootstrap.response.json()
    assert 'errors' in response_data
    errors = response_data['errors']
    assert any(error['code'] == 'ORGANIZATION_NOT_FOUND' for error in errors)

@given('a Financial Institution\'s certificate is near expiry')
def step_impl(context: Context):
    context.bootstrap.test_data['cert_near_expiry'] = True

@when('the Financial Institution requests a new certificate')
def step_impl(context: Context):
    url = f"{context.bootstrap.base_url}/admin/organization/{context.bootstrap.test_data['current_org_id']}/certificate"
    headers = {
        'Authorization': f'Bearer {context.bootstrap.registration_token}',
        'X-Certificate-Renewal': 'true'
    }
    response = requests.post(
        url,
        headers=headers,
        cert=(context.bootstrap.mtls_cert, context.bootstrap.mtls_key)
    )
    context.bootstrap.response = response

@then('the new certificate should have a future expiry date')
def step_impl(context: Context):
    response_data = context.bootstrap.response.json()
    expiry_date = datetime.fromisoformat(response_data['validUntil'])
    assert expiry_date > datetime.now() + timedelta(days=364)

@then('the old certificate should still be valid until expiry')
def step_impl(context: Context):
    # Verify old certificate is still accepted
    url = f"{context.bootstrap.base_url}/admin/organization"
    headers = {
        'Authorization': f'Bearer {context.bootstrap.registration_token}'
    }
    response = requests.get(
        url,
        headers=headers,
        cert=(context.bootstrap.mtls_cert, context.bootstrap.mtls_key)
    )
    assert response.status_code == 200
