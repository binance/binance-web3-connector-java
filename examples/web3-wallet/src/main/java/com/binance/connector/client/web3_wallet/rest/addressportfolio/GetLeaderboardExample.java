package com.binance.connector.client.web3_wallet.rest.addressportfolio;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.AddressPortfolioApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetLeaderboardResponse;
import com.binance.connector.client.web3_wallet.rest.model.SortBy;
import com.binance.connector.client.web3_wallet.rest.model.TimeFrame;
import com.binance.connector.client.web3_wallet.rest.model.WalletType;

/** API examples for AddressPortfolioApi */
public class GetLeaderboardExample {
    private Web3WalletRestApi api;

    public Web3WalletRestApi getApi() {
        if (api == null) {
            ClientConfiguration clientConfiguration =
                    Web3WalletRestApiUtil.getClientConfiguration();
            SignatureConfiguration signatureConfiguration = new SignatureConfiguration();
            signatureConfiguration.setApiKey("apiKey");
            signatureConfiguration.setSecretKey("secretKey");
            clientConfiguration.setSignatureConfiguration(signatureConfiguration);
            api = new Web3WalletRestApi(clientConfiguration);
        }
        return api;
    }

    /**
     * Get Leaderboard
     *
     * <p>Return a leaderboard of top-performing wallets, with sorting and filtering by PnL, win
     * rate, transaction count, and volume.
     *
     * @throws ApiException if the Api call fails
     */
    public void getLeaderboardExample() throws ApiException {
        String binanceChainId = "1";
        TimeFrame timeFrame = TimeFrame.TIME_FRAME_1;
        SortBy sortBy = SortBy.SORT_BY_1;
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        WalletType walletType = WalletType.WALLET_TYPE_1;
        String minRealizedPnlUsd = "1000";
        String maxRealizedPnlUsd = "50000";
        String minWinRatePercent = "50";
        String maxWinRatePercent = "90";
        String minTxs = "10";
        String maxTxs = "1000";
        String minTxVolume = "5000";
        String maxTxVolume = "1000000";
        String cursor = "";
        String limit = "50";
        AddressPortfolioApi.GetLeaderboardRequest request =
                new AddressPortfolioApi.GetLeaderboardRequest(binanceChainId, timeFrame, sortBy);
        ApiResponse<GetLeaderboardResponse> response = getApi().getLeaderboard(request);
        System.out.println(response.getData());
    }
}
