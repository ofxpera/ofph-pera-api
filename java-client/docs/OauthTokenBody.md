# OauthTokenBody

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**grantType** | [**GrantTypeEnum**](#GrantTypeEnum) |  | 
**code** | **String** | Authorization code received from the authorization server. | 
**redirectUri** | **String** | Redirect URI used in the authorization request. | 
**clientId** | **String** | Client identifier for the token request. | 
**refreshToken** | **String** | Refresh token used to obtain a new access token. |  [optional]
**clientAssertionType** | [**ClientAssertionTypeEnum**](#ClientAssertionTypeEnum) | value must be \&quot;urn:ietf:params:oauth:assertion-type:jwt-bearer\&quot; | 
**clientAssertion** | **String** | JWT assertion containing client credentials. | 

<a name="GrantTypeEnum"></a>
## Enum: GrantTypeEnum
Name | Value
---- | -----
AUTHORIZATION_CODE | &quot;authorization_code&quot;
REFRESH_TOKEN | &quot;refresh_token&quot;

<a name="ClientAssertionTypeEnum"></a>
## Enum: ClientAssertionTypeEnum
Name | Value
---- | -----
URN_IETF_PARAMS_OAUTH_ASSERTION_TYPE_JWT_BEARER | &quot;urn:ietf:params:oauth:assertion-type:jwt-bearer&quot;
