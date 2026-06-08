package com.binance.connector.client.web3_wallet.rest.market;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.MarketApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenTradingInfoResponse;

/** API examples for MarketApi */
public class GetTokenTradingInfoExample {
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
     * Get Token Trading Info
     *
     * <p>Get token price and trading data (volume, transactions, market cap, holders, etc.).
     * Supports batch queries for up to 100 tokens.
     *
     * @throws ApiException if the Api call fails
     */
    public void getTokenTradingInfoExample() throws ApiException {
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        MarketApi.GetTokenTradingInfoRequest request = new MarketApi.GetTokenTradingInfoRequest();
        ApiResponse<GetTokenTradingInfoResponse> response = getApi().getTokenTradingInfo(request);
        System.out.println(response.getData());
    }
}
