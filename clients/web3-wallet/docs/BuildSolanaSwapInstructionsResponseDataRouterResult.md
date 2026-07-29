

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
|**feeAmount** | **String** | Fee amount deducted for this swap (smallest unit, integer string). Only populated when the request enabled the custom fee; &#x60;null&#x60; otherwise. &#x60;FROM_TOKEN&#x60; direction &#x3D; &#x60;originalFromCoinAmount × feePercent/100&#x60; (HALF_UP); &#x60;TO_TOKEN&#x60; direction &#x3D; &#x60;originalToCoinAmount × feePercent/100&#x60; (HALF_DOWN). |  [optional] |
|**feeToken** | **String** | Contract address of the token in which the fee is denominated. &#x60;FROM_TOKEN&#x60; direction &#x3D; sell-token address; &#x60;TO_TOKEN&#x60; direction &#x3D; buy-token address. &#x60;null&#x60; when the custom fee is not enabled. |  [optional] |
|**actualSwapAmount** | **String** | Actual amount participating in the DEX swap (smallest unit, integer string). &#x60;FROM_TOKEN&#x60; direction &#x3D; net amount after fee deduction (&#x60;fromTokenAmount − feeAmount&#x60;); &#x60;TO_TOKEN&#x60; direction &#x3D; original input amount (fee is taken from the output side). &#x60;null&#x60; when the custom fee is not enabled. |  [optional] |



