package com.binance.connector.client.web3_wallet.rest.api;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.web3.common.ApiClient;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.model.ApproveTransaction;
import com.binance.connector.client.web3_wallet.rest.model.AutoSlippage;
import com.binance.connector.client.web3_wallet.rest.model.Bar;
import com.binance.connector.client.web3_wallet.rest.model.BinanceChainId;
import com.binance.connector.client.web3_wallet.rest.model.BroadcastTransactionsRequest;
import com.binance.connector.client.web3_wallet.rest.model.BroadcastTransactionsResponse;
import com.binance.connector.client.web3_wallet.rest.model.BuildSolanaSwapInstructionsResponse;
import com.binance.connector.client.web3_wallet.rest.model.BuildSwapTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.FeeSource;
import com.binance.connector.client.web3_wallet.rest.model.GasLevel;
import com.binance.connector.client.web3_wallet.rest.model.GetAddressPnLForSpecificTokenResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetAddressPortfolioOverviewResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetAddressRecentPnLResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetAggregatedQuoteResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetAggregatorSupportedChainsResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetAllTokenBalancesByAddressResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetBroadcastOrdersResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetCandlesResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetDexTradeHistoryResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetErc20ApproveTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetGasLimitRequest;
import com.binance.connector.client.web3_wallet.rest.model.GetGasLimitResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetGasPriceResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetHoldersRankingResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetHotTokenListResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetLeaderboardResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetPortfolioSupportedChainsResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetRfqOrderStatusResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetRwaTokenIssuancePlatformsResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetRwaTokenListResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetRwaTokenPriceResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetRwaUnderlyingInfoResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetRwaUnderlyingMarketDataResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetSupportedChainsResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenAdvancedInfoResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenBalancesByAddressRequest;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenBalancesByAddressResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenBasicInfoResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenDevInfoResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenPriceResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenTradesResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenTradingInfoResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTopLiquidityPoolsResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTopTradersResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTrackedTradesResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTransactionDetailByHashResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTransactionStatusResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTransactionSupportedChainsResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetTransactionsByAddressResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetWalletSupportedChainsResponse;
import com.binance.connector.client.web3_wallet.rest.model.OrderType;
import com.binance.connector.client.web3_wallet.rest.model.PlatformId;
import com.binance.connector.client.web3_wallet.rest.model.QuoteAndBuildSwapTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.RankBy;
import com.binance.connector.client.web3_wallet.rest.model.RankingTimeFrame;
import com.binance.connector.client.web3_wallet.rest.model.SearchRwaTokenResponse;
import com.binance.connector.client.web3_wallet.rest.model.SearchTokenResponse;
import com.binance.connector.client.web3_wallet.rest.model.SimulateTransactionsRequest;
import com.binance.connector.client.web3_wallet.rest.model.SimulateTransactionsResponse;
import com.binance.connector.client.web3_wallet.rest.model.SortBy;
import com.binance.connector.client.web3_wallet.rest.model.SubmitRfqOrderRequest;
import com.binance.connector.client.web3_wallet.rest.model.SubmitRfqOrderResponse;
import com.binance.connector.client.web3_wallet.rest.model.TagFilter;
import com.binance.connector.client.web3_wallet.rest.model.TimeFrame;
import com.binance.connector.client.web3_wallet.rest.model.TrackerType;
import com.binance.connector.client.web3_wallet.rest.model.Vendor;
import com.binance.connector.client.web3_wallet.rest.model.WalletType;

public class Web3WalletRestApi {

    private final AddressPortfolioApi addressPortfolioApi;
    private final GeneralDataApi generalDataApi;
    private final RwaDataApi rwaDataApi;
    private final TradingApi tradingApi;
    private final TransactionApi transactionApi;
    private final WalletApi walletApi;

    public Web3WalletRestApi(ClientConfiguration configuration) {
        this(Web3WalletRestApiUtil.getDefaultClient(configuration));
    }

    public Web3WalletRestApi(ApiClient apiClient) {
        this.addressPortfolioApi = new AddressPortfolioApi(apiClient);
        this.generalDataApi = new GeneralDataApi(apiClient);
        this.rwaDataApi = new RwaDataApi(apiClient);
        this.tradingApi = new TradingApi(apiClient);
        this.transactionApi = new TransactionApi(apiClient);
        this.walletApi = new WalletApi(apiClient);
    }

    public ApiResponse<GetAddressPnLForSpecificTokenResponse> getAddressPnLForSpecificToken(
            AddressPortfolioApi.GetAddressPnLForSpecificTokenRequest request) {
        return addressPortfolioApi.getAddressPnLForSpecificToken(request);
    }

    /**
     * Get Address PnL for Specific Token Return the latest realized PnL detail for a specific token
     * held by an address, including buy/sell stats, current balance, and holding duration.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param walletAddress Wallet address to query. EVM chains accept lowercase 42-character hex
     *     addresses; Solana accepts base58 addresses (case-sensitive). (required)
     * @param tokenContractAddress Token contract address. EVM chains accept lowercase 42-character
     *     hex addresses; Solana accepts base58 addresses (case-sensitive). (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetAddressPnLForSpecificTokenResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Token latest PnL returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/address-portfolio#get-address-pn-lfor-specific-token">Get
     *     Address PnL for Specific Token Documentation</a>
     */
    public ApiResponse<GetAddressPnLForSpecificTokenResponse> getAddressPnLForSpecificToken(
            String binanceChainId,
            String walletAddress,
            String tokenContractAddress,
            Long recvWindow,
            String nonce)
            throws ApiException {
        return addressPortfolioApi.getAddressPnLForSpecificToken(
                binanceChainId, walletAddress, tokenContractAddress, recvWindow, nonce);
    }

    public ApiResponse<GetAddressPortfolioOverviewResponse> getAddressPortfolioOverview(
            AddressPortfolioApi.GetAddressPortfolioOverviewRequest request) {
        return addressPortfolioApi.getAddressPortfolioOverview(request);
    }

    /**
     * Get Address Portfolio Overview Return trading performance overview for an address within the
     * selected time frame, including realized PnL, daily PnL breakdown, win rate, and top 3
     * profitable tokens.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param walletAddress Wallet address to query. EVM chains accept lowercase 42-character hex
     *     addresses; Solana accepts base58 addresses (case-sensitive). (required)
     * @param timeFrame Statistics time range. 1&#x3D;1D, 2&#x3D;7D, 3&#x3D;1M, 4&#x3D;3M. Note:
     *     these values differ from the leaderboard/list endpoint (where 1&#x3D;7D, 2&#x3D;1M,
     *     3&#x3D;3M); do not reuse enum knowledge across endpoints. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetAddressPortfolioOverviewResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Portfolio overview returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/address-portfolio#get-address-portfolio-overview">Get
     *     Address Portfolio Overview Documentation</a>
     */
    public ApiResponse<GetAddressPortfolioOverviewResponse> getAddressPortfolioOverview(
            String binanceChainId,
            String walletAddress,
            TimeFrame timeFrame,
            Long recvWindow,
            String nonce)
            throws ApiException {
        return addressPortfolioApi.getAddressPortfolioOverview(
                binanceChainId, walletAddress, timeFrame, recvWindow, nonce);
    }

    public ApiResponse<GetAddressRecentPnLResponse> getAddressRecentPnL(
            AddressPortfolioApi.GetAddressRecentPnLRequest request) {
        return addressPortfolioApi.getAddressRecentPnL(request);
    }

