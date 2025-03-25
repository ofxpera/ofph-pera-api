# BootstrapApi

All URIs are relative to *https://virtserver.swaggerhub.com/voyager-innovation/OFxPERA/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getParticipant**](BootstrapApi.md#getParticipant) | **GET** /ofxpera/participants/{participant_id} | [PHASE 2] Get an OFxPERA Participant&#x27;s registration information
[**listParticipants**](BootstrapApi.md#listParticipants) | **GET** /ofxpera/participants | [PHASE 1] Get a list of registered OFxPERA Participants
[**listProductByParticipant**](BootstrapApi.md#listProductByParticipant) | **GET** /ofxpera/products/{participant_id} | [PHASE 1] Get a list of PERA products associated with PERA Admin
[**registerParticipant**](BootstrapApi.md#registerParticipant) | **POST** /ofxpera/participants | [PHASE 2] Register an OFxPERA Participant
[**registerProduct**](BootstrapApi.md#registerProduct) | **POST** /ofxpera/products | [PHASE 2] Register a PERA Admin Product
[**updateParticipant**](BootstrapApi.md#updateParticipant) | **PUT** /ofxpera/participants | [PHASE 2] Update an OFxPERA Participant
[**updateProduct**](BootstrapApi.md#updateProduct) | **PUT** /ofxpera/products/{product_id} | [PHASE 2] Update a PERA Admin Product

<a name="getParticipant"></a>
# **getParticipant**
> ParticipantConfig getParticipant(participantId, participantId, xV, xFapiInteractionId)

[PHASE 2] Get an OFxPERA Participant&#x27;s registration information

API for retrieving registration information for a specific OFxPERA Participant

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BootstrapApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


BootstrapApi apiInstance = new BootstrapApi();
String participantId = "participantId_example"; // String | Participant identifier issued during participant registration
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    ParticipantConfig result = apiInstance.getParticipant(participantId, participantId, xV, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BootstrapApi#getParticipant");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **participantId** | **String**| Participant identifier issued during participant registration |
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 1, 100]
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**ParticipantConfig**](ParticipantConfig.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listParticipants"></a>
# **listParticipants**
> List&lt;ParticipantConfig&gt; listParticipants(participantId, xV, xFapiInteractionId)

[PHASE 1] Get a list of registered OFxPERA Participants

API for retrieving all registered OFxPERA Participants

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BootstrapApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


BootstrapApi apiInstance = new BootstrapApi();
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    List<ParticipantConfig> result = apiInstance.listParticipants(participantId, xV, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BootstrapApi#listParticipants");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 1, 100]
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**List&lt;ParticipantConfig&gt;**](ParticipantConfig.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listProductByParticipant"></a>
# **listProductByParticipant**
> List&lt;PeraProduct&gt; listProductByParticipant(participantId, participantId, xV, xFapiInteractionId)

[PHASE 1] Get a list of PERA products associated with PERA Admin

API for retrieving all registered products associated with the PERA Admin.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BootstrapApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


BootstrapApi apiInstance = new BootstrapApi();
String participantId = "participantId_example"; // String | Participant identifier issued during Participant registration
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    List<PeraProduct> result = apiInstance.listProductByParticipant(participantId, participantId, xV, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BootstrapApi#listProductByParticipant");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **participantId** | **String**| Participant identifier issued during Participant registration |
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 1, 100]
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**List&lt;PeraProduct&gt;**](PeraProduct.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="registerParticipant"></a>
# **registerParticipant**
> ClientRegistrationResponse registerParticipant(body, xV, xFapiInteractionId)

[PHASE 2] Register an OFxPERA Participant

API for registering an OFxPERA Participant following FAPI Dynamic Client Registration requirements

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BootstrapApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


BootstrapApi apiInstance = new BootstrapApi();
ParticipantConfig body = new ParticipantConfig(); // ParticipantConfig | 
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    ClientRegistrationResponse result = apiInstance.registerParticipant(body, xV, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BootstrapApi#registerParticipant");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ParticipantConfig**](ParticipantConfig.md)|  |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 100, 1]
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**ClientRegistrationResponse**](ClientRegistrationResponse.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="registerProduct"></a>
# **registerProduct**
> PeraProduct registerProduct(participantId, xV, xFapiInteractionId)

[PHASE 2] Register a PERA Admin Product

API that allows PERA Admin to register a PERA product.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BootstrapApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


BootstrapApi apiInstance = new BootstrapApi();
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    PeraProduct result = apiInstance.registerProduct(participantId, xV, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BootstrapApi#registerProduct");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 1, 100]
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**PeraProduct**](PeraProduct.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateParticipant"></a>
# **updateParticipant**
> ClientRegistrationResponse updateParticipant(body, participantId, xV, xFapiInteractionId)

[PHASE 2] Update an OFxPERA Participant

API for updating the URIs and status of an OFxPERA Participant

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BootstrapApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


BootstrapApi apiInstance = new BootstrapApi();
ParticipantConfig body = new ParticipantConfig(); // ParticipantConfig | 
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    ClientRegistrationResponse result = apiInstance.updateParticipant(body, participantId, xV, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BootstrapApi#updateParticipant");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ParticipantConfig**](ParticipantConfig.md)|  |
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 100, 1]
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**ClientRegistrationResponse**](ClientRegistrationResponse.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateProduct"></a>
# **updateProduct**
> PeraProduct updateProduct(productId, participantId, xV, xFapiInteractionId)

[PHASE 2] Update a PERA Admin Product

API that allows PERA Admin to update their product.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BootstrapApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


BootstrapApi apiInstance = new BootstrapApi();
String productId = "productId_example"; // String | Product identifier issued during product registration
String participantId = "participantId_example"; // String | Field referencing the unique identifier of the requesting participant.
Integer xV = 56; // Integer | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable.
UUID xFapiInteractionId = new UUID(); // UUID | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.
try {
    PeraProduct result = apiInstance.updateProduct(productId, participantId, xV, xFapiInteractionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BootstrapApi#updateProduct");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productId** | **String**| Product identifier issued during product registration |
 **participantId** | **String**| Field referencing the unique identifier of the requesting participant. |
 **xV** | **Integer**| Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | [enum: 1, 100]
 **xFapiInteractionId** | [**UUID**](.md)| An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | [optional]

### Return type

[**PeraProduct**](PeraProduct.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

