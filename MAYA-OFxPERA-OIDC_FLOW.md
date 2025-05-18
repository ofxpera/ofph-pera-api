# Admin-initiated OFxPERA Onboarding Authorization Flow

_**(OAuth 2.0 and OpenID Connect Authorization Flow for Protected API Access)**_

This document describes the end-to-end authorization flow using OAuth 2.0 and OpenID Connect (OIDC) to access protected resources in Maya's OFxPERA dev/test implementation, specifically focusing on the `GET /common/customers/{customer_id}/detail` and `POST /ofxpera/arrangements` endpoints.

## Overview

The flow involves two main components:

1. **Keycloak Identity Server**: Handles authentication and authorization
   - Public Endpoint: `dev-admin-server.mayabank.xyz`
   - Private Endpoint: `dev-auth-server.mayabank.xyz` (mTLS-enabled)

2. **Resource Server API**: Provides secure access to customer data
   - API Endpoint: `dev-ofph-api.mayabank.xyz`

## Architecture Diagram

```mermaid
sequenceDiagram
    participant Client as Third-Party Client
    participant User as User Agent
    participant KC as Keycloak (dev-admin-server.mayabank.xyz)
    participant API as Protected API Gateway (dev-ofph-api.mayabank.xyz)
    participant Lambda as Lambda Function
    participant DynamoDB as DynamoDB

    Note over Client,DynamoDB: 1. Client Registration (One-time setup)
    Client->>KC: Register client application
    KC-->>Client: Client ID, Client Secret, JWKS URL

    Note over Client,DynamoDB: 2. User Authorization Flow
    Client->>User: Redirect to authorization endpoint
    User->>KC: Authenticate (username/password)
    KC->>User: Authorization code
    User->>Client: Redirect with authorization code
    Client->>KC: Exchange code for tokens (with or w/o mTLS)
    KC-->>Client: Access token, ID token, Refresh token

    Note over Client,DynamoDB: 3. Protected Resource Access
    Client->>API: Request with mTLS + Access token
    API->>API: Validate client certificate (mTLS)
    API->>API: Validate JWT token (JWT Authorizer)
    API->>Lambda: Forward authenticated request
    Lambda->>KC: Validate token & get client definition
    KC-->>Lambda: Token validation result & JWKS URL
    Lambda->>DynamoDB: Query customer data
    DynamoDB-->>Lambda: Customer information
    Lambda->>Lambda: Encrypt response with JWE (optional)
    Lambda-->>API: Return encrypted/unencrypted response
    API-->>Client: Customer data (JWE encrypted or JSON)
```

## Detailed Process Flow

### 1. Client Registration (One-time Setup)

Before a third-party client application can access protected resources, it must be registered with the Keycloak server:

1. **Client Registration**:
   - The client system is registered with Keycloak through the admin console or registration API at `https://dev-admin-server.mayabank.xyz/admin/mayabank/console/`
   - Client system is registered with its redirect URIs, JWKS URI, grant types, and other OAuth configuration
   - Client is configured to use the auth code flow, implicit flow and direct access grants are disabled.

2. **Client Configuration**:
   - Keycloak clients are configured to use Signed JWT for authentication
   - Client configures its JWKS endpoint to expose its public key for JWE encryption
   - Client stores the Keycloak server's token endpoint and authorization endpoint URLs:
     - Authorization Endpoint: `https://dev-admin-server.mayabank.xyz/realms/mayabank/protocol/openid-connect/auth`
     - Token Endpoint: `https://dev-admin-server.mayabank.xyz/realms/mayabank/protocol/openid-connect/token`

3. **Certificate Setup for mTLS**:
   - Client obtains a client certificate from a trusted Certificate Authority (CA)
   - The client's CA certificate must be added to the API Gateway's truststore
   - Client configures its TLS client to use this certificate for API calls to `https://dev-ofph-api.mayabank.xyz`

### 2. User Authorization Flow (OAuth 2.0 Authorization Code Flow)

When a user needs to authorize the third-party application to access their data:

1. **Authorization Request**:
   - Client redirects the user to Keycloak's authorization endpoint:
     - JAR (JWT-Secured Authorization Requests) is preferred but PKCE is also supported
     - Example JAR API Call
        ```
        https://dev-admin-server.mayabank.xyz/realms/mayabank/protocol/openid-connect/auth
        ?client_id=client123
        &request=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InNlcnZpY2Utb25lX25nZmluX25ldC0yMDI1MDMzMCJ9.eyJjbGllbnRfaWQiOiJzZXJ2aWNlLW9uZS1uZ2ZpbiIsInN0YXRlIjoiODYwN2QzM2MtMzcwYi00NTRhLWI0MDAtMjkyNDcxNzBkM2U5IiwicmVzcG9uc2VfdHlwZSI6ImNvZGUiLCJyZXNwb25zZV9tb2RlIjoiand0Iiwic2NvcGUiOiJvcGVuaWQgcHJvZmlsZSBiYW5rX2FjY291bnQgYWRkcmVzcyIsInJlZGlyZWN0X3VyaSI6Imh0dHBzOi8vc2VydmljZS1vbmUubmdmaW4ubmV0L29hdXRoLXJlZGlyZWN0IiwiYXVkIjoiaHR0cHM6Ly9vcGVuZmluYW5jZS1waWxvdC1hdXRoLm1heWFiYW5rLnh5ei9yZWFsbXMvbWF5YWJhbmsiLCJpc3MiOiJzZXJ2aWNlLW9uZS1uZ2ZpbiIsImlhdCI6MTc0NzU0Nzk0OCwiZXhwIjoxNzQ3NTQ4MjQ4LCJqdGkiOiIxNzQ3NTQ3OTQ4NjI1LTNkYjFkZWJlMmQwNWIyM2YifQ.mvqMHCWKYvhCi5GLpsYNqMSE-bejvGUTaCC2kFEv0hjG4-9998KGDt8t3J1lFjjbcXikn1BEm0ZqJTNa3OLk5djUBDbee8MO9PclQQQTmrmPRAggsCE8LvO4A_0r_ExyKZnCEcYw8nS14RZ_cT631cqUhlLFrU8hNH1IGT1TMpZ85kb90MrhUpcJJd3Md9cpWOcyOUYViI0KO9jBcpO8WVfyQIcFBdmkaxHWSAGfdGT5KGKg5rUzGTkivJ9MNNoN6nF_7zauLum1huzbNBAUruZzbxMzuCqR25imR1-_bfi57YNRyFIJdcMK2eQSU0YxolPNu2v_xqpO-zXc2b0MfA
        ```
     - Example JSON Payload embedded within the JAR request
       ```json
       {
         "client_id": "service-one-ngfin",
         "state": "44ef2727-6f88-43f4-94db-959321c550d3",
         "response_type": "code",
         "response_mode": "jwt",
         "scope": "openid profile bank_account address",
         "redirect_uri": "https://service-one.ngfin.net/oauth-redirect",
         "aud": "https://openfinance-pilot-auth.mayabank.xyz/realms/mayabank",
         "iss": "service-one-ngfin",
         "iat": 1747548473,
         "exp": 1747548773,
         "jti": "1747548473117-b89986f48f584074"
       }
       ```
     - PKCE API Call
        ```
        https://dev-admin-server.mayabank.xyz/realms/mayabank/protocol/openid-connect/auth
        ?client_id=client123
        &response_type=code
        &scope=openid profile
        &redirect_uri=https://client-app.com/callback
        &state=random-state-string
        &code_challenge=SHA256-code-challenge
        &code_challenge_method=S256
        ```

2. **User Authentication**:
   - User authenticates with Keycloak using their credentials
   - Keycloak validates the user's identity

3. **Authorization Grant**:
   - User consents to the requested scopes
   - Keycloak redirects back to the client's redirect URI with an authorization code embedded in a JARM (JWT-Secured Authorization Response Mode) response:
    ```
    https://client-app.com/callback
    ?response=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Imp3dF9zaWdfMSJ9.eyJpc3MiOiJodHRwczovL2Rldi1hZG1pbi1zZXJ2ZXIubWF5YWJhbmsueHl6L3JlYWxtcy9tYXlhYmFuayIsImF1ZCI6ImNsaWVudDEyMyIsImV4cCI6MTcwMDAwMDAwMCwiaWF0IjoxNjAwMDAwMDAwLCJjb2RlIjoiYXV0aG9yaXphdGlvbi1jb2RlIiwic3RhdGUiOiJyYW5kb20tc3RhdGUtc3RyaW5nIn0.signature
    ```