    /**
     * Get Address Recent PnL Return recent realized PnL list for an address.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param walletAddress Wallet address to query. EVM chains accept lowercase 42-character hex
     *     addresses; Solana accepts base58 addresses (case-sensitive). (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param cursor Pagination cursor. Omit or pass empty string for the first page; pass the
     *     cursor from the previous response to get the next page. (optional)
     * @param limit Number of records per page. Default 20, max 100. (optional)
     * @return ApiResponse&lt;GetAddressRecentPnLResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Recent PnL list returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/address-portfolio#get-address-recent-pn-l">Get
     *     Address Recent PnL Documentation</a>
     */
    public ApiResponse<GetAddressRecentPnLResponse> getAddressRecentPnL(
            String binanceChainId,
            String walletAddress,
            Long recvWindow,
            String nonce,
            String cursor,
            String limit)
            throws ApiException {
        return addressPortfolioApi.getAddressRecentPnL(
                binanceChainId, walletAddress, recvWindow, nonce, cursor, limit);
    }

    public ApiResponse<GetDexTradeHistoryResponse> getDexTradeHistory(
            AddressPortfolioApi.GetDexTradeHistoryRequest request) {
        return addressPortfolioApi.getDexTradeHistory(request);
    }

    /**
     * Get DEX Trade History Return swap trade history for a specific address. Supports filtering by
     * time range, token, and trade type.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param walletAddress Wallet address to query. EVM chains accept lowercase 42-character hex
     *     addresses; Solana accepts base58 addresses (case-sensitive). (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param begin Start timestamp (Unix milliseconds, inclusive). If both begin and end are
     *     omitted, no time filter is applied. (optional)
     * @param end End timestamp (Unix milliseconds, inclusive). If both begin and end are omitted,
     *     no time filter is applied. (optional)
     * @param tokenContractAddress Filter by token contract address. Returns all tokens when
     *     omitted. (optional)
     * @param type Trade type filter. 1&#x3D;Buy, 2&#x3D;Sell. Omit to return all types. (optional)
     * @param cursor Pagination cursor. Omit or pass empty string for the first page. (optional)
     * @param limit Number of records per page. Default 20, max 100. (optional)
     * @return ApiResponse&lt;GetDexTradeHistoryResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> DEX history returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/address-portfolio#get-dex-trade-history">Get
     *     DEX Trade History Documentation</a>
     */
    public ApiResponse<GetDexTradeHistoryResponse> getDexTradeHistory(
            String binanceChainId,
            String walletAddress,
            Long recvWindow,
            String nonce,
            String begin,
            String end,
            String tokenContractAddress,
            OrderType type,
            String cursor,
            String limit)
            throws ApiException {
        return addressPortfolioApi.getDexTradeHistory(
                binanceChainId,
                walletAddress,
                recvWindow,
                nonce,
                begin,
                end,
                tokenContractAddress,
                type,
                cursor,
                limit);
    }

    public ApiResponse<GetLeaderboardResponse> getLeaderboard(
            AddressPortfolioApi.GetLeaderboardRequest request) {
        return addressPortfolioApi.getLeaderboard(request);
    }

    /**
     * Get Leaderboard Return a leaderboard of top-performing wallets, with sorting and filtering by
     * PnL, win rate, transaction count, and volume.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). Single chain only.
     *     (required)
     * @param timeFrame Statistics time range. 1&#x3D;7D, 2&#x3D;1M, 3&#x3D;3M. Note: these values
     *     differ from the portfolio/overview endpoint (where 1&#x3D;1D, 2&#x3D;7D, 3&#x3D;1M,
     *     4&#x3D;3M); do not reuse enum knowledge across endpoints. (required)
     * @param sortBy Sort field. 1&#x3D;Realized PnL (USD), 2&#x3D;Win Rate, 3&#x3D;Transaction
     *     count, 4&#x3D;Volume (USD), 5&#x3D;Realized PnL %. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param walletType Wallet type filter, single selection only. 1&#x3D;Smart Money, 2&#x3D;KOL,
     *     3&#x3D;Hot List. Returns all types when omitted. (optional)
     * @param minRealizedPnlUsd Minimum realized PnL filter, denominated in USD. (optional)
     * @param maxRealizedPnlUsd Maximum realized PnL filter, denominated in USD. (optional)
     * @param minWinRatePercent Minimum win rate filter, without percent sign. \&quot;50\&quot;
     *     means ≥50%. (optional)
     * @param maxWinRatePercent Maximum win rate filter, without percent sign. \&quot;90\&quot;
     *     means ≤90%. (optional)
     * @param minTxs Minimum transaction count filter. (optional)
     * @param maxTxs Maximum transaction count filter. (optional)
     * @param minTxVolume Minimum total transaction volume filter, denominated in USD. (optional)
     * @param maxTxVolume Maximum total transaction volume filter, denominated in USD. (optional)
     * @param cursor Pagination cursor. Omit or pass empty string for the first page. (optional)
     * @param limit Number of records per page. Default 50, max 50. (optional)
     * @return ApiResponse&lt;GetLeaderboardResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Leaderboard list returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/address-portfolio#get-leaderboard">Get
     *     Leaderboard Documentation</a>
     */
    public ApiResponse<GetLeaderboardResponse> getLeaderboard(
            String binanceChainId,
            TimeFrame timeFrame,
            SortBy sortBy,
            Long recvWindow,
            String nonce,
            WalletType walletType,
            String minRealizedPnlUsd,
            String maxRealizedPnlUsd,
            String minWinRatePercent,
            String maxWinRatePercent,
            String minTxs,
            String maxTxs,
            String minTxVolume,
            String maxTxVolume,
            String cursor,
            String limit)
            throws ApiException {
        return addressPortfolioApi.getLeaderboard(
                binanceChainId,
                timeFrame,
                sortBy,
                recvWindow,
                nonce,
                walletType,
                minRealizedPnlUsd,
                maxRealizedPnlUsd,
                minWinRatePercent,
                maxWinRatePercent,
                minTxs,
                maxTxs,
                minTxVolume,
                maxTxVolume,
                cursor,
                limit);
    }

    public ApiResponse<GetPortfolioSupportedChainsResponse> getPortfolioSupportedChains(
            AddressPortfolioApi.GetPortfolioSupportedChainsRequest request) {
        return addressPortfolioApi.getPortfolioSupportedChains(request);
    }

    /**
     * Get Portfolio Supported Chains Return the list of blockchains supported by address portfolio
     * analysis.
     *
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetPortfolioSupportedChainsResponse&gt;
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
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/address-portfolio#get-portfolio-supported-chains">Get
     *     Portfolio Supported Chains Documentation</a>
     */
    public ApiResponse<GetPortfolioSupportedChainsResponse> getPortfolioSupportedChains(
            Long recvWindow, String nonce) throws ApiException {
        return addressPortfolioApi.getPortfolioSupportedChains(recvWindow, nonce);
    }

    public ApiResponse<GetTrackedTradesResponse> getTrackedTrades(
            AddressPortfolioApi.GetTrackedTradesRequest request) {
        return addressPortfolioApi.getTrackedTrades(request);
    }

