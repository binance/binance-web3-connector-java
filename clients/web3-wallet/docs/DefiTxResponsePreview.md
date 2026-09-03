

# DefiTxResponsePreview

Simulation result returned by the build endpoints when `simulate=true`. Includes whether the action is expected to succeed, the projected balance change, the estimated network fee, and — for lending protocols — the health-factor change. `balanceChange`, `feeAndContract`, `healthFactor`, and `warnings` each have a fixed structure (see below); the number of entries and some inner values vary by protocol.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**success** | **Boolean** | Whether the simulated transaction is expected to succeed on-chain. |  [optional] |
|**balanceChange** | [**List&lt;DefiPreviewBalanceChangeInner&gt;**](DefiPreviewBalanceChangeInner.md) | Signed token balance deltas from the simulation. Each entry has &#x60;tokenType&#x60;, &#x60;tokenSymbol&#x60;, &#x60;tokenAddress&#x60;, &#x60;tokenDecimals&#x60;, &#x60;amount&#x60; (positive &#x3D; received, negative &#x3D; spent), &#x60;valueUsd&#x60;, and an optional &#x60;tokenId&#x60;. |  [optional] |
|**feeAndContract** | [**DefiPreviewFeeAndContract**](DefiPreviewFeeAndContract.md) |  |  [optional] |
|**healthFactor** | [**DefiPreviewHealthFactor**](DefiPreviewHealthFactor.md) |  |  [optional] |
|**warnings** | [**List&lt;DefiPreviewWarningsInner&gt;**](DefiPreviewWarningsInner.md) | Non-blocking risk warnings. Empty array when there are no warnings. |  [optional] |
|**errorMessage** | **String** | Error message when the simulated transaction is expected to fail. |  [optional] |



