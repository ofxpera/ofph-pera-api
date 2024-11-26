# OFxPERA API

## 1 Introduction

### 1.1 Overview

The OFxPERA API is a comprehensive set of RESTful APIs designed to facilitate the implementation of the Personal Equity and Retirement Account (PERA) ecosystem in the Philippines. This API suite enables seamless integration between PERA Administrators, Contributors, and other participating financial institutions.

Key features of the OFxPERA API include:
* Secure authentication and authorization using OAuth 2.0
* Standardized HTTP headers for consistent communication
* Comprehensive endpoints for account management, payment processing, and customer information
* Support for admin-initiated account opening and FI-initiated account management
* Robust data models for user profiles and KYC information

This documentation provides detailed specifications for API endpoints, data models, and integration guidelines to help financial institutions implement PERA services effectively.

### 1.2 URL Conventions

The URI structure for API endpoints in the standards MUST implement the following syntax:

`https://{financial-institution}/OFPH/{version}/<namespace>/<Resource>{?query-parameters}`

Example, the endpoint to get customer information would be:

`GET https://api.anybank.ph/ofph/v1/banking/customers/{customer-id}`


## 2 API Design Principles

### 2.1 Authentication and Authorization

The OFxPERA API implements a robust security framework based on OAuth 2.0, OpenID Connect (OIDC), and Financial-grade API (FAPI) standards to ensure secure authentication and authorization.

#### 2.1.1 OAuth 2.0 and OpenID Connect

OAuth 2.0 provides the foundation for secure delegated access, while OpenID Connect adds an identity layer on top of OAuth 2.0. This combination enables:

* **Secure Authentication**: OIDC allows PERA Contributors to authenticate users through their preferred Financial Institution
* **Delegated Authorization**: OAuth 2.0 enables Contributors to obtain limited access to customer's PERA accounts
* **Consent Management**: Explicit user consent for data sharing and account access
* **Token-based Security**: Use of access tokens and refresh tokens for secure API access

#### 2.1.2 Financial-grade API (FAPI)

FAPI extends OAuth 2.0 and OIDC with additional security requirements specifically designed for financial services:

* **Enhanced Security**: 
  - Mandates TLS 1.2 or higher
  - Requires stronger encryption algorithms
  - Implements additional protection against token theft and replay attacks

* **Key Requirements**:
  - Mutual TLS (mTLS) for client authentication
  - Signed requests and responses using JWS
  - Pushed Authorization Requests (PAR)
  - Strong customer authentication (SCA)
  - Protection against CSRF attacks

#### 2.1.3 Implementation Flow

1. **Registration**:
   - Contributors and PERA Administrators must register their OAuth clients
   - Exchange of certificates for mTLS
   - Configuration of redirect URIs and scope permissions

2. **Authentication Flow**:
   ```
   Customer -> PERA Admin -> FI Authorization Server -> Customer Authentication -> Consent -> PERA Admin
   ```

3. **API Access**:
   - Use of access tokens for API calls
   - Token introspection for validation
   - Regular token rotation for security

This security framework ensures:
* Strong customer authentication
* Secure consent management
* Protected API access
* Regulatory compliance
* Standardized integration patterns

### 2.1 Request and Response Payload Structure

Each API request payload MUST have a JSON object at the root level. This object contains the top-level document and MUST contain at least one of the following top-level members:

* `data`: contains the document's primary data
* `errors`: an array of error objects
* `meta`: used to provide additional information such as second factor authorization data, traffic management, and pagination among others

Note that `data` and `errors` MUST NOT coexist in the same document.

A document MAY contain the following additional top-level members:

* `links`: contains a set of URIs referencing the document as a whole
* `included`: an array of resource objects that are related to the primary data

The top-level `links` object MAY contain the following members:

* `self`: a URI that generated the current response document
* `describedby`: a URI to a description document such as OpenAPI or JSON schema

### 2.2 Responses Payloads and Error Handling

#### 2.2.1 HTTP Responses

* All endpoints MUST have HTTP Status codes `200`, `400`, `401`, `403`, `404`, and `500` as defined in the data dictionary
* Relevant endpoints MAY have HTTP status codes `201`, `409` as defined in the data dictionary
* Each API response payload MUST have a JSON object at the root level known as the root object

