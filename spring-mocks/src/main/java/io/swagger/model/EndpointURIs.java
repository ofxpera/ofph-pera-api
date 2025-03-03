package io.swagger.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
/**
* EndpointURIs
*/
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = OAuthClientURIs.class, name = "OAuthClientURIs"),
  @JsonSubTypes.Type(value = AuthServerURIs.class, name = "AuthServerURIs")
})
public interface EndpointURIs {

}
