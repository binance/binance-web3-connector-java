

# BuildDeFiClaimTransactionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**address** | **String** | User wallet address (the signer / sender). |  |
|**binanceChainId** | **String** | Binance chain ID. For &#x60;REWARD_PROTOCOL&#x60; (which does not use &#x60;investmentId&#x60;) this is the only chain signal and is required. For all other claim types the chain is resolved from &#x60;investmentId&#x60; and any client-supplied value is silently ignored — the call still executes on the &#x60;investmentId&#x60; chain, so a different chainId does not redirect the claim. |  [optional] |
|**claimType** | [**ClaimTypeEnum**](#ClaimTypeEnum) | Claim routing type. Determines which companion fields are required: - &#x60;REWARD_PROTOCOL&#x60;: protocol-level rewards (e.g. Aave incentive, Radiant) — requires &#x60;defiProtocolId&#x60; + &#x60;binanceChainId&#x60; - &#x60;REWARD_INVESTMENT&#x60;: per-investment rewards — requires &#x60;investmentId&#x60; - &#x60;LP_FEE&#x60;: Uniswap V3/V4 LP fees — requires &#x60;investmentId&#x60; + &#x60;nftId&#x60; - &#x60;REDEMPTION&#x60;: redeem principal. Requires &#x60;investmentId&#x60; + &#x60;redemptionId&#x60; for EVM protocols   (Lista, Aster, Solv) and for Solana protocols whose redeem mints a withdrawal ticket   (&#x60;renzo&#x60;, &#x60;marinadefinance&#x60; liquid, &#x60;jito&#x60;, &#x60;solayer&#x60;, &#x60;fragmetric&#x60;, &#x60;jupiter&#x60; Stake JUP) — the   &#x60;redemptionId&#x60; comes from the position list and is populated once the cooldown ends   (&#x60;unlockTimeReached &#x3D; true&#x60;). For Solana native staking (&#x60;sol_staking&#x60;) and Jupiter jupSOL   (whose claim handle surfaces under &#x60;sol_staking&#x60;), substitute &#x60;stakeAccounts&#x60; for   &#x60;redemptionId&#x60; (no redemption record).  **Protocol constraints** — not every &#x60;claimType&#x60; is valid for every protocol; an invalid combination is rejected (&#x60;40453&#x60; or &#x60;40454&#x60;): - &#x60;REWARD_PROTOCOL&#x60; is **not** supported for LP (liquidity-pool) protocols in this release. - &#x60;REWARD_INVESTMENT&#x60; is not supported for PancakeSwap V3 farming positions; use &#x60;LP_FEE&#x60;   to claim farming incentives there. - &#x60;LP_FEE&#x60; applies only to concentrated-liquidity (V3/V4) LP positions, including Solana   CLMM (&#x60;raydium3&#x60;, &#x60;orca3&#x60;). - &#x60;REDEMPTION&#x60; applies only to protocols with a redemption / lock-up flow: EVM Lista /   Aster / Solv, and on Solana &#x60;sol_staking&#x60;, &#x60;renzo&#x60;, &#x60;marinadefinance&#x60;,   &#x60;jito&#x60;, &#x60;solayer&#x60;, &#x60;fragmetric&#x60;, and &#x60;jupiter&#x60; stake surfaces. - Some Solana protocols auto-compound rewards into the position value (e.g. &#x60;sol_staking&#x60;,   &#x60;marinadefinance&#x60;, &#x60;jito&#x60;); their &#x60;claimReward&#x60; (&#x60;REWARD_PROTOCOL&#x60; /   &#x60;REWARD_INVESTMENT&#x60;) is not supported and is rejected with &#x60;40481&#x60;.  For a given position, prefer the &#x60;claimTypes&#x60; / &#x60;redemptionId&#x60; / &#x60;userStakeAccount&#x60; fields returned by the position list to decide the claim path — see Integration Flow. |  |
|**investmentId** | **String** | Required for &#x60;REWARD_INVESTMENT&#x60;, &#x60;LP_FEE&#x60;, and &#x60;REDEMPTION&#x60;. Not used for &#x60;REWARD_PROTOCOL&#x60; (which keys off &#x60;defiProtocolId&#x60;). |  [optional] |
|**defiProtocolId** | **String** | Required for &#x60;REWARD_PROTOCOL&#x60; (e.g. &#x60;pancakeswap3&#x60;). |  [optional] |
|**nftId** | **String** | Required for &#x60;LP_FEE&#x60;. The NFT token ID as a decimal string (e.g. &#x60;\&quot;7225901\&quot;&#x60; or &#x60;\&quot;#7225901\&quot;&#x60;). The &#x60;#&#x60; prefix returned by the position list may be passed as-is — the service strips it automatically. |  [optional] |
|**redemptionId** | **String** | Required for &#x60;REDEMPTION&#x60; on EVM and on the Solana protocols whose redeem mints a withdrawal ticket / record (&#x60;renzo&#x60;, &#x60;marinadefinance&#x60; liquid, &#x60;jito&#x60;, &#x60;solayer&#x60;, &#x60;fragmetric&#x60;, &#x60;jupiter&#x60; Stake JUP). Maps to the &#x60;redemptionId&#x60; returned in the position list (the on-line position index), and is only populated once the cooldown ends (&#x60;unlockTimeReached &#x3D; true&#x60;; &#x60;null&#x60; while cooling down). For Solana native staking (&#x60;sol_staking&#x60;) and Jupiter jupSOL (&#x60;jupiter&#x60; stake surfaces) under &#x60;REDEMPTION&#x60;, pass &#x60;stakeAccounts&#x60; instead — these have no redemption record, so &#x60;redemptionId&#x60; becomes optional when &#x60;stakeAccounts&#x60; is supplied. |  [optional] |
|**stakeAccounts** | **List&lt;String&gt;** | Base58 stake account address(es) — the account(s) to withdraw after the deactivation cooldown. Required for &#x60;REDEMPTION&#x60; on Solana native staking (&#x60;sol_staking&#x60;) and Jupiter jupSOL (claimed under &#x60;sol_staking&#x60; in the position list; pass the &#x60;sol_staking&#x60; or the jupSOL &#x60;investmentId&#x60; + this address). Makes &#x60;redemptionId&#x60; optional for these (no redemption record). Do **not** pass &#x60;stakeAccounts&#x60; for Stake JUP (&#x60;jupiter&#x60; &#x60;stake_jup&#x60;) — it uses &#x60;redemptionId&#x60;, and passing &#x60;stakeAccounts&#x60; builds a transaction that fails on-chain. Passing &#x60;stakeAccounts&#x60; for any other protocol (EVM, LP, or other Solana protocols whose redeem produces a ticket — those use &#x60;redemptionId&#x60;) is also a parameter error. This release supports exactly one element (length at most 1). |  [optional] |
|**tokenAddressList** | **List&lt;String&gt;** | Optional token address filter to narrow the claim scope. |  [optional] |
|**simulate** | **Boolean** | When &#x60;true&#x60;, the response also includes a &#x60;preview&#x60; object. Default &#x60;false&#x60;. If the simulated transaction reverts, the request returns &#x60;40485&#x60; for a specific classified revert reason or &#x60;40484&#x60; for any other revert (see Error Codes). |  [optional] |



## Enum: ClaimTypeEnum

| Name | Value |
|---- | -----|
| REWARD_PROTOCOL | &quot;REWARD_PROTOCOL&quot; |
| REWARD_INVESTMENT | &quot;REWARD_INVESTMENT&quot; |
| LP_FEE | &quot;LP_FEE&quot; |
| REDEMPTION | &quot;REDEMPTION&quot; |



