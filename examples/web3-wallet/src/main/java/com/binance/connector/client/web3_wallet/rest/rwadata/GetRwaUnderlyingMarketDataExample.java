package com.binance.connector.client.web3_wallet.rest.rwadata;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.RwaDataApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetRwaUnderlyingMarketDataResponse;

/** API examples for RwaDataApi */
public class GetRwaUnderlyingMarketDataExample {
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
     * Get RWA Underlying Market Data
     *
     * <p>Get market data for the underlying asset of an RWA token.
     *
     * @throws ApiException if the Api call fails
     */
    public void getRwaUnderlyingMarketDataExample() throws ApiException {
        String binanceChainId = "56";
        String tokenContractAddress = "0x8755c5c39b1aa9053a83ac731242a2cf4d04b0fe";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        RwaDataApi.GetRwaUnderlyingMarketDataRequest request =
                new RwaDataApi.GetRwaUnderlyingMarketDataRequest(
                        binanceChainId, tokenContractAddress);
        ApiResponse<GetRwaUnderlyingMarketDataResponse> response =
                getApi().getRwaUnderlyingMarketData(request);
        System.out.println(response.getData());
    }
}
