package com.binance.connector.client.web3_wallet.rest.generaldata;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.SearchTokenResponse;

/** API examples for GeneralDataApi */
public class SearchTokenExample {
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
     * Search Token
     *
     * <p>Search tokens by symbol or contract address.
     *
     * @throws ApiException if the Api call fails
     */
    public void searchTokenExample() throws ApiException {
        String chains = "1,56,CT_501";
        String search = "USDT";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        GeneralDataApi.SearchTokenRequest request =
                new GeneralDataApi.SearchTokenRequest(chains, search);
        ApiResponse<SearchTokenResponse> response = getApi().searchToken(request);
        System.out.println(response.getData());
    }
}
