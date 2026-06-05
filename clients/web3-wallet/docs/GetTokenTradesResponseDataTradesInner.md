

# GetTokenTradesResponseDataTradesInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Chain identifier. |  [optional] |
|**tokenContractAddress** | **String** | Token contract address. |  [optional] |
|**txHash** | **String** | On-chain transaction hash. |  [optional] |
|**userAddress** | **String** | Trader wallet address. |  [optional] |
|**dexName** | **String** | Name of the DEX protocol where the trade was executed. |  [optional] |
|**type** | **String** | Trade direction relative to the queried token. \&quot;buy\&quot; or \&quot;sell\&quot;. |  [optional] |
|**price** | **String** | Trade price, denominated in USD. |  [optional] |
|**volume** | **String** | Trade amount, denominated in USD. |  [optional] |
|**time** | **Long** | Trade time, Unix millisecond timestamp. |  [optional] |
|**changedTokenInfo** | [**List&lt;GetTokenTradesResponseDataTradesInnerChangedTokenInfoInner&gt;**](GetTokenTradesResponseDataTradesInnerChangedTokenInfoInner.md) | Token details involved in this trade. [0] &#x3D; queried token; [1] &#x3D; paired token. |  [optional] |



