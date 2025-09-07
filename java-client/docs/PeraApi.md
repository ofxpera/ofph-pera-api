# PeraApi

All URIs are relative to *https://virtserver.swaggerhub.com/voyager-innovation/OFxPERA-API/1.0.3-Draft*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getArrangementStatus**](PeraApi.md#getArrangementStatus) | **GET** /ofxpera/arrangements/{arrangement_id} | [PHASE 1] Get the status of a PERA arrangement
[**peraArrangementRegistration**](PeraApi.md#peraArrangementRegistration) | **POST** /ofxpera/arrangements | [PHASE 1] Registers the result of a PERA account opening

<a name="getArrangementStatus"></a>
# **getArrangementStatus**
> PeraArrangement getArrangementStatus(arrangementId, authorization, xV, xFapiInteractionId)

[PHASE 1] Get the status of a PERA arrangement

API that allows FIs to retrieve the status of one or more PERA Arrangements

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.PeraApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


PeraApi apiInstance = new PeraApi();
String arrangementId = "arrangementId_example"; // String | The ID of the PERA Arrangement
String authorization = "authorization_example"; // String | Bearer token for authentication. Must be in the format 'Bearer <signedJWT>'. the token is a signed JWT issued by the Financial Institution.  JWT carries the following payload.  ** JWT Header ** - `alg` (string) `*required` - Must be `RS256`. The algorithm used to sign the JWT  - `type` (string) `*required` - Must be `JWT`. The type of the token - `kid` (string) `*required` - The Key ID used to identify the signing key.  ** JWT Claims **  - `jti` (string) `*Required`: Unique identifier for the JWT, usually UUID, used to prevent    replay attacks         - `sub` (string) `*required`: Participant Identifier of the Financial Institution.  - `aud` (string) `*required`: must be 'get-ofxpera-arrangement' - `iat` (integer)`*Required`: Issued-at time (UNIX timestamp) - `exp` (integer)`*Required`: Expiration time (UNIX timestamp) - `arrangement-id` (string) `*required`: The unique identifier for the Consent Arrangement 
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    PeraArrangement result = apiInstance.getArrangementStatus(arrangementId, authorization, xV, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PeraApi#getArrangementStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **arrangementId** | **String**| The ID of the PERA Arrangement |
 **authorization** | **String**| Bearer token for authentication. Must be in the format &#x27;Bearer &lt;signedJWT&gt;&#x27;. the token is a signed JWT issued by the Financial Institution.  JWT carries the following payload.  ** JWT Header ** - &#x60;alg&#x60; (string) &#x60;*required&#x60; - Must be &#x60;RS256&#x60;. The algorithm used to sign the JWT  - &#x60;type&#x60; (string) &#x60;*required&#x60; - Must be &#x60;JWT&#x60;. The type of the token - &#x60;kid&#x60; (string) &#x60;*required&#x60; - The Key ID used to identify the signing key.  ** JWT Claims **  - &#x60;jti&#x60; (string) &#x60;*Required&#x60;: Unique identifier for the JWT, usually UUID, used to prevent    replay attacks         - &#x60;sub&#x60; (string) &#x60;*required&#x60;: Participant Identifier of the Financial Institution.  - &#x60;aud&#x60; (string) &#x60;*required&#x60;: must be &#x27;get-ofxpera-arrangement&#x27; - &#x60;iat&#x60; (integer)&#x60;*Required&#x60;: Issued-at time (UNIX timestamp) - &#x60;exp&#x60; (integer)&#x60;*Required&#x60;: Expiration time (UNIX timestamp) - &#x60;arrangement-id&#x60; (string) &#x60;*required&#x60;: The unique identifier for the Consent Arrangement  |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 1, 100]
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. |

### Return type

[**PeraArrangement**](PeraArrangement.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/jose, application/json

<a name="peraArrangementRegistration"></a>
# **peraArrangementRegistration**
> InlineResponse201 peraArrangementRegistration(body, authorization, xV, xFapiInteractionId, xIdempotencyKey)

[PHASE 1] Registers the result of a PERA account opening

API that allows PERA Admins to notify the Financial Institution about the result of a PERA account opening

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.PeraApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


PeraApi apiInstance = new PeraApi();
PeraArrangement body = new PeraArrangement(); // PeraArrangement | Entire JSON payload must be signed with `JWS (JSON web Signature)` and encrypted using `JWE (JSON Web Encryption)`. JWT carries the following payload.
String authorization = "authorization_example"; // String | Bearer token for authentication. Must be in the format 'Bearer <signedJWT>'. the token is a signed JWT issued by the PERA Admin.  JWT carries the following payload.  ** JWT Header ** - `alg` (string) `*required` - Must be `RS256`. The algorithm used to sign the JWT  - `type` (string) `*required` - Must be `JWT`. The type of the token - `kid` (string) `*required` - The Key ID used to identify the signing key.  ** JWT Claims **  - `jti` (string) `*Required`: Unique identifier for the JWT, usually UUID, used to prevent replay attacks  - `sub` (string) `*required`: The client id used in authorization request. - `iss` (string) `*required`: The client id used in authorization request.  - `aud` (string) `*required`: Audience (the authorization server token URL).  - `iat` (integer)`*Required`: Issued-at time (UNIX timestamp) - `exp` (integer)`*Required`: Expiration time (UNIX timestamp) 
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
UUID xIdempotencyKey = new UUID(); // UUID | Unique idempotency key for the request as per FAPI Advanced requirements
try {
    InlineResponse201 result = apiInstance.peraArrangementRegistration(body, authorization, xV, xFapiInteractionId, xIdempotencyKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PeraApi#peraArrangementRegistration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PeraArrangement**](PeraArrangement.md)| Entire JSON payload must be signed with &#x60;JWS (JSON web Signature)&#x60; and encrypted using &#x60;JWE (JSON Web Encryption)&#x60;. JWT carries the following payload. |
 **authorization** | **String**| Bearer token for authentication. Must be in the format &#x27;Bearer &lt;signedJWT&gt;&#x27;. the token is a signed JWT issued by the PERA Admin.  JWT carries the following payload.  ** JWT Header ** - &#x60;alg&#x60; (string) &#x60;*required&#x60; - Must be &#x60;RS256&#x60;. The algorithm used to sign the JWT  - &#x60;type&#x60; (string) &#x60;*required&#x60; - Must be &#x60;JWT&#x60;. The type of the token - &#x60;kid&#x60; (string) &#x60;*required&#x60; - The Key ID used to identify the signing key.  ** JWT Claims **  - &#x60;jti&#x60; (string) &#x60;*Required&#x60;: Unique identifier for the JWT, usually UUID, used to prevent replay attacks  - &#x60;sub&#x60; (string) &#x60;*required&#x60;: The client id used in authorization request. - &#x60;iss&#x60; (string) &#x60;*required&#x60;: The client id used in authorization request.  - &#x60;aud&#x60; (string) &#x60;*required&#x60;: Audience (the authorization server token URL).  - &#x60;iat&#x60; (integer)&#x60;*Required&#x60;: Issued-at time (UNIX timestamp) - &#x60;exp&#x60; (integer)&#x60;*Required&#x60;: Expiration time (UNIX timestamp)  |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 100, 1]
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. |
 **xIdempotencyKey** | [**UUID**](.md)| Unique idempotency key for the request as per FAPI Advanced requirements |

### Return type

[**InlineResponse201**](InlineResponse201.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: application/jose
 - **Accept**: application/jose, application/json

