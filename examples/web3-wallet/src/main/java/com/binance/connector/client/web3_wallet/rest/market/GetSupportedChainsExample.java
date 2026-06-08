package com.binance.connector.client.web3_wallet.rest.market;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.MarketApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetSupportedChainsResponse;

/** API examples for MarketApi */
public class GetSupportedChainsExample {
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
     * Get Supported Chains
     *
     * <p>Return the list of blockchains supported by the market service.
     *
     * @throws ApiException if the Api call fails
     */
    public void getSupportedChainsExample() throws ApiException {
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        MarketApi.GetSupportedChainsRequest request = new MarketApi.GetSupportedChainsRequest();
        ApiResponse<GetSupportedChainsResponse> response = getApi().getSupportedChains(request);
        System.out.println(response.getData());
    }
}
