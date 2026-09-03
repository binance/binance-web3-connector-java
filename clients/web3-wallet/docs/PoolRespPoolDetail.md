

# PoolRespPoolDetail

Pool-level metadata. Fields are null when not applicable to the pool type (e.g. `tickSpacing`/`hooks` only for concentrated-liquidity pools).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**expiry** | **Long** | Pool expiry timestamp (Unix seconds). Null if no expiry. |  [optional] |
|**feeTier** | **String** | Fee tier. For PancakeSwap V3-style pools this is the encoded fee (e.g. \&quot;500\&quot; &#x3D; 0.05%); for V4-style pools a flag-encoded value. |  [optional] |
|**lpFee** | **String** | LP fee portion in basis points (V4-style pools). |  [optional] |
|**tickSpacing** | **String** | Tick spacing for concentrated-liquidity pools. |  [optional] |
|**isDynamicFee** | **Boolean** | Whether the pool uses a dynamic (hook-managed) fee (V4-style pools). |  [optional] |
|**hookFee** | **String** | Hook fee portion in basis points (V4-style pools). |  [optional] |
|**tick** | **String** | Current pool tick (V4-style pools). |  [optional] |
|**hooks** | **String** | Hook contract address (V4-style pools). Zero address when no hook. |  [optional] |
|**swapProtocolFee** | **String** | Protocol fee on swaps in basis points (V4-style pools). |  [optional] |
|**parameters** | **String** | Encoded pool parameters, e.g. &#x60;0x&#x60; + 64-char hex (V4-style pools). |  [optional] |
|**fee** | **String** | Total pool fee in basis points (V4-style pools). |  [optional] |
|**spokeName** | **String** | Spoke pool name (e.g. across-protocol bridges). |  [optional] |
|**reserveCount** | **String** | Number of reserves in multi-asset pools. |  [optional] |
|**vaultName** | **String** | Vault name for vault-style protocols. |  [optional] |



