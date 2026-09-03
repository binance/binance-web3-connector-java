

# ProtocolRespPoolListInner

A pool containing position collections.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**bnPoolId** | **String** | Pool identifier (&#x60;0x&#x60; + 64-char hex). |  [optional] |
|**poolCa** | **String** | Pool contract address. |  [optional] |
|**poolType** | **String** | Pool type. Complete value set: &#x60;Lending&#x60; (supply/borrow market), &#x60;Staked&#x60; (native staking), &#x60;Yield&#x60; (yield vault / receipt token), &#x60;Deposit&#x60; (fixed deposit), &#x60;Rewards&#x60; (reward claims, e.g. PancakeSwap Infinity), &#x60;Liquidity Pool&#x60; (AMM / concentrated liquidity), &#x60;Farming&#x60; (MasterChef farming), &#x60;Locked&#x60; (locked staking with unlock time), &#x60;Vesting&#x60; (vesting schedule). Treat unknown values as generic display. |  [optional] |
|**positionCollectionList** | [**List&lt;PoolRespPositionCollectionListInner&gt;**](PoolRespPositionCollectionListInner.md) |  |  [optional] |
|**poolDetail** | [**PoolRespPoolDetail**](PoolRespPoolDetail.md) |  |  [optional] |



