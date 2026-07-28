

# SimulateTransactionsRequestEvmTx

EVM transaction payload. Required when `binanceChainId` belongs to an EVM chain.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**from** | **String** | Sender address. |  |
|**to** | **String** | Destination address (contract or EOA). |  |
|**value** | **String** | Native token amount in wei (integer string). |  |
|**data** | **String** | ABI-encoded calldata (hex). Optional. |  |



