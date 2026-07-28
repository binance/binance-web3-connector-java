

# BuildSolanaSwapInstructionsResponseDataInstructionListsInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**programId** | **String** | Program that owns the instruction (Base58). |  [optional] |
|**data** | **String** | Instruction data, Base64-encoded. May be an empty string for instructions without data. |  [optional] |
|**accounts** | [**List&lt;BuildSolanaSwapInstructionsResponseDataInstructionListsInnerAccountsInner&gt;**](BuildSolanaSwapInstructionsResponseDataInstructionListsInnerAccountsInner.md) | Accounts referenced by the instruction, in ABI order. |  [optional] |



