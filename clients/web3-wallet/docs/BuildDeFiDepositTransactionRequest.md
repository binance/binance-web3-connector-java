

# BuildDeFiDepositTransactionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**address** | **String** | User wallet address (the signer / sender). |  |
|**investmentId** | **String** | Investment product ID (chain-agnostic). The service resolves the chain from this ID. |  |
|**token** | [**BuildDeFiDepositTransactionRequestToken**](BuildDeFiDepositTransactionRequestToken.md) |  |  |
|**simulate** | **Boolean** | When &#x60;true&#x60;, the response also includes a &#x60;preview&#x60; object. Default &#x60;false&#x60;. If the simulated transaction reverts, the request returns &#x60;40485&#x60; for a specific classified revert reason or &#x60;40484&#x60; for any other revert (see Error Codes). |  [optional] |



