package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * Address
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class Address   {
  @JsonProperty("region")

  private String region = null;

  @JsonProperty("province")

  private String province = null;

  @JsonProperty("city")

  private String city = null;

  @JsonProperty("barangay")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String barangay = null;

  @JsonProperty("street_address")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String streetAddress = null;

  @JsonProperty("country")

  private String country = null;

  @JsonProperty("postal_code")

  private String postalCode = null;


  public Address region(String region) { 

    this.region = region;
    return this;
  }

  /**
   * PSGC Code for Region
   * @return region
   **/
  
  @Schema(required = true, description = "PSGC Code for Region")
  
  @NotNull
@Size(max=10)   public String getRegion() {  
    return region;
  }



  public void setRegion(String region) { 

    this.region = region;
  }

  public Address province(String province) { 

    this.province = province;
    return this;
  }

  /**
   * PSGC Code for Province
   * @return province
   **/
  
  @Schema(required = true, description = "PSGC Code for Province")
  
  @NotNull
@Size(max=10)   public String getProvince() {  
    return province;
  }



  public void setProvince(String province) { 

    this.province = province;
  }

  public Address city(String city) { 

    this.city = city;
    return this;
  }

  /**
   * PSGC Code for City
   * @return city
   **/
  
  @Schema(required = true, description = "PSGC Code for City")
  
  @NotNull
@Size(max=10)   public String getCity() {  
    return city;
  }



  public void setCity(String city) { 

    this.city = city;
  }

  public Address barangay(String barangay) { 

    this.barangay = barangay;
    return this;
  }

  /**
   * PSGC Code for Barangay
   * @return barangay
   **/
  
  @Schema(description = "PSGC Code for Barangay")
  
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
   * Get streetAddress
   * @return streetAddress
   **/
  
  @Schema(description = "")
  
@Size(max=200)   public String getStreetAddress() {  
    return streetAddress;
  }



  public void setStreetAddress(String streetAddress) { 
    this.streetAddress = streetAddress;
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
  
  @Schema(required = true, description = "Postal Code")
  
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
    return Objects.equals(this.region, address.region) &&
        Objects.equals(this.province, address.province) &&
        Objects.equals(this.city, address.city) &&
        Objects.equals(this.barangay, address.barangay) &&
        Objects.equals(this.streetAddress, address.streetAddress) &&
        Objects.equals(this.country, address.country) &&
        Objects.equals(this.postalCode, address.postalCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(region, province, city, barangay, streetAddress, country, postalCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    province: ").append(toIndentedString(province)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    barangay: ").append(toIndentedString(barangay)).append("\n");
    sb.append("    streetAddress: ").append(toIndentedString(streetAddress)).append("\n");
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
