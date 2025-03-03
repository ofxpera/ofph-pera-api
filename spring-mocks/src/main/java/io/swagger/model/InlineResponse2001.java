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
 * InlineResponse2001
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class InlineResponse2001   {
  @JsonProperty("access_token")

  private String accessToken = null;

  /**
   * Type of the token, always \"Bearer\"
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

  @JsonProperty("id_token")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String idToken = null;

  @JsonProperty("refresh_token")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String refreshToken = null;

  @JsonProperty("scope")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String scope = null;


  public InlineResponse2001 accessToken(String accessToken) { 

    this.accessToken = accessToken;
    return this;
  }

  /**
   * Access token for the authenticated user
   * @return accessToken
   **/
  
  @Schema(required = true, description = "Access token for the authenticated user")
  
  @NotNull
  public String getAccessToken() {  
    return accessToken;
  }



  public void setAccessToken(String accessToken) { 

    this.accessToken = accessToken;
  }

  public InlineResponse2001 tokenType(TokenTypeEnum tokenType) { 

    this.tokenType = tokenType;
    return this;
  }

  /**
   * Type of the token, always \"Bearer\"
   * @return tokenType
   **/
  
  @Schema(required = true, description = "Type of the token, always \"Bearer\"")
  
  @NotNull
  public TokenTypeEnum getTokenType() {  
    return tokenType;
  }



  public void setTokenType(TokenTypeEnum tokenType) { 

    this.tokenType = tokenType;
  }

  public InlineResponse2001 expiresIn(Integer expiresIn) { 

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

  public InlineResponse2001 idToken(String idToken) { 

    this.idToken = idToken;
    return this;
  }

  /**
   * ID Token value associated with the authenticated session
   * @return idToken
   **/
  
  @Schema(description = "ID Token value associated with the authenticated session")
  
  public String getIdToken() {  
    return idToken;
  }



  public void setIdToken(String idToken) { 
    this.idToken = idToken;
  }

  public InlineResponse2001 refreshToken(String refreshToken) { 

    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * Refresh token used to obtain new access tokens
   * @return refreshToken
   **/
  
  @Schema(description = "Refresh token used to obtain new access tokens")
  
  public String getRefreshToken() {  
    return refreshToken;
  }



  public void setRefreshToken(String refreshToken) { 
    this.refreshToken = refreshToken;
  }

  public InlineResponse2001 scope(String scope) { 

    this.scope = scope;
    return this;
  }

  /**
   * Space-separated list of scopes associated with the access token
   * @return scope
   **/
  
  @Schema(description = "Space-separated list of scopes associated with the access token")
  
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
    InlineResponse2001 inlineResponse2001 = (InlineResponse2001) o;
    return Objects.equals(this.accessToken, inlineResponse2001.accessToken) &&
        Objects.equals(this.tokenType, inlineResponse2001.tokenType) &&
        Objects.equals(this.expiresIn, inlineResponse2001.expiresIn) &&
        Objects.equals(this.idToken, inlineResponse2001.idToken) &&
        Objects.equals(this.refreshToken, inlineResponse2001.refreshToken) &&
        Objects.equals(this.scope, inlineResponse2001.scope);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, tokenType, expiresIn, idToken, refreshToken, scope);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001 {\n");
    
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
    sb.append("    idToken: ").append(toIndentedString(idToken)).append("\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
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
