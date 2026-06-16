package com.binance.connector.client.web3_wallet.rest.api;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.web3.common.ApiClient;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.model.ApproveTransaction;
import com.binance.connector.client.web3_wallet.rest.model.AutoSlippage;
import com.binance.connector.client.web3_wallet.rest.model.Bar;
import com.binance.connector.client.web3_wallet.rest.model.BroadcastTransactionsRequest;
import com.binance.connector.client.web3_wallet.rest.model.BroadcastTransactionsResponse;
import com.binance.connector.client.web3_wallet.rest.model.BuildSwapTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.GasLevel;
import com.binance.connector.client.web3_wallet.rest.model.GetAggregatedQuoteResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetAggregatorSupportedChainsResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetAllTokenBalancesByAddressResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetBroadcastOrdersResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetCandlesResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetErc20ApproveTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetGasLimitRequest;
import com.binance.connector.client.web3_wallet.rest.model.GetGasLimitResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetGasPriceResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetHoldersRankingResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetHotTokenListResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetSupportedChainsResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenAdvancedInfoResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenBalancesByAddressRequest;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenBalancesByAddressResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenBasicInfoResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenPriceResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenTradesResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenTradingInfoResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTopLiquidityPoolsResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTopTradersResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTransactionDetailByHashResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTransactionStatusResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTransactionSupportedChainsResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTransactionsByAddressResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetWalletSupportedChainsResponse;
import com.binance.connector.client.web3_wallet.rest.model.RankBy;
import com.binance.connector.client.web3_wallet.rest.model.RankingTimeFrame;
import com.binance.connector.client.web3_wallet.rest.model.SearchTokenResponse;
import com.binance.connector.client.web3_wallet.rest.model.SimulateTransactionsRequest;
import com.binance.connector.client.web3_wallet.rest.model.SimulateTransactionsResponse;
import com.binance.connector.client.web3_wallet.rest.model.TagFilter;

public class Web3WalletRestApi {

    private final MarketApi marketApi;
    private final TradingApi tradingApi;
    private final TransactionApi transactionApi;
    private final WalletApi walletApi;

    public Web3WalletRestApi(ClientConfiguration configuration) {
        this(Web3WalletRestApiUtil.getDefaultClient(configuration));
    }

    public Web3WalletRestApi(ApiClient apiClient) {
        this.marketApi = new MarketApi(apiClient);
        this.tradingApi = new TradingApi(apiClient);
        this.transactionApi = new TransactionApi(apiClient);
        this.walletApi = new WalletApi(apiClient);
    }

    public ApiResponse<GetCandlesResponse> getCandles(MarketApi.GetCandlesRequest request) {
        return marketApi.getCandles(request);
    }

    /**
     * Get Candles Return candlestick (K-line) data for a token.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param tokenContractAddress Token contract address. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param bar Candlestick time granularity, default \&quot;1m\&quot; (1 minute). Available
     *     values: 1s (1 second), 5s (5 seconds), 30s (30 seconds), 1m (1 minute), 3m (3 minutes),
     *     5m (5 minutes), 15m (15 minutes), 30m (30 minutes), 1h (1 hour), 2h (2 hours), 4h (4
     *     hours), 6h (6 hours), 8h (8 hours), 12h (12 hours), 1d (1 day), 3d (3 days), 1w (1 week),
     *     1M (1 month). (optional, default to 1m)
     * @param after End time for the query, Unix millisecond timestamp. Returns candles earlier than
     *     this time (exclusive). (optional)
     * @param before Start time for the query, Unix millisecond timestamp. Returns candles later
     *     than this time (exclusive). (optional)
     * @param limit Number of candles to return. Defaults to 100. (optional)
     * @return ApiResponse&lt;GetCandlesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Candle data returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/market-api#get-candles">Get
     *     Candles Documentation</a>
     */
    public ApiResponse<GetCandlesResponse> getCandles(
            String binanceChainId,
            String tokenContractAddress,
            Long recvWindow,
            String nonce,
            Bar bar,
            Long after,
            Long before,
            Integer limit)
            throws ApiException {
        return marketApi.getCandles(
                binanceChainId, tokenContractAddress, recvWindow, nonce, bar, after, before, limit);
    }

    public ApiResponse<GetHoldersRankingResponse> getHoldersRanking(
            MarketApi.GetHoldersRankingRequest request) {
        return marketApi.getHoldersRanking(request);
    }

    /**
     * Get Holders Ranking Return the holders ranking list for a token, including holding amount,
     * holding percentage, native-token balance, average buy/sell price, realized PnL, and funding
     * source. Up to 100 records. Pagination is not supported.
     *
     * @param binanceChainId Unique chain identifier. (required)
     * @param tokenContractAddress Token contract address. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param tagFilter Address tag filter, single selection only. Returns all holder addresses (by
     *     holding amount descending) when omitted; returns addresses matching the specified tag
     *     when provided. Mapping: 1&#x3D;KOL, 2&#x3D;Developer, 3&#x3D;Smart Money, 4&#x3D;Insider,
     *     5&#x3D;Sniper, 6&#x3D;Bundler. (optional)
     * @return ApiResponse&lt;GetHoldersRankingResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Holders ranking returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/market-api#get-holders-ranking">Get
     *     Holders Ranking Documentation</a>
     */
    public ApiResponse<GetHoldersRankingResponse> getHoldersRanking(
            String binanceChainId,
            String tokenContractAddress,
            Long recvWindow,
            String nonce,
            TagFilter tagFilter)
            throws ApiException {
        return marketApi.getHoldersRanking(
                binanceChainId, tokenContractAddress, recvWindow, nonce, tagFilter);
    }

    public ApiResponse<GetHotTokenListResponse> getHotTokenList(
            MarketApi.GetHotTokenListRequest request) {
        return marketApi.getHotTokenList(request);
    }

