package io.swagger.api;

import io.swagger.model.CustomerInformation;
import io.swagger.model.EndorsementResponse;
import io.swagger.model.Error;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")
@RestController
public class CommonApiController implements CommonApi {

    private static final Logger log = LoggerFactory.getLogger(CommonApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CommonApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<EndorsementResponse> forwardCustomerEndorsement(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Encrypted endorsement payload in JWS/JWE format" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "endorsement", required = true) String endorsement
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
                return new ResponseEntity<EndorsementResponse>(objectMapper.readValue("{\n  \"endorsement_details\" : {\n    \"sub\" : \"sub\",\n    \"endorsement_date\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"reference_id\" : \"reference_id\",\n    \"endorser_id\" : \"endorser_id\"\n  },\n  \"message\" : \"message\",\n  \"status\" : \"SUCCESS\",\n  \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\"\n}", EndorsementResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EndorsementResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EndorsementResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CustomerInformation> getCustomerDetail(@Parameter(in = ParameterIn.PATH, description = "Customer ID, this should map to the sub field returned from the OIDC token endpoint or the sub field returned from the /oauth/userinfo endpoint", required=true, schema=@Schema()) @PathVariable("customer_id") String customerId
,@Parameter(in = ParameterIn.HEADER, description = "Bearer token for authentication. Must be in the format 'Bearer <token>'" ,required=true,schema=@Schema()) @RequestHeader(value="Authorization", required=true) String authorization
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
                return new ResponseEntity<CustomerInformation>(objectMapper.readValue("{\n  \"arrangementId\" : \"arrangementId\",\n  \"sub\" : \"sub\",\n  \"cdd\" : {\n    \"pepIndicator\" : false,\n    \"occupation\" : \"occupation\",\n    \"employerAddress\" : \"\",\n    \"natureOfWork\" : \"natureOfWork\",\n    \"cddIndicator\" : \"Normal\",\n    \"employerName\" : \"employerName\",\n    \"employmentStatus\" : \"employmentStatus\",\n    \"fundSource\" : \"fundSource\"\n  },\n  \"presentedIds\" : [ {\n    \"idType\" : \"idType\",\n    \"idExpiryDate\" : \"2000-01-23\",\n    \"idNumber\" : \"idNumber\"\n  }, {\n    \"idType\" : \"idType\",\n    \"idExpiryDate\" : \"2000-01-23\",\n    \"idNumber\" : \"idNumber\"\n  } ],\n  \"personalInformation\" : {\n    \"sub\" : \"sub\",\n    \"lastName\" : \"lastName\",\n    \"birthdate\" : \"2000-01-23\",\n    \"mobileNumber\" : \"639171234567\",\n    \"givenName\" : \"givenName\",\n    \"title\" : \"title\",\n    \"suffix\" : \"suffix\",\n    \"phoneNumber\" : \"63287654321\",\n    \"nationality\" : \"nationality\",\n    \"residentialAddress\" : \"\",\n    \"tin\" : \"tin\",\n    \"middleName\" : \"middleName\",\n    \"email\" : \"\"\n  },\n  \"peraAdmin\" : \"peraAdmin\"\n}", CustomerInformation.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CustomerInformation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CustomerInformation>(HttpStatus.NOT_IMPLEMENTED);
    }

}
