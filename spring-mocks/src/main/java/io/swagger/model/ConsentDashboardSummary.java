package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.ConsentArrangementResponse;
import io.swagger.model.ConsentDashboardSummaryArrangementsByPurpose;
import io.swagger.model.ConsentDashboardSummaryArrangementsByStatus;
import io.swagger.model.ConsentDashboardSummaryDataHolders;
import io.swagger.model.ConsentHistory;
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
 * ConsentDashboardSummary
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class ConsentDashboardSummary   {
  @JsonProperty("total_arrangements")

  private Integer totalArrangements = null;

  @JsonProperty("active_arrangements")

  private Integer activeArrangements = null;

  @JsonProperty("arrangements_by_status")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private ConsentDashboardSummaryArrangementsByStatus arrangementsByStatus = null;

  @JsonProperty("arrangements_by_purpose")
  @Valid
  private List<ConsentDashboardSummaryArrangementsByPurpose> arrangementsByPurpose = null;
  @JsonProperty("data_holders")
  @Valid
  private List<ConsentDashboardSummaryDataHolders> dataHolders = null;
  @JsonProperty("recent_activity")
  @Valid
  private List<ConsentHistory> recentActivity = null;
  @JsonProperty("expiring_soon")
  @Valid
  private List<ConsentArrangementResponse> expiringSoon = null;

  public ConsentDashboardSummary totalArrangements(Integer totalArrangements) { 

    this.totalArrangements = totalArrangements;
    return this;
  }

  /**
   * Get totalArrangements
   * @return totalArrangements
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public Integer getTotalArrangements() {  
    return totalArrangements;
  }



  public void setTotalArrangements(Integer totalArrangements) { 

    this.totalArrangements = totalArrangements;
  }

  public ConsentDashboardSummary activeArrangements(Integer activeArrangements) { 

    this.activeArrangements = activeArrangements;
    return this;
  }

  /**
   * Get activeArrangements
   * @return activeArrangements
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public Integer getActiveArrangements() {  
    return activeArrangements;
  }



  public void setActiveArrangements(Integer activeArrangements) { 

    this.activeArrangements = activeArrangements;
  }

  public ConsentDashboardSummary arrangementsByStatus(ConsentDashboardSummaryArrangementsByStatus arrangementsByStatus) { 

    this.arrangementsByStatus = arrangementsByStatus;
    return this;
  }

  /**
   * Get arrangementsByStatus
   * @return arrangementsByStatus
   **/
  
  @Schema(description = "")
  
@Valid
  public ConsentDashboardSummaryArrangementsByStatus getArrangementsByStatus() {  
    return arrangementsByStatus;
  }



  public void setArrangementsByStatus(ConsentDashboardSummaryArrangementsByStatus arrangementsByStatus) { 
    this.arrangementsByStatus = arrangementsByStatus;
  }

  public ConsentDashboardSummary arrangementsByPurpose(List<ConsentDashboardSummaryArrangementsByPurpose> arrangementsByPurpose) { 

    this.arrangementsByPurpose = arrangementsByPurpose;
    return this;
  }

  public ConsentDashboardSummary addArrangementsByPurposeItem(ConsentDashboardSummaryArrangementsByPurpose arrangementsByPurposeItem) {
    if (this.arrangementsByPurpose == null) {
      this.arrangementsByPurpose = new ArrayList<ConsentDashboardSummaryArrangementsByPurpose>();
    }
    this.arrangementsByPurpose.add(arrangementsByPurposeItem);
    return this;
  }

  /**
   * Get arrangementsByPurpose
   * @return arrangementsByPurpose
   **/
  
  @Schema(description = "")
  @Valid
  public List<ConsentDashboardSummaryArrangementsByPurpose> getArrangementsByPurpose() {  
    return arrangementsByPurpose;
  }



  public void setArrangementsByPurpose(List<ConsentDashboardSummaryArrangementsByPurpose> arrangementsByPurpose) { 
    this.arrangementsByPurpose = arrangementsByPurpose;
  }

  public ConsentDashboardSummary dataHolders(List<ConsentDashboardSummaryDataHolders> dataHolders) { 

    this.dataHolders = dataHolders;
    return this;
  }

  public ConsentDashboardSummary addDataHoldersItem(ConsentDashboardSummaryDataHolders dataHoldersItem) {
    if (this.dataHolders == null) {
      this.dataHolders = new ArrayList<ConsentDashboardSummaryDataHolders>();
    }
    this.dataHolders.add(dataHoldersItem);
    return this;
  }

  /**
   * Get dataHolders
   * @return dataHolders
   **/
  
  @Schema(description = "")
  @Valid
  public List<ConsentDashboardSummaryDataHolders> getDataHolders() {  
    return dataHolders;
  }



  public void setDataHolders(List<ConsentDashboardSummaryDataHolders> dataHolders) { 
    this.dataHolders = dataHolders;
  }

  public ConsentDashboardSummary recentActivity(List<ConsentHistory> recentActivity) { 

    this.recentActivity = recentActivity;
    return this;
  }

  public ConsentDashboardSummary addRecentActivityItem(ConsentHistory recentActivityItem) {
    if (this.recentActivity == null) {
      this.recentActivity = new ArrayList<ConsentHistory>();
    }
    this.recentActivity.add(recentActivityItem);
    return this;
  }

  /**
   * Get recentActivity
   * @return recentActivity
   **/
  
  @Schema(description = "")
  @Valid
  public List<ConsentHistory> getRecentActivity() {  
    return recentActivity;
  }



  public void setRecentActivity(List<ConsentHistory> recentActivity) { 
    this.recentActivity = recentActivity;
  }

  public ConsentDashboardSummary expiringSoon(List<ConsentArrangementResponse> expiringSoon) { 

    this.expiringSoon = expiringSoon;
    return this;
  }

  public ConsentDashboardSummary addExpiringSoonItem(ConsentArrangementResponse expiringSoonItem) {
    if (this.expiringSoon == null) {
      this.expiringSoon = new ArrayList<ConsentArrangementResponse>();
    }
    this.expiringSoon.add(expiringSoonItem);
    return this;
  }

  /**
   * Arrangements expiring in the next 30 days
   * @return expiringSoon
   **/
  
  @Schema(description = "Arrangements expiring in the next 30 days")
  @Valid
  public List<ConsentArrangementResponse> getExpiringSoon() {  
    return expiringSoon;
  }



  public void setExpiringSoon(List<ConsentArrangementResponse> expiringSoon) { 
    this.expiringSoon = expiringSoon;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentDashboardSummary consentDashboardSummary = (ConsentDashboardSummary) o;
    return Objects.equals(this.totalArrangements, consentDashboardSummary.totalArrangements) &&
        Objects.equals(this.activeArrangements, consentDashboardSummary.activeArrangements) &&
        Objects.equals(this.arrangementsByStatus, consentDashboardSummary.arrangementsByStatus) &&
        Objects.equals(this.arrangementsByPurpose, consentDashboardSummary.arrangementsByPurpose) &&
        Objects.equals(this.dataHolders, consentDashboardSummary.dataHolders) &&
        Objects.equals(this.recentActivity, consentDashboardSummary.recentActivity) &&
        Objects.equals(this.expiringSoon, consentDashboardSummary.expiringSoon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalArrangements, activeArrangements, arrangementsByStatus, arrangementsByPurpose, dataHolders, recentActivity, expiringSoon);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentDashboardSummary {\n");
    
    sb.append("    totalArrangements: ").append(toIndentedString(totalArrangements)).append("\n");
    sb.append("    activeArrangements: ").append(toIndentedString(activeArrangements)).append("\n");
    sb.append("    arrangementsByStatus: ").append(toIndentedString(arrangementsByStatus)).append("\n");
    sb.append("    arrangementsByPurpose: ").append(toIndentedString(arrangementsByPurpose)).append("\n");
    sb.append("    dataHolders: ").append(toIndentedString(dataHolders)).append("\n");
    sb.append("    recentActivity: ").append(toIndentedString(recentActivity)).append("\n");
    sb.append("    expiringSoon: ").append(toIndentedString(expiringSoon)).append("\n");
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