    /**
     * Get Hot Token List Get hot token ranking list. Supports sorting by volume, price change,
     * market cap, etc., with filters for holding distribution, developer behavior, liquidity, and
     * more.
     *
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param binanceChainId Chain identifier. Single value only. Omit to return mixed results
     *     across all chains. (optional)
     * @param rankBy Ranking field. 1&#x3D;price, 2&#x3D;price change, 3&#x3D;transactions,
     *     4&#x3D;volume, 5&#x3D;market cap, 6&#x3D;liquidity, 7&#x3D;creation time, 8&#x3D;holders,
     *     9&#x3D;Binance MPC wallet holders, 10&#x3D;net inflow. (optional)
     * @param rankingTimeFrame Data time range. 1&#x3D;1 min, 2&#x3D;5 min, 3&#x3D;1 hour, 4&#x3D;4
     *     hours, 5&#x3D;24 hours. Default 1 hour. (optional, default to 3)
     * @param priceChangePercentMin Minimum price change filter. \&quot;5\&quot; means 5%.
     *     (optional)
     * @param priceChangePercentMax Maximum price change filter. \&quot;100\&quot; means 100%.
     *     (optional)
     * @param volumeMin Minimum volume filter, denominated in USD. (optional)
     * @param volumeMax Maximum volume filter, denominated in USD. (optional)
     * @param txsMin Minimum transaction count. (optional)
     * @param txsMax Maximum transaction count. (optional)
     * @param marketCapMin Minimum market cap filter, denominated in USD. (optional)
     * @param marketCapMax Maximum market cap filter, denominated in USD. (optional)
     * @param liquidityMin Minimum liquidity filter, denominated in USD. (optional)
     * @param liquidityMax Maximum liquidity filter, denominated in USD. (optional)
     * @param devHoldingPercentMin Minimum developer holding percentage filter. \&quot;5\&quot;
     *     means 5%. (optional)
     * @param devHoldingPercentMax Maximum developer holding percentage filter. \&quot;5\&quot;
     *     means 5%. (optional)
     * @param inflowUsdMin Minimum net inflow filter, denominated in USD. (optional)
     * @param inflowUsdMax Maximum net inflow filter, denominated in USD. (optional)
     * @param holdersMin Minimum holder count. (optional)
     * @param holdersMax Maximum holder count. (optional)
     * @param bnHolderCountMin Minimum Binance MPC wallet holders. (optional)
     * @param bnHolderCountMax Maximum Binance MPC wallet holders. (optional)
     * @param top10HoldingPercentMin Minimum top-10 holding percentage. \&quot;5\&quot; means 5%.
     *     (optional)
     * @param top10HoldingPercentMax Maximum top-10 holding percentage. \&quot;5\&quot; means 5%.
     *     (optional)
     * @param sniperHoldingPercentMin Minimum sniper holding percentage. \&quot;5\&quot; means 5%.
     *     (optional)
     * @param sniperHoldingPercentMax Maximum sniper holding percentage. \&quot;5\&quot; means 5%.
     *     (optional)
     * @param smartMoneyHoldingPercentMin Minimum smart-money holding percentage. \&quot;5\&quot;
     *     means 5%. (optional)
     * @param smartMoneyHoldingPercentMax Maximum smart-money holding percentage. \&quot;5\&quot;
     *     means 5%. (optional)
     * @param kolHoldingPercentMin Minimum KOL holding percentage. \&quot;5\&quot; means 5%.
     *     (optional)
     * @param kolHoldingPercentMax Maximum KOL holding percentage. \&quot;5\&quot; means 5%.
     *     (optional)
     * @param proHoldingPercentMin Minimum pro-trader holding percentage. \&quot;5\&quot; means 5%.
     *     (optional)
     * @param proHoldingPercentMax Maximum pro-trader holding percentage. \&quot;5\&quot; means 5%.
     *     (optional)
     * @param freshWalletHoldingPercentMin Minimum fresh-wallet holding percentage. \&quot;5\&quot;
     *     means 5%. (optional)
     * @param freshWalletHoldingPercentMax Maximum fresh-wallet holding percentage. \&quot;5\&quot;
     *     means 5%. (optional)
     * @param insiderHoldingPercentMin Minimum insider holding percentage. \&quot;5\&quot; means 5%.
     *     (optional)
     * @param insiderHoldingPercentMax Maximum insider holding percentage. \&quot;5\&quot; means 5%.
     *     (optional)
     * @param bundlerHoldingPercentMin Minimum bundler holding percentage. \&quot;5\&quot; means 5%.
     *     (optional)
     * @param bundlerHoldingPercentMax Maximum bundler holding percentage. \&quot;5\&quot; means 5%.
     *     (optional)
     * @param devCreatedTokenCountMin Minimum developer-created token count. (optional)
     * @param devCreatedTokenCountMax Maximum developer-created token count. (optional)
     * @param devMigratedTokenCountMin Minimum developer-migrated token count. (optional)
     * @param devMigratedTokenCountMax Maximum developer-migrated token count. (optional)
     * @param devMigratedTokenPercentMin Minimum developer-migrated token percentage.
     *     \&quot;5\&quot; means 5%. (optional)
     * @param devMigratedTokenPercentMax Maximum developer-migrated token percentage.
     *     \&quot;5\&quot; means 5%. (optional)
     * @param isDevSoldAll When set to true, returns only tokens where the developer has sold all
     *     holdings. Not filtered when omitted or false. (optional)
     * @param isDevBurned When set to true, returns only tokens where the developer has burned
     *     tokens. Not filtered when omitted or false. (optional)
     * @param isMint When set to true, excludes tokens with minting capability. Default false.
     *     (optional)
     * @param isFreeze When set to true, excludes tokens with freeze capability. Default false.
     *     (optional)
     * @param isHideWashTradingTokens When set to true, excludes tokens with wash trading behavior.
     *     Default true. (optional)
     * @param isHideDevWashTradingTokens When set to true, excludes tokens where the developer has
     *     wash trading behavior. Default true. (optional)
     * @param isHideInternalWashTradingTokens When set to true, excludes tokens where insiders have
     *     wash trading behavior. Default true. (optional)
     * @param pageId Pagination identifier. Do not pass on the first request; pass the page value
     *     from the previous response to get the next page. (optional)
     * @param size Page size. Maximum 100. Defaults to 100. (optional)
     * @return ApiResponse&lt;GetHotTokenListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Hot token list returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/market-api#get-hot-token-list">Get
     *     Hot Token List Documentation</a>
     */
    public ApiResponse<GetHotTokenListResponse> getHotTokenList(
            Long recvWindow,
            String nonce,
            String binanceChainId,
            RankBy rankBy,
            RankingTimeFrame rankingTimeFrame,
            String priceChangePercentMin,
            String priceChangePercentMax,
            String volumeMin,
            String volumeMax,
            String txsMin,
            String txsMax,
            String marketCapMin,
            String marketCapMax,
            String liquidityMin,
            String liquidityMax,
            String devHoldingPercentMin,
            String devHoldingPercentMax,
            String inflowUsdMin,
            String inflowUsdMax,
            String holdersMin,
            String holdersMax,
            String bnHolderCountMin,
            String bnHolderCountMax,
            String top10HoldingPercentMin,
            String top10HoldingPercentMax,
            String sniperHoldingPercentMin,
            String sniperHoldingPercentMax,
            String smartMoneyHoldingPercentMin,
            String smartMoneyHoldingPercentMax,
            String kolHoldingPercentMin,
            String kolHoldingPercentMax,
            String proHoldingPercentMin,
            String proHoldingPercentMax,
            String freshWalletHoldingPercentMin,
            String freshWalletHoldingPercentMax,
            String insiderHoldingPercentMin,
            String insiderHoldingPercentMax,
            String bundlerHoldingPercentMin,
            String bundlerHoldingPercentMax,
            String devCreatedTokenCountMin,
            String devCreatedTokenCountMax,
            String devMigratedTokenCountMin,
            String devMigratedTokenCountMax,
            String devMigratedTokenPercentMin,
            String devMigratedTokenPercentMax,
            Boolean isDevSoldAll,
            Boolean isDevBurned,
            Boolean isMint,
            Boolean isFreeze,
            Boolean isHideWashTradingTokens,
            Boolean isHideDevWashTradingTokens,
            Boolean isHideInternalWashTradingTokens,
            Integer pageId,
            Integer size)
            throws ApiException {
        return marketApi.getHotTokenList(
                recvWindow,
                nonce,
                binanceChainId,
                rankBy,
                rankingTimeFrame,
                priceChangePercentMin,
                priceChangePercentMax,
                volumeMin,
                volumeMax,
                txsMin,
                txsMax,
                marketCapMin,
                marketCapMax,
                liquidityMin,
                liquidityMax,
                devHoldingPercentMin,
                devHoldingPercentMax,
                inflowUsdMin,
                inflowUsdMax,
                holdersMin,
                holdersMax,
                bnHolderCountMin,
                bnHolderCountMax,
                top10HoldingPercentMin,
                top10HoldingPercentMax,
                sniperHoldingPercentMin,
                sniperHoldingPercentMax,
                smartMoneyHoldingPercentMin,
                smartMoneyHoldingPercentMax,
                kolHoldingPercentMin,
                kolHoldingPercentMax,
                proHoldingPercentMin,
                proHoldingPercentMax,
                freshWalletHoldingPercentMin,
                freshWalletHoldingPercentMax,
                insiderHoldingPercentMin,
                insiderHoldingPercentMax,
                bundlerHoldingPercentMin,
                bundlerHoldingPercentMax,
                devCreatedTokenCountMin,
                devCreatedTokenCountMax,
                devMigratedTokenCountMin,
                devMigratedTokenCountMax,
                devMigratedTokenPercentMin,
                devMigratedTokenPercentMax,
                isDevSoldAll,
                isDevBurned,
                isMint,
                isFreeze,
                isHideWashTradingTokens,
                isHideDevWashTradingTokens,
                isHideInternalWashTradingTokens,
                pageId,
                size);
    }

