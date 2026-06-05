

# GetTopLiquidityPoolsResponseDataInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**pool** | **String** | Pool name, e.g. \&quot;PEPE/WETH\&quot;. |  [optional] |
|**protocolName** | **String** | DEX protocol name. Null when unknown. |  [optional] |
|**protocolLogoUrl** | **String** | Protocol logo link. Null when no logo. |  [optional] |
|**liquidityUsd** | **String** | Pool liquidity, denominated in USD. |  [optional] |
|**poolAddress** | **String** | Pool contract address. |  [optional] |
|**liquidityAmount** | [**List&lt;GetTopLiquidityPoolsResponseDataInnerLiquidityAmountInner&gt;**](GetTopLiquidityPoolsResponseDataInnerLiquidityAmountInner.md) | Detailed information for each token in the pool. |  [optional] |



