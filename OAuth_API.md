# OAuth 2.0 API Documentation

This API implements the OAuth 2.0 Authorization Code Flow with PKCE, fully compliant with FAPI (Financial-grade API) standards, JARM (JWT Secured Authorization Response Mode), and the regulatory requirements of the UK, Australia, and South Korea.

## 1. Authorization Endpoint

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
```

**Parameters:**

| Name                | Required | Description                                                               |
|---------------------|----------|---------------------------------------------------------------------------|
| response_type       | Yes      | Must be `code`                                                            |
| client_id           | Yes      | OAuth client identifier                                                   |
| redirect_uri        | Yes      | Client redirect URI                                                       |
| scope               | Yes      | Space-delimited scopes (e.g., `openid accounts`)                          |
| state               | Yes      | Opaque value to maintain state                                            |
| code_challenge      | Yes      | PKCE code challenge (SHA-256 of code_verifier, base64url-encoded)         |
| code_challenge_method | Yes    | Must be `S256`                                                            |
| nonce               | Yes      | Unique value for replay protection (required for OpenID Connect)          |
| response_mode       | Yes      | Must be `jwt` (enables JARM)                                              |
| request             | Optional | Signed request object (JWT) for FAPI compliance                           |

**Response (JARM):**

On success, the authorization server redirects to `redirect_uri` with a signed JWT (JARM response) as a query parameter:

```
GET {redirect_uri}?response={jwt}&state={state}
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

## 2. Token Endpoint

### POST `/token`

Exchanges the authorization code for tokens.

**Request:**

```http
POST /token
Content-Type: application/x-www-form-urlencoded

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

```json
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

## 3. Token Introspection Endpoint

### POST `/introspect`

Checks the validity of an access token.

**Request:**

```http
POST /introspect
Content-Type: application/x-www-form-urlencoded
Authorization: Basic {client_credentials}

token={access_token}
```

**Response:**

```json
{
  "active": true,
  "scope": "openid accounts",
  "client_id": "client123",
  "exp": 1680000000,
  "sub": "user123"
}
```

---

## 4. Token Revocation Endpoint

### POST `/revoke`

Revokes an access or refresh token.

**Request:**

```http
POST /revoke
Content-Type: application/x-www-form-urlencoded
Authorization: Basic {client_credentials}

token={token}
&token_type_hint=access_token
```

**Response:**

- HTTP 200 with empty body on success.

---

## 5. Example: Accessing a Protected Resource

### GET `/customer/{customer_id}/detail`

Retrieve customer details using a valid access token.

**Request:**

```http
GET /customer/{customer_id}/detail
Authorization: Bearer {access_token}
```

**Response:**

```json
{
  "customer_id": "123456789",
  "name": "Jane Doe",
  "email": "jane.doe@example.com",
  "accounts": [
    {
      "account_id": "987654321",
      "type": "checking",
      "balance": 1000.50
    }
  ]
}
```

---

## Notes

- All endpoints require TLS (HTTPS) and must reject non-FAPI or non-JARM compliant requests.
- Authorization responses from `/auth` are returned as signed (and optionally encrypted) JWTs per [JARM](https://openid.net/specs/oauth-v2-jarm.html).
- Clients must validate JWT signatures, claims, and audience as per JARM and FAPI.
- JWTs (id_token, request object, JARM response) must be signed and validated per FAPI, JARM, and local regulations.
- Error responses follow [RFC 6749](https://tools.ietf.org/html/rfc6749), [OIDC](https://openid.net/specs/openid-connect-core-1_0.html), and JARM specifications.
