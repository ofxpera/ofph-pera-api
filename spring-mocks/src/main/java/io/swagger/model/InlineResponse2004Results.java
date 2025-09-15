package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.BulkConsentResponseError;
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
 * InlineResponse2004Results
 */
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class InlineResponse2004Results   {
  @JsonProperty("id")

  private String id = null;

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

  @JsonProperty("error")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private BulkConsentResponseError error = null;


  public InlineResponse2004Results id(String id) { 

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

  public InlineResponse2004Results status(StatusEnum status) { 

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

  public InlineResponse2004Results error(BulkConsentResponseError error) { 

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
    InlineResponse2004Results inlineResponse2004Results = (InlineResponse2004Results) o;
    return Objects.equals(this.id, inlineResponse2004Results.id) &&
        Objects.equals(this.status, inlineResponse2004Results.status) &&
        Objects.equals(this.error, inlineResponse2004Results.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2004Results {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
