

# BuildDeFiRedeemTransactionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**address** | **String** | User wallet address (the signer / sender). |  |
|**investmentId** | **String** | Investment product ID (chain-agnostic). The service resolves the chain from this ID. |  |
|**token** | [**BuildDeFiRedeemTransactionRequestToken**](BuildDeFiRedeemTransactionRequestToken.md) |  |  [optional] |
|**ratio** | **String** | Redeem ratio, mutually exclusive with &#x60;token&#x60;. Omitted / blank → exact-amount redeem via &#x60;token&#x60; (&#x60;tokenAddress&#x60; + &#x60;amount&#x60;, position not queried). Present → must parse as a decimal in &#x60;(0, 1]&#x60;; the service queries the on-chain position under &#x60;investmentId&#x60; and scales each token amount by &#x60;ratio&#x60; (floored to decimals). &#x60;\&quot;1\&quot;&#x60; &#x3D; full (max) redeem; in this mode &#x60;token&#x60; is ignored. |  [optional] |
|**slippageBps** | **String** | Slippage tolerance in basis points (e.g. &#x60;300&#x60; &#x3D; 3%). |  [optional] |
|**simulate** | **Boolean** | When &#x60;true&#x60;, the response also includes a &#x60;preview&#x60; object. Default &#x60;false&#x60;. If the simulated transaction reverts, the request returns an error code instead of a &#x60;200&#x60; with &#x60;preview.success&#x3D;false&#x60;: &#x60;40485&#x60; when the redeem amount exceeds the current position, &#x60;40484&#x60; for any other revert (see Error Codes). |  [optional] |



