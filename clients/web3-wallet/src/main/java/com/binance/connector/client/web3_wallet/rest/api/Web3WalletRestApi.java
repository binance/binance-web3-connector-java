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
import com.binance.connector.client.web3_wallet.rest.model.BuildDeFiClaimTransactionRequest;
import com.binance.connector.client.web3_wallet.rest.model.BuildDeFiClaimTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.BuildDeFiDepositTransactionRequest;
import com.binance.connector.client.web3_wallet.rest.model.BuildDeFiDepositTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.BuildDeFiRedeemTransactionRequest;
import com.binance.connector.client.web3_wallet.rest.model.BuildDeFiRedeemTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.BuildLpAddTransactionRequest;
import com.binance.connector.client.web3_wallet.rest.model.BuildLpAddTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.BuildLpRemoveTransactionRequest;
import com.binance.connector.client.web3_wallet.rest.model.BuildLpRemoveTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.BuildSolanaSwapInstructionsResponse;
import com.binance.connector.client.web3_wallet.rest.model.BuildSwapTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.CalculateLpAddPairedAmountsRequest;
import com.binance.connector.client.web3_wallet.rest.model.CalculateLpAddPairedAmountsResponse;
import com.binance.connector.client.web3_wallet.rest.model.FeeSource;
import com.binance.connector.client.web3_wallet.rest.model.GasLevel;
import com.binance.connector.client.web3_wallet.rest.model.GetAddressPnLForSpecificTokenResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetAddressPortfolioOverviewResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetAddressRecentPnLResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetAggregatedQuoteResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetAggregatorSupportedChainsResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetAllTokenBalancesByAddressResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetB402SupportedConfigurationsV1Request;
import com.binance.connector.client.web3_wallet.rest.model.GetB402SupportedConfigurationsV1Response;
import com.binance.connector.client.web3_wallet.rest.model.GetB402SupportedConfigurationsV2Request;
import com.binance.connector.client.web3_wallet.rest.model.GetB402SupportedConfigurationsV2Response;
import com.binance.connector.client.web3_wallet.rest.model.GetBroadcastOrdersResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetCandlesResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetDeFiPositionsRequest;
import com.binance.connector.client.web3_wallet.rest.model.GetDeFiPositionsResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetDexTradeHistoryResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetErc20ApproveTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetGasLimitRequest;
import com.binance.connector.client.web3_wallet.rest.model.GetGasLimitResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetGasPriceResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetHoldersRankingResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetHotTokenListResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetInvestmentDetailRequest;
import com.binance.connector.client.web3_wallet.rest.model.GetInvestmentDetailResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetLatestBlockHeightResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetLeaderboardResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetPortfolioSupportedChainsResponse;
import com.binance.connector.client.web3_wallet.rest.model.GetProtocolDetailRequest;
import com.binance.connector.client.web3_wallet.rest.model.GetProtocolDetailResponse;
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
import com.binance.connector.client.web3_wallet.rest.model.GetWebSocketAuthTokenResponse;
import com.binance.connector.client.web3_wallet.rest.model.ListDeFiInvestmentsRequest;
import com.binance.connector.client.web3_wallet.rest.model.ListDeFiInvestmentsResponse;
import com.binance.connector.client.web3_wallet.rest.model.ListDeFiProtocolsRequest;
import com.binance.connector.client.web3_wallet.rest.model.ListDeFiProtocolsResponse;
import com.binance.connector.client.web3_wallet.rest.model.OrderType;
import com.binance.connector.client.web3_wallet.rest.model.PlatformId;
import com.binance.connector.client.web3_wallet.rest.model.QuoteAndBuildSwapTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.RankBy;
import com.binance.connector.client.web3_wallet.rest.model.RankingTimeFrame;
import com.binance.connector.client.web3_wallet.rest.model.SearchRwaTokenResponse;
import com.binance.connector.client.web3_wallet.rest.model.SearchTokenResponse;
import com.binance.connector.client.web3_wallet.rest.model.SettleB402PaymentV1Request;
import com.binance.connector.client.web3_wallet.rest.model.SettleB402PaymentV1Response;
import com.binance.connector.client.web3_wallet.rest.model.SettleB402PaymentV2Request;
import com.binance.connector.client.web3_wallet.rest.model.SettleB402PaymentV2Response;
import com.binance.connector.client.web3_wallet.rest.model.SimulateTransactionsRequest;
import com.binance.connector.client.web3_wallet.rest.model.SimulateTransactionsResponse;
import com.binance.connector.client.web3_wallet.rest.model.SortBy;
import com.binance.connector.client.web3_wallet.rest.model.SubmitRfqOrderRequest;
import com.binance.connector.client.web3_wallet.rest.model.SubmitRfqOrderResponse;
import com.binance.connector.client.web3_wallet.rest.model.TagFilter;
import com.binance.connector.client.web3_wallet.rest.model.TimeFrame;
import com.binance.connector.client.web3_wallet.rest.model.TrackerType;
import com.binance.connector.client.web3_wallet.rest.model.Vendor;
import com.binance.connector.client.web3_wallet.rest.model.VerifyB402PaymentV1Request;
import com.binance.connector.client.web3_wallet.rest.model.VerifyB402PaymentV1Response;
import com.binance.connector.client.web3_wallet.rest.model.VerifyB402PaymentV2Request;
import com.binance.connector.client.web3_wallet.rest.model.VerifyB402PaymentV2Response;
import com.binance.connector.client.web3_wallet.rest.model.WalletType;

