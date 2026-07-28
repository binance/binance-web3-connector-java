

# BuildSolanaSwapInstructionsResponseData


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addressLookupTableAccount** | **List&lt;String&gt;** | Address Lookup Table addresses (Base58) referenced by the transaction, including the platform-injected custom ALT. The caller must fetch each ALT account (&#x60;getAccountInfo&#x60;) and pass the parsed lookup data when compiling the v0 message. |  [optional] |
|**instructionLists** | [**List&lt;BuildSolanaSwapInstructionsResponseDataInstructionListsInner&gt;**](BuildSolanaSwapInstructionsResponseDataInstructionListsInner.md) | Ordered uncompiled instructions to assemble into the v0 transaction. |  [optional] |
|**routerResult** | [**BuildSolanaSwapInstructionsResponseDataRouterResult**](BuildSolanaSwapInstructionsResponseDataRouterResult.md) |  |  [optional] |
|**tx** | [**BuildSolanaSwapInstructionsResponseDataTx**](BuildSolanaSwapInstructionsResponseDataTx.md) |  |  [optional] |



