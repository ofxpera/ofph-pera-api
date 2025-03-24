package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConsentDashboardSummaryArrangementsByPurpose
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class ConsentDashboardSummaryArrangementsByPurpose   {
  @JsonProperty("purpose")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String purpose = null;

  @JsonProperty("count")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer count = null;


  public ConsentDashboardSummaryArrangementsByPurpose purpose(String purpose) { 

    this.purpose = purpose;
    return this;
  }

  /**
   * Get purpose
   * @return purpose
   **/
  
  @Schema(description = "")
  
  public String getPurpose() {  
    return purpose;
  }



  public void setPurpose(String purpose) { 
    this.purpose = purpose;
  }

  public ConsentDashboardSummaryArrangementsByPurpose count(Integer count) { 

    this.count = count;
    return this;
  }

  /**
   * Get count
   * @return count
   **/
  
  @Schema(description = "")
  
  public Integer getCount() {  
    return count;
  }



  public void setCount(Integer count) { 
    this.count = count;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentDashboardSummaryArrangementsByPurpose consentDashboardSummaryArrangementsByPurpose = (ConsentDashboardSummaryArrangementsByPurpose) o;
    return Objects.equals(this.purpose, consentDashboardSummaryArrangementsByPurpose.purpose) &&
        Objects.equals(this.count, consentDashboardSummaryArrangementsByPurpose.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(purpose, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentDashboardSummaryArrangementsByPurpose {\n");
    
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
