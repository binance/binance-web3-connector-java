

# GetDexTradeHistoryResponseDataTransactionListInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** | Trade type. 1&#x3D;Buy, 2&#x3D;Sell. |  [optional] |
|**binanceChainId** | **String** | Unique chain identifier. |  [optional] |
|**tokenContractAddress** | **String** | Token contract address. EVM addresses are lowercase; Solana addresses are case-sensitive. |  [optional] |
|**tokenSymbol** | **String** | Token symbol. |  [optional] |
|**valueUsd** | **String** | Transaction value, denominated in USD. |  [optional] |
|**amount** | **String** | Token quantity involved in this transaction (token units). |  [optional] |
|**price** | **String** | Execution price of this transaction, denominated in USD. |  [optional] |
|**marketCap** | **String** | Token market cap at the time of this transaction, denominated in USD. |  [optional] |
|**txHash** | **String** | On-chain transaction hash. |  [optional] |
|**chainLogoUrl** | **String** | Chain logo image URL. |  [optional] |
|**time** | **String** | Transaction on-chain time, Unix millisecond timestamp. |  [optional] |



