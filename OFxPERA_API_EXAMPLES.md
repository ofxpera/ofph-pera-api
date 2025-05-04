# OFxPERA API Documentation

This API implements the OAuth 2.0 Authorization Code Flow as defined in OFxPERA speficiations.
The OFxPERA specifications is based on FAPI (Financial-grade API) standards and the regulatory requirements of the UK, Australia, and South Korea. It makes use of JARM (JWT Secured Authorization Response Mode) and JWE (JSON Web Encryption) standards.

## 1. OAuth 2.0 Authorization Endpoint

### GET `/auth`

Initiates the OAuth 2.0 Authorization Code Flow using JARM (JWT Secured Authorization Response Mode).

**Request:**

```http
GET /auth?response_type=code
    &client_id={client_id}
    &redirect_uri={redirect_uri}
    &scope={scopes}
    &state={state}
    &code_challenge={code_challenge}
    &code_challenge_method=S256
    &nonce={nonce}
    &response_mode=jwt
    &request={request_object}

Headers:
  Accept: application/jwt
  x-fapi-interaction-id: {uuid}                 # Recommended for correlation
```

**Parameters:**

| Name              | Required | Description                                                       |
|-------------------|----------|-------------------------------------------------------------------|
| response_type     | Yes      | Must be `code`                                                    |
| client_id         | Yes      | OAuth client identifier                                           |
| redirect_uri      | Yes      | Client redirect URI                                               |
| scope             | Yes      | Space-delimited scopes (e.g., `openid accounts`)                  |
| state             | No       | Opaque value to maintain state                                    |
| code_challenge    | No       | PKCE code challenge (SHA-256 of code_verifier, base64url-encoded) |
| code_challenge_method | No   | Must be `S256` (required for public clients)                      |
| nonce             | No       | Unique value for replay protection (required for OpenID Connect)  |
| response_mode     | Yes      | Must be `jwt` (enables JARM)                                      |
| request           | Optional | Signed request object (JWT) for FAPI compliance                   |

**Response (JARM):**

On success, the authorization server redirects to `redirect_uri` with a signed JWT (JARM response) as a query parameter:

```
GET {redirect_uri}?response={jwt}&state={state}

Headers:
  x-fapi-interaction-id: {uuid}                 # Echoed if provided in request
  Cache-Control: no-store
  Pragma: no-cache
```

Where `response` is a JWT containing the authorization code and other parameters, signed (and optionally encrypted) by the authorization server.

**Example JARM Success JWT Payload:**

```json
{
  "iss": "https://as.example.com",
  "aud": "client123",
  "exp": 1680000000,
  "iat": 1679999400,
  "code": "SplxlOBeZQQYbYS6WxSbIA",
  "state": "af0ifjsldkj",
  "scope": "openid accounts"
}
```

**Example JARM Error JWT Payload:**

```json
{
  "iss": "https://as.example.com",
  "aud": "client123",
  "exp": 1680000000,
  "iat": 1679999400,
  "error": "access_denied",
  "error_description": "The resource owner denied the request.",
  "state": "af0ifjsldkj"
}
```

---

## 2. OAuth 2.0 Token Endpoint

### POST `/token`

Exchanges the authorization code for tokens.

**Request:**

```http
POST /token
Content-Type: application/x-www-form-urlencoded
Accept: application/json
x-fapi-interaction-id: {uuid}

Body:
grant_type=authorization_code
&code={code}
&redirect_uri={redirect_uri}
&client_id={client_id}
&code_verifier={code_verifier}
```

**Parameters:**

| Name          | Required | Description                          |
|---------------|----------|--------------------------------------|
| grant_type    | Yes      | Must be `authorization_code`         |
| code          | Yes      | Authorization code from `/auth`      |
| redirect_uri  | Yes      | Must match the original request      |
| client_id     | Yes      | OAuth client ID                      |
| code_verifier | Yes      | Original PKCE code verifier          |

**Response:**

```http
HTTP/1.1 200 OK
Content-Type: application/json
Cache-Control: no-store
Pragma: no-cache
x-fapi-interaction-id: {uuid}

{
  "access_token": "eyJraWQiOiJ...",
  "token_type": "Bearer",
  "expires_in": 3600,
  "refresh_token": "def50200...",
  "id_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",
  "scope": "openid accounts"
}
```

---

## 3. Optional Token Introspection Endpoint

### POST `/introspect`

Checks the validity of an access token.

**Request:**

```http
POST /introspect
Content-Type: application/x-www-form-urlencoded
Accept: application/json
Authorization: Basic {client_credentials}
x-fapi-interaction-id: {uuid}

Body:
token={access_token}
```

**Response:**

