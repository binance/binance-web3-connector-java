

# GetProtocolDetailResponseData

DeFi protocol detail.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**defiProtocolId** | **String** | DeFi protocol identifier. |  [optional] |
|**protocolName** | **String** | Protocol display name. |  [optional] |
|**protocolLogo** | **String** | Protocol logo image URL (full URL under &#x60;https://bin.bnbstatic.com&#x60;). |  [optional] |
|**description** | **String** | Protocol description (already translated; quote as-is). |  [optional] |
|**websiteUrl** | **String** | Official website URL. |  [optional] |
|**investType** | **List&lt;String&gt;** | Investment types supported by this protocol — an array here (a protocol may support several). Note: the investment-level investType (in investment list/detail) is a single string. Known values: Earn, LiquidityPool. |  [optional] |
|**supportedChains** | **List&lt;String&gt;** | Supported Binance chain IDs. |  [optional] |
|**tvl** | **String** | Total value locked (USD). String, raw precision from the data source. |  [optional] |
|**tags** | **List&lt;String&gt;** | Protocol tags / categories. |  [optional] |
|**founded** | **String** | Founding year (YYYY). |  [optional] |
|**fdv** | **String** | Fully diluted valuation. |  [optional] |
|**totalFunding** | **String** | Total funding raised. Null when not disclosed. |  [optional] |
|**socialLinks** | [**GetProtocolDetailResponseDataSocialLinks**](GetProtocolDetailResponseDataSocialLinks.md) |  |  [optional] |
|**team** | [**List&lt;DefiProtocolInfoDtoTeamInner&gt;**](DefiProtocolInfoDtoTeamInner.md) | Team members. |  [optional] |
|**fundRaising** | [**List&lt;DefiProtocolInfoDtoFundRaisingInner&gt;**](DefiProtocolInfoDtoFundRaisingInner.md) | Fundraising history. |  [optional] |
|**securityScore** | **String** | Overall CertiK security score. |  [optional] |
|**dimensionScores** | [**GetProtocolDetailResponseDataDimensionScores**](GetProtocolDetailResponseDataDimensionScores.md) |  |  [optional] |
|**highlights** | **List&lt;String&gt;** | Protocol highlights (already translated; quote as-is). |  [optional] |
|**faq** | [**List&lt;DefiProtocolInfoDtoFaqInner&gt;**](DefiProtocolInfoDtoFaqInner.md) | FAQ entries (question and answer text, already translated). |  [optional] |



