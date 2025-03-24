# CommonApi

All URIs are relative to *https://virtserver.swaggerhub.com/voyager-innovation/OFxPERA/0.0.7*

Method | HTTP request | Description
------------- | ------------- | -------------
[**forwardCustomerEndorsement**](CommonApi.md#forwardCustomerEndorsement) | **GET** /common/customers/endorse | [DEPRECATED] Forward customer endorsement
[**getCustomerDetail**](CommonApi.md#getCustomerDetail) | **GET** /common/customers/{customer_id}/detail | [PHASE 1] Get detailed customer information

<a name="forwardCustomerEndorsement"></a>
# **forwardCustomerEndorsement**
> EndorsementResponse forwardCustomerEndorsement(endorsement, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId)

[DEPRECATED] Forward customer endorsement

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CommonApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

CommonApi apiInstance = new CommonApi();
String endorsement = "endorsement_example"; // String | Encrypted endorsement payload in JWS/JWE format
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
    EndorsementResponse result = apiInstance.forwardCustomerEndorsement(endorsement, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommonApi#forwardCustomerEndorsement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endorsement** | **String**| Encrypted endorsement payload in JWS/JWE format |
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

[**EndorsementResponse**](EndorsementResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCustomerDetail"></a>
# **getCustomerDetail**
> CustomerInformation getCustomerDetail(customerId, authorization, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId)

[PHASE 1] Get detailed customer information

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CommonApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

CommonApi apiInstance = new CommonApi();
String customerId = "customerId_example"; // String | Customer ID, this should map to the sub field returned from the OIDC token endpoint or the sub field returned from the /oauth/userinfo endpoint
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
    CustomerInformation result = apiInstance.getCustomerDetail(customerId, authorization, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommonApi#getCustomerDetail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **customerId** | **String**| Customer ID, this should map to the sub field returned from the OIDC token endpoint or the sub field returned from the /oauth/userinfo endpoint |
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

[**CustomerInformation**](CustomerInformation.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

