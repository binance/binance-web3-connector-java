

# GetHoldersRankingResponseDataInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**holderWalletAddress** | **String** | Holder wallet address. |  [optional] |
|**holdAmount** | **String** | Current holding amount. |  [optional] |
|**holdingPercent** | **String** | Holding percentage. \&quot;5.23\&quot; means 5.23%. |  [optional] |
|**nativeTokenSymbol** | **String** | Native token symbol. |  [optional] |
|**nativeTokenBalance** | **String** | Native token balance of the address. |  [optional] |
|**boughtAmount** | **String** | Total buy amount. |  [optional] |
|**avgBuyPrice** | **String** | Average buy price, denominated in USD. |  [optional] |
|**soldAmount** | **String** | Cumulative sold amount (token units). |  [optional] |
|**avgSellPrice** | **String** | Average sell price, denominated in USD. |  [optional] |
|**maxHoldAmount** | **String** | Maximum historical holding amount. |  [optional] |
|**lastTradeTime** | **Long** | Time of the holder&#39;s last trade of this token, Unix millisecond timestamp. |  [optional] |
|**realizedPnlUsd** | **String** | Realized PnL, denominated in USD. Positive means profit, negative means loss. |  [optional] |
|**fundingSource** | **String** | Funding source address, i.e., the originator of the first inbound native-token transfer. Null when no inbound transfer is recorded. |  [optional] |
|**fundingSourceLabel** | [**GetHoldersRankingResponseDataInnerFundingSourceLabel**](GetHoldersRankingResponseDataInnerFundingSourceLabel.md) |  |  [optional] |
|**fundingSourceHash** | **String** | Transaction hash of the first inbound native-token transfer. |  [optional] |
|**fundingSourceTime** | **Long** | Time of the first native token inbound transfer, Unix millisecond timestamp. |  [optional] |
|**fundingSourceAmount** | **String** | Amount of the first native token inbound transfer. e.g. 0.5 means 0.5 ETH. |  [optional] |



