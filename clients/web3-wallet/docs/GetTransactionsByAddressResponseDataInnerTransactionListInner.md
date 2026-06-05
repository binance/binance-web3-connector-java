

# GetTransactionsByAddressResponseDataInnerTransactionListInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Chain identifier. |  [optional] |
|**txHash** | **String** | On-chain transaction hash. |  [optional] |
|**itype** | **String** | Transaction layer type. \&quot;0\&quot;&#x3D;outer native-token transfer, \&quot;1\&quot;&#x3D;internal contract native-token transfer, \&quot;2\&quot;&#x3D;token transfer. |  [optional] |
|**methodId** | **String** | Contract method ID (function selector). Null for plain native-token transfers. |  [optional] |
|**nonce** | **String** | Sender&#39;s nonce for this transaction. |  [optional] |
|**txTime** | **String** | Transaction time (Unix milliseconds, string form). |  [optional] |
|**from** | [**List&lt;GetTransactionsByAddressResponseDataInnerTransactionListInnerFromInner&gt;**](GetTransactionsByAddressResponseDataInnerTransactionListInnerFromInner.md) | Inputs (sender addresses and amounts). |  [optional] |
|**to** | [**List&lt;GetTransactionsByAddressResponseDataInnerTransactionListInnerToInner&gt;**](GetTransactionsByAddressResponseDataInnerTransactionListInnerToInner.md) | Outputs (receiver addresses and amounts). |  [optional] |
|**tokenContractAddress** | **String** | Token contract address. Null for native-token transfers. |  [optional] |
|**amount** | **String** | Transaction amount in the token&#39;s smallest unit. |  [optional] |
|**symbol** | **String** | Symbol of the transferred asset. |  [optional] |
|**txFee** | **String** | Transaction fee (native-token amount, decimal string). |  [optional] |
|**txStatus** | **String** | Transaction status. |  [optional] |
|**hitBlacklist** | **Boolean** | Whether the transaction matches a blacklist rule. |  [optional] |



