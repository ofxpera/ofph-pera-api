# ConsentArrangementRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dataHolderId** | **String** | Identifier of the data holder (financial institution) | 
**permissions** | [**List&lt;PermissionsEnum&gt;**](#List&lt;PermissionsEnum&gt;) | Permissions being requested for data access | 
**sharingDuration** | [**ConsentArrangementRequestSharingDuration**](ConsentArrangementRequestSharingDuration.md) |  | 
**purpose** | **String** | Purpose for which the data will be used | 
**additionalTerms** | [**List&lt;ConsentArrangementRequestAdditionalTerms&gt;**](ConsentArrangementRequestAdditionalTerms.md) | Additional terms and conditions specific to this arrangement |  [optional]

<a name="List<PermissionsEnum>"></a>
## Enum: List&lt;PermissionsEnum&gt;
Name | Value
---- | -----
BASIC_INFO | &quot;PERA_BASIC_INFO&quot;
BALANCE | &quot;PERA_BALANCE&quot;
TRANSACTIONS | &quot;PERA_TRANSACTIONS&quot;
INVESTMENT_DETAILS | &quot;PERA_INVESTMENT_DETAILS&quot;
STATEMENTS | &quot;PERA_STATEMENTS&quot;
