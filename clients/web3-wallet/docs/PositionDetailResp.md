

# PositionDetailResp

Position-level metadata. Present for concentrated-liquidity / locked / farming positions; null otherwise. Fields are null when not applicable to the position type.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**positionIndex** | **String** | Position index (e.g. the Uniswap-V3-style position number). |  [optional] |
|**nftId** | **String** | NFT token ID for concentrated-liquidity positions, prefixed with &#x60;#&#x60; (e.g. &#x60;\&quot;#7225901\&quot;&#x60;). Null for non-NFT positions. The &#x60;#&#x60; prefix may be passed as-is to a transaction build endpoint (&#x60;lp-add&#x60; / &#x60;lp-remove&#x60; / &#x60;claim&#x60; &#x60;LP_FEE&#x60;) — the service strips it automatically; passing the raw id without &#x60;#&#x60; is also accepted. |  [optional] |
|**unlockTime** | **String** | Unix timestamp (seconds) when the position unlocks. Null if no lock. |  [optional] |
|**unlockTimeReached** | **Boolean** | Whether the unlock time has been reached. |  [optional] |
|**tickLower** | **String** | Lower tick bound for concentrated-liquidity positions. |  [optional] |
|**tickUpper** | **String** | Upper tick bound for concentrated-liquidity positions. |  [optional] |
|**active** | **Boolean** | Whether the position is currently in-range (active). |  [optional] |
|**proofs** | **Map&lt;String, List&lt;String&gt;&gt;** | Merkle proofs keyed by reward token address. Required when claiming PancakeSwap Infinity (V4) rewards. |  [optional] |
|**stakeState** | **String** | Staking lifecycle state. Complete value set: active (earning), deactivating (unstaking in progress, rewards stop), inactive (fully unstaked). |  [optional] |
|**claimTypes** | [**List&lt;ClaimTypesEnum&gt;**](#List&lt;ClaimTypesEnum&gt;) | Claim types available for this position. Values map to the &#x60;claimType&#x60; field of &#x60;POST /transaction/claim&#x60; and determine which companion fields a claim requires. |  [optional] |
|**redemptionId** | **String** | Redemption record ID (for pending redemptions). Null when not a pending redemption. |  [optional] |



## Enum: List&lt;ClaimTypesEnum&gt;

| Name | Value |
|---- | -----|
| REWARD_PROTOCOL | &quot;REWARD_PROTOCOL&quot; |
| REWARD_INVESTMENT | &quot;REWARD_INVESTMENT&quot; |
| LP_FEE | &quot;LP_FEE&quot; |
| REDEMPTION | &quot;REDEMPTION&quot; |



