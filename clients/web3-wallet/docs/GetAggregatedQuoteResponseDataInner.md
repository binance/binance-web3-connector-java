

# GetAggregatedQuoteResponseDataInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**quoteId** | **String** | Per-route quote identifier (UUID, no dashes). Pass to the swap endpoint to lock in this route. |  [optional] |
|**vendorName** | **String** | Source vendor display name. Possible values include LiquidMesh, Lifi, 1inch, Pancake, Jupiter. |  [optional] |
|**binanceChainId** | **String** | Chain identifier echoed from the request. |  [optional] |
|**fromTokenAmount** | **String** | Sell amount echoed from the request (smallest unit, integer string). |  [optional] |
|**toTokenAmount** | **String** | Estimated buy-token amount returned by the vendor (smallest unit, integer string). |  [optional] |
|**tradeFee** | **String** | Estimated network fee for this route in USD. Null when the vendor does not return one. |  [optional] |
|**estimateGasFee** | **String** | Estimated gas in the chain&#39;s smallest unit (e.g. wei). May be null on Solana. |  [optional] |
|**priceImpactPercent** | **String** | Estimated price impact percentage. Null when the vendor does not return one. |  [optional] |
|**router** | **String** | Routing path description, addresses joined with \&quot;--\&quot;. |  [optional] |
|**fromToken** | [**GetAggregatedQuoteResponseDataInnerFromToken**](GetAggregatedQuoteResponseDataInnerFromToken.md) |  |  [optional] |
|**toToken** | [**GetAggregatedQuoteResponseDataInnerToToken**](GetAggregatedQuoteResponseDataInnerToToken.md) |  |  [optional] |
|**dexRouterList** | [**List&lt;GetAggregatedQuoteResponseDataInnerDexRouterListInner&gt;**](GetAggregatedQuoteResponseDataInnerDexRouterListInner.md) | Routing path segments. Each segment corresponds to one hop on one DEX protocol; multi-DEX hops are flattened. |  [optional] |



