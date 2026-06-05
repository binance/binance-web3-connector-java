

# SimulateTransactionsResponseData


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**status** | **String** | Predicted execution status. |  [optional] |
|**failReason** | **String** | Failure reason when &#x60;status&#x3D;FAILED&#x60;; otherwise null. |  [optional] |
|**balanceChanges** | [**List&lt;SimulateTransactionsResponseDataBalanceChangesInner&gt;**](SimulateTransactionsResponseDataBalanceChangesInner.md) | Predicted balance changes for the simulated transaction. |  [optional] |
|**allowanceChanges** | [**List&lt;SimulateTransactionsResponseDataAllowanceChangesInner&gt;**](SimulateTransactionsResponseDataAllowanceChangesInner.md) | Predicted ERC-20 allowance changes (EVM chains only). |  [optional] |



