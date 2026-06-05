

# GetGasLimitRequestEvmTx

EVM transaction payload. Required when `binanceChainId` belongs to an EVM chain.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**from** | **String** | Sender address. |  |
|**to** | **String** | Destination address (contract or EOA). |  |
|**value** | **String** | Native token amount in wei (integer string). Use \&quot;0\&quot; for ERC-20 transfers. |  |
|**data** | **String** | ABI-encoded calldata (hex). Optional when no contract call is involved. |  [optional] |



