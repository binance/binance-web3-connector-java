

# PositionDetailResp

Position-level metadata. Present for concentrated-liquidity / locked / farming positions; null otherwise. Fields are null when not applicable to the position type.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**positionIndex** | **String** | Position index / handle. For EVM concentrated-liquidity positions this is the Uniswap-V3-style position number. For Solana protocols whose redeem mints a withdrawal ticket (e.g. &#x60;renzo&#x60;, &#x60;marinadefinance&#x60; liquid, &#x60;jito&#x60;), this is the ticket / record PDA and is what &#x60;claim&#x60; &#x60;REDEMPTION&#x60; takes as &#x60;redemptionId&#x60; once the cooldown ends. For Jupiter Lend Borrow (&#x60;jupiter&#x60;, surface &#x60;lend_borrow_supply&#x60;), this is the position PDA passed to &#x60;redeem&#x60; as &#x60;positionAddress&#x60;. |  [optional] |
|**nftId** | **String** | NFT token ID for concentrated-liquidity positions, prefixed with &#x60;#&#x60; (e.g. &#x60;\&quot;#7225901\&quot;&#x60;). Null for non-NFT positions. The &#x60;#&#x60; prefix may be passed as-is to a transaction build endpoint (&#x60;lp-add&#x60; / &#x60;lp-remove&#x60; / &#x60;claim&#x60; &#x60;LP_FEE&#x60;) — the service strips it automatically; passing the raw id without &#x60;#&#x60; is also accepted. |  [optional] |
|**unlockTime** | **String** | Unix timestamp (seconds) when the position unlocks. Null if no lock. |  [optional] |
|**unlockTimeReached** | **Boolean** | Whether the unlock time has been reached. |  [optional] |
|**tickLower** | **String** | Lower tick bound for concentrated-liquidity positions. |  [optional] |
|**tickUpper** | **String** | Upper tick bound for concentrated-liquidity positions. |  [optional] |
|**active** | **Boolean** | Whether the position is currently in-range (active). |  [optional] |
|**proofs** | **Map&lt;String, List&lt;String&gt;&gt;** | Merkle proofs keyed by reward token address. Required when claiming PancakeSwap Infinity (V4) rewards. |  [optional] |
|**stakeState** | **String** | Staking lifecycle state. Complete value set: active (earning), deactivating (unstaking in progress, rewards stop), inactive (fully unstaked). |  [optional] |
|**claimTypes** | [**List&lt;ClaimTypesEnum&gt;**](#List&lt;ClaimTypesEnum&gt;) | Claim types available for this position. Values map to the &#x60;claimType&#x60; field of &#x60;POST /transaction/claim&#x60; and determine which companion fields a claim requires. |  [optional] |
|**redemptionId** | **String** | Redemption record ID (the withdrawal ticket / record handle) for pending redemptions. For Solana protocols whose redeem mints a ticket (&#x60;renzo&#x60;, &#x60;marinadefinance&#x60; liquid, &#x60;jito&#x60;, &#x60;jupiter&#x60; Stake JUP), this mirrors &#x60;positionIndex&#x60; and is populated only after the cooldown ends (&#x60;unlockTimeReached &#x3D; true&#x60;); &#x60;null&#x60; while cooling down — poll the position list until it appears, then pass it to &#x60;claim&#x60; &#x60;REDEMPTION&#x60;. Null when not a pending redemption. |  [optional] |
|**userStakeAccount** | **String** | Base58 stake account address for Solana native staking (&#x60;sol_staking&#x60;), or the native stake account a Jupiter jupSOL redeem created (which also surfaces under &#x60;sol_staking&#x60; in the position list — its &#x60;redemptionId&#x60; equals this address). Pass it to &#x60;redeem&#x60; / &#x60;claim&#x60; &#x60;REDEMPTION&#x60; as the single element of &#x60;stakeAccounts&#x60;; for jupSOL either the &#x60;sol_staking&#x60; or the jupSOL &#x60;investmentId&#x60; works. Null for non-staking positions. |  [optional] |



## Enum: List&lt;ClaimTypesEnum&gt;

| Name | Value |
|---- | -----|
| REWARD_PROTOCOL | &quot;REWARD_PROTOCOL&quot; |
| REWARD_INVESTMENT | &quot;REWARD_INVESTMENT&quot; |
| LP_FEE | &quot;LP_FEE&quot; |
| REDEMPTION | &quot;REDEMPTION&quot; |



