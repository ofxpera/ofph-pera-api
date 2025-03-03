# OAuthApi

All URIs are relative to *https://virtserver.swaggerhub.com/maya-ph/OFxPERA-API/0.0.5*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authorizeOAuth**](OAuthApi.md#authorizeOAuth) | **GET** /oauth/auth | Authorization endpoint
[**getOAuthToken**](OAuthApi.md#getOAuthToken) | **POST** /oauth/token | Token endpoint
[**getUserInfo**](OAuthApi.md#getUserInfo) | **GET** /oauth/userinfo | Optional OpenID Connect UserInfo Endpoint
[**introspectToken**](OAuthApi.md#introspectToken) | **GET** /oauth/introspect | Optional token introspection
[**oAuthPAR**](OAuthApi.md#oAuthPAR) | **POST** /oauth/auth | [Phase 2] PAR-based Authorization API for FI-initiated onboarding

<a name="authorizeOAuth"></a>
# **authorizeOAuth**
> authorizeOAuth(clientId, responseType, scope, redirectUri, state, codeChallenge, codeChallengeMethod, prompt, nonce)

Authorization endpoint

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
String codeChallenge = "codeChallenge_example"; // String | Code challenge for PKCE
String codeChallengeMethod = "codeChallengeMethod_example"; // String | Code challenge method for PKCE
String prompt = "prompt_example"; // String | Prompt for the authorization request
String nonce = "nonce_example"; // String | Random value used to prevent replay attacks
try {
    apiInstance.authorizeOAuth(clientId, responseType, scope, redirectUri, state, codeChallenge, codeChallengeMethod, prompt, nonce);
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
> InlineResponse2001 getOAuthToken(grantType, code, redirectUri, clientId, refreshToken)

Token endpoint

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
try {
    InlineResponse2001 result = apiInstance.getOAuthToken(grantType, code, redirectUri, clientId, refreshToken);
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

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="getUserInfo"></a>
# **getUserInfo**
> InlineResponse2003 getUserInfo()

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
try {
    InlineResponse2003 result = apiInstance.getUserInfo();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OAuthApi#getUserInfo");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="introspectToken"></a>
# **introspectToken**
> InlineResponse2002 introspectToken(token)

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

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

OAuthApi apiInstance = new OAuthApi();
String token = "token_example"; // String | 
try {
    InlineResponse2002 result = apiInstance.introspectToken(token);
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

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="oAuthPAR"></a>
# **oAuthPAR**
> InlineResponse200 oAuthPAR(body)

[Phase 2] PAR-based Authorization API for FI-initiated onboarding

POST version of the authorization API that initiates the authorization flow\&quot;

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
try {
    InlineResponse200 result = apiInstance.oAuthPAR(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OAuthApi#oAuthPAR");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**OauthAuthBody**](OauthAuthBody.md)|  |

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

