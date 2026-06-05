

# GetTransactionStatusResponseData

Transaction details. Null when the transaction is not found in any source table.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Chain identifier. |  [optional] |
|**txHash** | **String** | Transaction hash. |  [optional] |
|**height** | **String** | Block height the transaction was included in (decimal string). |  [optional] |
|**txTime** | **String** | Transaction timestamp (Unix epoch milliseconds, string form). |  [optional] |
|**status** | **String** | Transaction status. Typical values \&quot;success\&quot; or \&quot;failed\&quot;. |  [optional] |
|**fromAddress** | **String** | Sender address. |  [optional] |
|**toAddress** | **String** | Recipient address (typically the DEX router). |  [optional] |
|**errorMsg** | **String** | Error message when &#x60;status&#x3D;failed&#x60;; null otherwise. |  [optional] |
|**gasLimit** | **String** | Gas limit (decimal string). Null on Solana. |  [optional] |
|**gasUsed** | **String** | Gas actually consumed (decimal string, wei). Null on Solana. |  [optional] |
|**gasPrice** | **String** | Gas price (decimal string, wei). Null on Solana. |  [optional] |
|**txFee** | **String** | Transaction fee in the chain&#39;s native unit. Null on Solana. |  [optional] |
|**priorityFee** | **String** | EIP-1559 priority fee (wei) on EVM, prioritization fee (lamports) on Solana, null on legacy EVM transactions. |  [optional] |
|**txType** | **String** | Transaction action; currently fixed to \&quot;Swap\&quot; when an aggregator event is present. Null otherwise. |  [optional] |
|**dexRouter** | **String** | DEX router contract address (mirrors &#x60;toAddress&#x60;). Null when no aggregator event is present. |  [optional] |
|**fromTokenDetails** | [**List&lt;GetTransactionStatusResponseDataFromTokenDetailsInner&gt;**](GetTransactionStatusResponseDataFromTokenDetailsInner.md) | Sell-token details. Populated when an aggregator event is present; null otherwise. |  [optional] |
|**toTokenDetails** | [**List&lt;GetTransactionStatusResponseDataToTokenDetailsInner&gt;**](GetTransactionStatusResponseDataToTokenDetailsInner.md) | Buy-token details. Populated when an aggregator event is present; null otherwise. |  [optional] |



