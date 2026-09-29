

# RealTimeTradesStreamResponse

Trade history event payload.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**tx** | **String** | Transaction hash. |  [optional] |
|**ua** | **String** | Transaction initiator wallet address (the wallet that initiated the swap). |  [optional] |
|**tp** | **String** | Trade direction relative to the queried (base) token: buy or sell. |  [optional] |
|**vol** | **String** | Trade amount in USD. |  [optional] |
|**tLowerCase** | **Long** | Trade timestamp in milliseconds. |  [optional] |
|**tokens** | [**List&lt;RealTimeTradesStreamResponseTokensInner&gt;**](RealTimeTradesStreamResponseTokensInner.md) | Token pair info. Fixed 2 elements — first is the base token, second is the quote token. |  [optional] |



