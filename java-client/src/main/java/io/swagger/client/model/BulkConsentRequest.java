/*
 * OFxPERA API
 * Philippines Open Finance API Implementation for PERA
 *
 * OpenAPI spec version: 1.0.0
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
import io.swagger.client.model.ConsentArrangementRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * BulkConsentRequest
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2025-03-24T23:12:52.341191218Z[GMT]")

public class BulkConsentRequest {
  @SerializedName("arrangements")
  private List<ConsentArrangementRequest> arrangements = new ArrayList<ConsentArrangementRequest>();

  @SerializedName("batch_id")
  private String batchId = null;

  public BulkConsentRequest arrangements(List<ConsentArrangementRequest> arrangements) {
    this.arrangements = arrangements;
    return this;
  }

  public BulkConsentRequest addArrangementsItem(ConsentArrangementRequest arrangementsItem) {
    this.arrangements.add(arrangementsItem);
    return this;
  }

   /**
   * Get arrangements
   * @return arrangements
  **/
  @Schema(required = true, description = "")
  public List<ConsentArrangementRequest> getArrangements() {
    return arrangements;
  }

  public void setArrangements(List<ConsentArrangementRequest> arrangements) {
    this.arrangements = arrangements;
  }

  public BulkConsentRequest batchId(String batchId) {
    this.batchId = batchId;
    return this;
  }

   /**
   * Optional identifier for the bulk operation
   * @return batchId
  **/
  @Schema(description = "Optional identifier for the bulk operation")
  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkConsentRequest bulkConsentRequest = (BulkConsentRequest) o;
    return Objects.equals(this.arrangements, bulkConsentRequest.arrangements) &&
        Objects.equals(this.batchId, bulkConsentRequest.batchId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(arrangements, batchId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkConsentRequest {\n");
    
    sb.append("    arrangements: ").append(toIndentedString(arrangements)).append("\n");
    sb.append("    batchId: ").append(toIndentedString(batchId)).append("\n");
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
