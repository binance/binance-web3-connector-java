# GeneralDataApi

All URIs are relative to *https://web3.binance.com/build*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getCandles**](GeneralDataApi.md#getCandles) | **GET** /api/v1/dex/market/candles | Get Candles |
| [**getHoldersRanking**](GeneralDataApi.md#getHoldersRanking) | **GET** /api/v1/dex/market/token/holder | Get Holders Ranking |
| [**getHotTokenList**](GeneralDataApi.md#getHotTokenList) | **GET** /api/v1/dex/market/token/hot-token | Get Hot Token List |
| [**getSupportedChains**](GeneralDataApi.md#getSupportedChains) | **GET** /api/v1/dex/market/supported/chain | Get Supported Chains |
| [**getTokenAdvancedInfo**](GeneralDataApi.md#getTokenAdvancedInfo) | **GET** /api/v1/dex/market/token/advanced-info | Get Token Advanced Info |
| [**getTokenBasicInfo**](GeneralDataApi.md#getTokenBasicInfo) | **POST** /api/v1/dex/market/token/basic-info | Get Token Basic Info |
| [**getTokenDevInfo**](GeneralDataApi.md#getTokenDevInfo) | **GET** /api/v1/dex/market/memepump/tokenDevInfo | Get Token Dev Info |
| [**getTokenPrice**](GeneralDataApi.md#getTokenPrice) | **POST** /api/v1/dex/market/price | Get Token Price |
| [**getTokenTrades**](GeneralDataApi.md#getTokenTrades) | **GET** /api/v1/dex/market/trades | Get Token Trades |
| [**getTokenTradingInfo**](GeneralDataApi.md#getTokenTradingInfo) | **POST** /api/v1/dex/market/price-info | Get Token Trading Info |
| [**getTopLiquidityPools**](GeneralDataApi.md#getTopLiquidityPools) | **GET** /api/v1/dex/market/token/top-liquidity | Get Top Liquidity Pools |
| [**getTopTraders**](GeneralDataApi.md#getTopTraders) | **GET** /api/v1/dex/market/token/top-trader | Get Top Traders |
| [**searchToken**](GeneralDataApi.md#searchToken) | **GET** /api/v1/dex/market/token/search | Search Token |


<a id="getCandles"></a>
# **getCandles**
> GetCandlesResponse getCandles(binanceChainId, tokenContractAddress).recvWindow(recvWindow).nonce(nonce).bar(bar).after(after).before(before).limit(limit).execute();

Get Candles

Return candlestick (K-line) data for a token.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    GeneralDataApi apiInstance = new GeneralDataApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana).
    String tokenContractAddress = "0xdac17f958d2ee523a2206206994597c13d831ec7"; // String | Token contract address.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    Bar bar = Bar.fromValue("1s"); // Bar | Candlestick time granularity, default \"1m\" (1 minute). Available values: 1s (1 second), 5s (5 seconds), 30s (30 seconds), 1m (1 minute), 3m (3 minutes), 5m (5 minutes), 15m (15 minutes), 30m (30 minutes), 1h (1 hour), 2h (2 hours), 4h (4 hours), 6h (6 hours), 8h (8 hours), 12h (12 hours), 1d (1 day), 3d (3 days), 1w (1 week), 1M (1 month).
    Long after = 1748600000000L; // Long | End time for the query, Unix millisecond timestamp. Returns candles earlier than this time (exclusive).
    Long before = 1748000000000L; // Long | Start time for the query, Unix millisecond timestamp. Returns candles later than this time (exclusive).
    Integer limit = 100; // Integer | Number of candles to return. Defaults to 100.
    try {
      GetCandlesResponse result = apiInstance.getCandles(binanceChainId, tokenContractAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .bar(bar)
            .after(after)
            .before(before)
            .limit(limit)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GeneralDataApi#getCandles");
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
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **bar** | [**Bar**](.md)| Candlestick time granularity, default \&quot;1m\&quot; (1 minute). Available values: 1s (1 second), 5s (5 seconds), 30s (30 seconds), 1m (1 minute), 3m (3 minutes), 5m (5 minutes), 15m (15 minutes), 30m (30 minutes), 1h (1 hour), 2h (2 hours), 4h (4 hours), 6h (6 hours), 8h (8 hours), 12h (12 hours), 1d (1 day), 3d (3 days), 1w (1 week), 1M (1 month). | [optional] [default to 1m] [enum: 1s, 5s, 30s, 1m, 3m, 5m, 15m, 30m, 1h, 2h, 4h, 6h, 8h, 12h, 1d, 3d, 1w, 1M] |
| **after** | **Long**| End time for the query, Unix millisecond timestamp. Returns candles earlier than this time (exclusive). | [optional] |
| **before** | **Long**| Start time for the query, Unix millisecond timestamp. Returns candles later than this time (exclusive). | [optional] |
| **limit** | **Integer**| Number of candles to return. Defaults to 100. | [optional] |

### Return type

[**GetCandlesResponse**](GetCandlesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Candle data returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getHoldersRanking"></a>
# **getHoldersRanking**
> GetHoldersRankingResponse getHoldersRanking(binanceChainId, tokenContractAddress).recvWindow(recvWindow).nonce(nonce).tagFilter(tagFilter).execute();

Get Holders Ranking

Return the holders ranking list for a token, including holding amount, holding percentage, native-token balance, average buy/sell price, realized PnL, and funding source. Up to 100 records. Pagination is not supported.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    GeneralDataApi apiInstance = new GeneralDataApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier.
    String tokenContractAddress = "0x6982508145454ce325ddbe47a25d4ec3d2311933"; // String | Token contract address.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    TagFilter tagFilter = TagFilter.fromValue("1"); // TagFilter | Address tag filter, single selection only. Returns all holder addresses (by holding amount descending) when omitted; returns addresses matching the specified tag when provided. Mapping: 1=KOL, 2=Developer, 3=Smart Money, 4=Insider, 5=Sniper, 6=Bundler.
    try {
      GetHoldersRankingResponse result = apiInstance.getHoldersRanking(binanceChainId, tokenContractAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .tagFilter(tagFilter)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GeneralDataApi#getHoldersRanking");
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
| **binanceChainId** | **String**| Unique chain identifier. | |
| **tokenContractAddress** | **String**| Token contract address. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **tagFilter** | [**TagFilter**](.md)| Address tag filter, single selection only. Returns all holder addresses (by holding amount descending) when omitted; returns addresses matching the specified tag when provided. Mapping: 1&#x3D;KOL, 2&#x3D;Developer, 3&#x3D;Smart Money, 4&#x3D;Insider, 5&#x3D;Sniper, 6&#x3D;Bundler. | [optional] [enum: 1, 2, 3, 4, 5, 6, 7] |

### Return type

[**GetHoldersRankingResponse**](GetHoldersRankingResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Holders ranking returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getHotTokenList"></a>
# **getHotTokenList**
> GetHotTokenListResponse getHotTokenList(binanceChainId).recvWindow(recvWindow).nonce(nonce).rankBy(rankBy).rankingTimeFrame(rankingTimeFrame).priceChangePercentMin(priceChangePercentMin).priceChangePercentMax(priceChangePercentMax).volumeMin(volumeMin).volumeMax(volumeMax).txsMin(txsMin).txsMax(txsMax).marketCapMin(marketCapMin).marketCapMax(marketCapMax).liquidityMin(liquidityMin).liquidityMax(liquidityMax).devHoldingPercentMin(devHoldingPercentMin).devHoldingPercentMax(devHoldingPercentMax).inflowUsdMin(inflowUsdMin).inflowUsdMax(inflowUsdMax).holdersMin(holdersMin).holdersMax(holdersMax).bnHolderCountMin(bnHolderCountMin).bnHolderCountMax(bnHolderCountMax).top10HoldingPercentMin(top10HoldingPercentMin).top10HoldingPercentMax(top10HoldingPercentMax).sniperHoldingPercentMin(sniperHoldingPercentMin).sniperHoldingPercentMax(sniperHoldingPercentMax).smartMoneyHoldingPercentMin(smartMoneyHoldingPercentMin).smartMoneyHoldingPercentMax(smartMoneyHoldingPercentMax).kolHoldingPercentMin(kolHoldingPercentMin).kolHoldingPercentMax(kolHoldingPercentMax).proHoldingPercentMin(proHoldingPercentMin).proHoldingPercentMax(proHoldingPercentMax).freshWalletHoldingPercentMin(freshWalletHoldingPercentMin).freshWalletHoldingPercentMax(freshWalletHoldingPercentMax).insiderHoldingPercentMin(insiderHoldingPercentMin).insiderHoldingPercentMax(insiderHoldingPercentMax).bundlerHoldingPercentMin(bundlerHoldingPercentMin).bundlerHoldingPercentMax(bundlerHoldingPercentMax).devCreatedTokenCountMin(devCreatedTokenCountMin).devCreatedTokenCountMax(devCreatedTokenCountMax).devMigratedTokenCountMin(devMigratedTokenCountMin).devMigratedTokenCountMax(devMigratedTokenCountMax).devMigratedTokenPercentMin(devMigratedTokenPercentMin).devMigratedTokenPercentMax(devMigratedTokenPercentMax).isDevSoldAll(isDevSoldAll).isDevBurned(isDevBurned).isMint(isMint).isFreeze(isFreeze).isHideWashTradingTokens(isHideWashTradingTokens).isHideDevWashTradingTokens(isHideDevWashTradingTokens).isHideInternalWashTradingTokens(isHideInternalWashTradingTokens).pageId(pageId).size(size).execute();

Get Hot Token List

Get hot token ranking list. Supports sorting by volume, price change, market cap, etc., with filters for holding distribution, developer behavior, liquidity, and more.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    GeneralDataApi apiInstance = new GeneralDataApi(defaultClient);
    String binanceChainId = "1"; // String | Chain identifier. Single value only.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    RankBy rankBy = RankBy.fromValue("1"); // RankBy | Ranking field. 1=price, 2=price change, 3=transactions, 4=volume, 5=market cap, 6=liquidity, 7=creation time, 8=holders, 9=Binance MPC wallet holders, 10=net inflow.
    RankingTimeFrame rankingTimeFrame = RankingTimeFrame.fromValue("1"); // RankingTimeFrame | Data time range. 1=1 min, 2=5 min, 3=1 hour, 4=4 hours, 5=24 hours. Default 1 hour.
    String priceChangePercentMin = "5"; // String | Minimum price change filter. \"5\" means 5%.
    String priceChangePercentMax = "100"; // String | Maximum price change filter. \"100\" means 100%.
    String volumeMin = "10000"; // String | Minimum volume filter, denominated in USD.
    String volumeMax = "1000000"; // String | Maximum volume filter, denominated in USD.
    String txsMin = "100"; // String | Minimum transaction count.
    String txsMax = "10000"; // String | Maximum transaction count.
    String marketCapMin = "100000"; // String | Minimum market cap filter, denominated in USD.
    String marketCapMax = "100000000"; // String | Maximum market cap filter, denominated in USD.
    String liquidityMin = "10000"; // String | Minimum liquidity filter, denominated in USD.
    String liquidityMax = "10000000"; // String | Maximum liquidity filter, denominated in USD.
    String devHoldingPercentMin = "0"; // String | Minimum developer holding percentage filter. \"5\" means 5%.
    String devHoldingPercentMax = "10"; // String | Maximum developer holding percentage filter. \"5\" means 5%.
    String inflowUsdMin = "0"; // String | Minimum net inflow filter, denominated in USD.
    String inflowUsdMax = "1000000"; // String | Maximum net inflow filter, denominated in USD.
    String holdersMin = "100"; // String | Minimum holder count.
    String holdersMax = "100000"; // String | Maximum holder count.
    String bnHolderCountMin = "0"; // String | Minimum Binance MPC wallet holders.
    String bnHolderCountMax = "10000"; // String | Maximum Binance MPC wallet holders.
    String top10HoldingPercentMin = "0"; // String | Minimum top-10 holding percentage. \"5\" means 5%.
    String top10HoldingPercentMax = "100"; // String | Maximum top-10 holding percentage. \"5\" means 5%.
    String sniperHoldingPercentMin = "0"; // String | Minimum sniper holding percentage. \"5\" means 5%.
    String sniperHoldingPercentMax = "100"; // String | Maximum sniper holding percentage. \"5\" means 5%.
    String smartMoneyHoldingPercentMin = "0"; // String | Minimum smart-money holding percentage. \"5\" means 5%.
    String smartMoneyHoldingPercentMax = "100"; // String | Maximum smart-money holding percentage. \"5\" means 5%.
    String kolHoldingPercentMin = "0"; // String | Minimum KOL holding percentage. \"5\" means 5%.
    String kolHoldingPercentMax = "100"; // String | Maximum KOL holding percentage. \"5\" means 5%.
    String proHoldingPercentMin = "0"; // String | Minimum pro-trader holding percentage. \"5\" means 5%.
    String proHoldingPercentMax = "100"; // String | Maximum pro-trader holding percentage. \"5\" means 5%.
    String freshWalletHoldingPercentMin = "0"; // String | Minimum fresh-wallet holding percentage. \"5\" means 5%.
    String freshWalletHoldingPercentMax = "100"; // String | Maximum fresh-wallet holding percentage. \"5\" means 5%.
    String insiderHoldingPercentMin = "0"; // String | Minimum insider holding percentage. \"5\" means 5%.
    String insiderHoldingPercentMax = "100"; // String | Maximum insider holding percentage. \"5\" means 5%.
    String bundlerHoldingPercentMin = "0"; // String | Minimum bundler holding percentage. \"5\" means 5%.
    String bundlerHoldingPercentMax = "100"; // String | Maximum bundler holding percentage. \"5\" means 5%.
    String devCreatedTokenCountMin = "0"; // String | Minimum developer-created token count.
    String devCreatedTokenCountMax = "100"; // String | Maximum developer-created token count.
    String devMigratedTokenCountMin = "0"; // String | Minimum developer-migrated token count.
    String devMigratedTokenCountMax = "100"; // String | Maximum developer-migrated token count.
    String devMigratedTokenPercentMin = "0"; // String | Minimum developer-migrated token percentage. \"5\" means 5%.
    String devMigratedTokenPercentMax = "100"; // String | Maximum developer-migrated token percentage. \"5\" means 5%.
    Boolean isDevSoldAll = false; // Boolean | When set to true, returns only tokens where the developer has sold all holdings. Not filtered when omitted or false.
    Boolean isDevBurned = false; // Boolean | When set to true, returns only tokens where the developer has burned tokens. Not filtered when omitted or false.
    Boolean isMint = false; // Boolean | When set to true, excludes tokens with minting capability. Default false.
    Boolean isFreeze = false; // Boolean | When set to true, excludes tokens with freeze capability. Default false.
    Boolean isHideWashTradingTokens = true; // Boolean | When set to true, excludes tokens with wash trading behavior. Default true.
    Boolean isHideDevWashTradingTokens = true; // Boolean | When set to true, excludes tokens where the developer has wash trading behavior. Default true.
    Boolean isHideInternalWashTradingTokens = true; // Boolean | When set to true, excludes tokens where insiders have wash trading behavior. Default true.
    Integer pageId = 1; // Integer | Pagination identifier. Do not pass on the first request; pass the page value from the previous response to get the next page.
    Integer size = 100; // Integer | Page size. Maximum 100. Defaults to 100.
    try {
      GetHotTokenListResponse result = apiInstance.getHotTokenList(binanceChainId)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .rankBy(rankBy)
            .rankingTimeFrame(rankingTimeFrame)
            .priceChangePercentMin(priceChangePercentMin)
            .priceChangePercentMax(priceChangePercentMax)
            .volumeMin(volumeMin)
            .volumeMax(volumeMax)
            .txsMin(txsMin)
            .txsMax(txsMax)
            .marketCapMin(marketCapMin)
            .marketCapMax(marketCapMax)
            .liquidityMin(liquidityMin)
            .liquidityMax(liquidityMax)
            .devHoldingPercentMin(devHoldingPercentMin)
            .devHoldingPercentMax(devHoldingPercentMax)
            .inflowUsdMin(inflowUsdMin)
            .inflowUsdMax(inflowUsdMax)
            .holdersMin(holdersMin)
            .holdersMax(holdersMax)
            .bnHolderCountMin(bnHolderCountMin)
            .bnHolderCountMax(bnHolderCountMax)
            .top10HoldingPercentMin(top10HoldingPercentMin)
            .top10HoldingPercentMax(top10HoldingPercentMax)
            .sniperHoldingPercentMin(sniperHoldingPercentMin)
            .sniperHoldingPercentMax(sniperHoldingPercentMax)
            .smartMoneyHoldingPercentMin(smartMoneyHoldingPercentMin)
            .smartMoneyHoldingPercentMax(smartMoneyHoldingPercentMax)
            .kolHoldingPercentMin(kolHoldingPercentMin)
            .kolHoldingPercentMax(kolHoldingPercentMax)
            .proHoldingPercentMin(proHoldingPercentMin)
            .proHoldingPercentMax(proHoldingPercentMax)
            .freshWalletHoldingPercentMin(freshWalletHoldingPercentMin)
            .freshWalletHoldingPercentMax(freshWalletHoldingPercentMax)
            .insiderHoldingPercentMin(insiderHoldingPercentMin)
            .insiderHoldingPercentMax(insiderHoldingPercentMax)
            .bundlerHoldingPercentMin(bundlerHoldingPercentMin)
            .bundlerHoldingPercentMax(bundlerHoldingPercentMax)
            .devCreatedTokenCountMin(devCreatedTokenCountMin)
            .devCreatedTokenCountMax(devCreatedTokenCountMax)
            .devMigratedTokenCountMin(devMigratedTokenCountMin)
            .devMigratedTokenCountMax(devMigratedTokenCountMax)
            .devMigratedTokenPercentMin(devMigratedTokenPercentMin)
            .devMigratedTokenPercentMax(devMigratedTokenPercentMax)
            .isDevSoldAll(isDevSoldAll)
            .isDevBurned(isDevBurned)
            .isMint(isMint)
            .isFreeze(isFreeze)
            .isHideWashTradingTokens(isHideWashTradingTokens)
            .isHideDevWashTradingTokens(isHideDevWashTradingTokens)
            .isHideInternalWashTradingTokens(isHideInternalWashTradingTokens)
            .pageId(pageId)
            .size(size)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GeneralDataApi#getHotTokenList");
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
| **binanceChainId** | **String**| Chain identifier. Single value only. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **rankBy** | [**RankBy**](.md)| Ranking field. 1&#x3D;price, 2&#x3D;price change, 3&#x3D;transactions, 4&#x3D;volume, 5&#x3D;market cap, 6&#x3D;liquidity, 7&#x3D;creation time, 8&#x3D;holders, 9&#x3D;Binance MPC wallet holders, 10&#x3D;net inflow. | [optional] [enum: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10] |
| **rankingTimeFrame** | [**RankingTimeFrame**](.md)| Data time range. 1&#x3D;1 min, 2&#x3D;5 min, 3&#x3D;1 hour, 4&#x3D;4 hours, 5&#x3D;24 hours. Default 1 hour. | [optional] [default to 3] [enum: 1, 2, 3, 4, 5] |
| **priceChangePercentMin** | **String**| Minimum price change filter. \&quot;5\&quot; means 5%. | [optional] |
| **priceChangePercentMax** | **String**| Maximum price change filter. \&quot;100\&quot; means 100%. | [optional] |
| **volumeMin** | **String**| Minimum volume filter, denominated in USD. | [optional] |
| **volumeMax** | **String**| Maximum volume filter, denominated in USD. | [optional] |
| **txsMin** | **String**| Minimum transaction count. | [optional] |
| **txsMax** | **String**| Maximum transaction count. | [optional] |
| **marketCapMin** | **String**| Minimum market cap filter, denominated in USD. | [optional] |
| **marketCapMax** | **String**| Maximum market cap filter, denominated in USD. | [optional] |
| **liquidityMin** | **String**| Minimum liquidity filter, denominated in USD. | [optional] |
| **liquidityMax** | **String**| Maximum liquidity filter, denominated in USD. | [optional] |
| **devHoldingPercentMin** | **String**| Minimum developer holding percentage filter. \&quot;5\&quot; means 5%. | [optional] |
| **devHoldingPercentMax** | **String**| Maximum developer holding percentage filter. \&quot;5\&quot; means 5%. | [optional] |
| **inflowUsdMin** | **String**| Minimum net inflow filter, denominated in USD. | [optional] |
| **inflowUsdMax** | **String**| Maximum net inflow filter, denominated in USD. | [optional] |
| **holdersMin** | **String**| Minimum holder count. | [optional] |
| **holdersMax** | **String**| Maximum holder count. | [optional] |
| **bnHolderCountMin** | **String**| Minimum Binance MPC wallet holders. | [optional] |
| **bnHolderCountMax** | **String**| Maximum Binance MPC wallet holders. | [optional] |
| **top10HoldingPercentMin** | **String**| Minimum top-10 holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **top10HoldingPercentMax** | **String**| Maximum top-10 holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **sniperHoldingPercentMin** | **String**| Minimum sniper holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **sniperHoldingPercentMax** | **String**| Maximum sniper holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **smartMoneyHoldingPercentMin** | **String**| Minimum smart-money holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **smartMoneyHoldingPercentMax** | **String**| Maximum smart-money holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **kolHoldingPercentMin** | **String**| Minimum KOL holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **kolHoldingPercentMax** | **String**| Maximum KOL holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **proHoldingPercentMin** | **String**| Minimum pro-trader holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **proHoldingPercentMax** | **String**| Maximum pro-trader holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **freshWalletHoldingPercentMin** | **String**| Minimum fresh-wallet holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **freshWalletHoldingPercentMax** | **String**| Maximum fresh-wallet holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **insiderHoldingPercentMin** | **String**| Minimum insider holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **insiderHoldingPercentMax** | **String**| Maximum insider holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **bundlerHoldingPercentMin** | **String**| Minimum bundler holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **bundlerHoldingPercentMax** | **String**| Maximum bundler holding percentage. \&quot;5\&quot; means 5%. | [optional] |
| **devCreatedTokenCountMin** | **String**| Minimum developer-created token count. | [optional] |
| **devCreatedTokenCountMax** | **String**| Maximum developer-created token count. | [optional] |
| **devMigratedTokenCountMin** | **String**| Minimum developer-migrated token count. | [optional] |
| **devMigratedTokenCountMax** | **String**| Maximum developer-migrated token count. | [optional] |
| **devMigratedTokenPercentMin** | **String**| Minimum developer-migrated token percentage. \&quot;5\&quot; means 5%. | [optional] |
| **devMigratedTokenPercentMax** | **String**| Maximum developer-migrated token percentage. \&quot;5\&quot; means 5%. | [optional] |
| **isDevSoldAll** | **Boolean**| When set to true, returns only tokens where the developer has sold all holdings. Not filtered when omitted or false. | [optional] |
| **isDevBurned** | **Boolean**| When set to true, returns only tokens where the developer has burned tokens. Not filtered when omitted or false. | [optional] |
| **isMint** | **Boolean**| When set to true, excludes tokens with minting capability. Default false. | [optional] |
| **isFreeze** | **Boolean**| When set to true, excludes tokens with freeze capability. Default false. | [optional] |
| **isHideWashTradingTokens** | **Boolean**| When set to true, excludes tokens with wash trading behavior. Default true. | [optional] |
| **isHideDevWashTradingTokens** | **Boolean**| When set to true, excludes tokens where the developer has wash trading behavior. Default true. | [optional] |
| **isHideInternalWashTradingTokens** | **Boolean**| When set to true, excludes tokens where insiders have wash trading behavior. Default true. | [optional] |
| **pageId** | **Integer**| Pagination identifier. Do not pass on the first request; pass the page value from the previous response to get the next page. | [optional] |
| **size** | **Integer**| Page size. Maximum 100. Defaults to 100. | [optional] |

### Return type

[**GetHotTokenListResponse**](GetHotTokenListResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Hot token list returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getSupportedChains"></a>
# **getSupportedChains**
> GetSupportedChainsResponse getSupportedChains().recvWindow(recvWindow).nonce(nonce).execute();

Get Supported Chains

Return the list of blockchains supported by the market service.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    GeneralDataApi apiInstance = new GeneralDataApi(defaultClient);
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetSupportedChainsResponse result = apiInstance.getSupportedChains()
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GeneralDataApi#getSupportedChains");
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

[**GetSupportedChainsResponse**](GetSupportedChainsResponse.md)

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

<a id="getTokenAdvancedInfo"></a>
# **getTokenAdvancedInfo**
> GetTokenAdvancedInfoResponse getTokenAdvancedInfo(binanceChainId, tokenContractAddress).recvWindow(recvWindow).nonce(nonce).execute();

Get Token Advanced Info

Return comprehensive metrics for a token, including creator and launch info, holding percentages by address type (smart money, KOL, sniper, bundler, fresh wallet, etc.), and token tags.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    GeneralDataApi apiInstance = new GeneralDataApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier.
    String tokenContractAddress = "0x6982508145454ce325ddbe47a25d4ec3d2311933"; // String | Token contract address.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetTokenAdvancedInfoResponse result = apiInstance.getTokenAdvancedInfo(binanceChainId, tokenContractAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GeneralDataApi#getTokenAdvancedInfo");
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
| **binanceChainId** | **String**| Unique chain identifier. | |
| **tokenContractAddress** | **String**| Token contract address. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetTokenAdvancedInfoResponse**](GetTokenAdvancedInfoResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Advanced token info returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getTokenBasicInfo"></a>
# **getTokenBasicInfo**
> GetTokenBasicInfoResponse getTokenBasicInfo(binanceChainId, tokenContractAddress).recvWindow(recvWindow).nonce(nonce).execute();

Get Token Basic Info

Return basic metadata for a token: name, symbol, logo, decimals, creator address, creation time, and tag info.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    GeneralDataApi apiInstance = new GeneralDataApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier.
    String tokenContractAddress = "0xdac17f958d2ee523a2206206994597c13d831ec7"; // String | Token contract address.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetTokenBasicInfoResponse result = apiInstance.getTokenBasicInfo(binanceChainId, tokenContractAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GeneralDataApi#getTokenBasicInfo");
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
| **binanceChainId** | **String**| Unique chain identifier. | |
| **tokenContractAddress** | **String**| Token contract address. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetTokenBasicInfoResponse**](GetTokenBasicInfoResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Token basic info returned successfully. |  -  |
| **201** | Created. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getTokenDevInfo"></a>
# **getTokenDevInfo**
> GetTokenDevInfoResponse getTokenDevInfo(binanceChainId, tokenContractAddress).recvWindow(recvWindow).nonce(nonce).execute();

Get Token Dev Info

Return developer profile for a token, including historical token launch stats, current holding percentage, and initial funding source.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    GeneralDataApi apiInstance = new GeneralDataApi(defaultClient);
    String binanceChainId = "CT_501"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana).
    String tokenContractAddress = "EPjFWdd5AufqSSqeM2qN1xzybapC8G4wEGGkZwyTDt1v"; // String | Token contract address. EVM chains accept lowercase 42-character hex addresses; Solana accepts base58 addresses (case-sensitive).
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetTokenDevInfoResponse result = apiInstance.getTokenDevInfo(binanceChainId, tokenContractAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GeneralDataApi#getTokenDevInfo");
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
| **tokenContractAddress** | **String**| Token contract address. EVM chains accept lowercase 42-character hex addresses; Solana accepts base58 addresses (case-sensitive). | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetTokenDevInfoResponse**](GetTokenDevInfoResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Token dev info returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getTokenPrice"></a>
# **getTokenPrice**
> GetTokenPriceResponse getTokenPrice().recvWindow(recvWindow).nonce(nonce).execute();

Get Token Price

Get the latest price for tokens. Supports batch queries, up to 100 tokens per request.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    GeneralDataApi apiInstance = new GeneralDataApi(defaultClient);
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetTokenPriceResponse result = apiInstance.getTokenPrice()
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GeneralDataApi#getTokenPrice");
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

[**GetTokenPriceResponse**](GetTokenPriceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Token prices returned successfully. |  -  |
| **201** | Created. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getTokenTrades"></a>
# **getTokenTrades**
> GetTokenTradesResponse getTokenTrades(binanceChainId, tokenContractAddress).recvWindow(recvWindow).nonce(nonce).cursor(cursor).limit(limit).tagFilter(tagFilter).walletAddressFilter(walletAddressFilter).execute();

Get Token Trades

Return on-chain trade history for a token. Supports tag filtering and wallet address filtering.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    GeneralDataApi apiInstance = new GeneralDataApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier.
    String tokenContractAddress = "0x6982508145454ce325ddbe47a25d4ec3d2311933"; // String | Token contract address.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String cursor = "eyJ0aW1lIjoxNzQ4NjAwMDAwMDAwLCJpZCI6MTIzfQ=="; // String | Pagination cursor. Do not pass on the first request; pass the cursor value from the previous response to get the next page.
    Integer limit = 100; // Integer | Number of results per page, maximum 500, defaults to 100.
    TagFilter tagFilter = TagFilter.fromValue("1"); // TagFilter | Address tag filter, single selection only. Returns all trades with pagination when omitted; returns only the latest 100 trades for the specified tag's addresses when provided (cursor and limit are ignored). Mapping: 1=KOL, 2=Developer, 3=Smart Money, 4=Insider, 5=Sniper, 6=Bundler, 7=Whale Holder.
    String walletAddressFilter = "0x28c6c06298d514db089934071355e5743bf21d60"; // String | Filter by specific wallet addresses. Separate multiple addresses with commas. Up to 2 addresses.
    try {
      GetTokenTradesResponse result = apiInstance.getTokenTrades(binanceChainId, tokenContractAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .cursor(cursor)
            .limit(limit)
            .tagFilter(tagFilter)
            .walletAddressFilter(walletAddressFilter)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GeneralDataApi#getTokenTrades");
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
| **binanceChainId** | **String**| Unique chain identifier. | |
| **tokenContractAddress** | **String**| Token contract address. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **cursor** | **String**| Pagination cursor. Do not pass on the first request; pass the cursor value from the previous response to get the next page. | [optional] |
| **limit** | **Integer**| Number of results per page, maximum 500, defaults to 100. | [optional] |
| **tagFilter** | [**TagFilter**](.md)| Address tag filter, single selection only. Returns all trades with pagination when omitted; returns only the latest 100 trades for the specified tag&#39;s addresses when provided (cursor and limit are ignored). Mapping: 1&#x3D;KOL, 2&#x3D;Developer, 3&#x3D;Smart Money, 4&#x3D;Insider, 5&#x3D;Sniper, 6&#x3D;Bundler, 7&#x3D;Whale Holder. | [optional] [enum: 1, 2, 3, 4, 5, 6, 7] |
| **walletAddressFilter** | **String**| Filter by specific wallet addresses. Separate multiple addresses with commas. Up to 2 addresses. | [optional] |

### Return type

[**GetTokenTradesResponse**](GetTokenTradesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Trade history returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getTokenTradingInfo"></a>
# **getTokenTradingInfo**
> GetTokenTradingInfoResponse getTokenTradingInfo().recvWindow(recvWindow).nonce(nonce).execute();

Get Token Trading Info

Get token price and trading data (volume, transactions, market cap, holders, etc.). Supports batch queries for up to 100 tokens.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    GeneralDataApi apiInstance = new GeneralDataApi(defaultClient);
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetTokenTradingInfoResponse result = apiInstance.getTokenTradingInfo()
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GeneralDataApi#getTokenTradingInfo");
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

[**GetTokenTradingInfoResponse**](GetTokenTradingInfoResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Price info returned successfully. |  -  |
| **201** | Created. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getTopLiquidityPools"></a>
# **getTopLiquidityPools**
> GetTopLiquidityPoolsResponse getTopLiquidityPools(binanceChainId, tokenContractAddress).recvWindow(recvWindow).nonce(nonce).execute();

Get Top Liquidity Pools

Return the top liquidity pools for a token, including pool name, protocol, liquidity in USD, pool address, and per-token composition.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    GeneralDataApi apiInstance = new GeneralDataApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier.
    String tokenContractAddress = "0x6982508145454ce325ddbe47a25d4ec3d2311933"; // String | Token contract address.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetTopLiquidityPoolsResponse result = apiInstance.getTopLiquidityPools(binanceChainId, tokenContractAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GeneralDataApi#getTopLiquidityPools");
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
| **binanceChainId** | **String**| Unique chain identifier. | |
| **tokenContractAddress** | **String**| Token contract address. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetTopLiquidityPoolsResponse**](GetTopLiquidityPoolsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Top liquidity pools returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getTopTraders"></a>
# **getTopTraders**
> GetTopTradersResponse getTopTraders(binanceChainId, tokenContractAddress).recvWindow(recvWindow).nonce(nonce).tagFilter(tagFilter).execute();

Get Top Traders

Return the top profit-making addresses for a token, ranked by realized PnL descending. Includes holding amount, average buy/sell price, realized PnL, and funding source. Up to 100 records. Pagination is not supported.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    GeneralDataApi apiInstance = new GeneralDataApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier.
    String tokenContractAddress = "0x6982508145454ce325ddbe47a25d4ec3d2311933"; // String | Token contract address.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    TagFilter tagFilter = TagFilter.fromValue("1"); // TagFilter | Address tag filter, single selection only. Returns all top profit addresses (by realized PnL descending) when omitted; returns addresses matching the specified tag when provided. Mapping: 1=KOL, 2=Developer, 3=Smart Money, 4=Insider, 5=Sniper, 6=Bundler, 7=Whale Holder.
    try {
      GetTopTradersResponse result = apiInstance.getTopTraders(binanceChainId, tokenContractAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .tagFilter(tagFilter)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GeneralDataApi#getTopTraders");
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
| **binanceChainId** | **String**| Unique chain identifier. | |
| **tokenContractAddress** | **String**| Token contract address. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **tagFilter** | [**TagFilter**](.md)| Address tag filter, single selection only. Returns all top profit addresses (by realized PnL descending) when omitted; returns addresses matching the specified tag when provided. Mapping: 1&#x3D;KOL, 2&#x3D;Developer, 3&#x3D;Smart Money, 4&#x3D;Insider, 5&#x3D;Sniper, 6&#x3D;Bundler, 7&#x3D;Whale Holder. | [optional] [enum: 1, 2, 3, 4, 5, 6, 7] |

### Return type

[**GetTopTradersResponse**](GetTopTradersResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Top traders returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="searchToken"></a>
# **searchToken**
> SearchTokenResponse searchToken(chains, search).recvWindow(recvWindow).nonce(nonce).execute();

Search Token

Search tokens by symbol or contract address.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    GeneralDataApi apiInstance = new GeneralDataApi(defaultClient);
    String chains = "1,56,CT_501"; // String | List of chain IDs to search, comma-separated.
    String search = "USDT"; // String | Search keyword. Can be a token address or token symbol.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      SearchTokenResponse result = apiInstance.searchToken(chains, search)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GeneralDataApi#searchToken");
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
| **chains** | **String**| List of chain IDs to search, comma-separated. | |
| **search** | **String**| Search keyword. Can be a token address or token symbol. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**SearchTokenResponse**](SearchTokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Search results returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

