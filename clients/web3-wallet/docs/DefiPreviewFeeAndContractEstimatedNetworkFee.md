

# DefiPreviewFeeAndContractEstimatedNetworkFee

Estimated gas cost for the action. Fields may be `null` when estimation is not available (e.g. a failed simulation).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **String** | Estimated gas fee in the gas-paying token (human-readable). |  [optional] |
|**tokenSymbol** | **String** | Symbol of the fee-paying token (native coin, e.g. BNB). |  [optional] |
|**valueUsd** | **String** | USD value of the estimated fee. |  [optional] |
|**rentFeeAmount** | **String** | Storage / rent fee portion (human-readable), if applicable. |  [optional] |
|**rentFeeValueUsd** | **String** | USD value of the storage / rent fee, if applicable. |  [optional] |
|**priorityFeeAmount** | **String** | Priority fee portion (human-readable), if broken out. |  [optional] |



