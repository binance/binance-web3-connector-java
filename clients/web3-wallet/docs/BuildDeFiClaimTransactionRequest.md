

# BuildDeFiClaimTransactionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**address** | **String** | User wallet address (the signer / sender). |  |
|**binanceChainId** | **String** | Binance chain ID. For &#x60;REWARD_PROTOCOL&#x60; (which does not use &#x60;investmentId&#x60;) this is the only chain signal and is required. For all other claim types the chain is resolved from &#x60;investmentId&#x60; and any client-supplied value is silently ignored — the call still executes on the &#x60;investmentId&#x60; chain, so a different chainId does not redirect the claim. |  [optional] |
|**claimType** | [**ClaimTypeEnum**](#ClaimTypeEnum) | Claim routing type. Determines which companion fields are required: - &#x60;REWARD_PROTOCOL&#x60;: protocol-level rewards (e.g. Aave incentive, Radiant) — requires &#x60;defiProtocolId&#x60; + &#x60;binanceChainId&#x60; - &#x60;REWARD_INVESTMENT&#x60;: per-investment rewards — requires &#x60;investmentId&#x60; - &#x60;LP_FEE&#x60;: Uniswap V3/V4 LP fees — requires &#x60;investmentId&#x60; + &#x60;nftId&#x60; - &#x60;REDEMPTION&#x60;: redeem principal (Lista / Aster / Solv etc.) — requires &#x60;investmentId&#x60; + &#x60;redemptionId&#x60;  **Protocol constraints** — not every &#x60;claimType&#x60; is valid for every protocol; an invalid combination is rejected (&#x60;40453&#x60; or &#x60;40454&#x60;): - &#x60;REWARD_PROTOCOL&#x60; is **not** supported for LP (liquidity-pool) protocols in this release. - &#x60;REWARD_INVESTMENT&#x60; is not supported for PancakeSwap V3 farming positions; use &#x60;LP_FEE&#x60;   to claim farming incentives there. - &#x60;LP_FEE&#x60; applies only to concentrated-liquidity (V3/V4) LP positions. - &#x60;REDEMPTION&#x60; applies only to protocols with a redemption / lock-up flow (Lista, Aster, Solv).  The valid &#x60;claimType&#x60;s for a specific position are returned in that position&#39;s &#x60;positionDetail.claimTypes&#x60; (see the position list) — branch on that rather than hard-coding the mapping. Note: error messages may surface the protocol id with a chain prefix (e.g. &#x60;bsc_pancakeswap4&#x60;); the canonical id in API fields is the un-prefixed form (e.g. &#x60;pancakeswap4&#x60;). |  |
|**investmentId** | **String** | Required for &#x60;REWARD_INVESTMENT&#x60;, &#x60;LP_FEE&#x60;, and &#x60;REDEMPTION&#x60;. Not used for &#x60;REWARD_PROTOCOL&#x60; (which keys off &#x60;defiProtocolId&#x60;). |  [optional] |
|**defiProtocolId** | **String** | Required for &#x60;REWARD_PROTOCOL&#x60; (e.g. &#x60;pancakeswap3&#x60;). |  [optional] |
|**nftId** | **String** | Required for &#x60;LP_FEE&#x60;. The NFT token ID as a decimal string (e.g. &#x60;\&quot;7225901\&quot;&#x60; or &#x60;\&quot;#7225901\&quot;&#x60;). The &#x60;#&#x60; prefix returned by the position list may be passed as-is — the service strips it automatically. |  [optional] |
|**redemptionId** | **String** | Required for &#x60;REDEMPTION&#x60;. Maps to the &#x60;redemptionId&#x60; returned in the position list (the on-line position index). |  [optional] |
|**tokenAddressList** | **List&lt;String&gt;** | Optional token address filter to narrow the claim scope. |  [optional] |
|**simulate** | **Boolean** | When &#x60;true&#x60;, the response also includes a &#x60;preview&#x60; object. Default &#x60;false&#x60;. If the simulated transaction reverts, the request returns &#x60;40485&#x60; for a specific classified revert reason or &#x60;40484&#x60; for any other revert (see Error Codes). |  [optional] |



## Enum: ClaimTypeEnum

| Name | Value |
|---- | -----|
| REWARD_PROTOCOL | &quot;REWARD_PROTOCOL&quot; |
| REWARD_INVESTMENT | &quot;REWARD_INVESTMENT&quot; |
| LP_FEE | &quot;LP_FEE&quot; |
| REDEMPTION | &quot;REDEMPTION&quot; |



