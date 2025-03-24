package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.ConsentArrangementRequestAdditionalTerms;
import io.swagger.model.ConsentArrangementResponseRevocationInfo;
import io.swagger.model.ConsentArrangementResponseSharingDuration;
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
 * ConsentArrangementResponse
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class ConsentArrangementResponse   {
  @JsonProperty("id")

  private String id = null;

  /**
   * Current status of the consent arrangement
   */
  public enum StatusEnum {
    ACTIVE("active"),
    
    EXPIRED("expired"),
    
    REVOKED("revoked"),
    
    SUSPENDED("suspended");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")

  private StatusEnum status = null;

  @JsonProperty("created_at")

  private OffsetDateTime createdAt = null;

  @JsonProperty("last_updated_at")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private OffsetDateTime lastUpdatedAt = null;

  @JsonProperty("data_holder_id")

  private String dataHolderId = null;

  @JsonProperty("permissions")
  @Valid
  private List<String> permissions = new ArrayList<String>();
  @JsonProperty("sharing_duration")

  private ConsentArrangementResponseSharingDuration sharingDuration = null;

  @JsonProperty("purpose")

  private String purpose = null;

  @JsonProperty("additional_terms")
  @Valid
  private List<ConsentArrangementRequestAdditionalTerms> additionalTerms = null;
  @JsonProperty("revocation_info")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private ConsentArrangementResponseRevocationInfo revocationInfo = null;


  public ConsentArrangementResponse id(String id) { 

    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the consent arrangement
   * @return id
   **/
  
  @Schema(required = true, description = "Unique identifier for the consent arrangement")
  
  @NotNull
  public String getId() {  
    return id;
  }



  public void setId(String id) { 

    this.id = id;
  }

  public ConsentArrangementResponse status(StatusEnum status) { 

    this.status = status;
    return this;
  }

  /**
   * Current status of the consent arrangement
   * @return status
   **/
  
  @Schema(required = true, description = "Current status of the consent arrangement")
  
  @NotNull
  public StatusEnum getStatus() {  
    return status;
  }



  public void setStatus(StatusEnum status) { 

    this.status = status;
  }

  public ConsentArrangementResponse createdAt(OffsetDateTime createdAt) { 

    this.createdAt = createdAt;
    return this;
  }

  /**
   * When the consent arrangement was created
   * @return createdAt
   **/
  
  @Schema(required = true, description = "When the consent arrangement was created")
  
@Valid
  @NotNull
  public OffsetDateTime getCreatedAt() {  
    return createdAt;
  }



  public void setCreatedAt(OffsetDateTime createdAt) { 

    this.createdAt = createdAt;
  }

  public ConsentArrangementResponse lastUpdatedAt(OffsetDateTime lastUpdatedAt) { 

    this.lastUpdatedAt = lastUpdatedAt;
    return this;
  }

  /**
   * When the consent arrangement was last updated
   * @return lastUpdatedAt
   **/
  
  @Schema(description = "When the consent arrangement was last updated")
  
@Valid
  public OffsetDateTime getLastUpdatedAt() {  
    return lastUpdatedAt;
  }



  public void setLastUpdatedAt(OffsetDateTime lastUpdatedAt) { 
    this.lastUpdatedAt = lastUpdatedAt;
  }

  public ConsentArrangementResponse dataHolderId(String dataHolderId) { 

    this.dataHolderId = dataHolderId;
    return this;
  }

  /**
   * Identifier of the data holder
   * @return dataHolderId
   **/
  
  @Schema(required = true, description = "Identifier of the data holder")
  
  @NotNull
  public String getDataHolderId() {  
    return dataHolderId;
  }



  public void setDataHolderId(String dataHolderId) { 

    this.dataHolderId = dataHolderId;
  }

  public ConsentArrangementResponse permissions(List<String> permissions) { 

    this.permissions = permissions;
    return this;
  }

  public ConsentArrangementResponse addPermissionsItem(String permissionsItem) {
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * Granted permissions for data access
   * @return permissions
   **/
  
  @Schema(required = true, description = "Granted permissions for data access")
  
  @NotNull
  public List<String> getPermissions() {  
    return permissions;
  }



  public void setPermissions(List<String> permissions) { 

    this.permissions = permissions;
  }

  public ConsentArrangementResponse sharingDuration(ConsentArrangementResponseSharingDuration sharingDuration) { 

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
  public ConsentArrangementResponseSharingDuration getSharingDuration() {  
    return sharingDuration;
  }



  public void setSharingDuration(ConsentArrangementResponseSharingDuration sharingDuration) { 

    this.sharingDuration = sharingDuration;
  }

  public ConsentArrangementResponse purpose(String purpose) { 

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

  public ConsentArrangementResponse additionalTerms(List<ConsentArrangementRequestAdditionalTerms> additionalTerms) { 

    this.additionalTerms = additionalTerms;
    return this;
  }

  public ConsentArrangementResponse addAdditionalTermsItem(ConsentArrangementRequestAdditionalTerms additionalTermsItem) {
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

  public ConsentArrangementResponse revocationInfo(ConsentArrangementResponseRevocationInfo revocationInfo) { 

    this.revocationInfo = revocationInfo;
    return this;
  }

  /**
   * Get revocationInfo
   * @return revocationInfo
   **/
  
  @Schema(description = "")
  
@Valid
  public ConsentArrangementResponseRevocationInfo getRevocationInfo() {  
    return revocationInfo;
  }



  public void setRevocationInfo(ConsentArrangementResponseRevocationInfo revocationInfo) { 
    this.revocationInfo = revocationInfo;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentArrangementResponse consentArrangementResponse = (ConsentArrangementResponse) o;
    return Objects.equals(this.id, consentArrangementResponse.id) &&
        Objects.equals(this.status, consentArrangementResponse.status) &&
        Objects.equals(this.createdAt, consentArrangementResponse.createdAt) &&
        Objects.equals(this.lastUpdatedAt, consentArrangementResponse.lastUpdatedAt) &&
        Objects.equals(this.dataHolderId, consentArrangementResponse.dataHolderId) &&
        Objects.equals(this.permissions, consentArrangementResponse.permissions) &&
        Objects.equals(this.sharingDuration, consentArrangementResponse.sharingDuration) &&
        Objects.equals(this.purpose, consentArrangementResponse.purpose) &&
        Objects.equals(this.additionalTerms, consentArrangementResponse.additionalTerms) &&
        Objects.equals(this.revocationInfo, consentArrangementResponse.revocationInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, createdAt, lastUpdatedAt, dataHolderId, permissions, sharingDuration, purpose, additionalTerms, revocationInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentArrangementResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    lastUpdatedAt: ").append(toIndentedString(lastUpdatedAt)).append("\n");
    sb.append("    dataHolderId: ").append(toIndentedString(dataHolderId)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    sharingDuration: ").append(toIndentedString(sharingDuration)).append("\n");
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
    sb.append("    additionalTerms: ").append(toIndentedString(additionalTerms)).append("\n");
    sb.append("    revocationInfo: ").append(toIndentedString(revocationInfo)).append("\n");
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
