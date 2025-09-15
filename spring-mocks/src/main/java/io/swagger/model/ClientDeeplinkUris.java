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
 * ClientDeeplinkUris
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-09-07T08:58:01.056844973Z[GMT]")


public class ClientDeeplinkUris   {
  @JsonProperty("mobileDeeplinkUri")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String mobileDeeplinkUri = null;

  @JsonProperty("webDeeplinkUri")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String webDeeplinkUri = null;


  public ClientDeeplinkUris mobileDeeplinkUri(String mobileDeeplinkUri) { 

    this.mobileDeeplinkUri = mobileDeeplinkUri;
    return this;
  }

  /**
   * redirects customer to a specific PERA Admin Mobile application.
   * @return mobileDeeplinkUri
   **/
  
  @Schema(example = "test", description = "redirects customer to a specific PERA Admin Mobile application.")
  
  public String getMobileDeeplinkUri() {  
    return mobileDeeplinkUri;
  }



  public void setMobileDeeplinkUri(String mobileDeeplinkUri) { 
    this.mobileDeeplinkUri = mobileDeeplinkUri;
  }

  public ClientDeeplinkUris webDeeplinkUri(String webDeeplinkUri) { 

    this.webDeeplinkUri = webDeeplinkUri;
    return this;
  }

  /**
   * redirects customer to a specific PERA Admin Web application.
   * @return webDeeplinkUri
   **/
  
  @Schema(example = "test", description = "redirects customer to a specific PERA Admin Web application.")
  
  public String getWebDeeplinkUri() {  
    return webDeeplinkUri;
  }



  public void setWebDeeplinkUri(String webDeeplinkUri) { 
    this.webDeeplinkUri = webDeeplinkUri;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientDeeplinkUris clientDeeplinkUris = (ClientDeeplinkUris) o;
    return Objects.equals(this.mobileDeeplinkUri, clientDeeplinkUris.mobileDeeplinkUri) &&
        Objects.equals(this.webDeeplinkUri, clientDeeplinkUris.webDeeplinkUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mobileDeeplinkUri, webDeeplinkUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientDeeplinkUris {\n");
    
    sb.append("    mobileDeeplinkUri: ").append(toIndentedString(mobileDeeplinkUri)).append("\n");
    sb.append("    webDeeplinkUri: ").append(toIndentedString(webDeeplinkUri)).append("\n");
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
