package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.ConsentArrangementRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BulkConsentRequest
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class BulkConsentRequest   {
  @JsonProperty("arrangements")
  @Valid
  private List<ConsentArrangementRequest> arrangements = new ArrayList<ConsentArrangementRequest>();
  @JsonProperty("batch_id")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
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
  
@Valid
  @NotNull
@Size(min=1,max=50)   public List<ConsentArrangementRequest> getArrangements() {  
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
