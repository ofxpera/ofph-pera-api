# PeraProduct

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**productId** | **String** | Unique Identifier for the product |  [optional]
**productName** | **String** | The name of the product |  [optional]
**productDescription** | **String** | A detailed description of the product |  [optional]
**productRiskRating** | [**ProductRiskRatingEnum**](#ProductRiskRatingEnum) | The risk rating of the product |  [optional]
**productKiidUri** | **String** | URI to the KIID (Key Investor Information Document) for the product |  [optional]

<a name="ProductRiskRatingEnum"></a>
## Enum: ProductRiskRatingEnum
Name | Value
---- | -----
CONSERVATIVE | &quot;conservative&quot;
MODERATE | &quot;moderate&quot;
AGGRESSIVE | &quot;aggressive&quot;
