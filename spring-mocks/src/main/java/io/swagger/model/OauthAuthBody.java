package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.EndorsementDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OauthAuthBody
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class OauthAuthBody   {
  @JsonProperty("participant_id")

  private String participantId = null;

  @JsonProperty("endorsement_details")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private EndorsementDetails endorsementDetails = null;

  @JsonProperty("authorization_code")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String authorizationCode = null;

  /**
   * Must be set to \"code\" for authorization code flow
   */
  public enum ResponseTypeEnum {
    CODE("code"),
    
    ENDORSEMENT("endorsement");

    private String value;

    ResponseTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ResponseTypeEnum fromValue(String text) {
      for (ResponseTypeEnum b : ResponseTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("response_type")

  private ResponseTypeEnum responseType = null;

  /**
   * Gets or Sets scope
   */
  public enum ScopeEnum {
    OPENID("openid"),
    
    PROFILE("profile"),
    
    EMAIL("email"),
    
    ADDRESS("address"),
    
    PHONE("phone");

    private String value;

    ScopeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ScopeEnum fromValue(String text) {
      for (ScopeEnum b : ScopeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("scope")
  @Valid
  private List<ScopeEnum> scope = null;
  @JsonProperty("token_endpoint")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String tokenEndpoint = null;

  @JsonProperty("code_challenge")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String codeChallenge = null;

  /**
   * Code challenge method for PKCE
   */
  public enum CodeChallengeMethodEnum {
    S256("S256");

    private String value;

    CodeChallengeMethodEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CodeChallengeMethodEnum fromValue(String text) {
      for (CodeChallengeMethodEnum b : CodeChallengeMethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("code_challenge_method")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private CodeChallengeMethodEnum codeChallengeMethod = null;

  @JsonProperty("state")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String state = null;

  @JsonProperty("prompt")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String prompt = null;

  @JsonProperty("nonce")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String nonce = null;


  public OauthAuthBody participantId(String participantId) { 

    this.participantId = participantId;
    return this;
  }

  /**
   * Participant identifier of the FI issued during registration
   * @return participantId
   **/
  
  @Schema(required = true, description = "Participant identifier of the FI issued during registration")
  
  @NotNull
  public String getParticipantId() {  
    return participantId;
  }



  public void setParticipantId(String participantId) { 

    this.participantId = participantId;
  }

  public OauthAuthBody endorsementDetails(EndorsementDetails endorsementDetails) { 

    this.endorsementDetails = endorsementDetails;
    return this;
  }

  /**
   * Get endorsementDetails
   * @return endorsementDetails
   **/
  
  @Schema(description = "")
  
@Valid
  public EndorsementDetails getEndorsementDetails() {  
    return endorsementDetails;
  }



  public void setEndorsementDetails(EndorsementDetails endorsementDetails) { 
    this.endorsementDetails = endorsementDetails;
  }

  public OauthAuthBody authorizationCode(String authorizationCode) { 

    this.authorizationCode = authorizationCode;
    return this;
  }

  /**
   * Authorization code
   * @return authorizationCode
   **/
  
  @Schema(description = "Authorization code")
  
  public String getAuthorizationCode() {  
    return authorizationCode;
  }



  public void setAuthorizationCode(String authorizationCode) { 
    this.authorizationCode = authorizationCode;
  }

  public OauthAuthBody responseType(ResponseTypeEnum responseType) { 

    this.responseType = responseType;
    return this;
  }

  /**
   * Must be set to \"code\" for authorization code flow
   * @return responseType
   **/
  
  @Schema(required = true, description = "Must be set to \"code\" for authorization code flow")
  
  @NotNull
  public ResponseTypeEnum getResponseType() {  
    return responseType;
  }



  public void setResponseType(ResponseTypeEnum responseType) { 

    this.responseType = responseType;
  }

  public OauthAuthBody scope(List<ScopeEnum> scope) { 

    this.scope = scope;
    return this;
  }

  public OauthAuthBody addScopeItem(ScopeEnum scopeItem) {
    if (this.scope == null) {
      this.scope = new ArrayList<ScopeEnum>();
    }
    this.scope.add(scopeItem);
    return this;
  }

  /**
   * Space-separated list of requested scope values, OFxPERA requires openid to be included to maintain compatibility with OIDC.
   * @return scope
   **/
  
  @Schema(description = "Space-separated list of requested scope values, OFxPERA requires openid to be included to maintain compatibility with OIDC.")
  
  public List<ScopeEnum> getScope() {  
    return scope;
  }



  public void setScope(List<ScopeEnum> scope) { 
    this.scope = scope;
  }

  public OauthAuthBody tokenEndpoint(String tokenEndpoint) { 

    this.tokenEndpoint = tokenEndpoint;
    return this;
  }

  /**
   * URI of the token endpoint for retrieving access tokens
   * @return tokenEndpoint
   **/
  
  @Schema(description = "URI of the token endpoint for retrieving access tokens")
  
  public String getTokenEndpoint() {  
    return tokenEndpoint;
  }



  public void setTokenEndpoint(String tokenEndpoint) { 
    this.tokenEndpoint = tokenEndpoint;
  }

  public OauthAuthBody codeChallenge(String codeChallenge) { 

    this.codeChallenge = codeChallenge;
    return this;
  }

  /**
   * Code challenge for PKCE
   * @return codeChallenge
   **/
  
  @Schema(description = "Code challenge for PKCE")
  
  public String getCodeChallenge() {  
    return codeChallenge;
  }



  public void setCodeChallenge(String codeChallenge) { 
    this.codeChallenge = codeChallenge;
  }

  public OauthAuthBody codeChallengeMethod(CodeChallengeMethodEnum codeChallengeMethod) { 

    this.codeChallengeMethod = codeChallengeMethod;
    return this;
  }

  /**
   * Code challenge method for PKCE
   * @return codeChallengeMethod
   **/
  
  @Schema(description = "Code challenge method for PKCE")
  
  public CodeChallengeMethodEnum getCodeChallengeMethod() {  
    return codeChallengeMethod;
  }



  public void setCodeChallengeMethod(CodeChallengeMethodEnum codeChallengeMethod) { 
    this.codeChallengeMethod = codeChallengeMethod;
  }

  public OauthAuthBody state(String state) { 

    this.state = state;
    return this;
  }

  /**
   * Opaque value to maintain state between request and callback
   * @return state
   **/
  
  @Schema(description = "Opaque value to maintain state between request and callback")
  
  public String getState() {  
    return state;
  }



  public void setState(String state) { 
    this.state = state;
  }

  public OauthAuthBody prompt(String prompt) { 

    this.prompt = prompt;
    return this;
  }

  /**
   * Prompt for the authorization request
   * @return prompt
   **/
  
  @Schema(description = "Prompt for the authorization request")
  
  public String getPrompt() {  
    return prompt;
  }



  public void setPrompt(String prompt) { 
    this.prompt = prompt;
  }

  public OauthAuthBody nonce(String nonce) { 

    this.nonce = nonce;
    return this;
  }

  /**
   * Random value used to prevent replay attacks
   * @return nonce
   **/
  
  @Schema(description = "Random value used to prevent replay attacks")
  
  public String getNonce() {  
    return nonce;
  }



  public void setNonce(String nonce) { 
    this.nonce = nonce;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OauthAuthBody oauthAuthBody = (OauthAuthBody) o;
    return Objects.equals(this.participantId, oauthAuthBody.participantId) &&
        Objects.equals(this.endorsementDetails, oauthAuthBody.endorsementDetails) &&
        Objects.equals(this.authorizationCode, oauthAuthBody.authorizationCode) &&
        Objects.equals(this.responseType, oauthAuthBody.responseType) &&
        Objects.equals(this.scope, oauthAuthBody.scope) &&
        Objects.equals(this.tokenEndpoint, oauthAuthBody.tokenEndpoint) &&
        Objects.equals(this.codeChallenge, oauthAuthBody.codeChallenge) &&
        Objects.equals(this.codeChallengeMethod, oauthAuthBody.codeChallengeMethod) &&
        Objects.equals(this.state, oauthAuthBody.state) &&
        Objects.equals(this.prompt, oauthAuthBody.prompt) &&
        Objects.equals(this.nonce, oauthAuthBody.nonce);
  }

  @Override
  public int hashCode() {
    return Objects.hash(participantId, endorsementDetails, authorizationCode, responseType, scope, tokenEndpoint, codeChallenge, codeChallengeMethod, state, prompt, nonce);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OauthAuthBody {\n");
    
    sb.append("    participantId: ").append(toIndentedString(participantId)).append("\n");
    sb.append("    endorsementDetails: ").append(toIndentedString(endorsementDetails)).append("\n");
    sb.append("    authorizationCode: ").append(toIndentedString(authorizationCode)).append("\n");
    sb.append("    responseType: ").append(toIndentedString(responseType)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    tokenEndpoint: ").append(toIndentedString(tokenEndpoint)).append("\n");
    sb.append("    codeChallenge: ").append(toIndentedString(codeChallenge)).append("\n");
    sb.append("    codeChallengeMethod: ").append(toIndentedString(codeChallengeMethod)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    prompt: ").append(toIndentedString(prompt)).append("\n");
    sb.append("    nonce: ").append(toIndentedString(nonce)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
