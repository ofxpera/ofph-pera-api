package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Endpoints of the OFxPERA Participant as an Authorization Server
 */
@Schema(description = "Endpoints of the OFxPERA Participant as an Authorization Server")
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class AuthServerURIs  implements EndpointURIs {
  @JsonProperty("issuer")

  private String issuer = null;

  @JsonProperty("authorizationEndpoint")

  private String authorizationEndpoint = null;

  @JsonProperty("tokenEndpoint")

  private String tokenEndpoint = null;

  @JsonProperty("userInfoEndpoint")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String userInfoEndpoint = null;

  @JsonProperty("endSessionEndpoint")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String endSessionEndpoint = null;

  @JsonProperty("registrationEndpoint")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String registrationEndpoint = null;


  public AuthServerURIs issuer(String issuer) { 

    this.issuer = issuer;
    return this;
  }

  /**
   * URL using the https scheme with no query or fragment component that the OP asserts as its Issuer Identifier
   * @return issuer
   **/
  
  @Schema(required = true, description = "URL using the https scheme with no query or fragment component that the OP asserts as its Issuer Identifier")
  
  @NotNull
  public String getIssuer() {  
    return issuer;
  }



  public void setIssuer(String issuer) { 

    this.issuer = issuer;
  }

  public AuthServerURIs authorizationEndpoint(String authorizationEndpoint) { 

    this.authorizationEndpoint = authorizationEndpoint;
    return this;
  }

  /**
   * URL of the OP's OAuth 2.0 Authorization Endpoint
   * @return authorizationEndpoint
   **/
  
  @Schema(required = true, description = "URL of the OP's OAuth 2.0 Authorization Endpoint")
  
  @NotNull
  public String getAuthorizationEndpoint() {  
    return authorizationEndpoint;
  }



  public void setAuthorizationEndpoint(String authorizationEndpoint) { 

    this.authorizationEndpoint = authorizationEndpoint;
  }

  public AuthServerURIs tokenEndpoint(String tokenEndpoint) { 

    this.tokenEndpoint = tokenEndpoint;
    return this;
  }

  /**
   * URL of the OP's OAuth 2.0 Token Endpoint
   * @return tokenEndpoint
   **/
  
  @Schema(required = true, description = "URL of the OP's OAuth 2.0 Token Endpoint")
  
  @NotNull
  public String getTokenEndpoint() {  
    return tokenEndpoint;
  }



  public void setTokenEndpoint(String tokenEndpoint) { 

    this.tokenEndpoint = tokenEndpoint;
  }

  public AuthServerURIs userInfoEndpoint(String userInfoEndpoint) { 

    this.userInfoEndpoint = userInfoEndpoint;
    return this;
  }

  /**
   * URL of the OP's UserInfo Endpoint
   * @return userInfoEndpoint
   **/
  
  @Schema(description = "URL of the OP's UserInfo Endpoint")
  
  public String getUserInfoEndpoint() {  
    return userInfoEndpoint;
  }



  public void setUserInfoEndpoint(String userInfoEndpoint) { 
    this.userInfoEndpoint = userInfoEndpoint;
  }

  public AuthServerURIs endSessionEndpoint(String endSessionEndpoint) { 

    this.endSessionEndpoint = endSessionEndpoint;
    return this;
  }

  /**
   * URL at the OP to which an RP can perform a redirect to
   * @return endSessionEndpoint
   **/
  
  @Schema(description = "URL at the OP to which an RP can perform a redirect to")
  
  public String getEndSessionEndpoint() {  
    return endSessionEndpoint;
  }



  public void setEndSessionEndpoint(String endSessionEndpoint) { 
    this.endSessionEndpoint = endSessionEndpoint;
  }

  public AuthServerURIs registrationEndpoint(String registrationEndpoint) { 

    this.registrationEndpoint = registrationEndpoint;
    return this;
  }

  /**
   * URL of the OP's Dynamic Client Registration Endpoint
   * @return registrationEndpoint
   **/
  
  @Schema(description = "URL of the OP's Dynamic Client Registration Endpoint")
  
  public String getRegistrationEndpoint() {  
    return registrationEndpoint;
  }



  public void setRegistrationEndpoint(String registrationEndpoint) { 
    this.registrationEndpoint = registrationEndpoint;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthServerURIs authServerURIs = (AuthServerURIs) o;
    return Objects.equals(this.issuer, authServerURIs.issuer) &&
        Objects.equals(this.authorizationEndpoint, authServerURIs.authorizationEndpoint) &&
        Objects.equals(this.tokenEndpoint, authServerURIs.tokenEndpoint) &&
        Objects.equals(this.userInfoEndpoint, authServerURIs.userInfoEndpoint) &&
        Objects.equals(this.endSessionEndpoint, authServerURIs.endSessionEndpoint) &&
        Objects.equals(this.registrationEndpoint, authServerURIs.registrationEndpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issuer, authorizationEndpoint, tokenEndpoint, userInfoEndpoint, endSessionEndpoint, registrationEndpoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthServerURIs {\n");
    
    sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
    sb.append("    authorizationEndpoint: ").append(toIndentedString(authorizationEndpoint)).append("\n");
    sb.append("    tokenEndpoint: ").append(toIndentedString(tokenEndpoint)).append("\n");
    sb.append("    userInfoEndpoint: ").append(toIndentedString(userInfoEndpoint)).append("\n");
    sb.append("    endSessionEndpoint: ").append(toIndentedString(endSessionEndpoint)).append("\n");
    sb.append("    registrationEndpoint: ").append(toIndentedString(registrationEndpoint)).append("\n");
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