#### 2.2.2 Successful Responses

If the response is successful (`200 OK`), the root object must follow the Request and Response Payload Structure as defined in this document.

#### 2.2.3 Unsuccessful Responses

If the response is unsuccessful (not `200 OK`), the root object:
* MAY contain an `errors` object (as per the specific endpoint definition)

Error responses MUST contain three tiers of information to support error handling:

* HTTP Status Code - Category of the error that has occurred. See Data Dictionary
* Error Code - Describes the cause of the error. The Data Dictionary defines a standard list of error codes. Where a specific error code MUST be responded, this requirement is stated against the applicable error code or API endpoints
* Description - Human readable message describing the error

The definition of the contents for the `data` object and `meta` object will be defined separately for each endpoint.

### 2.3 Pagination

Each API endpoint that can return multiple records will stipulate whether pagination is supported for the endpoint or not. For endpoints that will return less than a reasonably sized page of results in the majority of circumstances, support for paging may not be included.

Note that the use of paging for an endpoint does not require or preclude the use of filtering query parameters. It is expected that filtering and paging will be applied independently of each other.

#### 2.3.1 Pagination Links

If the endpoint supports pagination, the following elements MUST be returned by the server in the `links` object:

* `first`: The first page of the data set. Mandatory if this response is not the first page
* `last`: The last page of the data set. Mandatory if this response is not the last page
* `prev`: The previous page. Mandatory if this response is not the first page
* `next`: The following page in the data set. Mandatory if this response is not the last page

The `meta` object MAY contain the following:

* `total-records`: The total number of records in the set
* `total-pages`: The total number of pages in the set
* If `total-records` is 0, `total-pages` MUST be 0

For each of these fields, the page size specified in the request should be assumed when calculating values.

#### 2.3.2 Pagination Query Parameters

When pagination is supported, the consumer MAY provide the following query parameters:

* `page`: the page number being requested (with the first page being 1)
* `page-size`: the number of records to return in each page

If the query parameters are not provided the following defaults will be assumed:

* `page`: a default of 1 (the first page) will be assumed
* `page-size`: a default of 25 will be assumed

## 3 HTTP Headers

Supported HTTP headers, and their usage, for the standards are as laid out in the following sections.

### 3.1 Open Finance Request and Response Headers

| Header Field | Description | Mandatory? |
|--------------|-------------|------------|
| participant-id | Field referencing the unique identifier of the requesting participant. | Mandatory |
| x-v | Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable. | Mandatory |
| x-fapi-interaction-id | An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. | Conditional |
| x-fapi-auth-date | The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. | Mandatory |
| x-fapi-customer-ip-address | The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. | Mandatory |
| x-client-headers | The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. | Optional |

### 3.2 Industry Standard Headers

