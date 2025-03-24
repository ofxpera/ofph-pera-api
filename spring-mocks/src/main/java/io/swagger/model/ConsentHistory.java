package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.ConsentHistoryEvents;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * ConsentHistory
 */
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class ConsentHistory   {
  @JsonProperty("id")

  private String id = null;

  @JsonProperty("events")
  @Valid
  private List<ConsentHistoryEvents> events = new ArrayList<ConsentHistoryEvents>();

  public ConsentHistory id(String id) { 

    this.id = id;
    return this;
  }

  /**
   * The ID of the consent arrangement
   * @return id
   **/
  
  @Schema(required = true, description = "The ID of the consent arrangement")
  
  @NotNull
  public String getId() {  
    return id;
  }



  public void setId(String id) { 

    this.id = id;
  }

  public ConsentHistory events(List<ConsentHistoryEvents> events) { 

    this.events = events;
    return this;
  }

  public ConsentHistory addEventsItem(ConsentHistoryEvents eventsItem) {
    this.events.add(eventsItem);
    return this;
  }

  /**
   * Get events
   * @return events
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
  public List<ConsentHistoryEvents> getEvents() {  
    return events;
  }



  public void setEvents(List<ConsentHistoryEvents> events) { 

    this.events = events;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentHistory consentHistory = (ConsentHistory) o;
    return Objects.equals(this.id, consentHistory.id) &&
        Objects.equals(this.events, consentHistory.events);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, events);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentHistory {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
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
