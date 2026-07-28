# RwaDataApi

All URIs are relative to *https://web3.binance.com/build*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getRwaTokenIssuancePlatforms**](RwaDataApi.md#getRwaTokenIssuancePlatforms) | **GET** /api/v1/dex/market/rwa/platforms | Get RWA Token Issuance Platforms |
| [**getRwaTokenList**](RwaDataApi.md#getRwaTokenList) | **GET** /api/v1/dex/market/rwa/tokens | Get RWA Token List |
| [**getRwaTokenPrice**](RwaDataApi.md#getRwaTokenPrice) | **GET** /api/v1/dex/market/rwa/price | Get RWA Token Price |
| [**getRwaUnderlyingInfo**](RwaDataApi.md#getRwaUnderlyingInfo) | **GET** /api/v1/dex/market/rwa/underlying-profile | Get RWA Underlying Info |
| [**getRwaUnderlyingMarketData**](RwaDataApi.md#getRwaUnderlyingMarketData) | **GET** /api/v1/dex/market/rwa/underlying-market | Get RWA Underlying Market Data |
| [**searchRwaToken**](RwaDataApi.md#searchRwaToken) | **GET** /api/v1/dex/market/rwa/search | Search RWA Token |


<a id="getRwaTokenIssuancePlatforms"></a>
# **getRwaTokenIssuancePlatforms**
> GetRwaTokenIssuancePlatformsResponse getRwaTokenIssuancePlatforms().recvWindow(recvWindow).nonce(nonce).platformId(platformId).execute();

Get RWA Token Issuance Platforms

Return the list of supported RWA token issuance platforms and their basic info.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.RwaDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    RwaDataApi apiInstance = new RwaDataApi(defaultClient);
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds. Default 5000, max 60000.
    String nonce = "unique-nonce-string"; // String | Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN when omitted.
    PlatformId platformId = PlatformId.fromValue("ondo"); // PlatformId | Platform identifier (ondo=Ondo Finance, bstock=bStocks). Optional. If not specified, returns all platforms; when specified, returns only that platform.
    try {
      GetRwaTokenIssuancePlatformsResponse result = apiInstance.getRwaTokenIssuancePlatforms()
            .recvWindow(recvWindow)
            .nonce(nonce)
            .platformId(platformId)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RwaDataApi#getRwaTokenIssuancePlatforms");
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
| **recvWindow** | **Long**| Allowed time deviation in milliseconds. Default 5000, max 60000. | [optional] |
| **nonce** | **String**| Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN when omitted. | [optional] |
| **platformId** | [**PlatformId**](.md)| Platform identifier (ondo&#x3D;Ondo Finance, bstock&#x3D;bStocks). Optional. If not specified, returns all platforms; when specified, returns only that platform. | [optional] [enum: ondo, bstock] |

### Return type

[**GetRwaTokenIssuancePlatformsResponse**](GetRwaTokenIssuancePlatformsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | RWA token issuance platform list returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getRwaTokenList"></a>
# **getRwaTokenList**
> GetRwaTokenListResponse getRwaTokenList().recvWindow(recvWindow).nonce(nonce).binanceChainId(binanceChainId).platformId(platformId).tabId(tabId).execute();

Get RWA Token List

Get the list of RWA tokens with underlying asset info. Supports filtering by platform and sector tab.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.RwaDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    RwaDataApi apiInstance = new RwaDataApi(defaultClient);
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds. Default 5000, max 60000.
    String nonce = "unique-nonce-string"; // String | Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN when omitted.
    String binanceChainId = "56"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana). Optional. If not specified, returns data from all chains.
    PlatformId platformId = PlatformId.fromValue("ondo"); // PlatformId | Platform filter (ondo=Ondo Finance, bstock=bStocks). Optional. If not specified, returns all platforms.
    Integer tabId = 9; // Integer | Sector tab filter. Optional. If not specified, returns all sectors. Enum: 1=Serenity Call, 2=SpaceX (SpaceX-related and commercial spaceflight concept stocks), 3=Upcoming Earnings, 4=AI Chips, 5=Storage, 6=Energy, 7=Precious Metals, 8=China ADR (Chinese companies listed in the US), 9=Magnificent 7 (the seven largest US tech giants: Apple, Microsoft, Alphabet, Amazon, Nvidia, Meta, Tesla), 10=Crypto, 11=ETF, 12=Tech Leaders, 13=Buffett Portfolio.
    try {
      GetRwaTokenListResponse result = apiInstance.getRwaTokenList()
            .recvWindow(recvWindow)
            .nonce(nonce)
            .binanceChainId(binanceChainId)
            .platformId(platformId)
            .tabId(tabId)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RwaDataApi#getRwaTokenList");
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
| **recvWindow** | **Long**| Allowed time deviation in milliseconds. Default 5000, max 60000. | [optional] |
| **nonce** | **String**| Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN when omitted. | [optional] |
| **binanceChainId** | **String**| Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). Optional. If not specified, returns data from all chains. | [optional] |
| **platformId** | [**PlatformId**](.md)| Platform filter (ondo&#x3D;Ondo Finance, bstock&#x3D;bStocks). Optional. If not specified, returns all platforms. | [optional] [enum: ondo, bstock] |
| **tabId** | **Integer**| Sector tab filter. Optional. If not specified, returns all sectors. Enum: 1&#x3D;Serenity Call, 2&#x3D;SpaceX (SpaceX-related and commercial spaceflight concept stocks), 3&#x3D;Upcoming Earnings, 4&#x3D;AI Chips, 5&#x3D;Storage, 6&#x3D;Energy, 7&#x3D;Precious Metals, 8&#x3D;China ADR (Chinese companies listed in the US), 9&#x3D;Magnificent 7 (the seven largest US tech giants: Apple, Microsoft, Alphabet, Amazon, Nvidia, Meta, Tesla), 10&#x3D;Crypto, 11&#x3D;ETF, 12&#x3D;Tech Leaders, 13&#x3D;Buffett Portfolio. | [optional] |

### Return type

[**GetRwaTokenListResponse**](GetRwaTokenListResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | RWA token list returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getRwaTokenPrice"></a>
# **getRwaTokenPrice**
> GetRwaTokenPriceResponse getRwaTokenPrice(binanceChainId, tokenContractAddresses).recvWindow(recvWindow).nonce(nonce).execute();

Get RWA Token Price

Batch query RWA token prices, including on-chain price and underlying reference price.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.RwaDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    RwaDataApi apiInstance = new RwaDataApi(defaultClient);
    String binanceChainId = "56"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana).
    String tokenContractAddresses = "0x8755c5c39b1aa9053a83ac731242a2cf4d04b0fe"; // String | Comma-separated token contract addresses. Maximum 100 per request.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds. Default 5000, max 60000.
    String nonce = "unique-nonce-string"; // String | Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN when omitted.
    try {
      GetRwaTokenPriceResponse result = apiInstance.getRwaTokenPrice(binanceChainId, tokenContractAddresses)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RwaDataApi#getRwaTokenPrice");
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
| **tokenContractAddresses** | **String**| Comma-separated token contract addresses. Maximum 100 per request. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds. Default 5000, max 60000. | [optional] |
| **nonce** | **String**| Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN when omitted. | [optional] |

### Return type

[**GetRwaTokenPriceResponse**](GetRwaTokenPriceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Quote data returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getRwaUnderlyingInfo"></a>
# **getRwaUnderlyingInfo**
> GetRwaUnderlyingInfoResponse getRwaUnderlyingInfo(binanceChainId, tokenContractAddress).recvWindow(recvWindow).nonce(nonce).execute();

Get RWA Underlying Info

Get the underlying company information for an RWA token.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.RwaDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    RwaDataApi apiInstance = new RwaDataApi(defaultClient);
    String binanceChainId = "56"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana).
    String tokenContractAddress = "0x8755c5c39b1aa9053a83ac731242a2cf4d04b0fe"; // String | Token contract address.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds. Default 5000, max 60000.
    String nonce = "unique-nonce-string"; // String | Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN when omitted.
    try {
      GetRwaUnderlyingInfoResponse result = apiInstance.getRwaUnderlyingInfo(binanceChainId, tokenContractAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RwaDataApi#getRwaUnderlyingInfo");
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
| **tokenContractAddress** | **String**| Token contract address. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds. Default 5000, max 60000. | [optional] |
| **nonce** | **String**| Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN when omitted. | [optional] |

### Return type

[**GetRwaUnderlyingInfoResponse**](GetRwaUnderlyingInfoResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Token detail returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getRwaUnderlyingMarketData"></a>
# **getRwaUnderlyingMarketData**
> GetRwaUnderlyingMarketDataResponse getRwaUnderlyingMarketData(binanceChainId, tokenContractAddress).recvWindow(recvWindow).nonce(nonce).execute();

Get RWA Underlying Market Data

Get market data for the underlying asset of an RWA token.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.RwaDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    RwaDataApi apiInstance = new RwaDataApi(defaultClient);
    String binanceChainId = "56"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana).
    String tokenContractAddress = "0x8755c5c39b1aa9053a83ac731242a2cf4d04b0fe"; // String | Token contract address.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds. Default 5000, max 60000.
    String nonce = "unique-nonce-string"; // String | Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN when omitted.
    try {
      GetRwaUnderlyingMarketDataResponse result = apiInstance.getRwaUnderlyingMarketData(binanceChainId, tokenContractAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RwaDataApi#getRwaUnderlyingMarketData");
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
| **tokenContractAddress** | **String**| Token contract address. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds. Default 5000, max 60000. | [optional] |
| **nonce** | **String**| Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN when omitted. | [optional] |

### Return type

[**GetRwaUnderlyingMarketDataResponse**](GetRwaUnderlyingMarketDataResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Underlying market data returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="searchRwaToken"></a>
# **searchRwaToken**
> SearchRwaTokenResponse searchRwaToken(keyword).recvWindow(recvWindow).nonce(nonce).platformId(platformId).execute();

Search RWA Token

Search RWA tokens by keyword or contract address.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.RwaDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    RwaDataApi apiInstance = new RwaDataApi(defaultClient);
    String keyword = "NVDA"; // String | Search keyword (ticker, company name, or contract address). Case-insensitive.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds. Default 5000, max 60000.
    String nonce = "unique-nonce-string"; // String | Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN when omitted.
    PlatformId platformId = PlatformId.fromValue("ondo"); // PlatformId | Platform filter (ondo=Ondo Finance, bstock=bStocks). Optional. If not specified, returns results from all platforms.
    try {
      SearchRwaTokenResponse result = apiInstance.searchRwaToken(keyword)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .platformId(platformId)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RwaDataApi#searchRwaToken");
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
| **keyword** | **String**| Search keyword (ticker, company name, or contract address). Case-insensitive. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds. Default 5000, max 60000. | [optional] |
| **nonce** | **String**| Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN when omitted. | [optional] |
| **platformId** | [**PlatformId**](.md)| Platform filter (ondo&#x3D;Ondo Finance, bstock&#x3D;bStocks). Optional. If not specified, returns results from all platforms. | [optional] [enum: ondo, bstock] |

### Return type

[**SearchRwaTokenResponse**](SearchRwaTokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Ticker lookup results returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

