# OauthTokenBody

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**grantType** | [**GrantTypeEnum**](#GrantTypeEnum) |  | 
**code** | **String** | Authorization code received from the authorization server. | 
**redirectUri** | **String** | Redirect URI used in the authorization request. | 
**clientId** | **String** | Client identifier for the token request. | 
**refreshToken** | **String** | Refresh token used to obtain a new access token. |  [optional]

<a name="GrantTypeEnum"></a>
## Enum: GrantTypeEnum
Name | Value
---- | -----
AUTHORIZATION_CODE | &quot;authorization_code&quot;
REFRESH_TOKEN | &quot;refresh_token&quot;
