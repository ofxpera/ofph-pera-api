# OFxPERA API

Philippines Open Finance API Implementation for PERA (Personal Equity and Retirement Account)

## Overview

This repository contains the OpenAPI 3.0 specification for the OFxPERA API, which enables secure data exchange between PERA participants following Financial-grade API (FAPI) security requirements.

## API Endpoints

### Bootstrap APIs
- `POST /ofxpera/participants` - Register a new PERA participant
- `PUT /ofxpera/participants` - Update participant registration
- `GET /ofxpera/participants` - List all registered participants
- `GET /ofxpera/participants/{client_id}` - Get specific participant details

### OAuth/OpenID Connect APIs
- `GET /oauth/auth` - Authorization endpoint
- `POST /oauth/token` - Token endpoint
- `GET /oauth/introspect` - Token introspection (optional)
- `GET /oauth/userinfo` - UserInfo endpoint (optional)

### Common APIs
- `GET /common/customers/{id}/detail` - Get customer information

### Discovery APIs
- `GET /.well-known/openid-configuration` - OpenID Connect discovery
- `POST /.well-known/openid-registration` - Dynamic client registration
- `GET /.well-known/openid-registration` - Get client registration
- `PUT /.well-known/openid-registration` - Update client registration
- `DELETE /.well-known/openid-registration` - Delete client registration
- `GET /.well-known/jwks.json` - JSON Web Key Set

## Security

- OAuth 2.0 with OpenID Connect
- FAPI-compliant security profiles
- Required security headers:
  - `participant-id`
  - `x-v` (API version)
  - `x-fapi-interaction-id`
  - `x-fapi-auth-date`
  - `x-fapi-customer-ip-address`
  - `x-client-headers`

## License

Apache License 2.0 - See LICENSE file for details

## Contact

For questions or support, please contact the OFxPERA team.