    public ApiResponse<GetSupportedChainsResponse> getSupportedChains(
            MarketApi.GetSupportedChainsRequest request) {
        return marketApi.getSupportedChains(request);
    }

    /**
     * Get Supported Chains Return the list of blockchains supported by the market service.
     *
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetSupportedChainsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Supported chains returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/market-api#get-supported-chains">Get
     *     Supported Chains Documentation</a>
     */
    public ApiResponse<GetSupportedChainsResponse> getSupportedChains(Long recvWindow, String nonce)
            throws ApiException {
        return marketApi.getSupportedChains(recvWindow, nonce);
    }

    public ApiResponse<GetTokenAdvancedInfoResponse> getTokenAdvancedInfo(
            MarketApi.GetTokenAdvancedInfoRequest request) {
        return marketApi.getTokenAdvancedInfo(request);
    }

    /**
     * Get Token Advanced Info Return comprehensive metrics for a token, including creator and
     * launch info, holding percentages by address type (smart money, KOL, sniper, bundler, fresh
     * wallet, etc.), and token tags.
     *
     * @param binanceChainId Unique chain identifier. (required)
     * @param tokenContractAddress Token contract address. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetTokenAdvancedInfoResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Advanced token info returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/market-api#get-token-advanced-info">Get
     *     Token Advanced Info Documentation</a>
     */
    public ApiResponse<GetTokenAdvancedInfoResponse> getTokenAdvancedInfo(
            String binanceChainId, String tokenContractAddress, Long recvWindow, String nonce)
            throws ApiException {
        return marketApi.getTokenAdvancedInfo(
                binanceChainId, tokenContractAddress, recvWindow, nonce);
    }

    public ApiResponse<GetTokenBasicInfoResponse> getTokenBasicInfo(
            MarketApi.GetTokenBasicInfoRequest request) {
        return marketApi.getTokenBasicInfo(request);
    }

