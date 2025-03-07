/*
 * OFxPERA API
 * Philippines Open Finance API Implementation for PERA
 *
 * OpenAPI spec version: 0.0.5
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
import io.swagger.client.model.ConsentArrangementResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * InlineResponse2005
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2025-03-03T23:36:15.658195047Z[GMT]")

public class InlineResponse2005 {
  @SerializedName("customer_id")
  private String customerId = null;

  @SerializedName("total_arrangements")
  private Integer totalArrangements = null;

  @SerializedName("active_arrangements")
  private Integer activeArrangements = null;

  @SerializedName("arrangements")
  private List<ConsentArrangementResponse> arrangements = new ArrayList<ConsentArrangementResponse>();

  public InlineResponse2005 customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * Get customerId
   * @return customerId
  **/
  @Schema(required = true, description = "")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public InlineResponse2005 totalArrangements(Integer totalArrangements) {
    this.totalArrangements = totalArrangements;
    return this;
  }

   /**
   * Get totalArrangements
   * @return totalArrangements
  **/
  @Schema(description = "")
  public Integer getTotalArrangements() {
    return totalArrangements;
  }

  public void setTotalArrangements(Integer totalArrangements) {
    this.totalArrangements = totalArrangements;
  }

  public InlineResponse2005 activeArrangements(Integer activeArrangements) {
    this.activeArrangements = activeArrangements;
    return this;
  }

   /**
   * Get activeArrangements
   * @return activeArrangements
  **/
  @Schema(description = "")
  public Integer getActiveArrangements() {
    return activeArrangements;
  }

  public void setActiveArrangements(Integer activeArrangements) {
    this.activeArrangements = activeArrangements;
  }

  public InlineResponse2005 arrangements(List<ConsentArrangementResponse> arrangements) {
    this.arrangements = arrangements;
    return this;
  }

  public InlineResponse2005 addArrangementsItem(ConsentArrangementResponse arrangementsItem) {
    this.arrangements.add(arrangementsItem);
    return this;
  }

   /**
   * Get arrangements
   * @return arrangements
  **/
  @Schema(required = true, description = "")
  public List<ConsentArrangementResponse> getArrangements() {
    return arrangements;
  }

  public void setArrangements(List<ConsentArrangementResponse> arrangements) {
    this.arrangements = arrangements;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2005 inlineResponse2005 = (InlineResponse2005) o;
    return Objects.equals(this.customerId, inlineResponse2005.customerId) &&
        Objects.equals(this.totalArrangements, inlineResponse2005.totalArrangements) &&
        Objects.equals(this.activeArrangements, inlineResponse2005.activeArrangements) &&
        Objects.equals(this.arrangements, inlineResponse2005.arrangements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, totalArrangements, activeArrangements, arrangements);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2005 {\n");
    
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    totalArrangements: ").append(toIndentedString(totalArrangements)).append("\n");
    sb.append("    activeArrangements: ").append(toIndentedString(activeArrangements)).append("\n");
    sb.append("    arrangements: ").append(toIndentedString(arrangements)).append("\n");
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
