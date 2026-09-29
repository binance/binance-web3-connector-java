# MarketApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**candlestickStream**](MarketApi.md#candlestickStream) | **POST** /w3w@onchainos@pub@candles@&lt;bar&gt;@&lt;chainId&gt;@&lt;contractAddress&gt; | Candlestick Stream |
| [**marketStatsStream**](MarketApi.md#marketStatsStream) | **POST** /w3w@onchainos@pub@tx-data@&lt;chainId&gt;@&lt;contractAddress&gt; | Market Stats Stream |
| [**priceStream**](MarketApi.md#priceStream) | **POST** /w3w@onchainos@pub@price@&lt;chainId&gt;@&lt;contractAddress&gt; | Price Stream |
| [**realTimeTradesStream**](MarketApi.md#realTimeTradesStream) | **POST** /w3w@onchainos@pub@tx@&lt;chainId&gt;@&lt;contractAddress&gt; | Real-Time Trades Stream |


<a id="candlestickStream"></a>
# **candlestickStream**
> CandlestickStreamResponse candlestickStream(candlestickStreamRequest)

Candlestick Stream

Push token candlestick (K-line) data in real time. The current (unclosed) candle keeps updating as new trades occur.  Update Speed: Real-time

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.websocket.stream.api.MarketApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MarketApi apiInstance = new MarketApi(defaultClient);
    CandlestickStreamRequest candlestickStreamRequest = new CandlestickStreamRequest(); // CandlestickStreamRequest | 
    try {
      CandlestickStreamResponse result = apiInstance.candlestickStream(candlestickStreamRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MarketApi#candlestickStream");
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
| **candlestickStreamRequest** | [**CandlestickStreamRequest**](CandlestickStreamRequest.md)|  | |

### Return type

[**CandlestickStreamResponse**](CandlestickStreamResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Candles stream payload. |  -  |

<a id="marketStatsStream"></a>
# **marketStatsStream**
> MarketStatsStreamResponse marketStatsStream(marketStatsStreamRequest)

Market Stats Stream

Push token market data. Rate-limited to at most once per second per token: if a token&#39;s data changes within a 1-second window, the latest snapshot is pushed once (multiple changes are coalesced into the latest value); if there is no change, nothing is pushed.  Update Speed: Real-time

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.websocket.stream.api.MarketApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MarketApi apiInstance = new MarketApi(defaultClient);
    MarketStatsStreamRequest marketStatsStreamRequest = new MarketStatsStreamRequest(); // MarketStatsStreamRequest | 
    try {
      MarketStatsStreamResponse result = apiInstance.marketStatsStream(marketStatsStreamRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MarketApi#marketStatsStream");
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
| **marketStatsStreamRequest** | [**MarketStatsStreamRequest**](MarketStatsStreamRequest.md)|  | |

### Return type

[**MarketStatsStreamResponse**](MarketStatsStreamResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | TX data stream payload. |  -  |

<a id="priceStream"></a>
# **priceStream**
> PriceStreamResponse priceStream(priceStreamRequest)

Price Stream

Push token price updates. Triggered every time a token&#39;s price changes.  Update Speed: Real-time

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.websocket.stream.api.MarketApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MarketApi apiInstance = new MarketApi(defaultClient);
    PriceStreamRequest priceStreamRequest = new PriceStreamRequest(); // PriceStreamRequest | 
    try {
      PriceStreamResponse result = apiInstance.priceStream(priceStreamRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MarketApi#priceStream");
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
| **priceStreamRequest** | [**PriceStreamRequest**](PriceStreamRequest.md)|  | |

### Return type

[**PriceStreamResponse**](PriceStreamResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Price stream payload. |  -  |

<a id="realTimeTradesStream"></a>
# **realTimeTradesStream**
> RealTimeTradesStreamResponse realTimeTradesStream(realTimeTradesStreamRequest)

Real-Time Trades Stream

Push real-time token trade history. Triggered on every new transaction.  Update Speed: Real-time

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.websocket.stream.api.MarketApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MarketApi apiInstance = new MarketApi(defaultClient);
    RealTimeTradesStreamRequest realTimeTradesStreamRequest = new RealTimeTradesStreamRequest(); // RealTimeTradesStreamRequest | 
    try {
      RealTimeTradesStreamResponse result = apiInstance.realTimeTradesStream(realTimeTradesStreamRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MarketApi#realTimeTradesStream");
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
| **realTimeTradesStreamRequest** | [**RealTimeTradesStreamRequest**](RealTimeTradesStreamRequest.md)|  | |

### Return type

[**RealTimeTradesStreamResponse**](RealTimeTradesStreamResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Trade history stream payload. |  -  |

