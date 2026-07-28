

# BuildSwapTransactionResponseData


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**routerResult** | [**BuildSwapTransactionResponseDataRouterResult**](BuildSwapTransactionResponseDataRouterResult.md) |  |  [optional] |
|**tx** | [**BuildSwapTransactionResponseDataTx**](BuildSwapTransactionResponseDataTx.md) |  |  [optional] |
|**executionMode** | **String** | Execution mode for this swap. &#x60;SWAP&#x60; &#x3D; sign the &#x60;tx&#x60; object and broadcast to the chain. &#x60;RFQ&#x60; &#x3D; sign &#x60;rfq.typedDataToSign&#x60; with EIP-712 (&#x60;eth_signTypedData_v4&#x60;), then submit via &#x60;POST /order/submit&#x60; and poll &#x60;GET /order/{orderId}&#x60; for settlement status. Equity / RWA tokens always return &#x60;RFQ&#x60;. |  [optional] |
|**rfq** | [**BuildSwapTransactionResponseDataRfq**](BuildSwapTransactionResponseDataRfq.md) |  |  [optional] |



