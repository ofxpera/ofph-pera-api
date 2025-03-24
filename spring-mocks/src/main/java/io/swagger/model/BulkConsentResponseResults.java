package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.BulkConsentResponseError;
import io.swagger.model.ConsentArrangementResponse;
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
 * BulkConsentResponseResults
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class BulkConsentResponseResults   {
  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    SUCCESS("success"),
    
    FAILED("failed");

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

  @JsonProperty("arrangement")

  private ConsentArrangementResponse arrangement = null;

  @JsonProperty("error")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private BulkConsentResponseError error = null;


  public BulkConsentResponseResults status(StatusEnum status) { 

    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public StatusEnum getStatus() {  
    return status;
  }



  public void setStatus(StatusEnum status) { 

    this.status = status;
  }

  public BulkConsentResponseResults arrangement(ConsentArrangementResponse arrangement) { 

    this.arrangement = arrangement;
    return this;
  }

  /**
   * Get arrangement
   * @return arrangement
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
  public ConsentArrangementResponse getArrangement() {  
    return arrangement;
  }



  public void setArrangement(ConsentArrangementResponse arrangement) { 

    this.arrangement = arrangement;
  }

  public BulkConsentResponseResults error(BulkConsentResponseError error) { 

    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
   **/
  
  @Schema(description = "")
  
@Valid
  public BulkConsentResponseError getError() {  
    return error;
  }



  public void setError(BulkConsentResponseError error) { 
    this.error = error;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkConsentResponseResults bulkConsentResponseResults = (BulkConsentResponseResults) o;
    return Objects.equals(this.status, bulkConsentResponseResults.status) &&
        Objects.equals(this.arrangement, bulkConsentResponseResults.arrangement) &&
        Objects.equals(this.error, bulkConsentResponseResults.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, arrangement, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkConsentResponseResults {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    arrangement: ").append(toIndentedString(arrangement)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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
