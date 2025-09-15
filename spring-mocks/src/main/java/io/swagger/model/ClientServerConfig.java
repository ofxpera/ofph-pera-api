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
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PERA Administrator API Endpoints for FI-Initiated Onboarding
 */
@Schema(description = "PERA Administrator API Endpoints for FI-Initiated Onboarding")
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-09-15T04:08:15.774251174Z[GMT]")


public class ClientServerConfig   {
  @JsonProperty("customerKycEndpoint")

  private String customerKycEndpoint = null;

  @JsonProperty("peraArrangementEndpoint")

  private String peraArrangementEndpoint = null;


  public ClientServerConfig customerKycEndpoint(String customerKycEndpoint) { 

    this.customerKycEndpoint = customerKycEndpoint;
    return this;
  }

  /**
   * URL of the Customer KYC Endpoint
   * @return customerKycEndpoint
   **/
  
  @Schema(required = true, description = "URL of the Customer KYC Endpoint")
  
  @NotNull
  public String getCustomerKycEndpoint() {  
    return customerKycEndpoint;
  }



  public void setCustomerKycEndpoint(String customerKycEndpoint) { 

    this.customerKycEndpoint = customerKycEndpoint;
  }

  public ClientServerConfig peraArrangementEndpoint(String peraArrangementEndpoint) { 

    this.peraArrangementEndpoint = peraArrangementEndpoint;
    return this;
  }

  /**
   * URL of the PERA Arrangement Endpoint
   * @return peraArrangementEndpoint
   **/
  
  @Schema(required = true, description = "URL of the PERA Arrangement Endpoint")
  
  @NotNull
  public String getPeraArrangementEndpoint() {  
    return peraArrangementEndpoint;
  }



  public void setPeraArrangementEndpoint(String peraArrangementEndpoint) { 

    this.peraArrangementEndpoint = peraArrangementEndpoint;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientServerConfig clientServerConfig = (ClientServerConfig) o;
    return Objects.equals(this.customerKycEndpoint, clientServerConfig.customerKycEndpoint) &&
        Objects.equals(this.peraArrangementEndpoint, clientServerConfig.peraArrangementEndpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerKycEndpoint, peraArrangementEndpoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientServerConfig {\n");
    
    sb.append("    customerKycEndpoint: ").append(toIndentedString(customerKycEndpoint)).append("\n");
    sb.append("    peraArrangementEndpoint: ").append(toIndentedString(peraArrangementEndpoint)).append("\n");
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