    /**
     * Get Token Basic Info Return basic metadata for a token: name, symbol, logo, decimals, creator
     * address, creation time, and tag info.
     *
     * @param binanceChainId Unique chain identifier. (required)
     * @param tokenContractAddress Token contract address. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetTokenBasicInfoResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Token basic info returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 201 </td><td> Created. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/market-api#get-token-basic-info">Get
     *     Token Basic Info Documentation</a>
     */
    public ApiResponse<GetTokenBasicInfoResponse> getTokenBasicInfo(
            String binanceChainId, String tokenContractAddress, Long recvWindow, String nonce)
            throws ApiException {
        return marketApi.getTokenBasicInfo(binanceChainId, tokenContractAddress, recvWindow, nonce);
    }

    public ApiResponse<GetTokenPriceResponse> getTokenPrice(
            MarketApi.GetTokenPriceRequest request) {
        return marketApi.getTokenPrice(request);
    }

    /**
     * Get Token Price Get the latest price for tokens. Supports batch queries, up to 100 tokens per
     * request.
     *
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetTokenPriceResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Token prices returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 201 </td><td> Created. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/market-api#get-token-price">Get
     *     Token Price Documentation</a>
     */
    public ApiResponse<GetTokenPriceResponse> getTokenPrice(Long recvWindow, String nonce)
            throws ApiException {
        return marketApi.getTokenPrice(recvWindow, nonce);
    }

    public ApiResponse<GetTokenTradesResponse> getTokenTrades(
            MarketApi.GetTokenTradesRequest request) {
        return marketApi.getTokenTrades(request);
    }

    /**
     * Get Token Trades Return on-chain trade history for a token. Supports tag filtering and wallet
     * address filtering.
     *
     * @param binanceChainId Unique chain identifier. (required)
     * @param tokenContractAddress Token contract address. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param cursor Pagination cursor. Do not pass on the first request; pass the cursor value from
     *     the previous response to get the next page. (optional)
     * @param limit Number of results per page, maximum 500, defaults to 100. (optional)
     * @param tagFilter Address tag filter, single selection only. Returns all trades with
     *     pagination when omitted; returns only the latest 100 trades for the specified tag&#39;s
     *     addresses when provided (cursor and limit are ignored). Mapping: 1&#x3D;KOL,
     *     2&#x3D;Developer, 3&#x3D;Smart Money, 4&#x3D;Insider, 5&#x3D;Sniper, 6&#x3D;Bundler,
     *     7&#x3D;Whale Holder. (optional)
     * @param walletAddressFilter Filter by specific wallet addresses. Separate multiple addresses
     *     with commas. Up to 2 addresses. (optional)
     * @return ApiResponse&lt;GetTokenTradesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Trade history returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/market-api#get-token-trades">Get
     *     Token Trades Documentation</a>
     */
    public ApiResponse<GetTokenTradesResponse> getTokenTrades(
            String binanceChainId,
            String tokenContractAddress,
            Long recvWindow,
            String nonce,
            String cursor,
            Integer limit,
            TagFilter tagFilter,
            String walletAddressFilter)
            throws ApiException {
        return marketApi.getTokenTrades(
                binanceChainId,
                tokenContractAddress,
                recvWindow,
                nonce,
                cursor,
                limit,
                tagFilter,
                walletAddressFilter);
    }

    public ApiResponse<GetTokenTradingInfoResponse> getTokenTradingInfo(
            MarketApi.GetTokenTradingInfoRequest request) {
        return marketApi.getTokenTradingInfo(request);
    }

    /**
     * Get Token Trading Info Get token price and trading data (volume, transactions, market cap,
     * holders, etc.). Supports batch queries for up to 100 tokens.
     *
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetTokenTradingInfoResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Price info returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 201 </td><td> Created. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/market-api#get-token-trading-info">Get
     *     Token Trading Info Documentation</a>
     */
    public ApiResponse<GetTokenTradingInfoResponse> getTokenTradingInfo(
            Long recvWindow, String nonce) throws ApiException {
        return marketApi.getTokenTradingInfo(recvWindow, nonce);
    }

    public ApiResponse<GetTopLiquidityPoolsResponse> getTopLiquidityPools(
            MarketApi.GetTopLiquidityPoolsRequest request) {
        return marketApi.getTopLiquidityPools(request);
    }

    /**
     * Get Top Liquidity Pools Return the top liquidity pools for a token, including pool name,
     * protocol, liquidity in USD, pool address, and per-token composition.
     *
     * @param binanceChainId Unique chain identifier. (required)
     * @param tokenContractAddress Token contract address. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetTopLiquidityPoolsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Top liquidity pools returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/market-api#get-top-liquidity-pools">Get
     *     Top Liquidity Pools Documentation</a>
     */
    public ApiResponse<GetTopLiquidityPoolsResponse> getTopLiquidityPools(
            String binanceChainId, String tokenContractAddress, Long recvWindow, String nonce)
            throws ApiException {
        return marketApi.getTopLiquidityPools(
                binanceChainId, tokenContractAddress, recvWindow, nonce);
    }

    public ApiResponse<GetTopTradersResponse> getTopTraders(
            MarketApi.GetTopTradersRequest request) {
        return marketApi.getTopTraders(request);
    }

    /**
     * Get Top Traders Return the top profit-making addresses for a token, ranked by realized PnL
     * descending. Includes holding amount, average buy/sell price, realized PnL, and funding
     * source. Up to 100 records. Pagination is not supported.
     *
     * @param binanceChainId Unique chain identifier. (required)
     * @param tokenContractAddress Token contract address. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param tagFilter Address tag filter, single selection only. Returns all top profit addresses
     *     (by realized PnL descending) when omitted; returns addresses matching the specified tag
     *     when provided. Mapping: 1&#x3D;KOL, 2&#x3D;Developer, 3&#x3D;Smart Money, 4&#x3D;Insider,
     *     5&#x3D;Sniper, 6&#x3D;Bundler, 7&#x3D;Whale Holder. (optional)
     * @return ApiResponse&lt;GetTopTradersResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Top traders returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/market-api#get-top-traders">Get
     *     Top Traders Documentation</a>
     */
    public ApiResponse<GetTopTradersResponse> getTopTraders(
            String binanceChainId,
            String tokenContractAddress,
            Long recvWindow,
            String nonce,
            TagFilter tagFilter)
            throws ApiException {
        return marketApi.getTopTraders(
                binanceChainId, tokenContractAddress, recvWindow, nonce, tagFilter);
    }

