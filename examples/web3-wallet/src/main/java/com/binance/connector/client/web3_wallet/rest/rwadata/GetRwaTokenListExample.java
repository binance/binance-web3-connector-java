package com.binance.connector.client.web3_wallet.rest.rwadata;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.RwaDataApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetRwaTokenListResponse;
import com.binance.connector.client.web3_wallet.rest.model.PlatformId;

/** API examples for RwaDataApi */
public class GetRwaTokenListExample {
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
     * Get RWA Token List
     *
     * <p>Get the list of RWA tokens with underlying asset info. Supports filtering by platform and
     * sector tab.
     *
     * @throws ApiException if the Api call fails
     */
    public void getRwaTokenListExample() throws ApiException {
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        String binanceChainId = "56";
        PlatformId platformId = PlatformId.ondo;
        Integer tabId = 9;
        RwaDataApi.GetRwaTokenListRequest request = new RwaDataApi.GetRwaTokenListRequest();
        ApiResponse<GetRwaTokenListResponse> response = getApi().getRwaTokenList(request);
        System.out.println(response.getData());
    }
}
