/*
 * OFxPERA API
 * Philippines Open Finance API Implementation for PERA
 *
 * OpenAPI spec version: 0.0.7
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * OAuthError
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2025-03-24T23:06:51.563824754Z[GMT]")

public class OAuthError {
  /**
   * Error code as defined in RFC 6749
   */
  @JsonAdapter(ErrorEnum.Adapter.class)
  public enum ErrorEnum {
    @SerializedName("invalid_request")
    INVALID_REQUEST("invalid_request"),
    @SerializedName("invalid_client")
    INVALID_CLIENT("invalid_client"),
    @SerializedName("invalid_grant")
    INVALID_GRANT("invalid_grant"),
    @SerializedName("unauthorized_client")
    UNAUTHORIZED_CLIENT("unauthorized_client"),
    @SerializedName("unsupported_grant_type")
    UNSUPPORTED_GRANT_TYPE("unsupported_grant_type"),
    @SerializedName("invalid_scope")
    INVALID_SCOPE("invalid_scope");

    private String value;

    ErrorEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static ErrorEnum fromValue(String input) {
      for (ErrorEnum b : ErrorEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<ErrorEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ErrorEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public ErrorEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return ErrorEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("error")
  private ErrorEnum error = null;

  @SerializedName("error_description")
  private String errorDescription = null;

  @SerializedName("error_uri")
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
