package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse2001;
import io.swagger.model.InlineResponse2002;
import io.swagger.model.InlineResponse2003;
import io.swagger.model.OauthAuthBody;
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
public class OauthApiController implements OauthApi {

    private static final Logger log = LoggerFactory.getLogger(OauthApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OauthApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> authorizeOAuth(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Client identifier issued to the client during registration" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "client_id", required = true) String clientId
,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Must be set to \"code\" for authorization code flow" ,required=true,schema=@Schema(allowableValues={ "code" }
)) @Valid @RequestParam(value = "response_type", required = true) String responseType
,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Space-separated list of requested scope values, OFxPERA requires openid to be included to maintain compatibility with OIDC." ,required=true,schema=@Schema(allowableValues={ "openid", "profile", "email", "address", "phone" }
)) @Valid @RequestParam(value = "scope", required = true) List<String> scope
,@NotNull @Parameter(in = ParameterIn.QUERY, description = "URI to return the user to after authorization is complete" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "redirect_uri", required = true) String redirectUri
,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Opaque value to maintain state between request and callback" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "state", required = true) String state
,@Parameter(in = ParameterIn.QUERY, description = "Code challenge for PKCE" ,schema=@Schema()) @Valid @RequestParam(value = "code_challenge", required = false) String codeChallenge
,@Parameter(in = ParameterIn.QUERY, description = "Code challenge method for PKCE" ,schema=@Schema(allowableValues={ "S256" }
)) @Valid @RequestParam(value = "code_challenge_method", required = false) String codeChallengeMethod
,@Parameter(in = ParameterIn.QUERY, description = "Prompt for the authorization request" ,schema=@Schema()) @Valid @RequestParam(value = "prompt", required = false) String prompt
,@Parameter(in = ParameterIn.QUERY, description = "Random value used to prevent replay attacks" ,schema=@Schema()) @Valid @RequestParam(value = "nonce", required = false) String nonce
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2001> getOAuthToken(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema(allowableValues={ "authorization_code", "refresh_token" }
)) @RequestParam(value="grant_type", required=true)  String grantType
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="code", required=true)  String code
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="redirect_uri", required=true)  String redirectUri
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="client_id", required=true)  String clientId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="refresh_token", required=true)  String refreshToken
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2001>(objectMapper.readValue("{\n  \"access_token\" : \"access_token\",\n  \"refresh_token\" : \"refresh_token\",\n  \"scope\" : \"scope\",\n  \"id_token\" : \"id_token\",\n  \"token_type\" : \"Bearer\",\n  \"expires_in\" : 0\n}", InlineResponse2001.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2001>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2001>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2003> getUserInfo() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2003>(objectMapper.readValue("{\n  \"sub\" : \"sub\",\n  \"email_verified\" : true,\n  \"name\" : \"name\",\n  \"phone_number_verified\" : true,\n  \"phone_number\" : \"phone_number\",\n  \"given_name\" : \"given_name\",\n  \"family_name\" : \"family_name\",\n  \"email\" : \"\"\n}", InlineResponse2003.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2003>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2003>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2002> introspectToken(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "token", required = true) String token
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2002>(objectMapper.readValue("{\n  \"scope\" : \"scope\",\n  \"active\" : true,\n  \"exp\" : 0,\n  \"iat\" : 6,\n  \"client_id\" : \"client_id\",\n  \"username\" : \"username\"\n}", InlineResponse2002.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2002>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2002>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse200> oAuthPAR(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody OauthAuthBody body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse200>(objectMapper.readValue("{\n  \"request_uri\" : \"http://example.com/aeiou\"\n}", InlineResponse200.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse200>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse200>(HttpStatus.NOT_IMPLEMENTED);
    }

}
