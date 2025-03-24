package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OauthTokenBody
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class OauthTokenBody   {
  /**
   * Gets or Sets grantType
   */
  public enum GrantTypeEnum {
    AUTHORIZATION_CODE("authorization_code"),
    
    REFRESH_TOKEN("refresh_token");

    private String value;

    GrantTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GrantTypeEnum fromValue(String text) {
      for (GrantTypeEnum b : GrantTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("grant_type")

  private GrantTypeEnum grantType = null;

  @JsonProperty("code")

  private String code = null;

  @JsonProperty("redirect_uri")

  private String redirectUri = null;

  @JsonProperty("client_id")

  private String clientId = null;

  @JsonProperty("refresh_token")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String refreshToken = null;

  /**
   * value must be \"urn:ietf:params:oauth:assertion-type:jwt-bearer\"
   */
  public enum ClientAssertionTypeEnum {
    URN_IETF_PARAMS_OAUTH_ASSERTION_TYPE_JWT_BEARER("urn:ietf:params:oauth:assertion-type:jwt-bearer");

    private String value;

    ClientAssertionTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ClientAssertionTypeEnum fromValue(String text) {
      for (ClientAssertionTypeEnum b : ClientAssertionTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("client_assertion_type")

  private ClientAssertionTypeEnum clientAssertionType = null;

  @JsonProperty("client_assertion")

  private String clientAssertion = null;


  public OauthTokenBody grantType(GrantTypeEnum grantType) { 

    this.grantType = grantType;
    return this;
  }

  /**
   * Get grantType
   * @return grantType
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public GrantTypeEnum getGrantType() {  
    return grantType;
  }



  public void setGrantType(GrantTypeEnum grantType) { 

    this.grantType = grantType;
  }

  public OauthTokenBody code(String code) { 

    this.code = code;
    return this;
  }

  /**
   * Authorization code received from the authorization server.
   * @return code
   **/
  
  @Schema(required = true, description = "Authorization code received from the authorization server.")
  
  @NotNull
  public String getCode() {  
    return code;
  }



  public void setCode(String code) { 

    this.code = code;
  }

  public OauthTokenBody redirectUri(String redirectUri) { 

    this.redirectUri = redirectUri;
    return this;
  }

  /**
   * Redirect URI used in the authorization request.
   * @return redirectUri
   **/
  
  @Schema(required = true, description = "Redirect URI used in the authorization request.")
  
  @NotNull
  public String getRedirectUri() {  
    return redirectUri;
  }



  public void setRedirectUri(String redirectUri) { 

    this.redirectUri = redirectUri;
  }

  public OauthTokenBody clientId(String clientId) { 

    this.clientId = clientId;
    return this;
  }

  /**
   * Client identifier for the token request.
   * @return clientId
   **/
  
  @Schema(required = true, description = "Client identifier for the token request.")
  
  @NotNull
  public String getClientId() {  
    return clientId;
  }



  public void setClientId(String clientId) { 

    this.clientId = clientId;
  }

  public OauthTokenBody refreshToken(String refreshToken) { 

    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * Refresh token used to obtain a new access token.
   * @return refreshToken
   **/
  
  @Schema(description = "Refresh token used to obtain a new access token.")
  
  public String getRefreshToken() {  
    return refreshToken;
  }



  public void setRefreshToken(String refreshToken) { 
    this.refreshToken = refreshToken;
  }

  public OauthTokenBody clientAssertionType(ClientAssertionTypeEnum clientAssertionType) { 

    this.clientAssertionType = clientAssertionType;
    return this;
  }

  /**
   * value must be \"urn:ietf:params:oauth:assertion-type:jwt-bearer\"
   * @return clientAssertionType
   **/
  
  @Schema(required = true, description = "value must be \"urn:ietf:params:oauth:assertion-type:jwt-bearer\"")
  
  @NotNull
  public ClientAssertionTypeEnum getClientAssertionType() {  
    return clientAssertionType;
  }



  public void setClientAssertionType(ClientAssertionTypeEnum clientAssertionType) { 

    this.clientAssertionType = clientAssertionType;
  }

  public OauthTokenBody clientAssertion(String clientAssertion) { 

    this.clientAssertion = clientAssertion;
    return this;
  }

  /**
   * JWT assertion containing client credentials.
   * @return clientAssertion
   **/
  
  @Schema(required = true, description = "JWT assertion containing client credentials.")
  
  @NotNull
  public String getClientAssertion() {  
    return clientAssertion;
  }



  public void setClientAssertion(String clientAssertion) { 

    this.clientAssertion = clientAssertion;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OauthTokenBody oauthTokenBody = (OauthTokenBody) o;
    return Objects.equals(this.grantType, oauthTokenBody.grantType) &&
        Objects.equals(this.code, oauthTokenBody.code) &&
        Objects.equals(this.redirectUri, oauthTokenBody.redirectUri) &&
        Objects.equals(this.clientId, oauthTokenBody.clientId) &&
        Objects.equals(this.refreshToken, oauthTokenBody.refreshToken) &&
        Objects.equals(this.clientAssertionType, oauthTokenBody.clientAssertionType) &&
        Objects.equals(this.clientAssertion, oauthTokenBody.clientAssertion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(grantType, code, redirectUri, clientId, refreshToken, clientAssertionType, clientAssertion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OauthTokenBody {\n");
    
    sb.append("    grantType: ").append(toIndentedString(grantType)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    redirectUri: ").append(toIndentedString(redirectUri)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
    sb.append("    clientAssertionType: ").append(toIndentedString(clientAssertionType)).append("\n");
    sb.append("    clientAssertion: ").append(toIndentedString(clientAssertion)).append("\n");
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
