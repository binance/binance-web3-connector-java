

# GetDeFiPositionsResponseDataAddressListInnerProtocolListInnerPoolListInnerPositionCollectionListInnerPositionListInner

A single DeFi position with underlying asset and token breakdown.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**positionId** | **String** | Unique position identifier (64-char hex, no &#x60;0x&#x60; prefix). |  [optional] |
|**underlyingAssetName** | **String** | Display name of the underlying asset (e.g. \&quot;USDT-USDC\&quot;, \&quot;lisUSD\&quot;). |  [optional] |
|**underlyingAssetId** | **String** | Underlying asset identifier (64-char hex, no &#x60;0x&#x60; prefix). Hashed from the pool and underlying token addresses. |  [optional] |
|**assetType** | **String** | Asset structure type. Null for a regular position; &#x60;locked&#x60; for a locked position (e.g. locked staking — check &#x60;unlockTime&#x60; on positionDetail); &#x60;farming&#x60; for a MasterChef-style farming position (rewards accrue under the &#x60;farming_reward&#x60; token group). |  [optional] |
|**investmentIds** | **List&lt;String&gt;** | Related investment IDs (64-char hex, no &#x60;0x&#x60; prefix). Use with &#x60;POST /api/v1/defi/data/investment/detail&#x60;. Usually a single entry; a position can relate to several investments when the pool stacks products on top of each other (e.g. a farming position wraps the underlying LP investment plus its incentive product, or a staked vault layers a receipt token over the base deposit). When there are several, query each with investment/detail and pick by the action you want to perform — redeeming the principal uses the base investment, claiming farming incentives uses the incentive one. |  [optional] |
|**positionDetail** | [**GetDeFiPositionsResponseDataAddressListInnerProtocolListInnerPoolListInnerPositionCollectionListInnerPositionListInnerPositionDetail**](GetDeFiPositionsResponseDataAddressListInnerProtocolListInnerPoolListInnerPositionCollectionListInnerPositionListInnerPositionDetail.md) |  |  [optional] |
|**positionValue** | **String** | Total position value in USD (sum of all token values; may be negative for borrow positions). |  [optional] |
|**tokenList** | [**PositionRespTokenList**](PositionRespTokenList.md) |  |  [optional] |



