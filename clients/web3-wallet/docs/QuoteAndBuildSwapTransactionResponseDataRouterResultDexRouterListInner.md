

# QuoteAndBuildSwapTransactionResponseDataRouterResultDexRouterListInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**dexProtocol** | [**BuildSwapTransactionResponseDataRouterResultDexRouterListInnerDexProtocol**](BuildSwapTransactionResponseDataRouterResultDexRouterListInnerDexProtocol.md) |  |  [optional] |
|**fromToken** | [**BuildSwapTransactionResponseDataRouterResultDexRouterListInnerFromToken**](BuildSwapTransactionResponseDataRouterResultDexRouterListInnerFromToken.md) |  |  [optional] |
|**fromTokenIndex** | **String** |  |  [optional] |
|**toToken** | [**BuildSwapTransactionResponseDataRouterResultDexRouterListInnerToToken**](BuildSwapTransactionResponseDataRouterResultDexRouterListInnerToToken.md) |  |  [optional] |
|**toTokenIndex** | **String** |  |  [optional] |
|**poolAddress** | **String** | Liquidity pool address/pool ID actually used by this path segment (V2/V3 pools: 0x + 40-hex contract address; V4/Infinity pools: 0x + 64-hex poolId). Pass it to the &#x60;excludePools&#x60; parameter to exclude this pool from routing. Null when unavailable. |  [optional] |



