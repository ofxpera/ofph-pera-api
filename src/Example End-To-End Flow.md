## Detailed Process Flow Example

🛠 Example Scenario

* Authorization Server (AS): https://authserver.example.com
* Resource Server (RS): https://api.example.com
* Client (e.g., mobile app or web app): registered for FAPI Advanced profile
* Client ID: client-12345
* Client Authentication: private\_key\_jwt (client authenticates by signing a JWT)
* Response Mode: response\_mode=jwt
* Response Type: code
* Scope: openid accounts
* PKCE: mandatory under FAPI (so code\_challenge and code\_verifier used)
* Request Object: passed by value as a request parameter (signed JWT)
* Access Token: JWT (not opaque)
* ID Token: JWT
* Token Binding: optional here — we can add mTLS or DPoP later if you want

⸻

🌐 Step 1 — Authorization Request (GET /authorize)

Instead of sending query params directly, we use a Request Object (a signed JWT).

1.1 Build the Request Object (JWT)

Example JWT claims:
```json
{
	"iss": "client-12345",
	"aud": "https://authserver.example.com",
	"response\_type": "code",
	"response\_mode": "jwt",
	"client\_id": "client-12345",
	"redirect\_uri": "https://client.example.com/cb",
	"scope": "openid accounts",
	"state": "abc123",
	"nonce": "xyz456",
	"code\_challenge": "s256hashedvalue","code\_challenge\_method": "S256",
	"exp": 1717074016,
	"iat": 1717073716
}
```
	

The Request Object JWT is signed using the client’s private key (using RS256 or stronger).

⸻

1.2 Make the Authorization Request (GET)

	GET /authorize?
	  client\_id=client-12345
	  &request=<signed\_request\_object\_jwt>
	  &response\_mode=jwt
	  HTTP/1.1
	Host: authserver.example.com

  
⸻

📩 Step 2 — Authorization Response (JARM — JWT Secured Authorization Response)

Instead of a normal ?code=...&state=..., the server responds with a JWT that contains the code.

Example response:

HTTP/1.1 302 Found
Location: https://client.example.com/cb?response=\<signed\_response\_jwt\>

Inside the response JWT payload:

	{
	  "iss": "https://authserver.example.com",
	  "aud": "client-12345",
	  "exp": 1717074046,
	  "iat": 1717073746,
	  "code": "authcode-abcdef123456",
	  "state": "abc123"
	}

✅ Client verifies:
	•	JWT Signature (from Authorization Server public key)
	•	iss, aud, exp, state values.

✅ Extracts the code from the JWT.

⸻

🔑 Step 3 — Token Request (POST /token)

Use private\_key\_jwt authentication at the token endpoint.

You also must send the code\_verifier because PKCE is required.

⸻

3.1 Create Client Assertion JWT for Authentication

JWT claims:

{
  "iss": "client-12345",
  "sub": "client-12345",
  "aud": "https://authserver.example.com/token",
  "jti": "random-uuid-12345",
  "exp": 1717074076,
  "iat": 1717073776
}

✅ Sign this with the client’s private key.

⸻

3.2 Make the Token Request

POST /token HTTP/1.1
Host: authserver.example.com
Content-Type: application/x-www-form-urlencoded

grant\_type=authorization\_code
&code=authcode-abcdef123456
&redirect\_uri=https%3A%2F%2Fclient.example.com%2Fcb
&client\_id=client-12345
&client\_assertion\_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer
&client\_assertion=\<signed\_client\_assertion\_jwt\>
&code\_verifier=\<original\_code\_verifier\>



⸻

📦 Step 4 — Token Response

Example response:

{
  "access\_token": "eyJraWQiOiJrZzIiLCJhbGciOiJSUzI1NiJ9....",
  "id\_token": "eyJraWQiOiJrZzIiLCJhbGciOiJSUzI1NiJ9....",
  "token\_type": "Bearer",
  "expires\_in": 3600,
  "scope": "openid accounts"
}

✅ access\_token and id\_token are both JWTs.
✅ Access Token must have FAPI-required claims (aud, exp, scope, etc.)
✅ ID Token must include sub, aud, iss, exp, iat, and auth\_time.

⸻

🔒 Step 5 — Access the Protected Resource (GET /customers/{customer\_id})

Use the JWT access\_token in the Authorization header.

Example call:

GET /customers/123456 HTTP/1.1
Host: api.example.com
Authorization: Bearer eyJraWQiOiJrZzIiLCJhbGciOiJSUzI1NiJ9....
Accept: application/json
x-fapi-financial-id: openbanking.example.com
x-fapi-interaction-id: 84b3ff8c-f528-4e3d-8dfc-2c223bb81613
x-fapi-customer-ip-address: 203.0.113.12

	•	x-fapi-financial-id = identifies the financial institution (your API server)
	•	x-fapi-interaction-id = unique ID per request (client-generated)
	•	x-fapi-customer-ip-address = customer’s IP address

⸻

📥 Step 6 — Resource Server Validates the Access Token

Resource Server must:
	•	Verify JWT signature of access_token
	•	Check aud, exp, scope, etc.
	•	Enforce scope access (accounts, customers.read, etc.)
	•	Optionally verify binding if mTLS or DPoP is used (not shown here yet)

⸻

📋 Sample Response from Resource Server

{
  "customer\_id": "123456",
  "full\_name": "Jane Doe",
  "accounts": [
	{
	  "account_id": "abc123",
	  "account_type": "savings",
	  "balance": 10000.00,
	  "currency": "PHP"
	}
  ]
}



⸻

✅ Summary of Key Compliance to FAPI, JARM, and Open Finance

Requirement	Status	Notes
Authorization Request with Signed JWT	✅	request parameter
Authorization Response using JARM	✅	JWT response
Client Authentication using Signed JWT	✅	private\_key\_jwt
PKCE for Authorization Code Flow	✅	FAPI Advanced requires
Access Token as a Signed JWT	✅	No opaque tokens
ID Token with Standard Claims	✅	OpenID Connect Compliance
Accessing Resource with Bearer JWT	✅	Authorization: Bearer header
Secure Header Requirements (FAPI headers)	✅	x-fapi- headers used



⸻

🎯 Would you also like me to show:
	•	mTLS-bound access tokens?
	•	DPoP-bound access tokens?
	•	A real example of how the Request Object JWT and Client Assertion JWT are signed (Python or Java code)?
	•	Error scenarios (e.g., invalid signature, expired token, wrong audience)?

Would you like me to continue with any of these? 🚀