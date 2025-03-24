package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.JWKSetKeys;
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
 * JWKSet
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class JWKSet  implements JwksConfiguration {
  @JsonProperty("keys")
  @Valid
  private List<JWKSetKeys> keys = new ArrayList<JWKSetKeys>();

  public JWKSet keys(List<JWKSetKeys> keys) { 

    this.keys = keys;
    return this;
  }

  public JWKSet addKeysItem(JWKSetKeys keysItem) {
    this.keys.add(keysItem);
    return this;
  }

  /**
   * Array of JWK values representing public keys for verifying JWTs
   * @return keys
   **/
  
  @Schema(required = true, description = "Array of JWK values representing public keys for verifying JWTs")
  
@Valid
  @NotNull
  public List<JWKSetKeys> getKeys() {  
    return keys;
  }



  public void setKeys(List<JWKSetKeys> keys) { 

    this.keys = keys;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JWKSet jwKSet = (JWKSet) o;
    return Objects.equals(this.keys, jwKSet.keys);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keys);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JWKSet {\n");
    
    sb.append("    keys: ").append(toIndentedString(keys)).append("\n");
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
