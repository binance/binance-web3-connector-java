

# BuildSwapTransactionResponseDataTx

On-chain transaction payload to sign and submit.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**from** | **String** | User wallet address (transaction sender). |  [optional] |
|**to** | **String** | DEX router contract address (the transaction&#39;s &#x60;to&#x60; field). |  [optional] |
|**data** | **String** | ABI-encoded calldata. |  [optional] |
|**value** | **String** | Native-token amount sent with the transaction (wei). \&quot;0\&quot; for ERC-20 swaps. |  [optional] |
|**gas** | **String** | Gas limit estimate. Note: this is an estimate for reference only and may be inaccurate. For accurate gas values, use the Transaction API &#x60;GET /api/v1/dex/pre-transaction/gas-price&#x60; and &#x60;POST /api/v1/dex/pre-transaction/gas-limit&#x60;. |  [optional] |
|**gasPrice** | **String** | Gas price (wei). Note: this is an estimate for reference only and may be inaccurate. For accurate gas values, use the Transaction API &#x60;GET /api/v1/dex/pre-transaction/gas-price&#x60; and &#x60;POST /api/v1/dex/pre-transaction/gas-limit&#x60;. |  [optional] |
|**maxPriorityFeePerGas** | **String** | EIP-1559 max priority fee per gas (wei). Note: this is an estimate for reference only and may be inaccurate. For accurate gas values, use the Transaction API &#x60;GET /api/v1/dex/pre-transaction/gas-price&#x60; and &#x60;POST /api/v1/dex/pre-transaction/gas-limit&#x60;. |  [optional] |
|**minReceiveAmount** | **String** | Minimum buy-token amount the user accepts at the slippage limit (smallest unit, integer string). |  [optional] |
|**slippagePercent** | **String** | Slippage value applied to this transaction (percentage string). |  [optional] |
|**signatureData** | **List&lt;String&gt;** | Auxiliary signature data. When &#x60;approveTransaction&#x3D;true&#x60; was passed, this contains the spender address and approve calldata. |  [optional] |
|**computeUnitPrice** | **String** | Solana priority fee per compute unit (micro-lamports). Echoed when supplied; computed by the platform otherwise. Null on EVM chains. |  [optional] |
|**computeUnitLimit** | **String** | Solana compute-unit ceiling. Echoed when supplied; not returned otherwise. Null on EVM chains. |  [optional] |



