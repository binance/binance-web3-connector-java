# WalletApi

All URIs are relative to *https://web3.binance.com/build*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllTokenBalancesByAddress**](WalletApi.md#getAllTokenBalancesByAddress) | **GET** /api/v1/dex/balance/all-token-balances-by-address | Get All Token Balances by Address |
| [**getTokenBalancesByAddress**](WalletApi.md#getTokenBalancesByAddress) | **POST** /api/v1/dex/balance/token-balances-by-address | Get Token Balances by Address |
| [**getTransactionDetailByHash**](WalletApi.md#getTransactionDetailByHash) | **GET** /api/v1/dex/post-transaction/transaction-detail-by-txhash | Get Transaction Detail by Hash |
| [**getTransactionsByAddress**](WalletApi.md#getTransactionsByAddress) | **GET** /api/v1/dex/post-transaction/transactions-by-address | Get Transactions by Address |
| [**getWalletSupportedChains**](WalletApi.md#getWalletSupportedChains) | **GET** /api/v1/dex/balance/supported/chain | Get Wallet Supported Chains |


<a id="getAllTokenBalancesByAddress"></a>
# **getAllTokenBalancesByAddress**
> GetAllTokenBalancesByAddressResponse getAllTokenBalancesByAddress().recvWindow(recvWindow).nonce(nonce).address(address).chains(chains).excludeRiskToken(excludeRiskToken).page(page).pageSize(pageSize).execute();

Get All Token Balances by Address

Return all token balances held by an address across one or more chains, with pagination support. Set &#x60;excludeRiskToken&#x3D;true&#x60; to filter out airdrop-risk and honeypot tokens (honeypot detection currently applies only to ETH / BSC / SOL / BASE).

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.WalletApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    WalletApi apiInstance = new WalletApi(defaultClient);
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String address = "0xed0c6079229e2d407672a117c22b62064f4a4312"; // String | Wallet address to query.
    String chains = "1,56"; // String | Comma-separated list of chain identifiers.
    Boolean excludeRiskToken = true; // Boolean | Whether to exclude risk-flagged tokens.
    Long page = 1L; // Long | Page number. Defaults to 1.
    Integer pageSize = 20; // Integer | Page size. Range 1–100. Defaults to 20.
    try {
      GetAllTokenBalancesByAddressResponse result = apiInstance.getAllTokenBalancesByAddress()
            .recvWindow(recvWindow)
            .nonce(nonce)
            .address(address)
            .chains(chains)
            .excludeRiskToken(excludeRiskToken)
            .page(page)
            .pageSize(pageSize)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WalletApi#getAllTokenBalancesByAddress");
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
| **address** | **String**| Wallet address to query. | [optional] |
| **chains** | **String**| Comma-separated list of chain identifiers. | [optional] |
| **excludeRiskToken** | **Boolean**| Whether to exclude risk-flagged tokens. | [optional] |
| **page** | **Long**| Page number. Defaults to 1. | [optional] |
| **pageSize** | **Integer**| Page size. Range 1–100. Defaults to 20. | [optional] |

### Return type

[**GetAllTokenBalancesByAddressResponse**](GetAllTokenBalancesByAddressResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Token balances returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getTokenBalancesByAddress"></a>
# **getTokenBalancesByAddress**
> GetTokenBalancesByAddressResponse getTokenBalancesByAddress(getTokenBalancesByAddressRequest).recvWindow(recvWindow).nonce(nonce).execute();

Get Token Balances by Address

Return token balances for a specific list of (chain, contract) pairs. Up to 20 entries per request. Set &#x60;excludeRiskToken&#x3D;\&quot;0\&quot;&#x60; to exclude risk-flagged tokens (default), or &#x60;\&quot;1\&quot;&#x60; to include them.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.WalletApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    WalletApi apiInstance = new WalletApi(defaultClient);
    GetTokenBalancesByAddressRequest getTokenBalancesByAddressRequest = new GetTokenBalancesByAddressRequest(); // GetTokenBalancesByAddressRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetTokenBalancesByAddressResponse result = apiInstance.getTokenBalancesByAddress(getTokenBalancesByAddressRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WalletApi#getTokenBalancesByAddress");
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
| **getTokenBalancesByAddressRequest** | [**GetTokenBalancesByAddressRequest**](GetTokenBalancesByAddressRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetTokenBalancesByAddressResponse**](GetTokenBalancesByAddressResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Token balances returned successfully. |  -  |
| **201** | Created. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getTransactionDetailByHash"></a>
# **getTransactionDetailByHash**
> GetTransactionDetailByHashResponse getTransactionDetailByHash().recvWindow(recvWindow).nonce(nonce).binanceChainId(binanceChainId).txHash(txHash).itype(itype).execute();

Get Transaction Detail by Hash

Look up the full on-chain transaction detail by &#x60;binanceChainId&#x60; + &#x60;txHash&#x60;. Returns one or more entries describing transaction inputs, outputs, internal calls, and token transfers.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.WalletApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    WalletApi apiInstance = new WalletApi(defaultClient);
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String binanceChainId = "1"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana).
    String txHash = "0xabc123def4567890abc123def4567890abc123def4567890abc123def4567890"; // String | On-chain transaction hash.
    String itype = "0"; // String | Transaction-type filter (UTXO chains). Reserved — currently has no effect. Values: \"0\"=outer native-token, \"1\"=internal contract native-token, \"2\"=token transfer.
    try {
      GetTransactionDetailByHashResponse result = apiInstance.getTransactionDetailByHash()
            .recvWindow(recvWindow)
            .nonce(nonce)
            .binanceChainId(binanceChainId)
            .txHash(txHash)
            .itype(itype)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WalletApi#getTransactionDetailByHash");
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
| **binanceChainId** | **String**| Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). | [optional] |
| **txHash** | **String**| On-chain transaction hash. | [optional] |
| **itype** | **String**| Transaction-type filter (UTXO chains). Reserved — currently has no effect. Values: \&quot;0\&quot;&#x3D;outer native-token, \&quot;1\&quot;&#x3D;internal contract native-token, \&quot;2\&quot;&#x3D;token transfer. | [optional] |

### Return type

[**GetTransactionDetailByHashResponse**](GetTransactionDetailByHashResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Transaction details returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getTransactionsByAddress"></a>
# **getTransactionsByAddress**
> GetTransactionsByAddressResponse getTransactionsByAddress(address, chains).recvWindow(recvWindow).nonce(nonce).tokenContractAddress(tokenContractAddress).begin(begin).end(end).cursor(cursor).limit(limit).execute();

Get Transactions by Address

Return on-chain transaction history for a wallet address across one or more chains. Results are limited to the most recent 6 months and sorted by time (descending). Supports cursor pagination, time-range filtering, and token-contract filtering.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.WalletApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    WalletApi apiInstance = new WalletApi(defaultClient);
    String address = "0xd8dA6BF26964aF9D7eEd9e03E53415D37aA96045"; // String | Wallet address to query.
    String chains = "1,56"; // String | Comma-separated list of chain identifiers.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String tokenContractAddress = "0xdAC17F958D2ee523a2206206994597C13D831ec7"; // String | Optional token contract address filter.
    Long begin = 1746000000000L; // Long | Optional start timestamp (Unix milliseconds, inclusive).
    Long end = 1748601600000L; // Long | Optional end timestamp (Unix milliseconds, inclusive).
    String cursor = "eyJ0aW1lIjoxNzQ4NjAwMDAwMDAwLCJpZCI6MTIzfQ=="; // String | Pagination cursor returned by the previous page.
    Integer limit = 20; // Integer | Page size. Range 1–100. Defaults to 20.
    try {
      GetTransactionsByAddressResponse result = apiInstance.getTransactionsByAddress(address, chains)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .tokenContractAddress(tokenContractAddress)
            .begin(begin)
            .end(end)
            .cursor(cursor)
            .limit(limit)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WalletApi#getTransactionsByAddress");
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
| **address** | **String**| Wallet address to query. | |
| **chains** | **String**| Comma-separated list of chain identifiers. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **tokenContractAddress** | **String**| Optional token contract address filter. | [optional] |
| **begin** | **Long**| Optional start timestamp (Unix milliseconds, inclusive). | [optional] |
| **end** | **Long**| Optional end timestamp (Unix milliseconds, inclusive). | [optional] |
| **cursor** | **String**| Pagination cursor returned by the previous page. | [optional] |
| **limit** | **Integer**| Page size. Range 1–100. Defaults to 20. | [optional] |

### Return type

[**GetTransactionsByAddressResponse**](GetTransactionsByAddressResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Transaction history returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getWalletSupportedChains"></a>
# **getWalletSupportedChains**
> GetWalletSupportedChainsResponse getWalletSupportedChains().recvWindow(recvWindow).nonce(nonce).binanceChainId(binanceChainId).execute();

Get Wallet Supported Chains

Return blockchain networks for which the Wallet service can return balances. The supported list is dynamically configured server-side and may change over time. Pass &#x60;binanceChainId&#x60; to filter to a single chain; omit to get the full list.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.WalletApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    WalletApi apiInstance = new WalletApi(defaultClient);
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String binanceChainId = "1"; // String | Optional chain identifier. When set, only that chain is returned.
    try {
      GetWalletSupportedChainsResponse result = apiInstance.getWalletSupportedChains()
            .recvWindow(recvWindow)
            .nonce(nonce)
            .binanceChainId(binanceChainId)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WalletApi#getWalletSupportedChains");
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
| **binanceChainId** | **String**| Optional chain identifier. When set, only that chain is returned. | [optional] |

### Return type

[**GetWalletSupportedChainsResponse**](GetWalletSupportedChainsResponse.md)

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

