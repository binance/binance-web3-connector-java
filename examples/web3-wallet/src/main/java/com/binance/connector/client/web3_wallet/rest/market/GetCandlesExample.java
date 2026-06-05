package com.binance.connector.client.web3_wallet.rest.market;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.MarketApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetCandlesResponse;

/** API examples for MarketApi */
public class GetCandlesExample {
    private Web3WalletRestApi api;

    public Web3WalletRestApi getApi() {
        if (api == null) {
            ClientConfiguration clientConfiguration =
                    Web3WalletRestApiUtil.getClientConfiguration();
            SignatureConfiguration signatureConfiguration = new SignatureConfiguration();
            signatureConfiguration.setApiKey("apiKey");
            signatureConfiguration.setPrivateKey("path/to/private.key");
            clientConfiguration.setSignatureConfiguration(signatureConfiguration);
            api = new Web3WalletRestApi(clientConfiguration);
        }
        return api;
    }

    /**
     * Get Candles
     *
     * <p>Return candlestick (K-line) data for a token.
     *
     * @throws ApiException if the Api call fails
     */
    public void getCandlesExample() throws ApiException {
        String binanceChainId = "1";
        String tokenContractAddress = "0xdac17f958d2ee523a2206206994597c13d831ec7";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        String bar = "BAR_1s";
        Long after = 1748600000000L;
        Long before = 1748000000000L;
        Integer limit = 100;
        MarketApi.GetCandlesRequest request =
                new MarketApi.GetCandlesRequest(binanceChainId, tokenContractAddress);
        ApiResponse<GetCandlesResponse> response = getApi().getCandles(request);
        System.out.println(response.getData());
    }
}
