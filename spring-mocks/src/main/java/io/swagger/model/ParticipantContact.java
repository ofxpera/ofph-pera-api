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
 * ParticipantContact
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class ParticipantContact   {
  @JsonProperty("phone")

  private String phone = null;

  @JsonProperty("email")

  private String email = null;


  public ParticipantContact phone(String phone) { 

    this.phone = phone;
    return this;
  }

  /**
   * Contact phone number
   * @return phone
   **/
  
  @Schema(required = true, description = "Contact phone number")
  
  @NotNull
  public String getPhone() {  
    return phone;
  }



  public void setPhone(String phone) { 

    this.phone = phone;
  }

  public ParticipantContact email(String email) { 

    this.email = email;
    return this;
  }

  /**
   * Contact email address
   * @return email
   **/
  
  @Schema(required = true, description = "Contact email address")
  
  @NotNull
  public String getEmail() {  
    return email;
  }



  public void setEmail(String email) { 

    this.email = email;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParticipantContact participantContact = (ParticipantContact) o;
    return Objects.equals(this.phone, participantContact.phone) &&
        Objects.equals(this.email, participantContact.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phone, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParticipantContact {\n");
    
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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
