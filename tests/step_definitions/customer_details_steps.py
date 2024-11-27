from behave import given, when, then
from behave.runner import Context
import requests
import json
from datetime import datetime
from typing import Dict, List

class CustomerDetailsContext:
    def __init__(self):
        self.base_url = "https://api.ofxpera.ph/v1"
        self.access_token = None
        self.mtls_cert = None
        self.mtls_key = None
        self.response = None
        self.test_data = {}

@given('a valid access token with "customer_details" scope')
def step_impl(context: Context):
    context.customer = CustomerDetailsContext()
    context.customer.access_token = "valid_access_token_with_customer_details_scope"

@given('a valid mTLS certificate for secure communication')
def step_impl(context: Context):
    context.customer.mtls_cert = "test_certificate"
    context.customer.mtls_key = "test_private_key"

@given('customer consent has been granted')
def step_impl(context: Context):
    context.customer.test_data['consent_granted'] = True

@given('a customer with ID "{customer_id}" exists in the system')
def step_impl(context: Context, customer_id: str):
    context.customer.test_data['current_customer_id'] = customer_id
    # Setup mock customer data
    context.customer.test_data['customer'] = {
        'customerId': customer_id,
        'firstName': 'Juan',
        'lastName': 'Dela Cruz',
        'dateOfBirth': '1990-01-15',
        'nationality': 'Filipino',
        'residencyStatus': 'Resident',
        'taxStatus': 'Regular',
        'employmentStatus': 'Employed',
        'occupation': 'Software Engineer',
        'tin': '123-456-789-000'
    }

@when('a GET request is sent to "{endpoint}"')
def step_impl(context: Context, endpoint: str):
    url = context.customer.base_url + endpoint
    headers = {
        'Authorization': f'Bearer {context.customer.access_token}',
        'Content-Type': 'application/json'
    }
    response = requests.get(
        url,
        headers=headers,
        cert=(context.customer.mtls_cert, context.customer.mtls_key)
    )
    context.customer.response = response

@then('the response should contain complete customer information')
def step_impl(context: Context):
    response_data = context.customer.response.json()
    expected_data = {row['Field']: row['Value'] for row in context.table}
    
    for field, expected_value in expected_data.items():
        assert field in response_data
        assert response_data[field] == expected_value

@given('a customer with ID "{customer_id}" has multiple PERA accounts')
def step_impl(context: Context, customer_id: str):
    context.customer.test_data['current_customer_id'] = customer_id
    context.customer.test_data['pera_accounts'] = [
        {
            'accountNumber': 'PERA-001',
            'institution': 'Sample Bank',
            'status': 'Active',
            'balance': 100000,
            'openingDate': '2023-01-15'
        },
        {
            'accountNumber': 'PERA-002',
            'institution': 'Another Bank',
            'status': 'Active',
            'balance': 250000,
            'openingDate': '2023-06-30'
        }
    ]

@then('the response should include a list of PERA accounts')
def step_impl(context: Context):
    response_data = context.customer.response.json()
    assert 'peraAccounts' in response_data
    accounts = response_data['peraAccounts']
    
    # Convert table to list of dictionaries for comparison
    expected_accounts = []
    for row in context.table:
        account = dict(row)
        # Convert string amount to number
        account['Balance'] = float(account['Balance'])
        expected_accounts.append(account)
    
    assert len(accounts) == len(expected_accounts)
    for actual, expected in zip(accounts, expected_accounts):
        assert actual['accountNumber'] == expected['Account Number']
        assert actual['institution'] == expected['Institution']
        assert actual['status'] == expected['Status']
        assert actual['balance'] == expected['Balance']
        assert actual['openingDate'] == expected['Opening Date']

@given('a customer with ID "{customer_id}" exists')
def step_impl(context: Context, customer_id: str):
    context.customer.test_data['current_customer_id'] = customer_id
    context.customer.test_data['contact_info'] = {
        'emailAddress': 'juan.cruz@email.com',
        'mobileNumber': '+63-912-345-6789',
        'address': '123 Sample St, Manila',
        'postalCode': '1234',
        'country': 'Philippines'
    }

