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
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * InlineResponse2002
 */
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class InlineResponse2002   {
  @JsonProperty("issuer")

  private String issuer = null;

  @JsonProperty("authorization_endpoint")

  private String authorizationEndpoint = null;

  @JsonProperty("token_endpoint")

  private String tokenEndpoint = null;

  @JsonProperty("userinfo_endpoint")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String userinfoEndpoint = null;

  @JsonProperty("jwks_uri")

  private String jwksUri = null;

  @JsonProperty("registration_endpoint")

  private String registrationEndpoint = null;

  @JsonProperty("scopes_supported")
  @Valid
  private List<String> scopesSupported = null;
  @JsonProperty("response_types_supported")
  @Valid
  private List<String> responseTypesSupported = null;
  @JsonProperty("grant_types_supported")
  @Valid
  private List<String> grantTypesSupported = null;
  @JsonProperty("subject_types_supported")
  @Valid
  private List<String> subjectTypesSupported = null;
  @JsonProperty("id_token_signing_alg_values_supported")
  @Valid
  private List<String> idTokenSigningAlgValuesSupported = null;
  @JsonProperty("token_endpoint_auth_methods_supported")
  @Valid
  private List<String> tokenEndpointAuthMethodsSupported = null;
  @JsonProperty("claims_supported")
  @Valid
  private List<String> claimsSupported = null;

  public InlineResponse2002 issuer(String issuer) { 

    this.issuer = issuer;
    return this;
  }

  /**
   * Base URL that uniquely identifies the authorization server
   * @return issuer
   **/
  
  @Schema(required = true, description = "Base URL that uniquely identifies the authorization server")
  
  @NotNull
  public String getIssuer() {  
    return issuer;
  }



  public void setIssuer(String issuer) { 

    this.issuer = issuer;
  }

  public InlineResponse2002 authorizationEndpoint(String authorizationEndpoint) { 

    this.authorizationEndpoint = authorizationEndpoint;
    return this;
  }

  /**
   * Authorization endpoint URL for initiating the OAuth 2.0 flow
   * @return authorizationEndpoint
   **/
  
  @Schema(required = true, description = "Authorization endpoint URL for initiating the OAuth 2.0 flow")
  
  @NotNull
  public String getAuthorizationEndpoint() {  
    return authorizationEndpoint;
  }



  public void setAuthorizationEndpoint(String authorizationEndpoint) { 

    this.authorizationEndpoint = authorizationEndpoint;
  }

  public InlineResponse2002 tokenEndpoint(String tokenEndpoint) { 

    this.tokenEndpoint = tokenEndpoint;
    return this;
  }

  /**
   * Token endpoint URL for obtaining access tokens
   * @return tokenEndpoint
   **/
  
  @Schema(required = true, description = "Token endpoint URL for obtaining access tokens")
  
  @NotNull
  public String getTokenEndpoint() {  
    return tokenEndpoint;
  }



  public void setTokenEndpoint(String tokenEndpoint) { 

    this.tokenEndpoint = tokenEndpoint;
  }

  public InlineResponse2002 userinfoEndpoint(String userinfoEndpoint) { 

    this.userinfoEndpoint = userinfoEndpoint;
    return this;
  }

  /**
   * UserInfo endpoint URL for retrieving authenticated user information
   * @return userinfoEndpoint
   **/
  
  @Schema(description = "UserInfo endpoint URL for retrieving authenticated user information")
  
  public String getUserinfoEndpoint() {  
    return userinfoEndpoint;
  }



  public void setUserinfoEndpoint(String userinfoEndpoint) { 
    this.userinfoEndpoint = userinfoEndpoint;
  }

  public InlineResponse2002 jwksUri(String jwksUri) { 

    this.jwksUri = jwksUri;
    return this;
  }

  /**
   * URL for retrieving the JSON Web Key Set used to validate JWTs
   * @return jwksUri
   **/
  
  @Schema(required = true, description = "URL for retrieving the JSON Web Key Set used to validate JWTs")
  
  @NotNull
  public String getJwksUri() {  
    return jwksUri;
  }



  public void setJwksUri(String jwksUri) { 

    this.jwksUri = jwksUri;
  }

  public InlineResponse2002 registrationEndpoint(String registrationEndpoint) { 

    this.registrationEndpoint = registrationEndpoint;
    return this;
  }

  /**
   * Dynamic Client Registration endpoint URL
   * @return registrationEndpoint
   **/
  
  @Schema(required = true, description = "Dynamic Client Registration endpoint URL")
  
  @NotNull
  public String getRegistrationEndpoint() {  
    return registrationEndpoint;
  }



  public void setRegistrationEndpoint(String registrationEndpoint) { 

    this.registrationEndpoint = registrationEndpoint;
  }

  public InlineResponse2002 scopesSupported(List<String> scopesSupported) { 

    this.scopesSupported = scopesSupported;
    return this;
  }

  public InlineResponse2002 addScopesSupportedItem(String scopesSupportedItem) {
    if (this.scopesSupported == null) {
      this.scopesSupported = new ArrayList<String>();
    }
    this.scopesSupported.add(scopesSupportedItem);
    return this;
  }

  /**
   * Get scopesSupported
   * @return scopesSupported
   **/
  
  @Schema(description = "")
  
  public List<String> getScopesSupported() {  
    return scopesSupported;
  }



  public void setScopesSupported(List<String> scopesSupported) { 
    this.scopesSupported = scopesSupported;
  }

  public InlineResponse2002 responseTypesSupported(List<String> responseTypesSupported) { 

    this.responseTypesSupported = responseTypesSupported;
    return this;
  }

  public InlineResponse2002 addResponseTypesSupportedItem(String responseTypesSupportedItem) {
    if (this.responseTypesSupported == null) {
      this.responseTypesSupported = new ArrayList<String>();
    }
    this.responseTypesSupported.add(responseTypesSupportedItem);
    return this;
  }

  /**
   * Get responseTypesSupported
   * @return responseTypesSupported
   **/
  
  @Schema(description = "")
  
  public List<String> getResponseTypesSupported() {  
    return responseTypesSupported;
  }



  public void setResponseTypesSupported(List<String> responseTypesSupported) { 
    this.responseTypesSupported = responseTypesSupported;
  }

  public InlineResponse2002 grantTypesSupported(List<String> grantTypesSupported) { 

    this.grantTypesSupported = grantTypesSupported;
    return this;
  }

  public InlineResponse2002 addGrantTypesSupportedItem(String grantTypesSupportedItem) {
    if (this.grantTypesSupported == null) {
      this.grantTypesSupported = new ArrayList<String>();
    }
    this.grantTypesSupported.add(grantTypesSupportedItem);
    return this;
  }

  /**
   * Get grantTypesSupported
   * @return grantTypesSupported
   **/
  
  @Schema(description = "")
  
  public List<String> getGrantTypesSupported() {  
    return grantTypesSupported;
  }



  public void setGrantTypesSupported(List<String> grantTypesSupported) { 
    this.grantTypesSupported = grantTypesSupported;
  }

  public InlineResponse2002 subjectTypesSupported(List<String> subjectTypesSupported) { 

    this.subjectTypesSupported = subjectTypesSupported;
    return this;
  }

  public InlineResponse2002 addSubjectTypesSupportedItem(String subjectTypesSupportedItem) {
    if (this.subjectTypesSupported == null) {
      this.subjectTypesSupported = new ArrayList<String>();
    }
    this.subjectTypesSupported.add(subjectTypesSupportedItem);
    return this;
  }

  /**
   * Get subjectTypesSupported
   * @return subjectTypesSupported
   **/
  
  @Schema(description = "")
  
  public List<String> getSubjectTypesSupported() {  
    return subjectTypesSupported;
  }



  public void setSubjectTypesSupported(List<String> subjectTypesSupported) { 
    this.subjectTypesSupported = subjectTypesSupported;
  }

  public InlineResponse2002 idTokenSigningAlgValuesSupported(List<String> idTokenSigningAlgValuesSupported) { 

    this.idTokenSigningAlgValuesSupported = idTokenSigningAlgValuesSupported;
    return this;
  }

  public InlineResponse2002 addIdTokenSigningAlgValuesSupportedItem(String idTokenSigningAlgValuesSupportedItem) {
    if (this.idTokenSigningAlgValuesSupported == null) {
      this.idTokenSigningAlgValuesSupported = new ArrayList<String>();
    }
    this.idTokenSigningAlgValuesSupported.add(idTokenSigningAlgValuesSupportedItem);
    return this;
  }

  /**
   * Get idTokenSigningAlgValuesSupported
   * @return idTokenSigningAlgValuesSupported
   **/
  
  @Schema(description = "")
  
  public List<String> getIdTokenSigningAlgValuesSupported() {  
    return idTokenSigningAlgValuesSupported;
  }



  public void setIdTokenSigningAlgValuesSupported(List<String> idTokenSigningAlgValuesSupported) { 
    this.idTokenSigningAlgValuesSupported = idTokenSigningAlgValuesSupported;
  }

  public InlineResponse2002 tokenEndpointAuthMethodsSupported(List<String> tokenEndpointAuthMethodsSupported) { 

    this.tokenEndpointAuthMethodsSupported = tokenEndpointAuthMethodsSupported;
    return this;
  }

  public InlineResponse2002 addTokenEndpointAuthMethodsSupportedItem(String tokenEndpointAuthMethodsSupportedItem) {
    if (this.tokenEndpointAuthMethodsSupported == null) {
      this.tokenEndpointAuthMethodsSupported = new ArrayList<String>();
    }
    this.tokenEndpointAuthMethodsSupported.add(tokenEndpointAuthMethodsSupportedItem);
    return this;
  }

  /**
   * Get tokenEndpointAuthMethodsSupported
   * @return tokenEndpointAuthMethodsSupported
   **/
  
  @Schema(description = "")
  
  public List<String> getTokenEndpointAuthMethodsSupported() {  
    return tokenEndpointAuthMethodsSupported;
  }



  public void setTokenEndpointAuthMethodsSupported(List<String> tokenEndpointAuthMethodsSupported) { 
    this.tokenEndpointAuthMethodsSupported = tokenEndpointAuthMethodsSupported;
  }

  public InlineResponse2002 claimsSupported(List<String> claimsSupported) { 

    this.claimsSupported = claimsSupported;
    return this;
  }

  public InlineResponse2002 addClaimsSupportedItem(String claimsSupportedItem) {
    if (this.claimsSupported == null) {
      this.claimsSupported = new ArrayList<String>();
    }
    this.claimsSupported.add(claimsSupportedItem);
    return this;
  }

  /**
   * Get claimsSupported
   * @return claimsSupported
   **/
  
  @Schema(description = "")
  
  public List<String> getClaimsSupported() {  
    return claimsSupported;
  }



  public void setClaimsSupported(List<String> claimsSupported) { 
    this.claimsSupported = claimsSupported;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2002 inlineResponse2002 = (InlineResponse2002) o;
    return Objects.equals(this.issuer, inlineResponse2002.issuer) &&
        Objects.equals(this.authorizationEndpoint, inlineResponse2002.authorizationEndpoint) &&
        Objects.equals(this.tokenEndpoint, inlineResponse2002.tokenEndpoint) &&
        Objects.equals(this.userinfoEndpoint, inlineResponse2002.userinfoEndpoint) &&
        Objects.equals(this.jwksUri, inlineResponse2002.jwksUri) &&
        Objects.equals(this.registrationEndpoint, inlineResponse2002.registrationEndpoint) &&
        Objects.equals(this.scopesSupported, inlineResponse2002.scopesSupported) &&
        Objects.equals(this.responseTypesSupported, inlineResponse2002.responseTypesSupported) &&
        Objects.equals(this.grantTypesSupported, inlineResponse2002.grantTypesSupported) &&
        Objects.equals(this.subjectTypesSupported, inlineResponse2002.subjectTypesSupported) &&
        Objects.equals(this.idTokenSigningAlgValuesSupported, inlineResponse2002.idTokenSigningAlgValuesSupported) &&
        Objects.equals(this.tokenEndpointAuthMethodsSupported, inlineResponse2002.tokenEndpointAuthMethodsSupported) &&
        Objects.equals(this.claimsSupported, inlineResponse2002.claimsSupported);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issuer, authorizationEndpoint, tokenEndpoint, userinfoEndpoint, jwksUri, registrationEndpoint, scopesSupported, responseTypesSupported, grantTypesSupported, subjectTypesSupported, idTokenSigningAlgValuesSupported, tokenEndpointAuthMethodsSupported, claimsSupported);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2002 {\n");
    
    sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
    sb.append("    authorizationEndpoint: ").append(toIndentedString(authorizationEndpoint)).append("\n");
    sb.append("    tokenEndpoint: ").append(toIndentedString(tokenEndpoint)).append("\n");
    sb.append("    userinfoEndpoint: ").append(toIndentedString(userinfoEndpoint)).append("\n");
    sb.append("    jwksUri: ").append(toIndentedString(jwksUri)).append("\n");
    sb.append("    registrationEndpoint: ").append(toIndentedString(registrationEndpoint)).append("\n");
    sb.append("    scopesSupported: ").append(toIndentedString(scopesSupported)).append("\n");
    sb.append("    responseTypesSupported: ").append(toIndentedString(responseTypesSupported)).append("\n");
    sb.append("    grantTypesSupported: ").append(toIndentedString(grantTypesSupported)).append("\n");
    sb.append("    subjectTypesSupported: ").append(toIndentedString(subjectTypesSupported)).append("\n");
    sb.append("    idTokenSigningAlgValuesSupported: ").append(toIndentedString(idTokenSigningAlgValuesSupported)).append("\n");
    sb.append("    tokenEndpointAuthMethodsSupported: ").append(toIndentedString(tokenEndpointAuthMethodsSupported)).append("\n");
    sb.append("    claimsSupported: ").append(toIndentedString(claimsSupported)).append("\n");
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
