# ConsentArrangementResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier for the consent arrangement | 
**status** | [**StatusEnum**](#StatusEnum) | Current status of the consent arrangement | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | When the consent arrangement was created | 
**lastUpdatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | When the consent arrangement was last updated |  [optional]
**dataHolderId** | **String** | Identifier of the data holder | 
**permissions** | **List&lt;String&gt;** | Granted permissions for data access | 
**sharingDuration** | [**ConsentArrangementResponseSharingDuration**](ConsentArrangementResponseSharingDuration.md) |  | 
**purpose** | **String** | Purpose for which the data will be used | 
**additionalTerms** | [**List&lt;ConsentArrangementRequestAdditionalTerms&gt;**](ConsentArrangementRequestAdditionalTerms.md) |  |  [optional]
**revocationInfo** | [**ConsentArrangementResponseRevocationInfo**](ConsentArrangementResponseRevocationInfo.md) |  |  [optional]

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;active&quot;
EXPIRED | &quot;expired&quot;
REVOKED | &quot;revoked&quot;
SUSPENDED | &quot;suspended&quot;
