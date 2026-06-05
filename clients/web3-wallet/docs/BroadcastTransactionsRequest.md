

# BroadcastTransactionsRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). |  |
|**signedTransaction** | **String** | Client-signed raw transaction. EVM chains use a hex-encoded RLP transaction; Solana uses a base64-encoded signed transaction. |  |
|**address** | **String** | Sender wallet address. Used for status attribution and signature verification. |  |
|**enableMevProtection** | **Boolean** | When true, route the transaction through a private mempool for MEV protection. |  [optional] |



