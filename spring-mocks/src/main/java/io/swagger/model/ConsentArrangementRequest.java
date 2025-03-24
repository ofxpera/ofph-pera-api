package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.ConsentArrangementRequestAdditionalTerms;
import io.swagger.model.ConsentArrangementRequestSharingDuration;
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
 * ConsentArrangementRequest
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class ConsentArrangementRequest   {
  @JsonProperty("data_holder_id")

  private String dataHolderId = null;

  /**
   * Gets or Sets permissions
   */
  public enum PermissionsEnum {
    BASIC_INFO("PERA_BASIC_INFO"),
    
    BALANCE("PERA_BALANCE"),
    
    TRANSACTIONS("PERA_TRANSACTIONS"),
    
    INVESTMENT_DETAILS("PERA_INVESTMENT_DETAILS"),
    
    STATEMENTS("PERA_STATEMENTS");

    private String value;

    PermissionsEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PermissionsEnum fromValue(String text) {
      for (PermissionsEnum b : PermissionsEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("permissions")
  @Valid
  private List<PermissionsEnum> permissions = new ArrayList<PermissionsEnum>();
  @JsonProperty("sharing_duration")

  private ConsentArrangementRequestSharingDuration sharingDuration = null;

  @JsonProperty("purpose")

  private String purpose = null;

  @JsonProperty("additional_terms")
  @Valid
  private List<ConsentArrangementRequestAdditionalTerms> additionalTerms = null;

  public ConsentArrangementRequest dataHolderId(String dataHolderId) { 

    this.dataHolderId = dataHolderId;
    return this;
  }

  /**
   * Identifier of the data holder (financial institution)
   * @return dataHolderId
   **/
  
  @Schema(required = true, description = "Identifier of the data holder (financial institution)")
  
  @NotNull
  public String getDataHolderId() {  
    return dataHolderId;
  }



  public void setDataHolderId(String dataHolderId) { 

    this.dataHolderId = dataHolderId;
  }

  public ConsentArrangementRequest permissions(List<PermissionsEnum> permissions) { 

    this.permissions = permissions;
    return this;
  }

  public ConsentArrangementRequest addPermissionsItem(PermissionsEnum permissionsItem) {
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * Permissions being requested for data access
   * @return permissions
   **/
  
  @Schema(required = true, description = "Permissions being requested for data access")
  
  @NotNull
@Size(min=1)   public List<PermissionsEnum> getPermissions() {  
    return permissions;
  }



  public void setPermissions(List<PermissionsEnum> permissions) { 

    this.permissions = permissions;
  }

  public ConsentArrangementRequest sharingDuration(ConsentArrangementRequestSharingDuration sharingDuration) { 

    this.sharingDuration = sharingDuration;
    return this;
  }

  /**
   * Get sharingDuration
   * @return sharingDuration
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
  public ConsentArrangementRequestSharingDuration getSharingDuration() {  
    return sharingDuration;
  }



  public void setSharingDuration(ConsentArrangementRequestSharingDuration sharingDuration) { 

    this.sharingDuration = sharingDuration;
  }

  public ConsentArrangementRequest purpose(String purpose) { 

    this.purpose = purpose;
    return this;
  }

  /**
   * Purpose for which the data will be used
   * @return purpose
   **/
  
  @Schema(required = true, description = "Purpose for which the data will be used")
  
  @NotNull
  public String getPurpose() {  
    return purpose;
  }



  public void setPurpose(String purpose) { 

    this.purpose = purpose;
  }

  public ConsentArrangementRequest additionalTerms(List<ConsentArrangementRequestAdditionalTerms> additionalTerms) { 

    this.additionalTerms = additionalTerms;
    return this;
  }

  public ConsentArrangementRequest addAdditionalTermsItem(ConsentArrangementRequestAdditionalTerms additionalTermsItem) {
    if (this.additionalTerms == null) {
      this.additionalTerms = new ArrayList<ConsentArrangementRequestAdditionalTerms>();
    }
    this.additionalTerms.add(additionalTermsItem);
    return this;
  }

  /**
   * Additional terms and conditions specific to this arrangement
   * @return additionalTerms
   **/
  
  @Schema(description = "Additional terms and conditions specific to this arrangement")
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
    ConsentArrangementRequest consentArrangementRequest = (ConsentArrangementRequest) o;
    return Objects.equals(this.dataHolderId, consentArrangementRequest.dataHolderId) &&
        Objects.equals(this.permissions, consentArrangementRequest.permissions) &&
        Objects.equals(this.sharingDuration, consentArrangementRequest.sharingDuration) &&
        Objects.equals(this.purpose, consentArrangementRequest.purpose) &&
        Objects.equals(this.additionalTerms, consentArrangementRequest.additionalTerms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataHolderId, permissions, sharingDuration, purpose, additionalTerms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentArrangementRequest {\n");
    
    sb.append("    dataHolderId: ").append(toIndentedString(dataHolderId)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    sharingDuration: ").append(toIndentedString(sharingDuration)).append("\n");
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
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
