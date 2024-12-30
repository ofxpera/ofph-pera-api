# OFxPERA API

Philippines Open Finance API Implementation for PERA (Personal Equity and Retirement Account)

## Overview

This repository contains the OpenAPI 3.0 specification for the OFxPERA API, which enables secure data exchange between PERA participants following Financial-grade API (FAPI) security requirements. The API is designed to facilitate standardized integration between PERA administrators, custodians, and investment managers.

## Getting Started

### Base URL
Production: `https://api.ofxpera.ph/v1`

### API Version
Current Version: `0.0.1`

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
- `GET /ofxpera/participants/{client_id}` - Get specific participant details

### OAuth/OpenID Connect APIs
Authentication and authorization endpoints following FAPI security profile:
- `GET /oauth/auth` - Authorization endpoint
  - Supports PKCE (Proof Key for Code Exchange)
  - Required parameters: client_id, response_type, scope, redirect_uri, code_challenge
- `POST /oauth/token` - Token endpoint
  - Supports authorization_code and refresh_token grant types
- `GET /oauth/introspect` - Token introspection (optional)
- `GET /oauth/userinfo` - UserInfo endpoint (optional)

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
- FAPI-compliant security profiles
- PKCE (Proof Key for Code Exchange) requirement for authorization code flow
- JWT-based token format

### Required Headers
All API requests must include:
- `participant-id`: Registered participant identifier
- `x-v`: API version being used
- `x-fapi-interaction-id`: Unique ID for request tracing
- `x-fapi-auth-date`: Authentication timestamp
- `x-fapi-customer-ip-address`: End-user IP address
- `x-client-headers`: Additional client metadata

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

Copyright 2024 OFxPERA Contributors

Licensed under the Apache License 2.0 - See LICENSE file for details
