

# GetBroadcastOrdersResponseDataOrdersInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**orderId** | **String** | Internal order identifier. |  [optional] |
|**binanceChainId** | **String** | Chain identifier. |  [optional] |
|**address** | **String** | Sender wallet address. |  [optional] |
|**txHash** | **String** | On-chain transaction hash. Null while the order is pending. |  [optional] |
|**txStatus** | **String** | Transaction status (server-defined string, e.g. \&quot;pending\&quot;, \&quot;success\&quot;, \&quot;fail\&quot;). |  [optional] |
|**failReason** | **String** | Failure reason. Populated when the transaction failed; null otherwise. |  [optional] |



