

# GetTransactionDetailByHashResponseDataInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chainIndex** | **String** | Chain identifier. |  [optional] |
|**height** | **String** | Block height (decimal string). |  [optional] |
|**txTime** | **String** | Transaction time (Unix milliseconds, string form). |  [optional] |
|**txhash** | **String** | On-chain transaction hash. |  [optional] |
|**txStatus** | **String** | Transaction status. One of: \&quot;success\&quot;, \&quot;fail\&quot;, \&quot;pending\&quot;. |  [optional] |
|**gasLimit** | **String** | Gas limit (decimal string). |  [optional] |
|**gasUsed** | **String** | Gas actually consumed. |  [optional] |
|**gasPrice** | **String** | Gas price (wei, decimal string). |  [optional] |
|**txFee** | **String** | Transaction fee in the chain&#39;s native token. |  [optional] |
|**nonce** | **String** | Sender nonce. |  [optional] |
|**amount** | **String** | Transaction amount. |  [optional] |
|**symbol** | **String** | Symbol of the transferred asset. |  [optional] |
|**methodId** | **String** | Contract method ID (function selector). Null for plain native-token transfers. |  [optional] |
|**l1OriginHash** | **String** | L1 origin transaction hash for rollup / L2 transactions; null otherwise. |  [optional] |
|**fromDetails** | [**List&lt;GetTransactionDetailByHashResponseDataInnerFromDetailsInner&gt;**](GetTransactionDetailByHashResponseDataInnerFromDetailsInner.md) | Transaction inputs (sender details). |  [optional] |
|**toDetails** | [**List&lt;GetTransactionDetailByHashResponseDataInnerToDetailsInner&gt;**](GetTransactionDetailByHashResponseDataInnerToDetailsInner.md) | Transaction outputs (receiver details). |  [optional] |
|**internalTransactionDetails** | [**List&lt;GetTransactionDetailByHashResponseDataInnerInternalTransactionDetailsInner&gt;**](GetTransactionDetailByHashResponseDataInnerInternalTransactionDetailsInner.md) | Internal transaction details. |  [optional] |
|**tokenTransferDetails** | [**List&lt;GetTransactionDetailByHashResponseDataInnerTokenTransferDetailsInner&gt;**](GetTransactionDetailByHashResponseDataInnerTokenTransferDetailsInner.md) | Token transfer details emitted by this transaction. |  [optional] |



