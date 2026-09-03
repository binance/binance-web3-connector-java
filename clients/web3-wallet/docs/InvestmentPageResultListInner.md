

# InvestmentPageResultListInner

DeFi investment product summary (list item).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Binance chain ID. |  [optional] |
|**defiProtocolId** | **String** | Parent DeFi protocol identifier. |  [optional] |
|**protocolName** | **String** | Protocol display name. |  [optional] |
|**investmentId** | **String** | Investment product identifier (64-char hex, no &#x60;0x&#x60; prefix). Same format as the &#x60;investmentIds&#x60; returned by &#x60;POST /api/v1/defi/data/position/list&#x60; and accepted by the transaction build endpoints. |  [optional] |
|**investmentName** | **String** | Investment display name. |  [optional] |
|**investType** | **String** | Investment type of this product — a single string here (each product has exactly one). Note: the protocol-level investType (in protocol list/detail) is an array. Known values: Earn, LiquidityPool. |  [optional] |
|**apyType** | **String** | Rate yield type. Known values: APY, APR. |  [optional] |
|**apyBps** | **Long** | Annual percentage yield in basis points (1 bps &#x3D; 0.01%). Integer value — use this for sorting / comparing / filtering, never the raw decimal. |  [optional] |
|**apyDisplay** | **String** | Pre-formatted, human-readable APY string for display (e.g. \&quot;1,562.65%\&quot;). Quote as-is; do not re-compute or transform. |  [optional] |
|**tvl** | **String** | Total value locked in this investment (USD). String, raw precision from the data source. |  [optional] |



