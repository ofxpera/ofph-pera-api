package io.swagger.api;

import io.swagger.model.CustomerInformation;
import io.swagger.model.EndorsementResponse;
import io.swagger.model.Error;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")
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
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CustomerInformation>(objectMapper.readValue("{\n  \"arrangementId\" : \"arrangementId\",\n  \"sub\" : \"sub\",\n  \"cdd\" : {\n    \"pepIndicator\" : false,\n    \"occupation\" : \"occupation\",\n    \"employerAddress\" : {\n      \"street_address\" : \"street_address\",\n      \"country\" : \"PHL\",\n      \"province\" : \"province\",\n      \"city\" : \"city\",\n      \"region\" : \"region\",\n      \"postal_code\" : \"postal_code\",\n      \"barangay\" : \"barangay\"\n    },\n    \"natureOfWork\" : \"natureOfWork\",\n    \"cddIndicator\" : \"Normal\",\n    \"employerName\" : \"employerName\",\n    \"employmentStatus\" : \"employmentStatus\",\n    \"fundSource\" : \"fundSource\"\n  },\n  \"presentedIds\" : [ {\n    \"idType\" : \"idType\",\n    \"idExpiryDate\" : \"2000-01-23\",\n    \"idNumber\" : \"idNumber\"\n  }, {\n    \"idType\" : \"idType\",\n    \"idExpiryDate\" : \"2000-01-23\",\n    \"idNumber\" : \"idNumber\"\n  } ],\n  \"personalInformation\" : {\n    \"sub\" : \"sub\",\n    \"lastName\" : \"lastName\",\n    \"phoneNumber\" : \"63287654321\",\n    \"birthdate\" : \"2000-01-23\",\n    \"nationality\" : \"nationality\",\n    \"mobileNumber\" : \"639171234567\",\n    \"givenName\" : \"givenName\",\n    \"tin\" : \"tin\",\n    \"middleName\" : \"middleName\",\n    \"title\" : \"title\",\n    \"suffix\" : \"suffix\",\n    \"email\" : \"\"\n  },\n  \"peraAdmin\" : \"peraAdmin\"\n}", CustomerInformation.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CustomerInformation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CustomerInformation>(HttpStatus.NOT_IMPLEMENTED);
    }

}
