

# GetDeFiPositionsRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addresses** | **List&lt;String&gt;** | Wallet addresses to query positions for. Up to 3 addresses per request (server-side configured and subject to change); the limit is shared across chains — a multi-chain query consumes the same 3-address budget. |  |
|**binanceChainIds** | **List&lt;String&gt;** | Optional chain filter. When set, only positions on the specified chains are returned; when omitted, positions across all supported chains are returned. See Supported Chains &amp; Protocols for the supported chain ID values — unsupported values are rejected with 40001. |  [optional] |
|**forceRefresh** | **Boolean** | Force a cache bypass and re-read the latest on-chain state. Defaults to &#x60;false&#x60; (serves cached data). Set to &#x60;true&#x60; right after a redeem / claim to see the updated position immediately — the cache otherwise lags by a short window. |  [optional] |



