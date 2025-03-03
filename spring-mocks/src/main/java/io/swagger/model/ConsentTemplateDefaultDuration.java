package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
 * ConsentTemplateDefaultDuration
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class ConsentTemplateDefaultDuration   {
  @JsonProperty("value")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer value = null;

  /**
   * Gets or Sets unit
   */
  public enum UnitEnum {
    DAYS("days"),
    
    MONTHS("months"),
    
    YEARS("years");

    private String value;

    UnitEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static UnitEnum fromValue(String text) {
      for (UnitEnum b : UnitEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("unit")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private UnitEnum unit = null;


  public ConsentTemplateDefaultDuration value(Integer value) { 

    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   **/
  
  @Schema(description = "")
  
  public Integer getValue() {  
    return value;
  }



  public void setValue(Integer value) { 
    this.value = value;
  }

  public ConsentTemplateDefaultDuration unit(UnitEnum unit) { 

    this.unit = unit;
    return this;
  }

  /**
   * Get unit
   * @return unit
   **/
  
  @Schema(description = "")
  
  public UnitEnum getUnit() {  
    return unit;
  }



  public void setUnit(UnitEnum unit) { 
    this.unit = unit;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentTemplateDefaultDuration consentTemplateDefaultDuration = (ConsentTemplateDefaultDuration) o;
    return Objects.equals(this.value, consentTemplateDefaultDuration.value) &&
        Objects.equals(this.unit, consentTemplateDefaultDuration.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, unit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentTemplateDefaultDuration {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
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
