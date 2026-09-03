# DefiTransactionApi

All URIs are relative to *https://web3.binance.com/build*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**buildDeFiClaimTransaction**](DefiTransactionApi.md#buildDeFiClaimTransaction) | **POST** /api/v1/defi/transaction/claim | Build DeFi Claim Transaction |
| [**buildDeFiDepositTransaction**](DefiTransactionApi.md#buildDeFiDepositTransaction) | **POST** /api/v1/defi/transaction/deposit | Build DeFi Deposit Transaction |
| [**buildDeFiRedeemTransaction**](DefiTransactionApi.md#buildDeFiRedeemTransaction) | **POST** /api/v1/defi/transaction/redeem | Build DeFi Redeem Transaction |
| [**buildLpAddTransaction**](DefiTransactionApi.md#buildLpAddTransaction) | **POST** /api/v1/defi/transaction/lp-add | Build LP Add Transaction |
| [**buildLpRemoveTransaction**](DefiTransactionApi.md#buildLpRemoveTransaction) | **POST** /api/v1/defi/transaction/lp-remove | Build LP Remove Transaction |
| [**calculateLpAddPairedAmounts**](DefiTransactionApi.md#calculateLpAddPairedAmounts) | **POST** /api/v1/defi/transaction/lp-add/calculate | Calculate LP Add Paired Amounts |


<a id="buildDeFiClaimTransaction"></a>
# **buildDeFiClaimTransaction**
> BuildDeFiClaimTransactionResponse buildDeFiClaimTransaction(buildDeFiClaimTransactionRequest).recvWindow(recvWindow).nonce(nonce).execute();

Build DeFi Claim Transaction

Build the unsigned claim calldata for one of four claim types — see &#x60;DefiClaimType&#x60; for which companion fields each type requires **and which protocol constraints apply** (e.g. &#x60;REWARD_PROTOCOL&#x60; is not supported for LP protocols; PancakeSwap V3 farming uses &#x60;LP_FEE&#x60;, not &#x60;REWARD_INVESTMENT&#x60;). Returns an ordered &#x60;dataList&#x60; (typically &#x60;[CLAIM]&#x60;). **&#x60;binanceChainId&#x60; resolution rules**: - Normally resolved from &#x60;investmentId&#x60;; the call always executes on that chain. - For claim types other than &#x60;REWARD_PROTOCOL&#x60;, any client-supplied &#x60;binanceChainId&#x60; is   **silently ignored** — passing a different chainId will not redirect the claim.  - **Exception**: &#x60;REWARD_PROTOCOL&#x60; with no &#x60;investmentId&#x60; — the client MUST pass   &#x60;binanceChainId&#x60; (it is the only chain signal).  &#x60;tokenAddressList&#x60; optionally narrows the claim scope. Set &#x60;simulate&#x3D;true&#x60; to also receive &#x60;preview&#x60;.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.DefiTransactionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    DefiTransactionApi apiInstance = new DefiTransactionApi(defaultClient);
    BuildDeFiClaimTransactionRequest buildDeFiClaimTransactionRequest = new BuildDeFiClaimTransactionRequest(); // BuildDeFiClaimTransactionRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      BuildDeFiClaimTransactionResponse result = apiInstance.buildDeFiClaimTransaction(buildDeFiClaimTransactionRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefiTransactionApi#buildDeFiClaimTransaction");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **buildDeFiClaimTransactionRequest** | [**BuildDeFiClaimTransactionRequest**](BuildDeFiClaimTransactionRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**BuildDeFiClaimTransactionResponse**](BuildDeFiClaimTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Claim transaction calldata returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="buildDeFiDepositTransaction"></a>
# **buildDeFiDepositTransaction**
> BuildDeFiDepositTransactionResponse buildDeFiDepositTransaction(buildDeFiDepositTransactionRequest).recvWindow(recvWindow).nonce(nonce).execute();

Build DeFi Deposit Transaction

Build the unsigned transaction calldata for a DeFi deposit / stake. Returns an ordered &#x60;dataList&#x60; (typically &#x60;[APPROVE, DEPOSIT]&#x60;, or &#x60;[DEPOSIT]&#x60; when the allowance is already sufficient) for the caller to sign and broadcast. The caller does NOT pass &#x60;binanceChainId&#x60; — the service resolves it from &#x60;investmentId&#x60;. Set &#x60;simulate&#x3D;true&#x60; to also receive a &#x60;preview&#x60; (projected balance change, estimated gas, and lending health-factor change) without broadcasting.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.DefiTransactionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    DefiTransactionApi apiInstance = new DefiTransactionApi(defaultClient);
    BuildDeFiDepositTransactionRequest buildDeFiDepositTransactionRequest = new BuildDeFiDepositTransactionRequest(); // BuildDeFiDepositTransactionRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      BuildDeFiDepositTransactionResponse result = apiInstance.buildDeFiDepositTransaction(buildDeFiDepositTransactionRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefiTransactionApi#buildDeFiDepositTransaction");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **buildDeFiDepositTransactionRequest** | [**BuildDeFiDepositTransactionRequest**](BuildDeFiDepositTransactionRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**BuildDeFiDepositTransactionResponse**](BuildDeFiDepositTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Deposit transaction calldata returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="buildDeFiRedeemTransaction"></a>
# **buildDeFiRedeemTransaction**
> BuildDeFiRedeemTransactionResponse buildDeFiRedeemTransaction(buildDeFiRedeemTransactionRequest).recvWindow(recvWindow).nonce(nonce).execute();

Build DeFi Redeem Transaction

Build the unsigned transaction calldata for a DeFi redeem / withdraw. Returns an ordered &#x60;dataList&#x60; (typically &#x60;[REDEEM]&#x60; or &#x60;[APPROVE, REDEEM]&#x60;). **Redeem amount is decided by exactly one of &#x60;ratio&#x60; or &#x60;token&#x60;** (mutually exclusive): - &#x60;ratio&#x60; omitted / blank → **exact-amount redeem**: the amount comes from   &#x60;token&#x60; (&#x60;tokenAddress&#x60; + &#x60;amount&#x60;); the position is *not* queried. &#x60;token&#x60; is required   in this mode (omitting &#x60;token&#x60;, or leaving &#x60;amount&#x60; blank, is rejected with &#x60;40001&#x60;,   &#x60;Parameter error&#x60;; both &#x60;ratio&#x60; and &#x60;token&#x60; absent is also rejected with &#x60;40001&#x60;). - &#x60;ratio&#x60; present → **proportional redeem**: must parse as a decimal in &#x60;(0, 1]&#x60;. The   service queries the user&#39;s on-chain position under &#x60;investmentId&#x60; and scales each   token&#39;s amount by &#x60;ratio&#x60; (floored to the token&#39;s decimals). &#x60;ratio&#x3D;\&quot;1\&quot;&#x60; is a full (max)   redeem. In this mode &#x60;token&#x60; is **ignored** — the output tokens and amounts are derived   from the position.  &#x60;slippageBps&#x60; is the slippage tolerance in basis points (e.g. &#x60;300&#x60; &#x3D; 3%). The caller does NOT pass &#x60;binanceChainId&#x60; — resolved from &#x60;investmentId&#x60;. Set &#x60;simulate&#x3D;true&#x60; to also receive &#x60;preview&#x60;. The response also carries &#x60;redeemDelayDays&#x60; — the redeem waiting period as a &#x60;[min, max]&#x60; day pair (e.g. &#x60;[\&quot;7\&quot;,\&quot;10\&quot;]&#x60; &#x3D; 7–10 days, &#x60;[]&#x60; &#x3D; instant). The wait starts after the redeem tx is confirmed on-chain. See the &#x60;redeemDelayDays&#x60; field on &#x60;DefiTxResponse&#x60;.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.DefiTransactionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    DefiTransactionApi apiInstance = new DefiTransactionApi(defaultClient);
    BuildDeFiRedeemTransactionRequest buildDeFiRedeemTransactionRequest = new BuildDeFiRedeemTransactionRequest(); // BuildDeFiRedeemTransactionRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      BuildDeFiRedeemTransactionResponse result = apiInstance.buildDeFiRedeemTransaction(buildDeFiRedeemTransactionRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefiTransactionApi#buildDeFiRedeemTransaction");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **buildDeFiRedeemTransactionRequest** | [**BuildDeFiRedeemTransactionRequest**](BuildDeFiRedeemTransactionRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**BuildDeFiRedeemTransactionResponse**](BuildDeFiRedeemTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Redeem transaction calldata returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="buildLpAddTransaction"></a>
# **buildLpAddTransaction**
> BuildLpAddTransactionResponse buildLpAddTransaction(buildLpAddTransactionRequest).recvWindow(recvWindow).nonce(nonce).execute();

Build LP Add Transaction

Build the unsigned transaction calldata for adding liquidity. &#x60;tokenList&#x60; supports multiple tokens. Returns an ordered &#x60;dataList&#x60; (typically &#x60;[APPROVE, LP_ADD]&#x60;). **Tick range source (provide exactly one group)**: 1. &#x60;nftId&#x60; — append to an existing LP position (reuses its range). 2. &#x60;priceRange&#x60; — percentage band (e.g. &#x60;\&quot;5\&quot;&#x60; &#x3D; ±5%) for a new position. 3. &#x60;tickLower&#x60; + &#x60;tickUpper&#x60; — explicit raw &#x60;int24&#x60; pair for a new position. **Rules**: - If more than one group is supplied, only the highest-priority one above is used and the   others are silently ignored (priority: &#x60;nftId&#x60; &gt; &#x60;priceRange&#x60; &gt; explicit tick pair).  - If none is supplied, the request is rejected (&#x60;40453&#x60;). - &#x60;tickLower&#x60; / &#x60;tickUpper&#x60; are raw &#x60;int24&#x60; values and MUST be aligned to the pool&#39;s   &#x60;tickSpacing&#x60;, otherwise the request is rejected (&#x60;40453&#x60;).  - The caller does NOT pass &#x60;binanceChainId&#x60; — resolved from &#x60;investmentId&#x60;.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.DefiTransactionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    DefiTransactionApi apiInstance = new DefiTransactionApi(defaultClient);
    BuildLpAddTransactionRequest buildLpAddTransactionRequest = new BuildLpAddTransactionRequest(); // BuildLpAddTransactionRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      BuildLpAddTransactionResponse result = apiInstance.buildLpAddTransaction(buildLpAddTransactionRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefiTransactionApi#buildLpAddTransaction");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **buildLpAddTransactionRequest** | [**BuildLpAddTransactionRequest**](BuildLpAddTransactionRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**BuildLpAddTransactionResponse**](BuildLpAddTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | LP add transaction calldata returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="buildLpRemoveTransaction"></a>
# **buildLpRemoveTransaction**
> BuildLpRemoveTransactionResponse buildLpRemoveTransaction(buildLpRemoveTransactionRequest).recvWindow(recvWindow).nonce(nonce).execute();

Build LP Remove Transaction

Build the unsigned transaction calldata for removing liquidity. Removal is by &#x60;nftId&#x60; + &#x60;ratio&#x60; (range &#x60;(0, 1]&#x60;) — no &#x60;tokenList&#x60; is needed; the per-token amounts are derived from the on-chain position. Returns an ordered &#x60;dataList&#x60; (typically &#x60;[LP_REMOVE]&#x60;). &#x60;slippageBps&#x60; is the LP-leg slippage tolerance in basis points. The caller does NOT pass &#x60;binanceChainId&#x60; — resolved from &#x60;investmentId&#x60;.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.DefiTransactionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    DefiTransactionApi apiInstance = new DefiTransactionApi(defaultClient);
    BuildLpRemoveTransactionRequest buildLpRemoveTransactionRequest = new BuildLpRemoveTransactionRequest(); // BuildLpRemoveTransactionRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      BuildLpRemoveTransactionResponse result = apiInstance.buildLpRemoveTransaction(buildLpRemoveTransactionRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefiTransactionApi#buildLpRemoveTransaction");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **buildLpRemoveTransactionRequest** | [**BuildLpRemoveTransactionRequest**](BuildLpRemoveTransactionRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**BuildLpRemoveTransactionResponse**](BuildLpRemoveTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | LP remove transaction calldata returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="calculateLpAddPairedAmounts"></a>
# **calculateLpAddPairedAmounts**
> CalculateLpAddPairedAmountsResponse calculateLpAddPairedAmounts(calculateLpAddPairedAmountsRequest).recvWindow(recvWindow).nonce(nonce).execute();

Calculate LP Add Paired Amounts

Given a single input token, calculate the paired token amount needed for an LP add. This is a **pure computation endpoint** — it does not touch the chain and does not deduct any fee. Use it before &#x60;/transaction/lp-add&#x60; to size the paired token when only one side is supplied. Tick range source rules are the same as &#x60;/lp-add&#x60; — provide exactly one group: &#x60;nftId&#x60; (existing position), &#x60;priceRange&#x60;, or &#x60;tickLower&#x60;+&#x60;tickUpper&#x60;. - If more than one group is supplied, only the highest-priority one is used and the others   are silently ignored (priority: &#x60;nftId&#x60; &gt; &#x60;priceRange&#x60; &gt; explicit tick pair).  - If none is supplied, the request is rejected. - The caller does NOT pass &#x60;binanceChainId&#x60; — resolved from &#x60;investmentId&#x60;.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.DefiTransactionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    DefiTransactionApi apiInstance = new DefiTransactionApi(defaultClient);
    CalculateLpAddPairedAmountsRequest calculateLpAddPairedAmountsRequest = new CalculateLpAddPairedAmountsRequest(); // CalculateLpAddPairedAmountsRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      CalculateLpAddPairedAmountsResponse result = apiInstance.calculateLpAddPairedAmounts(calculateLpAddPairedAmountsRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefiTransactionApi#calculateLpAddPairedAmounts");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **calculateLpAddPairedAmountsRequest** | [**CalculateLpAddPairedAmountsRequest**](CalculateLpAddPairedAmountsRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**CalculateLpAddPairedAmountsResponse**](CalculateLpAddPairedAmountsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Paired token amounts returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

