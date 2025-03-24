package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.ConsentTemplateDefaultDuration;
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
 * ConsentTemplate
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class ConsentTemplate   {
  @JsonProperty("template_id")

  private String templateId = null;

  @JsonProperty("name")

  private String name = null;

  @JsonProperty("description")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String description = null;

  @JsonProperty("category")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String category = null;

  @JsonProperty("permissions")
  @Valid
  private List<String> permissions = new ArrayList<String>();
  @JsonProperty("purpose")

  private String purpose = null;

  @JsonProperty("default_duration")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private ConsentTemplateDefaultDuration defaultDuration = null;

  @JsonProperty("terms_and_conditions")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String termsAndConditions = null;

  @JsonProperty("data_usage_policy")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String dataUsagePolicy = null;

  @JsonProperty("version")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String version = null;


  public ConsentTemplate templateId(String templateId) { 

    this.templateId = templateId;
    return this;
  }

  /**
   * Get templateId
   * @return templateId
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public String getTemplateId() {  
    return templateId;
  }



  public void setTemplateId(String templateId) { 

    this.templateId = templateId;
  }

  public ConsentTemplate name(String name) { 

    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public String getName() {  
    return name;
  }



  public void setName(String name) { 

    this.name = name;
  }

  public ConsentTemplate description(String description) { 

    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  
  @Schema(description = "")
  
  public String getDescription() {  
    return description;
  }



  public void setDescription(String description) { 
    this.description = description;
  }

  public ConsentTemplate category(String category) { 

    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   **/
  
  @Schema(description = "")
  
  public String getCategory() {  
    return category;
  }



  public void setCategory(String category) { 
    this.category = category;
  }

  public ConsentTemplate permissions(List<String> permissions) { 

    this.permissions = permissions;
    return this;
  }

  public ConsentTemplate addPermissionsItem(String permissionsItem) {
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * Get permissions
   * @return permissions
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public List<String> getPermissions() {  
    return permissions;
  }



  public void setPermissions(List<String> permissions) { 

    this.permissions = permissions;
  }

  public ConsentTemplate purpose(String purpose) { 

    this.purpose = purpose;
    return this;
  }

  /**
   * Get purpose
   * @return purpose
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public String getPurpose() {  
    return purpose;
  }



  public void setPurpose(String purpose) { 

    this.purpose = purpose;
  }

  public ConsentTemplate defaultDuration(ConsentTemplateDefaultDuration defaultDuration) { 

    this.defaultDuration = defaultDuration;
    return this;
  }

  /**
   * Get defaultDuration
   * @return defaultDuration
   **/
  
  @Schema(description = "")
  
@Valid
  public ConsentTemplateDefaultDuration getDefaultDuration() {  
    return defaultDuration;
  }



  public void setDefaultDuration(ConsentTemplateDefaultDuration defaultDuration) { 
    this.defaultDuration = defaultDuration;
  }

  public ConsentTemplate termsAndConditions(String termsAndConditions) { 

    this.termsAndConditions = termsAndConditions;
    return this;
  }

  /**
   * Get termsAndConditions
   * @return termsAndConditions
   **/
  
  @Schema(description = "")
  
  public String getTermsAndConditions() {  
    return termsAndConditions;
  }



  public void setTermsAndConditions(String termsAndConditions) { 
    this.termsAndConditions = termsAndConditions;
  }

  public ConsentTemplate dataUsagePolicy(String dataUsagePolicy) { 

    this.dataUsagePolicy = dataUsagePolicy;
    return this;
  }

  /**
   * Get dataUsagePolicy
   * @return dataUsagePolicy
   **/
  
  @Schema(description = "")
  
  public String getDataUsagePolicy() {  
    return dataUsagePolicy;
  }



  public void setDataUsagePolicy(String dataUsagePolicy) { 
    this.dataUsagePolicy = dataUsagePolicy;
  }

  public ConsentTemplate version(String version) { 

    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
   **/
  
  @Schema(description = "")
  
  public String getVersion() {  
    return version;
  }



  public void setVersion(String version) { 
    this.version = version;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentTemplate consentTemplate = (ConsentTemplate) o;
    return Objects.equals(this.templateId, consentTemplate.templateId) &&
        Objects.equals(this.name, consentTemplate.name) &&
        Objects.equals(this.description, consentTemplate.description) &&
        Objects.equals(this.category, consentTemplate.category) &&
        Objects.equals(this.permissions, consentTemplate.permissions) &&
        Objects.equals(this.purpose, consentTemplate.purpose) &&
        Objects.equals(this.defaultDuration, consentTemplate.defaultDuration) &&
        Objects.equals(this.termsAndConditions, consentTemplate.termsAndConditions) &&
        Objects.equals(this.dataUsagePolicy, consentTemplate.dataUsagePolicy) &&
        Objects.equals(this.version, consentTemplate.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(templateId, name, description, category, permissions, purpose, defaultDuration, termsAndConditions, dataUsagePolicy, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentTemplate {\n");
    
    sb.append("    templateId: ").append(toIndentedString(templateId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
    sb.append("    defaultDuration: ").append(toIndentedString(defaultDuration)).append("\n");
    sb.append("    termsAndConditions: ").append(toIndentedString(termsAndConditions)).append("\n");
    sb.append("    dataUsagePolicy: ").append(toIndentedString(dataUsagePolicy)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