```http
HTTP/1.1 200 OK
Content-Type: application/json
x-fapi-interaction-id: {uuid}

{
  "active": true,
  "scope": "openid accounts",
  "client_id": "client123",
  "exp": 1680000000,
  "sub": "user123"
}
```

---

## 4. Optional Token Revocation Endpoint

### POST `/revoke`

Revokes an access or refresh token.

**Request:**

```http
POST /revoke
Content-Type: application/x-www-form-urlencoded
Accept: application/json
Authorization: Basic {client_credentials}
x-fapi-interaction-id: {uuid}

Body:
token={token}
&token_type_hint=access_token
```

**Response:**

```http
HTTP/1.1 200 OK
x-fapi-interaction-id: {uuid}

(empty body)
```

---

## 5. Example: Retrieving Customer Information

### GET `/customers/{customer_id}/detail`

Retrieve customer details using a valid access token. The response is a JWE (JSON Web Encryption) as per FAPI and Open Banking requirements.

**Request:**

```http
GET /customers/{customer_id}/detail
Authorization: Bearer {access_token}
Accept: application/jose
x-fapi-interaction-id: {uuid}
```

**Response:**

```http
HTTP/1.1 200 OK
Content-Type: application/jose
x-fapi-interaction-id: {uuid}

<encrypted JWE payload>

// Example JWE Compact Serialization (truncated)
eyJhbGciOiJSU0EtT0FFUCIsImVuYyI6IkExMjhHQ00ifQ...<encrypted_content>
```

- The response body is a JWE, which must be decrypted by the client using its private key.
- The decrypted payload will contain the following structure (based on the OpenAPI specification):

```json
{
  "sub": "user-123",
  "arrangementId": "arr-456",
  "personalInformation": {
    "sub": "user-123",
    "title": "Ms",
    "givenName": "Jane",
    "middleName": "A.",
    "lastName": "Doe",
    "suffix": "Jr.",
    "phoneNumber": "63287654321",
    "mobileNumber": "639171234567",
    "email": "jane.doe@example.com",
    "birthdate": "1990-01-01",
    "nationality": "PHL",
    "residentialAddress": {
      "line1": "#357 Barbie's Townhouse",
      "line2": "Yakal Street cor Lawaan Street",
      "barangay": "Santo Niño",
      "city": "Tanay",
      "province": "Rizal",
      "region": "Region IV-A (CALABARZON)",
      "postalCode": "1635",
      "country": "PHL"
    },
    "tin": "123-456-789-000"
  },
  "presentedIds": [
    {
      "idType": "PASSPORT",
      "idNumber": "A1234567"
    }
  ],
  "cdd": {
    "status": "PASSED",
    "lastChecked": "2024-12-31"
  },
  "peraAdmin": "admin-789"
}
```

---

## 6. Example: Registering a PERA Arrangement

### POST `/ofxpera/arrangements`

Registers the result of a PERA account opening. The request and response use JWE (JSON Web Encryption).

**Request:**

```http
POST /ofxpera/arrangements
Authorization: Bearer {access_token}
Content-Type: application/jose
Accept: application/jose
x-fapi-interaction-id: {uuid}
x-idempotency-key: {idempotency-uuid}

<encrypted JWE payload>

// Example decrypted payload
{
  "id": "arr-001",
  "adminId": "admin-123",
  "customerId": "cust-456",
  "sub": "user-789",
  "consentId": "consent-abc",
  "status": "active",
  "creationDate": "2025-05-01T10:00:00Z"
}
```

**Response:**

```http
HTTP/1.1 201 Created
Content-Type: application/jose
x-fapi-interaction-id: {uuid}

<encrypted JWE payload>

// Example decrypted payload
{
  "id": "arr-001"
}
```

- Both request and response bodies are JWE payloads, which must be encrypted/decrypted by the client and server accordingly.
- The response contains the unique identifier of the registered PERA arrangement.

---
## Notes

- All endpoints require TLS (HTTPS) and must reject non-FAPI or non-JARM compliant requests.
- Authorization responses from `/auth` are returned as signed (and optionally encrypted) JWTs per [JARM](https://openid.net/specs/oauth-v2-jarm.html).
- Clients must validate JWT signatures, claims, and audience as per JARM and FAPI.
- JWTs (id_token, request object, JARM response) must be signed and validated per FAPI, JARM, and local regulations.
- Error responses follow [RFC 6749](https://tools.ietf.org/html/rfc6749), [OIDC](https://openid.net/specs/openid-connect-core-1_0.html), and JARM specifications.
- Only headers required or recommended by the latest FAPI and Open Banking standards are included above (as of 2025): `x-fapi-interaction-id`, `Accept`, `Content-Type`, and `Authorization` (where applicable).
