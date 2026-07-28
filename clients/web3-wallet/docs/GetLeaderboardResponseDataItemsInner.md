

# GetLeaderboardResponseDataItemsInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**walletAddress** | **String** | Wallet address. |  [optional] |
|**walletName** | **String** | Wallet display name. Empty string when unavailable. |  [optional] |
|**walletLogoUrl** | **String** | Wallet avatar URL. Empty string when unavailable. |  [optional] |
|**walletTwitterUrl** | **String** | Associated Twitter/X profile URL. Empty string when unavailable. |  [optional] |
|**walletType** | **String** | Wallet type tags, comma-separated if multiple. 1&#x3D;Smart Money, 2&#x3D;KOL, 3&#x3D;Hot List. Empty string when no tag applies. |  [optional] |
|**nativeTokenBalance** | **String** | Native token balance of this address on the queried chain. |  [optional] |
|**nativeTokenBalanceUsd** | **String** | Native token balance of this address, denominated in USD. |  [optional] |
|**realizedPnlUsd** | **String** | Cumulative realized PnL within the time frame, denominated in USD. Positive means profit, negative means loss. |  [optional] |
|**realizedPnlPercent** | **String** | Realized PnL percentage within the time frame. No percent sign included. |  [optional] |
|**dailyPnl** | [**List&lt;GetLeaderboardResponseDataItemsInnerDailyPnlInner&gt;**](GetLeaderboardResponseDataItemsInnerDailyPnlInner.md) | Daily realized PnL within the selected time frame, sorted by date descending. |  [optional] |
|**winRatePercent** | **String** | Win rate within the time frame. No percent sign included. |  [optional] |
|**txVolume** | **String** | Total transaction volume within the time frame, denominated in USD. Equals buyTxVolume + sellTxVolume. |  [optional] |
|**buyTxVolume** | **String** | Total buy volume within the time frame, denominated in USD. |  [optional] |
|**sellTxVolume** | **String** | Total sell volume within the time frame, denominated in USD. |  [optional] |
|**avgBuyValueUsd** | **String** | Average buy value per transaction within the time frame, denominated in USD. Returns \&quot;0\&quot; when no buy transactions. |  [optional] |
|**txs** | **String** | Total transaction count within the time frame. Equals buyTxCount + sellTxCount. |  [optional] |
|**buyTxCount** | **String** | Buy transaction count within the time frame. |  [optional] |
|**sellTxCount** | **String** | Sell transaction count within the time frame. |  [optional] |
|**topPnlTokenList** | [**List&lt;GetLeaderboardResponseDataItemsInnerTopPnlTokenListInner&gt;**](GetLeaderboardResponseDataItemsInnerTopPnlTokenListInner.md) | Top 3 tokens by realized PnL. Returns fewer items if fewer than 3 tokens were traded. |  [optional] |
|**tokenCountByPnlPercent** | [**GetLeaderboardResponseDataItemsInnerTokenCountByPnlPercent**](GetLeaderboardResponseDataItemsInnerTokenCountByPnlPercent.md) |  |  [optional] |
|**lastActiveTimestamp** | **String** | Timestamp of the address&#39;s last trade, Unix millisecond timestamp. |  [optional] |



