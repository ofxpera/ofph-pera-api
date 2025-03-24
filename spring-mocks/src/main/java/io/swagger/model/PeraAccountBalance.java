package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
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
 * PeraAccountBalance
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class PeraAccountBalance   {
  @JsonProperty("current_value")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Double currentValue = null;

  @JsonProperty("currency")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String currency = "PHP";

  @JsonProperty("as_of")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private OffsetDateTime asOf = null;


  public PeraAccountBalance currentValue(Double currentValue) { 

    this.currentValue = currentValue;
    return this;
  }

  /**
   * Current value of the PERA arrangement
   * @return currentValue
   **/
  
  @Schema(description = "Current value of the PERA arrangement")
  
  public Double getCurrentValue() {  
    return currentValue;
  }



  public void setCurrentValue(Double currentValue) { 
    this.currentValue = currentValue;
  }

  public PeraAccountBalance currency(String currency) { 

    this.currency = currency;
    return this;
  }

  /**
   * Currency of the balance amounts
   * @return currency
   **/
  
  @Schema(description = "Currency of the balance amounts")
  
  public String getCurrency() {  
    return currency;
  }



  public void setCurrency(String currency) { 
    this.currency = currency;
  }

  public PeraAccountBalance asOf(OffsetDateTime asOf) { 

    this.asOf = asOf;
    return this;
  }

  /**
   * Timestamp of when the balance was last updated
   * @return asOf
   **/
  
  @Schema(description = "Timestamp of when the balance was last updated")
  
@Valid
  public OffsetDateTime getAsOf() {  
    return asOf;
  }



  public void setAsOf(OffsetDateTime asOf) { 
    this.asOf = asOf;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PeraAccountBalance peraAccountBalance = (PeraAccountBalance) o;
    return Objects.equals(this.currentValue, peraAccountBalance.currentValue) &&
        Objects.equals(this.currency, peraAccountBalance.currency) &&
        Objects.equals(this.asOf, peraAccountBalance.asOf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentValue, currency, asOf);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PeraAccountBalance {\n");
    
    sb.append("    currentValue: ").append(toIndentedString(currentValue)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    asOf: ").append(toIndentedString(asOf)).append("\n");
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
