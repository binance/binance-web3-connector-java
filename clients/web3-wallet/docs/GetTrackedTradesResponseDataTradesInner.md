

# GetTrackedTradesResponseDataTradesInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**txHash** | **String** | On-chain transaction hash. |  [optional] |
|**walletAddress** | **String** | Wallet address that initiated this trade. EVM addresses are lowercase; Solana addresses are case-sensitive. |  [optional] |
|**tokenSymbol** | **String** | Symbol of the traded token. |  [optional] |
|**tokenContractAddress** | **String** | Contract address of the traded token. EVM addresses are lowercase; Solana addresses are case-sensitive. |  [optional] |
|**binanceChainId** | **String** | Unique chain identifier of the traded token. |  [optional] |
|**tokenPrice** | **String** | Token price at the time of this trade, denominated in USD. |  [optional] |
|**marketCap** | **String** | Token market cap at the time of this trade, denominated in USD. |  [optional] |
|**tradeType** | **String** | Trade type. 1&#x3D;Buy, 2&#x3D;Sell, 3&#x3D;Add position, 4&#x3D;Reduce position, 5&#x3D;Open position, 6&#x3D;Close position, 7&#x3D;Transfer in, 8&#x3D;Transfer out. |  [optional] |
|**tradeTime** | **String** | On-chain time of this trade, Unix millisecond timestamp. |  [optional] |



