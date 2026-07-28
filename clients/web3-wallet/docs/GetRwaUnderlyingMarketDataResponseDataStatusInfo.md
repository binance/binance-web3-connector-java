

# GetRwaUnderlyingMarketDataResponseDataStatusInfo

Market status information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**openState** | **Boolean** | Whether the underlying market is currently tradable. |  [optional] |
|**marketStatus** | **String** | Current market status: premarket, regular (normal hours), postmarket, overnight, closed, or pause (trading halt/circuit breaker). |  [optional] |
|**reasonCode** | **String** | Reason code when the market is not tradable (returned when openState&#x3D;false). Market-level: MARKET_CLOSED (closed), MARKET_PAUSED (whole market paused), MARKET_MAINTENANCE (system maintenance). Asset-level: ASSET_PAUSED (single asset paused, incl. corporate actions — see reasonMsg), ASSET_LIMITED (single asset restricted but not paused, e.g. earnings window). Others: TRADING (normal), UNSUPPORTED (not supported). |  [optional] |
|**reasonMsg** | **String** | Human-readable reason when the market is not tradable. Common case e.g. \&quot;Weekend or Holiday\&quot;. For ASSET_PAUSED (corporate actions): cash_dividend, stock_dividend, stock_split, merger, acquisition, spinoff, maintenance, corporate action. For ASSET_LIMITED: earnings. |  [optional] |
|**nextOpenTime** | **Long** | Expected next market open time, Unix millisecond timestamp. |  [optional] |
|**nextCloseTime** | **Long** | Expected next market close time, Unix millisecond timestamp. |  [optional] |



