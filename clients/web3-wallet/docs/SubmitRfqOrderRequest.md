

# SubmitRfqOrderRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**requestId** | **String** | Idempotency key (UUID v4). Within 30 minutes, re-submitting with the same &#x60;requestId&#x60; returns the original result without re-calling the vendor. Generate a new UUID for each new order; reuse the same UUID when retrying the same attempt. |  |
|**userSignature** | **String** | EIP-712 signature of &#x60;rfq.typedDataToSign&#x60; from the &#x60;/swap&#x60; response. Must be a hex string with &#x60;0x&#x60; prefix (132 chars &#x3D; &#x60;0x&#x60; + 65 bytes). The signing wallet must match &#x60;userWalletAddress&#x60; used in &#x60;/quote&#x60;. The backend automatically corrects Ethereum &#x60;v&#x60; values &#x60;00&#x60;/&#x60;01&#x60; to &#x60;1b&#x60;/&#x60;1c&#x60;. |  |
|**vendor** | [**VendorEnum**](#VendorEnum) | RFQ vendor name — must match &#x60;rfq.vendor&#x60; from the &#x60;/swap&#x60; response. The backend validates this against &#x60;quoteId&#x60; to prevent misrouted submissions. |  |
|**quoteId** | **String** | &#x60;rfq.orderId&#x60; from the &#x60;/swap&#x60; response. The backend uses this to look up the vendor and chain context required to forward the signed order. |  |
|**signingScheme** | **String** | Signing scheme from &#x60;rfq.signingScheme&#x60; in the &#x60;/swap&#x60; response. Optional — when omitted the backend infers the default per vendor. |  [optional] |



## Enum: VendorEnum

| Name | Value |
|---- | -----|
| InchFusion | &quot;InchFusion&quot; |
| CowSwap | &quot;CowSwap&quot; |
| PcsXRfq | &quot;PcsXRfq&quot; |



