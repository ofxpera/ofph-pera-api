# ConsentApi

All URIs are relative to *https://virtserver.swaggerhub.com/voyager-innovation/OFxPERA/0.0.7*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkUpdateCustomerConsents**](ConsentApi.md#bulkUpdateCustomerConsents) | **POST** /consent/customers/{customer_id}/arrangements/bulk-update | Bulk update customer&#x27;s consent arrangements
[**createBulkConsent**](ConsentApi.md#createBulkConsent) | **POST** /consent/bulk | Create bulk consent arrangements
[**createConsentArrangement**](ConsentApi.md#createConsentArrangement) | **POST** /consent/arrangements | Create a consent arrangement
[**extendConsentDuration**](ConsentApi.md#extendConsentDuration) | **POST** /consent/arrangements/{arrangement_id}/extend | Extend consent arrangement duration
[**getConsentArrangement**](ConsentApi.md#getConsentArrangement) | **GET** /consent/arrangements/{arrangement_id} | Get consent arrangement details
[**getConsentHistory**](ConsentApi.md#getConsentHistory) | **GET** /consent/arrangements/{arrangement_id}/history | Get consent arrangement history
[**getCustomerConsentDashboard**](ConsentApi.md#getCustomerConsentDashboard) | **GET** /consent/customers/{customer_id}/dashboard | Get customer&#x27;s consent dashboard
[**getCustomerConsents**](ConsentApi.md#getCustomerConsents) | **GET** /consent/customers/{customer_id}/arrangements | Get customer&#x27;s consent arrangements
[**listConsentArrangements**](ConsentApi.md#listConsentArrangements) | **GET** /consent/arrangements | List consent arrangements
[**listConsentTemplates**](ConsentApi.md#listConsentTemplates) | **GET** /consent/templates | List available consent templates
[**revokeConsentArrangement**](ConsentApi.md#revokeConsentArrangement) | **DELETE** /consent/arrangements/{arrangement_id} | Revoke consent arrangement
[**updateConsentStatus**](ConsentApi.md#updateConsentStatus) | **PUT** /consent/arrangements/{arrangement_id} | Update consent arrangement status

<a name="bulkUpdateCustomerConsents"></a>
# **bulkUpdateCustomerConsents**
> InlineResponse2004 bulkUpdateCustomerConsents(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, customerId, xFapiInteractionId)

Bulk update customer&#x27;s consent arrangements

Update multiple consent arrangements for a specific customer in a single request. Based on: - Australia CDR Bulk Consumer Update - Korea MyData Consent Management 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ConsentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


ConsentApi apiInstance = new ConsentApi();
ArrangementsBulkupdateBody body = new ArrangementsBulkupdateBody(); // ArrangementsBulkupdateBody | 
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
OffsetDateTime xFapiAuthDate = new OffsetDateTime(); // OffsetDateTime | The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.
String xFapiCustomerIpAddress = "xFapiCustomerIpAddress_example"; // String | The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.
String xClientHeaders = "xClientHeaders_example"; // String | The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
String xClientUserAgent = "xClientUserAgent_example"; // String | The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
UUID xIdempotencyKey = new UUID(); // UUID | Unique idempotency key for the request as per FAPI Advanced requirements
OffsetDateTime xFapiCustomerLastLoggedTime = new OffsetDateTime(); // OffsetDateTime | The time when the PSU last logged in to the client software as per FAPI Advanced requirements
String customerId = "customerId_example"; // String | The customer's unique identifier
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    InlineResponse2004 result = apiInstance.bulkUpdateCustomerConsents(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, customerId, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#bulkUpdateCustomerConsents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ArrangementsBulkupdateBody**](ArrangementsBulkupdateBody.md)|  |
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 100, 1]
 **xFapiAuthDate** | **OffsetDateTime**| The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. |
 **xFapiCustomerIpAddress** | **String**| The customer&#x27;s original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. |
 **xClientHeaders** | **String**| The customer&#x27;s original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xClientUserAgent** | **String**| The customer&#x27;s original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xIdempotencyKey** | [**UUID**](.md)| Unique idempotency key for the request as per FAPI Advanced requirements |
 **xFapiCustomerLastLoggedTime** | **OffsetDateTime**| The time when the PSU last logged in to the client software as per FAPI Advanced requirements |
 **customerId** | **String**| The customer&#x27;s unique identifier |
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**InlineResponse2004**](InlineResponse2004.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createBulkConsent"></a>
# **createBulkConsent**
> BulkConsentResponse createBulkConsent(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId)

Create bulk consent arrangements

Create multiple consent arrangements in a single request. Based on: - Korea MyData Bulk Consent API - Singapore SGFinDex Multi-Institution Consent 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ConsentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


ConsentApi apiInstance = new ConsentApi();
BulkConsentRequest body = new BulkConsentRequest(); // BulkConsentRequest | 
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
    BulkConsentResponse result = apiInstance.createBulkConsent(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#createBulkConsent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**BulkConsentRequest**](BulkConsentRequest.md)|  |
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

[**BulkConsentResponse**](BulkConsentResponse.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createConsentArrangement"></a>
# **createConsentArrangement**
> ConsentArrangementResponse createConsentArrangement(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId)

Create a consent arrangement

Create a new consent arrangement between a data holder and data recipient. Based on: - UK Open Banking Consent API v3.1.10 - Australia CDR Consent Management Standards v1.14.0 - Singapore SGFinDex Consent Framework 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ConsentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


ConsentApi apiInstance = new ConsentApi();
ConsentArrangementRequest body = new ConsentArrangementRequest(); // ConsentArrangementRequest | 
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
    ConsentArrangementResponse result = apiInstance.createConsentArrangement(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#createConsentArrangement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ConsentArrangementRequest**](ConsentArrangementRequest.md)|  |
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

[**ConsentArrangementResponse**](ConsentArrangementResponse.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="extendConsentDuration"></a>
# **extendConsentDuration**
> ConsentArrangementResponse extendConsentDuration(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, arrangementId, xFapiInteractionId)

Extend consent arrangement duration

Extend the duration of an existing consent arrangement. Based on: - Australia CDR Consent Amendment - UK Open Banking Re-authentication 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ConsentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

ConsentApi apiInstance = new ConsentApi();
ConsentExtensionRequest body = new ConsentExtensionRequest(); // ConsentExtensionRequest | 
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
OffsetDateTime xFapiAuthDate = new OffsetDateTime(); // OffsetDateTime | The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.
String xFapiCustomerIpAddress = "xFapiCustomerIpAddress_example"; // String | The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.
String xClientHeaders = "xClientHeaders_example"; // String | The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
String xClientUserAgent = "xClientUserAgent_example"; // String | The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
UUID xIdempotencyKey = new UUID(); // UUID | Unique idempotency key for the request as per FAPI Advanced requirements
OffsetDateTime xFapiCustomerLastLoggedTime = new OffsetDateTime(); // OffsetDateTime | The time when the PSU last logged in to the client software as per FAPI Advanced requirements
String arrangementId = "arrangementId_example"; // String | The ID of the consent arrangement
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    ConsentArrangementResponse result = apiInstance.extendConsentDuration(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, arrangementId, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#extendConsentDuration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ConsentExtensionRequest**](ConsentExtensionRequest.md)|  |
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 100, 1]
 **xFapiAuthDate** | **OffsetDateTime**| The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. |
 **xFapiCustomerIpAddress** | **String**| The customer&#x27;s original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. |
 **xClientHeaders** | **String**| The customer&#x27;s original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xClientUserAgent** | **String**| The customer&#x27;s original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xIdempotencyKey** | [**UUID**](.md)| Unique idempotency key for the request as per FAPI Advanced requirements |
 **xFapiCustomerLastLoggedTime** | **OffsetDateTime**| The time when the PSU last logged in to the client software as per FAPI Advanced requirements |
 **arrangementId** | **String**| The ID of the consent arrangement |
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**ConsentArrangementResponse**](ConsentArrangementResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConsentArrangement"></a>
# **getConsentArrangement**
> ConsentArrangementResponse getConsentArrangement(arrangementId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId)

Get consent arrangement details

Retrieve details of a specific consent arrangement. Based on: - UK Open Banking Account Access Consents API - Australia CDR Get Consent API 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ConsentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


ConsentApi apiInstance = new ConsentApi();
String arrangementId = "arrangementId_example"; // String | The ID of the consent arrangement
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
    ConsentArrangementResponse result = apiInstance.getConsentArrangement(arrangementId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#getConsentArrangement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **arrangementId** | **String**| The ID of the consent arrangement |
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

[**ConsentArrangementResponse**](ConsentArrangementResponse.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getConsentHistory"></a>
# **getConsentHistory**
> ConsentHistory getConsentHistory(arrangementId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId)

Get consent arrangement history

Retrieve the full history of changes to a consent arrangement. Based on: - Australia CDR Consent History API - UK Open Banking Consent Audit Requirements 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ConsentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


ConsentApi apiInstance = new ConsentApi();
String arrangementId = "arrangementId_example"; // String | The ID of the consent arrangement
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
    ConsentHistory result = apiInstance.getConsentHistory(arrangementId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#getConsentHistory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **arrangementId** | **String**| The ID of the consent arrangement |
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

[**ConsentHistory**](ConsentHistory.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCustomerConsentDashboard"></a>
# **getCustomerConsentDashboard**
> ConsentDashboard getCustomerConsentDashboard(customerId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId)

Get customer&#x27;s consent dashboard

Retrieve a comprehensive view of customer&#x27;s consent arrangements and data sharing. Based on: - Australia CDR Consumer Dashboard - UK Open Banking Consent Dashboard - Singapore SGFinDex Customer Portal 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ConsentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


ConsentApi apiInstance = new ConsentApi();
String customerId = "customerId_example"; // String | The customer's unique identifier
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
    ConsentDashboard result = apiInstance.getCustomerConsentDashboard(customerId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#getCustomerConsentDashboard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **customerId** | **String**| The customer&#x27;s unique identifier |
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

[**ConsentDashboard**](ConsentDashboard.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCustomerConsents"></a>
# **getCustomerConsents**
> InlineResponse2003 getCustomerConsents(customerId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, status, dataHolderId, purpose, xFapiInteractionId)

Get customer&#x27;s consent arrangements

Retrieve all consent arrangements for a specific customer. Based on: - UK Open Banking Customer Consent Management - Australia CDR Consumer Dashboard APIs - Singapore SGFinDex Customer Consent View 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ConsentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


ConsentApi apiInstance = new ConsentApi();
String customerId = "customerId_example"; // String | The customer's unique identifier
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
OffsetDateTime xFapiAuthDate = new OffsetDateTime(); // OffsetDateTime | The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.
String xFapiCustomerIpAddress = "xFapiCustomerIpAddress_example"; // String | The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.
String xClientHeaders = "xClientHeaders_example"; // String | The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
String xClientUserAgent = "xClientUserAgent_example"; // String | The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
UUID xIdempotencyKey = new UUID(); // UUID | Unique idempotency key for the request as per FAPI Advanced requirements
OffsetDateTime xFapiCustomerLastLoggedTime = new OffsetDateTime(); // OffsetDateTime | The time when the PSU last logged in to the client software as per FAPI Advanced requirements
String status = "status_example"; // String | Filter consents by status
String dataHolderId = "dataHolderId_example"; // String | Filter by specific data holder/institution
String purpose = "purpose_example"; // String | Filter by consent purpose
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    InlineResponse2003 result = apiInstance.getCustomerConsents(customerId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, status, dataHolderId, purpose, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#getCustomerConsents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **customerId** | **String**| The customer&#x27;s unique identifier |
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 1, 100]
 **xFapiAuthDate** | **OffsetDateTime**| The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. |
 **xFapiCustomerIpAddress** | **String**| The customer&#x27;s original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. |
 **xClientHeaders** | **String**| The customer&#x27;s original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xClientUserAgent** | **String**| The customer&#x27;s original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xIdempotencyKey** | [**UUID**](.md)| Unique idempotency key for the request as per FAPI Advanced requirements |
 **xFapiCustomerLastLoggedTime** | **OffsetDateTime**| The time when the PSU last logged in to the client software as per FAPI Advanced requirements |
 **status** | **String**| Filter consents by status | [optional] [enum: active, expired, revoked, suspended]
 **dataHolderId** | **String**| Filter by specific data holder/institution | [optional]
 **purpose** | **String**| Filter by consent purpose | [optional]
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listConsentArrangements"></a>
# **listConsentArrangements**
> List&lt;ConsentArrangementResponse&gt; listConsentArrangements(participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, status, fromDate, toDate, xFapiInteractionId)

List consent arrangements

Retrieve a list of active consent arrangements for the authenticated user. Based on: - UK Open Banking Account Access Consents API - Australia CDR Get Consent API 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ConsentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


ConsentApi apiInstance = new ConsentApi();
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
OffsetDateTime xFapiAuthDate = new OffsetDateTime(); // OffsetDateTime | The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.
String xFapiCustomerIpAddress = "xFapiCustomerIpAddress_example"; // String | The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.
String xClientHeaders = "xClientHeaders_example"; // String | The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
String xClientUserAgent = "xClientUserAgent_example"; // String | The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
UUID xIdempotencyKey = new UUID(); // UUID | Unique idempotency key for the request as per FAPI Advanced requirements
OffsetDateTime xFapiCustomerLastLoggedTime = new OffsetDateTime(); // OffsetDateTime | The time when the PSU last logged in to the client software as per FAPI Advanced requirements
String status = "status_example"; // String | Filter consents by status
OffsetDateTime fromDate = new OffsetDateTime(); // OffsetDateTime | Filter consents created after this date
OffsetDateTime toDate = new OffsetDateTime(); // OffsetDateTime | Filter consents created before this date
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    List<ConsentArrangementResponse> result = apiInstance.listConsentArrangements(participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, status, fromDate, toDate, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#listConsentArrangements");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 1, 100]
 **xFapiAuthDate** | **OffsetDateTime**| The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. |
 **xFapiCustomerIpAddress** | **String**| The customer&#x27;s original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. |
 **xClientHeaders** | **String**| The customer&#x27;s original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xClientUserAgent** | **String**| The customer&#x27;s original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xIdempotencyKey** | [**UUID**](.md)| Unique idempotency key for the request as per FAPI Advanced requirements |
 **xFapiCustomerLastLoggedTime** | **OffsetDateTime**| The time when the PSU last logged in to the client software as per FAPI Advanced requirements |
 **status** | **String**| Filter consents by status | [optional] [enum: active, expired, revoked, suspended]
 **fromDate** | **OffsetDateTime**| Filter consents created after this date | [optional]
 **toDate** | **OffsetDateTime**| Filter consents created before this date | [optional]
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**List&lt;ConsentArrangementResponse&gt;**](ConsentArrangementResponse.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listConsentTemplates"></a>
# **listConsentTemplates**
> List&lt;ConsentTemplate&gt; listConsentTemplates(participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, category, purpose, xFapiInteractionId)

List available consent templates

Retrieve available consent templates that can be used to create new arrangements. Based on: - Australia CDR Consent Taxonomy - UK Open Banking Standard Permissions 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ConsentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


ConsentApi apiInstance = new ConsentApi();
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
OffsetDateTime xFapiAuthDate = new OffsetDateTime(); // OffsetDateTime | The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.
String xFapiCustomerIpAddress = "xFapiCustomerIpAddress_example"; // String | The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.
String xClientHeaders = "xClientHeaders_example"; // String | The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
String xClientUserAgent = "xClientUserAgent_example"; // String | The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
UUID xIdempotencyKey = new UUID(); // UUID | Unique idempotency key for the request as per FAPI Advanced requirements
OffsetDateTime xFapiCustomerLastLoggedTime = new OffsetDateTime(); // OffsetDateTime | The time when the PSU last logged in to the client software as per FAPI Advanced requirements
String category = "category_example"; // String | Filter templates by category
String purpose = "purpose_example"; // String | Filter templates by purpose
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    List<ConsentTemplate> result = apiInstance.listConsentTemplates(participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, category, purpose, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#listConsentTemplates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 1, 100]
 **xFapiAuthDate** | **OffsetDateTime**| The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. |
 **xFapiCustomerIpAddress** | **String**| The customer&#x27;s original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. |
 **xClientHeaders** | **String**| The customer&#x27;s original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xClientUserAgent** | **String**| The customer&#x27;s original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xIdempotencyKey** | [**UUID**](.md)| Unique idempotency key for the request as per FAPI Advanced requirements |
 **xFapiCustomerLastLoggedTime** | **OffsetDateTime**| The time when the PSU last logged in to the client software as per FAPI Advanced requirements |
 **category** | **String**| Filter templates by category | [optional]
 **purpose** | **String**| Filter templates by purpose | [optional]
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**List&lt;ConsentTemplate&gt;**](ConsentTemplate.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="revokeConsentArrangement"></a>
# **revokeConsentArrangement**
> revokeConsentArrangement(arrangementId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId)

Revoke consent arrangement

Revoke an existing consent arrangement. Based on: - UK Open Banking Account Access Consents API - Australia CDR Revoke Consent API - Korea MyData Consent Revocation API 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ConsentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


ConsentApi apiInstance = new ConsentApi();
String arrangementId = "arrangementId_example"; // String | The ID of the consent arrangement to revoke
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
    apiInstance.revokeConsentArrangement(arrangementId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#revokeConsentArrangement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **arrangementId** | **String**| The ID of the consent arrangement to revoke |
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

null (empty response body)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateConsentStatus"></a>
# **updateConsentStatus**
> ConsentArrangementResponse updateConsentStatus(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, arrangementId, xFapiInteractionId)

Update consent arrangement status

Update the status of a consent arrangement (e.g., suspend, resume). Based on: - UK Open Banking Account Access Consents API - Australia CDR Update Consent API 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ConsentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


ConsentApi apiInstance = new ConsentApi();
ConsentStatusUpdate body = new ConsentStatusUpdate(); // ConsentStatusUpdate | 
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
OffsetDateTime xFapiAuthDate = new OffsetDateTime(); // OffsetDateTime | The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.
String xFapiCustomerIpAddress = "xFapiCustomerIpAddress_example"; // String | The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.
String xClientHeaders = "xClientHeaders_example"; // String | The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
String xClientUserAgent = "xClientUserAgent_example"; // String | The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls.
UUID xIdempotencyKey = new UUID(); // UUID | Unique idempotency key for the request as per FAPI Advanced requirements
OffsetDateTime xFapiCustomerLastLoggedTime = new OffsetDateTime(); // OffsetDateTime | The time when the PSU last logged in to the client software as per FAPI Advanced requirements
String arrangementId = "arrangementId_example"; // String | The ID of the consent arrangement
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    ConsentArrangementResponse result = apiInstance.updateConsentStatus(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, arrangementId, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#updateConsentStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ConsentStatusUpdate**](ConsentStatusUpdate.md)|  |
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 100, 1]
 **xFapiAuthDate** | **OffsetDateTime**| The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. |
 **xFapiCustomerIpAddress** | **String**| The customer&#x27;s original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. |
 **xClientHeaders** | **String**| The customer&#x27;s original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xClientUserAgent** | **String**| The customer&#x27;s original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. |
 **xIdempotencyKey** | [**UUID**](.md)| Unique idempotency key for the request as per FAPI Advanced requirements |
 **xFapiCustomerLastLoggedTime** | **OffsetDateTime**| The time when the PSU last logged in to the client software as per FAPI Advanced requirements |
 **arrangementId** | **String**| The ID of the consent arrangement |
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**ConsentArrangementResponse**](ConsentArrangementResponse.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

