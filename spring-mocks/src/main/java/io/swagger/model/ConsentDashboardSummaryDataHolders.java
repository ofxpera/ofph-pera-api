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
 * ConsentDashboardSummaryDataHolders
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class ConsentDashboardSummaryDataHolders   {
  @JsonProperty("data_holder_id")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String dataHolderId = null;

  @JsonProperty("name")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String name = null;

  @JsonProperty("active_arrangements")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer activeArrangements = null;


  public ConsentDashboardSummaryDataHolders dataHolderId(String dataHolderId) { 

    this.dataHolderId = dataHolderId;
    return this;
  }

  /**
   * Get dataHolderId
   * @return dataHolderId
   **/
  
  @Schema(description = "")
  
  public String getDataHolderId() {  
    return dataHolderId;
  }



  public void setDataHolderId(String dataHolderId) { 
    this.dataHolderId = dataHolderId;
  }

  public ConsentDashboardSummaryDataHolders name(String name) { 

    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  
  @Schema(description = "")
  
  public String getName() {  
    return name;
  }



  public void setName(String name) { 
    this.name = name;
  }

  public ConsentDashboardSummaryDataHolders activeArrangements(Integer activeArrangements) { 

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

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentDashboardSummaryDataHolders consentDashboardSummaryDataHolders = (ConsentDashboardSummaryDataHolders) o;
    return Objects.equals(this.dataHolderId, consentDashboardSummaryDataHolders.dataHolderId) &&
        Objects.equals(this.name, consentDashboardSummaryDataHolders.name) &&
        Objects.equals(this.activeArrangements, consentDashboardSummaryDataHolders.activeArrangements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataHolderId, name, activeArrangements);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentDashboardSummaryDataHolders {\n");
    
    sb.append("    dataHolderId: ").append(toIndentedString(dataHolderId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    activeArrangements: ").append(toIndentedString(activeArrangements)).append("\n");
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
