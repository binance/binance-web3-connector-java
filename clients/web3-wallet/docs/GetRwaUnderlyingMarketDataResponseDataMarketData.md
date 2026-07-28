

# GetRwaUnderlyingMarketDataResponseDataMarketData

Underlying asset market data. Fields vary by asset type.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**referencePrice** | **String** | Underlying reference price (USD). A per-share converted price derived from the on-chain token price, not an official quote from the traditional stock market. |  [optional] |
|**high52W** | **String** | 52-week high price. Applicable to Stock and ETF only. |  [optional] |
|**low52W** | **String** | 52-week low price. Applicable to Stock and ETF only. |  [optional] |
|**volumeShares24H** | **String** | 24-hour trading volume in shares. |  [optional] |
|**avgDailyVolume1Y** | **String** | 1-year average daily volume. Applicable to Stock and ETF only. |  [optional] |
|**totalShares** | **String** | Total outstanding shares (Stock) or total units (ETF). Applicable to Stock and ETF only. |  [optional] |
|**marketCap** | **String** | Market capitalization (USD) for Stock/ETF, or implied total valuation for Pre-IPO. |  [optional] |
|**turnoverRate** | **String** | Turnover rate. \&quot;23.81\&quot; means 23.81%. Applicable to Stock and ETF only. |  [optional] |
|**amplitude** | **String** | Price amplitude (intraday). \&quot;3.05\&quot; means 3.05%, i.e. (intraday high − low) / previous close. Applicable to Stock and ETF only. |  [optional] |
|**peRatioTTM** | **String** | Price-to-Earnings ratio (TTM &#x3D; Trailing Twelve Months, based on earnings of the most recent 12 months). Applicable to Stock only. |  [optional] |
|**pbRatio** | **String** | Price-to-Book ratio. Applicable to Stock only. |  [optional] |
|**dividendYield** | **String** | Dividend yield. \&quot;0.85\&quot; means 0.85%. Applicable to Stock and ETF only. |  [optional] |
|**latestDividend** | **String** | Latest dividend amount (USD). Applicable to Stock and ETF only. |  [optional] |