    public ApiResponse<SearchTokenResponse> searchToken(MarketApi.SearchTokenRequest request) {
        return marketApi.searchToken(request);
    }

    /**
     * Search Token Search tokens by symbol or contract address.
     *
     * @param chains List of chain IDs to search, comma-separated. (required)
     * @param search Search keyword. Can be a token address or token symbol. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;SearchTokenResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Search results returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/market-api#search-token">Search
     *     Token Documentation</a>
     */
    public ApiResponse<SearchTokenResponse> searchToken(
            String chains, String search, Long recvWindow, String nonce) throws ApiException {
        return marketApi.searchToken(chains, search, recvWindow, nonce);
    }

    public ApiResponse<BuildSwapTransactionResponse> buildSwapTransaction(
            TradingApi.BuildSwapTransactionRequest request) {
        return tradingApi.buildSwapTransaction(request);
    }

    /**
     * Build Swap Transaction Build the on-chain swap calldata for a previously quoted route. The
     * request is matched against the cached quote by &#x60;quoteId&#x60; (TTL ~30s); if the entry
     * has expired, &#x60;QUOTE_EXPIRED&#x60; (40401) is returned, and if the request parameters
     * disagree with the cached quote, &#x60;SWAP_QUOTE_MISMATCH&#x60; (40462) is returned.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;56\&quot;&#x3D;BSC,
     *     \&quot;1\&quot;&#x3D;Ethereum, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param amount Sell-token amount in the token&#39;s smallest unit (positive integer string, no
     *     decimals). (required)
     * @param fromTokenAddress Sell-token contract address. (required)
     * @param toTokenAddress Buy-token contract address. (required)
     * @param slippagePercent Maximum slippage as a percentage. EVM range 0–100; Solana range 0 to
     *     less than 100. \&quot;0.5\&quot; means 0.5%. (required)
     * @param userWalletAddress User wallet address (transaction sender). (required)
     * @param quoteId quoteId returned from &#x60;/quote&#x60; for the route to execute. TTL ~30s;
     *     expired entries return &#x60;QUOTE_EXPIRED&#x60; (40401). (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param approveTransaction When \&quot;true\&quot;, &#x60;signatureData&#x60; includes the
     *     spender address and approve calldata so the client can submit it before the swap.
     *     Defaults to false. (optional)
     * @param approveAmount Override approve amount (smallest unit, positive integer string).
     *     Defaults to the swap amount. (optional)
     * @param gasLimit Gas limit override (positive integer string). EVM only. (optional)
     * @param gasLevel Gas price tier. Defaults to \&quot;average\&quot;. (optional)
     * @param priceImpactProtectionPercent Maximum allowed price impact percentage (0–100). Defaults
     *     to 90; set to 100 to disable. (optional)
     * @param autoSlippage When \&quot;true\&quot;, slippage is auto-derived from market data and
     *     overrides &#x60;slippagePercent&#x60;. Defaults to false. (optional)
     * @param maxAutoSlippagePercent Cap on auto-derived slippage (only applies when
     *     &#x60;autoSlippage&#x3D;true&#x60;). (optional)
     * @param computeUnitLimit Solana only — maximum compute units the transaction may consume
     *     (analogous to EVM gasLimit). Applies only when &#x60;binanceChainId&#x3D;CT_501&#x60;.
     *     (optional)
     * @param computeUnitPrice Solana only — priority fee per compute unit (micro-lamports),
     *     analogous to EVM gasPrice. When omitted, the platform computes a value dynamically.
     *     Applies only when &#x60;binanceChainId&#x3D;CT_501&#x60;. (optional)
     * @param tips Solana only — Jito tips in SOL for MEV protection. Valid range [0.000000001, 2]
     *     (minimum 1 lamport). When specified, it is recommended to set
     *     &#x60;computeUnitPrice&#x3D;0&#x60;. Applies only when
     *     &#x60;binanceChainId&#x3D;CT_501&#x60;. (optional)
     * @return ApiResponse&lt;BuildSwapTransactionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Swap transaction data returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/trading-api#build-swap-transaction">Build
     *     Swap Transaction Documentation</a>
     */
    public ApiResponse<BuildSwapTransactionResponse> buildSwapTransaction(
            String binanceChainId,
            String amount,
            String fromTokenAddress,
            String toTokenAddress,
            String slippagePercent,
            String userWalletAddress,
            String quoteId,
            Long recvWindow,
            String nonce,
            ApproveTransaction approveTransaction,
            String approveAmount,
            String gasLimit,
            GasLevel gasLevel,
            String priceImpactProtectionPercent,
            AutoSlippage autoSlippage,
            String maxAutoSlippagePercent,
            String computeUnitLimit,
            String computeUnitPrice,
            String tips)
            throws ApiException {
        return tradingApi.buildSwapTransaction(
                binanceChainId,
                amount,
                fromTokenAddress,
                toTokenAddress,
                slippagePercent,
                userWalletAddress,
                quoteId,
                recvWindow,
                nonce,
                approveTransaction,
                approveAmount,
                gasLimit,
                gasLevel,
                priceImpactProtectionPercent,
                autoSlippage,
                maxAutoSlippagePercent,
                computeUnitLimit,
                computeUnitPrice,
                tips);
    }

    public ApiResponse<GetAggregatedQuoteResponse> getAggregatedQuote(
            TradingApi.GetAggregatedQuoteRequest request) {
        return tradingApi.getAggregatedQuote(request);
    }

