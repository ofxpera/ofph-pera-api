# ClientRegistration

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**applicationType** | [**ApplicationTypeEnum**](#ApplicationTypeEnum) | Type of application | 
**clientId** | **String** | Client identifier |  [optional]
**clientName** | **String** | Name of the client | 
**redirectUris** | **List&lt;String&gt;** | Array of redirect URIs for use in OAuth flows | 
**tokenEndpointAuthMethod** | [**TokenEndpointAuthMethodEnum**](#TokenEndpointAuthMethodEnum) | Authentication method for token endpoint, OFxPERA Phase 1 requires private_key_jwt | 
**grantTypes** | [**List&lt;GrantTypesEnum&gt;**](#List&lt;GrantTypesEnum&gt;) |  | 
**responseTypes** | [**List&lt;ResponseTypesEnum&gt;**](#List&lt;ResponseTypesEnum&gt;) | Allowed OAuth response types, OFxPERA requires code and id_token. | 
**scope** | **String** | Space-separated list of requested scopes (e.g. openid profile email address phone) |  [optional]
**softwareStatement** | **String** | JWT containing software statement from trusted authority |  [optional]
**jwks** | [**JWKSet**](JWKSet.md) |  |  [optional]
**jwksUri** | **String** | URI for JSON Web Key Set containing public keys |  [optional]
**organizationName** | **String** | Legal name of the PERA Participant organization |  [optional]
**contacts** | **List&lt;String&gt;** | Administrative contact emails |  [optional]

<a name="ApplicationTypeEnum"></a>
## Enum: ApplicationTypeEnum
Name | Value
---- | -----
WEB | &quot;web&quot;
NATIVE | &quot;native&quot;
HYBRID | &quot;hybrid&quot;

<a name="TokenEndpointAuthMethodEnum"></a>
## Enum: TokenEndpointAuthMethodEnum
Name | Value
---- | -----
PRIVATE_KEY_JWT | &quot;private_key_jwt&quot;

<a name="List<GrantTypesEnum>"></a>
## Enum: List&lt;GrantTypesEnum&gt;
Name | Value
---- | -----
AUTHORIZATION_CODE | &quot;authorization_code&quot;
REFRESH_TOKEN | &quot;refresh_token&quot;

<a name="List<ResponseTypesEnum>"></a>
## Enum: List&lt;ResponseTypesEnum&gt;
Name | Value
---- | -----
CODE | &quot;code&quot;
ID_TOKEN | &quot;id_token&quot;
