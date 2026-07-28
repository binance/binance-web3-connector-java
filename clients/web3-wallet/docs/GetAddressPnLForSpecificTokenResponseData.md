

# GetAddressPnLForSpecificTokenResponseData

Token latest PnL details.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**realizedPnlUsd** | **String** | Cumulative realized PnL for this token, denominated in USD. Positive means profit, negative means loss. |  [optional] |
|**realizedPnlPercent** | **String** | Realized PnL percentage. No percent sign included. |  [optional] |
|**buyTxVolume** | **String** | Cumulative buy spend for this token, denominated in USD. |  [optional] |
|**buyAmount** | **String** | Cumulative buy quantity (token units). |  [optional] |
|**buyTxCount** | **String** | Number of buy transactions. |  [optional] |
|**sellTxVolume** | **String** | Cumulative sell proceeds for this token, denominated in USD. |  [optional] |
|**sellAmount** | **String** | Cumulative sell quantity (token units). |  [optional] |
|**sellTxCount** | **String** | Number of sell transactions. |  [optional] |
|**buyAvgPrice** | **String** | Average buy price, denominated in USD. |  [optional] |
|**sellAvgPrice** | **String** | Average sell price, denominated in USD. |  [optional] |
|**tokenBalanceUsd** | **String** | Current market value of the address&#39;s holding in this token, denominated in USD. Returns \&quot;0\&quot; when fully sold. |  [optional] |
|**tokenBalanceAmount** | **String** | Current holding amount (token units). Returns \&quot;0\&quot; when fully sold. |  [optional] |
|**maxBalanceAmount** | **String** | Maximum historical holding amount (token units). |  [optional] |
|**holdingDuration** | **String** | Cumulative holding duration in milliseconds. Counts only actual holding periods; gaps between sell and re-buy are excluded. If still holding, counts up to the current time. |  [optional] |
|**isPnlSupported** | **Boolean** | Whether PnL calculation is meaningful for this token. true&#x3D;supported; false&#x3D;not supported. Returns false for stablecoins (USDT/USDC/DAI etc.), native tokens (ETH/BNB/SOL etc.), and wrapped tokens (WETH/WBNB/WSOL etc.). Returns true for regular trading tokens. |  [optional] |



