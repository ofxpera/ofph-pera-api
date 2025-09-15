# OFxPERA API

Philippines Open Finance API Implementation for PERA (Personal Equity and Retirement Account)

## Overview

This repository contains the OpenAPI 3.0 specification for the OFxPERA API, which enables secure data exchange between PERA participants following Financial-grade API (FAPI) security requirements. The API is designed to facilitate standardized integration between PERA administrators, custodians, and investment managers.

## Getting Started

### Base URL
Production: `https://api.ofxpera.ph/v1`

### API Version
Current Version: `1.0.0`

### Prerequisites
- Valid participant registration with OFxPERA
- FAPI-compliant OAuth 2.0 client implementation
- Valid SSL certificates for secure communication
- Compliance with security and data protection requirements

## API Structure

### Bootstrap APIs
Bootstrap APIs handle participant registration and management:
- `POST /ofxpera/participants` - Register a new PERA participant
  - Requires participant details and FAPI-compliant registration information
- `PUT /ofxpera/participants` - Update participant registration
- `GET /ofxpera/participants` - List all registered participants
- `GET /ofxpera/participants/{participant_id}` - Get specific participant details
- `POST /ofxpera/products` - Register a PERA Admin Product
- `PUT /ofxpera/products/{product_id}` - Update a PERA Admin Product
- `GET /ofxpera/products/{participant_id}` - Get a list of PERA products associated with PERA Admin

### PERA APIs
Core PERA functionality endpoints:
- `POST /ofxpera/arrangements` - Register the result of a PERA account opening
- `GET /ofxpera/arrangements/{arrangement_id}` - Get PERA arrangement status
- `PUT /ofxpera/arrangements/{arrangement_id}/status` - Update PERA arrangement status

### OAuth/OpenID Connect APIs
Authentication and authorization endpoints following FAPI security profile:
- `GET /oauth/auth` - Authorization endpoint (302 redirect)
  - Supports PKCE (Proof Key for Code Exchange)
  - Required parameters: client_id, response_type (code), scope, redirect_uri, code_challenge
- `POST /oauth/auth` - PAR-based Authorization API for FI-initiated onboarding
- `POST /oauth/token` - Token endpoint
  - Supports authorization_code and refresh_token grant types
- `GET /oauth/introspect` - Token introspection
- `GET /oauth/userinfo` - UserInfo endpoint

### Consent APIs
Consent management endpoints:
- `POST /consent/arrangements` - Create a consent arrangement
- `GET /consent/arrangements/{arrangement_id}` - Get a specific consent arrangement
- `PUT /consent/arrangements/{arrangement_id}` - Update consent arrangement status
- `GET /consent/arrangements/{arrangement_id}/history` - Get consent arrangement history
- `GET /consent/templates` - List consent templates
- `GET /consent/customers/{customer_id}/arrangements` - Get customer consents
- `POST /consent/customers/{customer_id}/arrangements/bulk-update` - Bulk update customer consents
- `GET /consent/customers/{customer_id}/dashboard` - Get customer's consent dashboard

### Common APIs
Standardized endpoints for common functionalities:
- `GET /common/customers/{id}/detail` - Get customer information

### Discovery APIs
OpenID Connect discovery and registration endpoints:
- `GET /.well-known/openid-configuration` - OpenID Connect discovery document
- `POST /.well-known/openid-registration` - Dynamic client registration
- `GET /.well-known/openid-registration` - Get client registration
- `PUT /.well-known/openid-registration` - Update client registration
- `DELETE /.well-known/openid-registration` - Delete client registration
- `GET /.well-known/jwks.json` - JSON Web Key Set

## Security Requirements

### Authentication
- OAuth 2.0 with OpenID Connect implementation
- FAPI-compliant security profiles with encrypted JWTs (JWE)
- RSA-OAEP for key management and AES-GCM for content encryption
- PKCE (Proof Key for Code Exchange) requirement for authorization code flow
- JWT-based token format

### Required Headers
All API requests must include:
- `participant-id`: Registered participant identifier
- `x-v`: API version being used
- `x-fapi-interaction-id`: Unique ID for request tracing

Customer-triggered API endpoints (Common and OAuth tags) must additionally include:
- `Authorization`: Bearer token for authentication
- `x-fapi-auth-date`: Authentication timestamp
- `x-fapi-customer-ip-address`: End-user IP address
- `x-client-headers`: Additional client metadata
- `x-client-user-agent`: Customer's original User-Agent header
- `x-idempotency-key`: Unique idempotency key for the request
- `x-fapi-customer-last-logged-time`: Time when the PSU last logged in

### Scopes
Available OAuth scopes:
- `openid` (required)
- `profile`
- `email`
- `address`
- `phone`

## Error Handling
The API uses standard HTTP status codes and provides detailed error responses in JSON format:
- 400 - Bad Request
- 401 - Unauthorized
- 403 - Forbidden
- 404 - Not Found
- 429 - Too Many Requests
- 500 - Internal Server Error

## Rate Limiting
API requests are subject to rate limiting. Implement appropriate retry mechanisms with exponential backoff.

## Support and Contact

For technical support or questions:
- Contact the OFxPERA team
- Refer to the OpenAPI specification for detailed endpoint documentation
- Check the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0.html) for terms of use

## License

Copyright 2024-2025 OFxPERA Contributors

Licensed under the Apache License 2.0 - See LICENSE file for details
