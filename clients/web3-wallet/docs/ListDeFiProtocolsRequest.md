

# ListDeFiProtocolsRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | One of the supported chains — see Supported Chains &amp; Protocols for the supported chain ID values. Chains outside this whitelist are rejected with 40001. When omitted (or blank), results span all supported chains. |  [optional] |
|**investType** | [**InvestTypeEnum**](#InvestTypeEnum) | Filter by investment type. Known values: &#x60;Earn&#x60;, &#x60;LiquidityPool&#x60;. |  [optional] |
|**sortField** | **String** | Field to sort by. Only two values are accepted: &#x60;tvl&#x60;, &#x60;apy&#x60;. Note: sorting by APY uses &#x60;apy&#x60; (the server-side field name), even though the response exposes &#x60;apyBps&#x60; / &#x60;apyDisplay&#x60;. Other values are not supported. |  [optional] |
|**sortDirection** | [**SortDirectionEnum**](#SortDirectionEnum) | Sort direction. |  [optional] |
|**page** | **Integer** | Page number (1-based). |  [optional] |
|**size** | **Integer** | Page size. Max: 200. |  [optional] |



## Enum: InvestTypeEnum

| Name | Value |
|---- | -----|
| Earn | &quot;Earn&quot; |
| LiquidityPool | &quot;LiquidityPool&quot; |



## Enum: SortDirectionEnum

| Name | Value |
|---- | -----|
| ASC | &quot;ASC&quot; |
| DESC | &quot;DESC&quot; |



