

# BuildLpAddTransactionRequestTokenListInner

A `(tokenAddress, amount)` pair. `amount` is a human-readable decimal string (NOT the token's smallest unit); the service converts it according to the token's decimals. For the native asset use the sentinel `0xeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee` (40 `e`s).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**tokenAddress** | **String** | Token contract address; the native-asset sentinel for the native coin. |  |
|**amount** | **String** | Human-readable amount as a decimal string, e.g. \&quot;1.5\&quot;, \&quot;100\&quot;. |  |