public class Web3WalletRestApi {

    private final AddressPortfolioApi addressPortfolioApi;
    private final B402PaymentsApi b402PaymentsApi;
    private final DefiDataApi defiDataApi;
    private final DefiTransactionApi defiTransactionApi;
    private final GeneralDataApi generalDataApi;
    private final RwaDataApi rwaDataApi;
    private final TradingApi tradingApi;
    private final TransactionApi transactionApi;
    private final WalletApi walletApi;
    private final WebSocketApi webSocketApi;

    public Web3WalletRestApi(ClientConfiguration configuration) {
        this(Web3WalletRestApiUtil.getDefaultClient(configuration));
    }

    public Web3WalletRestApi(ApiClient apiClient) {
        this.addressPortfolioApi = new AddressPortfolioApi(apiClient);
        this.b402PaymentsApi = new B402PaymentsApi(apiClient);
        this.defiDataApi = new DefiDataApi(apiClient);
        this.defiTransactionApi = new DefiTransactionApi(apiClient);
        this.generalDataApi = new GeneralDataApi(apiClient);
        this.rwaDataApi = new RwaDataApi(apiClient);
        this.tradingApi = new TradingApi(apiClient);
        this.transactionApi = new TransactionApi(apiClient);
        this.walletApi = new WalletApi(apiClient);
        this.webSocketApi = new WebSocketApi(apiClient);
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

    /**
     * Get B402 Supported Configurations V1 Legacy V1 compatibility endpoint. New integrations
     * should use V2. V1 returns &#x60;x402Version&#x3D;1&#x60;, method-specific
     * &#x60;facilitatorAddress&#x60;, and V1 signer-map semantics.
     *
     * @param getB402SupportedConfigurationsV1Request (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetB402SupportedConfigurationsV1Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Legacy supported configurations or a B402 business error envelope. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains invalid Web3 API credentials. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. Check the API Key&#39;s B402 Payments permission, IP whitelist, and endpoint allowlist. </td><td>  -  </td></tr>
     * <tr><td> 429 </td><td> Rate limit exceeded. </td><td>  -  </td></tr>
     * <tr><td> 503 </td><td> B402 is temporarily unavailable. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/b402-payments#get-b402-supported-configurations-v1">Get
     *     B402 Supported Configurations V1 Documentation</a>
     */
    public ApiResponse<GetB402SupportedConfigurationsV1Response> getB402SupportedConfigurationsV1(
            GetB402SupportedConfigurationsV1Request getB402SupportedConfigurationsV1Request,
            Long recvWindow,
            String nonce)
            throws ApiException {
        return b402PaymentsApi.getB402SupportedConfigurationsV1(
                getB402SupportedConfigurationsV1Request, recvWindow, nonce);
    }

    /**
     * Get B402 Supported Configurations V2 Return the live x402 V2 payment kinds available to the
     * authenticated Developer Portal project. Use the result to construct HTTP 402 payment
     * requirements. Copy the selected &#x60;extra&#x60; object verbatim and refresh cached
     * configuration periodically.
     *
     * @param getB402SupportedConfigurationsV2Request (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetB402SupportedConfigurationsV2Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Supported configurations returned, or a B402 business error envelope. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains invalid Web3 API credentials. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. Check the API Key&#39;s B402 Payments permission, IP whitelist, and endpoint allowlist. </td><td>  -  </td></tr>
     * <tr><td> 429 </td><td> Rate limit exceeded. </td><td>  -  </td></tr>
     * <tr><td> 503 </td><td> B402 is temporarily unavailable. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/b402-payments#get-b402-supported-configurations-v2">Get
     *     B402 Supported Configurations V2 Documentation</a>
     */
    public ApiResponse<GetB402SupportedConfigurationsV2Response> getB402SupportedConfigurationsV2(
            GetB402SupportedConfigurationsV2Request getB402SupportedConfigurationsV2Request,
            Long recvWindow,
            String nonce)
            throws ApiException {
        return b402PaymentsApi.getB402SupportedConfigurationsV2(
                getB402SupportedConfigurationsV2Request, recvWindow, nonce);
    }

    /**
     * Settle B402 Payment V1 Legacy V1 on-chain settlement endpoint. New integrations should use
     * V2. This operation can move real funds and is irreversible. V1 additionally returns
     * &#x60;confirmations&#x60; in the settlement result.
     *
     * @param settleB402PaymentV1Request (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;SettleB402PaymentV1Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Legacy settlement result or a B402 business error envelope. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains invalid Web3 API credentials. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. Check the API Key&#39;s B402 Payments permission, IP whitelist, and endpoint allowlist. </td><td>  -  </td></tr>
     * <tr><td> 429 </td><td> Rate limit exceeded. </td><td>  -  </td></tr>
     * <tr><td> 503 </td><td> B402 is temporarily unavailable. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/b402-payments#settle-b402-payment-v1">Settle
     *     B402 Payment V1 Documentation</a>
     */
    public ApiResponse<SettleB402PaymentV1Response> settleB402PaymentV1(
            SettleB402PaymentV1Request settleB402PaymentV1Request, Long recvWindow, String nonce)
            throws ApiException {
        return b402PaymentsApi.settleB402PaymentV1(settleB402PaymentV1Request, recvWindow, nonce);
    }

    /**
     * Settle B402 Payment V2 Submit a verified x402 V2 authorization on-chain. This operation can
     * move real funds and is irreversible. For &#x60;permit2-upto&#x60;, provide
     * &#x60;settleAmount&#x60; in atomic units. Business failure is returned as HTTP 200 with
     * &#x60;data.success&#x3D;false&#x60;; reconcile any non-empty transaction hash before
     * retrying.
     *
     * @param settleB402PaymentV2Request (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;SettleB402PaymentV2Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Settlement result, or a B402 business error envelope. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains invalid Web3 API credentials. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. Check the API Key&#39;s B402 Payments permission, IP whitelist, and endpoint allowlist. </td><td>  -  </td></tr>
     * <tr><td> 429 </td><td> Rate limit exceeded. </td><td>  -  </td></tr>
     * <tr><td> 503 </td><td> B402 is temporarily unavailable. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/b402-payments#settle-b402-payment-v2">Settle
     *     B402 Payment V2 Documentation</a>
     */
    public ApiResponse<SettleB402PaymentV2Response> settleB402PaymentV2(
            SettleB402PaymentV2Request settleB402PaymentV2Request, Long recvWindow, String nonce)
            throws ApiException {
        return b402PaymentsApi.settleB402PaymentV2(settleB402PaymentV2Request, recvWindow, nonce);
    }

    /**
     * Verify B402 Payment V1 Legacy V1 off-chain verification endpoint. New integrations should use
     * V2. Portal identity is resolved from the API Key project, so &#x60;merchantId&#x60; is
     * omitted from the external request.
     *
     * @param verifyB402PaymentV1Request (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;VerifyB402PaymentV1Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Legacy verification result or a B402 business error envelope. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains invalid Web3 API credentials. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. Check the API Key&#39;s B402 Payments permission, IP whitelist, and endpoint allowlist. </td><td>  -  </td></tr>
     * <tr><td> 429 </td><td> Rate limit exceeded. </td><td>  -  </td></tr>
     * <tr><td> 503 </td><td> B402 is temporarily unavailable. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/b402-payments#verify-b402-payment-v1">Verify
     *     B402 Payment V1 Documentation</a>
     */
    public ApiResponse<VerifyB402PaymentV1Response> verifyB402PaymentV1(
            VerifyB402PaymentV1Request verifyB402PaymentV1Request, Long recvWindow, String nonce)
            throws ApiException {
        return b402PaymentsApi.verifyB402PaymentV1(verifyB402PaymentV1Request, recvWindow, nonce);
    }

    /**
     * Verify B402 Payment V2 Validate an x402 V2 payment authorization off-chain without spending
     * funds or broadcasting a transaction. Portal identity is resolved from the authenticated API
     * Key project; omit &#x60;merchantId&#x60;. A validation failure is returned as HTTP 200 with
     * &#x60;data.isValid&#x3D;false&#x60;.
     *
     * @param verifyB402PaymentV2Request (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;VerifyB402PaymentV2Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Verification result, or a B402 business error envelope. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains invalid Web3 API credentials. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. Check the API Key&#39;s B402 Payments permission, IP whitelist, and endpoint allowlist. </td><td>  -  </td></tr>
     * <tr><td> 429 </td><td> Rate limit exceeded. </td><td>  -  </td></tr>
     * <tr><td> 503 </td><td> B402 is temporarily unavailable. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/b402-payments#verify-b402-payment-v2">Verify
     *     B402 Payment V2 Documentation</a>
     */
    public ApiResponse<VerifyB402PaymentV2Response> verifyB402PaymentV2(
            VerifyB402PaymentV2Request verifyB402PaymentV2Request, Long recvWindow, String nonce)
            throws ApiException {
        return b402PaymentsApi.verifyB402PaymentV2(verifyB402PaymentV2Request, recvWindow, nonce);
    }

    /**
     * Get DeFi Positions Query DeFi positions for one or more wallet addresses on BSC. Returns
     * protocol-level position summaries with token breakdowns. Optionally filter by specific chains
     * via &#x60;binanceChainIds&#x60;. Position coverage is wider than the protocol list used by
     * data queries and transaction building — see [Supported Chains &amp;
     * Protocols](../supported-chains) for the difference.
     *
     * @param getDeFiPositionsRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetDeFiPositionsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> DeFi positions returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/defi-data#get-de-fi-positions">Get
     *     DeFi Positions Documentation</a>
     */
    public ApiResponse<GetDeFiPositionsResponse> getDeFiPositions(
            GetDeFiPositionsRequest getDeFiPositionsRequest, Long recvWindow, String nonce)
            throws ApiException {
        return defiDataApi.getDeFiPositions(getDeFiPositionsRequest, recvWindow, nonce);
    }

    /**
     * Get Investment Detail Get detailed information for a specific DeFi investment product,
     * including APY, TVL, supported tokens (asset / reward / LP / borrow), pool address, fee rate,
     * and investability.
     *
     * @param getInvestmentDetailRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetInvestmentDetailResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Investment detail returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/defi-data#get-investment-detail">Get
     *     Investment Detail Documentation</a>
     */
    public ApiResponse<GetInvestmentDetailResponse> getInvestmentDetail(
            GetInvestmentDetailRequest getInvestmentDetailRequest, Long recvWindow, String nonce)
            throws ApiException {
        return defiDataApi.getInvestmentDetail(getInvestmentDetailRequest, recvWindow, nonce);
    }

    /**
     * Get Protocol Detail Get detailed information for a specific DeFi protocol, including
     * description, highlights, CertiK security scores, team, fundraising, social links, and FAQ.
     *
     * @param getProtocolDetailRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetProtocolDetailResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Protocol detail returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/defi-data#get-protocol-detail">Get
     *     Protocol Detail Documentation</a>
     */
    public ApiResponse<GetProtocolDetailResponse> getProtocolDetail(
            GetProtocolDetailRequest getProtocolDetailRequest, Long recvWindow, String nonce)
            throws ApiException {
        return defiDataApi.getProtocolDetail(getProtocolDetailRequest, recvWindow, nonce);
    }

    /**
     * List DeFi Investments List available DeFi investment products. Filter by protocol, chain,
     * investment type, or contract address. Results are paginated and sortable.
     *
     * @param listDeFiInvestmentsRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;ListDeFiInvestmentsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Investment list returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/defi-data#list-de-fi-investments">List
     *     DeFi Investments Documentation</a>
     */
    public ApiResponse<ListDeFiInvestmentsResponse> listDeFiInvestments(
            ListDeFiInvestmentsRequest listDeFiInvestmentsRequest, Long recvWindow, String nonce)
            throws ApiException {
        return defiDataApi.listDeFiInvestments(listDeFiInvestmentsRequest, recvWindow, nonce);
    }

    public ApiResponse<ListDeFiProtocolsResponse> listDeFiProtocols(
            DefiDataApi.ListDeFiProtocolsRequest request) {
        return defiDataApi.listDeFiProtocols(request);
    }

    /**
     * List DeFi Protocols List supported DeFi protocols with optional filtering by chain and
     * investment type. Results are paginated and sortable.
     *
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param listDeFiProtocolsRequest (optional)
     * @return ApiResponse&lt;ListDeFiProtocolsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Protocol list returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/defi-data#list-de-fi-protocols">List
     *     DeFi Protocols Documentation</a>
     */
    public ApiResponse<ListDeFiProtocolsResponse> listDeFiProtocols(
            Long recvWindow, String nonce, ListDeFiProtocolsRequest listDeFiProtocolsRequest)
            throws ApiException {
        return defiDataApi.listDeFiProtocols(recvWindow, nonce, listDeFiProtocolsRequest);
    }

    /**
     * Build DeFi Claim Transaction Build the unsigned claim calldata for one of four claim types —
     * see &#x60;DefiClaimType&#x60; for which companion fields each type requires **and which
     * protocol constraints apply** (e.g. &#x60;REWARD_PROTOCOL&#x60; is not supported for LP
     * protocols; PancakeSwap V3 farming uses &#x60;LP_FEE&#x60;, not
     * &#x60;REWARD_INVESTMENT&#x60;). Returns an ordered &#x60;dataList&#x60; (typically
     * &#x60;[CLAIM]&#x60;). **&#x60;binanceChainId&#x60; resolution rules**: - Normally resolved
     * from &#x60;investmentId&#x60;; the call always executes on that chain. - For claim types
     * other than &#x60;REWARD_PROTOCOL&#x60;, any client-supplied &#x60;binanceChainId&#x60; is
     * **silently ignored** — passing a different chainId will not redirect the claim. -
     * **Exception**: &#x60;REWARD_PROTOCOL&#x60; with no &#x60;investmentId&#x60; — the client MUST
     * pass &#x60;binanceChainId&#x60; (it is the only chain signal). &#x60;tokenAddressList&#x60;
     * optionally narrows the claim scope. Set &#x60;simulate&#x3D;true&#x60; to also receive
     * &#x60;preview&#x60;.
     *
     * @param buildDeFiClaimTransactionRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;BuildDeFiClaimTransactionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Claim transaction calldata returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/defi-transaction#build-de-fi-claim-transaction">Build
     *     DeFi Claim Transaction Documentation</a>
     */
    public ApiResponse<BuildDeFiClaimTransactionResponse> buildDeFiClaimTransaction(
            BuildDeFiClaimTransactionRequest buildDeFiClaimTransactionRequest,
            Long recvWindow,
            String nonce)
            throws ApiException {
        return defiTransactionApi.buildDeFiClaimTransaction(
                buildDeFiClaimTransactionRequest, recvWindow, nonce);
    }

    /**
     * Build DeFi Deposit Transaction Build the unsigned transaction calldata for a DeFi deposit /
     * stake. Returns an ordered &#x60;dataList&#x60; (typically &#x60;[APPROVE, DEPOSIT]&#x60;, or
     * &#x60;[DEPOSIT]&#x60; when the allowance is already sufficient) for the caller to sign and
     * broadcast. The caller does NOT pass &#x60;binanceChainId&#x60; — the service resolves it from
     * &#x60;investmentId&#x60;. Set &#x60;simulate&#x3D;true&#x60; to also receive a
     * &#x60;preview&#x60; (projected balance change, estimated gas, and lending health-factor
     * change) without broadcasting.
     *
     * @param buildDeFiDepositTransactionRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;BuildDeFiDepositTransactionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Deposit transaction calldata returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/defi-transaction#build-de-fi-deposit-transaction">Build
     *     DeFi Deposit Transaction Documentation</a>
     */
    public ApiResponse<BuildDeFiDepositTransactionResponse> buildDeFiDepositTransaction(
            BuildDeFiDepositTransactionRequest buildDeFiDepositTransactionRequest,
            Long recvWindow,
            String nonce)
            throws ApiException {
        return defiTransactionApi.buildDeFiDepositTransaction(
                buildDeFiDepositTransactionRequest, recvWindow, nonce);
    }

    /**
     * Build DeFi Redeem Transaction Build the unsigned transaction calldata for a DeFi redeem /
     * withdraw. Returns an ordered &#x60;dataList&#x60; (typically &#x60;[REDEEM]&#x60; or
     * &#x60;[APPROVE, REDEEM]&#x60;). **Redeem amount is decided by exactly one of
     * &#x60;ratio&#x60; or &#x60;token&#x60;** (mutually exclusive): - &#x60;ratio&#x60; omitted /
     * blank → **exact-amount redeem**: the amount comes from &#x60;token&#x60;
     * (&#x60;tokenAddress&#x60; + &#x60;amount&#x60;); the position is *not* queried.
     * &#x60;token&#x60; is required in this mode (omitting &#x60;token&#x60;, or leaving
     * &#x60;amount&#x60; blank, is rejected with &#x60;40001&#x60;, &#x60;Parameter error&#x60;;
     * both &#x60;ratio&#x60; and &#x60;token&#x60; absent is also rejected with &#x60;40001&#x60;).
     * - &#x60;ratio&#x60; present → **proportional redeem**: must parse as a decimal in &#x60;(0,
     * 1]&#x60;. The service queries the user&#39;s on-chain position under &#x60;investmentId&#x60;
     * and scales each token&#39;s amount by &#x60;ratio&#x60; (floored to the token&#39;s
     * decimals). &#x60;ratio&#x3D;\&quot;1\&quot;&#x60; is a full (max) redeem. In this mode
     * &#x60;token&#x60; is **ignored** — the output tokens and amounts are derived from the
     * position. &#x60;slippageBps&#x60; is the slippage tolerance in basis points (e.g.
     * &#x60;300&#x60; &#x3D; 3%). The caller does NOT pass &#x60;binanceChainId&#x60; — resolved
     * from &#x60;investmentId&#x60;. Set &#x60;simulate&#x3D;true&#x60; to also receive
     * &#x60;preview&#x60;. The response also carries &#x60;redeemDelayDays&#x60; — the redeem
     * waiting period as a &#x60;[min, max]&#x60; day pair (e.g.
     * &#x60;[\&quot;7\&quot;,\&quot;10\&quot;]&#x60; &#x3D; 7–10 days, &#x60;[]&#x60; &#x3D;
     * instant). The wait starts after the redeem tx is confirmed on-chain. See the
     * &#x60;redeemDelayDays&#x60; field on &#x60;DefiTxResponse&#x60;.
     *
     * @param buildDeFiRedeemTransactionRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;BuildDeFiRedeemTransactionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Redeem transaction calldata returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/defi-transaction#build-de-fi-redeem-transaction">Build
     *     DeFi Redeem Transaction Documentation</a>
     */
    public ApiResponse<BuildDeFiRedeemTransactionResponse> buildDeFiRedeemTransaction(
            BuildDeFiRedeemTransactionRequest buildDeFiRedeemTransactionRequest,
            Long recvWindow,
            String nonce)
            throws ApiException {
        return defiTransactionApi.buildDeFiRedeemTransaction(
                buildDeFiRedeemTransactionRequest, recvWindow, nonce);
    }

    /**
     * Build LP Add Transaction Build the unsigned transaction calldata for adding liquidity.
     * &#x60;tokenList&#x60; supports multiple tokens. Returns an ordered &#x60;dataList&#x60;
     * (typically &#x60;[APPROVE, LP_ADD]&#x60;). **Tick range source (provide exactly one group)**:
     * 1. &#x60;nftId&#x60; — append to an existing LP position (reuses its range). 2.
     * &#x60;priceRange&#x60; — percentage band (e.g. &#x60;\&quot;5\&quot;&#x60; &#x3D; ±5%) for a
     * new position. 3. &#x60;tickLower&#x60; + &#x60;tickUpper&#x60; — explicit raw
     * &#x60;int24&#x60; pair for a new position. **Rules**: - If more than one group is supplied,
     * only the highest-priority one above is used and the others are silently ignored (priority:
     * &#x60;nftId&#x60; &gt; &#x60;priceRange&#x60; &gt; explicit tick pair). - If none is
     * supplied, the request is rejected (&#x60;40453&#x60;). - &#x60;tickLower&#x60; /
     * &#x60;tickUpper&#x60; are raw &#x60;int24&#x60; values and MUST be aligned to the pool&#39;s
     * &#x60;tickSpacing&#x60;, otherwise the request is rejected (&#x60;40453&#x60;). - The caller
     * does NOT pass &#x60;binanceChainId&#x60; — resolved from &#x60;investmentId&#x60;.
     *
     * @param buildLpAddTransactionRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;BuildLpAddTransactionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> LP add transaction calldata returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/defi-transaction#build-lp-add-transaction">Build
     *     LP Add Transaction Documentation</a>
     */
    public ApiResponse<BuildLpAddTransactionResponse> buildLpAddTransaction(
            BuildLpAddTransactionRequest buildLpAddTransactionRequest,
            Long recvWindow,
            String nonce)
            throws ApiException {
        return defiTransactionApi.buildLpAddTransaction(
                buildLpAddTransactionRequest, recvWindow, nonce);
    }

    /**
     * Build LP Remove Transaction Build the unsigned transaction calldata for removing liquidity.
     * Removal is by &#x60;nftId&#x60; + &#x60;ratio&#x60; (range &#x60;(0, 1]&#x60;) — no
     * &#x60;tokenList&#x60; is needed; the per-token amounts are derived from the on-chain
     * position. Returns an ordered &#x60;dataList&#x60; (typically &#x60;[LP_REMOVE]&#x60;).
     * &#x60;slippageBps&#x60; is the LP-leg slippage tolerance in basis points. The caller does NOT
     * pass &#x60;binanceChainId&#x60; — resolved from &#x60;investmentId&#x60;.
     *
     * @param buildLpRemoveTransactionRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;BuildLpRemoveTransactionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> LP remove transaction calldata returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/defi-transaction#build-lp-remove-transaction">Build
     *     LP Remove Transaction Documentation</a>
     */
    public ApiResponse<BuildLpRemoveTransactionResponse> buildLpRemoveTransaction(
            BuildLpRemoveTransactionRequest buildLpRemoveTransactionRequest,
            Long recvWindow,
            String nonce)
            throws ApiException {
        return defiTransactionApi.buildLpRemoveTransaction(
                buildLpRemoveTransactionRequest, recvWindow, nonce);
    }

    /**
     * Calculate LP Add Paired Amounts Given a single input token, calculate the paired token amount
     * needed for an LP add. This is a **pure computation endpoint** — it does not touch the chain
     * and does not deduct any fee. Use it before &#x60;/transaction/lp-add&#x60; to size the paired
     * token when only one side is supplied. Tick range source rules are the same as
     * &#x60;/lp-add&#x60; — provide exactly one group: &#x60;nftId&#x60; (existing position),
     * &#x60;priceRange&#x60;, or &#x60;tickLower&#x60;+&#x60;tickUpper&#x60;. - If more than one
     * group is supplied, only the highest-priority one is used and the others are silently ignored
     * (priority: &#x60;nftId&#x60; &gt; &#x60;priceRange&#x60; &gt; explicit tick pair). - If none
     * is supplied, the request is rejected. - The caller does NOT pass &#x60;binanceChainId&#x60; —
     * resolved from &#x60;investmentId&#x60;.
     *
     * @param calculateLpAddPairedAmountsRequest (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;CalculateLpAddPairedAmountsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Paired token amounts returned successfully. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/defi-transaction#calculate-lp-add-paired-amounts">Calculate
     *     LP Add Paired Amounts Documentation</a>
     */
    public ApiResponse<CalculateLpAddPairedAmountsResponse> calculateLpAddPairedAmounts(
            CalculateLpAddPairedAmountsRequest calculateLpAddPairedAmountsRequest,
            Long recvWindow,
            String nonce)
            throws ApiException {
        return defiTransactionApi.calculateLpAddPairedAmounts(
                calculateLpAddPairedAmountsRequest, recvWindow, nonce);
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
     * @param vendor Optional vendor selector. When provided, only the specified vendor is queried
     *     through the single-vendor fast path; the request bypasses the multi-vendor dual-window,
     *     early-return, and price-check logic. Values are case-sensitive and must be one of
     *     &#x60;LiquidMesh&#x60;, &#x60;Pancake&#x60;, or &#x60;Jupiter&#x60;. The vendor must also
     *     support the requested chain. An unsupported value or unavailable vendor/chain returns
     *     &#x60;PARAM_ERROR&#x60; (40001). When omitted, the API queries all applicable vendors in
     *     parallel and returns the aggregated routes. (optional)
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
            Vendor vendor,
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
                vendor,
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

    public ApiResponse<GetLatestBlockHeightResponse> getLatestBlockHeight(
            TransactionApi.GetLatestBlockHeightRequest request) {
        return transactionApi.getLatestBlockHeight(request);
    }

    /**
     * Get Latest Block Height Return the latest block height that the Binance Web3 node has synced
     * to for the specified chain. Callers can use this to monitor node sync progress for risk
     * control and detect when the node lags behind the canonical chain head.
     *
     * @param binanceChainId Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum,
     *     \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana,
     *     \&quot;CT_195\&quot;&#x3D;Tron). (required)
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetLatestBlockHeightResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> Latest block height for the specified chain. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> Unauthorized. The request is missing or contains an invalid API key. </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> Forbidden. The API key does not have permission to access this endpoint. </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Not Found. The requested resource or endpoint does not exist. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/transaction-api#get-latest-block-height">Get
     *     Latest Block Height Documentation</a>
     */
    public ApiResponse<GetLatestBlockHeightResponse> getLatestBlockHeight(
            String binanceChainId, Long recvWindow, String nonce) throws ApiException {
        return transactionApi.getLatestBlockHeight(binanceChainId, recvWindow, nonce);
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
     * Get All Token Balances by Address Return all token balances held by an address on a single
     * chain, with pagination support. Set &#x60;excludeRiskToken&#x3D;true&#x60; to filter out
     * airdrop-risk and honeypot tokens (honeypot detection currently applies only to ETH / BSC /
     * SOL / BASE).
     *
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @param address Wallet address to query. (optional)
     * @param chains Currently only a single chain is supported. Passing multiple comma-separated
     *     chain IDs returns an error; multi-chain support may be added in the future. (optional)
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

    public ApiResponse<GetWebSocketAuthTokenResponse> getWebSocketAuthToken(
            WebSocketApi.GetWebSocketAuthTokenRequest request) {
        return webSocketApi.getWebSocketAuthToken(request);
    }

    /**
     * Get WebSocket Auth Token Get a WebSocket auth token before connecting to the WebSocket stream
     * service.
     *
     * @param recvWindow Allowed time deviation in milliseconds (default: 5000, max: 60000).
     *     (optional)
     * @param nonce Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
     *     (optional)
     * @return ApiResponse&lt;GetWebSocketAuthTokenResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     * @http.response.details
     *     <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> WebSocket auth token returned successfully. </td><td>  -  </td></tr>
     * </table>
     *
     * @see <a
     *     href="https://web3.binance.com/en/dev-docs/catalog/web3-wallet/api/rest-api/web-socket-api#get-web-socket-auth-token">Get
     *     WebSocket Auth Token Documentation</a>
     */
    public ApiResponse<GetWebSocketAuthTokenResponse> getWebSocketAuthToken(
            Long recvWindow, String nonce) throws ApiException {
        return webSocketApi.getWebSocketAuthToken(recvWindow, nonce);
    }
}