    /**
     * Get Tracked Trades Return the latest swap trades from tracked addresses (smart money, KOL, or
     * custom address list).
     *
     * @param trackerType Tracker type. 1&#x3D;Smart Money, 2&#x3D;KOL, 3&#x3D;Custom address list
     *     (walletAddress required). (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param walletAddress Required when trackerType&#x3D;3. One or more wallet addresses,
     *     comma-separated, up to 20. EVM chains accept lowercase 42-character hex addresses; Solana
     *     accepts base58 addresses (case-sensitive). (optional)
     * @param tradeType Trade type filter. 0&#x3D;All (default), 1&#x3D;Buy, 2&#x3D;Sell, 3&#x3D;Add
     *     position, 4&#x3D;Reduce position, 5&#x3D;Open position, 6&#x3D;Close position,
     *     7&#x3D;Transfer in, 8&#x3D;Transfer out. Multiple values comma-separated. (optional)
     * @param binanceChainId Filter by chain. Returns all chains when omitted. (optional)
     * @param minVolume Minimum trade volume filter, denominated in USD. (optional)
     * @param maxVolume Maximum trade volume filter, denominated in USD. (optional)
     * @param minMarketCap Minimum market cap filter, denominated in USD. (optional)
     * @param maxMarketCap Maximum market cap filter, denominated in USD. (optional)
     * @param isHideRiskToken Whether to hide risk tokens. true&#x3D;hide risk tokens (default),
     *     false&#x3D;show all tokens including risk tokens. (optional)
     * @param limit Maximum number of trades to return. Effective only for trackerType&#x3D;3
     *     (custom address list); trackerType&#x3D;1/2 ignore this and use the downstream public
     *     query fixed cap. Omit to use the downstream default. (optional)
     * @return ApiResponse&lt;GetTrackedTradesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Address tracker trades returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/address-portfolio#get-tracked-trades">Get
     *     Tracked Trades Documentation</a>
     */
    public ApiResponse<GetTrackedTradesResponse> getTrackedTrades(
            TrackerType trackerType,
            Long recvWindow,
            String nonce,
            String walletAddress,
            String tradeType,
            String binanceChainId,
            String minVolume,
            String maxVolume,
            String minMarketCap,
            String maxMarketCap,
            Boolean isHideRiskToken,
            Integer limit)
            throws ApiException {
        return addressPortfolioApi.getTrackedTrades(
                trackerType,
                recvWindow,
                nonce,
                walletAddress,
                tradeType,
                binanceChainId,
                minVolume,
                maxVolume,
                minMarketCap,
                maxMarketCap,
                isHideRiskToken,
                limit);
    }

    public ApiResponse<GetCandlesResponse> getCandles(GeneralDataApi.GetCandlesRequest request) {
        return generalDataApi.getCandles(request);
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
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/general-data#get-candles">Get
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
        return generalDataApi.getCandles(
                binanceChainId, tokenContractAddress, recvWindow, nonce, bar, after, before, limit);
    }

