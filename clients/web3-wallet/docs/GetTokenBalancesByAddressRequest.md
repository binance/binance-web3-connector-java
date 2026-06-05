

# GetTokenBalancesByAddressRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**address** | **String** | Wallet address to query. |  |
|**tokenContractAddresses** | [**List&lt;GetTokenBalancesByAddressRequestTokenContractAddressesInner&gt;**](GetTokenBalancesByAddressRequestTokenContractAddressesInner.md) | Tokens to query, up to 20 entries. |  |
|**excludeRiskToken** | [**ExcludeRiskTokenEnum**](#ExcludeRiskTokenEnum) | Risk-token filter. \&quot;0\&quot;&#x3D;exclude (default), \&quot;1\&quot;&#x3D;include. Honeypot detection currently applies only to ETH / BSC / SOL / BASE. |  [optional] |



## Enum: ExcludeRiskTokenEnum

| Name | Value |
|---- | -----|
| EXCLUDE_RISK_TOKEN_0 | &quot;0&quot; |
| EXCLUDE_RISK_TOKEN_1 | &quot;1&quot; |



