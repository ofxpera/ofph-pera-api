# Participant

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**participantId** | **String** | Unique identifier for the participant |  [optional]
**participantName** | **String** | Trading name of the participant | 
**participantType** | [**List&lt;ParticipantTypeEnum&gt;**](#List&lt;ParticipantTypeEnum&gt;) | Types of roles this participant can perform | 
**participantDescription** | **String** | Short Description of the participant (Required for PERA Admin) |  [optional]
**participantLogoUri** | **String** | logo uri of the participant |  [optional]
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional]
**jwks** | [**JWKSet**](JWKSet.md) |  | 
**contact** | [**ParticipantContact**](ParticipantContact.md) |  |  [optional]
**address** | [**Address**](Address.md) |  |  [optional]

<a name="List<ParticipantTypeEnum>"></a>
## Enum: List&lt;ParticipantTypeEnum&gt;
Name | Value
---- | -----
OAUTH_CLIENT | &quot;oauth_client&quot;
AUTH_SERVER | &quot;auth_server&quot;

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;active&quot;
INACTIVE | &quot;inactive&quot;
SUSPENDED | &quot;suspended&quot;
