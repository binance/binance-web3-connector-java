

# DefiTxResponseDataListInner

A single unsigned transaction to sign and broadcast. The dataList is ordered: APPROVE items precede the main action. The shape depends on the chain family. EVM chains: return to / value (hex) and hex calldata in data. The list may contain an ERC-20 APPROVE item followed by the main action — sign and broadcast each in order. Solana (binanceChainId = \"CT_501\"): returns a base64-serialized wire transaction in data. The compute-budget fee is injected server-side for every action, so do not add ComputeBudget or priority-fee instructions yourself (see Integration Flow). to and value are null (Solana has no EVM to / value concept). The list is always exactly one item and never contains APPROVE (Solana has no ERC-20 allowance concept). Sign it as a Solana VersionedTransaction. Number-format conventions for this object: on EVM chains value is a 0x-prefixed hex string; gasLimit, gasPrice, maxPriorityFeePerGas, and maxFeePerGas are decimal strings. Mixed hex/decimal within the same object is by design (it mirrors the on-chain transaction fields); always parse gas fields with base-10 and value with base-16. On Solana value is null; gasLimit is the compute-unit limit and gasPrice is the per-compute-unit micro-lamport fee (both decimal strings). EIP-1559 and legacy gas fields (EVM): on BSC build responses populate maxFeePerGas and maxPriorityFeePerGas; gasPrice is null. Other supported EVM chains may populate either set — use the 1559 fields when present and fall back to gasPrice when it carries a value. The nullable markers below are retained so the schema also describes legacy-only chains. maxPriorityFeePerGas and maxFeePerGas are null on Solana.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**callDataType** | [**CallDataTypeEnum**](#CallDataTypeEnum) | Action kind of this item: - &#x60;APPROVE&#x60; — ERC-20 approval (EVM only), must be signed/broadcast and confirmed before the   main action. Never returned for Solana. - &#x60;DEPOSIT&#x60; / &#x60;REDEEM&#x60; / &#x60;LP_ADD&#x60; / &#x60;LP_REMOVE&#x60; / &#x60;CLAIM&#x60; — the main action.   &#x60;LP_ADD&#x60; / &#x60;LP_REMOVE&#x60; are the LP add / remove legs (the same build path as   deposit / redeem for liquidity-pool investments; the kind reflects the on-chain action,   not the entry endpoint). |  [optional] |
|**from** | **String** | User wallet address (the signer / sender). EIP-55 checksummed on EVM chains — normalize with &#x60;to_checksum_address&#x60; before signing if your signer requires it. On Solana this is the base58 fee-payer public key. |  [optional] |
|**to** | **String** | Target contract address. EIP-55 checksummed on EVM chains, same format as &#x60;from&#x60;. Non-null on EVM; &#x60;null&#x60; on Solana (Solana expresses the target program inside the serialized transaction in &#x60;data&#x60;, not here). |  [optional] |
|**value** | **String** | Native-asset value as a &#x60;0x&#x60;-prefixed hex string. Non-null on EVM; &#x60;null&#x60; on Solana. |  [optional] |
|**data** | **String** | Serialized transaction data. On EVM chains a &#x60;0x&#x60;-prefixed hex calldata string. On Solana a base64-serialized wire transaction (compute-budget fee injected server-side for every action). |  [optional] |
|**gasLimit** | **String** | Suggested gas limit on EVM (decimal string, gas units). On Solana it is the estimated compute-unit **consumption**; the transaction&#39;s actual compute-unit limit set on-chain is roughly 1.2× this value. &#x60;null&#x60; when estimation fails. |  [optional] |
|**gasPrice** | **String** | Legacy gas price on EVM, decimal string. &#x60;null&#x60; on EIP-1559 chains such as BSC (use &#x60;maxFeePerGas&#x60; / &#x60;maxPriorityFeePerGas&#x60; instead). On Solana this is the per-compute-unit fee in micro-lamports (decimal string). |  [optional] |
|**maxPriorityFeePerGas** | **String** | EIP-1559 priority fee in wei (decimal string). &#x60;null&#x60; on non-1559 EVM chains and on Solana. |  [optional] |
|**maxFeePerGas** | **String** | EIP-1559 max fee per gas in wei (decimal string). &#x60;null&#x60; on non-1559 EVM chains and on Solana. |  [optional] |



## Enum: CallDataTypeEnum

| Name | Value |
|---- | -----|
| APPROVE | &quot;APPROVE&quot; |
| DEPOSIT | &quot;DEPOSIT&quot; |
| REDEEM | &quot;REDEEM&quot; |
| LP_ADD | &quot;LP_ADD&quot; |
| LP_REMOVE | &quot;LP_REMOVE&quot; |
| CLAIM | &quot;CLAIM&quot; |