4. **Token Exchange**:
   - Client exchanges the authorization code for tokens using client authentication with a signed JWT:
      ```http
      POST /realms/mayabank/protocol/openid-connect/token HTTP/1.1
      Host: dev-admin-server.mayabank.xyz
      Content-Type: application/x-www-form-urlencoded

      grant_type=authorization_code
      &code=authorization-code
      &client_id=client123
      &site=ofxpera
      &client_assertion_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer
      &client_assertion=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImNsaWVudDEyMy1rZXkifQ.eyJpc3MiOiJjbGllbnQxMjMiLCJzdWIiOiJjbGllbnQxMjMiLCJhdWQiOiJodHRwczovL2Rldi1hZG1pbi1zZXJ2ZXIubWF5YWJhbmsueHl6L3JlYWxtcy9tYXlhYmFuay9wcm90b2NvbC9vcGVuaWQtY29ubmVjdC90b2tlbiIsImp0aSI6ImEtMTIzLXJhbmRvbS1qdGktdmFsdWUiLCJleHAiOjE3MDAwMDAwMDAsImlhdCI6MTYwMDAwMDAwMH0.signature
      &redirect_uri=https://client-app.com/callback
      ```

5. **Token Response**:
   - Keycloak returns access token, ID token, and refresh token:
     ```json
     {
       "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",
       "id_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",
       "refresh_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",
       "token_type": "Bearer",
       "expires_in": 7243,
       "refresh_expires_in": 7243,
       "session_state": "8e570afb-3ba3-4411-8f98-f5bf716658ab",
       "scope": "bank_account profile openid email address"
     }
     ```

### 3. Protected Resource Access

Once the client has obtained an access token, it can access the protected resource:

1. **API Request with mTLS and JWT**:
   - Client establishes a TLS connection with the API Gateway using its client certificate
   - Client includes the access token in the Authorization header:
     ```http
     GET /common/customers/123456/detail HTTP/1.1
     Host: api.mayabank.xyz
     Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...
     ```

2. **mTLS Authentication**:
   - API Gateway validates the client certificate against its truststore
   - If the certificate is invalid or not trusted, the request is rejected with a TLS error

3. **JWT Authorization**:
   - API Gateway's JWT Authorizer validates the token's signature, expiration, and claims
   - If the token is invalid, the request is rejected with a 401 Unauthorized response

4. **Lambda Function Processing**:
   - The request is forwarded to the GetCustomerDetailHandler Lambda function
   - Lambda extracts the customer_id from the path parameters
   - Lambda validates the presence of the Access Token
   - Lambda validates the expiration and subject of the token (if TOKEN_VALIDATION_ENABLED is true)
   - Lambda validates the access token with Keycloak's introspection endpoint (if TOKEN_INTROSPECTION_ENABLED is true)
   - Lambda retrieves the customer information from DynamoDB

5. **Response Encryption (Optional)**:
   - If RESPONSE_ENCRYPTION_ENABLED is true:
     - Lambda extracts the client ID from the access token
     - Lambda retrieves the client definition from Keycloak at `https://dev-admin-server.mayabank.xyz/admin/realms/mayabank/clients`
     - Lambda extracts the JWKS URL from the client definition
     - Lambda fetches the client's public key from the JWKS URL
     - Lambda encrypts the response using JWE with the client's public key

6. **Response Delivery**:
   - If encryption is enabled and successful:
     - Lambda returns the JWE token with Content-Type: application/jose
   - If encryption is disabled or fails:
     - Lambda returns the customer data as JSON with Content-Type: application/json
   - The response is sent back to the client through the API Gateway

### 4. PERA Arrangement Registration

Once the PERA account onboarding has concluded, the results can be registered using the `/ofxpera/arrangements` endpoint:

1. **API Request with mTLS and JWT**:
   - Client establishes a TLS connection with the API Gateway using its client certificate
   - Client includes the access token in the Authorization header:
     ```http
     POST /ofxpera/arrangements HTTP/1.1
     Host: dev-ofph-api.mayabank.xyz
     Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...
     Content-Type: application/json
     x-v: 1.0.0
     x-fapi-interaction-id: 5b9c196b-f279-...
     x-idempotency-key: 082f2439-55b6-...
     
     {
         "id": "97d9d019-74b7-4fce-ad34-04c5341554db",
         "adminId": "one-admin-23",
         "customerId": "978b-af96bea91c3b",
         "sub": "001",
         "consentId": "13505161-5053-409e-aad0-7cb4e0bb8bda",
         "status": "active",
         "reason": null,
         "LastUpdateDate": "2025-05-18T00:13:04.514Z"
     }
     ```

