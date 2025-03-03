package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * IdType
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class IdType   {
  @JsonProperty("idNumber")

  private String idNumber = null;

  @JsonProperty("idExpiryDate")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private LocalDate idExpiryDate = null;

  @JsonProperty("idType")

  private String idType = null;


  public IdType idNumber(String idNumber) { 

    this.idNumber = idNumber;
    return this;
  }

  /**
   * Get idNumber
   * @return idNumber
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
@Size(max=50)   public String getIdNumber() {  
    return idNumber;
  }



  public void setIdNumber(String idNumber) { 

    this.idNumber = idNumber;
  }

  public IdType idExpiryDate(LocalDate idExpiryDate) { 

    this.idExpiryDate = idExpiryDate;
    return this;
  }

  /**
   * Format is YYYY-MM-DD
   * @return idExpiryDate
   **/
  
  @Schema(description = "Format is YYYY-MM-DD")
  
@Valid
  public LocalDate getIdExpiryDate() {  
    return idExpiryDate;
  }



  public void setIdExpiryDate(LocalDate idExpiryDate) { 
    this.idExpiryDate = idExpiryDate;
  }

  public IdType idType(String idType) { 

    this.idType = idType;
    return this;
  }

  /**
   * ID Type (e.g., \"Drivers License\", \"Passport\", etc.)
   * @return idType
   **/
  
  @Schema(required = true, description = "ID Type (e.g., \"Drivers License\", \"Passport\", etc.)")
  
  @NotNull
@Size(max=100)   public String getIdType() {  
    return idType;
  }



  public void setIdType(String idType) { 

    this.idType = idType;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdType idType = (IdType) o;
    return Objects.equals(this.idNumber, idType.idNumber) &&
        Objects.equals(this.idExpiryDate, idType.idExpiryDate) &&
        Objects.equals(this.idType, idType.idType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idNumber, idExpiryDate, idType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdType {\n");
    
    sb.append("    idNumber: ").append(toIndentedString(idNumber)).append("\n");
    sb.append("    idExpiryDate: ").append(toIndentedString(idExpiryDate)).append("\n");
    sb.append("    idType: ").append(toIndentedString(idType)).append("\n");
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
