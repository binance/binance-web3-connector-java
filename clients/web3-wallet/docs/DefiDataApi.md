# DefiDataApi

All URIs are relative to *https://web3.binance.com/build*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getDeFiPositions**](DefiDataApi.md#getDeFiPositions) | **POST** /api/v1/defi/data/position/list | Get DeFi Positions |
| [**getInvestmentDetail**](DefiDataApi.md#getInvestmentDetail) | **POST** /api/v1/defi/data/investment/detail | Get Investment Detail |
| [**getProtocolDetail**](DefiDataApi.md#getProtocolDetail) | **POST** /api/v1/defi/data/protocol/detail | Get Protocol Detail |
| [**listDeFiInvestments**](DefiDataApi.md#listDeFiInvestments) | **POST** /api/v1/defi/data/investment/list | List DeFi Investments |
| [**listDeFiProtocols**](DefiDataApi.md#listDeFiProtocols) | **POST** /api/v1/defi/data/protocol/list | List DeFi Protocols |


<a id="getDeFiPositions"></a>
# **getDeFiPositions**
> GetDeFiPositionsResponse getDeFiPositions(getDeFiPositionsRequest).recvWindow(recvWindow).nonce(nonce).execute();

Get DeFi Positions

Query DeFi positions for one or more wallet addresses on BSC. Returns protocol-level position summaries with token breakdowns. Optionally filter by specific chains via &#x60;binanceChainIds&#x60;. Position coverage is wider than the protocol list used by data queries and transaction building — see [Supported Chains &amp; Protocols](../supported-chains) for the difference.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.DefiDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    DefiDataApi apiInstance = new DefiDataApi(defaultClient);
    GetDeFiPositionsRequest getDeFiPositionsRequest = new GetDeFiPositionsRequest(); // GetDeFiPositionsRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetDeFiPositionsResponse result = apiInstance.getDeFiPositions(getDeFiPositionsRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefiDataApi#getDeFiPositions");
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
| **getDeFiPositionsRequest** | [**GetDeFiPositionsRequest**](GetDeFiPositionsRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetDeFiPositionsResponse**](GetDeFiPositionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | DeFi positions returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getInvestmentDetail"></a>
# **getInvestmentDetail**
> GetInvestmentDetailResponse getInvestmentDetail(getInvestmentDetailRequest).recvWindow(recvWindow).nonce(nonce).execute();

Get Investment Detail

Get detailed information for a specific DeFi investment product, including APY, TVL, supported tokens (asset / reward / LP / borrow), pool address, fee rate, and investability.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.DefiDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    DefiDataApi apiInstance = new DefiDataApi(defaultClient);
    GetInvestmentDetailRequest getInvestmentDetailRequest = new GetInvestmentDetailRequest(); // GetInvestmentDetailRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetInvestmentDetailResponse result = apiInstance.getInvestmentDetail(getInvestmentDetailRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefiDataApi#getInvestmentDetail");
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
| **getInvestmentDetailRequest** | [**GetInvestmentDetailRequest**](GetInvestmentDetailRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetInvestmentDetailResponse**](GetInvestmentDetailResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Investment detail returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getProtocolDetail"></a>
# **getProtocolDetail**
> GetProtocolDetailResponse getProtocolDetail(getProtocolDetailRequest).recvWindow(recvWindow).nonce(nonce).execute();

Get Protocol Detail

Get detailed information for a specific DeFi protocol, including description, highlights, CertiK security scores, team, fundraising, social links, and FAQ.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.DefiDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    DefiDataApi apiInstance = new DefiDataApi(defaultClient);
    GetProtocolDetailRequest getProtocolDetailRequest = new GetProtocolDetailRequest(); // GetProtocolDetailRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetProtocolDetailResponse result = apiInstance.getProtocolDetail(getProtocolDetailRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefiDataApi#getProtocolDetail");
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
| **getProtocolDetailRequest** | [**GetProtocolDetailRequest**](GetProtocolDetailRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetProtocolDetailResponse**](GetProtocolDetailResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Protocol detail returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="listDeFiInvestments"></a>
# **listDeFiInvestments**
> ListDeFiInvestmentsResponse listDeFiInvestments(listDeFiInvestmentsRequest).recvWindow(recvWindow).nonce(nonce).execute();

List DeFi Investments

List available DeFi investment products. Filter by protocol, chain, investment type, or contract address. Results are paginated and sortable.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.DefiDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    DefiDataApi apiInstance = new DefiDataApi(defaultClient);
    ListDeFiInvestmentsRequest listDeFiInvestmentsRequest = new ListDeFiInvestmentsRequest(); // ListDeFiInvestmentsRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      ListDeFiInvestmentsResponse result = apiInstance.listDeFiInvestments(listDeFiInvestmentsRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefiDataApi#listDeFiInvestments");
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
| **listDeFiInvestmentsRequest** | [**ListDeFiInvestmentsRequest**](ListDeFiInvestmentsRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**ListDeFiInvestmentsResponse**](ListDeFiInvestmentsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Investment list returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="listDeFiProtocols"></a>
# **listDeFiProtocols**
> ListDeFiProtocolsResponse listDeFiProtocols().recvWindow(recvWindow).nonce(nonce).listDeFiProtocolsRequest(listDeFiProtocolsRequest).execute();

List DeFi Protocols

List supported DeFi protocols with optional filtering by chain and investment type. Results are paginated and sortable.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.DefiDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    DefiDataApi apiInstance = new DefiDataApi(defaultClient);
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    ListDeFiProtocolsRequest listDeFiProtocolsRequest = new ListDeFiProtocolsRequest(); // ListDeFiProtocolsRequest | 
    try {
      ListDeFiProtocolsResponse result = apiInstance.listDeFiProtocols()
            .recvWindow(recvWindow)
            .nonce(nonce)
            .listDeFiProtocolsRequest(listDeFiProtocolsRequest)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefiDataApi#listDeFiProtocols");
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
| **listDeFiProtocolsRequest** | [**ListDeFiProtocolsRequest**](ListDeFiProtocolsRequest.md)|  | [optional] |

### Return type

[**ListDeFiProtocolsResponse**](ListDeFiProtocolsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Protocol list returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

