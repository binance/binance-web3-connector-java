# AddressPortfolioApi

All URIs are relative to *https://web3.binance.com/build*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAddressPnLForSpecificToken**](AddressPortfolioApi.md#getAddressPnLForSpecificToken) | **GET** /api/v1/dex/market/portfolio/token/latest-pnl | Get Address PnL for Specific Token |
| [**getAddressPortfolioOverview**](AddressPortfolioApi.md#getAddressPortfolioOverview) | **GET** /api/v1/dex/market/portfolio/overview | Get Address Portfolio Overview |
| [**getAddressRecentPnL**](AddressPortfolioApi.md#getAddressRecentPnL) | **GET** /api/v1/dex/market/portfolio/recent-pnl | Get Address Recent PnL |
| [**getDexTradeHistory**](AddressPortfolioApi.md#getDexTradeHistory) | **GET** /api/v1/dex/market/portfolio/dex-history | Get DEX Trade History |
| [**getLeaderboard**](AddressPortfolioApi.md#getLeaderboard) | **GET** /api/v1/dex/market/leaderboard/list | Get Leaderboard |
| [**getPortfolioSupportedChains**](AddressPortfolioApi.md#getPortfolioSupportedChains) | **GET** /api/v1/dex/market/portfolio/supported/chain | Get Portfolio Supported Chains |
| [**getTrackedTrades**](AddressPortfolioApi.md#getTrackedTrades) | **GET** /api/v1/dex/market/address-tracker/trades | Get Tracked Trades |


<a id="getAddressPnLForSpecificToken"></a>
# **getAddressPnLForSpecificToken**
> GetAddressPnLForSpecificTokenResponse getAddressPnLForSpecificToken(binanceChainId, walletAddress, tokenContractAddress).recvWindow(recvWindow).nonce(nonce).execute();

Get Address PnL for Specific Token

Return the latest realized PnL detail for a specific token held by an address, including buy/sell stats, current balance, and holding duration.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.AddressPortfolioApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    AddressPortfolioApi apiInstance = new AddressPortfolioApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana).
    String walletAddress = "0x28c6c06298d514db089934071355e5743bf21d60"; // String | Wallet address to query. EVM chains accept lowercase 42-character hex addresses; Solana accepts base58 addresses (case-sensitive).
    String tokenContractAddress = "0x6982508145454ce325ddbe47a25d4ec3d2311933"; // String | Token contract address. EVM chains accept lowercase 42-character hex addresses; Solana accepts base58 addresses (case-sensitive).
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetAddressPnLForSpecificTokenResponse result = apiInstance.getAddressPnLForSpecificToken(binanceChainId, walletAddress, tokenContractAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AddressPortfolioApi#getAddressPnLForSpecificToken");
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
| **walletAddress** | **String**| Wallet address to query. EVM chains accept lowercase 42-character hex addresses; Solana accepts base58 addresses (case-sensitive). | |
| **tokenContractAddress** | **String**| Token contract address. EVM chains accept lowercase 42-character hex addresses; Solana accepts base58 addresses (case-sensitive). | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetAddressPnLForSpecificTokenResponse**](GetAddressPnLForSpecificTokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Token latest PnL returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getAddressPortfolioOverview"></a>
# **getAddressPortfolioOverview**
> GetAddressPortfolioOverviewResponse getAddressPortfolioOverview(binanceChainId, walletAddress, timeFrame).recvWindow(recvWindow).nonce(nonce).execute();

Get Address Portfolio Overview

Return trading performance overview for an address within the selected time frame, including realized PnL, daily PnL breakdown, win rate, and top 3 profitable tokens.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.AddressPortfolioApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    AddressPortfolioApi apiInstance = new AddressPortfolioApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana).
    String walletAddress = "0x28c6c06298d514db089934071355e5743bf21d60"; // String | Wallet address to query. EVM chains accept lowercase 42-character hex addresses; Solana accepts base58 addresses (case-sensitive).
    TimeFrame timeFrame = TimeFrame.fromValue("1"); // TimeFrame | Statistics time range. 1=1D, 2=7D, 3=1M, 4=3M. Note: these values differ from the leaderboard/list endpoint (where 1=7D, 2=1M, 3=3M); do not reuse enum knowledge across endpoints.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetAddressPortfolioOverviewResponse result = apiInstance.getAddressPortfolioOverview(binanceChainId, walletAddress, timeFrame)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AddressPortfolioApi#getAddressPortfolioOverview");
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
| **walletAddress** | **String**| Wallet address to query. EVM chains accept lowercase 42-character hex addresses; Solana accepts base58 addresses (case-sensitive). | |
| **timeFrame** | [**TimeFrame**](.md)| Statistics time range. 1&#x3D;1D, 2&#x3D;7D, 3&#x3D;1M, 4&#x3D;3M. Note: these values differ from the leaderboard/list endpoint (where 1&#x3D;7D, 2&#x3D;1M, 3&#x3D;3M); do not reuse enum knowledge across endpoints. | [enum: 1, 2, 3] |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetAddressPortfolioOverviewResponse**](GetAddressPortfolioOverviewResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Portfolio overview returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getAddressRecentPnL"></a>
# **getAddressRecentPnL**
> GetAddressRecentPnLResponse getAddressRecentPnL(binanceChainId, walletAddress).recvWindow(recvWindow).nonce(nonce).cursor(cursor).limit(limit).execute();

Get Address Recent PnL

Return recent realized PnL list for an address.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.AddressPortfolioApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    AddressPortfolioApi apiInstance = new AddressPortfolioApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana).
    String walletAddress = "0x28c6c06298d514db089934071355e5743bf21d60"; // String | Wallet address to query. EVM chains accept lowercase 42-character hex addresses; Solana accepts base58 addresses (case-sensitive).
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String cursor = ""; // String | Pagination cursor. Omit or pass empty string for the first page; pass the cursor from the previous response to get the next page.
    String limit = "20"; // String | Number of records per page. Default 20, max 100.
    try {
      GetAddressRecentPnLResponse result = apiInstance.getAddressRecentPnL(binanceChainId, walletAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .cursor(cursor)
            .limit(limit)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AddressPortfolioApi#getAddressRecentPnL");
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
| **walletAddress** | **String**| Wallet address to query. EVM chains accept lowercase 42-character hex addresses; Solana accepts base58 addresses (case-sensitive). | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **cursor** | **String**| Pagination cursor. Omit or pass empty string for the first page; pass the cursor from the previous response to get the next page. | [optional] |
| **limit** | **String**| Number of records per page. Default 20, max 100. | [optional] |

### Return type

[**GetAddressRecentPnLResponse**](GetAddressRecentPnLResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Recent PnL list returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getDexTradeHistory"></a>
# **getDexTradeHistory**
> GetDexTradeHistoryResponse getDexTradeHistory(binanceChainId, walletAddress).recvWindow(recvWindow).nonce(nonce).begin(begin).end(end).tokenContractAddress(tokenContractAddress).type(type).cursor(cursor).limit(limit).execute();

Get DEX Trade History

Return swap trade history for a specific address. Supports filtering by time range, token, and trade type.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.AddressPortfolioApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    AddressPortfolioApi apiInstance = new AddressPortfolioApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana).
    String walletAddress = "0x28c6c06298d514db089934071355e5743bf21d60"; // String | Wallet address to query. EVM chains accept lowercase 42-character hex addresses; Solana accepts base58 addresses (case-sensitive).
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String begin = "1714000000000"; // String | Start timestamp (Unix milliseconds, inclusive). If both begin and end are omitted, no time filter is applied.
    String end = "1748601600000"; // String | End timestamp (Unix milliseconds, inclusive). If both begin and end are omitted, no time filter is applied.
    String tokenContractAddress = "0x6982508145454ce325ddbe47a25d4ec3d2311933"; // String | Filter by token contract address. Returns all tokens when omitted.
    OrderType type = OrderType.fromValue("1"); // OrderType | Trade type filter. 1=Buy, 2=Sell. Omit to return all types.
    String cursor = ""; // String | Pagination cursor. Omit or pass empty string for the first page.
    String limit = "20"; // String | Number of records per page. Default 20, max 100.
    try {
      GetDexTradeHistoryResponse result = apiInstance.getDexTradeHistory(binanceChainId, walletAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .begin(begin)
            .end(end)
            .tokenContractAddress(tokenContractAddress)
            .type(type)
            .cursor(cursor)
            .limit(limit)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AddressPortfolioApi#getDexTradeHistory");
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
| **walletAddress** | **String**| Wallet address to query. EVM chains accept lowercase 42-character hex addresses; Solana accepts base58 addresses (case-sensitive). | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **begin** | **String**| Start timestamp (Unix milliseconds, inclusive). If both begin and end are omitted, no time filter is applied. | [optional] |
| **end** | **String**| End timestamp (Unix milliseconds, inclusive). If both begin and end are omitted, no time filter is applied. | [optional] |
| **tokenContractAddress** | **String**| Filter by token contract address. Returns all tokens when omitted. | [optional] |
| **type** | [**OrderType**](.md)| Trade type filter. 1&#x3D;Buy, 2&#x3D;Sell. Omit to return all types. | [optional] [enum: 1, 2] |
| **cursor** | **String**| Pagination cursor. Omit or pass empty string for the first page. | [optional] |
| **limit** | **String**| Number of records per page. Default 20, max 100. | [optional] |

### Return type

[**GetDexTradeHistoryResponse**](GetDexTradeHistoryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | DEX history returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getLeaderboard"></a>
# **getLeaderboard**
> GetLeaderboardResponse getLeaderboard(binanceChainId, timeFrame, sortBy).recvWindow(recvWindow).nonce(nonce).walletType(walletType).minRealizedPnlUsd(minRealizedPnlUsd).maxRealizedPnlUsd(maxRealizedPnlUsd).minWinRatePercent(minWinRatePercent).maxWinRatePercent(maxWinRatePercent).minTxs(minTxs).maxTxs(maxTxs).minTxVolume(minTxVolume).maxTxVolume(maxTxVolume).cursor(cursor).limit(limit).execute();

Get Leaderboard

Return a leaderboard of top-performing wallets, with sorting and filtering by PnL, win rate, transaction count, and volume.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.AddressPortfolioApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    AddressPortfolioApi apiInstance = new AddressPortfolioApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana). Single chain only.
    TimeFrame timeFrame = TimeFrame.fromValue("1"); // TimeFrame | Statistics time range. 1=7D, 2=1M, 3=3M. Note: these values differ from the portfolio/overview endpoint (where 1=1D, 2=7D, 3=1M, 4=3M); do not reuse enum knowledge across endpoints.
    SortBy sortBy = SortBy.fromValue("1"); // SortBy | Sort field. 1=Realized PnL (USD), 2=Win Rate, 3=Transaction count, 4=Volume (USD), 5=Realized PnL %.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    WalletType walletType = WalletType.fromValue("1"); // WalletType | Wallet type filter, single selection only. 1=Smart Money, 2=KOL, 3=Hot List. Returns all types when omitted.
    String minRealizedPnlUsd = "1000"; // String | Minimum realized PnL filter, denominated in USD.
    String maxRealizedPnlUsd = "50000"; // String | Maximum realized PnL filter, denominated in USD.
    String minWinRatePercent = "50"; // String | Minimum win rate filter, without percent sign. \"50\" means ≥50%.
    String maxWinRatePercent = "90"; // String | Maximum win rate filter, without percent sign. \"90\" means ≤90%.
    String minTxs = "10"; // String | Minimum transaction count filter.
    String maxTxs = "1000"; // String | Maximum transaction count filter.
    String minTxVolume = "5000"; // String | Minimum total transaction volume filter, denominated in USD.
    String maxTxVolume = "1000000"; // String | Maximum total transaction volume filter, denominated in USD.
    String cursor = ""; // String | Pagination cursor. Omit or pass empty string for the first page.
    String limit = "50"; // String | Number of records per page. Default 50, max 50.
    try {
      GetLeaderboardResponse result = apiInstance.getLeaderboard(binanceChainId, timeFrame, sortBy)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .walletType(walletType)
            .minRealizedPnlUsd(minRealizedPnlUsd)
            .maxRealizedPnlUsd(maxRealizedPnlUsd)
            .minWinRatePercent(minWinRatePercent)
            .maxWinRatePercent(maxWinRatePercent)
            .minTxs(minTxs)
            .maxTxs(maxTxs)
            .minTxVolume(minTxVolume)
            .maxTxVolume(maxTxVolume)
            .cursor(cursor)
            .limit(limit)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AddressPortfolioApi#getLeaderboard");
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
| **binanceChainId** | **String**| Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). Single chain only. | |
| **timeFrame** | [**TimeFrame**](.md)| Statistics time range. 1&#x3D;7D, 2&#x3D;1M, 3&#x3D;3M. Note: these values differ from the portfolio/overview endpoint (where 1&#x3D;1D, 2&#x3D;7D, 3&#x3D;1M, 4&#x3D;3M); do not reuse enum knowledge across endpoints. | [enum: 1, 2, 3] |
| **sortBy** | [**SortBy**](.md)| Sort field. 1&#x3D;Realized PnL (USD), 2&#x3D;Win Rate, 3&#x3D;Transaction count, 4&#x3D;Volume (USD), 5&#x3D;Realized PnL %. | [enum: 1, 2, 3, 4, 5] |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **walletType** | [**WalletType**](.md)| Wallet type filter, single selection only. 1&#x3D;Smart Money, 2&#x3D;KOL, 3&#x3D;Hot List. Returns all types when omitted. | [optional] [enum: 1, 2, 3] |
| **minRealizedPnlUsd** | **String**| Minimum realized PnL filter, denominated in USD. | [optional] |
| **maxRealizedPnlUsd** | **String**| Maximum realized PnL filter, denominated in USD. | [optional] |
| **minWinRatePercent** | **String**| Minimum win rate filter, without percent sign. \&quot;50\&quot; means ≥50%. | [optional] |
| **maxWinRatePercent** | **String**| Maximum win rate filter, without percent sign. \&quot;90\&quot; means ≤90%. | [optional] |
| **minTxs** | **String**| Minimum transaction count filter. | [optional] |
| **maxTxs** | **String**| Maximum transaction count filter. | [optional] |
| **minTxVolume** | **String**| Minimum total transaction volume filter, denominated in USD. | [optional] |
| **maxTxVolume** | **String**| Maximum total transaction volume filter, denominated in USD. | [optional] |
| **cursor** | **String**| Pagination cursor. Omit or pass empty string for the first page. | [optional] |
| **limit** | **String**| Number of records per page. Default 50, max 50. | [optional] |

### Return type

[**GetLeaderboardResponse**](GetLeaderboardResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Leaderboard list returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getPortfolioSupportedChains"></a>
# **getPortfolioSupportedChains**
> GetPortfolioSupportedChainsResponse getPortfolioSupportedChains().recvWindow(recvWindow).nonce(nonce).execute();

Get Portfolio Supported Chains

Return the list of blockchains supported by address portfolio analysis.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.AddressPortfolioApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    AddressPortfolioApi apiInstance = new AddressPortfolioApi(defaultClient);
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetPortfolioSupportedChainsResponse result = apiInstance.getPortfolioSupportedChains()
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AddressPortfolioApi#getPortfolioSupportedChains");
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

[**GetPortfolioSupportedChainsResponse**](GetPortfolioSupportedChainsResponse.md)

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

<a id="getTrackedTrades"></a>
# **getTrackedTrades**
> GetTrackedTradesResponse getTrackedTrades(trackerType).recvWindow(recvWindow).nonce(nonce).walletAddress(walletAddress).tradeType(tradeType).binanceChainId(binanceChainId).minVolume(minVolume).maxVolume(maxVolume).minMarketCap(minMarketCap).maxMarketCap(maxMarketCap).isHideRiskToken(isHideRiskToken).limit(limit).execute();

Get Tracked Trades

Return the latest swap trades from tracked addresses (smart money, KOL, or custom address list).

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.AddressPortfolioApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    AddressPortfolioApi apiInstance = new AddressPortfolioApi(defaultClient);
    TrackerType trackerType = TrackerType.fromValue("1"); // TrackerType | Tracker type. 1=Smart Money, 2=KOL, 3=Custom address list (walletAddress required).
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String walletAddress = "0x28c6c06298d514db089934071355e5743bf21d60,0xd8da6bf26964af9d7eed9e03e53415d37aa96045"; // String | Required when trackerType=3. One or more wallet addresses, comma-separated, up to 20. EVM chains accept lowercase 42-character hex addresses; Solana accepts base58 addresses (case-sensitive).
    String tradeType = "0"; // String | Trade type filter. 0=All (default), 1=Buy, 2=Sell, 3=Add position, 4=Reduce position, 5=Open position, 6=Close position, 7=Transfer in, 8=Transfer out. Multiple values comma-separated.
    String binanceChainId = "1"; // String | Filter by chain. Returns all chains when omitted.
    String minVolume = "100"; // String | Minimum trade volume filter, denominated in USD.
    String maxVolume = "100000"; // String | Maximum trade volume filter, denominated in USD.
    String minMarketCap = "10000"; // String | Minimum market cap filter, denominated in USD.
    String maxMarketCap = "10000000"; // String | Maximum market cap filter, denominated in USD.
    Boolean isHideRiskToken = true; // Boolean | Whether to hide risk tokens. true=hide risk tokens (default), false=show all tokens including risk tokens.
    Integer limit = 50; // Integer | Maximum number of trades to return. Effective only for trackerType=3 (custom address list); trackerType=1/2 ignore this and use the downstream public query fixed cap. Omit to use the downstream default.
    try {
      GetTrackedTradesResponse result = apiInstance.getTrackedTrades(trackerType)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .walletAddress(walletAddress)
            .tradeType(tradeType)
            .binanceChainId(binanceChainId)
            .minVolume(minVolume)
            .maxVolume(maxVolume)
            .minMarketCap(minMarketCap)
            .maxMarketCap(maxMarketCap)
            .isHideRiskToken(isHideRiskToken)
            .limit(limit)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AddressPortfolioApi#getTrackedTrades");
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
| **trackerType** | [**TrackerType**](.md)| Tracker type. 1&#x3D;Smart Money, 2&#x3D;KOL, 3&#x3D;Custom address list (walletAddress required). | [enum: 1, 2, 3] |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **walletAddress** | **String**| Required when trackerType&#x3D;3. One or more wallet addresses, comma-separated, up to 20. EVM chains accept lowercase 42-character hex addresses; Solana accepts base58 addresses (case-sensitive). | [optional] |
| **tradeType** | **String**| Trade type filter. 0&#x3D;All (default), 1&#x3D;Buy, 2&#x3D;Sell, 3&#x3D;Add position, 4&#x3D;Reduce position, 5&#x3D;Open position, 6&#x3D;Close position, 7&#x3D;Transfer in, 8&#x3D;Transfer out. Multiple values comma-separated. | [optional] |
| **binanceChainId** | **String**| Filter by chain. Returns all chains when omitted. | [optional] |
| **minVolume** | **String**| Minimum trade volume filter, denominated in USD. | [optional] |
| **maxVolume** | **String**| Maximum trade volume filter, denominated in USD. | [optional] |
| **minMarketCap** | **String**| Minimum market cap filter, denominated in USD. | [optional] |
| **maxMarketCap** | **String**| Maximum market cap filter, denominated in USD. | [optional] |
| **isHideRiskToken** | **Boolean**| Whether to hide risk tokens. true&#x3D;hide risk tokens (default), false&#x3D;show all tokens including risk tokens. | [optional] |
| **limit** | **Integer**| Maximum number of trades to return. Effective only for trackerType&#x3D;3 (custom address list); trackerType&#x3D;1/2 ignore this and use the downstream public query fixed cap. Omit to use the downstream default. | [optional] |

### Return type

[**GetTrackedTradesResponse**](GetTrackedTradesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Address tracker trades returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

