package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EndorsementDetails
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class EndorsementDetails   {
  @JsonProperty("endorser_id")

  private String endorserId = null;

  @JsonProperty("sub")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String sub = null;

  @JsonProperty("endorsement_date")

  private OffsetDateTime endorsementDate = null;

  @JsonProperty("reference_id")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String referenceId = null;


  public EndorsementDetails endorserId(String endorserId) { 

    this.endorserId = endorserId;
    return this;
  }

  /**
   * Endorser's unique identifier
   * @return endorserId
   **/
  
  @Schema(required = true, description = "Endorser's unique identifier")
  
  @NotNull
  public String getEndorserId() {  
    return endorserId;
  }



  public void setEndorserId(String endorserId) { 

    this.endorserId = endorserId;
  }

  public EndorsementDetails sub(String sub) { 

    this.sub = sub;
    return this;
  }

  /**
   * Subject – FI's unique identifier for the End-User
   * @return sub
   **/
  
  @Schema(description = "Subject – FI's unique identifier for the End-User")
  
  public String getSub() {  
    return sub;
  }



  public void setSub(String sub) { 
    this.sub = sub;
  }

  public EndorsementDetails endorsementDate(OffsetDateTime endorsementDate) { 

    this.endorsementDate = endorsementDate;
    return this;
  }

  /**
   * Date and time the endorsement was created
   * @return endorsementDate
   **/
  
  @Schema(required = true, description = "Date and time the endorsement was created")
  
@Valid
  @NotNull
  public OffsetDateTime getEndorsementDate() {  
    return endorsementDate;
  }



  public void setEndorsementDate(OffsetDateTime endorsementDate) { 

    this.endorsementDate = endorsementDate;
  }

  public EndorsementDetails referenceId(String referenceId) { 

    this.referenceId = referenceId;
    return this;
  }

  /**
   * Reference ID from the PERA Admin
   * @return referenceId
   **/
  
  @Schema(description = "Reference ID from the PERA Admin")
  
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
    EndorsementDetails endorsementDetails = (EndorsementDetails) o;
    return Objects.equals(this.endorserId, endorsementDetails.endorserId) &&
        Objects.equals(this.sub, endorsementDetails.sub) &&
        Objects.equals(this.endorsementDate, endorsementDetails.endorsementDate) &&
        Objects.equals(this.referenceId, endorsementDetails.referenceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endorserId, sub, endorsementDate, referenceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EndorsementDetails {\n");
    
    sb.append("    endorserId: ").append(toIndentedString(endorserId)).append("\n");
    sb.append("    sub: ").append(toIndentedString(sub)).append("\n");
    sb.append("    endorsementDate: ").append(toIndentedString(endorsementDate)).append("\n");
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
