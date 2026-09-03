

# PositionRespTokenList

Token breakdown grouped by role. Keys: `supply` (supplied assets), `borrow` (borrowed assets, lending positions), `reward` (claimable rewards), `farming_reward` (MasterChef farming incentives). A key is absent when the position has no tokens in that role.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**supply** | [**List&lt;PositionRespTokenListSupplyInner&gt;**](PositionRespTokenListSupplyInner.md) |  |  [optional] |
|**borrow** | [**List&lt;PositionRespTokenListSupplyInner&gt;**](PositionRespTokenListSupplyInner.md) |  |  [optional] |
|**reward** | [**List&lt;PositionRespTokenListSupplyInner&gt;**](PositionRespTokenListSupplyInner.md) |  |  [optional] |
|**farmingReward** | [**List&lt;PositionRespTokenListSupplyInner&gt;**](PositionRespTokenListSupplyInner.md) |  |  [optional] |



