

# GetRfqOrderStatusResponseData

Order status details.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**orderId** | **String** | Platform order ID. |  [optional] |
|**status** | **String** | Current order status. - **Terminal**: &#x60;FILLED&#x60; (settled on-chain), &#x60;FAILED&#x60; (settlement failed),   &#x60;EXPIRED&#x60; (vendor could not settle before the order deadline), &#x60;CANCELLED&#x60;   (cancelled by the user or vendor).  - **Intermediate**: &#x60;PENDING_VENDOR&#x60; (forwarded to vendor, awaiting settlement),   &#x60;PENDING_ONCHAIN&#x60; (vendor has broadcast the on-chain transaction, awaiting   block confirmation). |  [optional] |
|**txHash** | **String** | On-chain transaction hash. Present only when &#x60;status&#x3D;FILLED&#x60;. |  [optional] |
|**fromAmount** | **String** | Actual sell-token amount settled (smallest unit, integer string). Present when filled. |  [optional] |
|**toAmount** | **String** | Actual buy-token amount received (smallest unit, integer string). Present when filled. |  [optional] |
|**filledAt** | **Long** | Settlement timestamp (Unix epoch milliseconds). Present when filled. |  [optional] |
|**createdAt** | **Long** | Order creation timestamp (Unix epoch milliseconds). |  [optional] |



