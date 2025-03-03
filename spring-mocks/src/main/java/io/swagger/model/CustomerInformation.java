package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.CustomerDueDiligence;
import io.swagger.model.IdType;
import io.swagger.model.PersonalInformation;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CustomerInformation
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class CustomerInformation   {
  @JsonProperty("sub")

  private String sub = null;

  @JsonProperty("arrangementId")

  private String arrangementId = null;

  @JsonProperty("personalInformation")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private PersonalInformation personalInformation = null;

  @JsonProperty("presentedIds")
  @Valid
  private List<IdType> presentedIds = new ArrayList<IdType>();
  @JsonProperty("cdd")

  private CustomerDueDiligence cdd = null;

  @JsonProperty("peraAdmin")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String peraAdmin = null;


  public CustomerInformation sub(String sub) { 

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

  public CustomerInformation arrangementId(String arrangementId) { 

    this.arrangementId = arrangementId;
    return this;
  }

  /**
   * The unique identifier for the Consent Arrangement
   * @return arrangementId
   **/
  
  @Schema(required = true, description = "The unique identifier for the Consent Arrangement")
  
  @NotNull
  public String getArrangementId() {  
    return arrangementId;
  }



  public void setArrangementId(String arrangementId) { 

    this.arrangementId = arrangementId;
  }

  public CustomerInformation personalInformation(PersonalInformation personalInformation) { 

    this.personalInformation = personalInformation;
    return this;
  }

  /**
   * Get personalInformation
   * @return personalInformation
   **/
  
  @Schema(description = "")
  
@Valid
  public PersonalInformation getPersonalInformation() {  
    return personalInformation;
  }



  public void setPersonalInformation(PersonalInformation personalInformation) { 
    this.personalInformation = personalInformation;
  }

  public CustomerInformation presentedIds(List<IdType> presentedIds) { 

    this.presentedIds = presentedIds;
    return this;
  }

  public CustomerInformation addPresentedIdsItem(IdType presentedIdsItem) {
    this.presentedIds.add(presentedIdsItem);
    return this;
  }

  /**
   * Array of identification details
   * @return presentedIds
   **/
  
  @Schema(required = true, description = "Array of identification details")
  
@Valid
  @NotNull
  public List<IdType> getPresentedIds() {  
    return presentedIds;
  }



  public void setPresentedIds(List<IdType> presentedIds) { 

    this.presentedIds = presentedIds;
  }

  public CustomerInformation cdd(CustomerDueDiligence cdd) { 

    this.cdd = cdd;
    return this;
  }

  /**
   * Get cdd
   * @return cdd
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
  public CustomerDueDiligence getCdd() {  
    return cdd;
  }



  public void setCdd(CustomerDueDiligence cdd) { 

    this.cdd = cdd;
  }

  public CustomerInformation peraAdmin(String peraAdmin) { 

    this.peraAdmin = peraAdmin;
    return this;
  }

  /**
   * The PERA Admin selected by the Customer
   * @return peraAdmin
   **/
  
  @Schema(description = "The PERA Admin selected by the Customer")
  
@Size(max=50)   public String getPeraAdmin() {  
    return peraAdmin;
  }



  public void setPeraAdmin(String peraAdmin) { 
    this.peraAdmin = peraAdmin;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerInformation customerInformation = (CustomerInformation) o;
    return Objects.equals(this.sub, customerInformation.sub) &&
        Objects.equals(this.arrangementId, customerInformation.arrangementId) &&
        Objects.equals(this.personalInformation, customerInformation.personalInformation) &&
        Objects.equals(this.presentedIds, customerInformation.presentedIds) &&
        Objects.equals(this.cdd, customerInformation.cdd) &&
        Objects.equals(this.peraAdmin, customerInformation.peraAdmin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sub, arrangementId, personalInformation, presentedIds, cdd, peraAdmin);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerInformation {\n");
    
    sb.append("    sub: ").append(toIndentedString(sub)).append("\n");
    sb.append("    arrangementId: ").append(toIndentedString(arrangementId)).append("\n");
    sb.append("    personalInformation: ").append(toIndentedString(personalInformation)).append("\n");
    sb.append("    presentedIds: ").append(toIndentedString(presentedIds)).append("\n");
    sb.append("    cdd: ").append(toIndentedString(cdd)).append("\n");
    sb.append("    peraAdmin: ").append(toIndentedString(peraAdmin)).append("\n");
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
