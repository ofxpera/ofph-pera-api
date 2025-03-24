package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.InlineResponse2004Results;
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
 * InlineResponse2004
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class InlineResponse2004   {
  @JsonProperty("customer_id")

  private String customerId = null;

  @JsonProperty("results")
  @Valid
  private List<InlineResponse2004Results> results = new ArrayList<InlineResponse2004Results>();

  public InlineResponse2004 customerId(String customerId) { 

    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public String getCustomerId() {  
    return customerId;
  }



  public void setCustomerId(String customerId) { 

    this.customerId = customerId;
  }

  public InlineResponse2004 results(List<InlineResponse2004Results> results) { 

    this.results = results;
    return this;
  }

  public InlineResponse2004 addResultsItem(InlineResponse2004Results resultsItem) {
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
  public List<InlineResponse2004Results> getResults() {  
    return results;
  }



  public void setResults(List<InlineResponse2004Results> results) { 

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
    InlineResponse2004 inlineResponse2004 = (InlineResponse2004) o;
    return Objects.equals(this.customerId, inlineResponse2004.customerId) &&
        Objects.equals(this.results, inlineResponse2004.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2004 {\n");
    
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
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
