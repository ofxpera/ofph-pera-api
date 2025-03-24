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
 * ConsentDashboardSummaryArrangementsByStatus
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class ConsentDashboardSummaryArrangementsByStatus   {
  @JsonProperty("active")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer active = null;

  @JsonProperty("expired")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer expired = null;

  @JsonProperty("revoked")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer revoked = null;

  @JsonProperty("suspended")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer suspended = null;


  public ConsentDashboardSummaryArrangementsByStatus active(Integer active) { 

    this.active = active;
    return this;
  }

  /**
   * Get active
   * @return active
   **/
  
  @Schema(description = "")
  
  public Integer getActive() {  
    return active;
  }



  public void setActive(Integer active) { 
    this.active = active;
  }

  public ConsentDashboardSummaryArrangementsByStatus expired(Integer expired) { 

    this.expired = expired;
    return this;
  }

  /**
   * Get expired
   * @return expired
   **/
  
  @Schema(description = "")
  
  public Integer getExpired() {  
    return expired;
  }



  public void setExpired(Integer expired) { 
    this.expired = expired;
  }

  public ConsentDashboardSummaryArrangementsByStatus revoked(Integer revoked) { 

    this.revoked = revoked;
    return this;
  }

  /**
   * Get revoked
   * @return revoked
   **/
  
  @Schema(description = "")
  
  public Integer getRevoked() {  
    return revoked;
  }



  public void setRevoked(Integer revoked) { 
    this.revoked = revoked;
  }

  public ConsentDashboardSummaryArrangementsByStatus suspended(Integer suspended) { 

    this.suspended = suspended;
    return this;
  }

  /**
   * Get suspended
   * @return suspended
   **/
  
  @Schema(description = "")
  
  public Integer getSuspended() {  
    return suspended;
  }



  public void setSuspended(Integer suspended) { 
    this.suspended = suspended;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentDashboardSummaryArrangementsByStatus consentDashboardSummaryArrangementsByStatus = (ConsentDashboardSummaryArrangementsByStatus) o;
    return Objects.equals(this.active, consentDashboardSummaryArrangementsByStatus.active) &&
        Objects.equals(this.expired, consentDashboardSummaryArrangementsByStatus.expired) &&
        Objects.equals(this.revoked, consentDashboardSummaryArrangementsByStatus.revoked) &&
        Objects.equals(this.suspended, consentDashboardSummaryArrangementsByStatus.suspended);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, expired, revoked, suspended);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentDashboardSummaryArrangementsByStatus {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    expired: ").append(toIndentedString(expired)).append("\n");
    sb.append("    revoked: ").append(toIndentedString(revoked)).append("\n");
    sb.append("    suspended: ").append(toIndentedString(suspended)).append("\n");
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
