

# BroadcastTransactionsRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana, \&quot;CT_195\&quot;&#x3D;Tron). |  |
|**signedTransaction** | **String** | Client-signed raw transaction. Format depends on &#x60;binanceChainId&#x60;:  - **EVM chains**: hex-encoded RLP transaction (e.g. &#x60;0xf86c...&#x60;). - **Solana (&#x60;CT_501&#x60;)**: base64-encoded signed transaction. - **Tron (&#x60;CT_195&#x60;)**: JSON string of the signed transaction   returned by a Tron signer, containing &#x60;raw_data&#x60; (with   &#x60;contract[].parameter.value.owner_address&#x60;) and a &#x60;signature&#x60;   array. Example:   &#x60;{\&quot;raw_data\&quot;:{\&quot;contract\&quot;:[{\&quot;type\&quot;:\&quot;TriggerSmartContract\&quot;,\&quot;parameter\&quot;:{\&quot;value\&quot;:{\&quot;owner_address\&quot;:\&quot;T...\&quot;,\&quot;contract_address\&quot;:\&quot;T...\&quot;,\&quot;data\&quot;:\&quot;&lt;calldata hex&gt;\&quot;,\&quot;call_value\&quot;:0}}}]},\&quot;signature\&quot;:[\&quot;...\&quot;]}&#x60;.   Note for Tron: &#x60;signedTransaction&#x60; is NOT the calldata hex passed to &#x60;simulate&#x60; / &#x60;getGasLimit&#x60; under &#x60;tronTx.triggerSmartContractParams.data&#x60;. The signer is extracted from &#x60;raw_data.contract[0].parameter.value.owner_address&#x60; and must match &#x60;address&#x60;; passing calldata hex here will be rejected with &#x60;code&#x3D;40001, invalid signedTransaction: failed to parse Tron signedTransaction: syntax error&#x60;. |  |
|**address** | **String** | Sender wallet address. Used for status attribution and signature verification. On Tron and Solana the address is case-sensitive base58check. |  |
|**enableMevProtection** | **Boolean** | When true, route the transaction through a private mempool for MEV protection. |  [optional] |



