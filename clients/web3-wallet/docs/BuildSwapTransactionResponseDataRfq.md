

# BuildSwapTransactionResponseDataRfq

RFQ order payload. Present only when `executionMode=RFQ`. Contains the EIP-712 typed data to sign, the target vendor, the signing scheme, and (when requested) the approve transaction data.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**vendor** | **String** | RFQ vendor that will settle this order on-chain. Pass this as the &#x60;vendor&#x60; field in &#x60;POST /order/submit&#x60;. |  [optional] |
|**txType** | **String** | Transaction type for this RFQ order. Currently always &#x60;EIP712&#x60; (all three RFQ vendors use EIP-712 typed-data signing); reserved for future signing schemes. |  [optional] |
|**typedDataToSign** | **String** | EIP-712 typed data payload for &#x60;eth_signTypedData_v4&#x60;, serialized as a hex string (or JSON-encoded string). Sign with the wallet that matches &#x60;userWalletAddress&#x60; from &#x60;/quote&#x60;. Pass the resulting signature as &#x60;userSignature&#x60; in &#x60;POST /order/submit&#x60;. |  [optional] |
|**signingScheme** | **String** | Signing scheme required by this vendor. Pass this as &#x60;signingScheme&#x60; in &#x60;POST /order/submit&#x60;. |  [optional] |
|**signatureData** | **List&lt;String&gt;** | Approve transaction data, present only when &#x60;approveTransaction&#x3D;true&#x60; was passed and the from-token is an EVM ERC-20. Each element is a JSON string containing &#x60;approveContract&#x60; (the spender address, resolved per vendor: InchFusion→router, PcsXRfq→Permit2, CowSwap→VaultRelayer) and &#x60;approveTxCalldata&#x60; (the ERC-20 &#x60;approve()&#x60; calldata). Empty list otherwise. |  [optional] |



