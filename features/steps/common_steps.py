from behave import given, when, then

@given('I have a valid customer ID "{customer_id}"')
def step_impl(context, customer_id):
    context.customer_id = customer_id

@then('the response should contain customer information')
def step_impl(context):
    data = context.response.json()
    required_fields = [row['field'] for row in context.table]
    for field in required_fields:
        assert field in data, f"Response does not contain field: {field}"

@then('the response should contain personal information')
def step_impl(context):
    data = context.response.json()
    pii = data['pii']
    required_fields = [row['field'] for row in context.table]
    for field in required_fields:
        assert field in pii, f"Personal information does not contain field: {field}"
        assert pii[field] is not None, f"Field {field} is null"

@then('the response should contain customer due diligence')
def step_impl(context):
    data = context.response.json()
    cdd = data['cdd']
    required_fields = [row['field'] for row in context.table]
    for field in required_fields:
        assert field in cdd, f"CDD information does not contain field: {field}"
        assert cdd[field] is not None, f"Field {field} is null"

@then('the response should contain presented IDs')
def step_impl(context):
    data = context.response.json()
    ids = data['presentedIds']
    assert isinstance(ids, list), "presentedIds should be an array"
    assert len(ids) > 0, "presentedIds array is empty"
    
    required_fields = [row['field'] for row in context.table]
    for id_doc in ids:
        for field in required_fields:
            assert field in id_doc, f"ID document does not contain field: {field}"
            assert id_doc[field] is not None, f"Field {field} is null" 