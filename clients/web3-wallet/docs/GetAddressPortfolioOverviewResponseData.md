

# GetAddressPortfolioOverviewResponseData

Address portfolio overview.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**realizedPnlUsd** | **String** | Total realized PnL within the time frame, denominated in USD. Positive means profit, negative means loss. |  [optional] |
|**realizedPnlPercent** | **String** | Realized PnL percentage within the time frame. \&quot;16.44\&quot; means +16.44%. No percent sign included. |  [optional] |
|**dailyPnl** | [**List&lt;GetAddressPortfolioOverviewResponseDataDailyPnlInner&gt;**](GetAddressPortfolioOverviewResponseDataDailyPnlInner.md) | Daily realized PnL breakdown, sorted by date descending (most recent first). Number of entries matches the timeFrame. |  [optional] |
|**winRate** | **String** | Win rate within the time frame. \&quot;61.11\&quot; means 61.11%. No percent sign included. |  [optional] |
|**tokenCountByPnlPercent** | [**GetAddressPortfolioOverviewResponseDataTokenCountByPnlPercent**](GetAddressPortfolioOverviewResponseDataTokenCountByPnlPercent.md) |  |  [optional] |
|**buyTxCount** | **String** | Number of buy transactions within the time frame. |  [optional] |
|**sellTxCount** | **String** | Number of sell transactions within the time frame. |  [optional] |
|**totalTokenCount** | **String** | Total number of distinct tokens traded within the time frame. |  [optional] |
|**buyTxVolume** | **String** | Total buy volume within the time frame, denominated in USD. |  [optional] |
|**sellTxVolume** | **String** | Total sell volume within the time frame, denominated in USD. |  [optional] |
|**avgBuyValueUsd** | **String** | Average buy value per transaction within the time frame, denominated in USD. |  [optional] |
|**top3PnlTokenSumUsd** | **String** | Total realized PnL of the top 3 profit tokens, denominated in USD. |  [optional] |
|**top3PnlTokenPercent** | **String** | Percentage of total realized PnL contributed by the top 3 profit tokens. No percent sign included. |  [optional] |
|**topPnlTokenList** | [**List&lt;GetAddressPortfolioOverviewResponseDataTopPnlTokenListInner&gt;**](GetAddressPortfolioOverviewResponseDataTopPnlTokenListInner.md) | Top 3 tokens by realized PnL. Returns fewer items if fewer than 3 tokens were traded. |  [optional] |



