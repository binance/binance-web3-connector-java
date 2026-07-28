package com.binance.connector.client.web3_wallet.rest.generaldata;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenPriceResponse;

/** API examples for GeneralDataApi */
public class GetTokenPriceExample {
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
     * Get Token Price
     *
     * <p>Get the latest price for tokens. Supports batch queries, up to 100 tokens per request.
     *
     * @throws ApiException if the Api call fails
     */
    public void getTokenPriceExample() throws ApiException {
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        GeneralDataApi.GetTokenPriceRequest request = new GeneralDataApi.GetTokenPriceRequest();
        ApiResponse<GetTokenPriceResponse> response = getApi().getTokenPrice(request);
        System.out.println(response.getData());
    }
}
