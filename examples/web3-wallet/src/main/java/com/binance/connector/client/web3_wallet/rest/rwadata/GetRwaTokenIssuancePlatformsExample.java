package com.binance.connector.client.web3_wallet.rest.rwadata;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.RwaDataApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetRwaTokenIssuancePlatformsResponse;
import com.binance.connector.client.web3_wallet.rest.model.PlatformId;

/** API examples for RwaDataApi */
public class GetRwaTokenIssuancePlatformsExample {
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
     * Get RWA Token Issuance Platforms
     *
     * <p>Return the list of supported RWA token issuance platforms and their basic info.
     *
     * @throws ApiException if the Api call fails
     */
    public void getRwaTokenIssuancePlatformsExample() throws ApiException {
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        PlatformId platformId = PlatformId.ondo;
        RwaDataApi.GetRwaTokenIssuancePlatformsRequest request =
                new RwaDataApi.GetRwaTokenIssuancePlatformsRequest();
        ApiResponse<GetRwaTokenIssuancePlatformsResponse> response =
                getApi().getRwaTokenIssuancePlatforms(request);
        System.out.println(response.getData());
    }
}
