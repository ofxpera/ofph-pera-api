package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.EndorsementDetails;
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
 * EndorsementResponse
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class EndorsementResponse   {
  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    SUCCESS("SUCCESS"),
    
    FAILED("FAILED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")

  private StatusEnum status = null;

  @JsonProperty("message")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String message = null;

  @JsonProperty("timestamp")

  private OffsetDateTime timestamp = null;

  @JsonProperty("endorsement_details")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private EndorsementDetails endorsementDetails = null;


  public EndorsementResponse status(StatusEnum status) { 

    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public StatusEnum getStatus() {  
    return status;
  }



  public void setStatus(StatusEnum status) { 

    this.status = status;
  }

  public EndorsementResponse message(String message) { 

    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   **/
  
  @Schema(description = "")
  
  public String getMessage() {  
    return message;
  }



  public void setMessage(String message) { 
    this.message = message;
  }

  public EndorsementResponse timestamp(OffsetDateTime timestamp) { 

    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
  public OffsetDateTime getTimestamp() {  
    return timestamp;
  }



  public void setTimestamp(OffsetDateTime timestamp) { 

    this.timestamp = timestamp;
  }

  public EndorsementResponse endorsementDetails(EndorsementDetails endorsementDetails) { 

    this.endorsementDetails = endorsementDetails;
    return this;
  }

  /**
   * Get endorsementDetails
   * @return endorsementDetails
   **/
  
  @Schema(description = "")
  
@Valid
  public EndorsementDetails getEndorsementDetails() {  
    return endorsementDetails;
  }



  public void setEndorsementDetails(EndorsementDetails endorsementDetails) { 
    this.endorsementDetails = endorsementDetails;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EndorsementResponse endorsementResponse = (EndorsementResponse) o;
    return Objects.equals(this.status, endorsementResponse.status) &&
        Objects.equals(this.message, endorsementResponse.message) &&
        Objects.equals(this.timestamp, endorsementResponse.timestamp) &&
        Objects.equals(this.endorsementDetails, endorsementResponse.endorsementDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, message, timestamp, endorsementDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EndorsementResponse {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    endorsementDetails: ").append(toIndentedString(endorsementDetails)).append("\n");
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
