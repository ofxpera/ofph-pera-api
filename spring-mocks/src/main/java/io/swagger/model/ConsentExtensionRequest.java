package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.ConsentArrangementRequestAdditionalTerms;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConsentExtensionRequest
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class ConsentExtensionRequest   {
  @JsonProperty("new_end_date")

  private OffsetDateTime newEndDate = null;

  @JsonProperty("reason")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String reason = null;

  @JsonProperty("additional_terms")
  @Valid
  private List<ConsentArrangementRequestAdditionalTerms> additionalTerms = null;

  public ConsentExtensionRequest newEndDate(OffsetDateTime newEndDate) { 

    this.newEndDate = newEndDate;
    return this;
  }

  /**
   * New end date for the consent arrangement
   * @return newEndDate
   **/
  
  @Schema(required = true, description = "New end date for the consent arrangement")
  
@Valid
  @NotNull
  public OffsetDateTime getNewEndDate() {  
    return newEndDate;
  }



  public void setNewEndDate(OffsetDateTime newEndDate) { 

    this.newEndDate = newEndDate;
  }

  public ConsentExtensionRequest reason(String reason) { 

    this.reason = reason;
    return this;
  }

  /**
   * Reason for extending the consent
   * @return reason
   **/
  
  @Schema(description = "Reason for extending the consent")
  
  public String getReason() {  
    return reason;
  }



  public void setReason(String reason) { 
    this.reason = reason;
  }

  public ConsentExtensionRequest additionalTerms(List<ConsentArrangementRequestAdditionalTerms> additionalTerms) { 

    this.additionalTerms = additionalTerms;
    return this;
  }

  public ConsentExtensionRequest addAdditionalTermsItem(ConsentArrangementRequestAdditionalTerms additionalTermsItem) {
    if (this.additionalTerms == null) {
      this.additionalTerms = new ArrayList<ConsentArrangementRequestAdditionalTerms>();
    }
    this.additionalTerms.add(additionalTermsItem);
    return this;
  }

  /**
   * Get additionalTerms
   * @return additionalTerms
   **/
  
  @Schema(description = "")
  @Valid
  public List<ConsentArrangementRequestAdditionalTerms> getAdditionalTerms() {  
    return additionalTerms;
  }



  public void setAdditionalTerms(List<ConsentArrangementRequestAdditionalTerms> additionalTerms) { 
    this.additionalTerms = additionalTerms;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentExtensionRequest consentExtensionRequest = (ConsentExtensionRequest) o;
    return Objects.equals(this.newEndDate, consentExtensionRequest.newEndDate) &&
        Objects.equals(this.reason, consentExtensionRequest.reason) &&
        Objects.equals(this.additionalTerms, consentExtensionRequest.additionalTerms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newEndDate, reason, additionalTerms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentExtensionRequest {\n");
    
    sb.append("    newEndDate: ").append(toIndentedString(newEndDate)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    additionalTerms: ").append(toIndentedString(additionalTerms)).append("\n");
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
