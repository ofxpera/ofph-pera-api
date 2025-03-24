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
 * AddressString
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:06:40.598571645Z[GMT]")


public class AddressString  implements OneOfCustomerDueDiligenceEmployerAddress, OneOfPersonalInformationResidentialAddress {
  /**
   * Format of address values
   */
  public enum AddressFormatEnum {
    TEXT("TEXT");

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
  @JsonProperty("address_format")

  private AddressFormatEnum addressFormat = null;

  @JsonProperty("region")

  private String region = null;

  @JsonProperty("province")

  private String province = null;

  @JsonProperty("city_municipality")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String cityMunicipality = null;

  @JsonProperty("barangay")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String barangay = null;

  @JsonProperty("street_address")

  private String streetAddress = null;

  @JsonProperty("building_unit_number")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String buildingUnitNumber = null;

  @JsonProperty("country")

  private String country = null;

  @JsonProperty("postal_code")

  private String postalCode = null;


  public AddressString addressFormat(AddressFormatEnum addressFormat) { 

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

  public AddressString region(String region) { 

    this.region = region;
    return this;
  }

  /**
   * Region
   * @return region
   **/
  
  @Schema(example = "Region IV-A (CALABARZON)", required = true, description = "Region")
  
  @NotNull
@Size(max=140)   public String getRegion() {  
    return region;
  }



  public void setRegion(String region) { 

    this.region = region;
  }

  public AddressString province(String province) { 

    this.province = province;
    return this;
  }

  /**
   * Province
   * @return province
   **/
  
  @Schema(example = "Rizal", required = true, description = "Province")
  
  @NotNull
@Size(max=140)   public String getProvince() {  
    return province;
  }



  public void setProvince(String province) { 

    this.province = province;
  }

  public AddressString cityMunicipality(String cityMunicipality) { 

    this.cityMunicipality = cityMunicipality;
    return this;
  }

  /**
   * City
   * @return cityMunicipality
   **/
  
  @Schema(example = "Tanay", description = "City")
  
@Size(max=140)   public String getCityMunicipality() {  
    return cityMunicipality;
  }



  public void setCityMunicipality(String cityMunicipality) { 
    this.cityMunicipality = cityMunicipality;
  }

  public AddressString barangay(String barangay) { 

    this.barangay = barangay;
    return this;
  }

  /**
   * Barangay
   * @return barangay
   **/
  
  @Schema(example = "Santo Niño", description = "Barangay")
  
@Size(max=140)   public String getBarangay() {  
    return barangay;
  }



  public void setBarangay(String barangay) { 
    this.barangay = barangay;
  }

  public AddressString streetAddress(String streetAddress) { 

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

  public AddressString buildingUnitNumber(String buildingUnitNumber) { 

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

  public AddressString country(String country) { 

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

  public AddressString postalCode(String postalCode) { 

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
    AddressString addressString = (AddressString) o;
    return Objects.equals(this.addressFormat, addressString.addressFormat) &&
        Objects.equals(this.region, addressString.region) &&
        Objects.equals(this.province, addressString.province) &&
        Objects.equals(this.cityMunicipality, addressString.cityMunicipality) &&
        Objects.equals(this.barangay, addressString.barangay) &&
        Objects.equals(this.streetAddress, addressString.streetAddress) &&
        Objects.equals(this.buildingUnitNumber, addressString.buildingUnitNumber) &&
        Objects.equals(this.country, addressString.country) &&
        Objects.equals(this.postalCode, addressString.postalCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressFormat, region, province, cityMunicipality, barangay, streetAddress, buildingUnitNumber, country, postalCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressString {\n");
    
    sb.append("    addressFormat: ").append(toIndentedString(addressFormat)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    province: ").append(toIndentedString(province)).append("\n");
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
