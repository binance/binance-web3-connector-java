

# DefiCallDataItem

A single unsigned transaction to sign and broadcast. The `dataList` is ordered: APPROVE items precede the main action. EVM chains return `to`/`value` (hex) and hex calldata in `data`. **Number-format conventions for this object** — `value` is a `0x`-prefixed hex string; `gasLimit`, `gasPrice`, `maxPriorityFeePerGas`, and `maxFeePerGas` are decimal strings. Mixed hex/decimal within the same object is by design (it mirrors the on-chain transaction fields); always parse gas fields with base-10 and `value` with base-16. **BSC and EIP-1559**: this release is BSC only. BSC is an EIP-1559 chain, so build responses populate `maxFeePerGas` and `maxPriorityFeePerGas`; `gasPrice` is `null` (legacy-only). The nullable markers below are retained so the schema also describes non-1559 chains in later releases — on BSC the 1559 fields are present and the legacy `gasPrice` is `null`. `to` and `value` are non-null for every action item on BSC.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**callDataType** | [**CallDataTypeEnum**](#CallDataTypeEnum) | Action kind of this item: - &#x60;APPROVE&#x60; — ERC-20 approval, must be signed/broadcast and confirmed before the main action - &#x60;DEPOSIT&#x60; / &#x60;REDEEM&#x60; / &#x60;LP_ADD&#x60; / &#x60;LP_REMOVE&#x60; / &#x60;CLAIM&#x60; — the main action.   &#x60;LP_ADD&#x60; / &#x60;LP_REMOVE&#x60; are the LP add / remove legs (the same build path as   deposit / redeem for liquidity-pool investments; the kind reflects the on-chain action,   not the entry endpoint). |  [optional] |
|**from** | **String** | User wallet address (the signer / sender). EIP-55 checksummed — normalize with &#x60;to_checksum_address&#x60; before signing if your signer requires it. |  [optional] |
|**to** | **String** | Target contract address. EIP-55 checksummed, same format as &#x60;from&#x60;. Non-null on BSC for every action item. |  [optional] |
|**value** | **String** | Native-asset value as a &#x60;0x&#x60;-prefixed hex string. Non-null on BSC for action items. |  [optional] |
|**data** | **String** | Serialized transaction data, as a &#x60;0x&#x60;-prefixed hex calldata string. |  [optional] |
|**gasLimit** | **String** | Suggested gas limit (decimal string). &#x60;null&#x60; when estimation fails. |  [optional] |
|**gasPrice** | **String** | Legacy gas price, decimal string. &#x60;null&#x60; on EIP-1559 chains such as BSC (use &#x60;maxFeePerGas&#x60; / &#x60;maxPriorityFeePerGas&#x60; instead). |  [optional] |
|**maxPriorityFeePerGas** | **String** | EIP-1559 priority fee in wei (decimal string). &#x60;null&#x60; on non-1559 chains. |  [optional] |
|**maxFeePerGas** | **String** | EIP-1559 max fee per gas in wei (decimal string). &#x60;null&#x60; on non-1559 chains. |  [optional] |



## Enum: CallDataTypeEnum

| Name | Value |
|---- | -----|
| APPROVE | &quot;APPROVE&quot; |
| DEPOSIT | &quot;DEPOSIT&quot; |
| REDEEM | &quot;REDEEM&quot; |
| LP_ADD | &quot;LP_ADD&quot; |
| LP_REMOVE | &quot;LP_REMOVE&quot; |
| CLAIM | &quot;CLAIM&quot; |



