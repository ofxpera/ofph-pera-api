package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.Address;
import io.swagger.model.JWKSet;
import io.swagger.model.ParticipantContact;
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
 * Participant
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class Participant   {
  @JsonProperty("participant_id")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String participantId = null;

  @JsonProperty("participant_name")

  private String participantName = null;

  /**
   * Gets or Sets participantType
   */
  public enum ParticipantTypeEnum {
    OAUTH_CLIENT("oauth_client"),
    
    AUTH_SERVER("auth_server");

    private String value;

    ParticipantTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ParticipantTypeEnum fromValue(String text) {
      for (ParticipantTypeEnum b : ParticipantTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("participant_type")
  @Valid
  private List<ParticipantTypeEnum> participantType = new ArrayList<ParticipantTypeEnum>();
  @JsonProperty("participant_description")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String participantDescription = null;

  @JsonProperty("participant_logo_uri")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String participantLogoUri = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    ACTIVE("active"),
    
    INACTIVE("inactive"),
    
    SUSPENDED("suspended");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private StatusEnum status = StatusEnum.ACTIVE;

  @JsonProperty("jwks")

  private JWKSet jwks = null;

  @JsonProperty("contact")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private ParticipantContact contact = null;

  @JsonProperty("address")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Address address = null;


  public Participant participantId(String participantId) { 

    this.participantId = participantId;
    return this;
  }

  /**
   * Unique identifier for the participant
   * @return participantId
   **/
  
  @Schema(description = "Unique identifier for the participant")
  
  public String getParticipantId() {  
    return participantId;
  }



  public void setParticipantId(String participantId) { 
    this.participantId = participantId;
  }

  public Participant participantName(String participantName) { 

    this.participantName = participantName;
    return this;
  }

  /**
   * Trading name of the participant
   * @return participantName
   **/
  
  @Schema(required = true, description = "Trading name of the participant")
  
  @NotNull
  public String getParticipantName() {  
    return participantName;
  }



  public void setParticipantName(String participantName) { 

    this.participantName = participantName;
  }

  public Participant participantType(List<ParticipantTypeEnum> participantType) { 

    this.participantType = participantType;
    return this;
  }

  public Participant addParticipantTypeItem(ParticipantTypeEnum participantTypeItem) {
    this.participantType.add(participantTypeItem);
    return this;
  }

  /**
   * Types of roles this participant can perform
   * @return participantType
   **/
  
  @Schema(required = true, description = "Types of roles this participant can perform")
  
  @NotNull
@Size(min=1)   public List<ParticipantTypeEnum> getParticipantType() {  
    return participantType;
  }



  public void setParticipantType(List<ParticipantTypeEnum> participantType) { 

    this.participantType = participantType;
  }

  public Participant participantDescription(String participantDescription) { 

    this.participantDescription = participantDescription;
    return this;
  }

  /**
   * Short Description of the participant (Required for PERA Admin)
   * @return participantDescription
   **/
  
  @Schema(description = "Short Description of the participant (Required for PERA Admin)")
  
  public String getParticipantDescription() {  
    return participantDescription;
  }



  public void setParticipantDescription(String participantDescription) { 
    this.participantDescription = participantDescription;
  }

  public Participant participantLogoUri(String participantLogoUri) { 

    this.participantLogoUri = participantLogoUri;
    return this;
  }

  /**
   * logo uri of the participant
   * @return participantLogoUri
   **/
  
  @Schema(description = "logo uri of the participant")
  
  public String getParticipantLogoUri() {  
    return participantLogoUri;
  }



  public void setParticipantLogoUri(String participantLogoUri) { 
    this.participantLogoUri = participantLogoUri;
  }

  public Participant status(StatusEnum status) { 

    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  
  @Schema(description = "")
  
  public StatusEnum getStatus() {  
    return status;
  }



  public void setStatus(StatusEnum status) { 
    this.status = status;
  }

  public Participant jwks(JWKSet jwks) { 

    this.jwks = jwks;
    return this;
  }

  /**
   * Get jwks
   * @return jwks
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
  public JWKSet getJwks() {  
    return jwks;
  }



  public void setJwks(JWKSet jwks) { 

    this.jwks = jwks;
  }

  public Participant contact(ParticipantContact contact) { 

    this.contact = contact;
    return this;
  }

  /**
   * Get contact
   * @return contact
   **/
  
  @Schema(description = "")
  
@Valid
  public ParticipantContact getContact() {  
    return contact;
  }



  public void setContact(ParticipantContact contact) { 
    this.contact = contact;
  }

  public Participant address(Address address) { 

    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
   **/
  
  @Schema(description = "")
  
@Valid
  public Address getAddress() {  
    return address;
  }



  public void setAddress(Address address) { 
    this.address = address;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Participant participant = (Participant) o;
    return Objects.equals(this.participantId, participant.participantId) &&
        Objects.equals(this.participantName, participant.participantName) &&
        Objects.equals(this.participantType, participant.participantType) &&
        Objects.equals(this.participantDescription, participant.participantDescription) &&
        Objects.equals(this.participantLogoUri, participant.participantLogoUri) &&
        Objects.equals(this.status, participant.status) &&
        Objects.equals(this.jwks, participant.jwks) &&
        Objects.equals(this.contact, participant.contact) &&
        Objects.equals(this.address, participant.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(participantId, participantName, participantType, participantDescription, participantLogoUri, status, jwks, contact, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Participant {\n");
    
    sb.append("    participantId: ").append(toIndentedString(participantId)).append("\n");
    sb.append("    participantName: ").append(toIndentedString(participantName)).append("\n");
    sb.append("    participantType: ").append(toIndentedString(participantType)).append("\n");
    sb.append("    participantDescription: ").append(toIndentedString(participantDescription)).append("\n");
    sb.append("    participantLogoUri: ").append(toIndentedString(participantLogoUri)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    jwks: ").append(toIndentedString(jwks)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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
