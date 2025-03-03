# InlineResponse2001

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accessToken** | **String** | Access token for the authenticated user | 
**tokenType** | [**TokenTypeEnum**](#TokenTypeEnum) | Type of the token, always \&quot;Bearer\&quot; | 
**expiresIn** | **Integer** | Lifetime in seconds of the access token | 
**idToken** | **String** | ID Token value associated with the authenticated session |  [optional]
**refreshToken** | **String** | Refresh token used to obtain new access tokens |  [optional]
**scope** | **String** | Space-separated list of scopes associated with the access token |  [optional]

<a name="TokenTypeEnum"></a>
## Enum: TokenTypeEnum
Name | Value
---- | -----
BEARER | &quot;Bearer&quot;
