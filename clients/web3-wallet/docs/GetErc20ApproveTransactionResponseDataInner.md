

# GetErc20ApproveTransactionResponseDataInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**data** | **String** | ABI-encoded calldata for the ERC-20 &#x60;approve()&#x60; call. Selector + padded spender + padded amount. |  [optional] |
|**dexContractAddress** | **String** | DEX router contract address (the spender in the &#x60;approve()&#x60; call). Configured per chain. |  [optional] |
|**gasLimit** | **String** | Gas limit ceiling for the approve transaction (integer string, gas units). |  [optional] |
|**gasPrice** | **String** | Gas price for the approve transaction (integer string, wei). |  [optional] |



