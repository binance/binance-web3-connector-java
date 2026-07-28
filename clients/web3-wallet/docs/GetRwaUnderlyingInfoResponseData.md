

# GetRwaUnderlyingInfoResponseData

Underlying company information and protections.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). |  [optional] |
|**tokenContractAddress** | **String** | Token contract address. |  [optional] |
|**platformId** | **String** | Unique platform identifier. |  [optional] |
|**underlyingTicker** | **String** | Underlying asset ticker symbol. |  [optional] |
|**underlyingFullName** | **String** | Underlying asset full name. |  [optional] |
|**assetType** | **Integer** | Asset type. 1&#x3D;Stock, 2&#x3D;Pre-IPO, 3&#x3D;ETF. |  [optional] |
|**tokenToShareRatio** | **String** | Token-to-share exchange ratio. E.g. \&quot;1.003701\&quot; means 1 token ≈ 1.003701 underlying shares. |  [optional] |
|**protections** | [**Map&lt;String, GetRwaUnderlyingInfoResponseDataProtectionsValue&gt;**](GetRwaUnderlyingInfoResponseDataProtectionsValue.md) | Investor protection mechanisms, keyed by mechanism type. Each entry includes whether it is supported and a related proof/report link. Known keys: dailyAttestationReport, monthlyAttestationReport, collateralReport. New keys may be added per platform. |  [optional] |
|**companyInfo** | [**GetRwaUnderlyingInfoResponseDataCompanyInfo**](GetRwaUnderlyingInfoResponseDataCompanyInfo.md) |  |  [optional] |



