package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
 * JWKSetKeys
 */
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class JWKSetKeys   {
  /**
   * Key type
   */
  public enum KtyEnum {
    RSA("RSA"),
    
    EC("EC");

    private String value;

    KtyEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static KtyEnum fromValue(String text) {
      for (KtyEnum b : KtyEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("kty")

  private KtyEnum kty = null;

  @JsonProperty("kid")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String kid = null;

  @JsonProperty("use")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String use = null;

  @JsonProperty("alg")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String alg = null;

  @JsonProperty("n")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String n = null;

  @JsonProperty("e")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String e = null;

  @JsonProperty("x")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String x = null;

  @JsonProperty("y")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String y = null;

  /**
   * Curve type for EC keys
   */
  public enum CrvEnum {
    _256("P-256"),
    
    _384("P-384"),
    
    _521("P-521");

    private String value;

    CrvEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CrvEnum fromValue(String text) {
      for (CrvEnum b : CrvEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("crv")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private CrvEnum crv = null;

  @JsonProperty("x5c")
  @Valid
  private List<String> x5c = null;
  @JsonProperty("x5t")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String x5t = null;


  public JWKSetKeys kty(KtyEnum kty) { 

    this.kty = kty;
    return this;
  }

  /**
   * Key type
   * @return kty
   **/
  
  @Schema(required = true, description = "Key type")
  
  @NotNull
  public KtyEnum getKty() {  
    return kty;
  }



  public void setKty(KtyEnum kty) { 

    this.kty = kty;
  }

  public JWKSetKeys kid(String kid) { 

    this.kid = kid;
    return this;
  }

  /**
   * Key ID
   * @return kid
   **/
  
  @Schema(example = "1234567890", description = "Key ID")
  
  public String getKid() {  
    return kid;
  }



  public void setKid(String kid) { 
    this.kid = kid;
  }

  public JWKSetKeys use(String use) { 

    this.use = use;
    return this;
  }

  /**
   * Key usage (e.g., \"sig\" for signing)
   * @return use
   **/
  
  @Schema(example = "sig", description = "Key usage (e.g., \"sig\" for signing)")
  
  public String getUse() {  
    return use;
  }



  public void setUse(String use) { 
    this.use = use;
  }

  public JWKSetKeys alg(String alg) { 

    this.alg = alg;
    return this;
  }

  /**
   * Algorithm (e.g., \"RS256\")
   * @return alg
   **/
  
  @Schema(example = "RS256", description = "Algorithm (e.g., \"RS256\")")
  
  public String getAlg() {  
    return alg;
  }



  public void setAlg(String alg) { 
    this.alg = alg;
  }

  public JWKSetKeys n(String n) { 

    this.n = n;
    return this;
  }

  /**
   * RSA modulus for RSA keys
   * @return n
   **/
  
  @Schema(example = "0vx7agoebGcQSuuPiLJXZptN9nndrQmbXEps2aiAFbWhM78LhWx4cbbfAAtVT86zwu1RK7aPFFxuhDR1L6tSoc_BJECPebWKRXjBZCiFV4n3oknjhMstn64tZ_2W-5JsGY4Hc5n9yBXArwl93lqt7_RN5w6Cf0h4QyQ5v-65YGjQR0_FDW2QvzqY368QQMicAtaSqzs8KJZgnYb9c7d0zgdAZHzu6qMQvRL5hajrn1n91CbOpbISD08qNLyrdkt-bFTWhAI4vMQFh6WeZu0fM4lFd2NcRwr3XPksINHaQ-G_xBniIqbw0Ls1jF44-csFCur-kEgU8awapJzKnqDKgw", description = "RSA modulus for RSA keys")
  
  public String getN() {  
    return n;
  }



  public void setN(String n) { 
    this.n = n;
  }

  public JWKSetKeys e(String e) { 

    this.e = e;
    return this;
  }

  /**
   * RSA public exponent for RSA keys
   * @return e
   **/
  
  @Schema(example = "AQAB", description = "RSA public exponent for RSA keys")
  
  public String getE() {  
    return e;
  }



  public void setE(String e) { 
    this.e = e;
  }

  public JWKSetKeys x(String x) { 

    this.x = x;
    return this;
  }

  /**
   * X coordinate for EC keys
   * @return x
   **/
  
  @Schema(example = "gI0GAILBdu7T53akrFmMyGcsF3n5dO7MmwNBHKW5SV0", description = "X coordinate for EC keys")
  
  public String getX() {  
    return x;
  }



  public void setX(String x) { 
    this.x = x;
  }

  public JWKSetKeys y(String y) { 

    this.y = y;
    return this;
  }

  /**
   * Y coordinate for EC keys
   * @return y
   **/
  
  @Schema(example = "SLW_xSffzlPWrHEVI30DHM_4egVwt3NQqeUD7nMFpps", description = "Y coordinate for EC keys")
  
  public String getY() {  
    return y;
  }



  public void setY(String y) { 
    this.y = y;
  }

  public JWKSetKeys crv(CrvEnum crv) { 

    this.crv = crv;
    return this;
  }

  /**
   * Curve type for EC keys
   * @return crv
   **/
  
  @Schema(example = "P-256", description = "Curve type for EC keys")
  
  public CrvEnum getCrv() {  
    return crv;
  }



  public void setCrv(CrvEnum crv) { 
    this.crv = crv;
  }

  public JWKSetKeys x5c(List<String> x5c) { 

    this.x5c = x5c;
    return this;
  }

  public JWKSetKeys addX5cItem(String x5cItem) {
    if (this.x5c == null) {
      this.x5c = new ArrayList<String>();
    }
    this.x5c.add(x5cItem);
    return this;
  }

  /**
   * X.509 certificate chain
   * @return x5c
   **/
  
  @Schema(example = "[\"MIIDQjCCAiqgAwIBAgIGATz/FuLiMA0GCSqGSIb3DQEBBQUAMGIxCzAJBgNVBAYTAlVTMQswCQYDVQQIEwJDTzEPMA0GA1UEBxMGRGVudmVyMRwwGgYDVQQKExNQaW5nIElkZW50aXR5IENvcnAuMRcwFQYDVQQDEw5CcmlhbiBDYW1wYmVsbDAeFw0xMzAyMjEyMzI5MTVaFw0xODA4MTQyMjI5MTVaMGIxCzAJBgNVBAYTAlVTMQswCQYDVQQIEwJDTzEPMA0GA1UEBxMGRGVudmVyMRwwGgYDVQQKExNQaW5nIElkZW50aXR5IENvcnAuMRcwFQYDVQQDEw5CcmlhbiBDYW1wYmVsbDAeFw0xMzAyMjEyMzI5MTVaFw0xODA4MTQyMjI5MTVaMGIxCzAJBgNVBAYTAlVTMQswCQYDVQQIEwJDTzEPMA0GA1UEBxMGRGVudmVyMRwwGgYDVQQKExNQaW5nIElkZW50aXR5IENvcnAuMRcwFQYDVQQDEw5CcmlhbiBDYW1wYmVsbDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAL64zn8/QnHYMeZ0LncoXaEde1fiLm1jHjmQsF/449IYALM9if6amFtPDy2yvz3YlRij66s5gyLCyO7ANuVRJx1NbgizcAblIgjtdf/u3WG7K+IiZhtELto/A7Fck9Ws6SQvzRvOE8uSirYbgmj6He4iO8NCyvaK0jIQRMMGQwsU1quGmFgHIXPLfnpnfajr1rVTAwtgV5LEZ4Iel+W1GC8ugMhyr4/p1MtcIM42EA8BzE6ZQqC7VPqPvEjZ2dbZkaBhPbiZAS3YeYBRDWm1p1OZtWamT3cEvqqPpnjL1XyW+oyVVkaZdklLQp2Btgt9qr21m42f4wTw+Xrp6rCKNb0CAwEAATANBgkqhkiG9w0BAQUFAAOCAQEAh8zGlfSlcI0o3rYDPBB07aXNswb4ECNIKG0CETTUxmXl9KUL+9gGlqCz5iWLOgWsnrcKcY0vXPG9J1r9AqBNTqNgHq2G03X09266X5CpOe1zFo+Owb1zxtp3PehFdfQJ610CDLEaS9V9Rqp17hCyybEpOGVwe8fnk+fbEL2Bo3UPGrpsHzUoaGpDftmWssZkhpBJKVMJyf/RuP2SmmaIzmnw9JiSlYhzo4tpzd5rFXhjRbg4zW9C+2qok+2+qDM1iJ684gPHMIY8aLWrdgQTxkumGmTqgawR+N5MDtdPTEQ0XfIBc2cJEUyMTY5MPvACWpkA6SdS4xSvdXK3IVfOWA==\"]", description = "X.509 certificate chain")
  
  public List<String> getX5c() {  
    return x5c;
  }



  public void setX5c(List<String> x5c) { 
    this.x5c = x5c;
  }

  public JWKSetKeys x5t(String x5t) { 

    this.x5t = x5t;
    return this;
  }

  /**
   * X.509 certificate SHA-1 thumbprint
   * @return x5t
   **/
  
  @Schema(example = "dGhpcyBpcyBub3QgYSByZWFsIHRodW1icHJpbnQ", description = "X.509 certificate SHA-1 thumbprint")
  
  public String getX5t() {  
    return x5t;
  }



  public void setX5t(String x5t) { 
    this.x5t = x5t;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JWKSetKeys jwKSetKeys = (JWKSetKeys) o;
    return Objects.equals(this.kty, jwKSetKeys.kty) &&
        Objects.equals(this.kid, jwKSetKeys.kid) &&
        Objects.equals(this.use, jwKSetKeys.use) &&
        Objects.equals(this.alg, jwKSetKeys.alg) &&
        Objects.equals(this.n, jwKSetKeys.n) &&
        Objects.equals(this.e, jwKSetKeys.e) &&
        Objects.equals(this.x, jwKSetKeys.x) &&
        Objects.equals(this.y, jwKSetKeys.y) &&
        Objects.equals(this.crv, jwKSetKeys.crv) &&
        Objects.equals(this.x5c, jwKSetKeys.x5c) &&
        Objects.equals(this.x5t, jwKSetKeys.x5t);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kty, kid, use, alg, n, e, x, y, crv, x5c, x5t);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JWKSetKeys {\n");
    
    sb.append("    kty: ").append(toIndentedString(kty)).append("\n");
    sb.append("    kid: ").append(toIndentedString(kid)).append("\n");
    sb.append("    use: ").append(toIndentedString(use)).append("\n");
    sb.append("    alg: ").append(toIndentedString(alg)).append("\n");
    sb.append("    n: ").append(toIndentedString(n)).append("\n");
    sb.append("    e: ").append(toIndentedString(e)).append("\n");
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
    sb.append("    crv: ").append(toIndentedString(crv)).append("\n");
    sb.append("    x5c: ").append(toIndentedString(x5c)).append("\n");
    sb.append("    x5t: ").append(toIndentedString(x5t)).append("\n");
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
