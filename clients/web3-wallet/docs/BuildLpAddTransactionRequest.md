

# BuildLpAddTransactionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**address** | **String** | User wallet address (the signer / sender). |  |
|**investmentId** | **String** | LP investment product ID (chain-agnostic). |  |
|**tokenList** | [**List&lt;BuildLpAddTransactionRequestTokenListInner&gt;**](BuildLpAddTransactionRequestTokenListInner.md) | Tokens to supply. Two tokens for a standard LP add. |  |
|**tickLower** | **String** | Lower tick bound (raw &#x60;int24&#x60;) for a new position. MUST be aligned to the pool&#39;s &#x60;tickSpacing&#x60;. Pick exactly one tick-range source: &#x60;tickLower&#x60;+&#x60;tickUpper&#x60;, &#x60;priceRange&#x60;, or &#x60;nftId&#x60; (to append to an existing position). If several are supplied, the lowest-priority ones are ignored (priority: &#x60;nftId&#x60; &gt; &#x60;priceRange&#x60; &gt; explicit tick pair). |  [optional] |
|**tickUpper** | **String** | Upper tick bound (raw &#x60;int24&#x60;) for a new position. MUST be aligned to the pool&#39;s &#x60;tickSpacing&#x60;. See &#x60;tickLower&#x60; for the pick-exactly-one rule. |  [optional] |
|**priceRange** | **String** | Price range as a percentage (e.g. &#x60;\&quot;5\&quot;&#x60; &#x3D; ±5%) for a new position. Alternative to &#x60;tickLower&#x60;+&#x60;tickUpper&#x60;; see &#x60;tickLower&#x60; for the pick-exactly-one rule. |  [optional] |
|**nftId** | **String** | LP NFT token ID, decimal string (e.g. &#x60;\&quot;7225901\&quot;&#x60; or &#x60;\&quot;#7225901\&quot;&#x60;). Required when appending to an existing position (reuses its range); omit for a new position. Highest-priority tick-range source — see &#x60;tickLower&#x60; for the pick-exactly-one rule. The &#x60;#&#x60; prefix returned by the position list may be passed as-is — the service strips it automatically. |  [optional] |
|**slippageBps** | **String** | Slippage tolerance for the LP leg, in basis points (e.g. &#x60;300&#x60; &#x3D; 3%). |  [optional] |
|**simulate** | **Boolean** | When &#x60;true&#x60;, the response also includes a &#x60;preview&#x60; object. Default &#x60;false&#x60;. If the simulated transaction reverts, the request returns &#x60;40485&#x60; for a specific classified revert reason or &#x60;40484&#x60; for any other revert (see Error Codes). |  [optional] |



