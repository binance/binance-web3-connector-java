# TradingApi

All URIs are relative to *https://web3.binance.com/build*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**buildSwapTransaction**](TradingApi.md#buildSwapTransaction) | **GET** /api/v1/dex/aggregator/swap | Build Swap Transaction |
| [**getAggregatedQuote**](TradingApi.md#getAggregatedQuote) | **GET** /api/v1/dex/aggregator/quote | Get Aggregated Quote |
| [**getAggregatorSupportedChains**](TradingApi.md#getAggregatorSupportedChains) | **GET** /api/v1/dex/aggregator/supported/chain | Get Aggregator Supported Chains |
| [**getErc20ApproveTransaction**](TradingApi.md#getErc20ApproveTransaction) | **GET** /api/v1/dex/aggregator/approve-transaction | Get ERC-20 Approve Transaction |
| [**getTransactionStatus**](TradingApi.md#getTransactionStatus) | **GET** /api/v1/dex/aggregator/history | Get Transaction Status |


<a id="buildSwapTransaction"></a>
# **buildSwapTransaction**
> BuildSwapTransactionResponse buildSwapTransaction(binanceChainId, amount, fromTokenAddress, toTokenAddress, slippagePercent, userWalletAddress, quoteId).recvWindow(recvWindow).nonce(nonce).approveTransaction(approveTransaction).approveAmount(approveAmount).gasLimit(gasLimit).gasLevel(gasLevel).priceImpactProtectionPercent(priceImpactProtectionPercent).autoSlippage(autoSlippage).maxAutoSlippagePercent(maxAutoSlippagePercent).computeUnitLimit(computeUnitLimit).computeUnitPrice(computeUnitPrice).tips(tips).execute();

Build Swap Transaction

Build the on-chain swap calldata for a previously quoted route. The request is matched against the cached quote by &#x60;quoteId&#x60; (TTL ~30s); if the entry has expired, &#x60;QUOTE_EXPIRED&#x60; (40401) is returned, and if the request parameters disagree with the cached quote, &#x60;SWAP_QUOTE_MISMATCH&#x60; (40462) is returned.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TradingApi apiInstance = new TradingApi(defaultClient);
    String binanceChainId = "56"; // String | Unique chain identifier (e.g. \"56\"=BSC, \"1\"=Ethereum, \"CT_501\"=Solana).
    String amount = "1000000"; // String | Sell-token amount in the token's smallest unit (positive integer string, no decimals).
    String fromTokenAddress = "0x55d398326f99059fF775485246999027B3197955"; // String | Sell-token contract address.
    String toTokenAddress = "0x8AC76a51cc950d9822D68b83fE1Ad97B32Cd580d"; // String | Buy-token contract address.
    String slippagePercent = "0.5"; // String | Maximum slippage as a percentage. EVM range 0–100; Solana range 0 to less than 100. \"0.5\" means 0.5%.
    String userWalletAddress = "0xd8dA6BF26964aF9D7eEd9e03E53415D37aA96045"; // String | User wallet address (transaction sender).
    String quoteId = "a1b2c3d4e5f64a8b9c0d1e2f3a4b5c6d"; // String | quoteId returned from `/quote` for the route to execute. TTL ~30s; expired entries return `QUOTE_EXPIRED` (40401).
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    ApproveTransaction approveTransaction = ApproveTransaction.fromValue("true"); // ApproveTransaction | When \"true\", `signatureData` includes the spender address and approve calldata so the client can submit it before the swap. Defaults to false.
    String approveAmount = "1000000"; // String | Override approve amount (smallest unit, positive integer string). Defaults to the swap amount.
    String gasLimit = "200000"; // String | Gas limit override (positive integer string). EVM only.
    GasLevel gasLevel = GasLevel.fromValue("slow"); // GasLevel | Gas price tier. Defaults to \"average\".
    String priceImpactProtectionPercent = "90"; // String | Maximum allowed price impact percentage (0–100). Defaults to 90; set to 100 to disable.
    AutoSlippage autoSlippage = AutoSlippage.fromValue("true"); // AutoSlippage | When \"true\", slippage is auto-derived from market data and overrides `slippagePercent`. Defaults to false.
    String maxAutoSlippagePercent = "3"; // String | Cap on auto-derived slippage (only applies when `autoSlippage=true`).
    String computeUnitLimit = "1400000"; // String | Solana only — maximum compute units the transaction may consume (analogous to EVM gasLimit). Applies only when `binanceChainId=CT_501`.
    String computeUnitPrice = "1000"; // String | Solana only — priority fee per compute unit (micro-lamports), analogous to EVM gasPrice. When omitted, the platform computes a value dynamically. Applies only when `binanceChainId=CT_501`.
    String tips = "0.001"; // String | Solana only — Jito tips in SOL for MEV protection. Valid range [0.000000001, 2] (minimum 1 lamport). When specified, it is recommended to set `computeUnitPrice=0`. Applies only when `binanceChainId=CT_501`.
    try {
      BuildSwapTransactionResponse result = apiInstance.buildSwapTransaction(binanceChainId, amount, fromTokenAddress, toTokenAddress, slippagePercent, userWalletAddress, quoteId)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .approveTransaction(approveTransaction)
            .approveAmount(approveAmount)
            .gasLimit(gasLimit)
            .gasLevel(gasLevel)
            .priceImpactProtectionPercent(priceImpactProtectionPercent)
            .autoSlippage(autoSlippage)
            .maxAutoSlippagePercent(maxAutoSlippagePercent)
            .computeUnitLimit(computeUnitLimit)
            .computeUnitPrice(computeUnitPrice)
            .tips(tips)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TradingApi#buildSwapTransaction");
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
| **binanceChainId** | **String**| Unique chain identifier (e.g. \&quot;56\&quot;&#x3D;BSC, \&quot;1\&quot;&#x3D;Ethereum, \&quot;CT_501\&quot;&#x3D;Solana). | |
| **amount** | **String**| Sell-token amount in the token&#39;s smallest unit (positive integer string, no decimals). | |
| **fromTokenAddress** | **String**| Sell-token contract address. | |
| **toTokenAddress** | **String**| Buy-token contract address. | |
| **slippagePercent** | **String**| Maximum slippage as a percentage. EVM range 0–100; Solana range 0 to less than 100. \&quot;0.5\&quot; means 0.5%. | |
| **userWalletAddress** | **String**| User wallet address (transaction sender). | |
| **quoteId** | **String**| quoteId returned from &#x60;/quote&#x60; for the route to execute. TTL ~30s; expired entries return &#x60;QUOTE_EXPIRED&#x60; (40401). | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **approveTransaction** | [**ApproveTransaction**](.md)| When \&quot;true\&quot;, &#x60;signatureData&#x60; includes the spender address and approve calldata so the client can submit it before the swap. Defaults to false. | [optional] [enum: true, false] |
| **approveAmount** | **String**| Override approve amount (smallest unit, positive integer string). Defaults to the swap amount. | [optional] |
| **gasLimit** | **String**| Gas limit override (positive integer string). EVM only. | [optional] |
| **gasLevel** | [**GasLevel**](.md)| Gas price tier. Defaults to \&quot;average\&quot;. | [optional] [enum: slow, average, fast] |
| **priceImpactProtectionPercent** | **String**| Maximum allowed price impact percentage (0–100). Defaults to 90; set to 100 to disable. | [optional] |
| **autoSlippage** | [**AutoSlippage**](.md)| When \&quot;true\&quot;, slippage is auto-derived from market data and overrides &#x60;slippagePercent&#x60;. Defaults to false. | [optional] [enum: true, false] |
| **maxAutoSlippagePercent** | **String**| Cap on auto-derived slippage (only applies when &#x60;autoSlippage&#x3D;true&#x60;). | [optional] |
| **computeUnitLimit** | **String**| Solana only — maximum compute units the transaction may consume (analogous to EVM gasLimit). Applies only when &#x60;binanceChainId&#x3D;CT_501&#x60;. | [optional] |
| **computeUnitPrice** | **String**| Solana only — priority fee per compute unit (micro-lamports), analogous to EVM gasPrice. When omitted, the platform computes a value dynamically. Applies only when &#x60;binanceChainId&#x3D;CT_501&#x60;. | [optional] |
| **tips** | **String**| Solana only — Jito tips in SOL for MEV protection. Valid range [0.000000001, 2] (minimum 1 lamport). When specified, it is recommended to set &#x60;computeUnitPrice&#x3D;0&#x60;. Applies only when &#x60;binanceChainId&#x3D;CT_501&#x60;. | [optional] |

### Return type

[**BuildSwapTransactionResponse**](BuildSwapTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Swap transaction data returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getAggregatedQuote"></a>
# **getAggregatedQuote**
> GetAggregatedQuoteResponse getAggregatedQuote(binanceChainId, amount, fromTokenAddress, toTokenAddress).recvWindow(recvWindow).nonce(nonce).execute();

Get Aggregated Quote

Query multiple DEX vendors in parallel and return the priced routes sorted by &#x60;toTokenAmount&#x60; (descending). Each route carries an independent &#x60;quoteId&#x60; (TTL ~30s) that the swap endpoint consumes to construct calldata for the chosen route.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TradingApi apiInstance = new TradingApi(defaultClient);
    String binanceChainId = "56"; // String | Unique chain identifier (e.g. \"56\"=BSC, \"1\"=Ethereum, \"CT_501\"=Solana).
    String amount = "1000000"; // String | Sell-token amount in the token's smallest unit (positive integer string, no decimals). Example \"1000000\" = 1 USDT (decimals=6).
    String fromTokenAddress = "0x55d398326f99059fF775485246999027B3197955"; // String | Sell-token contract address. EVM chains require 0x + 40 hex chars; non-EVM chains use the chain's native address format.
    String toTokenAddress = "0x8AC76a51cc950d9822D68b83fE1Ad97B32Cd580d"; // String | Buy-token contract address. Must differ from `fromTokenAddress`.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetAggregatedQuoteResponse result = apiInstance.getAggregatedQuote(binanceChainId, amount, fromTokenAddress, toTokenAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TradingApi#getAggregatedQuote");
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
| **binanceChainId** | **String**| Unique chain identifier (e.g. \&quot;56\&quot;&#x3D;BSC, \&quot;1\&quot;&#x3D;Ethereum, \&quot;CT_501\&quot;&#x3D;Solana). | |
| **amount** | **String**| Sell-token amount in the token&#39;s smallest unit (positive integer string, no decimals). Example \&quot;1000000\&quot; &#x3D; 1 USDT (decimals&#x3D;6). | |
| **fromTokenAddress** | **String**| Sell-token contract address. EVM chains require 0x + 40 hex chars; non-EVM chains use the chain&#39;s native address format. | |
| **toTokenAddress** | **String**| Buy-token contract address. Must differ from &#x60;fromTokenAddress&#x60;. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetAggregatedQuoteResponse**](GetAggregatedQuoteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Quote routes returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getAggregatorSupportedChains"></a>
# **getAggregatorSupportedChains**
> GetAggregatorSupportedChainsResponse getAggregatorSupportedChains().recvWindow(recvWindow).nonce(nonce).binanceChainId(binanceChainId).execute();

Get Aggregator Supported Chains

Return blockchain networks supported by the DEX aggregator. The supported list is dynamically configured server-side and may change over time. Pass &#x60;binanceChainId&#x60; to filter to a single chain; omit it to get the full list.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TradingApi apiInstance = new TradingApi(defaultClient);
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String binanceChainId = "56"; // String | Optional chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana). When set, only that chain is returned.
    try {
      GetAggregatorSupportedChainsResponse result = apiInstance.getAggregatorSupportedChains()
            .recvWindow(recvWindow)
            .nonce(nonce)
            .binanceChainId(binanceChainId)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TradingApi#getAggregatorSupportedChains");
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
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **binanceChainId** | **String**| Optional chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). When set, only that chain is returned. | [optional] |

### Return type

[**GetAggregatorSupportedChainsResponse**](GetAggregatorSupportedChainsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Supported chains returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getErc20ApproveTransaction"></a>
# **getErc20ApproveTransaction**
> GetErc20ApproveTransactionResponse getErc20ApproveTransaction(binanceChainId, tokenContractAddress, approveAmount).recvWindow(recvWindow).nonce(nonce).execute();

Get ERC-20 Approve Transaction

Build the on-chain transaction data needed to approve the DEX router to spend a user&#39;s ERC-20 token before a swap. Calldata is encoded per the ERC-20 ABI standard (&#x60;approve()&#x60; selector + spender + amount).

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TradingApi apiInstance = new TradingApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC).
    String tokenContractAddress = "0xdAC17F958D2ee523a2206206994597C13D831ec7"; // String | ERC-20 token contract address to approve (0x + 40 hex chars).
    String approveAmount = "1000000"; // String | Approval amount in the token's smallest unit (positive integer string). Example \"1000000\" = 1 USDT (decimals=6).
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetErc20ApproveTransactionResponse result = apiInstance.getErc20ApproveTransaction(binanceChainId, tokenContractAddress, approveAmount)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TradingApi#getErc20ApproveTransaction");
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
| **binanceChainId** | **String**| Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC). | |
| **tokenContractAddress** | **String**| ERC-20 token contract address to approve (0x + 40 hex chars). | |
| **approveAmount** | **String**| Approval amount in the token&#39;s smallest unit (positive integer string). Example \&quot;1000000\&quot; &#x3D; 1 USDT (decimals&#x3D;6). | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetErc20ApproveTransactionResponse**](GetErc20ApproveTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Approve transaction data returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getTransactionStatus"></a>
# **getTransactionStatus**
> GetTransactionStatusResponse getTransactionStatus(binanceChainId, txHash).recvWindow(recvWindow).nonce(nonce).execute();

Get Transaction Status

Look up the on-chain status of a DEX swap by &#x60;binanceChainId&#x60; + &#x60;txHash&#x60;. Response semantics: - Transaction not found: &#x60;data&#x60; is &#x60;null&#x60; (not HTTP 404). - Transaction failed: &#x60;status&#x3D;failed&#x60; with &#x60;errorMsg&#x60;; aggregator   business fields (&#x60;txType&#x60;, &#x60;dexRouter&#x60;, &#x60;fromTokenDetails&#x60;,   &#x60;toTokenDetails&#x60;) are &#x60;null&#x60;.  - Transaction succeeded: &#x60;status&#x3D;success&#x60; with full token details   when an aggregator event is present.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TradingApi apiInstance = new TradingApi(defaultClient);
    String binanceChainId = "56"; // String | Unique chain identifier (e.g. \"56\"=BSC, \"1\"=Ethereum, \"CT_501\"=Solana).
    String txHash = "0xabc123def4567890abc123def4567890abc123def4567890abc123def4567890"; // String | On-chain transaction hash.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetTransactionStatusResponse result = apiInstance.getTransactionStatus(binanceChainId, txHash)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TradingApi#getTransactionStatus");
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
| **binanceChainId** | **String**| Unique chain identifier (e.g. \&quot;56\&quot;&#x3D;BSC, \&quot;1\&quot;&#x3D;Ethereum, \&quot;CT_501\&quot;&#x3D;Solana). | |
| **txHash** | **String**| On-chain transaction hash. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetTransactionStatusResponse**](GetTransactionStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Transaction details. &#x60;data&#x60; is null when no record is found. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

