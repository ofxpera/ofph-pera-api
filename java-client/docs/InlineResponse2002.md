# InlineResponse2002

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**issuer** | **String** | Base URL that uniquely identifies the authorization server | 
**authorizationEndpoint** | **String** | Authorization endpoint URL for initiating the OAuth 2.0 flow | 
**tokenEndpoint** | **String** | Token endpoint URL for obtaining access tokens | 
**userinfoEndpoint** | **String** | UserInfo endpoint URL for retrieving authenticated user information |  [optional]
**jwksUri** | **String** | URL for retrieving the JSON Web Key Set used to validate JWTs | 
**registrationEndpoint** | **String** | Dynamic Client Registration endpoint URL | 
**scopesSupported** | **List&lt;String&gt;** |  |  [optional]
**responseTypesSupported** | **List&lt;String&gt;** |  |  [optional]
**grantTypesSupported** | **List&lt;String&gt;** |  |  [optional]
**subjectTypesSupported** | **List&lt;String&gt;** |  |  [optional]
**idTokenSigningAlgValuesSupported** | **List&lt;String&gt;** |  |  [optional]
**tokenEndpointAuthMethodsSupported** | **List&lt;String&gt;** |  |  [optional]
**claimsSupported** | **List&lt;String&gt;** |  |  [optional]
