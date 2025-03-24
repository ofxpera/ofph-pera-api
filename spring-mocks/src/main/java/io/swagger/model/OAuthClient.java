package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.ClientRegistration;
import io.swagger.model.Participant;
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
 * OAuthClient
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class OAuthClient  implements ParticipantConfig {
  @JsonProperty("participant")

  private Participant participant = null;

  @JsonProperty("clientConfig")
  @Valid
  private List<ClientRegistration> clientConfig = new ArrayList<ClientRegistration>();

  public OAuthClient participant(Participant participant) { 

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

  public OAuthClient clientConfig(List<ClientRegistration> clientConfig) { 

    this.clientConfig = clientConfig;
    return this;
  }

  public OAuthClient addClientConfigItem(ClientRegistration clientConfigItem) {
    this.clientConfig.add(clientConfigItem);
    return this;
  }

  /**
   * Array of OAuth client configurations for this participant
   * @return clientConfig
   **/
  
  @Schema(required = true, description = "Array of OAuth client configurations for this participant")
  
@Valid
  @NotNull
@Size(min=1)   public List<ClientRegistration> getClientConfig() {  
    return clientConfig;
  }



  public void setClientConfig(List<ClientRegistration> clientConfig) { 

    this.clientConfig = clientConfig;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OAuthClient oauthClient = (OAuthClient) o;
    return Objects.equals(this.participant, oauthClient.participant) &&
        Objects.equals(this.clientConfig, oauthClient.clientConfig);
  }

  @Override
  public int hashCode() {
    return Objects.hash(participant, clientConfig);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OAuthClient {\n");
    
    sb.append("    participant: ").append(toIndentedString(participant)).append("\n");
    sb.append("    clientConfig: ").append(toIndentedString(clientConfig)).append("\n");
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
