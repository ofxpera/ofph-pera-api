# TokenResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accessToken** | **String** | The access token string as issued by the authorization server | 
**tokenType** | [**TokenTypeEnum**](#TokenTypeEnum) | Type of access token, fixed to Bearer | 
**expiresIn** | **Integer** | Lifetime in seconds of the access token | 
**refreshToken** | **String** | Refresh token used to obtain a new access token. |  [optional]
**idToken** | **String** | ID Token value associated with the authenticated session | 
**scope** | **String** | Space-separated list of scopes granted |  [optional]

<a name="TokenTypeEnum"></a>
## Enum: TokenTypeEnum
Name | Value
---- | -----
BEARER | &quot;Bearer&quot;