    /**
     * Get Aggregated Quote Query multiple DEX vendors in parallel and return the priced routes
     * sorted by &#x60;toTokenAmount&#x60; (descending). Each route carries an independent
     * &#x60;quoteId&#x60; (TTL ~30s) that the swap endpoint consumes to construct calldata for the
     * chosen route.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;56\&quot;&#x3D;BSC,
     *     \&quot;1\&quot;&#x3D;Ethereum, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param amount Sell-token amount in the token&#39;s smallest unit (positive integer string, no
     *     decimals). Example \&quot;1000000\&quot; &#x3D; 1 USDT (decimals&#x3D;6). (required)
     * @param fromTokenAddress Sell-token contract address. EVM chains require 0x + 40 hex chars;
     *     non-EVM chains use the chain&#39;s native address format. (required)
     * @param toTokenAddress Buy-token contract address. Must differ from
     *     &#x60;fromTokenAddress&#x60;. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetAggregatedQuoteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Quote routes returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/trading-api#get-aggregated-quote">Get
     *     Aggregated Quote Documentation</a>
     */
    public ApiResponse<GetAggregatedQuoteResponse> getAggregatedQuote(
            String binanceChainId,
            String amount,
            String fromTokenAddress,
            String toTokenAddress,
            Long recvWindow,
            String nonce)
            throws ApiException {
        return tradingApi.getAggregatedQuote(
                binanceChainId, amount, fromTokenAddress, toTokenAddress, recvWindow, nonce);
    }

    public ApiResponse<GetAggregatorSupportedChainsResponse> getAggregatorSupportedChains(
            TradingApi.GetAggregatorSupportedChainsRequest request) {
        return tradingApi.getAggregatorSupportedChains(request);
    }

    /**
     * Get Aggregator Supported Chains Return blockchain networks supported by the DEX aggregator.
     * The supported list is dynamically configured server-side and may change over time. Pass
     * &#x60;binanceChainId&#x60; to filter to a single chain; omit it to get the full list.
     *
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param binanceChainId Optional chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). When set, only that chain
     *     is returned. (optional)
     * @return ApiResponse&lt;GetAggregatorSupportedChainsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Supported chains returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/trading-api#get-aggregator-supported-chains">Get
     *     Aggregator Supported Chains Documentation</a>
     */
    public ApiResponse<GetAggregatorSupportedChainsResponse> getAggregatorSupportedChains(
            Long recvWindow, String nonce, String binanceChainId) throws ApiException {
        return tradingApi.getAggregatorSupportedChains(recvWindow, nonce, binanceChainId);
    }

    public ApiResponse<GetErc20ApproveTransactionResponse> getErc20ApproveTransaction(
            TradingApi.GetErc20ApproveTransactionRequest request) {
        return tradingApi.getErc20ApproveTransaction(request);
    }

    /**
     * Get ERC-20 Approve Transaction Build the on-chain transaction data needed to approve the DEX
     * router to spend a user&#39;s ERC-20 token before a swap. Calldata is encoded per the ERC-20
     * ABI standard (&#x60;approve()&#x60; selector + spender + amount).
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC). (required)
     * @param tokenContractAddress ERC-20 token contract address to approve (0x + 40 hex chars).
     *     (required)
     * @param approveAmount Approval amount in the token&#39;s smallest unit (positive integer
     *     string). Example \&quot;1000000\&quot; &#x3D; 1 USDT (decimals&#x3D;6). (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetErc20ApproveTransactionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Approve transaction data returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/trading-api#get-erc20-approve-transaction">Get
     *     ERC-20 Approve Transaction Documentation</a>
     */
    public ApiResponse<GetErc20ApproveTransactionResponse> getErc20ApproveTransaction(
            String binanceChainId,
            String tokenContractAddress,
            String approveAmount,
            Long recvWindow,
            String nonce)
            throws ApiException {
        return tradingApi.getErc20ApproveTransaction(
                binanceChainId, tokenContractAddress, approveAmount, recvWindow, nonce);
    }

    public ApiResponse<GetTransactionStatusResponse> getTransactionStatus(
            TradingApi.GetTransactionStatusRequest request) {
        return tradingApi.getTransactionStatus(request);
    }

    /**
     * Get Transaction Status Look up the on-chain status of a DEX swap by
     * &#x60;binanceChainId&#x60; + &#x60;txHash&#x60;. Response semantics: - Transaction not found:
     * &#x60;data&#x60; is &#x60;null&#x60; (not HTTP 404). - Transaction failed:
     * &#x60;status&#x3D;failed&#x60; with &#x60;errorMsg&#x60;; aggregator business fields
     * (&#x60;txType&#x60;, &#x60;dexRouter&#x60;, &#x60;fromTokenDetails&#x60;,
     * &#x60;toTokenDetails&#x60;) are &#x60;null&#x60;. - Transaction succeeded:
     * &#x60;status&#x3D;success&#x60; with full token details when an aggregator event is present.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;56\&quot;&#x3D;BSC,
     *     \&quot;1\&quot;&#x3D;Ethereum, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param txHash On-chain transaction hash. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetTransactionStatusResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Transaction details. &#x60;data&#x60; is null when no record is found. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/trading-api#get-transaction-status">Get
     *     Transaction Status Documentation</a>
     */
    public ApiResponse<GetTransactionStatusResponse> getTransactionStatus(
            String binanceChainId, String txHash, Long recvWindow, String nonce)
            throws ApiException {
        return tradingApi.getTransactionStatus(binanceChainId, txHash, recvWindow, nonce);
    }

    /**
     * Broadcast Transactions Broadcast a client-signed transaction to the chain via the Binance
     * Web3 API relay. Returns the transaction hash and an internal &#x60;orderId&#x60; you can use
     * to track on-chain status via the post-transaction service. Optional MEV protection (EVM
     * chains only) routes the transaction through a private mempool to mitigate front-running and
     * sandwich attacks.
     *
     * @param broadcastTransactionsRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;BroadcastTransactionsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Transaction submitted successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/transaction-api#broadcast-transactions">Broadcast
     *     Transactions Documentation</a>
     */
    public ApiResponse<BroadcastTransactionsResponse> broadcastTransactions(
            BroadcastTransactionsRequest broadcastTransactionsRequest,
            Long recvWindow,
            String nonce)
            throws ApiException {
        return transactionApi.broadcastTransactions(
                broadcastTransactionsRequest, recvWindow, nonce);
    }

