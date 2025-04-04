/*
 * OFxPERA API
 * Philippines Open Finance API Implementation for PERA
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * Address
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2025-03-24T23:12:52.341191218Z[GMT]")

public class Address implements OneOfCustomerDueDiligenceEmployerAddress, OneOfPersonalInformationResidentialAddress {
  /**
   * Format of address values
   */
  @JsonAdapter(AddressFormatEnum.Adapter.class)
  public enum AddressFormatEnum {
    @SerializedName("PSGC")
    PSGC("PSGC");

    private String value;

    AddressFormatEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static AddressFormatEnum fromValue(String input) {
      for (AddressFormatEnum b : AddressFormatEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<AddressFormatEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final AddressFormatEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public AddressFormatEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return AddressFormatEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("addressFormat")
  private AddressFormatEnum addressFormat = null;

  @SerializedName("cityMunicipality")
  private String cityMunicipality = null;

  @SerializedName("barangay")
  private String barangay = null;

  @SerializedName("streetAddress")
  private String streetAddress = null;

  @SerializedName("buildingUnitNumber")
  private String buildingUnitNumber = null;

  @SerializedName("country")
  private String country = null;

  @SerializedName("postalCode")
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
  public AddressFormatEnum getAddressFormat() {
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
  public String getCityMunicipality() {
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
  public String getBarangay() {
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
   * Get streetAddress
   * @return streetAddress
  **/
  @Schema(required = true, description = "")
  public String getStreetAddress() {
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
   * Get buildingUnitNumber
   * @return buildingUnitNumber
  **/
  @Schema(description = "")
  public String getBuildingUnitNumber() {
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
   * Get country
   * @return country
  **/
  @Schema(required = true, description = "")
  public String getCountry() {
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
   * Get postalCode
   * @return postalCode
  **/
  @Schema(required = true, description = "")
  public String getPostalCode() {
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
