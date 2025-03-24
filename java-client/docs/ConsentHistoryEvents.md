# ConsentHistoryEvents

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**eventType** | [**EventTypeEnum**](#EventTypeEnum) |  | 
**timestamp** | [**OffsetDateTime**](OffsetDateTime.md) |  | 
**actor** | **String** | The entity that performed the action (e.g., user_id, system) | 
**details** | **Object** | Additional event-specific details |  [optional]
**previousState** | **Object** | State before the change |  [optional]
**newState** | **Object** | State after the change |  [optional]

<a name="EventTypeEnum"></a>
## Enum: EventTypeEnum
Name | Value
---- | -----
CREATED | &quot;created&quot;
UPDATED | &quot;updated&quot;
SUSPENDED | &quot;suspended&quot;
RESUMED | &quot;resumed&quot;
REVOKED | &quot;revoked&quot;
EXPIRED | &quot;expired&quot;
EXTENDED | &quot;extended&quot;
