

# GetRwaTokenListResponseDataInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). |  [optional] |
|**tokenContractAddress** | **String** | Token contract address. |  [optional] |
|**platformId** | **String** | Unique platform identifier. |  [optional] |
|**assetType** | **Integer** | Asset type. 1&#x3D;Stock, 2&#x3D;Pre-IPO, 3&#x3D;ETF. |  [optional] |
|**tokenName** | **String** | Token full name. |  [optional] |
|**tokenSymbol** | **String** | Token symbol. |  [optional] |
|**tokenLogoUrl** | **String** | Token logo URL. |  [optional] |
|**decimals** | **String** | Token decimals. |  [optional] |
|**underlyingTicker** | **String** | Underlying asset ticker symbol. |  [optional] |
|**underlyingName** | **String** | Underlying company English name. |  [optional] |
|**underlyingNameZh** | **String** | Underlying company Chinese name. Falls back to English if unavailable. |  [optional] |
|**tokenToShareRatio** | **String** | Token-to-share exchange ratio. E.g. \&quot;1.003701\&quot; means 1 token ≈ 1.003701 underlying shares. |  [optional] |
|**tags** | **List&lt;String&gt;** | Token tag array. Enum: alpha, communityRecognized, volumeSurge, volumePlunge. |  [optional] |
|**statusInfo** | [**GetRwaTokenListResponseDataInnerStatusInfo**](GetRwaTokenListResponseDataInnerStatusInfo.md) |  |  [optional] |
|**tokenPrice** | **String** | On-chain token price (USD). |  [optional] |
|**referencePrice** | **String** | Underlying reference price (USD). A per-share converted price derived from the on-chain token price, not an official quote from the traditional stock market. |  [optional] |
|**volume24H** | **String** | 24-hour trading volume (USD). |  [optional] |
|**marketCap** | **String** | Market capitalization (USD). |  [optional] |
|**peRatioTTM** | **String** | Price-to-Earnings ratio (TTM). Null when unavailable. |  [optional] |



