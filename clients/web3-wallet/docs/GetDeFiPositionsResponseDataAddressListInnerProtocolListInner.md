

# GetDeFiPositionsResponseDataAddressListInnerProtocolListInner

Protocol-level position summary for one address on one chain. `binanceChainId` + `defiProtocolId` uniquely identify a protocol on a chain.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Binance chain ID (e.g. \&quot;56\&quot;&#x3D;BSC). |  [optional] |
|**defiProtocolId** | **String** | Protocol identifier consistent with &#x60;POST /api/v1/defi/data/protocol/list&#x60;. Use this value when calling investment/list, transaction endpoints, etc. |  [optional] |
|**protocolName** | **String** | Protocol display name. |  [optional] |
|**protocolTotalValue** | **String** | Total position value in this protocol (USD). |  [optional] |
|**poolList** | [**List&lt;GetDeFiPositionsResponseDataAddressListInnerProtocolListInnerPoolListInner&gt;**](GetDeFiPositionsResponseDataAddressListInnerProtocolListInnerPoolListInner.md) | Pools with positions in this protocol. |  [optional] |



