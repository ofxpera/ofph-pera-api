# OFxPERA API Documentation

This API implements the OAuth 2.0 Authorization Code Flow as defined in OFxPERA speficiations.
The OFxPERA specifications is based on FAPI (Financial-grade API) standards and the Open Finance requirements of the UK, Australia, and South Korea. It makes use of JAR (JWT Secured Authorization Request), JARM (JWT Secured Authorization Response Mode), and JWE (JSON Web Encryption) standards.

## 1. OAuth 2.0 Authorization Endpoint

### GET `/auth`

Initiates the OAuth 2.0 Authorization Code Flow using JAR (JWT Secured Authorization Request) with JARM (JWT Secured Authorization Response Mode).

**Request:**

```http
GET /auth?request={request_object}

Headers:
  Accept: application/json
  x-fapi-interaction-id: {uuid}
```

**Parameters:**

| Name     | Required | Description                                           |
|----------|----------|-------------------------------------------------------|
| request  | Yes      | Signed request object (JWT) for FAPI compliance       |

**JAR Request Object:**

The `request` parameter contains a signed JWT with the following claims:

```json
{
  "iss": "client123",
  "aud": "https://as.example.com",
  "response_type": "code",
  "client_id": "client123",
  "redirect_uri": "https://client.example.com/callback",
  "scope": "openid accounts",
  "state": "af0ifjsldkj",
  "nonce": "n-0S6_WzA2Mj",
  "response_mode": "jwt",
  "exp": 1680000000,
  "iat": 1679999400,
  "jti": "abcdef-123456"
}
```

**Response:**

Using JARM, the authorization server redirects to the specified `redirect_uri` with a JWT response parameter:

```
GET {redirect_uri}?response={jwt}

Headers:
  x-fapi-interaction-id: {uuid}                 # Echoed if provided in request
  Cache-Control: no-store
  Pragma: no-cache
```

**JARM Response:**

The `response` parameter is a signed and encrypted JWT (Nested JWT) containing:

```json
{
  "iss": "https://as.example.com",
  "aud": "client123",
  "exp": 1680000600,
  "iat": 1679999800,
  "jti": "xyz-789012",
  "state": "af0ifjsldkj",
  "code": "SplxlOBeZQQYbYS6WxSbIA",
  "s_hash": "77QmUPtjPfzWtF2AnpK9RQ"
}
```

The returned authorization code (`code`) is then exchanged for tokens using the token endpoint.

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
&client_assertion_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer
&client_assertion={signed_jwt}
```

**Parameters:**

| Name                  | Required | Description                                                    |
|-----------------------|----------|----------------------------------------------------------------|
| grant_type            | Yes      | Must be `authorization_code`                                   |
| code                  | Yes      | Authorization code from `/auth`                                |
| redirect_uri          | Yes      | Must match the original request                                |
| client_id             | Yes      | OAuth client ID                                                |
| client_assertion_type | Yes      | Must be `urn:ietf:params:oauth:client-assertion-type:jwt-bearer` |
| client_assertion      | Yes      | A signed JWT for client authentication                         |

**Client Assertion JWT Format:**

The client_assertion is a JWT signed by the client's private key with the following claims:

```json
{
  "iss": "{client_id}",                     // Client ID as issuer
  "sub": "{client_id}",                     // Client ID as subject
  "aud": "https://auth.ofxpera.ph/token",   // Token endpoint URL as audience
  "jti": "{unique_identifier}",             // Unique ID for this JWT
  "exp": 1680000000,                        // Expiration time (max 5 minutes from issuance)
  "iat": 1679999700                         // Issued at time
}
```

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
x-fapi-interaction-id: {uuid}

Body:
token={access_token}
&client_id={client_id}
&client_assertion_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer
&client_assertion={signed_jwt}
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

Revokes an access or refresh token using client assertion JWT authentication.

**Request:**

```http
POST /revoke
Content-Type: application/x-www-form-urlencoded
Accept: application/json
x-fapi-interaction-id: {uuid}

Body:
token={token}
&token_type_hint=access_token
&client_id={client_id}
&client_assertion_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer
&client_assertion={signed_jwt}
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

## 7. Refresh Token Flow with Client Assertion

### POST `/token` (Refresh Flow)

Obtains a new access token using a refresh token, with client authentication via JWT assertion.

**Request:**

```http
POST /token
Content-Type: application/x-www-form-urlencoded
Accept: application/json
x-fapi-interaction-id: {uuid}

Body:
grant_type=refresh_token
&refresh_token={refresh_token}
&client_id={client_id}
&client_assertion_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer
&client_assertion={signed_jwt}
```

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
  "refresh_token": "newdef50200...",
  "scope": "openid accounts"
}
```

---

## Notes

- All endpoints require TLS (HTTPS) and must reject non-FAPI, non-JAR, or non-JARM compliant requests.
- Authorization requests to `/auth` can use JAR (JWT Secured Authorization Request) per [JAR](https://datatracker.ietf.org/doc/html/rfc9101).
- Authorization responses from `/auth` must be returned as signed and encrypted JWTs (Nested JWT) per [JARM](https://openid.net/specs/oauth-v2-jarm.html).
- Clients must validate JWT signatures, decryption, claims, and audience as per JAR, JARM, and FAPI.
- JWTs (id_token, request object, JARM response) must be properly secured per FAPI, JAR, JARM, and local regulations.
- Error responses follow [RFC 6749](https://tools.ietf.org/html/rfc6749), [OIDC](https://openid.net/specs/openid-connect-core-1_0.html), JAR, and JARM specifications.
- Only headers required or recommended by the latest FAPI and Open Banking standards are included above (as of 2025): `x-fapi-interaction-id`, `Accept`, `Content-Type`, and `Authorization` (where applicable).

### Client Assertion JWT Requirements:

1. **Signing Algorithm**: Must use asymmetric algorithms (RS256, PS256, ES256, or ES384).
2. **Audience (aud)**: Must match the token endpoint URL.
3. **Issuer (iss) and Subject (sub)**: Must match the client_id.
4. **JWT ID (jti)**: Must be unique for each request to prevent replay attacks.
5. **Expiration (exp)**: Short-lived (max 5 minutes from issuance).
6. **Signing Key**: Must be the private key associated with the public key registered for the client.
7. **Required Claims**: `iss`, `sub`, `aud`, `exp`, `iat`, `jti`.
