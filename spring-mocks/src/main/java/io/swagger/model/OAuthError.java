package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
 * OAuthError
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:06:40.598571645Z[GMT]")


public class OAuthError   {
  /**
   * Error code as defined in RFC 6749
   */
  public enum ErrorEnum {
    INVALID_REQUEST("invalid_request"),
    
    INVALID_CLIENT("invalid_client"),
    
    INVALID_GRANT("invalid_grant"),
    
    UNAUTHORIZED_CLIENT("unauthorized_client"),
    
    UNSUPPORTED_GRANT_TYPE("unsupported_grant_type"),
    
    INVALID_SCOPE("invalid_scope");

    private String value;

    ErrorEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ErrorEnum fromValue(String text) {
      for (ErrorEnum b : ErrorEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("error")

  private ErrorEnum error = null;

  @JsonProperty("error_description")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String errorDescription = null;

  @JsonProperty("error_uri")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String errorUri = null;


  public OAuthError error(ErrorEnum error) { 

    this.error = error;
    return this;
  }

  /**
   * Error code as defined in RFC 6749
   * @return error
   **/
  
  @Schema(required = true, description = "Error code as defined in RFC 6749")
  
  @NotNull
  public ErrorEnum getError() {  
    return error;
  }



  public void setError(ErrorEnum error) { 

    this.error = error;
  }

  public OAuthError errorDescription(String errorDescription) { 

    this.errorDescription = errorDescription;
    return this;
  }

  /**
   * Human-readable error description
   * @return errorDescription
   **/
  
  @Schema(description = "Human-readable error description")
  
  public String getErrorDescription() {  
    return errorDescription;
  }



  public void setErrorDescription(String errorDescription) { 
    this.errorDescription = errorDescription;
  }

  public OAuthError errorUri(String errorUri) { 

    this.errorUri = errorUri;
    return this;
  }

  /**
   * URI to error documentation
   * @return errorUri
   **/
  
  @Schema(description = "URI to error documentation")
  
  public String getErrorUri() {  
    return errorUri;
  }



  public void setErrorUri(String errorUri) { 
    this.errorUri = errorUri;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OAuthError oauthError = (OAuthError) o;
    return Objects.equals(this.error, oauthError.error) &&
        Objects.equals(this.errorDescription, oauthError.errorDescription) &&
        Objects.equals(this.errorUri, oauthError.errorUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, errorDescription, errorUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OAuthError {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    errorDescription: ").append(toIndentedString(errorDescription)).append("\n");
    sb.append("    errorUri: ").append(toIndentedString(errorUri)).append("\n");
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
