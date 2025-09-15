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
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * ConsentArrangementRequestSharingDuration
 */
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class ConsentArrangementRequestSharingDuration   {
  @JsonProperty("start_date")

  private OffsetDateTime startDate = null;

  @JsonProperty("end_date")

  private OffsetDateTime endDate = null;


  public ConsentArrangementRequestSharingDuration startDate(OffsetDateTime startDate) { 

    this.startDate = startDate;
    return this;
  }

  /**
   * When the consent arrangement should start
   * @return startDate
   **/
  
  @Schema(required = true, description = "When the consent arrangement should start")
  
@Valid
  @NotNull
  public OffsetDateTime getStartDate() {  
    return startDate;
  }



  public void setStartDate(OffsetDateTime startDate) { 

    this.startDate = startDate;
  }

  public ConsentArrangementRequestSharingDuration endDate(OffsetDateTime endDate) { 

    this.endDate = endDate;
    return this;
  }

  /**
   * When the consent arrangement should end
   * @return endDate
   **/
  
  @Schema(required = true, description = "When the consent arrangement should end")
  
@Valid
  @NotNull
  public OffsetDateTime getEndDate() {  
    return endDate;
  }



  public void setEndDate(OffsetDateTime endDate) { 

    this.endDate = endDate;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentArrangementRequestSharingDuration consentArrangementRequestSharingDuration = (ConsentArrangementRequestSharingDuration) o;
    return Objects.equals(this.startDate, consentArrangementRequestSharingDuration.startDate) &&
        Objects.equals(this.endDate, consentArrangementRequestSharingDuration.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startDate, endDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentArrangementRequestSharingDuration {\n");
    
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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