    public ApiResponse<GetBroadcastOrdersResponse> getBroadcastOrders(
            TransactionApi.GetBroadcastOrdersRequest request) {
        return transactionApi.getBroadcastOrders(request);
    }

    /**
     * Get Broadcast Orders Look up broadcast orders previously submitted via
     * &#x60;/pre-transaction/broadcast-transaction&#x60;. Filter by &#x60;txStatus&#x60; or
     * &#x60;orderId&#x60;, paginate with &#x60;cursor&#x60;.
     *
     * @param address Sender wallet address whose orders to list. (required)
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param txStatus Optional filter on transaction status (server-defined string, e.g.
     *     \&quot;pending\&quot;, \&quot;success\&quot;, \&quot;fail\&quot;). (optional)
     * @param orderId Optional filter to fetch a single order by its internal order ID. (optional)
     * @param cursor Pagination cursor returned by the previous page. Omit on the first request.
     *     (optional)
     * @param limit Page size. Defaults to 20. (optional)
     * @return ApiResponse&lt;GetBroadcastOrdersResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Orders returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/transaction-api#get-broadcast-orders">Get
     *     Broadcast Orders Documentation</a>
     */
    public ApiResponse<GetBroadcastOrdersResponse> getBroadcastOrders(
            String address,
            String binanceChainId,
            Long recvWindow,
            String nonce,
            String txStatus,
            String orderId,
            String cursor,
            Integer limit)
            throws ApiException {
        return transactionApi.getBroadcastOrders(
                address, binanceChainId, recvWindow, nonce, txStatus, orderId, cursor, limit);
    }

    /**
     * Get Gas Limit Estimate the gas limit (or compute-unit ceiling on Solana) for an unsigned
     * transaction. Provide either &#x60;evmTx&#x60; for EVM chains or &#x60;solTx&#x60; for Solana,
     * matching the value of &#x60;binanceChainId&#x60;.
     *
     * @param getGasLimitRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetGasLimitResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Estimated gas limit. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/transaction-api#get-gas-limit">Get
     *     Gas Limit Documentation</a>
     */
    public ApiResponse<GetGasLimitResponse> getGasLimit(
            GetGasLimitRequest getGasLimitRequest, Long recvWindow, String nonce)
            throws ApiException {
        return transactionApi.getGasLimit(getGasLimitRequest, recvWindow, nonce);
    }

    public ApiResponse<GetGasPriceResponse> getGasPrice(TransactionApi.GetGasPriceRequest request) {
        return transactionApi.getGasPrice(request);
    }

    /**
     * Get Gas Price Query the current network gas price for the specified chain. The response shape
     * varies by chain family: - EVM chains return both &#x60;evmLegacyGasPrice&#x60; (legacy
     * gasPrice) and &#x60;eip1559GasPrice&#x60; (baseFee + priority/max fees) when EIP-1559 is
     * supported. - Solana returns &#x60;solanaGasPrice&#x60; (compute-unit prices and Jito tips).
     * Fields not applicable to the chain family are returned as &#x60;null&#x60;.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetGasPriceResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Current gas price for the specified chain. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/transaction-api#get-gas-price">Get
     *     Gas Price Documentation</a>
     */
    public ApiResponse<GetGasPriceResponse> getGasPrice(
            String binanceChainId, Long recvWindow, String nonce) throws ApiException {
        return transactionApi.getGasPrice(binanceChainId, recvWindow, nonce);
    }

    public ApiResponse<GetTransactionSupportedChainsResponse> getTransactionSupportedChains(
            TransactionApi.GetTransactionSupportedChainsRequest request) {
        return transactionApi.getTransactionSupportedChains(request);
    }

    /**
     * Get Transaction Supported Chains Return the blockchain networks supported by the Transaction
     * service for gas estimation, simulation, and broadcasting. The list is dynamically configured
     * server-side and may change over time.
     *
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetTransactionSupportedChainsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Supported chains returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/transaction-api#get-transaction-supported-chains">Get
     *     Transaction Supported Chains Documentation</a>
     */
    public ApiResponse<GetTransactionSupportedChainsResponse> getTransactionSupportedChains(
            Long recvWindow, String nonce) throws ApiException {
        return transactionApi.getTransactionSupportedChains(recvWindow, nonce);
    }

    /**
     * Simulate Transactions Simulate transaction execution off-chain to predict its outcome before
     * broadcasting. The response includes the predicted execution status, balance changes per
     * affected account/token, and ERC-20 allowance changes (EVM chains). Provide either
     * &#x60;evmTx&#x60; (EVM chains) or &#x60;solTx&#x60; (Solana) matching
     * &#x60;binanceChainId&#x60;.
     *
     * @param simulateTransactionsRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;SimulateTransactionsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Simulation result. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/transaction-api#simulate-transactions">Simulate
     *     Transactions Documentation</a>
     */
    public ApiResponse<SimulateTransactionsResponse> simulateTransactions(
            SimulateTransactionsRequest simulateTransactionsRequest, Long recvWindow, String nonce)
            throws ApiException {
        return transactionApi.simulateTransactions(simulateTransactionsRequest, recvWindow, nonce);
    }

    public ApiResponse<GetAllTokenBalancesByAddressResponse> getAllTokenBalancesByAddress(
            WalletApi.GetAllTokenBalancesByAddressRequest request) {
        return walletApi.getAllTokenBalancesByAddress(request);
    }

