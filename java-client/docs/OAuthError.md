# OAuthError

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**error** | [**ErrorEnum**](#ErrorEnum) | Error code as defined in RFC 6749 | 
**errorDescription** | **String** | Human-readable error description |  [optional]
**errorUri** | **String** | URI to error documentation |  [optional]

<a name="ErrorEnum"></a>
## Enum: ErrorEnum
Name | Value
---- | -----
INVALID_REQUEST | &quot;invalid_request&quot;
INVALID_CLIENT | &quot;invalid_client&quot;
INVALID_GRANT | &quot;invalid_grant&quot;
UNAUTHORIZED_CLIENT | &quot;unauthorized_client&quot;
UNSUPPORTED_GRANT_TYPE | &quot;unsupported_grant_type&quot;
INVALID_SCOPE | &quot;invalid_scope&quot;
