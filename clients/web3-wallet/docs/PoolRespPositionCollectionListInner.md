

# PoolRespPositionCollectionListInner

A collection of positions grouped under the same underlying asset.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**positionCollectionId** | **String** | Collection unique identifier (64-char hex, no &#x60;0x&#x60; prefix). |  [optional] |
|**positionCollectionDetail** | [**PositionCollectionRespPositionCollectionDetail**](PositionCollectionRespPositionCollectionDetail.md) |  |  [optional] |
|**positionCollectionTotalValue** | **String** | Total value of all positions in this collection (USD). |  [optional] |
|**positionList** | [**List&lt;PositionCollectionRespPositionListInner&gt;**](PositionCollectionRespPositionListInner.md) | List of positions in this collection. |  [optional] |



