

# QuoteAndBuildSwapTransactionResponseData


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**routerResult** | [**BuildSwapTransactionResponseDataRouterResult**](BuildSwapTransactionResponseDataRouterResult.md) |  |  [optional] |
|**tx** | [**BuildSwapTransactionResponseDataTx**](BuildSwapTransactionResponseDataTx.md) |  |  [optional] |
|**executionMode** | **String** | Always &#x60;SWAP&#x60; for this endpoint — returns executable calldata / swapTransaction to sign and broadcast on-chain (no &#x60;RFQ&#x60; mode). |  [optional] |
|**rfq** | [**QuoteAndBuildSwapTransactionResponseDataRfq**](QuoteAndBuildSwapTransactionResponseDataRfq.md) |  |  [optional] |



