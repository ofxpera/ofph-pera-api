# OauthAuthBody

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**participantId** | **String** | Participant identifier of the FI issued during registration | 
**endorsementDetails** | [**EndorsementDetails**](EndorsementDetails.md) |  |  [optional]
**authorizationCode** | **String** | Authorization code |  [optional]
**responseType** | [**ResponseTypeEnum**](#ResponseTypeEnum) | Must be set to \&quot;code\&quot; for authorization code flow | 
**scope** | [**List&lt;ScopeEnum&gt;**](#List&lt;ScopeEnum&gt;) | Space-separated list of requested scope values, OFxPERA requires openid to be included to maintain compatibility with OIDC. |  [optional]
**tokenEndpoint** | **String** | URI of the token endpoint for retrieving access tokens |  [optional]
**codeChallenge** | **String** | Code challenge for PKCE |  [optional]
**codeChallengeMethod** | [**CodeChallengeMethodEnum**](#CodeChallengeMethodEnum) | Code challenge method for PKCE |  [optional]
**state** | **String** | Opaque value to maintain state between request and callback |  [optional]
**prompt** | **String** | Prompt for the authorization request |  [optional]
**nonce** | **String** | Random value used to prevent replay attacks |  [optional]

<a name="ResponseTypeEnum"></a>
## Enum: ResponseTypeEnum
Name | Value
---- | -----
CODE | &quot;code&quot;

<a name="List<ScopeEnum>"></a>
## Enum: List&lt;ScopeEnum&gt;
Name | Value
---- | -----
OPENID | &quot;openid&quot;
PROFILE | &quot;profile&quot;
EMAIL | &quot;email&quot;
ADDRESS | &quot;address&quot;
PHONE | &quot;phone&quot;

<a name="CodeChallengeMethodEnum"></a>
## Enum: CodeChallengeMethodEnum
Name | Value
---- | -----
S256 | &quot;S256&quot;
