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
 * PersonalInformation
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class PersonalInformation   {
  @JsonProperty("sub")

  private String sub = null;

  @JsonProperty("title")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String title = null;

  @JsonProperty("givenName")

  private String givenName = null;

  @JsonProperty("middleName")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String middleName = null;

  @JsonProperty("lastName")

  private String lastName = null;

  @JsonProperty("suffix")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String suffix = null;

  @JsonProperty("phoneNumber")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String phoneNumber = null;

  @JsonProperty("mobileNumber")

  private String mobileNumber = null;

  @JsonProperty("email")

  private String email = null;

  @JsonProperty("birthdate")

  private LocalDate birthdate = null;

  @JsonProperty("nationality")

  private String nationality = null;

  @JsonProperty("tin")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String tin = null;


  public PersonalInformation sub(String sub) { 

    this.sub = sub;
    return this;
  }

  /**
   * Subject – FI's unique identifier for the End-User
   * @return sub
   **/
  
  @Schema(required = true, description = "Subject – FI's unique identifier for the End-User")
  
  @NotNull
@Size(max=50)   public String getSub() {  
    return sub;
  }



  public void setSub(String sub) { 

    this.sub = sub;
  }

  public PersonalInformation title(String title) { 

    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   **/
  
  @Schema(description = "")
  
@Size(max=50)   public String getTitle() {  
    return title;
  }



  public void setTitle(String title) { 
    this.title = title;
  }

  public PersonalInformation givenName(String givenName) { 

    this.givenName = givenName;
    return this;
  }

  /**
   * Get givenName
   * @return givenName
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
@Size(max=50)   public String getGivenName() {  
    return givenName;
  }



  public void setGivenName(String givenName) { 

    this.givenName = givenName;
  }

  public PersonalInformation middleName(String middleName) { 

    this.middleName = middleName;
    return this;
  }

  /**
   * Get middleName
   * @return middleName
   **/
  
  @Schema(description = "")
  
@Size(max=50)   public String getMiddleName() {  
    return middleName;
  }



  public void setMiddleName(String middleName) { 
    this.middleName = middleName;
  }

  public PersonalInformation lastName(String lastName) { 

    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
@Size(max=50)   public String getLastName() {  
    return lastName;
  }



  public void setLastName(String lastName) { 

    this.lastName = lastName;
  }

  public PersonalInformation suffix(String suffix) { 

    this.suffix = suffix;
    return this;
  }

  /**
   * Get suffix
   * @return suffix
   **/
  
  @Schema(description = "")
  
@Size(max=10)   public String getSuffix() {  
    return suffix;
  }



  public void setSuffix(String suffix) { 
    this.suffix = suffix;
  }

  public PersonalInformation phoneNumber(String phoneNumber) { 

    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Get phoneNumber
   * @return phoneNumber
   **/
  
  @Schema(example = "63287654321", description = "")
  
@Pattern(regexp="^[0-9]{11}$") @Size(max=15)   public String getPhoneNumber() {  
    return phoneNumber;
  }



  public void setPhoneNumber(String phoneNumber) { 
    this.phoneNumber = phoneNumber;
  }

  public PersonalInformation mobileNumber(String mobileNumber) { 

    this.mobileNumber = mobileNumber;
    return this;
  }

  /**
   * Get mobileNumber
   * @return mobileNumber
   **/
  
  @Schema(example = "639171234567", required = true, description = "")
  
  @NotNull
@Pattern(regexp="^[0-9]{12}$") @Size(max=15)   public String getMobileNumber() {  
    return mobileNumber;
  }



  public void setMobileNumber(String mobileNumber) { 

    this.mobileNumber = mobileNumber;
  }

  public PersonalInformation email(String email) { 

    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public String getEmail() {  
    return email;
  }



  public void setEmail(String email) { 

    this.email = email;
  }

  public PersonalInformation birthdate(LocalDate birthdate) { 

    this.birthdate = birthdate;
    return this;
  }

  /**
   * Format YYYY-MM-DD
   * @return birthdate
   **/
  
  @Schema(required = true, description = "Format YYYY-MM-DD")
  
@Valid
  @NotNull
  public LocalDate getBirthdate() {  
    return birthdate;
  }



  public void setBirthdate(LocalDate birthdate) { 

    this.birthdate = birthdate;
  }

  public PersonalInformation nationality(String nationality) { 

    this.nationality = nationality;
    return this;
  }

  /**
   * ISO 3166 Code
   * @return nationality
   **/
  
  @Schema(required = true, description = "ISO 3166 Code")
  
  @NotNull
@Size(max=3)   public String getNationality() {  
    return nationality;
  }



  public void setNationality(String nationality) { 

    this.nationality = nationality;
  }

  public PersonalInformation tin(String tin) { 

    this.tin = tin;
    return this;
  }

  /**
   * Format NNN-NNN-NNN-000
   * @return tin
   **/
  
  @Schema(description = "Format NNN-NNN-NNN-000")
  
@Pattern(regexp="^[0-9]{3}-[0-9]{3}-[0-9]{3}-[0-9]{3}$") @Size(max=15)   public String getTin() {  
    return tin;
  }



  public void setTin(String tin) { 
    this.tin = tin;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonalInformation personalInformation = (PersonalInformation) o;
    return Objects.equals(this.sub, personalInformation.sub) &&
        Objects.equals(this.title, personalInformation.title) &&
        Objects.equals(this.givenName, personalInformation.givenName) &&
        Objects.equals(this.middleName, personalInformation.middleName) &&
        Objects.equals(this.lastName, personalInformation.lastName) &&
        Objects.equals(this.suffix, personalInformation.suffix) &&
        Objects.equals(this.phoneNumber, personalInformation.phoneNumber) &&
        Objects.equals(this.mobileNumber, personalInformation.mobileNumber) &&
        Objects.equals(this.email, personalInformation.email) &&
        Objects.equals(this.birthdate, personalInformation.birthdate) &&
        Objects.equals(this.nationality, personalInformation.nationality) &&
        Objects.equals(this.tin, personalInformation.tin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sub, title, givenName, middleName, lastName, suffix, phoneNumber, mobileNumber, email, birthdate, nationality, tin);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonalInformation {\n");
    
    sb.append("    sub: ").append(toIndentedString(sub)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    suffix: ").append(toIndentedString(suffix)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
    sb.append("    tin: ").append(toIndentedString(tin)).append("\n");
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
