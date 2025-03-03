# PeraApi

All URIs are relative to *https://virtserver.swaggerhub.com/maya-ph/OFxPERA-API/0.0.5*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getArrangementStatus**](PeraApi.md#getArrangementStatus) | **GET** /ofxpera/arrangements/{arrangement_id} | Get the status of a PERA arrangement
[**peraArrangementRegistration**](PeraApi.md#peraArrangementRegistration) | **POST** /ofxpera/arrangements | Registers a new PERA arrangement

<a name="getArrangementStatus"></a>
# **getArrangementStatus**
> PeraArrangement getArrangementStatus(arrangementId)

Get the status of a PERA arrangement

API that allows FIs to retrieve the status of one or more PERA Arrangements

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PeraApi;


PeraApi apiInstance = new PeraApi();
String arrangementId = "arrangementId_example"; // String | The ID of the PERA Arrangement
try {
    PeraArrangement result = apiInstance.getArrangementStatus(arrangementId);
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

### Return type

[**PeraArrangement**](PeraArrangement.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="peraArrangementRegistration"></a>
# **peraArrangementRegistration**
> PeraArrangement peraArrangementRegistration()

Registers a new PERA arrangement

API that allows PERA Admins to register the successful creation of one or more new PERA Arrangements

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PeraApi;


PeraApi apiInstance = new PeraApi();
try {
    PeraArrangement result = apiInstance.peraArrangementRegistration();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PeraApi#peraArrangementRegistration");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**PeraArrangement**](PeraArrangement.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

