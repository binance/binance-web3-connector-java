

# GetTopTradersResponseDataInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**holderWalletAddress** | **String** | Trader wallet address. |  [optional] |
|**holdAmount** | **String** | Current holding amount. |  [optional] |
|**holdingPercent** | **String** | Current holding percentage. \&quot;3.5\&quot; means 3.5%. |  [optional] |
|**boughtAmount** | **String** | Total bought amount (token units). |  [optional] |
|**avgBuyPrice** | **String** | Average buy price, denominated in USD. |  [optional] |
|**soldAmount** | **String** | Total sold amount (token units). |  [optional] |
|**avgSellPrice** | **String** | Average sell price, denominated in USD. |  [optional] |
|**maxHoldAmount** | **String** | Maximum historical holding amount. |  [optional] |
|**lastTradeTime** | **Long** | Time of the holder&#39;s last trade of this token, Unix millisecond timestamp. |  [optional] |
|**realizedPnlUsd** | **String** | Realized PnL, denominated in USD. Positive means profit, negative means loss. |  [optional] |
|**fundingSource** | **String** | Funding source address, i.e., the originator of the first inbound native-token transfer. Null when no inbound transfer is recorded. |  [optional] |
|**fundingSourceLabel** | [**GetHoldersRankingResponseDataInnerFundingSourceLabel**](GetHoldersRankingResponseDataInnerFundingSourceLabel.md) |  |  [optional] |
|**fundingSourceHash** | **String** | Transaction hash of the first inbound native-token transfer. |  [optional] |
|**fundingSourceTime** | **Long** | Time of the first native token inbound transfer, Unix millisecond timestamp. |  [optional] |
|**fundingSourceAmount** | **String** | Amount of the first native token inbound transfer. e.g. 0.5 means 0.5 ETH. |  [optional] |



