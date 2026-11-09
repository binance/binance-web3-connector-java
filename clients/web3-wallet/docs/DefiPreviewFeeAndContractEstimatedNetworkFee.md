

# DefiPreviewFeeAndContractEstimatedNetworkFee

Estimated gas cost for the action. Fields may be `null` when estimation is not available (e.g. a failed simulation).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **String** | Estimated gas fee in the fee-paying native coin (human-readable). On Solana this may be &#x60;null&#x60; even when fee estimation succeeded — use &#x60;valueUsd&#x60; as the reliable figure when &#x60;amount&#x60; is absent. |  [optional] |
|**tokenSymbol** | **String** | Symbol of the fee-paying token (native coin, e.g. BNB). |  [optional] |
|**valueUsd** | **String** | USD value of the estimated fee. |  [optional] |
|**rentFeeAmount** | **String** | Solana storage / rent fee portion (human-readable). &#x60;null&#x60; on EVM chains; only populated on Solana when the action creates an account (e.g. a first-time ATA). |  [optional] |
|**rentFeeValueUsd** | **String** | USD value of the Solana rent fee. &#x60;null&#x60; on EVM chains; Solana-only. |  [optional] |
|**priorityFeeAmount** | **String** | Solana priority fee portion (human-readable). &#x60;null&#x60; on EVM chains; Solana-only. |  [optional] |