    public ApiResponse<GetHoldersRankingResponse> getHoldersRanking(
            GeneralDataApi.GetHoldersRankingRequest request) {
        return generalDataApi.getHoldersRanking(request);
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
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/general-data#get-holders-ranking">Get
     *     Holders Ranking Documentation</a>
     */
    public ApiResponse<GetHoldersRankingResponse> getHoldersRanking(
            String binanceChainId,
            String tokenContractAddress,
            Long recvWindow,
            String nonce,
            TagFilter tagFilter)
            throws ApiException {
        return generalDataApi.getHoldersRanking(
                binanceChainId, tokenContractAddress, recvWindow, nonce, tagFilter);
    }

    public ApiResponse<GetHotTokenListResponse> getHotTokenList(
            GeneralDataApi.GetHotTokenListRequest request) {
        return generalDataApi.getHotTokenList(request);
    }

    /**
     * Get Hot Token List Get hot token ranking list. Supports sorting by volume, price change,
     * market cap, etc., with filters for holding distribution, developer behavior, liquidity, and
     * more.
     *
     * @param binanceChainId Chain identifier. Single value only. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
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
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/general-data#get-hot-token-list">Get
     *     Hot Token List Documentation</a>
     */
    public ApiResponse<GetHotTokenListResponse> getHotTokenList(
            String binanceChainId,
            Long recvWindow,
            String nonce,
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
        return generalDataApi.getHotTokenList(
                binanceChainId,
                recvWindow,
                nonce,
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
            GeneralDataApi.GetSupportedChainsRequest request) {
        return generalDataApi.getSupportedChains(request);
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
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/general-data#get-supported-chains">Get
     *     Supported Chains Documentation</a>
     */
    public ApiResponse<GetSupportedChainsResponse> getSupportedChains(Long recvWindow, String nonce)
            throws ApiException {
        return generalDataApi.getSupportedChains(recvWindow, nonce);
    }

    public ApiResponse<GetTokenAdvancedInfoResponse> getTokenAdvancedInfo(
            GeneralDataApi.GetTokenAdvancedInfoRequest request) {
        return generalDataApi.getTokenAdvancedInfo(request);
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
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/general-data#get-token-advanced-info">Get
     *     Token Advanced Info Documentation</a>
     */
    public ApiResponse<GetTokenAdvancedInfoResponse> getTokenAdvancedInfo(
            String binanceChainId, String tokenContractAddress, Long recvWindow, String nonce)
            throws ApiException {
        return generalDataApi.getTokenAdvancedInfo(
                binanceChainId, tokenContractAddress, recvWindow, nonce);
    }

    public ApiResponse<GetTokenBasicInfoResponse> getTokenBasicInfo(
            GeneralDataApi.GetTokenBasicInfoRequest request) {
        return generalDataApi.getTokenBasicInfo(request);
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
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/general-data#get-token-basic-info">Get
     *     Token Basic Info Documentation</a>
     */
    public ApiResponse<GetTokenBasicInfoResponse> getTokenBasicInfo(
            String binanceChainId, String tokenContractAddress, Long recvWindow, String nonce)
            throws ApiException {
        return generalDataApi.getTokenBasicInfo(
                binanceChainId, tokenContractAddress, recvWindow, nonce);
    }

    public ApiResponse<GetTokenDevInfoResponse> getTokenDevInfo(
            GeneralDataApi.GetTokenDevInfoRequest request) {
        return generalDataApi.getTokenDevInfo(request);
    }

    /**
     * Get Token Dev Info Return developer profile for a token, including historical token launch
     * stats, current holding percentage, and initial funding source.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param tokenContractAddress Token contract address. EVM chains accept lowercase 42-character
     *     hex addresses; Solana accepts base58 addresses (case-sensitive). (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetTokenDevInfoResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Token dev info returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/general-data#get-token-dev-info">Get
     *     Token Dev Info Documentation</a>
     */
    public ApiResponse<GetTokenDevInfoResponse> getTokenDevInfo(
            String binanceChainId, String tokenContractAddress, Long recvWindow, String nonce)
            throws ApiException {
        return generalDataApi.getTokenDevInfo(
                binanceChainId, tokenContractAddress, recvWindow, nonce);
    }

    public ApiResponse<GetTokenPriceResponse> getTokenPrice(
            GeneralDataApi.GetTokenPriceRequest request) {
        return generalDataApi.getTokenPrice(request);
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
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/general-data#get-token-price">Get
     *     Token Price Documentation</a>
     */
    public ApiResponse<GetTokenPriceResponse> getTokenPrice(Long recvWindow, String nonce)
            throws ApiException {
        return generalDataApi.getTokenPrice(recvWindow, nonce);
    }

    public ApiResponse<GetTokenTradesResponse> getTokenTrades(
            GeneralDataApi.GetTokenTradesRequest request) {
        return generalDataApi.getTokenTrades(request);
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
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/general-data#get-token-trades">Get
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
        return generalDataApi.getTokenTrades(
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
            GeneralDataApi.GetTokenTradingInfoRequest request) {
        return generalDataApi.getTokenTradingInfo(request);
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
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/general-data#get-token-trading-info">Get
     *     Token Trading Info Documentation</a>
     */
    public ApiResponse<GetTokenTradingInfoResponse> getTokenTradingInfo(
            Long recvWindow, String nonce) throws ApiException {
        return generalDataApi.getTokenTradingInfo(recvWindow, nonce);
    }

    public ApiResponse<GetTopLiquidityPoolsResponse> getTopLiquidityPools(
            GeneralDataApi.GetTopLiquidityPoolsRequest request) {
        return generalDataApi.getTopLiquidityPools(request);
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
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/general-data#get-top-liquidity-pools">Get
     *     Top Liquidity Pools Documentation</a>
     */
    public ApiResponse<GetTopLiquidityPoolsResponse> getTopLiquidityPools(
            String binanceChainId, String tokenContractAddress, Long recvWindow, String nonce)
            throws ApiException {
        return generalDataApi.getTopLiquidityPools(
                binanceChainId, tokenContractAddress, recvWindow, nonce);
    }

    public ApiResponse<GetTopTradersResponse> getTopTraders(
            GeneralDataApi.GetTopTradersRequest request) {
        return generalDataApi.getTopTraders(request);
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
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/general-data#get-top-traders">Get
     *     Top Traders Documentation</a>
     */
    public ApiResponse<GetTopTradersResponse> getTopTraders(
            String binanceChainId,
            String tokenContractAddress,
            Long recvWindow,
            String nonce,
            TagFilter tagFilter)
            throws ApiException {
        return generalDataApi.getTopTraders(
                binanceChainId, tokenContractAddress, recvWindow, nonce, tagFilter);
    }

    public ApiResponse<SearchTokenResponse> searchToken(GeneralDataApi.SearchTokenRequest request) {
        return generalDataApi.searchToken(request);
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
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/general-data#search-token">Search
     *     Token Documentation</a>
     */
    public ApiResponse<SearchTokenResponse> searchToken(
            String chains, String search, Long recvWindow, String nonce) throws ApiException {
        return generalDataApi.searchToken(chains, search, recvWindow, nonce);
    }

    public ApiResponse<GetRwaTokenIssuancePlatformsResponse> getRwaTokenIssuancePlatforms(
            RwaDataApi.GetRwaTokenIssuancePlatformsRequest request) {
        return rwaDataApi.getRwaTokenIssuancePlatforms(request);
    }

    /**
     * Get RWA Token Issuance Platforms Return the list of supported RWA token issuance platforms
     * and their basic info.
     *
     * @param recvWindow Allowed time deviation in milliseconds. Default 5000, max 60000. (optional)
     * @param nonce Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN
     *     when omitted. (optional)
     * @param platformId Platform identifier (ondo&#x3D;Ondo Finance, bstock&#x3D;bStocks).
     *     Optional. If not specified, returns all platforms; when specified, returns only that
     *     platform. (optional)
     * @return ApiResponse&lt;GetRwaTokenIssuancePlatformsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> RWA token issuance platform list returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/rwa-data#get-rwa-token-issuance-platforms">Get
     *     RWA Token Issuance Platforms Documentation</a>
     */
    public ApiResponse<GetRwaTokenIssuancePlatformsResponse> getRwaTokenIssuancePlatforms(
            Long recvWindow, String nonce, PlatformId platformId) throws ApiException {
        return rwaDataApi.getRwaTokenIssuancePlatforms(recvWindow, nonce, platformId);
    }

    public ApiResponse<GetRwaTokenListResponse> getRwaTokenList(
            RwaDataApi.GetRwaTokenListRequest request) {
        return rwaDataApi.getRwaTokenList(request);
    }

    /**
     * Get RWA Token List Get the list of RWA tokens with underlying asset info. Supports filtering
     * by platform and sector tab.
     *
     * @param recvWindow Allowed time deviation in milliseconds. Default 5000, max 60000. (optional)
     * @param nonce Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN
     *     when omitted. (optional)
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). Optional. If not specified,
     *     returns data from all chains. (optional)
     * @param platformId Platform filter (ondo&#x3D;Ondo Finance, bstock&#x3D;bStocks). Optional. If
     *     not specified, returns all platforms. (optional)
     * @param tabId Sector tab filter. Optional. If not specified, returns all sectors. Enum:
     *     1&#x3D;Serenity Call, 2&#x3D;SpaceX (SpaceX-related and commercial spaceflight concept
     *     stocks), 3&#x3D;Upcoming Earnings, 4&#x3D;AI Chips, 5&#x3D;Storage, 6&#x3D;Energy,
     *     7&#x3D;Precious Metals, 8&#x3D;China ADR (Chinese companies listed in the US),
     *     9&#x3D;Magnificent 7 (the seven largest US tech giants: Apple, Microsoft, Alphabet,
     *     Amazon, Nvidia, Meta, Tesla), 10&#x3D;Crypto, 11&#x3D;ETF, 12&#x3D;Tech Leaders,
     *     13&#x3D;Buffett Portfolio. (optional)
     * @return ApiResponse&lt;GetRwaTokenListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> RWA token list returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/rwa-data#get-rwa-token-list">Get
     *     RWA Token List Documentation</a>
     */
    public ApiResponse<GetRwaTokenListResponse> getRwaTokenList(
            Long recvWindow,
            String nonce,
            String binanceChainId,
            PlatformId platformId,
            Integer tabId)
            throws ApiException {
        return rwaDataApi.getRwaTokenList(recvWindow, nonce, binanceChainId, platformId, tabId);
    }

    public ApiResponse<GetRwaTokenPriceResponse> getRwaTokenPrice(
            RwaDataApi.GetRwaTokenPriceRequest request) {
        return rwaDataApi.getRwaTokenPrice(request);
    }

    /**
     * Get RWA Token Price Batch query RWA token prices, including on-chain price and underlying
     * reference price.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param tokenContractAddresses Comma-separated token contract addresses. Maximum 100 per
     *     request. (required)
     * @param recvWindow Allowed time deviation in milliseconds. Default 5000, max 60000. (optional)
     * @param nonce Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN
     *     when omitted. (optional)
     * @return ApiResponse&lt;GetRwaTokenPriceResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Quote data returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/rwa-data#get-rwa-token-price">Get
     *     RWA Token Price Documentation</a>
     */
    public ApiResponse<GetRwaTokenPriceResponse> getRwaTokenPrice(
            String binanceChainId, String tokenContractAddresses, Long recvWindow, String nonce)
            throws ApiException {
        return rwaDataApi.getRwaTokenPrice(
                binanceChainId, tokenContractAddresses, recvWindow, nonce);
    }

    public ApiResponse<GetRwaUnderlyingInfoResponse> getRwaUnderlyingInfo(
            RwaDataApi.GetRwaUnderlyingInfoRequest request) {
        return rwaDataApi.getRwaUnderlyingInfo(request);
    }

    /**
     * Get RWA Underlying Info Get the underlying company information for an RWA token.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param tokenContractAddress Token contract address. (required)
     * @param recvWindow Allowed time deviation in milliseconds. Default 5000, max 60000. (optional)
     * @param nonce Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN
     *     when omitted. (optional)
     * @return ApiResponse&lt;GetRwaUnderlyingInfoResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Token detail returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/rwa-data#get-rwa-underlying-info">Get
     *     RWA Underlying Info Documentation</a>
     */
    public ApiResponse<GetRwaUnderlyingInfoResponse> getRwaUnderlyingInfo(
            String binanceChainId, String tokenContractAddress, Long recvWindow, String nonce)
            throws ApiException {
        return rwaDataApi.getRwaUnderlyingInfo(
                binanceChainId, tokenContractAddress, recvWindow, nonce);
    }

    public ApiResponse<GetRwaUnderlyingMarketDataResponse> getRwaUnderlyingMarketData(
            RwaDataApi.GetRwaUnderlyingMarketDataRequest request) {
        return rwaDataApi.getRwaUnderlyingMarketData(request);
    }

    /**
     * Get RWA Underlying Market Data Get market data for the underlying asset of an RWA token.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param tokenContractAddress Token contract address. (required)
     * @param recvWindow Allowed time deviation in milliseconds. Default 5000, max 60000. (optional)
     * @param nonce Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN
     *     when omitted. (optional)
     * @return ApiResponse&lt;GetRwaUnderlyingMarketDataResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Underlying market data returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/rwa-data#get-rwa-underlying-market-data">Get
     *     RWA Underlying Market Data Documentation</a>
     */
    public ApiResponse<GetRwaUnderlyingMarketDataResponse> getRwaUnderlyingMarketData(
            String binanceChainId, String tokenContractAddress, Long recvWindow, String nonce)
            throws ApiException {
        return rwaDataApi.getRwaUnderlyingMarketData(
                binanceChainId, tokenContractAddress, recvWindow, nonce);
    }

    public ApiResponse<SearchRwaTokenResponse> searchRwaToken(
            RwaDataApi.SearchRwaTokenRequest request) {
        return rwaDataApi.searchRwaToken(request);
    }

    /**
     * Search RWA Token Search RWA tokens by keyword or contract address.
     *
     * @param keyword Search keyword (ticker, company name, or contract address). Case-insensitive.
     *     (required)
     * @param recvWindow Allowed time deviation in milliseconds. Default 5000, max 60000. (optional)
     * @param nonce Unique request identifier to prevent replay attacks. Falls back to X-OC-SIGN
     *     when omitted. (optional)
     * @param platformId Platform filter (ondo&#x3D;Ondo Finance, bstock&#x3D;bStocks). Optional. If
     *     not specified, returns results from all platforms. (optional)
     * @return ApiResponse&lt;SearchRwaTokenResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Ticker lookup results returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/rwa-data#search-rwa-token">Search
     *     RWA Token Documentation</a>
     */
    public ApiResponse<SearchRwaTokenResponse> searchRwaToken(
            String keyword, Long recvWindow, String nonce, PlatformId platformId)
            throws ApiException {
        return rwaDataApi.searchRwaToken(keyword, recvWindow, nonce, platformId);
    }

    public ApiResponse<BuildSolanaSwapInstructionsResponse> buildSolanaSwapInstructions(
            TradingApi.BuildSolanaSwapInstructionsRequest request) {
        return tradingApi.buildSolanaSwapInstructions(request);
    }

    /**
     * Build Solana Swap Instructions Solana-only counterpart to &#x60;/swap&#x60;. Shares the full
     * quote → route → vendor &#x60;buildSwapTx&#x60; → priceImpact → minReceive →
     * instruction-assembly pipeline; the only difference is the response: instead of returning a
     * signed-and-serialized base64 transaction, this endpoint returns the **uncompiled**
     * instruction list plus the address-lookup-table (ALT) address list, leaving v0-transaction
     * compilation, signing, and submission to the caller. Use this when the caller needs to: -
     * prepend / append their own instructions (e.g. fee splitting, custom logging) before signing;
     * - reuse the platform-curated route, slippage, PS-variant rewriting, ALT injection,
     * ComputeBudget overwrite, and ATA batching while still controlling the final wire format. Only
     * supports &#x60;binanceChainId&#x3D;CT_501&#x60; (Solana). Other chains return
     * &#x60;CHAIN_NOT_SUPPORTED&#x60; (40411). Parameters mirror the Solana subset of
     * &#x60;/swap&#x60; (no EVM-only &#x60;approveTransaction&#x60; / &#x60;approveAmount&#x60; /
     * &#x60;gasLimit&#x60;). Supports the custom-fee (Add Fee / referral fee) parameters
     * (&#x60;feePercent&#x60; + &#x60;fromTokenReferrerWalletAddress&#x60; /
     * &#x60;toTokenReferrerWalletAddress&#x60;), with the same semantics as &#x60;/swap&#x60; — the
     * fee instructions are injected into the returned uncompiled instruction list.
     *
     * @param binanceChainId Chain identifier. Only &#x60;CT_501&#x60; (Solana) is accepted; other
     *     values return &#x60;CHAIN_NOT_SUPPORTED&#x60; (40411). (required)
     * @param amount Sell-token amount in the token&#39;s smallest unit (positive integer string, no
     *     decimals). (required)
     * @param fromTokenAddress Sell-token mint address (Solana Base58, case-sensitive). (required)
     * @param toTokenAddress Buy-token mint address (Solana Base58, case-sensitive). (required)
     * @param slippagePercent Maximum slippage as a percentage. Solana range 0 to less than 100.
     *     \&quot;0.5\&quot; means 0.5%. (required)
     * @param userWalletAddress User wallet address (Solana Base58); becomes the v0
     *     transaction&#39;s &#x60;feePayer&#x60;. (required)
     * @param quoteId quoteId returned from &#x60;/quote&#x60; for the route to execute. TTL ~30s;
     *     expired entries return &#x60;QUOTE_EXPIRED&#x60; (40401). (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param priceImpactProtectionPercent Maximum allowed price impact percentage (0–100). Defaults
     *     to 90; set to 100 to disable. (optional)
     * @param autoSlippage When \&quot;true\&quot;, slippage is auto-derived from market data and
     *     overrides &#x60;slippagePercent&#x60;. Defaults to false. (optional)
     * @param maxAutoSlippagePercent Cap on auto-derived slippage (only applies when
     *     &#x60;autoSlippage&#x3D;true&#x60;). (optional)
     * @param computeUnitLimit Maximum compute units the transaction may consume (analogous to EVM
     *     gasLimit). Defaults to the platform value when omitted. (optional)
     * @param computeUnitPrice Priority fee per compute unit (micro-lamports). When omitted, the
     *     platform computes a value either from the &#x60;gasLevel&#x60; tier or from chain-side
     *     defaults. (optional)
     * @param gasLevel Priority-fee tier; consulted only when &#x60;computeUnitPrice&#x60; is
     *     omitted. Defaults to \&quot;average\&quot;. (optional)
     * @param tips Jito tips in SOL for MEV protection. Valid range [0.000000001, 2] (minimum 1
     *     lamport). When specified, it is recommended to set &#x60;computeUnitPrice&#x3D;0&#x60;.
     *     The platform picks one of Jito&#39;s tip accounts at random per request. (optional)
     * @param feePercent Custom fee (referral fee / Add Fee) percentage as a decimal string. Must be
     *     paired with exactly one of &#x60;fromTokenReferrerWalletAddress&#x60; or
     *     &#x60;toTokenReferrerWalletAddress&#x60; (the two referrer addresses are mutually
     *     exclusive). Same semantics as &#x60;/swap&#x60;. **Range (Solana):** &#x60;(0, 10]&#x60;
     *     — greater than 0, up to 10 inclusive, max 2 decimal places. &#x60;\&quot;1.5\&quot;&#x60;
     *     means 1.5%. Values exceeding 2 decimal places are rejected with
     *     &#x60;INVALID_FEE_PERCENT&#x60; (40466). **&#x60;four.meme&#x60; tokens are not
     *     supported** — do not pass fee parameters when either side of the pair is a
     *     &#x60;four.meme&#x60; token. (optional)
     * @param fromTokenReferrerWalletAddress Wallet address that receives the fee deducted from the
     *     sell token (&#x60;FROM_TOKEN&#x60; direction). Mutually exclusive with
     *     &#x60;toTokenReferrerWalletAddress&#x60; — providing both returns
     *     &#x60;CONFLICT_REFERRER_PARAMS&#x60; (40468). Solana requires a Base58 pubkey; an invalid
     *     format returns &#x60;INVALID_REFERRER_ADDRESS&#x60; (40467). Must be paired with
     *     &#x60;feePercent&#x60;. (optional)
     * @param toTokenReferrerWalletAddress Wallet address that receives the fee deducted from the
     *     buy-token output (&#x60;TO_TOKEN&#x60; direction). Mutually exclusive with
     *     &#x60;fromTokenReferrerWalletAddress&#x60; — providing both returns
     *     &#x60;CONFLICT_REFERRER_PARAMS&#x60; (40468). Solana requires a Base58 pubkey; an invalid
     *     format returns &#x60;INVALID_REFERRER_ADDRESS&#x60; (40467). Must be paired with
     *     &#x60;feePercent&#x60;. The referrer must already be activated (funded with some SOL) or
     *     the request returns &#x60;REFERRER_NOT_ACTIVATED&#x60; (40469). (optional)
     * @return ApiResponse&lt;BuildSolanaSwapInstructionsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Uncompiled Solana instruction list and ALT addresses returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/trading-api#build-solana-swap-instructions">Build
     *     Solana Swap Instructions Documentation</a>
     */
    public ApiResponse<BuildSolanaSwapInstructionsResponse> buildSolanaSwapInstructions(
            BinanceChainId binanceChainId,
            String amount,
            String fromTokenAddress,
            String toTokenAddress,
            String slippagePercent,
            String userWalletAddress,
            String quoteId,
            Long recvWindow,
            String nonce,
            String priceImpactProtectionPercent,
            AutoSlippage autoSlippage,
            String maxAutoSlippagePercent,
            String computeUnitLimit,
            String computeUnitPrice,
            GasLevel gasLevel,
            String tips,
            String feePercent,
            String fromTokenReferrerWalletAddress,
            String toTokenReferrerWalletAddress)
            throws ApiException {
        return tradingApi.buildSolanaSwapInstructions(
                binanceChainId,
                amount,
                fromTokenAddress,
                toTokenAddress,
                slippagePercent,
                userWalletAddress,
                quoteId,
                recvWindow,
                nonce,
                priceImpactProtectionPercent,
                autoSlippage,
                maxAutoSlippagePercent,
                computeUnitLimit,
                computeUnitPrice,
                gasLevel,
                tips,
                feePercent,
                fromTokenReferrerWalletAddress,
                toTokenReferrerWalletAddress);
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
     * @param userWalletAddress User wallet address (transaction sender). (required)
     * @param quoteId quoteId returned from &#x60;/quote&#x60; for the route to execute. TTL ~30s;
     *     expired entries return &#x60;QUOTE_EXPIRED&#x60; (40401). (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param slippagePercent Maximum slippage tolerance as a percentage string. Required unless
     *     &#x60;autoSlippage&#x3D;true&#x60;. **Range by chain:** - EVM chains (BSC, Ethereum,
     *     Base, etc.): &#x60;0&#x60; to &#x60;100&#x60; (inclusive) - Solana (&#x60;CT_501&#x60;):
     *     &#x60;0&#x60; to less than &#x60;100&#x60; (i.e. &#x60;&lt; 100&#x60;) **Range by
     *     vendor:** - 1inch, PancakeSwap: &#x60;0&#x60; to &#x60;50&#x60; (values above 50 are
     *     rejected) - LiFi, LiquidMesh: &#x60;0&#x60; to &#x60;100&#x60; (EVM) or &#x60;0&#x60; to
     *     &#x60;&lt; 100&#x60; (Solana) - Jupiter (Solana): &#x60;0&#x60; to less than
     *     &#x60;100&#x60;; the value is converted to basis points (&#x60;slippageBps &#x3D;
     *     ceil(slippagePercent × 100)&#x60;) and applied to the on-chain swap
     *     &#x60;\&quot;0.5\&quot;&#x60; means 0.5% maximum slippage. When
     *     &#x60;autoSlippage&#x3D;true&#x60; this field is overridden by the auto-computed value.
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
     * @param autoSlippage When &#x60;\&quot;true\&quot;&#x60;, slippage is auto-derived from market
     *     data and overrides &#x60;slippagePercent&#x60;. Either &#x60;slippagePercent&#x60; or
     *     &#x60;autoSlippage&#x3D;true&#x60; must be provided — omitting both returns a parameter
     *     error. Defaults to &#x60;\&quot;false\&quot;&#x60;. (optional)
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
     * @param feePercent Custom fee (referral fee / Add Fee) percentage as a decimal string. Must be
     *     paired with exactly one of &#x60;fromTokenReferrerWalletAddress&#x60; or
     *     &#x60;toTokenReferrerWalletAddress&#x60; (the two referrer addresses are mutually
     *     exclusive). **Range by chain:** &#x60;(0, 5]&#x60; for EVM chains (BSC, Ethereum, Base,
     *     etc.) and &#x60;(0, 10]&#x60; for Solana (&#x60;CT_501&#x60;) — greater than 0, up to the
     *     chain-specific maximum inclusive, max 2 decimal places. &#x60;\&quot;1.5\&quot;&#x60;
     *     means 1.5%. Values exceeding 2 decimal places are rejected with
     *     &#x60;INVALID_FEE_PERCENT&#x60; (40466). **&#x60;four.meme&#x60; tokens are not
     *     supported** — do not pass fee parameters when either side of the pair is a
     *     &#x60;four.meme&#x60; token. (optional)
     * @param fromTokenReferrerWalletAddress Wallet address that receives the fee deducted from the
     *     sell token (&#x60;FROM_TOKEN&#x60; direction). Mutually exclusive with
     *     &#x60;toTokenReferrerWalletAddress&#x60; — providing both returns
     *     &#x60;CONFLICT_REFERRER_PARAMS&#x60; (40468). Address format depends on the chain: EVM
     *     chains require &#x60;0x&#x60; + 40 hex chars; Solana (&#x60;CT_501&#x60;) requires a
     *     Base58 pubkey. An invalid format returns &#x60;INVALID_REFERRER_ADDRESS&#x60; (40467).
     *     Must be paired with &#x60;feePercent&#x60;. (optional)
     * @param toTokenReferrerWalletAddress Wallet address that receives the fee deducted from the
     *     buy-token output (&#x60;TO_TOKEN&#x60; direction). Mutually exclusive with
     *     &#x60;fromTokenReferrerWalletAddress&#x60; — providing both returns
     *     &#x60;CONFLICT_REFERRER_PARAMS&#x60; (40468). Address format depends on the chain: EVM
     *     chains require &#x60;0x&#x60; + 40 hex chars; Solana (&#x60;CT_501&#x60;) requires a
     *     Base58 pubkey. An invalid format returns &#x60;INVALID_REFERRER_ADDRESS&#x60; (40467).
     *     Must be paired with &#x60;feePercent&#x60;. On Solana, the referrer must already be
     *     activated (funded with some SOL) or the request returns
     *     &#x60;REFERRER_NOT_ACTIVATED&#x60; (40469). (optional)
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
            String userWalletAddress,
            String quoteId,
            Long recvWindow,
            String nonce,
            String slippagePercent,
            ApproveTransaction approveTransaction,
            String approveAmount,
            String gasLimit,
            GasLevel gasLevel,
            String priceImpactProtectionPercent,
            AutoSlippage autoSlippage,
            String maxAutoSlippagePercent,
            String computeUnitLimit,
            String computeUnitPrice,
            String tips,
            String feePercent,
            String fromTokenReferrerWalletAddress,
            String toTokenReferrerWalletAddress)
            throws ApiException {
        return tradingApi.buildSwapTransaction(
                binanceChainId,
                amount,
                fromTokenAddress,
                toTokenAddress,
                userWalletAddress,
                quoteId,
                recvWindow,
                nonce,
                slippagePercent,
                approveTransaction,
                approveAmount,
                gasLimit,
                gasLevel,
                priceImpactProtectionPercent,
                autoSlippage,
                maxAutoSlippagePercent,
                computeUnitLimit,
                computeUnitPrice,
                tips,
                feePercent,
                fromTokenReferrerWalletAddress,
                toTokenReferrerWalletAddress);
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
     * @param userWalletAddress User wallet address. Required when quoting RFQ routes (equity / RWA
     *     tokens such as Ondo and BStock). This address is used as the receiver in the RFQ order
     *     and must match the wallet that signs &#x60;rfq.typedDataToSign&#x60; in the subsequent
     *     &#x60;/swap&#x60; call. (optional)
     * @param feePercent Custom fee (referral fee / Add Fee) percentage as a decimal string. Must be
     *     paired with &#x60;feeSource&#x60; — either both present or both absent. **Range by
     *     chain:** &#x60;(0, 5]&#x60; for EVM chains (BSC, Ethereum, Base, etc.) and &#x60;(0,
     *     10]&#x60; for Solana (&#x60;CT_501&#x60;) — greater than 0, up to the chain-specific
     *     maximum inclusive, max 2 decimal places. &#x60;\&quot;1.5\&quot;&#x60; means 1.5%. Values
     *     exceeding 2 decimal places are rejected with &#x60;INVALID_FEE_PERCENT&#x60; (40466).
     *     **&#x60;four.meme&#x60; tokens are not supported** — do not pass fee parameters when
     *     either side of the pair is a &#x60;four.meme&#x60; token. (optional)
     * @param feeSource Fee deduction direction. &#x60;FROM_TOKEN&#x60; &#x3D; deduct the fee from
     *     the sell token (the amount passed to the DEX is reduced to a net amount);
     *     &#x60;TO_TOKEN&#x60; &#x3D; deduct the fee from the buy-token output (the user&#39;s
     *     actual received amount is reduced). Must be paired with &#x60;feePercent&#x60;.
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
            String nonce,
            String userWalletAddress,
            String feePercent,
            FeeSource feeSource)
            throws ApiException {
        return tradingApi.getAggregatedQuote(
                binanceChainId,
                amount,
                fromTokenAddress,
                toTokenAddress,
                recvWindow,
                nonce,
                userWalletAddress,
                feePercent,
                feeSource);
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
     * @param vendor RFQ vendor name. **Required for equity / RWA tokens (Ondo, BStock)**; pass the
     *     &#x60;vendorName&#x60; from the &#x60;/quote&#x60; response (e.g. &#x60;InchFusion&#x60;,
     *     &#x60;CowSwap&#x60;, &#x60;PcsXRfq&#x60;). When provided, the backend returns approve
     *     calldata targeting the vendor-specific spender contract (e.g. 1inch Router, PcsX Permit2,
     *     CowSwap VaultRelayer) instead of the default DEX router. For regular (non-RWA) tokens,
     *     this parameter is optional. If omitted, the backend uses the standard DEX router. If a
     *     valid RFQ vendor is passed, the backend resolves that vendor&#39;s spender — used when
     *     buying Ondo/BStock with a stablecoin, where the from-token (e.g. USDT) itself is not an
     *     RFQ token but must be approved to the RFQ vendor&#39;s router. (optional)
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
            String nonce,
            String vendor)
            throws ApiException {
        return tradingApi.getErc20ApproveTransaction(
                binanceChainId, tokenContractAddress, approveAmount, recvWindow, nonce, vendor);
    }

    public ApiResponse<GetRfqOrderStatusResponse> getRfqOrderStatus(
            TradingApi.GetRfqOrderStatusRequest request) {
        return tradingApi.getRfqOrderStatus(request);
    }

    /**
     * Get RFQ Order Status Query the settlement status of an RFQ order by its platform
     * &#x60;orderId&#x60; (returned by &#x60;POST /order/submit&#x60;). Poll this endpoint until
     * &#x60;status&#x60; reaches a terminal state: &#x60;FILLED&#x60; (settled on-chain) or
     * &#x60;FAILED&#x60; (settlement failed).
     *
     * @param orderId Platform order ID returned by &#x60;POST /order/submit&#x60;. (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetRfqOrderStatusResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Order status returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/trading-api#get-rfq-order-status">Get
     *     RFQ Order Status Documentation</a>
     */
    public ApiResponse<GetRfqOrderStatusResponse> getRfqOrderStatus(
            String orderId, Long recvWindow, String nonce) throws ApiException {
        return tradingApi.getRfqOrderStatus(orderId, recvWindow, nonce);
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

    public ApiResponse<QuoteAndBuildSwapTransactionResponse> quoteAndBuildSwapTransaction(
            TradingApi.QuoteAndBuildSwapTransactionRequest request) {
        return tradingApi.quoteAndBuildSwapTransaction(request);
    }

    /**
     * Quote and Build Swap Transaction (Flash API) Combines quoting and swap-transaction
     * construction into a single call. Unlike the two-step &#x60;/quote&#x60; + &#x60;/swap&#x60;
     * flow, this endpoint does not require a prior &#x60;/quote&#x60; call or a &#x60;quoteId&#x60;
     * — it returns the executable calldata / swapTransaction directly, eliminating one HTTP
     * round-trip. Use this endpoint for latency-sensitive trading when the vendor is known upfront.
     * The response shape is identical to &#x60;/swap&#x60;, so clients can reuse the same response
     * parsing logic for both endpoints.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;56\&quot;&#x3D;BSC,
     *     \&quot;1\&quot;&#x3D;Ethereum, \&quot;CT_501\&quot;&#x3D;Solana). (required)
     * @param amount Sell-token amount in the token&#39;s smallest unit (positive integer string, no
     *     decimals). (required)
     * @param fromTokenAddress Sell-token contract address. (required)
     * @param toTokenAddress Buy-token contract address. (required)
     * @param userWalletAddress User wallet address (transaction sender). For Solana, a Base58
     *     system-account address with sufficient SOL for gas. (required)
     * @param vendor Swap vendor to use for this request. **Required** — case-sensitive; must match
     *     one of the enum values. Any other value returns &#x60;PARAM_ERROR&#x60; (40001). For
     *     multi-vendor aggregation, use &#x60;/swap&#x60; with a &#x60;quoteId&#x60; instead.
     *     (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param slippagePercent Maximum slippage tolerance as a percentage string. Required unless
     *     &#x60;autoSlippage&#x3D;true&#x60;. **Range by chain:** - EVM chains (BSC, Ethereum,
     *     Base, etc.): &#x60;0&#x60; to &#x60;100&#x60; (inclusive) - Solana (&#x60;CT_501&#x60;):
     *     &#x60;0&#x60; to less than &#x60;100&#x60; (i.e. &#x60;&lt; 100&#x60;)
     *     &#x60;\&quot;0.5\&quot;&#x60; means 0.5% maximum slippage. When
     *     &#x60;autoSlippage&#x3D;true&#x60; this field is overridden by the auto-computed value.
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
     * @param autoSlippage When &#x60;\&quot;true\&quot;&#x60;, slippage is auto-derived from market
     *     data and overrides &#x60;slippagePercent&#x60;. Either &#x60;slippagePercent&#x60; or
     *     &#x60;autoSlippage&#x3D;true&#x60; must be provided — omitting both returns a parameter
     *     error. Defaults to &#x60;\&quot;false\&quot;&#x60;. (optional)
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
     * @param feePercent Custom fee (referral fee / Add Fee) percentage as a decimal string. Must be
     *     paired with exactly one of &#x60;fromTokenReferrerWalletAddress&#x60; or
     *     &#x60;toTokenReferrerWalletAddress&#x60; (the two referrer addresses are mutually
     *     exclusive). **Range by chain:** &#x60;(0, 5]&#x60; for EVM chains (BSC, Ethereum, Base,
     *     etc.) and &#x60;(0, 10]&#x60; for Solana (&#x60;CT_501&#x60;) — greater than 0, up to the
     *     chain-specific maximum inclusive, max 2 decimal places. &#x60;\&quot;1.5\&quot;&#x60;
     *     means 1.5%. Values exceeding 2 decimal places are rejected with
     *     &#x60;INVALID_FEE_PERCENT&#x60; (40466). **&#x60;four.meme&#x60; tokens are not
     *     supported** — do not pass fee parameters when either side of the pair is a
     *     &#x60;four.meme&#x60; token. (optional)
     * @param fromTokenReferrerWalletAddress Wallet address that receives the fee deducted from the
     *     sell token (&#x60;FROM_TOKEN&#x60; direction). Mutually exclusive with
     *     &#x60;toTokenReferrerWalletAddress&#x60; — providing both returns
     *     &#x60;CONFLICT_REFERRER_PARAMS&#x60; (40468). Address format depends on the chain: EVM
     *     chains require &#x60;0x&#x60; + 40 hex chars; Solana (&#x60;CT_501&#x60;) requires a
     *     Base58 pubkey. An invalid format returns &#x60;INVALID_REFERRER_ADDRESS&#x60; (40467).
     *     Must be paired with &#x60;feePercent&#x60;. (optional)
     * @param toTokenReferrerWalletAddress Wallet address that receives the fee deducted from the
     *     buy-token output (&#x60;TO_TOKEN&#x60; direction). Mutually exclusive with
     *     &#x60;fromTokenReferrerWalletAddress&#x60; — providing both returns
     *     &#x60;CONFLICT_REFERRER_PARAMS&#x60; (40468). Address format depends on the chain: EVM
     *     chains require &#x60;0x&#x60; + 40 hex chars; Solana (&#x60;CT_501&#x60;) requires a
     *     Base58 pubkey. An invalid format returns &#x60;INVALID_REFERRER_ADDRESS&#x60; (40467).
     *     Must be paired with &#x60;feePercent&#x60;. On Solana, the referrer must already be
     *     activated (funded with some SOL) or the request returns
     *     &#x60;REFERRER_NOT_ACTIVATED&#x60; (40469). (optional)
     * @return ApiResponse&lt;QuoteAndBuildSwapTransactionResponse&gt;
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
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/trading-api#quote-and-build-swap-transaction">Quote
     *     and Build Swap Transaction (Flash API) Documentation</a>
     */
    public ApiResponse<QuoteAndBuildSwapTransactionResponse> quoteAndBuildSwapTransaction(
            String binanceChainId,
            String amount,
            String fromTokenAddress,
            String toTokenAddress,
            String userWalletAddress,
            Vendor vendor,
            Long recvWindow,
            String nonce,
            String slippagePercent,
            ApproveTransaction approveTransaction,
            String approveAmount,
            String gasLimit,
            GasLevel gasLevel,
            String priceImpactProtectionPercent,
            AutoSlippage autoSlippage,
            String maxAutoSlippagePercent,
            String computeUnitLimit,
            String computeUnitPrice,
            String tips,
            String feePercent,
            String fromTokenReferrerWalletAddress,
            String toTokenReferrerWalletAddress)
            throws ApiException {
        return tradingApi.quoteAndBuildSwapTransaction(
                binanceChainId,
                amount,
                fromTokenAddress,
                toTokenAddress,
                userWalletAddress,
                vendor,
                recvWindow,
                nonce,
                slippagePercent,
                approveTransaction,
                approveAmount,
                gasLimit,
                gasLevel,
                priceImpactProtectionPercent,
                autoSlippage,
                maxAutoSlippagePercent,
                computeUnitLimit,
                computeUnitPrice,
                tips,
                feePercent,
                fromTokenReferrerWalletAddress,
                toTokenReferrerWalletAddress);
    }

    /**
     * Submit RFQ Order Submit a signed RFQ order to the backend for on-chain settlement via the
     * corresponding vendor relayer. Only used when &#x60;executionMode&#x3D;RFQ&#x60; (equity / RWA
     * tokens such as Ondo and BStock). **Flow**: &#x60;GET /quote&#x60; → pick an RFQ route →
     * &#x60;GET /swap&#x60; → sign &#x60;rfq.typedDataToSign&#x60; with EIP-712
     * (&#x60;eth_signTypedData_v4&#x60;) → call this endpoint → poll &#x60;GET
     * /order/{orderId}&#x60; until &#x60;FILLED&#x60; or &#x60;FAILED&#x60;. **Idempotency**:
     * Submitting with the same &#x60;requestId&#x60; within 30 minutes returns the original result
     * without re-calling the vendor. Use a new UUID for each distinct order; reuse the same UUID
     * when retrying.
     *
     * @param submitRfqOrderRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;SubmitRfqOrderResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> RFQ order submitted successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/trading-api#submit-rfq-order">Submit
     *     RFQ Order Documentation</a>
     */
    public ApiResponse<SubmitRfqOrderResponse> submitRfqOrder(
            SubmitRfqOrderRequest submitRfqOrderRequest, Long recvWindow, String nonce)
            throws ApiException {
        return tradingApi.submitRfqOrder(submitRfqOrderRequest, recvWindow, nonce);
    }

    /**
     * Broadcast Transactions Broadcast a client-signed transaction to the chain via the Binance
     * Web3 API relay. Returns the transaction hash and an internal &#x60;orderId&#x60; you can use
     * to track on-chain status via the post-transaction service. Optional MEV protection (EVM
     * chains only) routes the transaction through a private mempool to mitigate front-running and
     * sandwich attacks. Tron and Solana do not support MEV protection; the flag is ignored on these
     * chains.
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
     * transaction. Provide either &#x60;evmTx&#x60; for EVM chains, &#x60;solTx&#x60; for Solana,
     * or &#x60;tronTx&#x60; for Tron (\&quot;CT_195\&quot;), matching the value of
     * &#x60;binanceChainId&#x60;. On Tron the response carries energy/bandwidth fields instead of a
     * single gas limit; &#x60;gasLimit&#x60; is the fee limit (in sun) and the energy/bandwidth
     * fields describe resource consumption and pricing.
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
     * supported. - Solana returns &#x60;solanaGasPrice&#x60; (compute-unit prices and Jito tips). -
     * Tron (\&quot;CT_195\&quot;) returns an empty &#x60;data&#x60; object because Tron has no
     * on-chain gas-price concept; use the gas-limit endpoint instead. Fields not applicable to the
     * chain family are returned as &#x60;null&#x60;.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana,
     *     \&quot;CT_195\&quot;&#x3D;Tron). (required)
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
     * &#x60;evmTx&#x60; (EVM chains), &#x60;solTx&#x60; (Solana), or &#x60;tronTx&#x60; (Tron
     * \&quot;CT_195\&quot;) matching &#x60;binanceChainId&#x60;. On Tron,
     * &#x60;allowanceChanges&#x60; is returned as an empty array. Note: Metis (chainId 1088) is not
     * supported by this endpoint.
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
