

# GetGasLimitRequestTronTx

Tron transaction payload. Required when `binanceChainId=CT_195`.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**from** | **String** | Sender address (base58check). |  |
|**txType** | [**TxTypeEnum**](#TxTypeEnum) | Tron contract type. &#x60;TRIGGER_SMART_CONTRACT&#x60; requires &#x60;triggerSmartContractParams&#x60;; &#x60;TRANSFER_CONTRACT&#x60; requires &#x60;transferContractParams&#x60;. |  |
|**triggerSmartContractParams** | [**GetGasLimitRequestTronTxTriggerSmartContractParams**](GetGasLimitRequestTronTxTriggerSmartContractParams.md) |  |  [optional] |
|**transferContractParams** | [**GetGasLimitRequestTronTxTransferContractParams**](GetGasLimitRequestTronTxTransferContractParams.md) |  |  [optional] |



## Enum: TxTypeEnum

| Name | Value |
|---- | -----|
| TRIGGER_SMART_CONTRACT | &quot;TRIGGER_SMART_CONTRACT&quot; |
| TRANSFER_CONTRACT | &quot;TRANSFER_CONTRACT&quot; |



