

# BuildSolanaSwapInstructionsResponseDataRouterResult

Routing result (same shape and semantics as `/swap`'s `routerResult`).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Chain identifier (always &#x60;CT_501&#x60;). |  [optional] |
|**vendorName** | **String** | Vendor that supplied the executed quote (Solana vendors include Jupiter, LiquidMesh). |  [optional] |
|**fromTokenAmount** | **String** | Sell-token amount (smallest unit, integer string). |  [optional] |
|**toTokenAmount** | **String** | Estimated buy-token amount (smallest unit, integer string). |  [optional] |
|**tradeFee** | **String** | Estimated network fee in USD. |  [optional] |
|**estimateGasFee** | **String** | Estimated compute units for the transaction (echoes &#x60;computeUnitLimit&#x60;). |  [optional] |
|**router** | **String** | Routing path description, mints joined with \&quot;--\&quot;. |  [optional] |
|**priceImpactPercent** | **String** | Price impact percentage. |  [optional] |
|**dexRouterList** | [**List&lt;BuildSolanaSwapInstructionsResponseDataRouterResultDexRouterListInner&gt;**](BuildSolanaSwapInstructionsResponseDataRouterResultDexRouterListInner.md) | Routing path segments (same shape as &#x60;/quote&#x60;&#39;s &#x60;dexRouterList&#x60;). |  [optional] |
|**fromToken** | [**BuildSolanaSwapInstructionsResponseDataRouterResultFromToken**](BuildSolanaSwapInstructionsResponseDataRouterResultFromToken.md) |  |  [optional] |
|**toToken** | [**BuildSolanaSwapInstructionsResponseDataRouterResultToToken**](BuildSolanaSwapInstructionsResponseDataRouterResultToToken.md) |  |  [optional] |



