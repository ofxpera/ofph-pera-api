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
 * ClientRegistrationResponse
 */
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class ClientRegistrationResponse   {
  @JsonProperty("clientId")

  private String clientId = null;

  @JsonProperty("registrationAccessToken")

  private String registrationAccessToken = null;

  @JsonProperty("registrationClientUri")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String registrationClientUri = null;

  @JsonProperty("clientIdIssuedAt")

  private Integer clientIdIssuedAt = null;


  public ClientRegistrationResponse clientId(String clientId) { 

    this.clientId = clientId;
    return this;
  }

  /**
   * Issued client identifier
   * @return clientId
   **/
  
  @Schema(required = true, description = "Issued client identifier")
  
  @NotNull
  public String getClientId() {  
    return clientId;
  }



  public void setClientId(String clientId) { 

    this.clientId = clientId;
  }

  public ClientRegistrationResponse registrationAccessToken(String registrationAccessToken) { 

    this.registrationAccessToken = registrationAccessToken;
    return this;
  }

  /**
   * Registration access token for subsequent operations
   * @return registrationAccessToken
   **/
  
  @Schema(required = true, description = "Registration access token for subsequent operations")
  
  @NotNull
  public String getRegistrationAccessToken() {  
    return registrationAccessToken;
  }



  public void setRegistrationAccessToken(String registrationAccessToken) { 

    this.registrationAccessToken = registrationAccessToken;
  }

  public ClientRegistrationResponse registrationClientUri(String registrationClientUri) { 

    this.registrationClientUri = registrationClientUri;
    return this;
  }

  /**
   * URI for managing the client registration
   * @return registrationClientUri
   **/
  
  @Schema(description = "URI for managing the client registration")
  
  public String getRegistrationClientUri() {  
    return registrationClientUri;
  }



  public void setRegistrationClientUri(String registrationClientUri) { 
    this.registrationClientUri = registrationClientUri;
  }

  public ClientRegistrationResponse clientIdIssuedAt(Integer clientIdIssuedAt) { 

    this.clientIdIssuedAt = clientIdIssuedAt;
    return this;
  }

  /**
   * Time at which the client identifier was issued, in seconds since Unix epoch (1970-01-01T00:00:00Z UTC)
   * @return clientIdIssuedAt
   **/
  
  @Schema(required = true, description = "Time at which the client identifier was issued, in seconds since Unix epoch (1970-01-01T00:00:00Z UTC)")
  
  @NotNull
  public Integer getClientIdIssuedAt() {  
    return clientIdIssuedAt;
  }



  public void setClientIdIssuedAt(Integer clientIdIssuedAt) { 

    this.clientIdIssuedAt = clientIdIssuedAt;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientRegistrationResponse clientRegistrationResponse = (ClientRegistrationResponse) o;
    return Objects.equals(this.clientId, clientRegistrationResponse.clientId) &&
        Objects.equals(this.registrationAccessToken, clientRegistrationResponse.registrationAccessToken) &&
        Objects.equals(this.registrationClientUri, clientRegistrationResponse.registrationClientUri) &&
        Objects.equals(this.clientIdIssuedAt, clientRegistrationResponse.clientIdIssuedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, registrationAccessToken, registrationClientUri, clientIdIssuedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientRegistrationResponse {\n");
    
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    registrationAccessToken: ").append(toIndentedString(registrationAccessToken)).append("\n");
    sb.append("    registrationClientUri: ").append(toIndentedString(registrationClientUri)).append("\n");
    sb.append("    clientIdIssuedAt: ").append(toIndentedString(clientIdIssuedAt)).append("\n");
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
