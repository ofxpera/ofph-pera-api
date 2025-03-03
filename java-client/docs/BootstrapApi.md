# BootstrapApi

All URIs are relative to *https://virtserver.swaggerhub.com/maya-ph/OFxPERA-API/0.0.5*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getParticipant**](BootstrapApi.md#getParticipant) | **GET** /ofxpera/participants/{participant_id} | Get an OFxPERA Participant&#x27;s registration information
[**listParticipants**](BootstrapApi.md#listParticipants) | **GET** /ofxpera/participants | Get a list of registered OFxPERA Participants
[**listProductByParticipant**](BootstrapApi.md#listProductByParticipant) | **GET** /ofxpera/product/{participant_id} | Get a list of PERA products associated with PERA Admin
[**registerParticipant**](BootstrapApi.md#registerParticipant) | **POST** /ofxpera/participants | Register an OFxPERA Participant
[**registerProduct**](BootstrapApi.md#registerProduct) | **POST** /ofxpera/product | Register a PERA Admin Product
[**updateParticipant**](BootstrapApi.md#updateParticipant) | **PUT** /ofxpera/participants | Update an OFxPERA Participant
[**updateProduct**](BootstrapApi.md#updateProduct) | **PUT** /ofxpera/product/{product_id} | Update a PERA Admin Product

<a name="getParticipant"></a>
# **getParticipant**
> ParticipantConfig getParticipant(participantId)

Get an OFxPERA Participant&#x27;s registration information

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
try {
    ParticipantConfig result = apiInstance.getParticipant(participantId);
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

### Return type

[**ParticipantConfig**](ParticipantConfig.md)

### Authorization

[RegistrationAccessToken](../README.md#RegistrationAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listParticipants"></a>
# **listParticipants**
> List&lt;ParticipantConfig&gt; listParticipants()

Get a list of registered OFxPERA Participants

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
try {
    List<ParticipantConfig> result = apiInstance.listParticipants();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BootstrapApi#listParticipants");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;ParticipantConfig&gt;**](ParticipantConfig.md)

### Authorization

[RegistrationAccessToken](../README.md#RegistrationAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listProductByParticipant"></a>
# **listProductByParticipant**
> List&lt;PeraProduct&gt; listProductByParticipant(participantId)

Get a list of PERA products associated with PERA Admin

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
try {
    List<PeraProduct> result = apiInstance.listProductByParticipant(participantId);
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

### Return type

[**List&lt;PeraProduct&gt;**](PeraProduct.md)

### Authorization

[RegistrationAccessToken](../README.md#RegistrationAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="registerParticipant"></a>
# **registerParticipant**
> ClientRegistrationResponse registerParticipant(body)

Register an OFxPERA Participant

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
try {
    ClientRegistrationResponse result = apiInstance.registerParticipant(body);
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

### Return type

[**ClientRegistrationResponse**](ClientRegistrationResponse.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="registerProduct"></a>
# **registerProduct**
> PeraProduct registerProduct()

Register a PERA Admin Product

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
try {
    PeraProduct result = apiInstance.registerProduct();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BootstrapApi#registerProduct");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**PeraProduct**](PeraProduct.md)

### Authorization

[RegistrationAccessToken](../README.md#RegistrationAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateParticipant"></a>
# **updateParticipant**
> ClientRegistrationResponse updateParticipant(body)

Update an OFxPERA Participant

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
try {
    ClientRegistrationResponse result = apiInstance.updateParticipant(body);
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

### Return type

[**ClientRegistrationResponse**](ClientRegistrationResponse.md)

### Authorization

[RegistrationAccessToken](../README.md#RegistrationAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateProduct"></a>
# **updateProduct**
> PeraProduct updateProduct(productId)

Update a PERA Admin Product

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
try {
    PeraProduct result = apiInstance.updateProduct(productId);
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

### Return type

[**PeraProduct**](PeraProduct.md)

### Authorization

[RegistrationAccessToken](../README.md#RegistrationAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

