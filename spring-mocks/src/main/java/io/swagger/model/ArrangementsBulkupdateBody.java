package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.ConsentcustomerscustomerIdarrangementsbulkupdateUpdates;
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
 * ArrangementsBulkupdateBody
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class ArrangementsBulkupdateBody   {
  @JsonProperty("updates")
  @Valid
  private List<ConsentcustomerscustomerIdarrangementsbulkupdateUpdates> updates = new ArrayList<ConsentcustomerscustomerIdarrangementsbulkupdateUpdates>();

  public ArrangementsBulkupdateBody updates(List<ConsentcustomerscustomerIdarrangementsbulkupdateUpdates> updates) { 

    this.updates = updates;
    return this;
  }

  public ArrangementsBulkupdateBody addUpdatesItem(ConsentcustomerscustomerIdarrangementsbulkupdateUpdates updatesItem) {
    this.updates.add(updatesItem);
    return this;
  }

  /**
   * Get updates
   * @return updates
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
@Size(min=1,max=50)   public List<ConsentcustomerscustomerIdarrangementsbulkupdateUpdates> getUpdates() {  
    return updates;
  }



  public void setUpdates(List<ConsentcustomerscustomerIdarrangementsbulkupdateUpdates> updates) { 

    this.updates = updates;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArrangementsBulkupdateBody arrangementsBulkupdateBody = (ArrangementsBulkupdateBody) o;
    return Objects.equals(this.updates, arrangementsBulkupdateBody.updates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(updates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArrangementsBulkupdateBody {\n");
    
    sb.append("    updates: ").append(toIndentedString(updates)).append("\n");
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
