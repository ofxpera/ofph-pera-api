# OFxPERA API Release Notes

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

## Version 0.0.6

*Release Date: March 11, 2025*

This release focuses on security enhancements and improvements to the PERA arrangement endpoints, along with several other refinements to the API specification.

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

### PERA Arrangement Improvements

- **Added security requirements** to PERA arrangement endpoints:
  - Added `SignedJWT` security to `/ofxpera/arrangements` (POST)
  - Added `SignedJWT` security to `/ofxpera/arrangements/{arrangement_id}` (GET)

- **Updated PERA arrangement endpoint descriptions**:
  - Clarified that the POST endpoint registers the result of an FI-initiated PERA account opening
  - Updated summary to "Registers the result of a PERA account opening"

### Other Changes

- **Updated API version** from 0.0.5 to 0.0.6

- **Enhanced OAuth functionality**:
  - Added `endorsement` as a valid value for the `response_type` parameter in the OAuth authorization endpoint

- **Updated PeraArrangement schema**:
  - Changed status enum values from `[ACTIVE, SUSPENDED, CLOSED]` to `[ACTIVE, DECLINED, CLOSED]`

### Migration Notes
- Applications using `RegistrationAccessToken` should update to use `SignedJWT` instead
- JWT implementations must be updated to conform to the enhanced encryption requirements
- OAuth clients should be updated to handle the new `endorsement` response type if needed
- Applications handling PERA arrangements should update status handling to use `DECLINED` instead of `SUSPENDED`

---

*These release notes document changes from version 0.0.5 to version 0.0.6 of the OFxPERA API.*

Cascade [2025-03-11T10:02:07+08:00]