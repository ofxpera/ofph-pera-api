package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.JWKSet;
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
 * ClientRegistration
 */
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class ClientRegistration  implements AnyOfClientRegistration {
  /**
   * Type of application
   */
  public enum ApplicationTypeEnum {
    WEB("web"),
    
    NATIVE("native"),
    
    HYBRID("hybrid");

    private String value;

    ApplicationTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ApplicationTypeEnum fromValue(String text) {
      for (ApplicationTypeEnum b : ApplicationTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("applicationType")

  private ApplicationTypeEnum applicationType = null;

  @JsonProperty("clientId")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String clientId = null;

  @JsonProperty("clientName")

  private String clientName = null;

  @JsonProperty("redirectUris")
  @Valid
  private List<String> redirectUris = new ArrayList<String>();
  /**
   * Authentication method for token endpoint, OFxPERA Phase 1 requires private_key_jwt
   */
  public enum TokenEndpointAuthMethodEnum {
    PRIVATE_KEY_JWT("private_key_jwt");

    private String value;

    TokenEndpointAuthMethodEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TokenEndpointAuthMethodEnum fromValue(String text) {
      for (TokenEndpointAuthMethodEnum b : TokenEndpointAuthMethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("tokenEndpointAuthMethod")

  private TokenEndpointAuthMethodEnum tokenEndpointAuthMethod = null;

  /**
   * Gets or Sets grantTypes
   */
  public enum GrantTypesEnum {
    AUTHORIZATION_CODE("authorization_code"),
    
    REFRESH_TOKEN("refresh_token");

    private String value;

    GrantTypesEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GrantTypesEnum fromValue(String text) {
      for (GrantTypesEnum b : GrantTypesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("grantTypes")
  @Valid
  private List<GrantTypesEnum> grantTypes = new ArrayList<GrantTypesEnum>();
  /**
   * Gets or Sets responseTypes
   */
  public enum ResponseTypesEnum {
    CODE("code");

    private String value;

    ResponseTypesEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ResponseTypesEnum fromValue(String text) {
      for (ResponseTypesEnum b : ResponseTypesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("responseTypes")
  @Valid
  private List<ResponseTypesEnum> responseTypes = new ArrayList<ResponseTypesEnum>();
  @JsonProperty("scope")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String scope = null;

  @JsonProperty("softwareStatement")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String softwareStatement = null;

  @JsonProperty("jwks")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private JWKSet jwks = null;

  @JsonProperty("jwksUri")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String jwksUri = null;

  @JsonProperty("organizationName")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String organizationName = null;

  @JsonProperty("contacts")
  @Valid
  private List<String> contacts = null;

  public ClientRegistration applicationType(ApplicationTypeEnum applicationType) { 

    this.applicationType = applicationType;
    return this;
  }

  /**
   * Type of application
   * @return applicationType
   **/
  
  @Schema(required = true, description = "Type of application")
  
  @NotNull
  public ApplicationTypeEnum getApplicationType() {  
    return applicationType;
  }



  public void setApplicationType(ApplicationTypeEnum applicationType) { 

    this.applicationType = applicationType;
  }

  public ClientRegistration clientId(String clientId) { 

    this.clientId = clientId;
    return this;
  }

  /**
   * Client identifier
   * @return clientId
   **/
  
  @Schema(description = "Client identifier")
  
  public String getClientId() {  
    return clientId;
  }



  public void setClientId(String clientId) { 
    this.clientId = clientId;
  }

  public ClientRegistration clientName(String clientName) { 

    this.clientName = clientName;
    return this;
  }

  /**
   * Name of the client
   * @return clientName
   **/
  
  @Schema(required = true, description = "Name of the client")
  
  @NotNull
  public String getClientName() {  
    return clientName;
  }



  public void setClientName(String clientName) { 

    this.clientName = clientName;
  }

  public ClientRegistration redirectUris(List<String> redirectUris) { 

    this.redirectUris = redirectUris;
    return this;
  }

  public ClientRegistration addRedirectUrisItem(String redirectUrisItem) {
    this.redirectUris.add(redirectUrisItem);
    return this;
  }

  /**
   * Array of redirect URIs for use in OAuth flows
   * @return redirectUris
   **/
  
  @Schema(required = true, description = "Array of redirect URIs for use in OAuth flows")
  
  @NotNull
  public List<String> getRedirectUris() {  
    return redirectUris;
  }



  public void setRedirectUris(List<String> redirectUris) { 

    this.redirectUris = redirectUris;
  }

  public ClientRegistration tokenEndpointAuthMethod(TokenEndpointAuthMethodEnum tokenEndpointAuthMethod) { 

    this.tokenEndpointAuthMethod = tokenEndpointAuthMethod;
    return this;
  }

  /**
   * Authentication method for token endpoint, OFxPERA Phase 1 requires private_key_jwt
   * @return tokenEndpointAuthMethod
   **/
  
  @Schema(required = true, description = "Authentication method for token endpoint, OFxPERA Phase 1 requires private_key_jwt")
  
  @NotNull
  public TokenEndpointAuthMethodEnum getTokenEndpointAuthMethod() {  
    return tokenEndpointAuthMethod;
  }



  public void setTokenEndpointAuthMethod(TokenEndpointAuthMethodEnum tokenEndpointAuthMethod) { 

    this.tokenEndpointAuthMethod = tokenEndpointAuthMethod;
  }

  public ClientRegistration grantTypes(List<GrantTypesEnum> grantTypes) { 

    this.grantTypes = grantTypes;
    return this;
  }

  public ClientRegistration addGrantTypesItem(GrantTypesEnum grantTypesItem) {
    this.grantTypes.add(grantTypesItem);
    return this;
  }

  /**
   * Get grantTypes
   * @return grantTypes
   **/
  
  @Schema(required = true, description = "")
  
  @NotNull
  public List<GrantTypesEnum> getGrantTypes() {  
    return grantTypes;
  }



  public void setGrantTypes(List<GrantTypesEnum> grantTypes) { 

    this.grantTypes = grantTypes;
  }

  public ClientRegistration responseTypes(List<ResponseTypesEnum> responseTypes) { 

    this.responseTypes = responseTypes;
    return this;
  }

  public ClientRegistration addResponseTypesItem(ResponseTypesEnum responseTypesItem) {
    this.responseTypes.add(responseTypesItem);
    return this;
  }

  /**
   * Allowed OAuth response types, OFxPERA requires code.
   * @return responseTypes
   **/
  
  @Schema(example = "[\"code\"]", required = true, description = "Allowed OAuth response types, OFxPERA requires code.")
  
  @NotNull
@Size(min=1,max=1)   public List<ResponseTypesEnum> getResponseTypes() {  
    return responseTypes;
  }



  public void setResponseTypes(List<ResponseTypesEnum> responseTypes) { 

    this.responseTypes = responseTypes;
  }

  public ClientRegistration scope(String scope) { 

    this.scope = scope;
    return this;
  }

  /**
   * Space-separated list of requested scopes (e.g. openid profile email address phone)
   * @return scope
   **/
  
  @Schema(description = "Space-separated list of requested scopes (e.g. openid profile email address phone)")
  
  public String getScope() {  
    return scope;
  }



  public void setScope(String scope) { 
    this.scope = scope;
  }

  public ClientRegistration softwareStatement(String softwareStatement) { 

    this.softwareStatement = softwareStatement;
    return this;
  }

  /**
   * JWT containing software statement from trusted authority
   * @return softwareStatement
   **/
  
  @Schema(description = "JWT containing software statement from trusted authority")
  
  public String getSoftwareStatement() {  
    return softwareStatement;
  }



  public void setSoftwareStatement(String softwareStatement) { 
    this.softwareStatement = softwareStatement;
  }

  public ClientRegistration jwks(JWKSet jwks) { 

    this.jwks = jwks;
    return this;
  }

  /**
   * Get jwks
   * @return jwks
   **/
  
  @Schema(description = "")
  
@Valid
  public JWKSet getJwks() {  
    return jwks;
  }



  public void setJwks(JWKSet jwks) { 
    this.jwks = jwks;
  }

  public ClientRegistration jwksUri(String jwksUri) { 

    this.jwksUri = jwksUri;
    return this;
  }

  /**
   * URI for JSON Web Key Set containing public keys
   * @return jwksUri
   **/
  
  @Schema(description = "URI for JSON Web Key Set containing public keys")
  
  public String getJwksUri() {  
    return jwksUri;
  }



  public void setJwksUri(String jwksUri) { 
    this.jwksUri = jwksUri;
  }

  public ClientRegistration organizationName(String organizationName) { 

    this.organizationName = organizationName;
    return this;
  }

  /**
   * Legal name of the PERA Participant organization
   * @return organizationName
   **/
  
  @Schema(description = "Legal name of the PERA Participant organization")
  
  public String getOrganizationName() {  
    return organizationName;
  }



  public void setOrganizationName(String organizationName) { 
    this.organizationName = organizationName;
  }

  public ClientRegistration contacts(List<String> contacts) { 

    this.contacts = contacts;
    return this;
  }

  public ClientRegistration addContactsItem(String contactsItem) {
    if (this.contacts == null) {
      this.contacts = new ArrayList<String>();
    }
    this.contacts.add(contactsItem);
    return this;
  }

  /**
   * Administrative contact emails
   * @return contacts
   **/
  
  @Schema(description = "Administrative contact emails")
  
  public List<String> getContacts() {  
    return contacts;
  }



  public void setContacts(List<String> contacts) { 
    this.contacts = contacts;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientRegistration clientRegistration = (ClientRegistration) o;
    return Objects.equals(this.applicationType, clientRegistration.applicationType) &&
        Objects.equals(this.clientId, clientRegistration.clientId) &&
        Objects.equals(this.clientName, clientRegistration.clientName) &&
        Objects.equals(this.redirectUris, clientRegistration.redirectUris) &&
        Objects.equals(this.tokenEndpointAuthMethod, clientRegistration.tokenEndpointAuthMethod) &&
        Objects.equals(this.grantTypes, clientRegistration.grantTypes) &&
        Objects.equals(this.responseTypes, clientRegistration.responseTypes) &&
        Objects.equals(this.scope, clientRegistration.scope) &&
        Objects.equals(this.softwareStatement, clientRegistration.softwareStatement) &&
        Objects.equals(this.jwks, clientRegistration.jwks) &&
        Objects.equals(this.jwksUri, clientRegistration.jwksUri) &&
        Objects.equals(this.organizationName, clientRegistration.organizationName) &&
        Objects.equals(this.contacts, clientRegistration.contacts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationType, clientId, clientName, redirectUris, tokenEndpointAuthMethod, grantTypes, responseTypes, scope, softwareStatement, jwks, jwksUri, organizationName, contacts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientRegistration {\n");
    
    sb.append("    applicationType: ").append(toIndentedString(applicationType)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientName: ").append(toIndentedString(clientName)).append("\n");
    sb.append("    redirectUris: ").append(toIndentedString(redirectUris)).append("\n");
    sb.append("    tokenEndpointAuthMethod: ").append(toIndentedString(tokenEndpointAuthMethod)).append("\n");
    sb.append("    grantTypes: ").append(toIndentedString(grantTypes)).append("\n");
    sb.append("    responseTypes: ").append(toIndentedString(responseTypes)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    softwareStatement: ").append(toIndentedString(softwareStatement)).append("\n");
    sb.append("    jwks: ").append(toIndentedString(jwks)).append("\n");
    sb.append("    jwksUri: ").append(toIndentedString(jwksUri)).append("\n");
    sb.append("    organizationName: ").append(toIndentedString(organizationName)).append("\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
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
