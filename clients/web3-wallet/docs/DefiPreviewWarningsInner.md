

# DefiPreviewWarningsInner

A single non-blocking risk warning.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **String** | Warning code. Known values: &#x60;HEALTH_FACTOR_WARNING&#x60;, &#x60;HEALTH_FACTOR_DANGER&#x60;, &#x60;HIGH_SLIPPAGE&#x60;, &#x60;DELAYED_REDEMPTION&#x60;, &#x60;LP_OUT_OF_RANGE&#x60;. Branch on &#x60;code&#x60; for control flow; display &#x60;message&#x60; as-is. |  [optional] |
|**level** | **String** | Severity level — INFO / WARN / DANGER. |  [optional] |
|**message** | **String** | Human-readable warning text. |  [optional] |



