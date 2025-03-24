# OAuthApi

All URIs are relative to *https://virtserver.swaggerhub.com/voyager-innovation/OFxPERA/0.0.7*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authorizeOAuth**](OAuthApi.md#authorizeOAuth) | **GET** /oauth/auth | [PHASE 1] Authorization endpoint for Admin-initiated onboarding
[**getOAuthToken**](OAuthApi.md#getOAuthToken) | **POST** /oauth/token | [PHASE 1] Token endpoint
[**getUserInfo**](OAuthApi.md#getUserInfo) | **GET** /oauth/userinfo | Optional OpenID Connect UserInfo Endpoint
[**introspectToken**](OAuthApi.md#introspectToken) | **GET** /oauth/introspect | Optional token introspection
[**oAuthPAR**](OAuthApi.md#oAuthPAR) | **POST** /oauth/auth | [PHASE 1] PAR-based Authorization API for FI-initiated onboarding

<a name="authorizeOAuth"></a>
# **authorizeOAuth**
> authorizeOAuth(clientId, responseType, scope, redirectUri, state, xIdempotencyKey, xFapiAuthDate, xFapiCustomerLastLoggedTime, codeChallenge, codeChallengeMethod, prompt, nonce)

[PHASE 1] Authorization endpoint for Admin-initiated onboarding

OpenID Connect authorization endpoint that initiates the authorization flow

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OAuthApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


OAuthApi apiInstance = new OAuthApi();
String clientId = "clientId_example"; // String | Client identifier issued to the client during registration
String responseType = "responseType_example"; // String | Must be set to \"code\" for authorization code flow
List<String> scope = Arrays.asList("scope_example"); // List<String> | Space-separated list of requested scope values, OFxPERA requires openid to be included to maintain compatibility with OIDC.
String redirectUri = "redirectUri_example"; // String | URI to return the user to after authorization is complete
String state = "state_example"; // String | Opaque value to maintain state between request and callback
UUID xIdempotencyKey = new UUID(); // UUID | Unique idempotency key for the request as per FAPI Advanced requirements
OffsetDateTime xFapiAuthDate = new OffsetDateTime(); // OffsetDateTime | The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.
OffsetDateTime xFapiCustomerLastLoggedTime = new OffsetDateTime(); // OffsetDateTime | The time when the PSU last logged in to the client software as per FAPI Advanced requirements
String codeChallenge = "codeChallenge_example"; // String | Code challenge for PKCE
String codeChallengeMethod = "codeChallengeMethod_example"; // String | Code challenge method for PKCE
String prompt = "prompt_example"; // String | Prompt for the authorization request
String nonce = "nonce_example"; // String | Random value used to prevent replay attacks
try {
    apiInstance.authorizeOAuth(clientId, responseType, scope, redirectUri, state, xIdempotencyKey, xFapiAuthDate, xFapiCustomerLastLoggedTime, codeChallenge, codeChallengeMethod, prompt, nonce);
} catch (ApiException e) {
    System.err.println("Exception when calling OAuthApi#authorizeOAuth");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientId** | **String**| Client identifier issued to the client during registration |
 **responseType** | **String**| Must be set to \&quot;code\&quot; for authorization code flow | [enum: code]
 **scope** | [**List&lt;String&gt;**](String.md)| Space-separated list of requested scope values, OFxPERA requires openid to be included to maintain compatibility with OIDC. | [enum: openid, profile, email, address, phone]
 **redirectUri** | **String**| URI to return the user to after authorization is complete |
 **state** | **String**| Opaque value to maintain state between request and callback |
 **xIdempotencyKey** | [**UUID**](.md)| Unique idempotency key for the request as per FAPI Advanced requirements |
 **xFapiAuthDate** | **OffsetDateTime**| The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. |
 **xFapiCustomerLastLoggedTime** | **OffsetDateTime**| The time when the PSU last logged in to the client software as per FAPI Advanced requirements |
 **codeChallenge** | **String**| Code challenge for PKCE | [optional]
 **codeChallengeMethod** | **String**| Code challenge method for PKCE | [optional] [enum: S256]
 **prompt** | **String**| Prompt for the authorization request | [optional]
 **nonce** | **String**| Random value used to prevent replay attacks | [optional]

### Return type

null (empty response body)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getOAuthToken"></a>
# **getOAuthToken**
> TokenResponse getOAuthToken(grantType, code, redirectUri, clientId, refreshToken, clientAssertionType, clientAssertion, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId)

[PHASE 1] Token endpoint

OAuth 2.0 token endpoint for obtaining access tokens

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OAuthApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


OAuthApi apiInstance = new OAuthApi();
String grantType = "grantType_example"; // String | 
String code = "code_example"; // String | 
String redirectUri = "redirectUri_example"; // String | 
String clientId = "clientId_example"; // String | 
String refreshToken = "refreshToken_example"; // String | 
String clientAssertionType = "clientAssertionType_example"; // String | 
String clientAssertion = "clientAssertion_example"; // String | 
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
OffsetDateTime xFapiAuthDate = new OffsetDateTime(); // OffsetDateTime | The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.
String xFapiCustomerIpAddress = "xFapiCustomerIpAddress_example"; // String | The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.
String xClientHeaders = "xClientHeaders_example"; // String | The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
String xClientUserAgent = "xClientUserAgent_example"; // String | The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
UUID xIdempotencyKey = new UUID(); // UUID | Unique idempotency key for the request as per FAPI Advanced requirements
OffsetDateTime xFapiCustomerLastLoggedTime = new OffsetDateTime(); // OffsetDateTime | The time when the PSU last logged in to the client software as per FAPI Advanced requirements
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    TokenResponse result = apiInstance.getOAuthToken(grantType, code, redirectUri, clientId, refreshToken, clientAssertionType, clientAssertion, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OAuthApi#getOAuthToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **grantType** | **String**|  | [enum: authorization_code, refresh_token]
 **code** | **String**|  |
 **redirectUri** | **String**|  |
 **clientId** | **String**|  |
 **refreshToken** | **String**|  |
 **clientAssertionType** | **String**|  | [enum: urn:ietf:params:oauth:assertion-type:jwt-bearer]
 **clientAssertion** | **String**|  |
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 100, 1]
 **xFapiAuthDate** | **OffsetDateTime**| The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. |
 **xFapiCustomerIpAddress** | **String**| The customer&#x27;s original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. |
 **xClientHeaders** | **String**| The customer&#x27;s original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xClientUserAgent** | **String**| The customer&#x27;s original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xIdempotencyKey** | [**UUID**](.md)| Unique idempotency key for the request as per FAPI Advanced requirements |
 **xFapiCustomerLastLoggedTime** | **OffsetDateTime**| The time when the PSU last logged in to the client software as per FAPI Advanced requirements |
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="getUserInfo"></a>
# **getUserInfo**
> InlineResponse2001 getUserInfo(authorization, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId)

Optional OpenID Connect UserInfo Endpoint

OpenID Connect UserInfo Endpoint that returns information about the authenticated user. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OAuthApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

OAuthApi apiInstance = new OAuthApi();
String authorization = "authorization_example"; // String | Bearer token for authentication. Must be in the format 'Bearer <token>'
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
OffsetDateTime xFapiAuthDate = new OffsetDateTime(); // OffsetDateTime | The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.
String xFapiCustomerIpAddress = "xFapiCustomerIpAddress_example"; // String | The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.
String xClientHeaders = "xClientHeaders_example"; // String | The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
String xClientUserAgent = "xClientUserAgent_example"; // String | The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
UUID xIdempotencyKey = new UUID(); // UUID | Unique idempotency key for the request as per FAPI Advanced requirements
OffsetDateTime xFapiCustomerLastLoggedTime = new OffsetDateTime(); // OffsetDateTime | The time when the PSU last logged in to the client software as per FAPI Advanced requirements
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    InlineResponse2001 result = apiInstance.getUserInfo(authorization, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OAuthApi#getUserInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer token for authentication. Must be in the format &#x27;Bearer &lt;token&gt;&#x27; |
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 1, 100]
 **xFapiAuthDate** | **OffsetDateTime**| The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. |
 **xFapiCustomerIpAddress** | **String**| The customer&#x27;s original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. |
 **xClientHeaders** | **String**| The customer&#x27;s original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xClientUserAgent** | **String**| The customer&#x27;s original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xIdempotencyKey** | [**UUID**](.md)| Unique idempotency key for the request as per FAPI Advanced requirements |
 **xFapiCustomerLastLoggedTime** | **OffsetDateTime**| The time when the PSU last logged in to the client software as per FAPI Advanced requirements |
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="introspectToken"></a>
# **introspectToken**
> InlineResponse200 introspectToken(token, authorization, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId)

Optional token introspection

Endpoint for validating and retrieving metadata about an access token. Returns information about whether the token is active, its associated client, user, scopes, and expiration details. This endpoint allows resource servers to verify tokens before granting access to protected resources. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OAuthApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


OAuthApi apiInstance = new OAuthApi();
String token = "token_example"; // String | 
String authorization = "authorization_example"; // String | Bearer token for authentication. Must be in the format 'Bearer <token>'
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
OffsetDateTime xFapiAuthDate = new OffsetDateTime(); // OffsetDateTime | The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.
String xFapiCustomerIpAddress = "xFapiCustomerIpAddress_example"; // String | The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.
String xClientHeaders = "xClientHeaders_example"; // String | The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
String xClientUserAgent = "xClientUserAgent_example"; // String | The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
UUID xIdempotencyKey = new UUID(); // UUID | Unique idempotency key for the request as per FAPI Advanced requirements
OffsetDateTime xFapiCustomerLastLoggedTime = new OffsetDateTime(); // OffsetDateTime | The time when the PSU last logged in to the client software as per FAPI Advanced requirements
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    InlineResponse200 result = apiInstance.introspectToken(token, authorization, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OAuthApi#introspectToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **token** | **String**|  |
 **authorization** | **String**| Bearer token for authentication. Must be in the format &#x27;Bearer &lt;token&gt;&#x27; |
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 1, 100]
 **xFapiAuthDate** | **OffsetDateTime**| The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. |
 **xFapiCustomerIpAddress** | **String**| The customer&#x27;s original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. |
 **xClientHeaders** | **String**| The customer&#x27;s original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xClientUserAgent** | **String**| The customer&#x27;s original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xIdempotencyKey** | [**UUID**](.md)| Unique idempotency key for the request as per FAPI Advanced requirements |
 **xFapiCustomerLastLoggedTime** | **OffsetDateTime**| The time when the PSU last logged in to the client software as per FAPI Advanced requirements |
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="oAuthPAR"></a>
# **oAuthPAR**
> oAuthPAR(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId)

[PHASE 1] PAR-based Authorization API for FI-initiated onboarding

POST version of the authorization API that initiates the authorization flow

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OAuthApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


OAuthApi apiInstance = new OAuthApi();
OauthAuthBody body = new OauthAuthBody(); // OauthAuthBody | 
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
OffsetDateTime xFapiAuthDate = new OffsetDateTime(); // OffsetDateTime | The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.
String xFapiCustomerIpAddress = "xFapiCustomerIpAddress_example"; // String | The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.
String xClientHeaders = "xClientHeaders_example"; // String | The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
String xClientUserAgent = "xClientUserAgent_example"; // String | The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
UUID xIdempotencyKey = new UUID(); // UUID | Unique idempotency key for the request as per FAPI Advanced requirements
OffsetDateTime xFapiCustomerLastLoggedTime = new OffsetDateTime(); // OffsetDateTime | The time when the PSU last logged in to the client software as per FAPI Advanced requirements
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    apiInstance.oAuthPAR(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId);
} catch (ApiException e) {
    System.err.println("Exception when calling OAuthApi#oAuthPAR");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**OauthAuthBody**](OauthAuthBody.md)|  |
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 100, 1]
 **xFapiAuthDate** | **OffsetDateTime**| The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. |
 **xFapiCustomerIpAddress** | **String**| The customer&#x27;s original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. |
 **xClientHeaders** | **String**| The customer&#x27;s original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xClientUserAgent** | **String**| The customer&#x27;s original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xIdempotencyKey** | [**UUID**](.md)| Unique idempotency key for the request as per FAPI Advanced requirements |
 **xFapiCustomerLastLoggedTime** | **OffsetDateTime**| The time when the PSU last logged in to the client software as per FAPI Advanced requirements |
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

null (empty response body)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

