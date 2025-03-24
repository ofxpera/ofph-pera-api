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
 * TokenResponse
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class TokenResponse   {
  @JsonProperty("access_token")

  private String accessToken = null;

  /**
   * Type of access token, fixed to Bearer
   */
  public enum TokenTypeEnum {
    BEARER("Bearer");

    private String value;

    TokenTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TokenTypeEnum fromValue(String text) {
      for (TokenTypeEnum b : TokenTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("token_type")

  private TokenTypeEnum tokenType = null;

  @JsonProperty("expires_in")

  private Integer expiresIn = null;

  @JsonProperty("refresh_token")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String refreshToken = null;

  @JsonProperty("id_token")

  private String idToken = null;

  @JsonProperty("scope")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String scope = null;


  public TokenResponse accessToken(String accessToken) { 

    this.accessToken = accessToken;
    return this;
  }

  /**
   * The access token string as issued by the authorization server
   * @return accessToken
   **/
  
  @Schema(required = true, description = "The access token string as issued by the authorization server")
  
  @NotNull
  public String getAccessToken() {  
    return accessToken;
  }



  public void setAccessToken(String accessToken) { 

    this.accessToken = accessToken;
  }

  public TokenResponse tokenType(TokenTypeEnum tokenType) { 

    this.tokenType = tokenType;
    return this;
  }

  /**
   * Type of access token, fixed to Bearer
   * @return tokenType
   **/
  
  @Schema(required = true, description = "Type of access token, fixed to Bearer")
  
  @NotNull
  public TokenTypeEnum getTokenType() {  
    return tokenType;
  }



  public void setTokenType(TokenTypeEnum tokenType) { 

    this.tokenType = tokenType;
  }

  public TokenResponse expiresIn(Integer expiresIn) { 

    this.expiresIn = expiresIn;
    return this;
  }

  /**
   * Lifetime in seconds of the access token
   * @return expiresIn
   **/
  
  @Schema(required = true, description = "Lifetime in seconds of the access token")
  
  @NotNull
  public Integer getExpiresIn() {  
    return expiresIn;
  }



  public void setExpiresIn(Integer expiresIn) { 

    this.expiresIn = expiresIn;
  }

  public TokenResponse refreshToken(String refreshToken) { 

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

  public TokenResponse idToken(String idToken) { 

    this.idToken = idToken;
    return this;
  }

  /**
   * ID Token value associated with the authenticated session
   * @return idToken
   **/
  
  @Schema(required = true, description = "ID Token value associated with the authenticated session")
  
  @NotNull
  public String getIdToken() {  
    return idToken;
  }



  public void setIdToken(String idToken) { 

    this.idToken = idToken;
  }

  public TokenResponse scope(String scope) { 

    this.scope = scope;
    return this;
  }

  /**
   * Space-separated list of scopes granted
   * @return scope
   **/
  
  @Schema(description = "Space-separated list of scopes granted")
  
  public String getScope() {  
    return scope;
  }



  public void setScope(String scope) { 
    this.scope = scope;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenResponse tokenResponse = (TokenResponse) o;
    return Objects.equals(this.accessToken, tokenResponse.accessToken) &&
        Objects.equals(this.tokenType, tokenResponse.tokenType) &&
        Objects.equals(this.expiresIn, tokenResponse.expiresIn) &&
        Objects.equals(this.refreshToken, tokenResponse.refreshToken) &&
        Objects.equals(this.idToken, tokenResponse.idToken) &&
        Objects.equals(this.scope, tokenResponse.scope);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, tokenType, expiresIn, refreshToken, idToken, scope);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenResponse {\n");
    
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
    sb.append("    idToken: ").append(toIndentedString(idToken)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
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
