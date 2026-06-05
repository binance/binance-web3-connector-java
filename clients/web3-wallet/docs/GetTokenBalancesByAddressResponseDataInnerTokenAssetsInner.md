

# GetTokenBalancesByAddressResponseDataInnerTokenAssetsInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Chain identifier. |  [optional] |
|**tokenContractAddress** | **String** | Token contract address. Empty string for the chain&#39;s native asset. |  [optional] |
|**address** | **String** | Wallet address echoed from the request. |  [optional] |
|**symbol** | **String** | Token ticker. |  [optional] |
|**balance** | **String** | Token amount scaled by decimals. |  [optional] |
|**rawBalance** | **String** | Raw token amount in the smallest unit. Empty string when the chain doesn&#39;t expose a raw value. |  [optional] |
|**tokenPrice** | **String** | Token USD price. |  [optional] |
|**isRiskToken** | **Boolean** | Whether the token is risk-flagged. |  [optional] |



