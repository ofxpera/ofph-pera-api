# CustomerDueDiligence

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**employmentStatus** | **String** |  | 
**occupation** | **String** |  |  [optional]
**natureOfWork** | **String** | PSIC Code |  [optional]
**employerName** | **String** |  |  [optional]
**employerAddress** | [**Address**](Address.md) |  |  [optional]
**pepIndicator** | **Boolean** | Politically Exposed Person 1 - True; 0 - False | 
**fundSource** | **String** | Source of Funds | 
**cddIndicator** | [**CddIndicatorEnum**](#CddIndicatorEnum) | Customer Due Diligence Risk Level | 

<a name="CddIndicatorEnum"></a>
## Enum: CddIndicatorEnum
Name | Value
---- | -----
LOW | &quot;Low&quot;
NORMAL | &quot;Normal&quot;
HIGH | &quot;High&quot;
