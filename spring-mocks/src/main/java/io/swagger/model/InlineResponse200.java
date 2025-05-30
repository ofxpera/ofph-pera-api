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
 * InlineResponse200
 */
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class InlineResponse200   {
  @JsonProperty("active")

  private Boolean active = null;

  @JsonProperty("client_id")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String clientId = null;

  @JsonProperty("username")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String username = null;

  @JsonProperty("scope")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String scope = null;

  @JsonProperty("exp")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer exp = null;

  @JsonProperty("iat")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer iat = null;


  public InlineResponse200 active(Boolean active) { 

    this.active = active;
    return this;
  }

  /**
   * Indicates whether the token is currently active.
   * @return active
   **/
  
  @Schema(required = true, description = "Indicates whether the token is currently active.")
  
  @NotNull
  public Boolean isActive() {  
    return active;
  }



  public void setActive(Boolean active) { 

    this.active = active;
  }

  public InlineResponse200 clientId(String clientId) { 

    this.clientId = clientId;
    return this;
  }

  /**
   * Client identifier for the token.
   * @return clientId
   **/
  
  @Schema(description = "Client identifier for the token.")
  
  public String getClientId() {  
    return clientId;
  }



  public void setClientId(String clientId) { 
    this.clientId = clientId;
  }

  public InlineResponse200 username(String username) { 

    this.username = username;
    return this;
  }

  /**
   * Username associated with the token.
   * @return username
   **/
  
  @Schema(description = "Username associated with the token.")
  
  public String getUsername() {  
    return username;
  }



  public void setUsername(String username) { 
    this.username = username;
  }

  public InlineResponse200 scope(String scope) { 

    this.scope = scope;
    return this;
  }

  /**
   * Scope of the token.
   * @return scope
   **/
  
  @Schema(description = "Scope of the token.")
  
  public String getScope() {  
    return scope;
  }



  public void setScope(String scope) { 
    this.scope = scope;
  }

  public InlineResponse200 exp(Integer exp) { 

    this.exp = exp;
    return this;
  }

  /**
   * Expiration timestamp of the token in seconds since epoch.
   * @return exp
   **/
  
  @Schema(description = "Expiration timestamp of the token in seconds since epoch.")
  
  public Integer getExp() {  
    return exp;
  }



  public void setExp(Integer exp) { 
    this.exp = exp;
  }

  public InlineResponse200 iat(Integer iat) { 

    this.iat = iat;
    return this;
  }

  /**
   * Issued at timestamp of the token in seconds since epoch.
   * @return iat
   **/
  
  @Schema(description = "Issued at timestamp of the token in seconds since epoch.")
  
  public Integer getIat() {  
    return iat;
  }



  public void setIat(Integer iat) { 
    this.iat = iat;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.active, inlineResponse200.active) &&
        Objects.equals(this.clientId, inlineResponse200.clientId) &&
        Objects.equals(this.username, inlineResponse200.username) &&
        Objects.equals(this.scope, inlineResponse200.scope) &&
        Objects.equals(this.exp, inlineResponse200.exp) &&
        Objects.equals(this.iat, inlineResponse200.iat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, clientId, username, scope, exp, iat);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    exp: ").append(toIndentedString(exp)).append("\n");
    sb.append("    iat: ").append(toIndentedString(iat)).append("\n");
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