| Header Field | Description | Mandatory? |
|--------------|-------------|------------|
| ContentType | Standard HTTP Header. Represents the format of the payload provided in the request. The media type must be set to application/json. Mandatory for PUT and POST calls. | Conditional |
| Retry-After | Field indicating the time (in seconds) that the client should wait before retrying an operation. The response should include this header along with responses with the HTTP status code of 429 Too many requests. | Optional |
| Accept | If specified, the media type must be set to application/json, unless otherwise specified in the resource endpoint standard. If set to an unacceptable value the holder must respond with a 406 Not Acceptable. If not specified, or a wildcard (*/*) is provided, the default media type is application/json. | Optional |

## 4 Endpoints and Sequence Diagrams

### 4.1 Namespace

The following namespaces will be used for the OFxPERA pilot:

| Industry | Description |
|----------|-------------|
| Admin | This namespace will be used to register and retrieve CORS URIs by all participants |
| OAuth | APIs for authentication, authorization and consent management |
| Common | APIs that are used across different industries and various use cases (e.g., consent and customer information) |
| Banking | All banking-related use cases under the OFxPERA project |

### 4.2 OFxPERA APIs

#### 4.2.1 Admin

CORS URI endpoints:

| API | Description |
|-----|-------------|
| `POST /admin/organization` | API for registering a participating organization's URIs |
| `GET /admin/organization` | API for retrieving all registered organization URIs |
| `GET /admin/organization/{id}/certificate` | API for retrieving a registered organization's certificate |

#### 4.2.2 OAuth

Customer Authentication, Authorization and Consent Management:

| API | Description |
|-----|-------------|
| `POST /oauth/par` | OAuth Push Authorization Request |
| `GET /oauth/authorize` | Authorization endpoint |
| `POST /oauth/token` | Token endpoint |
| `GET /oauth/introspection` | Token introspection endpoint |
| `GET /oauth/userinfo` | User information endpoint |

#### 4.2.3 Common API Endpoints

| API | Description |
|-----|-------------|
| `GET /common/consent/{id}` | API for retrieving the latest consent information provided to the calling entity by the data provider |
| `POST /common/consent` | Create consent |
| `PUT /common/consent/{id}` | Update consent |
| `DELETE /common/consent/{id}` | API for revoking a previously provided consent |
| `GET /common/customer` | Get customer's Personal Information as defined in section 5.2.3 |
| `GET /common/customer/{id}/detail` | Get detailed customer information |

#### 4.2.4 Banking (OFxPERA Use Cases) API Endpoints

##### 4.2.4.1 Admin-Initiated Account Opening

| API | Description |
|-----|-------------|
| `GET /banking/account` | API for retrieving information about the customer's source account from their preferred FI. Used in account linking and similar use cases |

##### 4.2.4.2 FI-Initiated Account Management

| API | Description |
|-----|-------------|
| `GET /banking/products` | API for retrieving list of PERA products the customer could subscribe to |
| `POST /banking/accounts` | Create banking account |
| `GET /banking/accounts` | Get banking accounts |
| `GET /banking/accounts/{id}` | Get specific banking account |
| `GET /banking/account/{id}/transactions` | Get account transactions |
| `GET /banking/account/{id}/transactions/{id}` | Get specific transaction |

##### 4.2.4.3 Payment Initiation

| API | Description |
|-----|-------------|
| `POST /banking/payments` | API for initiating a payment (money movement) transaction |
| `GET /banking/payments/{id}` | API for retrieving and validating payment status and other details |
| `DELETE /banking/payments/{id}` | Cancel payment |
| `GET /banking/payments` | Get payments |

## 5 Data Model

### 5.1 User Profile

| Field | Type | Description |
|-------|------|-------------|
| sub | String | Subject - Identifier for the End-User at the Issuer. |
| name | String | End-User's full name in displayable form including all name parts, possibly including titles and suffixes, ordered according to the End-User's locale and preferences. |
| given_name | String | |
| middle_name | String | |
| last_name | String | |
| nickname | String | Shorthand name by which the End-User wishes to be referred to at the RP, such as janedoe or j.doe. |
| profile | URL | URL of the End-User's profile page. The contents of this Web page SHOULD be about the End-User. |
| picture | URL | URL of the End-User's profile picture |
| phone_number | String | Format: 63287654321 |
| phone_number_verified | Boolean | |
| email | String | |
| email_verified | Boolean | |
| gender | Enum | |
| birthdate | String | Format YYYY-MM-DD |
| updated_at | Number | Time the End-User's information was last updated. Its value is a JSON number representing the number of seconds from 1970-01-01T00:00:00Z as measured in UTC until the date/time. |

### 5.2 KYC Information

#### 5.2.1 Address Data Type

| Data Element | Data Type | Max Length | Mandatory? | Notes |
|--------------|-----------|------------|------------|--------|
| region | String | 10 | Mandatory | PSGC Code |
| province | String | 10 | Mandatory | PSGC Code |
| city | String | 10 | Mandatory | PSGC Code |
| barangay | String | 10 | | PSGC Code |
| street_adress | String | 200 | | |
| country | String | 3 | Mandatory | ISO 3166 Code |
| postal_code | String | 10 | Mandatory | |

#### 5.2.2 Identification Data Type

| Data Element | Data Type | Max Length | Mandatory? | Notes |
|--------------|-----------|------------|------------|--------|
| id_number | String | 50 | Mandatory | |
| id_expiry_date | String | 10 | Optional | Format is YYYY-MM-DD |
| id_type | Enum | 100 | Mandatory | Need info on the possible values ID Type (String: "Drivers License", "Passport", etc.) |

#### 5.2.3 Personal Information

| Data Element | Data Type | Max Length | Mandatory? | Notes |
|--------------|-----------|------------|------------|--------|
| sub | String | 50 | Mandatory | Subject – FI’s unique identifier for the End-User. |
| title | String | 50 | Optional | |
| given_name | String | 50 | Mandatory | |
| middle_name | String | 50 | Optional | |
| last_name | String | 50 | Mandatory | |
| suffix | String | 10 | Optional | |
| phone_number | String | 15 | Optional | Format: 63287654321 |
| mobile_number | String | 15 | Mandatory | Format: 639171234567 |
| email | String | 50 | Mandatory | |
| birthdate | String | 10 | Mandatory | Format YYYY-MM-DD |
| nationality | String | 3 | Mandatory | ISO 3166 Code |
| tin | String | 15 | Optional | Format NNN-NNN-NNN-000 |
| presented_ids | [IdType] | | Mandatory | Array of identification details |
| cdd | cddType | | Optional | |
| pera_admin | String | 50 | Mandatory | Selected PERA Admin by Customer FI Codes of PERA admin can be obtained via an API |

#### 5.2.4 Customer Due Diligence Data Type

| Data Element | Data Type | Max Length | Mandatory? | Notes |
|--------------|-----------|------------|------------|--------|
| employment_status | String | 50 | Mandatory | |
| occupation | String | 150 | Optional | |
| nature_of_work | String | 10 | Optional | PSIC Code |
| employer_name | String | 255 | Optional | |
| employer_address | Address | | Optional | |
| pep_indicator | Boolean | | Mandatory | Politically Exposed Person 1 - True; 0 - False |
| fund_source | String | 100 | Mandatory | Source of Funds |
| cdd_indicator | String | 6 | Mandatory | Need more info on the possible values Low; Normal; High |

### 5.3 Organization

The organization data model represents a participating institution in the PERA ecosystem.

| Data Element | Data Type | Mandatory? | Description |
|--------------|-----------|------------|-------------|
| organizationId | String | Mandatory | Unique identifier assigned to the organization |
| organizationName | String | Mandatory | Trading name of the organization |
| organizationType | Enum | Mandatory | Type of organization in the PERA ecosystem. Values: `PERA_ADMIN`, `CONTRIBUTOR_INSTITUTION` |
| registeredName | String | Mandatory | Legal registered name of the organization |
| registeredOfficeAddress | Address | Mandatory | Registered office address using the Address data type |
| businessAddress | Address | Mandatory | Primary business address using the Address data type |
| contactDetails | Object | Mandatory | Organization contact information |
| contactDetails.email | String | Mandatory | Primary contact email address |
| contactDetails.phone | String | Mandatory | Primary contact phone number |
| contactDetails.website | String | Optional | Organization's website URL |
| authorizationServers | Array | Mandatory | List of authorization server configurations |
| authorizationServers[].baseUrl | String | Mandatory | Base URL of the authorization server |
| authorizationServers[].description | String | Optional | Description of the authorization server's purpose |

#### Example Organization Payload
```json
{
  "organizationId": "org123",
  "organizationName": "Sample Bank",
  "organizationType": "CONTRIBUTOR_INSTITUTION",
  "registeredName": "Sample Bank Corporation",
  "registeredOfficeAddress": {
    "region": "130000000",
    "province": "133900000",
    "city": "133902000",
    "street_address": "123 Main Street",
    "country": "PHL",
    "postal_code": "1234"
  },
  "businessAddress": {
    "region": "130000000",
    "province": "133900000",
    "city": "133902000",
    "street_address": "456 Business Avenue",
    "country": "PHL",
    "postal_code": "1234"
  },
  "contactDetails": {
    "email": "contact@samplebank.com",
    "phone": "6328123456",
    "website": "https://www.samplebank.com"
  },
  "authorizationServers": [
    {
      "baseUrl": "https://auth.samplebank.com",
      "description": "Primary authorization server"
    }
  ]
}
