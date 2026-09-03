

# LpAddCalculateResponse

Result of `/transaction/lp-add/calculate`. Returns the paired token amounts derived from the single input token. This endpoint is pure computation — it does not touch the chain and does not deduct any fee.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**inputTokenAmount** | **String** | Echo of the input token amount (human-readable). |  [optional] |
|**pairedTokenAddress** | **String** | The paired token contract address derived from the investment. |  [optional] |
|**pairedTokenAmount** | **String** | Calculated paired token amount (human-readable). |  [optional] |



