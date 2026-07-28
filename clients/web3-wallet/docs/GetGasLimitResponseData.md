

# GetGasLimitResponseData

Estimated gas limit. On Tron, the response additionally carries energy/bandwidth fields; non-applicable fields are returned as `null`.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**gasLimit** | **String** | Estimated gas limit (EVM), compute-unit ceiling (Solana), or fee limit in sun (Tron), as an integer string. |  [optional] |
|**energyRequired** | **String** | Energy consumed by the Tron transaction (integer string). Null on non-Tron chains. |  [optional] |
|**bandwidthRequired** | **String** | Bandwidth consumed by the Tron transaction (integer string). Null on non-Tron chains. |  [optional] |
|**freeEnergy** | **String** | Free energy available to the account on Tron (integer string). Null on non-Tron chains. |  [optional] |
|**freeBandwidth** | **String** | Free bandwidth available to the account on Tron (integer string). Null on non-Tron chains. |  [optional] |
|**energyFee** | **String** | Unit price of energy on Tron (sun per energy, integer string). Null on non-Tron chains. |  [optional] |
|**bandwidthFee** | **String** | Unit price of bandwidth on Tron (sun per byte, integer string). Null on non-Tron chains. |  [optional] |



