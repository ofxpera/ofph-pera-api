package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.ConsentExtensionRequest;
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
 * ConsentcustomerscustomerIdarrangementsbulkupdateUpdates
 */
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class ConsentcustomerscustomerIdarrangementsbulkupdateUpdates   {
  @JsonProperty("id")

  private String id = null;

  /**
   * Gets or Sets action
   */
  public enum ActionEnum {
    REVOKE("revoke"),
    
    SUSPEND("suspend"),
    
    RESUME("resume"),
    
    EXTEND("extend");

    private String value;

    ActionEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ActionEnum fromValue(String text) {
      for (ActionEnum b : ActionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("action")

  private ActionEnum action = null;

  @JsonProperty("reason")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String reason = null;

  @JsonProperty("extension_details")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private ConsentExtensionRequest extensionDetails = null;


  public ConsentcustomerscustomerIdarrangementsbulkupdateUpdates id(String id) { 

    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public String getId() {  
    return id;
  }



  public void setId(String id) { 

    this.id = id;
  }

  public ConsentcustomerscustomerIdarrangementsbulkupdateUpdates action(ActionEnum action) { 

    this.action = action;
    return this;
  }

  /**
   * Get action
   * @return action
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public ActionEnum getAction() {  
    return action;
  }



  public void setAction(ActionEnum action) { 

    this.action = action;
  }

  public ConsentcustomerscustomerIdarrangementsbulkupdateUpdates reason(String reason) { 

    this.reason = reason;
    return this;
  }

  /**
   * Get reason
   * @return reason
   **/
  
  @Schema(description = "")
  
  public String getReason() {  
    return reason;
  }



  public void setReason(String reason) { 
    this.reason = reason;
  }

  public ConsentcustomerscustomerIdarrangementsbulkupdateUpdates extensionDetails(ConsentExtensionRequest extensionDetails) { 

    this.extensionDetails = extensionDetails;
    return this;
  }

  /**
   * Get extensionDetails
   * @return extensionDetails
   **/
  
  @Schema(description = "")
  
@Valid
  public ConsentExtensionRequest getExtensionDetails() {  
    return extensionDetails;
  }



  public void setExtensionDetails(ConsentExtensionRequest extensionDetails) { 
    this.extensionDetails = extensionDetails;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentcustomerscustomerIdarrangementsbulkupdateUpdates consentcustomerscustomerIdarrangementsbulkupdateUpdates = (ConsentcustomerscustomerIdarrangementsbulkupdateUpdates) o;
    return Objects.equals(this.id, consentcustomerscustomerIdarrangementsbulkupdateUpdates.id) &&
        Objects.equals(this.action, consentcustomerscustomerIdarrangementsbulkupdateUpdates.action) &&
        Objects.equals(this.reason, consentcustomerscustomerIdarrangementsbulkupdateUpdates.reason) &&
        Objects.equals(this.extensionDetails, consentcustomerscustomerIdarrangementsbulkupdateUpdates.extensionDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, action, reason, extensionDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentcustomerscustomerIdarrangementsbulkupdateUpdates {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    extensionDetails: ").append(toIndentedString(extensionDetails)).append("\n");
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
