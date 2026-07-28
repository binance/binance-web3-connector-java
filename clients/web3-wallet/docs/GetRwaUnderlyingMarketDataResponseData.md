

# GetRwaUnderlyingMarketDataResponseData

Underlying market data for the RWA token.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). |  [optional] |
|**tokenContractAddress** | **String** | Token contract address. |  [optional] |
|**platformId** | **String** | Unique platform identifier. |  [optional] |
|**assetType** | **Integer** | Asset type. 1&#x3D;Stock, 2&#x3D;Pre-IPO, 3&#x3D;ETF. |  [optional] |
|**statusInfo** | [**GetRwaUnderlyingMarketDataResponseDataStatusInfo**](GetRwaUnderlyingMarketDataResponseDataStatusInfo.md) |  |  [optional] |
|**marketData** | [**GetRwaUnderlyingMarketDataResponseDataMarketData**](GetRwaUnderlyingMarketDataResponseDataMarketData.md) |  |  [optional] |