2. **mTLS Authentication**:
   - API Gateway validates the client certificate against its truststore
   - If the certificate is invalid or not trusted, the request is rejected with a TLS error

3. **JWT Authorization**:
   - API Gateway's JWT Authorizer validates the token's signature, expiration, and claims
   - If the token is invalid, the request is rejected with a 401 Unauthorized response

4. **Lambda Function Processing**:
   - The request is forwarded to the PeraArrangementRegistrationHandler Lambda function
   - Lambda validates the request headers
   - Lambda validates the request payload against the expected schema
   - Lambda stores the PERA arrangement in DynamoDB

5. **Response Delivery**:
   - Lambda returns a success response with the created arrangement details:
     ```json
     {
         "statusCode": 201,
         "headers": {
            "x-v": "1.0.0",
            "x-fapi-interaction-id": "30faef77-8c84-4e23-96f8-edac98e07939",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "GET,POST,PUT,DELETE,OPTIONS",
            "Access-Control-Allow-Headers": "Content-Type,X-Amz-Date,Authorization,X-Api-Key,x-v,x-fapi-interaction-id,x-idempotency-key",
            "Content-Type": "application/json"
         },
         "body": "{\"id\":\"b851b3d4-003f-498e-8abd-dc709504de67\"}"
      }
     ```
   - If encryption is enabled, the response is encrypted using JWE with the client's public key
   - The response is sent back to the client through the API Gateway

## Security Considerations

1. **Multi-layered Security**:
   - **Transport Layer**: mTLS ensures both client and server authenticate each other
   - **Application Layer**: JWT tokens provide user authorization
   - **Data Layer**: JWE encryption protects sensitive data in transit

2. **Token Validation**:
   - Tokens are validated at multiple levels:
     - API Gateway JWT Authorizer validates token signature and claims
     - Lambda function performs additional validation with Keycloak

3. **Dynamic JWKS URL**:
   - The system supports dynamic JWKS URL retrieval from client definitions
   - This allows each client to have its own encryption keys
   - Fallback to environment configuration if JWKS URL retrieval fails

4. **Error Handling**:
   - Detailed error responses with appropriate HTTP status codes
   - Logging of security events for audit purposes
   - Graceful degradation if encryption fails (returns unencrypted data with warning)

## Implementation Details

### Keycloak Configuration

Keycloak is deployed on AWS EKS with a dual endpoint architecture:
- **Private Endpoint** (`dev-auth-server.mayabank.xyz`): Uses mTLS for secure machine-to-machine communication
- **Public Endpoint** (`dev-admin-server.mayabank.xyz`): Standard TLS for user authentication and admin access

### API Gateway Configuration

The API Gateway is configured with:
- mTLS authentication using a truststore of approved client certificates
- JWT authorizer that validates tokens from Keycloak
- Custom domain (`api.mayabank.xyz`) with regional endpoint and TLS 1.2 security policy

### Lambda Function Implementation

The GetCustomerDetailHandler Lambda function:
- Validates the access token with Keycloak
- Retrieves customer data from DynamoDB as a proxy to Maya's CIF system
- Dynamically determines the JWKS URL from the client definition
- Encrypts the response using JWE if enabled

## Summary

This authorization flow provides a secure and standards-compliant method for third-party applications to access protected resources. By combining OAuth 2.0, OpenID Connect, mTLS, JAR, JARM and JWE encryption, the system ensures that:

1. Only authenticated customers/account holders can authorize access to their data
2. Only authorized and authenticated clients can initiate requests on behalf of customers
3. Proof of origin, integrity and authenticity of requests and responses are established
4. Sensitive data is protected both in transit and through encryption
5. Each client can have its own encryption keys for maximum security

## Domain Names

| Service | FQDN | Purpose |
|---------|------|---------|
| Keycloak Public Endpoint | dev-admin-server.mayabank.xyz | User authentication, admin access, token issuance |
| Keycloak Private Endpoint | dev-auth-server.mayabank.xyz | Machine-to-machine communication with mTLS |
| Protected API | dev-ofph-api.mayabank.xyz | Secure API access with mTLS and JWT authorization |