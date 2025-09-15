# JWKSetKeys

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**kty** | [**KtyEnum**](#KtyEnum) | Key type | 
**kid** | **String** | Key ID |  [optional]
**use** | **String** | Key usage (e.g., \&quot;sig\&quot; for signing) |  [optional]
**alg** | **String** | Algorithm (e.g., \&quot;RS256\&quot;) |  [optional]
**n** | **String** | RSA modulus for RSA keys |  [optional]
**e** | **String** | RSA public exponent for RSA keys |  [optional]
**x** | **String** | X coordinate for EC keys |  [optional]
**y** | **String** | Y coordinate for EC keys |  [optional]
**crv** | [**CrvEnum**](#CrvEnum) | Curve type for EC keys |  [optional]
**x5c** | **List&lt;String&gt;** | X.509 certificate chain |  [optional]
**x5t** | **String** | X.509 certificate SHA-1 thumbprint |  [optional]

<a name="KtyEnum"></a>
## Enum: KtyEnum
Name | Value
---- | -----
RSA | &quot;RSA&quot;
EC | &quot;EC&quot;

<a name="CrvEnum"></a>
## Enum: CrvEnum
Name | Value
---- | -----
_256 | &quot;P-256&quot;
_384 | &quot;P-384&quot;
_521 | &quot;P-521&quot;
