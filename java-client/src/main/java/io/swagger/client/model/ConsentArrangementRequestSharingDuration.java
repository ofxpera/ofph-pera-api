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
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;
/**
 * ConsentArrangementRequestSharingDuration
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2025-03-24T23:12:52.341191218Z[GMT]")

public class ConsentArrangementRequestSharingDuration {
  @SerializedName("start_date")
  private OffsetDateTime startDate = null;

  @SerializedName("end_date")
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
