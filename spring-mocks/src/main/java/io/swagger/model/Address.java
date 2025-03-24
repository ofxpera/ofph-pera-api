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
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Address
 */
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class Address  implements OneOfCustomerDueDiligenceEmployerAddress, OneOfPersonalInformationResidentialAddress {
  /**
   * Format of address values
   */
  public enum AddressFormatEnum {
    PSGC("PSGC");

    private String value;

    AddressFormatEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AddressFormatEnum fromValue(String text) {
      for (AddressFormatEnum b : AddressFormatEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("addressFormat")

  private AddressFormatEnum addressFormat = null;

  @JsonProperty("cityMunicipality")

  private String cityMunicipality = null;

  @JsonProperty("barangay")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String barangay = null;

  @JsonProperty("streetAddress")

  private String streetAddress = null;

  @JsonProperty("buildingUnitNumber")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String buildingUnitNumber = null;

  @JsonProperty("country")

  private String country = null;

  @JsonProperty("postalCode")

  private String postalCode = null;


  public Address addressFormat(AddressFormatEnum addressFormat) { 

    this.addressFormat = addressFormat;
    return this;
  }

  /**
   * Format of address values
   * @return addressFormat
   **/
  
  @Schema(required = true, description = "Format of address values")
  
  @NotNull
@Size(max=4)   public AddressFormatEnum getAddressFormat() {  
    return addressFormat;
  }



  public void setAddressFormat(AddressFormatEnum addressFormat) { 

    this.addressFormat = addressFormat;
  }

  public Address cityMunicipality(String cityMunicipality) { 

    this.cityMunicipality = cityMunicipality;
    return this;
  }

  /**
   * PSGC Code for City
   * @return cityMunicipality
   **/
  
  @Schema(example = "0405812000", required = true, description = "PSGC Code for City")
  
  @NotNull
@Size(max=10)   public String getCityMunicipality() {  
    return cityMunicipality;
  }



  public void setCityMunicipality(String cityMunicipality) { 

    this.cityMunicipality = cityMunicipality;
  }

  public Address barangay(String barangay) { 

    this.barangay = barangay;
    return this;
  }

  /**
   * PSGC Code for Barangay
   * @return barangay
   **/
  
  @Schema(example = "0405812016", description = "PSGC Code for Barangay")
  
@Size(max=10)   public String getBarangay() {  
    return barangay;
  }



  public void setBarangay(String barangay) { 
    this.barangay = barangay;
  }

  public Address streetAddress(String streetAddress) { 

    this.streetAddress = streetAddress;
    return this;
  }

  /**
   * Street Address
   * @return streetAddress
   **/
  
  @Schema(example = "Yakal Street cor Lawaan Street", required = true, description = "Street Address")
  
  @NotNull
@Size(max=200)   public String getStreetAddress() {  
    return streetAddress;
  }



  public void setStreetAddress(String streetAddress) { 

    this.streetAddress = streetAddress;
  }

  public Address buildingUnitNumber(String buildingUnitNumber) { 

    this.buildingUnitNumber = buildingUnitNumber;
    return this;
  }

  /**
   * Building and/or Unit Number
   * @return buildingUnitNumber
   **/
  
  @Schema(example = "#357 Barbie's Townhouse", description = "Building and/or Unit Number")
  
@Size(max=200)   public String getBuildingUnitNumber() {  
    return buildingUnitNumber;
  }



  public void setBuildingUnitNumber(String buildingUnitNumber) { 
    this.buildingUnitNumber = buildingUnitNumber;
  }

  public Address country(String country) { 

    this.country = country;
    return this;
  }

  /**
   * ISO 3166 Code
   * @return country
   **/
  
  @Schema(example = "PHL", required = true, description = "ISO 3166 Code")
  
  @NotNull
@Pattern(regexp="^[A-Z]{3}$") @Size(max=3)   public String getCountry() {  
    return country;
  }



  public void setCountry(String country) { 

    this.country = country;
  }

  public Address postalCode(String postalCode) { 

    this.postalCode = postalCode;
    return this;
  }

  /**
   * Postal Code
   * @return postalCode
   **/
  
  @Schema(example = "1635", required = true, description = "Postal Code")
  
  @NotNull
@Size(max=10)   public String getPostalCode() {  
    return postalCode;
  }



  public void setPostalCode(String postalCode) { 

    this.postalCode = postalCode;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.addressFormat, address.addressFormat) &&
        Objects.equals(this.cityMunicipality, address.cityMunicipality) &&
        Objects.equals(this.barangay, address.barangay) &&
        Objects.equals(this.streetAddress, address.streetAddress) &&
        Objects.equals(this.buildingUnitNumber, address.buildingUnitNumber) &&
        Objects.equals(this.country, address.country) &&
        Objects.equals(this.postalCode, address.postalCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressFormat, cityMunicipality, barangay, streetAddress, buildingUnitNumber, country, postalCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    
    sb.append("    addressFormat: ").append(toIndentedString(addressFormat)).append("\n");
    sb.append("    cityMunicipality: ").append(toIndentedString(cityMunicipality)).append("\n");
    sb.append("    barangay: ").append(toIndentedString(barangay)).append("\n");
    sb.append("    streetAddress: ").append(toIndentedString(streetAddress)).append("\n");
    sb.append("    buildingUnitNumber: ").append(toIndentedString(buildingUnitNumber)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
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
