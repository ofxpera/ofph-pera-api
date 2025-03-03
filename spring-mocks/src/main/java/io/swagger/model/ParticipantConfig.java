package io.swagger.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
/**
* ParticipantConfig
*/
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = AuthServer.class, name = "AuthServer"),
  @JsonSubTypes.Type(value = OAuthClient.class, name = "OAuthClient")
})
public interface ParticipantConfig {

}
