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
 * InlineResponse2003
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class InlineResponse2003   {
  @JsonProperty("sub")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String sub = null;

  @JsonProperty("name")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String name = null;

  @JsonProperty("given_name")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String givenName = null;

  @JsonProperty("family_name")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String familyName = null;

  @JsonProperty("email")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String email = null;

  @JsonProperty("email_verified")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Boolean emailVerified = null;

  @JsonProperty("phone_number")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String phoneNumber = null;

  @JsonProperty("phone_number_verified")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Boolean phoneNumberVerified = null;


  public InlineResponse2003 sub(String sub) { 

    this.sub = sub;
    return this;
  }

  /**
   * Unique identifier for the user from the authentication provider's perspective.
   * @return sub
   **/
  
  @Schema(description = "Unique identifier for the user from the authentication provider's perspective.")
  
  public String getSub() {  
    return sub;
  }



  public void setSub(String sub) { 
    this.sub = sub;
  }

  public InlineResponse2003 name(String name) { 

    this.name = name;
    return this;
  }

  /**
   * Full name of the user.
   * @return name
   **/
  
  @Schema(description = "Full name of the user.")
  
  public String getName() {  
    return name;
  }



  public void setName(String name) { 
    this.name = name;
  }

  public InlineResponse2003 givenName(String givenName) { 

    this.givenName = givenName;
    return this;
  }

  /**
   * Given name of the user.
   * @return givenName
   **/
  
  @Schema(description = "Given name of the user.")
  
  public String getGivenName() {  
    return givenName;
  }



  public void setGivenName(String givenName) { 
    this.givenName = givenName;
  }

  public InlineResponse2003 familyName(String familyName) { 

    this.familyName = familyName;
    return this;
  }

  /**
   * Family name of the user.
   * @return familyName
   **/
  
  @Schema(description = "Family name of the user.")
  
  public String getFamilyName() {  
    return familyName;
  }



  public void setFamilyName(String familyName) { 
    this.familyName = familyName;
  }

  public InlineResponse2003 email(String email) { 

    this.email = email;
    return this;
  }

  /**
   * Email address of the user.
   * @return email
   **/
  
  @Schema(description = "Email address of the user.")
  
  public String getEmail() {  
    return email;
  }



  public void setEmail(String email) { 
    this.email = email;
  }

  public InlineResponse2003 emailVerified(Boolean emailVerified) { 

    this.emailVerified = emailVerified;
    return this;
  }

  /**
   * Indicates whether the user's email address has been verified.
   * @return emailVerified
   **/
  
  @Schema(description = "Indicates whether the user's email address has been verified.")
  
  public Boolean isEmailVerified() {  
    return emailVerified;
  }



  public void setEmailVerified(Boolean emailVerified) { 
    this.emailVerified = emailVerified;
  }

  public InlineResponse2003 phoneNumber(String phoneNumber) { 

    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Phone number of the user.
   * @return phoneNumber
   **/
  
  @Schema(description = "Phone number of the user.")
  
  public String getPhoneNumber() {  
    return phoneNumber;
  }



  public void setPhoneNumber(String phoneNumber) { 
    this.phoneNumber = phoneNumber;
  }

  public InlineResponse2003 phoneNumberVerified(Boolean phoneNumberVerified) { 

    this.phoneNumberVerified = phoneNumberVerified;
    return this;
  }

  /**
   * Indicates whether the user's phone number has been verified.
   * @return phoneNumberVerified
   **/
  
  @Schema(description = "Indicates whether the user's phone number has been verified.")
  
  public Boolean isPhoneNumberVerified() {  
    return phoneNumberVerified;
  }



  public void setPhoneNumberVerified(Boolean phoneNumberVerified) { 
    this.phoneNumberVerified = phoneNumberVerified;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2003 inlineResponse2003 = (InlineResponse2003) o;
    return Objects.equals(this.sub, inlineResponse2003.sub) &&
        Objects.equals(this.name, inlineResponse2003.name) &&
        Objects.equals(this.givenName, inlineResponse2003.givenName) &&
        Objects.equals(this.familyName, inlineResponse2003.familyName) &&
        Objects.equals(this.email, inlineResponse2003.email) &&
        Objects.equals(this.emailVerified, inlineResponse2003.emailVerified) &&
        Objects.equals(this.phoneNumber, inlineResponse2003.phoneNumber) &&
        Objects.equals(this.phoneNumberVerified, inlineResponse2003.phoneNumberVerified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sub, name, givenName, familyName, email, emailVerified, phoneNumber, phoneNumberVerified);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2003 {\n");
    
    sb.append("    sub: ").append(toIndentedString(sub)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
    sb.append("    familyName: ").append(toIndentedString(familyName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    emailVerified: ").append(toIndentedString(emailVerified)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    phoneNumberVerified: ").append(toIndentedString(phoneNumberVerified)).append("\n");
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
