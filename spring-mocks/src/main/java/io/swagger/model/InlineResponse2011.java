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
 * InlineResponse2011
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-09-07T08:58:01.056844973Z[GMT]")


public class InlineResponse2011   {
  @JsonProperty("customerId")

  private String customerId = null;

  @JsonProperty("adminId")

  private String adminId = null;

  @JsonProperty("referenceId")

  private String referenceId = null;


  public InlineResponse2011 customerId(String customerId) { 

    this.customerId = customerId;
    return this;
  }

  /**
   * PERA Administrator's unique identifier of the customer
   * @return customerId
   **/
  
  @Schema(required = true, description = "PERA Administrator's unique identifier of the customer")
  
  @NotNull
  public String getCustomerId() {  
    return customerId;
  }



  public void setCustomerId(String customerId) { 

    this.customerId = customerId;
  }

  public InlineResponse2011 adminId(String adminId) { 

    this.adminId = adminId;
    return this;
  }

  /**
   * Participant Identifier of the PERA Administrator
   * @return adminId
   **/
  
  @Schema(required = true, description = "Participant Identifier of the PERA Administrator")
  
  @NotNull
  public String getAdminId() {  
    return adminId;
  }



  public void setAdminId(String adminId) { 

    this.adminId = adminId;
  }

  public InlineResponse2011 referenceId(String referenceId) { 

    this.referenceId = referenceId;
    return this;
  }

  /**
   * Unique identifier used for redirection to the Admin Platform. The Financial Institution appends this ID as a signed JWT in the Admin's deeplink URL:https://any.admin.com/kyc/review?response=signedJWT({referenceId})
   * @return referenceId
   **/
  
  @Schema(required = true, description = "Unique identifier used for redirection to the Admin Platform. The Financial Institution appends this ID as a signed JWT in the Admin's deeplink URL:https://any.admin.com/kyc/review?response=signedJWT({referenceId})")
  
  @NotNull
  public String getReferenceId() {  
    return referenceId;
  }



  public void setReferenceId(String referenceId) { 

    this.referenceId = referenceId;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2011 inlineResponse2011 = (InlineResponse2011) o;
    return Objects.equals(this.customerId, inlineResponse2011.customerId) &&
        Objects.equals(this.adminId, inlineResponse2011.adminId) &&
        Objects.equals(this.referenceId, inlineResponse2011.referenceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, adminId, referenceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2011 {\n");
    
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    adminId: ").append(toIndentedString(adminId)).append("\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
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
