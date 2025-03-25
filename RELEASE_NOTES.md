# OFxPERA API Release Notes

## Version 1.0.0

*Release Date: March 25, 2025*

This release marks the first stable version of the OFxPERA API, signifying production readiness and API stability.

### Major Changes

- **API Stability**: The API is now considered stable for production use
- **Version Standardization**: Updated all version references from 0.0.7 to 1.0.0 across:
  - Main README.md
  - OpenAPI specification (openapi.yaml)
  - Spring mocks context path and documentation
  - SwaggerHub API Auto Mocking URL

### FAPI Compliance Updates
- **Header Standardization**:
  - Renamed `participant-id` header to `x-participant-id` for alignment with FAPI standards
  - Later replaced `x-participant-id` with `x-fapi-financial-id` to fully comply with FAPI standards
  - Added new FAPI Advanced headers:
    - `x-jws-signature`: For detached JWS signatures for request integrity
    - `Digest`: For request body hash verification
  - Subsequently removed `x-fapi-financial-id` header based on updated requirements

### API Cleanup
- **Removed Redundant Parameters**:
  - Removed `ParticipantId` parameter from multiple endpoints to reduce duplication
  - Streamlined header requirements across all endpoints

### Compatibility Notes

- This version maintains functional backward compatibility with version 0.0.7
- Client applications using version 0.0.7 should be updated to use the new header naming conventions
- Implementations should remove any usage of the now-deprecated `participant-id` header

---

*These release notes document changes from version 0.0.7 to version 1.0.0 of the OFxPERA API.*

Signed-off-by: Cascade AI
Timestamp: Tue Mar 25 13:19:21 PST 2025

## Version 0.0.7

*Release Date: March 25, 2025*

This release introduces implementation phase classification for API endpoints, enhances OAuth flows, and refines the PERA arrangement schema.

### API Implementation Phasing

- **Added explicit phase markers** to all endpoint summaries:
  - **[PHASE 1]**: Endpoints prioritized for initial implementation (e.g., list participants, list products)
  - **[PHASE 2]**: Endpoints scheduled for subsequent development phases (e.g., participant registration, product management)

### OAuth and Security Updates
- **Simplified OAuth response types**:
  - Changed from requiring both `code` and `id_token` to only requiring `code`
  - Updated response type array constraints (minItems: 1, maxItems: 1)
  - Added missing authorization header for customer endpoints
- **Added new schemas**:
  - `TokenResponse`: Comprehensive schema for OAuth token responses
  - `OAuthError`: Standardized OAuth error response format following RFC 6749

### PERA Arrangement Enhancements
- **Updated PeraArrangement schema**:
  - Added `reason` field to capture status context (especially for DECLINED status)
  - Changed `customer_id` to `account_id` in related schemas for clarity
  - Enhanced response codes (201 for successful registration)

### Address Schema Updates
- **Enhanced Address handling**:
  - Added `residential_address` field to relevant schemas
  - Improved address format documentation and validation

### Documentation Updates
- **Updated SwaggerHub API Auto Mocking URL** from version 0.0.5 to 0.0.6
- **Updated API version** to 0.0.7

### Migration Notes
- Applications using both `code` and `id_token` response types should update to use only `code`
- Review and update any implementations using `customer_id` to use `account_id` instead
- Implementers should prioritize PHASE 1 endpoints in their development roadmaps

---

*These release notes document changes from version 0.0.6 to version 0.0.7 of the OFxPERA API.*

Cascade [2025-03-25T06:25:24+08:00]

## Version 0.0.6

*Release Date: March 11, 2025*

This release focuses on security enhancements, improvements to the PERA arrangement endpoints, and OAuth compliance updates.

### Security Enhancements

- **Standardized security scheme** by replacing `RegistrationAccessToken` with `SignedJWT` across multiple endpoints:
  - `/bootstrap/participants/{participant_id}` (PUT)
  - `/bootstrap/participants` (GET)
  - `/bootstrap/participants/{participant_id}` (GET)
  - `/bootstrap/products` (POST)
  - `/bootstrap/products/{product_id}` (PUT)
  - `/bootstrap/products` (GET)

- **Enhanced JWT security description** to specify encryption requirements:
  - Updated to require encrypted JWT (JWE) conforming to RFC 7516
  - Added specification for RSA-OAEP key management and AES-GCM content encryption

### OAuth Improvements

