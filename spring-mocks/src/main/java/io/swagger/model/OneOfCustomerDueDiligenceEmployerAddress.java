package io.swagger.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
/**
* OneOfCustomerDueDiligenceEmployerAddress
*/
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = Address.class, name = "Address"),
  @JsonSubTypes.Type(value = AddressString.class, name = "AddressString")
})
public interface OneOfCustomerDueDiligenceEmployerAddress {

}
