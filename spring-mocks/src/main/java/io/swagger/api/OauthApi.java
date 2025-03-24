/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.66).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse2001;
import io.swagger.model.OAuthError;
import io.swagger.model.OauthAuthBody;
import org.threeten.bp.OffsetDateTime;
import io.swagger.model.TokenResponse;
import java.util.UUID;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")
@Validated
public interface OauthApi {

    @Operation(summary = "[PHASE 1] Authorization endpoint for Admin-initiated onboarding", description = "OpenID Connect authorization endpoint that initiates the authorization flow", security = {
        @SecurityRequirement(name = "SignedJWT")    }, tags={ "OAuth" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "302", description = "Redirect to client with authorization code"),
        
        @ApiResponse(responseCode = "400", description = "OAuth error response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OAuthError.class))),
        
        @ApiResponse(responseCode = "401", description = "Client authentication failed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OAuthError.class))),
        
        @ApiResponse(responseCode = "403", description = "Forbidden - The server understood the request but refuses to authorize it", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Not Found - The requested resource could not be found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "429", description = "Too Many Requests - The client has sent too many requests in a given amount of time", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error - The server encountered an unexpected condition", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/oauth/auth",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Void> authorizeOAuth(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Client identifier issued to the client during registration" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "client_id", required = true) String clientId
, @NotNull @Parameter(in = ParameterIn.QUERY, description = "Must be set to \"code\" for authorization code flow" ,required=true,schema=@Schema(allowableValues={ "code" }
)) @Valid @RequestParam(value = "response_type", required = true) String responseType
, @NotNull @Parameter(in = ParameterIn.QUERY, description = "Space-separated list of requested scope values, OFxPERA requires openid to be included to maintain compatibility with OIDC." ,required=true,schema=@Schema(allowableValues={ "openid", "profile", "email", "address", "phone" }
)) @Valid @RequestParam(value = "scope", required = true) List<String> scope
, @NotNull @Parameter(in = ParameterIn.QUERY, description = "URI to return the user to after authorization is complete" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "redirect_uri", required = true) String redirectUri
, @NotNull @Parameter(in = ParameterIn.QUERY, description = "Opaque value to maintain state between request and callback" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "state", required = true) String state
, @Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
, @Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
, @Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
, @Parameter(in = ParameterIn.QUERY, description = "Code challenge for PKCE" ,schema=@Schema()) @Valid @RequestParam(value = "code_challenge", required = false) String codeChallenge
, @Parameter(in = ParameterIn.QUERY, description = "Code challenge method for PKCE" ,schema=@Schema(allowableValues={ "S256" }
)) @Valid @RequestParam(value = "code_challenge_method", required = false) String codeChallengeMethod
, @Parameter(in = ParameterIn.QUERY, description = "Prompt for the authorization request" ,schema=@Schema()) @Valid @RequestParam(value = "prompt", required = false) String prompt
, @Parameter(in = ParameterIn.QUERY, description = "Random value used to prevent replay attacks" ,schema=@Schema()) @Valid @RequestParam(value = "nonce", required = false) String nonce
);


    @Operation(summary = "[PHASE 1] Token endpoint", description = "OAuth 2.0 token endpoint for obtaining access tokens", security = {
        @SecurityRequirement(name = "SignedJWT")    }, tags={ "OAuth" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Token successfully issued", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TokenResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Request - The server cannot process the request due to a client error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized - Authentication is required and has failed or not been provided", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "403", description = "Forbidden - The server understood the request but refuses to authorize it", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Not Found - The requested resource could not be found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "429", description = "Too Many Requests - The client has sent too many requests in a given amount of time", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error - The server encountered an unexpected condition", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/oauth/token",
        produces = { "application/json" }, 
        consumes = { "application/x-www-form-urlencoded" }, 
        method = RequestMethod.POST)
    ResponseEntity<TokenResponse> getOAuthToken(@Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
, @Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "100", "1" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
, @Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
, @Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
, @Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
, @Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
, @Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
, @Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema(allowableValues={ "authorization_code", "refresh_token" }
)) @RequestParam(value="grant_type", required=true)  String grantType
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="code", required=true)  String code
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="redirect_uri", required=true)  String redirectUri
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="client_id", required=true)  String clientId
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="refresh_token", required=true)  String refreshToken
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema(allowableValues={ "urn:ietf:params:oauth:assertion-type:jwt-bearer" }
)) @RequestParam(value="client_assertion_type", required=true)  String clientAssertionType
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="client_assertion", required=true)  String clientAssertion
, @Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
);


    @Operation(summary = "Optional OpenID Connect UserInfo Endpoint", description = "OpenID Connect UserInfo Endpoint that returns information about the authenticated user. ", security = {
        @SecurityRequirement(name = "OAuth2", scopes = {
            "read",
"write"        })    }, tags={ "OAuth" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "User information retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse2001.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Request - The server cannot process the request due to a client error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized - Authentication is required and has failed or not been provided", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "403", description = "Forbidden - The server understood the request but refuses to authorize it", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Not Found - The requested resource could not be found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "429", description = "Too Many Requests - The client has sent too many requests in a given amount of time", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error - The server encountered an unexpected condition", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/oauth/userinfo",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<InlineResponse2001> getUserInfo(@Parameter(in = ParameterIn.HEADER, description = "Bearer token for authentication. Must be in the format 'Bearer <token>'" ,required=true,schema=@Schema()) @RequestHeader(value="Authorization", required=true) String authorization
, @Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
, @Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "1", "100" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
, @Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
, @Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
, @Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
, @Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
, @Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
, @Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
, @Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
);


    @Operation(summary = "Optional token introspection", description = "Endpoint for validating and retrieving metadata about an access token. Returns information about whether the token is active, its associated client, user, scopes, and expiration details. This endpoint allows resource servers to verify tokens before granting access to protected resources. ", security = {
        @SecurityRequirement(name = "SignedJWT")    }, tags={ "OAuth" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Token information retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse200.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Request - The server cannot process the request due to a client error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized - Authentication is required and has failed or not been provided", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "403", description = "Forbidden - The server understood the request but refuses to authorize it", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Not Found - The requested resource could not be found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "429", description = "Too Many Requests - The client has sent too many requests in a given amount of time", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error - The server encountered an unexpected condition", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/oauth/introspect",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> introspectToken(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "token", required = true) String token
, @Parameter(in = ParameterIn.HEADER, description = "Bearer token for authentication. Must be in the format 'Bearer <token>'" ,required=true,schema=@Schema()) @RequestHeader(value="Authorization", required=true) String authorization
, @Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
, @Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "1", "100" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
, @Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
, @Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
, @Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
, @Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
, @Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
, @Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
, @Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
);


    @Operation(summary = "[PHASE 1] PAR-based Authorization API for FI-initiated onboarding", description = "POST version of the authorization API that initiates the authorization flow", security = {
        @SecurityRequirement(name = "SignedJWT")    }, tags={ "OAuth" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "302", description = "Redirect to authorization page"),
        
        @ApiResponse(responseCode = "400", description = "OAuth error response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OAuthError.class))),
        
        @ApiResponse(responseCode = "401", description = "Client authentication failed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OAuthError.class))),
        
        @ApiResponse(responseCode = "403", description = "Forbidden - The server understood the request but refuses to authorize it", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Not Found - The requested resource could not be found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "429", description = "Too Many Requests - The client has sent too many requests in a given amount of time", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error - The server encountered an unexpected condition", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/oauth/auth",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> oAuthPAR(@Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
, @Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "100", "1" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
, @Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
, @Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
, @Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
, @Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
, @Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
, @Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody OauthAuthBody body
, @Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
);

}

