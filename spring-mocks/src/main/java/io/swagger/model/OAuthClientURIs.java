package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * API Endpoints of the OFxPERA Participant as an OAuth client
 */
@Schema(description = "API Endpoints of the OFxPERA Participant as an OAuth client")
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-03T23:29:47.351872174Z[GMT]")


public class OAuthClientURIs  implements EndpointURIs {
  @JsonProperty("redirect_uris")
  @Valid
  private List<String> redirectUris = new ArrayList<String>();

  public OAuthClientURIs redirectUris(List<String> redirectUris) { 

    this.redirectUris = redirectUris;
    return this;
  }

  public OAuthClientURIs addRedirectUrisItem(String redirectUrisItem) {
    this.redirectUris.add(redirectUrisItem);
    return this;
  }

  /**
   * Array of redirect URIs to be used in OAuth 2.0 flows
   * @return redirectUris
   **/
  
  @Schema(required = true, description = "Array of redirect URIs to be used in OAuth 2.0 flows")
  
  @NotNull
@Size(min=1)   public List<String> getRedirectUris() {  
    return redirectUris;
  }



  public void setRedirectUris(List<String> redirectUris) { 

    this.redirectUris = redirectUris;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OAuthClientURIs oauthClientURIs = (OAuthClientURIs) o;
    return Objects.equals(this.redirectUris, oauthClientURIs.redirectUris);
  }

  @Override
  public int hashCode() {
    return Objects.hash(redirectUris);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OAuthClientURIs {\n");
    
    sb.append("    redirectUris: ").append(toIndentedString(redirectUris)).append("\n");
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
