package com.binance.connector.client.web3_wallet.rest.rwadata;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.RwaDataApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.PlatformId;
import com.binance.connector.client.web3_wallet.rest.model.SearchRwaTokenResponse;

/** API examples for RwaDataApi */
public class SearchRwaTokenExample {
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
     * Search RWA Token
     *
     * <p>Search RWA tokens by keyword or contract address.
     *
     * @throws ApiException if the Api call fails
     */
    public void searchRwaTokenExample() throws ApiException {
        String keyword = "NVDA";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        PlatformId platformId = PlatformId.ondo;
        RwaDataApi.SearchRwaTokenRequest request = new RwaDataApi.SearchRwaTokenRequest(keyword);
        ApiResponse<SearchRwaTokenResponse> response = getApi().searchRwaToken(request);
        System.out.println(response.getData());
    }
}
