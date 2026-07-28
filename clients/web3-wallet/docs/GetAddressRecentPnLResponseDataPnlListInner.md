

# GetAddressRecentPnLResponseDataPnlListInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Unique chain identifier. |  [optional] |
|**tokenContractAddress** | **String** | Token contract address. EVM addresses are lowercase; Solana addresses are case-sensitive. |  [optional] |
|**tokenSymbol** | **String** | Token symbol. |  [optional] |
|**lastActiveTimestamp** | **String** | Timestamp of the last transaction for this token, Unix millisecond timestamp. |  [optional] |
|**realizedPnlUsd** | **String** | Realized PnL for this token, denominated in USD. Positive means profit, negative means loss. |  [optional] |
|**realizedPnlPercent** | **String** | Realized PnL percentage for this token. No percent sign included. |  [optional] |
|**tokenBalanceUsd** | **String** | Current market value of the address&#39;s holding in this token, denominated in USD. |  [optional] |
|**tokenBalanceAmount** | **String** | Current holding amount of this token (token units). |  [optional] |
|**tokenPositionDuration** | [**GetAddressRecentPnLResponseDataPnlListInnerTokenPositionDuration**](GetAddressRecentPnLResponseDataPnlListInnerTokenPositionDuration.md) |  |  [optional] |
|**buyTxCount** | **String** | Number of buy transactions for this token. |  [optional] |
|**buyTxVolume** | **String** | Total buy spend for this token, denominated in USD. |  [optional] |
|**buyAvgPrice** | **String** | Average buy price for this token, denominated in USD. |  [optional] |
|**sellTxCount** | **String** | Number of sell transactions for this token. |  [optional] |
|**sellTxVolume** | **String** | Total sell proceeds for this token, denominated in USD. |  [optional] |
|**sellAvgPrice** | **String** | Average sell price for this token, denominated in USD. |  [optional] |



