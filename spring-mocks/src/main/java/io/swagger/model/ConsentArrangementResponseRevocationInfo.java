package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Information about consent revocation if applicable
 */
@Schema(description = "Information about consent revocation if applicable")
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class ConsentArrangementResponseRevocationInfo   {
  @JsonProperty("revoked_at")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private OffsetDateTime revokedAt = null;

  @JsonProperty("reason")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String reason = null;


  public ConsentArrangementResponseRevocationInfo revokedAt(OffsetDateTime revokedAt) { 

    this.revokedAt = revokedAt;
    return this;
  }

  /**
   * Get revokedAt
   * @return revokedAt
   **/
  
  @Schema(description = "")
  
@Valid
  public OffsetDateTime getRevokedAt() {  
    return revokedAt;
  }



  public void setRevokedAt(OffsetDateTime revokedAt) { 
    this.revokedAt = revokedAt;
  }

  public ConsentArrangementResponseRevocationInfo reason(String reason) { 

    this.reason = reason;
    return this;
  }

  /**
   * Get reason
   * @return reason
   **/
  
  @Schema(description = "")
  
  public String getReason() {  
    return reason;
  }



  public void setReason(String reason) { 
    this.reason = reason;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentArrangementResponseRevocationInfo consentArrangementResponseRevocationInfo = (ConsentArrangementResponseRevocationInfo) o;
    return Objects.equals(this.revokedAt, consentArrangementResponseRevocationInfo.revokedAt) &&
        Objects.equals(this.reason, consentArrangementResponseRevocationInfo.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(revokedAt, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentArrangementResponseRevocationInfo {\n");
    
    sb.append("    revokedAt: ").append(toIndentedString(revokedAt)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
