/*
 * OFxPERA API
 * Philippines Open Finance API Implementation for PERA
 *
 * OpenAPI spec version: 0.0.7
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.client.model.ClientRegistration;
import io.swagger.client.model.Participant;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * OAuthClient
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2025-03-24T23:12:52.341191218Z[GMT]")

public class OAuthClient implements ParticipantConfig {
  @SerializedName("participant")
  private Participant participant = null;

  @SerializedName("clientConfig")
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
  public List<ClientRegistration> getClientConfig() {
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
