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
import java.util.ArrayList;
import java.util.List;
/**
 * Error
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2025-03-24T23:12:52.341191218Z[GMT]")

public class Error {
  @SerializedName("error")
  private String error = null;

  @SerializedName("details")
  private List<String> details = null;

  public Error error(String error) {
    this.error = error;
    return this;
  }

   /**
   * Error message describing the error
   * @return error
  **/
  @Schema(description = "Error message describing the error")
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public Error details(List<String> details) {
    this.details = details;
    return this;
  }

  public Error addDetailsItem(String detailsItem) {
    if (this.details == null) {
      this.details = new ArrayList<String>();
    }
    this.details.add(detailsItem);
    return this;
  }

   /**
   * Additional details about the error
   * @return details
  **/
  @Schema(description = "Additional details about the error")
  public List<String> getDetails() {
    return details;
  }

  public void setDetails(List<String> details) {
    this.details = details;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.error, error.error) &&
        Objects.equals(this.details, error.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, details);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
