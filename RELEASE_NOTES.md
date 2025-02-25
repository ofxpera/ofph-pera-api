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