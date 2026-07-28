

# SubmitRfqOrderResponseData

Submitted order details.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**orderId** | **String** | Platform-generated order ID. Use this to poll &#x60;GET /order/{orderId}&#x60; for the final settlement status. |  [optional] |
|**status** | **String** | Initial order status after submission. Typical value: &#x60;PENDING_VENDOR&#x60; (forwarded to vendor, awaiting settlement). |  [optional] |
|**createdAt** | **Long** | Order creation timestamp (Unix epoch milliseconds). |  [optional] |



