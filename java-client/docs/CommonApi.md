# CommonApi

All URIs are relative to *https://virtserver.swaggerhub.com/maya-ph/OFxPERA-API/0.0.5*

Method | HTTP request | Description
------------- | ------------- | -------------
[**forwardCustomerEndorsement**](CommonApi.md#forwardCustomerEndorsement) | **GET** /common/customers/endorse | Forward customer endorsement
[**getCustomerDetail**](CommonApi.md#getCustomerDetail) | **GET** /common/customers/{customer_id}/detail | Get detailed customer information

<a name="forwardCustomerEndorsement"></a>
# **forwardCustomerEndorsement**
> EndorsementResponse forwardCustomerEndorsement(endorsement)

Forward customer endorsement

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
try {
    EndorsementResponse result = apiInstance.forwardCustomerEndorsement(endorsement);
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

### Return type

[**EndorsementResponse**](EndorsementResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCustomerDetail"></a>
# **getCustomerDetail**
> CustomerInformation getCustomerDetail(customerId)

Get detailed customer information

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
try {
    CustomerInformation result = apiInstance.getCustomerDetail(customerId);
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

### Return type

[**CustomerInformation**](CustomerInformation.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

