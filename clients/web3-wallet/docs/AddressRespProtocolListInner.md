

# AddressRespProtocolListInner

Protocol-level position summary for one address on one chain. `binanceChainId` + `defiProtocolId` uniquely identify a protocol on a chain.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Binance chain ID. Plain numeric string for EVM chains (e.g. &#x60;\&quot;56\&quot;&#x60; &#x3D; BNB Smart Chain); non-EVM chains use a &#x60;CT_&#x60;-prefixed string (e.g. &#x60;\&quot;CT_501\&quot;&#x60; &#x3D; Solana), consistent with the Trading / Transaction APIs. See Supported Chains &amp; Protocols for the supported values. |  [optional] |
|**defiProtocolId** | **String** | Protocol identifier consistent with &#x60;POST /api/v1/defi/data/protocol/list&#x60;. Use this value when calling investment/list, transaction endpoints, etc. |  [optional] |
|**protocolName** | **String** | Protocol display name. |  [optional] |
|**protocolTotalValue** | **String** | Total position value in this protocol (USD). |  [optional] |
|**poolList** | [**List&lt;ProtocolRespPoolListInner&gt;**](ProtocolRespPoolListInner.md) | Pools with positions in this protocol. |  [optional] |



