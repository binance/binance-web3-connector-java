

# QuoteAndBuildSwapTransactionResponseDataRouterResult

Routing result for the chosen vendor.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Chain identifier echoed from the request. |  [optional] |
|**vendorName** | **String** | Vendor that supplied the executed quote (e.g. LiquidMesh, Lifi, 1inch, Pancake, Jupiter). |  [optional] |
|**fromTokenAmount** | **String** | Sell-token amount (smallest unit, integer string). |  [optional] |
|**toTokenAmount** | **String** | Estimated buy-token amount (smallest unit, integer string). |  [optional] |
|**tradeFee** | **String** | Estimated network fee in USD. Note: this is an estimate for reference only and may be inaccurate. For accurate gas values, use the Transaction API &#x60;GET /api/v1/dex/pre-transaction/gas-price&#x60; and &#x60;POST /api/v1/dex/pre-transaction/gas-limit&#x60;. |  [optional] |
|**estimateGasFee** | **String** | Estimated gas in the chain&#39;s smallest unit (e.g. wei). Note: this is an estimate for reference only and may be inaccurate. For accurate gas values, use the Transaction API &#x60;GET /api/v1/dex/pre-transaction/gas-price&#x60; and &#x60;POST /api/v1/dex/pre-transaction/gas-limit&#x60;. |  [optional] |
|**router** | **String** | Routing path description, addresses joined with \&quot;--\&quot;. |  [optional] |
|**priceImpactPercent** | **String** | Price impact percentage. Formula (received_value − sent_value) / sent_value. |  [optional] |
|**dexRouterList** | [**List&lt;QuoteAndBuildSwapTransactionResponseDataRouterResultDexRouterListInner&gt;**](QuoteAndBuildSwapTransactionResponseDataRouterResultDexRouterListInner.md) | Routing path segments. Same shape as the &#x60;dexRouterList&#x60; returned by &#x60;/quote&#x60;. |  [optional] |
|**fromToken** | [**BuildSwapTransactionResponseDataRouterResultFromToken**](BuildSwapTransactionResponseDataRouterResultFromToken.md) |  |  [optional] |
|**toToken** | [**BuildSwapTransactionResponseDataRouterResultToToken**](BuildSwapTransactionResponseDataRouterResultToToken.md) |  |  [optional] |
|**feeAmount** | **String** | Fee amount deducted for this swap (smallest unit, integer string). Only populated when the request enabled the custom fee; &#x60;null&#x60; otherwise. &#x60;FROM_TOKEN&#x60; direction &#x3D; &#x60;originalFromCoinAmount × feePercent/100&#x60; (HALF_UP); &#x60;TO_TOKEN&#x60; direction &#x3D; &#x60;originalToCoinAmount × feePercent/100&#x60; (HALF_DOWN). |  [optional] |
|**feeToken** | **String** | Contract address of the token in which the fee is denominated. &#x60;FROM_TOKEN&#x60; direction &#x3D; sell-token address; &#x60;TO_TOKEN&#x60; direction &#x3D; buy-token address. &#x60;null&#x60; when the custom fee is not enabled. |  [optional] |
|**actualSwapAmount** | **String** | Actual amount participating in the DEX swap (smallest unit, integer string). &#x60;FROM_TOKEN&#x60; direction &#x3D; net amount after fee deduction (&#x60;fromTokenAmount − feeAmount&#x60;); &#x60;TO_TOKEN&#x60; direction &#x3D; original input amount (fee is taken from the output side). &#x60;null&#x60; when the custom fee is not enabled. |  [optional] |



