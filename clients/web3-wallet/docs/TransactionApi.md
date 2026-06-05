# TransactionApi

All URIs are relative to *https://web3.binance.com/build*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**broadcastTransactions**](TransactionApi.md#broadcastTransactions) | **POST** /api/v1/dex/pre-transaction/broadcast-transaction | Broadcast Transactions |
| [**getBroadcastOrders**](TransactionApi.md#getBroadcastOrders) | **GET** /api/v1/dex/post-transaction/orders | Get Broadcast Orders |
| [**getGasLimit**](TransactionApi.md#getGasLimit) | **POST** /api/v1/dex/pre-transaction/gas-limit | Get Gas Limit |
| [**getGasPrice**](TransactionApi.md#getGasPrice) | **GET** /api/v1/dex/pre-transaction/gas-price | Get Gas Price |
| [**getTransactionSupportedChains**](TransactionApi.md#getTransactionSupportedChains) | **GET** /api/v1/dex/pre-transaction/supported/chain | Get Transaction Supported Chains |
| [**simulateTransactions**](TransactionApi.md#simulateTransactions) | **POST** /api/v1/dex/pre-transaction/simulate | Simulate Transactions |


<a id="broadcastTransactions"></a>
# **broadcastTransactions**
> BroadcastTransactionsResponse broadcastTransactions(broadcastTransactionsRequest).recvWindow(recvWindow).nonce(nonce).execute();

Broadcast Transactions

Broadcast a client-signed transaction to the chain via the OnchainOS relay. Returns the transaction hash and an internal &#x60;orderId&#x60; you can use to track on-chain status via the post-transaction service. Optional MEV protection (EVM chains only) routes the transaction through a private mempool to mitigate front-running and sandwich attacks.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TransactionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TransactionApi apiInstance = new TransactionApi(defaultClient);
    BroadcastTransactionsRequest broadcastTransactionsRequest = new BroadcastTransactionsRequest(); // BroadcastTransactionsRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      BroadcastTransactionsResponse result = apiInstance.broadcastTransactions(broadcastTransactionsRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionApi#broadcastTransactions");
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
| **broadcastTransactionsRequest** | [**BroadcastTransactionsRequest**](BroadcastTransactionsRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**BroadcastTransactionsResponse**](BroadcastTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Transaction submitted successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getBroadcastOrders"></a>
# **getBroadcastOrders**
> GetBroadcastOrdersResponse getBroadcastOrders(address, binanceChainId).recvWindow(recvWindow).nonce(nonce).txStatus(txStatus).orderId(orderId).cursor(cursor).limit(limit).execute();

Get Broadcast Orders

Look up broadcast orders previously submitted via &#x60;/pre-transaction/broadcast-transaction&#x60;. Filter by &#x60;txStatus&#x60; or &#x60;orderId&#x60;, paginate with &#x60;cursor&#x60;.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TransactionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TransactionApi apiInstance = new TransactionApi(defaultClient);
    String address = "0xd8dA6BF26964aF9D7eEd9e03E53415D37aA96045"; // String | Sender wallet address whose orders to list.
    String binanceChainId = "1"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana).
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String txStatus = "success"; // String | Optional filter on transaction status (server-defined string, e.g. \"pending\", \"success\", \"fail\").
    String orderId = "1812345678901234567"; // String | Optional filter to fetch a single order by its internal order ID.
    String cursor = "eyJ0aW1lIjoxNzQ4NjAwMDAwMDAwLCJpZCI6MTIzfQ=="; // String | Pagination cursor returned by the previous page. Omit on the first request.
    Integer limit = 20; // Integer | Page size. Defaults to 20.
    try {
      GetBroadcastOrdersResponse result = apiInstance.getBroadcastOrders(address, binanceChainId)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .txStatus(txStatus)
            .orderId(orderId)
            .cursor(cursor)
            .limit(limit)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionApi#getBroadcastOrders");
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
| **address** | **String**| Sender wallet address whose orders to list. | |
| **binanceChainId** | **String**| Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **txStatus** | **String**| Optional filter on transaction status (server-defined string, e.g. \&quot;pending\&quot;, \&quot;success\&quot;, \&quot;fail\&quot;). | [optional] |
| **orderId** | **String**| Optional filter to fetch a single order by its internal order ID. | [optional] |
| **cursor** | **String**| Pagination cursor returned by the previous page. Omit on the first request. | [optional] |
| **limit** | **Integer**| Page size. Defaults to 20. | [optional] [default to 20] |

### Return type

[**GetBroadcastOrdersResponse**](GetBroadcastOrdersResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Orders returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getGasLimit"></a>
# **getGasLimit**
> GetGasLimitResponse getGasLimit(getGasLimitRequest).recvWindow(recvWindow).nonce(nonce).execute();

Get Gas Limit

Estimate the gas limit (or compute-unit ceiling on Solana) for an unsigned transaction. Provide either &#x60;evmTx&#x60; for EVM chains or &#x60;solTx&#x60; for Solana, matching the value of &#x60;binanceChainId&#x60;.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TransactionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TransactionApi apiInstance = new TransactionApi(defaultClient);
    GetGasLimitRequest getGasLimitRequest = new GetGasLimitRequest(); // GetGasLimitRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetGasLimitResponse result = apiInstance.getGasLimit(getGasLimitRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionApi#getGasLimit");
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
| **getGasLimitRequest** | [**GetGasLimitRequest**](GetGasLimitRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetGasLimitResponse**](GetGasLimitResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Estimated gas limit. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getGasPrice"></a>
# **getGasPrice**
> GetGasPriceResponse getGasPrice(binanceChainId).recvWindow(recvWindow).nonce(nonce).execute();

Get Gas Price

Query the current network gas price for the specified chain. The response shape varies by chain family: - EVM chains return both &#x60;evmLegacyGasPrice&#x60; (legacy gasPrice) and   &#x60;eip1559GasPrice&#x60; (baseFee + priority/max fees) when EIP-1559 is supported. - Solana returns &#x60;solanaGasPrice&#x60; (compute-unit prices and Jito tips). Fields not applicable to the chain family are returned as &#x60;null&#x60;.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TransactionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TransactionApi apiInstance = new TransactionApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana).
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetGasPriceResponse result = apiInstance.getGasPrice(binanceChainId)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionApi#getGasPrice");
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
| **binanceChainId** | **String**| Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetGasPriceResponse**](GetGasPriceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Current gas price for the specified chain. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getTransactionSupportedChains"></a>
# **getTransactionSupportedChains**
> GetTransactionSupportedChainsResponse getTransactionSupportedChains().recvWindow(recvWindow).nonce(nonce).execute();

Get Transaction Supported Chains

Return the blockchain networks supported by the Transaction service for gas estimation, simulation, and broadcasting. The list is dynamically configured server-side and may change over time.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TransactionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TransactionApi apiInstance = new TransactionApi(defaultClient);
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetTransactionSupportedChainsResponse result = apiInstance.getTransactionSupportedChains()
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionApi#getTransactionSupportedChains");
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

### Return type

[**GetTransactionSupportedChainsResponse**](GetTransactionSupportedChainsResponse.md)

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

<a id="simulateTransactions"></a>
# **simulateTransactions**
> SimulateTransactionsResponse simulateTransactions(simulateTransactionsRequest).recvWindow(recvWindow).nonce(nonce).execute();

Simulate Transactions

Simulate transaction execution off-chain to predict its outcome before broadcasting. The response includes the predicted execution status, balance changes per affected account/token, and ERC-20 allowance changes (EVM chains). Provide either &#x60;evmTx&#x60; (EVM chains) or &#x60;solTx&#x60; (Solana) matching &#x60;binanceChainId&#x60;.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TransactionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TransactionApi apiInstance = new TransactionApi(defaultClient);
    SimulateTransactionsRequest simulateTransactionsRequest = new SimulateTransactionsRequest(); // SimulateTransactionsRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      SimulateTransactionsResponse result = apiInstance.simulateTransactions(simulateTransactionsRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionApi#simulateTransactions");
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
| **simulateTransactionsRequest** | [**SimulateTransactionsRequest**](SimulateTransactionsRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**SimulateTransactionsResponse**](SimulateTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Simulation result. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

