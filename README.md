# OFxPERA API

## 4. Endpoints and Sequence Diagrams

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

## 5. Data Model

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
