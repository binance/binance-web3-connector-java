package com.binance.connector.client.web3_wallet.rest.addressportfolio;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.AddressPortfolioApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetAddressPortfolioOverviewResponse;
import com.binance.connector.client.web3_wallet.rest.model.TimeFrame;

/** API examples for AddressPortfolioApi */
public class GetAddressPortfolioOverviewExample {
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
     * Get Address Portfolio Overview
     *
     * <p>Return trading performance overview for an address within the selected time frame,
     * including realized PnL, daily PnL breakdown, win rate, and top 3 profitable tokens.
     *
     * @throws ApiException if the Api call fails
     */
    public void getAddressPortfolioOverviewExample() throws ApiException {
        String binanceChainId = "1";
        String walletAddress = "0x28c6c06298d514db089934071355e5743bf21d60";
        TimeFrame timeFrame = TimeFrame.TIME_FRAME_1;
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        AddressPortfolioApi.GetAddressPortfolioOverviewRequest request =
                new AddressPortfolioApi.GetAddressPortfolioOverviewRequest(
                        binanceChainId, walletAddress, timeFrame);
        ApiResponse<GetAddressPortfolioOverviewResponse> response =
                getApi().getAddressPortfolioOverview(request);
        System.out.println(response.getData());
    }
}