@then('the response should contain contact details')
def step_impl(context: Context):
    response_data = context.customer.response.json()
    assert 'contactDetails' in response_data
    contact_details = response_data['contactDetails']
    
    expected_details = {row['Field']: row['Value'] for row in context.table}
    for field, expected_value in expected_details.items():
        assert field in contact_details
        assert contact_details[field] == expected_value

@given('a customer with ID "{customer_id}" has investment profile')
def step_impl(context: Context, customer_id: str):
    context.customer.test_data['current_customer_id'] = customer_id
    context.customer.test_data['investment_profile'] = {
        'riskTolerance': 'Moderate',
        'investmentHorizon': 'Long Term',
        'investmentObjective': 'Retirement',
        'sourceOfFunds': 'Employment',
        'monthlyIncome': '50000-100000'
    }

@then('the response should contain investment profile')
def step_impl(context: Context):
    response_data = context.customer.response.json()
    assert 'investmentProfile' in response_data
    profile = response_data['investmentProfile']
    
    expected_profile = {row['Field']: row['Value'] for row in context.table}
    for field, expected_value in expected_profile.items():
        assert field in profile
        assert profile[field] == expected_value

@given('a customer with ID "{customer_id}" has registered beneficiaries')
def step_impl(context: Context, customer_id: str):
    context.customer.test_data['current_customer_id'] = customer_id
    context.customer.test_data['beneficiaries'] = [
        {
            'name': 'Maria Cruz',
            'relationship': 'Spouse',
            'share': '60%',
            'contactNumber': '+63912345678'
        },
        {
            'name': 'Juan Cruz Jr',
            'relationship': 'Child',
            'share': '40%',
            'contactNumber': '+63923456789'
        }
    ]

@then('the response should contain beneficiary information')
def step_impl(context: Context):
    response_data = context.customer.response.json()
    assert 'beneficiaries' in response_data
    beneficiaries = response_data['beneficiaries']
    
    expected_beneficiaries = []
    for row in context.table:
        beneficiary = dict(row)
        expected_beneficiaries.append(beneficiary)
    
    assert len(beneficiaries) == len(expected_beneficiaries)
    for actual, expected in zip(beneficiaries, expected_beneficiaries):
        assert actual['name'] == expected['Name']
        assert actual['relationship'] == expected['Relationship']
        assert actual['share'] == expected['Share']
        assert actual['contactNumber'] == expected['Contact Number']

@given('a customer with ID "{customer_id}" does not exist')
def step_impl(context: Context, customer_id: str):
    context.customer.test_data['current_customer_id'] = customer_id
    context.customer.test_data['exists'] = False

@then('the response should contain error details')
def step_impl(context: Context):
    response_data = context.customer.response.json()
    expected_error = {row['Field']: row['Value'] for row in context.table}
    
    assert 'code' in response_data
    assert 'message' in response_data
    assert response_data['code'] == expected_error['code']
    assert response_data['message'] == expected_error['message']

@given('an access token without "customer_details" scope')
def step_impl(context: Context):
    context.customer.access_token = "token_without_customer_details_scope"

@given('customer consent has been revoked for ID "{customer_id}"')
def step_impl(context: Context, customer_id: str):
    context.customer.test_data['current_customer_id'] = customer_id
    context.customer.test_data['consent_granted'] = False

@then('the response should only contain requested fields')
def step_impl(context: Context):
    response_data = context.customer.response.json()
    expected_fields = {}
    for row in context.table:
        category = row['Category']
        fields = row['Fields'].split(',')
        expected_fields[category] = fields
    
    # Verify only requested categories are present
    for category in expected_fields:
        assert category in response_data
        
        # Verify only requested fields in each category are present
        category_data = response_data[category]
        actual_fields = set(category_data.keys())
        expected_field_set = set(expected_fields[category])
        assert actual_fields == expected_field_set
