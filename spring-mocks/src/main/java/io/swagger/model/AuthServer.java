package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.AuthServerURIs;
import io.swagger.model.Participant;
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
 * AuthServer
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class AuthServer  implements ParticipantConfig {
  @JsonProperty("participant")

  private Participant participant = null;

  @JsonProperty("authserver_config")

  private AuthServerURIs authserverConfig = null;


  public AuthServer participant(Participant participant) { 

    this.participant = participant;
    return this;
  }

  /**
   * Get participant
   * @return participant
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
  public Participant getParticipant() {  
    return participant;
  }



  public void setParticipant(Participant participant) { 

    this.participant = participant;
  }

  public AuthServer authserverConfig(AuthServerURIs authserverConfig) { 

    this.authserverConfig = authserverConfig;
    return this;
  }

  /**
   * Get authserverConfig
   * @return authserverConfig
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
  public AuthServerURIs getAuthserverConfig() {  
    return authserverConfig;
  }



  public void setAuthserverConfig(AuthServerURIs authserverConfig) { 

    this.authserverConfig = authserverConfig;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthServer authServer = (AuthServer) o;
    return Objects.equals(this.participant, authServer.participant) &&
        Objects.equals(this.authserverConfig, authServer.authserverConfig);
  }

  @Override
  public int hashCode() {
    return Objects.hash(participant, authserverConfig);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthServer {\n");
    
    sb.append("    participant: ").append(toIndentedString(participant)).append("\n");
    sb.append("    authserverConfig: ").append(toIndentedString(authserverConfig)).append("\n");
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
