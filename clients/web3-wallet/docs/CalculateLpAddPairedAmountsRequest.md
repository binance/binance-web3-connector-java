

# CalculateLpAddPairedAmountsRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**address** | **String** | User wallet address. |  |
|**investmentId** | **String** | LP investment product ID (chain-agnostic). |  |
|**tickLower** | **String** | Lower tick bound (raw &#x60;int24&#x60;), aligned to the pool&#39;s &#x60;tickSpacing&#x60;. |  [optional] |
|**tickUpper** | **String** | Upper tick bound (raw &#x60;int24&#x60;), aligned to the pool&#39;s &#x60;tickSpacing&#x60;. |  [optional] |
|**priceRange** | **String** | Price range as a percentage (e.g. &#x60;\&quot;5\&quot;&#x60; &#x3D; ±5%). |  [optional] |
|**nftId** | **String** | Required when calculating for an existing LP position. |  [optional] |
|**inputToken** | [**BuildDeFiDepositTransactionRequestToken**](BuildDeFiDepositTransactionRequestToken.md) |  |  |



