package io.swagger.api;

import io.swagger.model.ClientRegistrationResponse;
import io.swagger.model.Error;
import io.swagger.model.ParticipantConfig;
import io.swagger.model.PeraArrangement;
import io.swagger.model.PeraProduct;
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
public class OfxperaApiController implements OfxperaApi {

    private static final Logger log = LoggerFactory.getLogger(OfxperaApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OfxperaApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<PeraArrangement> getArrangementStatus(@Parameter(in = ParameterIn.PATH, description = "The ID of the PERA Arrangement", required=true, schema=@Schema()) @PathVariable("arrangement_id") String arrangementId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PeraArrangement>(objectMapper.readValue("{\n  \"sub\" : \"sub\",\n  \"admin_id\" : \"admin_id\",\n  \"id\" : \"id\",\n  \"creation_date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"customer_id\" : \"customer_id\",\n  \"consent_id\" : \"consent_id\",\n  \"account\" : {\n    \"product\" : {\n      \"product_kiid_uri\" : \"product_kiid_uri\",\n      \"product_id\" : \"product_id\",\n      \"product_description\" : \"product_description\",\n      \"product_name\" : \"product_name\",\n      \"product_risk_rating\" : \"Conservative\"\n    },\n    \"balance\" : {\n      \"as_of\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"currency\" : \"PHP\",\n      \"current_value\" : 0.8008281904610115\n    },\n    \"id\" : \"id\",\n    \"creation_date\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"customer_id\" : \"customer_id\"\n  },\n  \"status\" : \"ACTIVE\"\n}", PeraArrangement.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PeraArrangement>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PeraArrangement>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ParticipantConfig> getParticipant(@Parameter(in = ParameterIn.PATH, description = "Participant identifier issued during participant registration", required=true, schema=@Schema()) @PathVariable("participant_id") String participantId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ParticipantConfig>(objectMapper.readValue("\"\"", ParticipantConfig.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ParticipantConfig>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ParticipantConfig>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ParticipantConfig>> listParticipants() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ParticipantConfig>>(objectMapper.readValue("[ \"\", \"\" ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ParticipantConfig>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ParticipantConfig>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<PeraProduct>> listProductByParticipant(@Parameter(in = ParameterIn.PATH, description = "Participant identifier issued during Participant registration", required=true, schema=@Schema()) @PathVariable("participant_id") String participantId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<PeraProduct>>(objectMapper.readValue("[ {\n  \"product_kiid_uri\" : \"product_kiid_uri\",\n  \"product_id\" : \"product_id\",\n  \"product_description\" : \"product_description\",\n  \"product_name\" : \"product_name\",\n  \"product_risk_rating\" : \"Conservative\"\n}, {\n  \"product_kiid_uri\" : \"product_kiid_uri\",\n  \"product_id\" : \"product_id\",\n  \"product_description\" : \"product_description\",\n  \"product_name\" : \"product_name\",\n  \"product_risk_rating\" : \"Conservative\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<PeraProduct>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<PeraProduct>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<PeraArrangement> peraArrangementRegistration() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PeraArrangement>(objectMapper.readValue("{\n  \"sub\" : \"sub\",\n  \"admin_id\" : \"admin_id\",\n  \"id\" : \"id\",\n  \"creation_date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"customer_id\" : \"customer_id\",\n  \"consent_id\" : \"consent_id\",\n  \"account\" : {\n    \"product\" : {\n      \"product_kiid_uri\" : \"product_kiid_uri\",\n      \"product_id\" : \"product_id\",\n      \"product_description\" : \"product_description\",\n      \"product_name\" : \"product_name\",\n      \"product_risk_rating\" : \"Conservative\"\n    },\n    \"balance\" : {\n      \"as_of\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"currency\" : \"PHP\",\n      \"current_value\" : 0.8008281904610115\n    },\n    \"id\" : \"id\",\n    \"creation_date\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"customer_id\" : \"customer_id\"\n  },\n  \"status\" : \"ACTIVE\"\n}", PeraArrangement.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PeraArrangement>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PeraArrangement>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ClientRegistrationResponse> registerParticipant(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ParticipantConfig body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ClientRegistrationResponse>(objectMapper.readValue("{\n  \"registration_client_uri\" : \"http://example.com/aeiou\",\n  \"client_id_issued_at\" : 0,\n  \"registration_access_token\" : \"registration_access_token\",\n  \"client_id\" : \"client_id\"\n}", ClientRegistrationResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ClientRegistrationResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ClientRegistrationResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<PeraProduct> registerProduct() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PeraProduct>(objectMapper.readValue("{\n  \"product_kiid_uri\" : \"product_kiid_uri\",\n  \"product_id\" : \"product_id\",\n  \"product_description\" : \"product_description\",\n  \"product_name\" : \"product_name\",\n  \"product_risk_rating\" : \"Conservative\"\n}", PeraProduct.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PeraProduct>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PeraProduct>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ClientRegistrationResponse> updateParticipant(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ParticipantConfig body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ClientRegistrationResponse>(objectMapper.readValue("{\n  \"registration_client_uri\" : \"http://example.com/aeiou\",\n  \"client_id_issued_at\" : 0,\n  \"registration_access_token\" : \"registration_access_token\",\n  \"client_id\" : \"client_id\"\n}", ClientRegistrationResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ClientRegistrationResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ClientRegistrationResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<PeraProduct> updateProduct(@Parameter(in = ParameterIn.PATH, description = "Product identifier issued during product registration", required=true, schema=@Schema()) @PathVariable("product_id") String productId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PeraProduct>(objectMapper.readValue("{\n  \"product_kiid_uri\" : \"product_kiid_uri\",\n  \"product_id\" : \"product_id\",\n  \"product_description\" : \"product_description\",\n  \"product_name\" : \"product_name\",\n  \"product_risk_rating\" : \"Conservative\"\n}", PeraProduct.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PeraProduct>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PeraProduct>(HttpStatus.NOT_IMPLEMENTED);
    }

}
