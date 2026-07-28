

# GetRwaTokenPriceResponseDataInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). |  [optional] |
|**tokenContractAddress** | **String** | Token contract address. |  [optional] |
|**platformId** | **String** | Unique platform identifier. |  [optional] |
|**tokenPrice** | **String** | On-chain token price (USD). |  [optional] |
|**referencePrice** | **String** | Underlying reference price (USD). A per-share converted price derived from the on-chain token price, not an official quote from the traditional stock market. |  [optional] |
|**tokenPriceUpdatedAt** | **Long** | Token price last updated time, Unix millisecond timestamp. |  [optional] |



