

# ProtocolPageResultListInner

DeFi protocol summary (list item).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**defiProtocolId** | **String** | DeFi protocol identifier. |  [optional] |
|**protocolName** | **String** | Protocol display name. |  [optional] |
|**protocolLogo** | **String** | Protocol logo image URL (full URL; quote as-is). |  [optional] |
|**tvl** | **String** | Total value locked in the protocol (USD). String, raw precision from the data source. |  [optional] |
|**apyBps** | **Long** | Highest APY across the protocol&#39;s investments, in basis points (1 bps &#x3D; 0.01%). Integer value — use this for sorting / comparing / filtering, never the raw decimal. |  [optional] |
|**apyDisplay** | **String** | Pre-formatted, human-readable APY string for display (e.g. \&quot;12.35%\&quot;). Quote as-is; do not re-compute or transform. |  [optional] |
|**investType** | **List&lt;String&gt;** | Investment types supported by this protocol — an array here (a protocol may support several). Note: the investment-level investType (in investment list/detail) is a single string. Known values: Earn, LiquidityPool. |  [optional] |
|**supportedChains** | **List&lt;String&gt;** | Supported Binance chain IDs. |  [optional] |



