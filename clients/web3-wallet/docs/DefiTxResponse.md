

# DefiTxResponse

Unified response of the five build endpoints (deposit / redeem / lp-add / lp-remove / claim). `dataList` is ordered: APPROVE items come first, the main action follows — sign and broadcast each item in order. `preview` is non-null only when the request set `simulate=true`. `redeemDelayDays` is populated only by `/transaction/redeem`.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**dataList** | [**List&lt;DefiTxResponseDataListInner&gt;**](DefiTxResponseDataListInner.md) | Ordered unsigned transactions; APPROVE precedes the main action. |  [optional] |
|**preview** | [**DefiTxResponsePreview**](DefiTxResponsePreview.md) |  |  [optional] |
|**redeemDelayDays** | **List&lt;String&gt;** | Redeem waiting period as a &#x60;[min, max]&#x60; day pair of decimal strings. Populated **only** by &#x60;/transaction/redeem&#x60;; &#x60;null&#x60; on the other build endpoints or when unavailable. Interpretation: &#x60;[]&#x60; (empty) &#x3D; instant, no waiting period; &#x60;[\&quot;7\&quot;,\&quot;7\&quot;]&#x60; &#x3D; fixed 7 days; &#x60;[\&quot;7\&quot;,\&quot;10\&quot;]&#x60; &#x3D; 7–10 days. The wait starts after the redeem transaction is confirmed on-chain. |  [optional] |