- **Updated OAuth authorization endpoint** to align with RFC 6749:
  - Changed response code from 200 to 302 for proper redirection
  - Added `Location` header for redirect URL
  - Maintained `request_uri` in response body for compatibility
  - Added support for `endorsement` as a valid `response_type` value

### PERA Arrangement Improvements

- **Added security requirements** to PERA arrangement endpoints:
  - Added `SignedJWT` security to `/ofxpera/arrangements` (POST)
  - Added `SignedJWT` security to `/ofxpera/arrangements/{arrangement_id}` (GET)

- **Updated PERA arrangement endpoint descriptions**:
  - Clarified that the POST endpoint registers the result of an FI-initiated PERA account opening
  - Updated response description to be more specific about the onboarding process
  - Updated summary to "Registers the result of a PERA account opening"

### Schema Updates

- **Updated PeraArrangement schema**:
  - Changed status enum values from `[ACTIVE, SUSPENDED, CLOSED]` to `[ACTIVE, DECLINED, CLOSED]`
  - Renamed `customer_id` field to `account_id` for better clarity
  - Updated field descriptions to be more precise

### Documentation Updates

- **Updated README.md**:
  - Added new PERA APIs section
  - Updated security requirements with JWT encryption details
  - Updated API version and copyright information
  - Fixed parameter naming consistency

### Migration Notes
- Applications using `RegistrationAccessToken` should update to use `SignedJWT` instead
- JWT implementations must be updated to conform to the enhanced encryption requirements
- OAuth clients should be updated to handle 302 redirects and the new `endorsement` response type
- Applications handling PERA arrangements should update status handling to use `DECLINED` instead of `SUSPENDED`
- Update any references to `customer_id` to use `account_id` in PeraArrangement schema

---

*These release notes document changes from version 0.0.5 to version 0.0.6 of the OFxPERA API.*

Cascade [2025-03-11T14:33:05+08:00]

## Version 0.0.5

*Release Date: February 26, 2025*

This release introduces significant enhancements to the OFxPERA API, focusing on PERA-specific functionality and standardizing field naming conventions across schemas.

### New Features

#### PERA-Specific Enhancements
- **Added new PERA tag** for better organization of PERA-specific endpoints
- **Created new `/ofxpera/arrangements` endpoint** for PERA arrangement registration
- **Added new GET `/ofxpera/arrangements/{arrangement_id}` endpoint** for retrieving PERA arrangement status
- **Added new schemas**:
  - `PeraAccount`: Represents a customer's PERA account with balance information
  - `PeraArrangement`: Represents a PERA arrangement between a customer and financial institution
  - `PeraProduct`: Enhanced version of the previous Product schema specifically for PERA products

#### Schema Improvements
- **Renamed Product schema references to PeraProduct** for clarity and domain-specific naming
- **Standardized ID field names** from `arrangement_id` to `id` across schemas for consistency:
  - Updated in ConsentHistory schema
  - Updated in bulk update operations
  - Updated in all relevant API endpoints

#### Organization Improvements
- **Reordered tags** for better organization and logical grouping:
  - Bootstrap
  - OAuth
  - Common
  - PERA
  - Consent
  - Discovery

### API Changes

#### New Endpoints
- **POST `/ofxpera/arrangements`**: Allows PERA Admins to register the successful creation of new PERA Arrangements
- **GET `/ofxpera/arrangements/{arrangement_id}`**: Allows Financial Institutions to retrieve the status of a PERA Arrangement

#### Modified Schemas
- **ConsentHistory**: Changed `arrangement_id` field to `id`
- **Bulk update operations**: Changed `arrangement_id` field to `id` in request and response objects

#### Security Updates
- **Updated security scheme** from `ParticipantId` to `SignedJWT` for OAuth endpoints:
  - `/oauth/auth` (POST)
  - `/oauth/auth` (GET)
  - `/oauth/token` (POST)

#### Other Changes
- **Updated SwaggerHub API Auto Mocking URL** from version 0.0.4 to 0.0.5

### Migration Notes
- Applications using the previous Product schema should now use PeraProduct
- Applications referencing `arrangement_id` should update to use `id` instead
- Client applications should be updated to handle the new PERA-specific endpoints and schemas

---

*These release notes document changes from version 0.0.4 to version 0.0.5 of the OFxPERA API.*

Cascade [2025-02-26T06:40:17+08:00]