package com.binance.connector.client.web3_wallet.rest.addressportfolio;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.AddressPortfolioApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetPortfolioSupportedChainsResponse;

/** API examples for AddressPortfolioApi */
public class GetPortfolioSupportedChainsExample {
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
     * Get Portfolio Supported Chains
     *
     * <p>Return the list of blockchains supported by address portfolio analysis.
     *
     * @throws ApiException if the Api call fails
     */
    public void getPortfolioSupportedChainsExample() throws ApiException {
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        AddressPortfolioApi.GetPortfolioSupportedChainsRequest request =
                new AddressPortfolioApi.GetPortfolioSupportedChainsRequest();
        ApiResponse<GetPortfolioSupportedChainsResponse> response =
                getApi().getPortfolioSupportedChains(request);
        System.out.println(response.getData());
    }
}
