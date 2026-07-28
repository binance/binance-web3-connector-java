package com.binance.connector.client.web3_wallet.rest.addressportfolio;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.AddressPortfolioApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetTrackedTradesResponse;
import com.binance.connector.client.web3_wallet.rest.model.TrackerType;

/** API examples for AddressPortfolioApi */
public class GetTrackedTradesExample {
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
     * Get Tracked Trades
     *
     * <p>Return the latest swap trades from tracked addresses (smart money, KOL, or custom address
     * list).
     *
     * @throws ApiException if the Api call fails
     */
    public void getTrackedTradesExample() throws ApiException {
        TrackerType trackerType = TrackerType.TRACKER_TYPE_1;
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        String walletAddress =
                "0x28c6c06298d514db089934071355e5743bf21d60,0xd8da6bf26964af9d7eed9e03e53415d37aa96045";
        String tradeType = "0";
        String binanceChainId = "1";
        String minVolume = "100";
        String maxVolume = "100000";
        String minMarketCap = "10000";
        String maxMarketCap = "10000000";
        Boolean isHideRiskToken = true;
        Integer limit = 50;
        AddressPortfolioApi.GetTrackedTradesRequest request =
                new AddressPortfolioApi.GetTrackedTradesRequest(trackerType);
        ApiResponse<GetTrackedTradesResponse> response = getApi().getTrackedTrades(request);
        System.out.println(response.getData());
    }
}
