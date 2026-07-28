

# GetTokenDevInfoResponseDataDevHoldingInfo

Developer's current holding information for this token.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**devHoldingPercent** | **String** | Developer&#39;s current holding percentage for this token. No percent sign included. Empty string means fully sold. |  [optional] |
|**devAddress** | **String** | Developer (creator) wallet address. |  [optional] |
|**fundingSource** | **String** | Funding source address — the originator of the first inbound native-token transfer. Empty string when no inbound transfer is recorded. |  [optional] |
|**fundingSourceLabel** | **String** | Funding source name (e.g. exchange name). Empty string when unknown. |  [optional] |
|**fundingSourceHash** | **String** | Transaction hash of the first inbound native-token transfer. |  [optional] |
|**fundingSourceTime** | **String** | Timestamp of the first inbound native-token transfer, Unix millisecond timestamp. |  [optional] |
|**fundingSourceAmount** | **String** | Amount of the first inbound native-token transfer (native token units). |  [optional] |
|**devBalance** | **String** | Developer wallet&#39;s native token balance (e.g. SOL). Empty string when unavailable. |  [optional] |



