

# GetGasLimitRequestTronTxTriggerSmartContractParams

Required when `txType=TRIGGER_SMART_CONTRACT`.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**contractAddress** | **String** | Smart-contract address (base58check). |  |
|**data** | **String** | ABI-encoded calldata (hex, no &#x60;0x&#x60; prefix). |  |
|**callValue** | **Long** | Amount of TRX (in sun) to attach as &#x60;call_value&#x60;. |  |
|**feeLimitSun** | **Long** | Optional max fee the caller is willing to pay (in sun). If omitted, server default applies. |  [optional] |



