

# GetGasLimitRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana, \&quot;CT_195\&quot;&#x3D;Tron). Provide &#x60;evmTx&#x60; for EVM chains, &#x60;solTx&#x60; for Solana, or &#x60;tronTx&#x60; for Tron — exactly one must be present. Note: &#x60;evmTx&#x60;, &#x60;solTx&#x60;, and &#x60;tronTx&#x60; are marked required in this schema for rendering purposes only; in practice supply exactly one matching &#x60;binanceChainId&#x60;. |  |
|**evmTx** | [**GetGasLimitRequestEvmTx**](GetGasLimitRequestEvmTx.md) |  |  |
|**solTx** | [**GetGasLimitRequestSolTx**](GetGasLimitRequestSolTx.md) |  |  |
|**tronTx** | [**GetGasLimitRequestTronTx**](GetGasLimitRequestTronTx.md) |  |  |



