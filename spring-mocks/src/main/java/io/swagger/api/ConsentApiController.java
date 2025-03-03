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
import io.swagger.model.InlineResponse2005;
import io.swagger.model.InlineResponse2006;
import org.threeten.bp.OffsetDateTime;
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
public class ConsentApiController implements ConsentApi {

    private static final Logger log = LoggerFactory.getLogger(ConsentApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ConsentApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<InlineResponse2006> bulkUpdateCustomerConsents(@Parameter(in = ParameterIn.PATH, description = "The customer's unique identifier", required=true, schema=@Schema()) @PathVariable("customer_id") String customerId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ArrangementsBulkupdateBody body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2006>(objectMapper.readValue("{\n  \"customer_id\" : \"customer_id\",\n  \"results\" : [ {\n    \"id\" : \"id\",\n    \"error\" : {\n      \"code\" : \"code\",\n      \"message\" : \"message\"\n    },\n    \"status\" : \"success\"\n  }, {\n    \"id\" : \"id\",\n    \"error\" : {\n      \"code\" : \"code\",\n      \"message\" : \"message\"\n    },\n    \"status\" : \"success\"\n  } ]\n}", InlineResponse2006.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2006>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2006>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BulkConsentResponse> createBulkConsent(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody BulkConsentRequest body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BulkConsentResponse>(objectMapper.readValue("{\n  \"batch_id\" : \"batch_id\",\n  \"results\" : [ {\n    \"arrangement\" : {\n      \"data_holder_id\" : \"data_holder_id\",\n      \"sharing_duration\" : {\n        \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n      },\n      \"purpose\" : \"purpose\",\n      \"last_updated_at\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"permissions\" : [ \"permissions\", \"permissions\" ],\n      \"revocation_info\" : {\n        \"reason\" : \"reason\",\n        \"revoked_at\" : \"2000-01-23T04:56:07.000+00:00\"\n      },\n      \"additional_terms\" : [ {\n        \"value\" : \"value\",\n        \"key\" : \"key\"\n      }, {\n        \"value\" : \"value\",\n        \"key\" : \"key\"\n      } ],\n      \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"id\" : \"id\",\n      \"status\" : \"active\"\n    },\n    \"error\" : {\n      \"code\" : \"code\",\n      \"message\" : \"message\"\n    },\n    \"status\" : \"success\"\n  }, {\n    \"arrangement\" : {\n      \"data_holder_id\" : \"data_holder_id\",\n      \"sharing_duration\" : {\n        \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n      },\n      \"purpose\" : \"purpose\",\n      \"last_updated_at\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"permissions\" : [ \"permissions\", \"permissions\" ],\n      \"revocation_info\" : {\n        \"reason\" : \"reason\",\n        \"revoked_at\" : \"2000-01-23T04:56:07.000+00:00\"\n      },\n      \"additional_terms\" : [ {\n        \"value\" : \"value\",\n        \"key\" : \"key\"\n      }, {\n        \"value\" : \"value\",\n        \"key\" : \"key\"\n      } ],\n      \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"id\" : \"id\",\n      \"status\" : \"active\"\n    },\n    \"error\" : {\n      \"code\" : \"code\",\n      \"message\" : \"message\"\n    },\n    \"status\" : \"success\"\n  } ]\n}", BulkConsentResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BulkConsentResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BulkConsentResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConsentArrangementResponse> createConsentArrangement(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ConsentArrangementRequest body
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

    public ResponseEntity<ConsentArrangementResponse> extendConsentDuration(@Parameter(in = ParameterIn.PATH, description = "The ID of the consent arrangement", required=true, schema=@Schema()) @PathVariable("arrangement_id") String arrangementId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ConsentExtensionRequest body
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

    public ResponseEntity<InlineResponse2005> getCustomerConsents(@Parameter(in = ParameterIn.PATH, description = "The customer's unique identifier", required=true, schema=@Schema()) @PathVariable("customer_id") String customerId
,@Parameter(in = ParameterIn.QUERY, description = "Filter consents by status" ,schema=@Schema(allowableValues={ "active", "expired", "revoked", "suspended" }
)) @Valid @RequestParam(value = "status", required = false) String status
,@Parameter(in = ParameterIn.QUERY, description = "Filter by specific data holder/institution" ,schema=@Schema()) @Valid @RequestParam(value = "data_holder_id", required = false) String dataHolderId
,@Parameter(in = ParameterIn.QUERY, description = "Filter by consent purpose" ,schema=@Schema()) @Valid @RequestParam(value = "purpose", required = false) String purpose
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2005>(objectMapper.readValue("{\n  \"total_arrangements\" : 0,\n  \"customer_id\" : \"customer_id\",\n  \"active_arrangements\" : 6,\n  \"arrangements\" : [ {\n    \"data_holder_id\" : \"data_holder_id\",\n    \"sharing_duration\" : {\n      \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n    },\n    \"purpose\" : \"purpose\",\n    \"last_updated_at\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"permissions\" : [ \"permissions\", \"permissions\" ],\n    \"revocation_info\" : {\n      \"reason\" : \"reason\",\n      \"revoked_at\" : \"2000-01-23T04:56:07.000+00:00\"\n    },\n    \"additional_terms\" : [ {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    } ],\n    \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"id\" : \"id\",\n    \"status\" : \"active\"\n  }, {\n    \"data_holder_id\" : \"data_holder_id\",\n    \"sharing_duration\" : {\n      \"end_date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n    },\n    \"purpose\" : \"purpose\",\n    \"last_updated_at\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"permissions\" : [ \"permissions\", \"permissions\" ],\n    \"revocation_info\" : {\n      \"reason\" : \"reason\",\n      \"revoked_at\" : \"2000-01-23T04:56:07.000+00:00\"\n    },\n    \"additional_terms\" : [ {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    } ],\n    \"created_at\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"id\" : \"id\",\n    \"status\" : \"active\"\n  } ]\n}", InlineResponse2005.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2005>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2005>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ConsentArrangementResponse>> listConsentArrangements(@Parameter(in = ParameterIn.QUERY, description = "Filter consents by status" ,schema=@Schema(allowableValues={ "active", "expired", "revoked", "suspended" }
)) @Valid @RequestParam(value = "status", required = false) String status
,@Parameter(in = ParameterIn.QUERY, description = "Filter consents created after this date" ,schema=@Schema()) @Valid @RequestParam(value = "from_date", required = false) OffsetDateTime fromDate
,@Parameter(in = ParameterIn.QUERY, description = "Filter consents created before this date" ,schema=@Schema()) @Valid @RequestParam(value = "to_date", required = false) OffsetDateTime toDate
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

    public ResponseEntity<List<ConsentTemplate>> listConsentTemplates(@Parameter(in = ParameterIn.QUERY, description = "Filter templates by category" ,schema=@Schema()) @Valid @RequestParam(value = "category", required = false) String category
,@Parameter(in = ParameterIn.QUERY, description = "Filter templates by purpose" ,schema=@Schema()) @Valid @RequestParam(value = "purpose", required = false) String purpose
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
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConsentArrangementResponse> updateConsentStatus(@Parameter(in = ParameterIn.PATH, description = "The ID of the consent arrangement", required=true, schema=@Schema()) @PathVariable("arrangement_id") String arrangementId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ConsentStatusUpdate body
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
