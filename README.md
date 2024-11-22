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
| `GET /common/customer` | Get customer information |
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

