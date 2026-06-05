

# BuildSwapTransactionResponseDataRouterResult

Routing result for the chosen vendor.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Chain identifier echoed from the request. |  [optional] |
|**vendorName** | **String** | Vendor that supplied the executed quote (e.g. LiquidMesh, Lifi, 1inch, Pancake, Jupiter). |  [optional] |
|**fromTokenAmount** | **String** | Sell-token amount (smallest unit, integer string). |  [optional] |
|**toTokenAmount** | **String** | Estimated buy-token amount (smallest unit, integer string). |  [optional] |
|**tradeFee** | **String** | Estimated network fee in USD. |  [optional] |
|**estimateGasFee** | **String** | Estimated gas in the chain&#39;s smallest unit (e.g. wei). |  [optional] |
|**router** | **String** | Routing path description, addresses joined with \&quot;--\&quot;. |  [optional] |
|**priceImpactPercent** | **String** | Price impact percentage. Formula (received_value − sent_value) / sent_value. |  [optional] |
|**dexRouterList** | [**List&lt;BuildSwapTransactionResponseDataRouterResultDexRouterListInner&gt;**](BuildSwapTransactionResponseDataRouterResultDexRouterListInner.md) | Routing path segments. Same shape as the &#x60;dexRouterList&#x60; returned by &#x60;/quote&#x60;. |  [optional] |
|**fromToken** | [**BuildSwapTransactionResponseDataRouterResultFromToken**](BuildSwapTransactionResponseDataRouterResultFromToken.md) |  |  [optional] |
|**toToken** | [**BuildSwapTransactionResponseDataRouterResultToToken**](BuildSwapTransactionResponseDataRouterResultToToken.md) |  |  [optional] |



