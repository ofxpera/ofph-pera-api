# OFxPERA API

4	Endpoints and Sequence Diagrams
4.1	Namespace
The following namespaces will be used for the OFxPERA pilot.
Industry	Description
Admin	This namespace will be used to register and retrieve CORS URIs by all participants and for 
Oauth	APIs for authentication, authorization and consent management will fall under this namespace.
Common	APIs that re used across different industries and various use cases, e.g. consent and customer information.
Banking	All banking-related use cases under the OFxPERA project must use this namespace.
4.2	OFxPERA APIs
The following API endpoints will be supported in the OFxPERA Pilot.
4.2.1	Admin
CORS URI endpoints
API	Description
POST /admin/organization	API for registering a participating organization’s URIs
GET /admin/organization	API for retrieving all registered organization URIs
GET /admin/organization/{ id}/certificate	API for retrieving a registered organization’s certificate

4.2.2	OAuth
Customer Authentication, Authorization and Consent Management
API	Description
POST /oauth/par	Oauth Push Authorization Request
GET / oauth/authorize	
POST / oauth/token	
GET / oauth/introspection	
GET / oauth/userinfo	

4.2.3	Common API Endpoints
API	Description
GET /common/consent/{id}	API for retrieving the latest consent information provided to the calling entity by the data provider.
POST /common/consent	
PUT /common/consent/{id}	
DELETE /common/consent/{id}	API for revoking a previously provided consent.
GET / common /customer	
GET / common /customer/{id}/detail	

4.2.4	Banking (OFxPERA Use Cases) API Endpoints
4.2.4.1	Admin-Initiated Account Opening
API	Description
GET / banking/account	API for retrieving information about the customer’s source account from their preferred FI. Used in account linking and similar use cases.

4.2.4.2	FI-Initiated Account Management
API	Description
GET /banking/products	API for retrieving list of PERA products the customer could subscribe to.
POST /banking/customer	API for 
GET /banking/customer	
POST /banking/accounts	
GET / banking/accounts	
GET /banking/accounts/{id}	
GET /banking/account/{id}/transactions	
GET /banking/account/{id}/transactions/{id}	

4.2.4.3	Payment Initiation
API	Description
POST /banking/payments	API for initiating a payment (money movement) transaction.
GET /banking/payments/{id}	API for retrieving and validating payment status and other details.
DELETE /banking/payments/{id}	
GET /banking/payments	

