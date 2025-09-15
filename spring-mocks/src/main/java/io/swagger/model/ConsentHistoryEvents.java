package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * ConsentHistoryEvents
 */
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class ConsentHistoryEvents   {
  /**
   * Gets or Sets eventType
   */
  public enum EventTypeEnum {
    CREATED("created"),
    
    UPDATED("updated"),
    
    SUSPENDED("suspended"),
    
    RESUMED("resumed"),
    
    REVOKED("revoked"),
    
    EXPIRED("expired"),
    
    EXTENDED("extended");

    private String value;

    EventTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EventTypeEnum fromValue(String text) {
      for (EventTypeEnum b : EventTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("event_type")

  private EventTypeEnum eventType = null;

  @JsonProperty("timestamp")

  private OffsetDateTime timestamp = null;

  @JsonProperty("actor")

  private String actor = null;

  @JsonProperty("details")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Object details = null;

  @JsonProperty("previous_state")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Object previousState = null;

  @JsonProperty("new_state")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Object newState = null;


  public ConsentHistoryEvents eventType(EventTypeEnum eventType) { 

    this.eventType = eventType;
    return this;
  }

  /**
   * Get eventType
   * @return eventType
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public EventTypeEnum getEventType() {  
    return eventType;
  }



  public void setEventType(EventTypeEnum eventType) { 

    this.eventType = eventType;
  }

  public ConsentHistoryEvents timestamp(OffsetDateTime timestamp) { 

    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
  public OffsetDateTime getTimestamp() {  
    return timestamp;
  }



  public void setTimestamp(OffsetDateTime timestamp) { 

    this.timestamp = timestamp;
  }

  public ConsentHistoryEvents actor(String actor) { 

    this.actor = actor;
    return this;
  }

  /**
   * The entity that performed the action (e.g., user_id, system)
   * @return actor
   **/
  
  @Schema(required = true, description = "The entity that performed the action (e.g., user_id, system)")
  
  @NotNull
  public String getActor() {  
    return actor;
  }



  public void setActor(String actor) { 

    this.actor = actor;
  }

  public ConsentHistoryEvents details(Object details) { 

    this.details = details;
    return this;
  }

  /**
   * Additional event-specific details
   * @return details
   **/
  
  @Schema(description = "Additional event-specific details")
  
  public Object getDetails() {  
    return details;
  }



  public void setDetails(Object details) { 
    this.details = details;
  }

  public ConsentHistoryEvents previousState(Object previousState) { 

    this.previousState = previousState;
    return this;
  }

  /**
   * State before the change
   * @return previousState
   **/
  
  @Schema(description = "State before the change")
  
  public Object getPreviousState() {  
    return previousState;
  }



  public void setPreviousState(Object previousState) { 
    this.previousState = previousState;
  }

  public ConsentHistoryEvents newState(Object newState) { 

    this.newState = newState;
    return this;
  }

  /**
   * State after the change
   * @return newState
   **/
  
  @Schema(description = "State after the change")
  
  public Object getNewState() {  
    return newState;
  }



  public void setNewState(Object newState) { 
    this.newState = newState;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentHistoryEvents consentHistoryEvents = (ConsentHistoryEvents) o;
    return Objects.equals(this.eventType, consentHistoryEvents.eventType) &&
        Objects.equals(this.timestamp, consentHistoryEvents.timestamp) &&
        Objects.equals(this.actor, consentHistoryEvents.actor) &&
        Objects.equals(this.details, consentHistoryEvents.details) &&
        Objects.equals(this.previousState, consentHistoryEvents.previousState) &&
        Objects.equals(this.newState, consentHistoryEvents.newState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventType, timestamp, actor, details, previousState, newState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentHistoryEvents {\n");
    
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    actor: ").append(toIndentedString(actor)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    previousState: ").append(toIndentedString(previousState)).append("\n");
    sb.append("    newState: ").append(toIndentedString(newState)).append("\n");
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
