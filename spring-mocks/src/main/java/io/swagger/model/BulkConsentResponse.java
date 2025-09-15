package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.BulkConsentResponseResults;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * BulkConsentResponse
 */
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class BulkConsentResponse   {
  @JsonProperty("batch_id")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String batchId = null;

  @JsonProperty("results")
  @Valid
  private List<BulkConsentResponseResults> results = new ArrayList<BulkConsentResponseResults>();

  public BulkConsentResponse batchId(String batchId) { 

    this.batchId = batchId;
    return this;
  }

  /**
   * Get batchId
   * @return batchId
   **/
  
  @Schema(description = "")
  
  public String getBatchId() {  
    return batchId;
  }



  public void setBatchId(String batchId) { 
    this.batchId = batchId;
  }

  public BulkConsentResponse results(List<BulkConsentResponseResults> results) { 

    this.results = results;
    return this;
  }

  public BulkConsentResponse addResultsItem(BulkConsentResponseResults resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
  public List<BulkConsentResponseResults> getResults() {  
    return results;
  }



  public void setResults(List<BulkConsentResponseResults> results) { 

    this.results = results;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkConsentResponse bulkConsentResponse = (BulkConsentResponse) o;
    return Objects.equals(this.batchId, bulkConsentResponse.batchId) &&
        Objects.equals(this.results, bulkConsentResponse.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(batchId, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkConsentResponse {\n");
    
    sb.append("    batchId: ").append(toIndentedString(batchId)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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
