# DiscoveryApi

All URIs are relative to *https://virtserver.swaggerhub.com/voyager-innovation/OFxPERA/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteClientRegistration**](DiscoveryApi.md#deleteClientRegistration) | **DELETE** /.well-known/openid-registration | Delete Client Registration (configurable endpoint)
[**getClientRegistration**](DiscoveryApi.md#getClientRegistration) | **GET** /.well-known/openid-registration | Get Client Registration (configurable endpoint)
[**getJwks**](DiscoveryApi.md#getJwks) | **GET** /.well-known/jwks.json | [PHASE 1] Retrieve JSON Web Key Set (JWKS) containing public keys for JWT signature verification (configurable endpoint)
[**getOpenIdConfiguration**](DiscoveryApi.md#getOpenIdConfiguration) | **GET** /.well-known/openid-configuration | Optional - OpenID Connect Discovery
[**registerClient**](DiscoveryApi.md#registerClient) | **POST** /.well-known/openid-registration | [PHASE 2] Dynamic Client Registration (configurable endpoint)
[**updateClientRegistration**](DiscoveryApi.md#updateClientRegistration) | **PUT** /.well-known/openid-registration | [PHASE 2] Update Client Registration (configurable endpoint)

<a name="deleteClientRegistration"></a>
# **deleteClientRegistration**
> deleteClientRegistration()

Delete Client Registration (configurable endpoint)

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DiscoveryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


DiscoveryApi apiInstance = new DiscoveryApi();
try {
    apiInstance.deleteClientRegistration();
} catch (ApiException e) {
    System.err.println("Exception when calling DiscoveryApi#deleteClientRegistration");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getClientRegistration"></a>
# **getClientRegistration**
> ClientRegistration getClientRegistration()

Get Client Registration (configurable endpoint)

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DiscoveryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


DiscoveryApi apiInstance = new DiscoveryApi();
try {
    ClientRegistration result = apiInstance.getClientRegistration();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DiscoveryApi#getClientRegistration");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ClientRegistration**](ClientRegistration.md)

### Authorization

[RegistrationAccessToken](../README.md#RegistrationAccessToken)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getJwks"></a>
# **getJwks**
> JWKSet getJwks()

[PHASE 1] Retrieve JSON Web Key Set (JWKS) containing public keys for JWT signature verification (configurable endpoint)

Returns the public keys used to verify JWT signatures

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DiscoveryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


DiscoveryApi apiInstance = new DiscoveryApi();
try {
    JWKSet result = apiInstance.getJwks();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DiscoveryApi#getJwks");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**JWKSet**](JWKSet.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getOpenIdConfiguration"></a>
# **getOpenIdConfiguration**
> InlineResponse2002 getOpenIdConfiguration()

Optional - OpenID Connect Discovery

Retrieve OpenID Connect configuration information

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DiscoveryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


DiscoveryApi apiInstance = new DiscoveryApi();
try {
    InlineResponse2002 result = apiInstance.getOpenIdConfiguration();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DiscoveryApi#getOpenIdConfiguration");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="registerClient"></a>
# **registerClient**
> ClientRegistrationResponse registerClient(body)

[PHASE 2] Dynamic Client Registration (configurable endpoint)

Register a new OFxPERA Participant as an OAuth client following FAPI Dynamic Client Registration requirements.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DiscoveryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


DiscoveryApi apiInstance = new DiscoveryApi();
ClientRegistration body = new ClientRegistration(); // ClientRegistration | 
try {
    ClientRegistrationResponse result = apiInstance.registerClient(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DiscoveryApi#registerClient");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ClientRegistration**](ClientRegistration.md)|  |

### Return type

[**ClientRegistrationResponse**](ClientRegistrationResponse.md)

### Authorization

[SignedJWT](../README.md#SignedJWT)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateClientRegistration"></a>
# **updateClientRegistration**
> ClientRegistration updateClientRegistration(body)

[PHASE 2] Update Client Registration (configurable endpoint)

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DiscoveryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


DiscoveryApi apiInstance = new DiscoveryApi();
ClientRegistration body = new ClientRegistration(); // ClientRegistration | 
try {
    ClientRegistration result = apiInstance.updateClientRegistration(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DiscoveryApi#updateClientRegistration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ClientRegistration**](ClientRegistration.md)|  |

### Return type

[**ClientRegistration**](ClientRegistration.md)

### Authorization

[RegistrationAccessToken](../README.md#RegistrationAccessToken)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

