

# GetAggregatorSupportedChainsResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **Integer** | Business status code. 0 indicates success; any non-zero value indicates a business error. |  [optional] |
|**msg** | **String** | Status description message. |  [optional] |
|**data** | [**List&lt;GetAggregatorSupportedChainsResponseDataInner&gt;**](GetAggregatorSupportedChainsResponseDataInner.md) | List of supported blockchain networks. |  [optional] |
|**timestamp** | **Long** | Server response timestamp in milliseconds. |  [optional] |
|**success** | **Boolean** | Convenience flag derived from &#x60;code &#x3D;&#x3D; 0&#x60;. |  [optional] |



