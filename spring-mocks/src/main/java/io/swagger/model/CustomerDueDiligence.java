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
 * CustomerDueDiligence
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class CustomerDueDiligence   {
  @JsonProperty("employmentStatus")

  private String employmentStatus = null;

  @JsonProperty("occupation")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String occupation = null;

  @JsonProperty("natureOfWork")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String natureOfWork = null;

  @JsonProperty("employerName")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String employerName = null;

  @JsonProperty("employerAddress")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private OneOfCustomerDueDiligenceEmployerAddress employerAddress = null;

  @JsonProperty("pepIndicator")

  private Boolean pepIndicator = false;

  @JsonProperty("fundSource")

  private String fundSource = null;

  /**
   * Customer Due Diligence Risk Level
   */
  public enum CddIndicatorEnum {
    LOW("Low"),
    
    NORMAL("Normal"),
    
    HIGH("High");

    private String value;

    CddIndicatorEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CddIndicatorEnum fromValue(String text) {
      for (CddIndicatorEnum b : CddIndicatorEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("cddIndicator")

  private CddIndicatorEnum cddIndicator = CddIndicatorEnum.NORMAL;


  public CustomerDueDiligence employmentStatus(String employmentStatus) { 

    this.employmentStatus = employmentStatus;
    return this;
  }

  /**
   * Get employmentStatus
   * @return employmentStatus
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
@Size(max=50)   public String getEmploymentStatus() {  
    return employmentStatus;
  }



  public void setEmploymentStatus(String employmentStatus) { 

    this.employmentStatus = employmentStatus;
  }

  public CustomerDueDiligence occupation(String occupation) { 

    this.occupation = occupation;
    return this;
  }

  /**
   * Get occupation
   * @return occupation
   **/
  
  @Schema(description = "")
  
@Size(max=150)   public String getOccupation() {  
    return occupation;
  }



  public void setOccupation(String occupation) { 
    this.occupation = occupation;
  }

  public CustomerDueDiligence natureOfWork(String natureOfWork) { 

    this.natureOfWork = natureOfWork;
    return this;
  }

  /**
   * PSIC Code
   * @return natureOfWork
   **/
  
  @Schema(description = "PSIC Code")
  
@Size(max=10)   public String getNatureOfWork() {  
    return natureOfWork;
  }



  public void setNatureOfWork(String natureOfWork) { 
    this.natureOfWork = natureOfWork;
  }

  public CustomerDueDiligence employerName(String employerName) { 

    this.employerName = employerName;
    return this;
  }

  /**
   * Get employerName
   * @return employerName
   **/
  
  @Schema(description = "")
  
@Size(max=255)   public String getEmployerName() {  
    return employerName;
  }



  public void setEmployerName(String employerName) { 
    this.employerName = employerName;
  }

  public CustomerDueDiligence employerAddress(OneOfCustomerDueDiligenceEmployerAddress employerAddress) { 

    this.employerAddress = employerAddress;
    return this;
  }

  /**
   * Get employerAddress
   * @return employerAddress
   **/
  
  @Schema(description = "")
  
  public OneOfCustomerDueDiligenceEmployerAddress getEmployerAddress() {  
    return employerAddress;
  }



  public void setEmployerAddress(OneOfCustomerDueDiligenceEmployerAddress employerAddress) { 
    this.employerAddress = employerAddress;
  }

  public CustomerDueDiligence pepIndicator(Boolean pepIndicator) { 

    this.pepIndicator = pepIndicator;
    return this;
  }

  /**
   * Politically Exposed Person 1 - True; 0 - False
   * @return pepIndicator
   **/
  
  @Schema(required = true, description = "Politically Exposed Person 1 - True; 0 - False")
  
  @NotNull
  public Boolean isPepIndicator() {  
    return pepIndicator;
  }



  public void setPepIndicator(Boolean pepIndicator) { 

    this.pepIndicator = pepIndicator;
  }

  public CustomerDueDiligence fundSource(String fundSource) { 

    this.fundSource = fundSource;
    return this;
  }

  /**
   * Source of Funds
   * @return fundSource
   **/
  
  @Schema(required = true, description = "Source of Funds")
  
  @NotNull
@Size(max=100)   public String getFundSource() {  
    return fundSource;
  }



  public void setFundSource(String fundSource) { 

    this.fundSource = fundSource;
  }

  public CustomerDueDiligence cddIndicator(CddIndicatorEnum cddIndicator) { 

    this.cddIndicator = cddIndicator;
    return this;
  }

  /**
   * Customer Due Diligence Risk Level
   * @return cddIndicator
   **/
  
  @Schema(required = true, description = "Customer Due Diligence Risk Level")
  
  @NotNull
@Size(max=6)   public CddIndicatorEnum getCddIndicator() {  
    return cddIndicator;
  }



  public void setCddIndicator(CddIndicatorEnum cddIndicator) { 

    this.cddIndicator = cddIndicator;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDueDiligence customerDueDiligence = (CustomerDueDiligence) o;
    return Objects.equals(this.employmentStatus, customerDueDiligence.employmentStatus) &&
        Objects.equals(this.occupation, customerDueDiligence.occupation) &&
        Objects.equals(this.natureOfWork, customerDueDiligence.natureOfWork) &&
        Objects.equals(this.employerName, customerDueDiligence.employerName) &&
        Objects.equals(this.employerAddress, customerDueDiligence.employerAddress) &&
        Objects.equals(this.pepIndicator, customerDueDiligence.pepIndicator) &&
        Objects.equals(this.fundSource, customerDueDiligence.fundSource) &&
        Objects.equals(this.cddIndicator, customerDueDiligence.cddIndicator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employmentStatus, occupation, natureOfWork, employerName, employerAddress, pepIndicator, fundSource, cddIndicator);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDueDiligence {\n");
    
    sb.append("    employmentStatus: ").append(toIndentedString(employmentStatus)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    natureOfWork: ").append(toIndentedString(natureOfWork)).append("\n");
    sb.append("    employerName: ").append(toIndentedString(employerName)).append("\n");
    sb.append("    employerAddress: ").append(toIndentedString(employerAddress)).append("\n");
    sb.append("    pepIndicator: ").append(toIndentedString(pepIndicator)).append("\n");
    sb.append("    fundSource: ").append(toIndentedString(fundSource)).append("\n");
    sb.append("    cddIndicator: ").append(toIndentedString(cddIndicator)).append("\n");
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
