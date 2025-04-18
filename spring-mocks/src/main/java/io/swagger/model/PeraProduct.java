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
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * PeraProduct
 */
@Validated
@NotUndefined
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-24T23:14:39.487511291Z[GMT]")


public class PeraProduct   {
  @JsonProperty("productId")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String productId = null;

  @JsonProperty("productName")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String productName = null;

  @JsonProperty("productDescription")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String productDescription = null;

  /**
   * The risk rating of the product
   */
  public enum ProductRiskRatingEnum {
    CONSERVATIVE("conservative"),
    
    MODERATE("moderate"),
    
    AGGRESSIVE("aggressive");

    private String value;

    ProductRiskRatingEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ProductRiskRatingEnum fromValue(String text) {
      for (ProductRiskRatingEnum b : ProductRiskRatingEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("productRiskRating")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private ProductRiskRatingEnum productRiskRating = null;

  @JsonProperty("productKiidUri")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String productKiidUri = null;


  public PeraProduct productId(String productId) { 

    this.productId = productId;
    return this;
  }

  /**
   * Unique Identifier for the product
   * @return productId
   **/
  
  @Schema(description = "Unique Identifier for the product")
  
  public String getProductId() {  
    return productId;
  }



  public void setProductId(String productId) { 
    this.productId = productId;
  }

  public PeraProduct productName(String productName) { 

    this.productName = productName;
    return this;
  }

  /**
   * The name of the product
   * @return productName
   **/
  
  @Schema(description = "The name of the product")
  
  public String getProductName() {  
    return productName;
  }



  public void setProductName(String productName) { 
    this.productName = productName;
  }

  public PeraProduct productDescription(String productDescription) { 

    this.productDescription = productDescription;
    return this;
  }

  /**
   * A detailed description of the product
   * @return productDescription
   **/
  
  @Schema(description = "A detailed description of the product")
  
  public String getProductDescription() {  
    return productDescription;
  }



  public void setProductDescription(String productDescription) { 
    this.productDescription = productDescription;
  }

  public PeraProduct productRiskRating(ProductRiskRatingEnum productRiskRating) { 

    this.productRiskRating = productRiskRating;
    return this;
  }

  /**
   * The risk rating of the product
   * @return productRiskRating
   **/
  
  @Schema(description = "The risk rating of the product")
  
  public ProductRiskRatingEnum getProductRiskRating() {  
    return productRiskRating;
  }



  public void setProductRiskRating(ProductRiskRatingEnum productRiskRating) { 
    this.productRiskRating = productRiskRating;
  }

  public PeraProduct productKiidUri(String productKiidUri) { 

    this.productKiidUri = productKiidUri;
    return this;
  }

  /**
   * URI to the KIID (Key Investor Information Document) for the product
   * @return productKiidUri
   **/
  
  @Schema(description = "URI to the KIID (Key Investor Information Document) for the product")
  
  public String getProductKiidUri() {  
    return productKiidUri;
  }



  public void setProductKiidUri(String productKiidUri) { 
    this.productKiidUri = productKiidUri;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PeraProduct peraProduct = (PeraProduct) o;
    return Objects.equals(this.productId, peraProduct.productId) &&
        Objects.equals(this.productName, peraProduct.productName) &&
        Objects.equals(this.productDescription, peraProduct.productDescription) &&
        Objects.equals(this.productRiskRating, peraProduct.productRiskRating) &&
        Objects.equals(this.productKiidUri, peraProduct.productKiidUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, productName, productDescription, productRiskRating, productKiidUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PeraProduct {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
    sb.append("    productDescription: ").append(toIndentedString(productDescription)).append("\n");
    sb.append("    productRiskRating: ").append(toIndentedString(productRiskRating)).append("\n");
    sb.append("    productKiidUri: ").append(toIndentedString(productKiidUri)).append("\n");
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
