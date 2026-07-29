

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
|**executionMode** | **String** | Execution mode for this route. &#x60;SWAP&#x60; &#x3D; standard on-chain swap (sign the &#x60;tx&#x60; object from &#x60;/swap&#x60; and broadcast). &#x60;RFQ&#x60; &#x3D; signed order flow (sign &#x60;rfq.typedDataToSign&#x60; from &#x60;/swap&#x60; with EIP-712, submit via &#x60;POST /order/submit&#x60;, poll &#x60;GET /order/{orderId}&#x60;). Equity / RWA tokens always return &#x60;RFQ&#x60;. |  [optional] |
|**approveTarget** | **String** | The spender contract address the backend will encode into the approve calldata for this route. To obtain that calldata, call &#x60;/approve-transaction&#x60; with &#x60;vendor&#x3D;&lt;vendorName&gt;&#x60; (the string name, e.g. &#x60;\&quot;PcsXRfq\&quot;&#x60;) — the backend resolves the spender address internally from the vendor name. This field is provided for informational purposes only (e.g. to call ERC-20 &#x60;approve()&#x60; directly without going through &#x60;/approve-transaction&#x60;). Null when no approval is needed (e.g. native-token swap or already approved). |  [optional] |
|**isBest** | **Boolean** | Whether this route has the highest &#x60;toTokenAmount&#x60; among all routes returned in this response. At most one route per response has &#x60;isBest&#x3D;true&#x60;. |  [optional] |
|**feeAmount** | **String** | Fee amount deducted for this route (smallest unit, integer string). Only populated when the request enabled the custom fee (&#x60;feePercent&#x60; + &#x60;feeSource&#x60; both present); &#x60;null&#x60; otherwise. &#x60;FROM_TOKEN&#x60; direction &#x3D; &#x60;originalFromCoinAmount × feePercent/100&#x60; (HALF_UP); &#x60;TO_TOKEN&#x60; direction &#x3D; &#x60;originalToCoinAmount × feePercent/100&#x60; (HALF_DOWN). |  [optional] |
|**feeToken** | **String** | Contract address of the token in which the fee is denominated. &#x60;FROM_TOKEN&#x60; direction &#x3D; sell-token address; &#x60;TO_TOKEN&#x60; direction &#x3D; buy-token address. &#x60;null&#x60; when the custom fee is not enabled. |  [optional] |
|**actualSwapAmount** | **String** | Actual amount participating in the DEX swap (smallest unit, integer string). &#x60;FROM_TOKEN&#x60; direction &#x3D; net amount after fee deduction (&#x60;fromTokenAmount − feeAmount&#x60;, i.e. the amountIn sent to the DEX); &#x60;TO_TOKEN&#x60; direction &#x3D; original input amount (fee is taken from the output side, so the full input participates in the swap). &#x60;null&#x60; when the custom fee is not enabled. |  [optional] |



