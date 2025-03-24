package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.ConsentDashboardSummary;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * ConsentDashboard
 */
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class ConsentDashboard   {
  @JsonProperty("customer_id")

  private String customerId = null;

  @JsonProperty("summary")

  private ConsentDashboardSummary summary = null;


  public ConsentDashboard customerId(String customerId) { 

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

  public ConsentDashboard summary(ConsentDashboardSummary summary) { 

    this.summary = summary;
    return this;
  }

  /**
   * Get summary
   * @return summary
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
  public ConsentDashboardSummary getSummary() {  
    return summary;
  }



  public void setSummary(ConsentDashboardSummary summary) { 

    this.summary = summary;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentDashboard consentDashboard = (ConsentDashboard) o;
    return Objects.equals(this.customerId, consentDashboard.customerId) &&
        Objects.equals(this.summary, consentDashboard.summary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, summary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentDashboard {\n");
    
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
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
