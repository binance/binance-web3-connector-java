

# GetGasPriceResponseDataEip1559GasPrice

EIP-1559 fee structure (wei, integer strings). Null on chains that don't support EIP-1559 or non-EVM chains.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**baseFee** | **String** | Current block base fee in wei. |  [optional] |
|**lowPriorityFee** | **String** | Slow tier max priority fee per gas (wei). |  [optional] |
|**lowMaxFee** | **String** | Slow tier max fee per gas (wei). |  [optional] |
|**mediumPriorityFee** | **String** | Average tier max priority fee per gas (wei). |  [optional] |
|**mediumMaxFee** | **String** | Average tier max fee per gas (wei). |  [optional] |
|**highPriorityFee** | **String** | Fast tier max priority fee per gas (wei). |  [optional] |
|**highMaxFee** | **String** | Fast tier max fee per gas (wei). |  [optional] |



