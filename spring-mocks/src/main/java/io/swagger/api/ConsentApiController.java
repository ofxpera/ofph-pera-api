package io.swagger.api;

import io.swagger.model.ArrangementsBulkupdateBody;
import io.swagger.model.BulkConsentRequest;
import io.swagger.model.BulkConsentResponse;
import io.swagger.model.ConsentArrangementRequest;
import io.swagger.model.ConsentArrangementResponse;
import io.swagger.model.ConsentDashboard;
import io.swagger.model.ConsentExtensionRequest;
import io.swagger.model.ConsentHistory;
import io.swagger.model.ConsentStatusUpdate;
import io.swagger.model.ConsentTemplate;
import io.swagger.model.Error;
import io.swagger.model.InlineResponse2003;
import io.swagger.model.InlineResponse2004;
import org.threeten.bp.OffsetDateTime;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")
@RestController
public class ConsentApiController implements ConsentApi {

    private static final Logger log = LoggerFactory.getLogger(ConsentApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ConsentApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<InlineResponse2004> bulkUpdateCustomerConsents(@Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
,@Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "100", "1" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
,@Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
,@Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
,@Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
,@Parameter(in = ParameterIn.PATH, description = "The customer's unique identifier", required=true, schema=@Schema()) @PathVariable("customer_id") String customerId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ArrangementsBulkupdateBody body
,@Parameter(in = ParameterIn.HEADER, description = "Bearer token for authentication. Must be in the format 'Bearer <token>'" ,required=true,schema=@Schema()) @RequestHeader(value="Authorization", required=true) String authorization
,@Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2004>(objectMapper.readValue("{\n  \"customer_id\" : \"customer_id\",\n  \"results\" : [ {\n    \"id\" : \"id\",\n    \"error\" : {\n      \"code\" : \"code\",\n      \"message\" : \"message\"\n    },\n    \"status\" : \"success\"\n  }, {\n    \"id\" : \"id\",\n    \"error\" : {\n      \"code\" : \"code\",\n      \"message\" : \"message\"\n    },\n    \"status\" : \"success\"\n  } ]\n}", InlineResponse2004.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2004>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2004>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<BulkConsentResponse> createBulkConsent(String participantId, Integer xV, OffsetDateTime xFapiAuthDate, String xFapiCustomerIpAddress, String xClientHeaders, String xClientUserAgent, UUID xIdempotencyKey, OffsetDateTime xFapiCustomerLastLoggedTime, @Valid BulkConsentRequest body, String authorization, UUID xFapiInteractionId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BulkConsentResponse>(objectMapper.readValue("{\n  \"data\" : {\n    \"bulk_consent_id\" : \"bulk_consent_id\",\n    \"status\" : \"status\",\n    \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"arrangements\" : [ {\n      \"arrangement_id\" : \"arrangement_id\",\n      \"status\" : \"status\"\n    }, {\n      \"arrangement_id\" : \"arrangement_id\",\n      \"status\" : \"status\"\n    } ]\n  }\n}", BulkConsentResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BulkConsentResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BulkConsentResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConsentArrangementResponse> createConsentArrangement(@Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
,@Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "100", "1" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
,@Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in FAPI Advanced. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
,@Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
,@Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ConsentArrangementRequest body
,@Parameter(in = ParameterIn.HEADER, description = "Bearer token for authentication. Must be in the format 'Bearer <token>'" ,required=true,schema=@Schema()) @RequestHeader(value="Authorization", required=true) String authorization
,@Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConsentArrangementResponse>(objectMapper.readValue("{\n  \"data_holder_id\" : \"data_holder_id\",\n  \"sharing_duration\" : {\n    \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n  },\n  \"purpose\" : \"purpose\",\n  \"last_updated_at\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"permissions\" : [ \"permissions\", \"permissions\" ],\n  \"revocation_info\" : {\n    \"reason\" : \"reason\",\n    \"revoked_at\" : \"2000-01-23T04:56:07.000+00:00\"\n  },\n  \"additional_terms\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"id\" : \"id\",\n  \"status\" : \"active\"\n}", ConsentArrangementResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConsentArrangementResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConsentArrangementResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConsentArrangementResponse> extendConsentDuration(@Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
,@Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "100", "1" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
,@Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
,@Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
,@Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
,@Parameter(in = ParameterIn.PATH, description = "The ID of the consent arrangement", required=true, schema=@Schema()) @PathVariable("arrangement_id") String arrangementId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ConsentExtensionRequest body
,@Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConsentArrangementResponse>(objectMapper.readValue("{\n  \"data_holder_id\" : \"data_holder_id\",\n  \"sharing_duration\" : {\n    \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n  },\n  \"purpose\" : \"purpose\",\n  \"last_updated_at\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"permissions\" : [ \"permissions\", \"permissions\" ],\n  \"revocation_info\" : {\n    \"reason\" : \"reason\",\n    \"revoked_at\" : \"2000-01-23T04:56:07.000+00:00\"\n  },\n  \"additional_terms\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"id\" : \"id\",\n  \"status\" : \"active\"\n}", ConsentArrangementResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConsentArrangementResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConsentArrangementResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConsentArrangementResponse> getConsentArrangement(@Parameter(in = ParameterIn.PATH, description = "The ID of the consent arrangement", required=true, schema=@Schema()) @PathVariable("arrangement_id") String arrangementId
,@Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
,@Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "1", "100" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
,@Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in FAPI Advanced. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
,@Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
,@Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
,@Parameter(in = ParameterIn.HEADER, description = "Bearer token for authentication. Must be in the format 'Bearer <token>'" ,required=true,schema=@Schema()) @RequestHeader(value="Authorization", required=true) String authorization
,@Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConsentArrangementResponse>(objectMapper.readValue("{\n  \"data_holder_id\" : \"data_holder_id\",\n  \"sharing_duration\" : {\n    \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n  },\n  \"purpose\" : \"purpose\",\n  \"last_updated_at\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"permissions\" : [ \"permissions\", \"permissions\" ],\n  \"revocation_info\" : {\n    \"reason\" : \"reason\",\n    \"revoked_at\" : \"2000-01-23T04:56:07.000+00:00\"\n  },\n  \"additional_terms\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"id\" : \"id\",\n  \"status\" : \"active\"\n}", ConsentArrangementResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConsentArrangementResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConsentArrangementResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConsentHistory> getConsentHistory(@Parameter(in = ParameterIn.PATH, description = "The ID of the consent arrangement", required=true, schema=@Schema()) @PathVariable("arrangement_id") String arrangementId
,@Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
,@Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "1", "100" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
,@Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
,@Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
,@Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
,@Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConsentHistory>(objectMapper.readValue("{\n  \"id\" : \"id\",\n  \"events\" : [ {\n    \"actor\" : \"actor\",\n    \"event_type\" : \"created\",\n    \"previous_state\" : { },\n    \"new_state\" : { },\n    \"details\" : { },\n    \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\"\n  }, {\n    \"actor\" : \"actor\",\n    \"event_type\" : \"created\",\n    \"previous_state\" : { },\n    \"new_state\" : { },\n    \"details\" : { },\n    \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\"\n  } ]\n}", ConsentHistory.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConsentHistory>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConsentHistory>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConsentDashboard> getCustomerConsentDashboard(@Parameter(in = ParameterIn.PATH, description = "The customer's unique identifier", required=true, schema=@Schema()) @PathVariable("customer_id") String customerId
,@Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
,@Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "1", "100" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
,@Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
,@Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
,@Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
,@Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConsentDashboard>(objectMapper.readValue("{\n  \"summary\" : {\n    \"expiring_soon\" : [ {\n      \"data_holder_id\" : \"data_holder_id\",\n      \"sharing_duration\" : {\n        \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n      },\n      \"purpose\" : \"purpose\",\n      \"last_updated_at\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"permissions\" : [ \"permissions\", \"permissions\" ],\n      \"revocation_info\" : {\n        \"reason\" : \"reason\",\n        \"revoked_at\" : \"2000-01-23T04:56:07.000+00:00\"\n      },\n      \"additional_terms\" : [ {\n        \"value\" : \"value\",\n        \"key\" : \"key\"\n      }, {\n        \"value\" : \"value\",\n        \"key\" : \"key\"\n      } ],\n      \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"id\" : \"id\",\n      \"status\" : \"active\"\n    }, {\n      \"data_holder_id\" : \"data_holder_id\",\n      \"sharing_duration\" : {\n        \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n      },\n      \"purpose\" : \"purpose\",\n      \"last_updated_at\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"permissions\" : [ \"permissions\", \"permissions\" ],\n      \"revocation_info\" : {\n        \"reason\" : \"reason\",\n        \"revoked_at\" : \"2000-01-23T04:56:07.000+00:00\"\n      },\n      \"additional_terms\" : [ {\n        \"value\" : \"value\",\n        \"key\" : \"key\"\n      }, {\n        \"value\" : \"value\",\n        \"key\" : \"key\"\n      } ],\n      \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"id\" : \"id\",\n      \"status\" : \"active\"\n    } ],\n    \"arrangements_by_status\" : {\n      \"expired\" : 5,\n      \"active\" : 1,\n      \"revoked\" : 5,\n      \"suspended\" : 2\n    },\n    \"arrangements_by_purpose\" : [ {\n      \"purpose\" : \"purpose\",\n      \"count\" : 7\n    }, {\n      \"purpose\" : \"purpose\",\n      \"count\" : 7\n    } ],\n    \"data_holders\" : [ {\n      \"data_holder_id\" : \"data_holder_id\",\n      \"name\" : \"name\",\n      \"active_arrangements\" : 9\n    }, {\n      \"data_holder_id\" : \"data_holder_id\",\n      \"name\" : \"name\",\n      \"active_arrangements\" : 9\n    } ],\n    \"total_arrangements\" : 0,\n    \"recent_activity\" : [ {\n      \"id\" : \"id\",\n      \"events\" : [ {\n        \"actor\" : \"actor\",\n        \"event_type\" : \"created\",\n        \"previous_state\" : { },\n        \"new_state\" : { },\n        \"details\" : { },\n        \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\"\n      }, {\n        \"actor\" : \"actor\",\n        \"event_type\" : \"created\",\n        \"previous_state\" : { },\n        \"new_state\" : { },\n        \"details\" : { },\n        \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\"\n      } ]\n    }, {\n      \"id\" : \"id\",\n      \"events\" : [ {\n        \"actor\" : \"actor\",\n        \"event_type\" : \"created\",\n        \"previous_state\" : { },\n        \"new_state\" : { },\n        \"details\" : { },\n        \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\"\n      }, {\n        \"actor\" : \"actor\",\n        \"event_type\" : \"created\",\n        \"previous_state\" : { },\n        \"new_state\" : { },\n        \"details\" : { },\n        \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\"\n      } ]\n    } ],\n    \"active_arrangements\" : 6\n  },\n  \"customer_id\" : \"customer_id\"\n}", ConsentDashboard.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConsentDashboard>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConsentDashboard>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2003> getCustomerConsents(@Parameter(in = ParameterIn.PATH, description = "The customer's unique identifier", required=true, schema=@Schema()) @PathVariable("customer_id") String customerId
,@Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
,@Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "1", "100" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
,@Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
,@Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
,@Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
,@Parameter(in = ParameterIn.QUERY, description = "Filter consents by status" ,schema=@Schema(allowableValues={ "active", "expired", "revoked", "suspended" }
)) @Valid @RequestParam(value = "status", required = false) String status
,@Parameter(in = ParameterIn.QUERY, description = "Filter by specific data holder/institution" ,schema=@Schema()) @Valid @RequestParam(value = "data_holder_id", required = false) String dataHolderId
,@Parameter(in = ParameterIn.QUERY, description = "Filter by consent purpose" ,schema=@Schema()) @Valid @RequestParam(value = "purpose", required = false) String purpose
,@Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2003>(objectMapper.readValue("{\n  \"total_arrangements\" : 0,\n  \"customer_id\" : \"customer_id\",\n  \"active_arrangements\" : 6,\n  \"arrangements\" : [ {\n    \"data_holder_id\" : \"data_holder_id\",\n    \"sharing_duration\" : {\n      \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n    },\n    \"purpose\" : \"purpose\",\n    \"last_updated_at\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"permissions\" : [ \"permissions\", \"permissions\" ],\n    \"revocation_info\" : {\n      \"reason\" : \"reason\",\n      \"revoked_at\" : \"2000-01-23T04:56:07.000+00:00\"\n    },\n    \"additional_terms\" : [ {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    } ],\n    \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"id\" : \"id\",\n    \"status\" : \"active\"\n  }, {\n    \"data_holder_id\" : \"data_holder_id\",\n    \"sharing_duration\" : {\n      \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n    },\n    \"purpose\" : \"purpose\",\n    \"last_updated_at\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"permissions\" : [ \"permissions\", \"permissions\" ],\n    \"revocation_info\" : {\n      \"reason\" : \"reason\",\n      \"revoked_at\" : \"2000-01-23T04:56:07.000+00:00\"\n    },\n    \"additional_terms\" : [ {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    } ],\n    \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"id\" : \"id\",\n    \"status\" : \"active\"\n  } ]\n}", InlineResponse2003.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2003>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2003>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ConsentArrangementResponse>> listConsentArrangements(@Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
,@Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "1", "100" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
,@Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
,@Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
,@Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
,@Parameter(in = ParameterIn.QUERY, description = "Filter consents by status" ,schema=@Schema(allowableValues={ "active", "expired", "revoked", "suspended" }
)) @Valid @RequestParam(value = "status", required = false) String status
,@Parameter(in = ParameterIn.QUERY, description = "Filter consents created after this date" ,schema=@Schema()) @Valid @RequestParam(value = "from_date", required = false) OffsetDateTime fromDate
,@Parameter(in = ParameterIn.QUERY, description = "Filter consents created before this date" ,schema=@Schema()) @Valid @RequestParam(value = "to_date", required = false) OffsetDateTime toDate
,@Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ConsentArrangementResponse>>(objectMapper.readValue("[ {\n  \"data_holder_id\" : \"data_holder_id\",\n  \"sharing_duration\" : {\n    \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n  },\n  \"purpose\" : \"purpose\",\n  \"last_updated_at\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"permissions\" : [ \"permissions\", \"permissions\" ],\n  \"revocation_info\" : {\n    \"reason\" : \"reason\",\n    \"revoked_at\" : \"2000-01-23T04:56:07.000+00:00\"\n  },\n  \"additional_terms\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"id\" : \"id\",\n  \"status\" : \"active\"\n}, {\n  \"data_holder_id\" : \"data_holder_id\",\n  \"sharing_duration\" : {\n    \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n  },\n  \"purpose\" : \"purpose\",\n  \"last_updated_at\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"permissions\" : [ \"permissions\", \"permissions\" ],\n  \"revocation_info\" : {\n    \"reason\" : \"reason\",\n    \"revoked_at\" : \"2000-01-23T04:56:07.000+00:00\"\n  },\n  \"additional_terms\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"id\" : \"id\",\n  \"status\" : \"active\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ConsentArrangementResponse>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ConsentArrangementResponse>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ConsentTemplate>> listConsentTemplates(@Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
,@Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "1", "100" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
,@Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
,@Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
,@Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
,@Parameter(in = ParameterIn.QUERY, description = "Filter templates by category" ,schema=@Schema()) @Valid @RequestParam(value = "category", required = false) String category
,@Parameter(in = ParameterIn.QUERY, description = "Filter templates by purpose" ,schema=@Schema()) @Valid @RequestParam(value = "purpose", required = false) String purpose
,@Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ConsentTemplate>>(objectMapper.readValue("[ {\n  \"terms_and_conditions\" : \"terms_and_conditions\",\n  \"purpose\" : \"purpose\",\n  \"permissions\" : [ \"permissions\", \"permissions\" ],\n  \"data_usage_policy\" : \"data_usage_policy\",\n  \"name\" : \"name\",\n  \"description\" : \"description\",\n  \"template_id\" : \"template_id\",\n  \"category\" : \"category\",\n  \"version\" : \"version\",\n  \"default_duration\" : {\n    \"unit\" : \"days\",\n    \"value\" : 0\n  }\n}, {\n  \"terms_and_conditions\" : \"terms_and_conditions\",\n  \"purpose\" : \"purpose\",\n  \"permissions\" : [ \"permissions\", \"permissions\" ],\n  \"data_usage_policy\" : \"data_usage_policy\",\n  \"name\" : \"name\",\n  \"description\" : \"description\",\n  \"template_id\" : \"template_id\",\n  \"category\" : \"category\",\n  \"version\" : \"version\",\n  \"default_duration\" : {\n    \"unit\" : \"days\",\n    \"value\" : 0\n  }\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ConsentTemplate>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ConsentTemplate>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> revokeConsentArrangement(@Parameter(in = ParameterIn.PATH, description = "The ID of the consent arrangement to revoke", required=true, schema=@Schema()) @PathVariable("arrangement_id") String arrangementId
,@Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
,@Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "1", "100" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
,@Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
,@Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
,@Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
,@Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConsentArrangementResponse> updateConsentStatus(@Parameter(in = ParameterIn.HEADER, description = "Field referencing the unique identifier of the requesting participant." ,required=true,schema=@Schema()) @RequestHeader(value="participant-id", required=true) String participantId
,@Parameter(in = ParameterIn.HEADER, description = "Version of the API endpoint requested by the client. Must be set to a positive integer. If the version requested is not supported then the holder must respond with a 406 Not Acceptable." ,required=true,schema=@Schema(allowableValues={ "100", "1" }, minimum="1", maximum="100"
)) @RequestHeader(value="x-v", required=true) Integer xV
,@Parameter(in = ParameterIn.HEADER, description = "The time when the customer last logged in to the Data Recipient Software Product as described in [FAPI-1.0-Baseline]. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=true) OffsetDateTime xFapiAuthDate
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=true) String xFapiCustomerIpAddress
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original standard http headers Base64 encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-headers", required=true) String xClientHeaders
,@Parameter(in = ParameterIn.HEADER, description = "The customer's original User-Agent header Base64 encoded, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls." ,required=true,schema=@Schema()) @RequestHeader(value="x-client-user-agent", required=true) String xClientUserAgent
,@Parameter(in = ParameterIn.HEADER, description = "Unique idempotency key for the request as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-idempotency-key", required=true) UUID xIdempotencyKey
,@Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in to the client software as per FAPI Advanced requirements" ,required=true,schema=@Schema()) @RequestHeader(value="x-fapi-customer-last-logged-time", required=true) OffsetDateTime xFapiCustomerLastLoggedTime
,@Parameter(in = ParameterIn.PATH, description = "The ID of the consent arrangement", required=true, schema=@Schema()) @PathVariable("arrangement_id") String arrangementId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ConsentStatusUpdate body
,@Parameter(in = ParameterIn.HEADER, description = "An [RFC4122] UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) UUID xFapiInteractionId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConsentArrangementResponse>(objectMapper.readValue("{\n  \"data_holder_id\" : \"data_holder_id\",\n  \"sharing_duration\" : {\n    \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n  },\n  \"purpose\" : \"purpose\",\n  \"last_updated_at\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"permissions\" : [ \"permissions\", \"permissions\" ],\n  \"revocation_info\" : {\n    \"reason\" : \"reason\",\n    \"revoked_at\" : \"2000-01-23T04:56:07.000+00:00\"\n  },\n  \"additional_terms\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"id\" : \"id\",\n  \"status\" : \"active\"\n}", ConsentArrangementResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConsentArrangementResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConsentArrangementResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
