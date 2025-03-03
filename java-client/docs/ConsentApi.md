# ConsentApi

All URIs are relative to *https://virtserver.swaggerhub.com/maya-ph/OFxPERA-API/0.0.5*

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
> InlineResponse2006 bulkUpdateCustomerConsents(body, customerId)

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

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

ConsentApi apiInstance = new ConsentApi();
ArrangementsBulkupdateBody body = new ArrangementsBulkupdateBody(); // ArrangementsBulkupdateBody | 
String customerId = "customerId_example"; // String | The customer's unique identifier
try {
    InlineResponse2006 result = apiInstance.bulkUpdateCustomerConsents(body, customerId);
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
 **customerId** | **String**| The customer&#x27;s unique identifier |

### Return type

[**InlineResponse2006**](InlineResponse2006.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createBulkConsent"></a>
# **createBulkConsent**
> BulkConsentResponse createBulkConsent(body)

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

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

ConsentApi apiInstance = new ConsentApi();
BulkConsentRequest body = new BulkConsentRequest(); // BulkConsentRequest | 
try {
    BulkConsentResponse result = apiInstance.createBulkConsent(body);
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

### Return type

[**BulkConsentResponse**](BulkConsentResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createConsentArrangement"></a>
# **createConsentArrangement**
> ConsentArrangementResponse createConsentArrangement(body)

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

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

ConsentApi apiInstance = new ConsentApi();
ConsentArrangementRequest body = new ConsentArrangementRequest(); // ConsentArrangementRequest | 
try {
    ConsentArrangementResponse result = apiInstance.createConsentArrangement(body);
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

### Return type

[**ConsentArrangementResponse**](ConsentArrangementResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="extendConsentDuration"></a>
# **extendConsentDuration**
> ConsentArrangementResponse extendConsentDuration(body, arrangementId)

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
String arrangementId = "arrangementId_example"; // String | The ID of the consent arrangement
try {
    ConsentArrangementResponse result = apiInstance.extendConsentDuration(body, arrangementId);
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
 **arrangementId** | **String**| The ID of the consent arrangement |

### Return type

[**ConsentArrangementResponse**](ConsentArrangementResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConsentArrangement"></a>
# **getConsentArrangement**
> ConsentArrangementResponse getConsentArrangement(arrangementId)

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

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

ConsentApi apiInstance = new ConsentApi();
String arrangementId = "arrangementId_example"; // String | The ID of the consent arrangement
try {
    ConsentArrangementResponse result = apiInstance.getConsentArrangement(arrangementId);
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

### Return type

[**ConsentArrangementResponse**](ConsentArrangementResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getConsentHistory"></a>
# **getConsentHistory**
> ConsentHistory getConsentHistory(arrangementId)

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

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

ConsentApi apiInstance = new ConsentApi();
String arrangementId = "arrangementId_example"; // String | The ID of the consent arrangement
try {
    ConsentHistory result = apiInstance.getConsentHistory(arrangementId);
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

### Return type

[**ConsentHistory**](ConsentHistory.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCustomerConsentDashboard"></a>
# **getCustomerConsentDashboard**
> ConsentDashboard getCustomerConsentDashboard(customerId)

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

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

ConsentApi apiInstance = new ConsentApi();
String customerId = "customerId_example"; // String | The customer's unique identifier
try {
    ConsentDashboard result = apiInstance.getCustomerConsentDashboard(customerId);
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

### Return type

[**ConsentDashboard**](ConsentDashboard.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCustomerConsents"></a>
# **getCustomerConsents**
> InlineResponse2005 getCustomerConsents(customerId, status, dataHolderId, purpose)

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

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

ConsentApi apiInstance = new ConsentApi();
String customerId = "customerId_example"; // String | The customer's unique identifier
String status = "status_example"; // String | Filter consents by status
String dataHolderId = "dataHolderId_example"; // String | Filter by specific data holder/institution
String purpose = "purpose_example"; // String | Filter by consent purpose
try {
    InlineResponse2005 result = apiInstance.getCustomerConsents(customerId, status, dataHolderId, purpose);
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
 **status** | **String**| Filter consents by status | [optional] [enum: active, expired, revoked, suspended]
 **dataHolderId** | **String**| Filter by specific data holder/institution | [optional]
 **purpose** | **String**| Filter by consent purpose | [optional]

### Return type

[**InlineResponse2005**](InlineResponse2005.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listConsentArrangements"></a>
# **listConsentArrangements**
> List&lt;ConsentArrangementResponse&gt; listConsentArrangements(status, fromDate, toDate)

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

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

ConsentApi apiInstance = new ConsentApi();
String status = "status_example"; // String | Filter consents by status
OffsetDateTime fromDate = new OffsetDateTime(); // OffsetDateTime | Filter consents created after this date
OffsetDateTime toDate = new OffsetDateTime(); // OffsetDateTime | Filter consents created before this date
try {
    List<ConsentArrangementResponse> result = apiInstance.listConsentArrangements(status, fromDate, toDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#listConsentArrangements");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | **String**| Filter consents by status | [optional] [enum: active, expired, revoked, suspended]
 **fromDate** | **OffsetDateTime**| Filter consents created after this date | [optional]
 **toDate** | **OffsetDateTime**| Filter consents created before this date | [optional]

### Return type

[**List&lt;ConsentArrangementResponse&gt;**](ConsentArrangementResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listConsentTemplates"></a>
# **listConsentTemplates**
> List&lt;ConsentTemplate&gt; listConsentTemplates(category, purpose)

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

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

ConsentApi apiInstance = new ConsentApi();
String category = "category_example"; // String | Filter templates by category
String purpose = "purpose_example"; // String | Filter templates by purpose
try {
    List<ConsentTemplate> result = apiInstance.listConsentTemplates(category, purpose);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#listConsentTemplates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | **String**| Filter templates by category | [optional]
 **purpose** | **String**| Filter templates by purpose | [optional]

### Return type

[**List&lt;ConsentTemplate&gt;**](ConsentTemplate.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="revokeConsentArrangement"></a>
# **revokeConsentArrangement**
> revokeConsentArrangement(arrangementId)

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

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

ConsentApi apiInstance = new ConsentApi();
String arrangementId = "arrangementId_example"; // String | The ID of the consent arrangement to revoke
try {
    apiInstance.revokeConsentArrangement(arrangementId);
} catch (ApiException e) {
    System.err.println("Exception when calling ConsentApi#revokeConsentArrangement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **arrangementId** | **String**| The ID of the consent arrangement to revoke |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateConsentStatus"></a>
# **updateConsentStatus**
> ConsentArrangementResponse updateConsentStatus(body, arrangementId)

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

// Configure OAuth2 access token for authorization: OAuth2
OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
OAuth2.setAccessToken("YOUR ACCESS TOKEN");

ConsentApi apiInstance = new ConsentApi();
ConsentStatusUpdate body = new ConsentStatusUpdate(); // ConsentStatusUpdate | 
String arrangementId = "arrangementId_example"; // String | The ID of the consent arrangement
try {
    ConsentArrangementResponse result = apiInstance.updateConsentStatus(body, arrangementId);
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
 **arrangementId** | **String**| The ID of the consent arrangement |

### Return type

[**ConsentArrangementResponse**](ConsentArrangementResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

