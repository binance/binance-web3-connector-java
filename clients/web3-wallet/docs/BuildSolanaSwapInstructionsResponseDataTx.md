

# BuildSolanaSwapInstructionsResponseDataTx

Transaction summary (no `data` field — replaced by `instructionLists`). Contains the fields the caller needs to display or audit before signing.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**from** | **String** | User wallet address (transaction sender / fee payer). |  [optional] |
|**to** | **String** | Platform Router program address (the swap target program). |  [optional] |
|**minReceiveAmount** | **String** | Minimum buy-token amount the user accepts at the slippage limit (smallest unit, integer string). |  [optional] |
|**slippagePercent** | **String** | Slippage value applied to this transaction (percentage string). |  [optional] |