    /**
     * Get All Token Balances by Address Return all token balances held by an address across one or
     * more chains, with pagination support. Set &#x60;excludeRiskToken&#x3D;true&#x60; to filter
     * out airdrop-risk and honeypot tokens (honeypot detection currently applies only to ETH / BSC
     * / SOL / BASE).
     *
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param address Wallet address to query. (optional)
     * @param chains Comma-separated list of chain identifiers. (optional)
     * @param excludeRiskToken Whether to exclude risk-flagged tokens. (optional)
     * @param page Page number. Defaults to 1. (optional)
     * @param pageSize Page size. Range 1–100. Defaults to 20. (optional)
     * @return ApiResponse&lt;GetAllTokenBalancesByAddressResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Token balances returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/wallet-api#get-all-token-balances-by-address">Get
     *     All Token Balances by Address Documentation</a>
     */
    public ApiResponse<GetAllTokenBalancesByAddressResponse> getAllTokenBalancesByAddress(
            Long recvWindow,
            String nonce,
            String address,
            String chains,
            Boolean excludeRiskToken,
            Long page,
            Integer pageSize)
            throws ApiException {
        return walletApi.getAllTokenBalancesByAddress(
                recvWindow, nonce, address, chains, excludeRiskToken, page, pageSize);
    }

    /**
     * Get Token Balances by Address Return token balances for a specific list of (chain, contract)
     * pairs. Up to 20 entries per request. Set &#x60;excludeRiskToken&#x3D;\&quot;0\&quot;&#x60; to
     * exclude risk-flagged tokens (default), or &#x60;\&quot;1\&quot;&#x60; to include them.
     *
     * @param getTokenBalancesByAddressRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetTokenBalancesByAddressResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Token balances returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 201 </td><td> Created. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/wallet-api#get-token-balances-by-address">Get
     *     Token Balances by Address Documentation</a>
     */
    public ApiResponse<GetTokenBalancesByAddressResponse> getTokenBalancesByAddress(
            GetTokenBalancesByAddressRequest getTokenBalancesByAddressRequest,
            Long recvWindow,
            String nonce)
            throws ApiException {
        return walletApi.getTokenBalancesByAddress(
                getTokenBalancesByAddressRequest, recvWindow, nonce);
    }

    public ApiResponse<GetTransactionDetailByHashResponse> getTransactionDetailByHash(
            WalletApi.GetTransactionDetailByHashRequest request) {
        return walletApi.getTransactionDetailByHash(request);
    }

    /**
     * Get Transaction Detail by Hash Look up the full on-chain transaction detail by
     * &#x60;binanceChainId&#x60; + &#x60;txHash&#x60;. Returns one or more entries describing
     * transaction inputs, outputs, internal calls, and token transfers.
     *
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). (optional)
     * @param txHash On-chain transaction hash. (optional)
     * @param itype Transaction-type filter (UTXO chains). Reserved — currently has no effect.
     *     Values: \&quot;0\&quot;&#x3D;outer native-token, \&quot;1\&quot;&#x3D;internal contract
     *     native-token, \&quot;2\&quot;&#x3D;token transfer. (optional)
     * @return ApiResponse&lt;GetTransactionDetailByHashResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Transaction details returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/wallet-api#get-transaction-detail-by-hash">Get
     *     Transaction Detail by Hash Documentation</a>
     */
    public ApiResponse<GetTransactionDetailByHashResponse> getTransactionDetailByHash(
            Long recvWindow, String nonce, String binanceChainId, String txHash, String itype)
            throws ApiException {
        return walletApi.getTransactionDetailByHash(
                recvWindow, nonce, binanceChainId, txHash, itype);
    }

    public ApiResponse<GetTransactionsByAddressResponse> getTransactionsByAddress(
            WalletApi.GetTransactionsByAddressRequest request) {
        return walletApi.getTransactionsByAddress(request);
    }

    /**
     * Get Transactions by Address Return on-chain transaction history for a wallet address across
     * one or more chains. Results are limited to the most recent 6 months and sorted by time
     * (descending). Supports cursor pagination, time-range filtering, and token-contract filtering.
     *
     * @param address Wallet address to query. (required)
     * @param chains Comma-separated list of chain identifiers. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param tokenContractAddress Optional token contract address filter. (optional)
     * @param begin Optional start timestamp (Unix milliseconds, inclusive). (optional)
     * @param end Optional end timestamp (Unix milliseconds, inclusive). (optional)
     * @param cursor Pagination cursor returned by the previous page. (optional)
     * @param limit Page size. Range 1–100. Defaults to 20. (optional)
     * @return ApiResponse&lt;GetTransactionsByAddressResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Transaction history returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/wallet-api#get-transactions-by-address">Get
     *     Transactions by Address Documentation</a>
     */
    public ApiResponse<GetTransactionsByAddressResponse> getTransactionsByAddress(
            String address,
            String chains,
            Long recvWindow,
            String nonce,
            String tokenContractAddress,
            Long begin,
            Long end,
            String cursor,
            Integer limit)
            throws ApiException {
        return walletApi.getTransactionsByAddress(
                address,
                chains,
                recvWindow,
                nonce,
                tokenContractAddress,
                begin,
                end,
                cursor,
                limit);
    }

    public ApiResponse<GetWalletSupportedChainsResponse> getWalletSupportedChains(
            WalletApi.GetWalletSupportedChainsRequest request) {
        return walletApi.getWalletSupportedChains(request);
    }

    /**
     * Get Wallet Supported Chains Return blockchain networks for which the Wallet service can
     * return balances. The supported list is dynamically configured server-side and may change over
     * time. Pass &#x60;binanceChainId&#x60; to filter to a single chain; omit to get the full list.
     *
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param binanceChainId Optional chain identifier. When set, only that chain is returned.
     *     (optional)
     * @return ApiResponse&lt;GetWalletSupportedChainsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Supported chains returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/wallet-api#get-wallet-supported-chains">Get
     *     Wallet Supported Chains Documentation</a>
     */
    public ApiResponse<GetWalletSupportedChainsResponse> getWalletSupportedChains(
            Long recvWindow, String nonce, String binanceChainId) throws ApiException {
        return walletApi.getWalletSupportedChains(recvWindow, nonce, binanceChainId);
    }
}
