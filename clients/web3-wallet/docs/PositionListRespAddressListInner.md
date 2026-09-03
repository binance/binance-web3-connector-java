

# PositionListRespAddressListInner

Address-level aggregation. Groups the protocol-level position summaries of one wallet address.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**address** | **String** | Wallet address. |  [optional] |
|**addressTotalValue** | **String** | Total DeFi position value of this address across all chains (USD). Same raw precision as the position values. |  [optional] |
|**protocolList** | [**List&lt;AddressRespProtocolListInner&gt;**](AddressRespProtocolListInner.md) | Protocol-level position summaries of this address. |  [optional] |



