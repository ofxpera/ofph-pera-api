from behave import given, when, then
from datetime import datetime, timedelta
import requests
import json
from typing import Dict, List
import pytest
from urllib.parse import urljoin

# Configuration and utilities
BASE_URL = "https://api.ofxpera.ph/v1"
ADMIN_CREDENTIALS = {
    "client_id": "admin_client",
    "client_secret": "admin_secret"
}

def get_admin_token():
    """Retrieve admin access token for API calls"""
    # Implementation for getting admin token
    pass

def validate_endpoint_health(endpoint: str) -> Dict:
    """Validate endpoint health and return metrics"""
    # Implementation for health check
    pass

# Step Definitions
@given('the Central Hub system is operational')
def step_central_hub_operational(context):
    response = requests.get(urljoin(BASE_URL, "/health"))
    assert response.status_code == 200
    context.base_url = BASE_URL

@given('the administrator has valid authentication credentials')
def step_admin_credentials(context):
    context.admin_token = get_admin_token()
    assert context.admin_token is not None

@given('required security certificates are in place')
def step_security_certificates(context):
    # Verify certificate configuration
    pass

@given('a Financial Institution "{name}" prepares to register their APIs')
def step_fi_prepare_apis(context, name):
    context.institution_name = name
    context.api_endpoints = {
        row['API Type']: {
            'endpoint': row['Endpoint'],
            'version': row['Version'],
            'status': row['Status']
        }
        for row in context.table
    }

@when('the Financial Institution sends a POST request to "{endpoint}"')
def step_fi_register_apis(context, endpoint):
    headers = {
        'Authorization': f'Bearer {context.admin_token}',
        'Content-Type': 'application/json'
    }
    payload = {
        'institution_name': context.institution_name,
        'api_endpoints': context.api_endpoints
    }
    context.response = requests.post(
        urljoin(context.base_url, endpoint),
        headers=headers,
        json=payload
    )

@then('the response status code should be {status_code:d}')
def step_verify_status_code(context, status_code):
    assert context.response.status_code == status_code

@then('the response should contain a unique registry ID')
def step_verify_registry_id(context):
    response_data = context.response.json()
    assert 'registry_id' in response_data
    assert isinstance(response_data['registry_id'], str)
    context.registry_id = response_data['registry_id']

@then('the response should include API validation status')
def step_verify_api_validation(context):
    response_data = context.response.json()
    assert 'validation_status' in response_data
    for endpoint in context.api_endpoints:
        assert endpoint in response_data['validation_status']

@then('the system should initiate endpoint health checks')
def step_verify_health_checks(context):
    # Wait for health checks to complete
    time.sleep(2)
    response = requests.get(
        urljoin(context.base_url, f"/admin/registry/{context.registry_id}/health"),
        headers={'Authorization': f'Bearer {context.admin_token}'}
    )
    assert response.status_code == 200
    health_data = response.json()
    assert all(endpoint in health_data for endpoint in context.api_endpoints)

@given('multiple institutions have registered their APIs')
def step_multiple_institutions_registered(context):
    # Setup test data for multiple institutions
    pass

@when('an administrator sends a GET request to "{endpoint}"')
def step_admin_get_request(context, endpoint):
    headers = {'Authorization': f'Bearer {context.admin_token}'}
    context.response = requests.get(
        urljoin(context.base_url, endpoint),
        headers=headers
    )

@then('the response should contain a list of all registered APIs')
def step_verify_api_list(context):
    response_data = context.response.json()
    assert 'apis' in response_data
    apis = response_data['apis']
    
    # Verify each row in the table matches the response
    for row in context.table:
        matching_api = next(
            (api for api in apis if api['institution'] == row['Institution']
             and api['type'] == row['API Type']),
            None
        )
        assert matching_api is not None
        assert matching_api['status'] == row['Status']

@when('the compliance service performs a security audit')
def step_perform_security_audit(context):
    headers = {'Authorization': f'Bearer {context.admin_token}'}
    context.response = requests.post(
        urljoin(context.base_url, f"/admin/registry/{context.registry_id}/audit"),
        headers=headers
    )

@then('it should verify')
def step_verify_security_requirements(context):
    response_data = context.response.json()
    assert 'security_audit' in response_data
    audit_results = response_data['security_audit']
    
    for row in context.table:
        requirement = row['Security Requirement']
        expected_status = row['Status']
        assert audit_results[requirement.lower().replace(' ', '_')] == expected_status

@when('they upload API documentation to "{endpoint}"')
def step_upload_api_documentation(context, endpoint):
    headers = {
        'Authorization': f'Bearer {context.admin_token}',
        'Content-Type': 'application/json'
    }
    with open('openapi.yaml', 'rb') as f:
        files = {'file': ('openapi.yaml', f, 'application/x-yaml')}
        context.response = requests.post(
            urljoin(context.base_url, endpoint),
            headers=headers,
            files=files
        )

@when('an administrator requests usage metrics')
def step_request_usage_metrics(context):
    headers = {'Authorization': f'Bearer {context.admin_token}'}
    params = {
        'period': '24h',
        'metrics': ['requests', 'response_time', 'error_rate', 'consumers', 'bandwidth']
    }
    context.response = requests.get(
        urljoin(context.base_url, "/admin/registry/metrics"),
        headers=headers,
        params=params
    )

@given('a security incident is reported for institution "{name}"')
def step_security_incident_reported(context, name):
    context.incident_institution = name
    context.incident_time = datetime.utcnow()

@when('the administrator initiates emergency shutdown')
def step_initiate_emergency_shutdown(context):
    headers = {
        'Authorization': f'Bearer {context.admin_token}',
        'Content-Type': 'application/json'
    }
    payload = {
        'institution': context.incident_institution,
        'reason': 'Security Incident',
        'incident_time': context.incident_time.isoformat()
    }
    context.response = requests.post(
        urljoin(context.base_url, "/admin/registry/emergency-shutdown"),
        headers=headers,
        json=payload
    )

@then('the system should')
def step_verify_emergency_actions(context):
    response_data = context.response.json()
    assert 'emergency_actions' in response_data
    actions = response_data['emergency_actions']
    
    for row in context.table:
        action = row['Action']
        timeline = row['Timeline']
        matching_action = next(
            (a for a in actions if a['name'] == action),
            None
        )
        assert matching_action is not None
        assert matching_action['timeline'] == timeline
