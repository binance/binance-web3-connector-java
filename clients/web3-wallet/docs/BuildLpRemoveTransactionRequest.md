

# BuildLpRemoveTransactionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**address** | **String** | User wallet address (the signer / sender). |  |
|**investmentId** | **String** | LP investment product ID (chain-agnostic). |  |
|**nftId** | **String** | LP NFT token ID identifying the position to remove, decimal string (e.g. &#x60;\&quot;7225901\&quot;&#x60; or &#x60;\&quot;#7225901\&quot;&#x60;). The &#x60;#&#x60; prefix returned by the position list may be passed as-is — the service strips it automatically. |  |
|**ratio** | **String** | Removal ratio in the range &#x60;(0, 1]&#x60; as a decimal string (e.g. &#x60;\&quot;0.04\&quot;&#x60;, &#x60;\&quot;1\&quot;&#x60;). |  |
|**slippageBps** | **String** | Slippage tolerance for the LP leg, in basis points (e.g. &#x60;300&#x60; &#x3D; 3%). |  [optional] |
|**simulate** | **Boolean** | When &#x60;true&#x60;, the response also includes a &#x60;preview&#x60; object. Default &#x60;false&#x60;. If the simulated transaction reverts, the request returns &#x60;40485&#x60; for a specific classified revert reason or &#x60;40484&#x60; for any other revert (see Error Codes). |  [optional] |



