package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.ConsentArrangementResponse;
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
 * InlineResponse2005
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class InlineResponse2005   {
  @JsonProperty("customer_id")

  private String customerId = null;

  @JsonProperty("total_arrangements")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer totalArrangements = null;

  @JsonProperty("active_arrangements")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer activeArrangements = null;

  @JsonProperty("arrangements")
  @Valid
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
  
  @NotNull
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
  
@Valid
  @NotNull
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
