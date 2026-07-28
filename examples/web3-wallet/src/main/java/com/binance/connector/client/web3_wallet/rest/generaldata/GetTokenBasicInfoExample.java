package com.binance.connector.client.web3_wallet.rest.generaldata;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenBasicInfoResponse;

/** API examples for GeneralDataApi */
public class GetTokenBasicInfoExample {
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
     * Get Token Basic Info
     *
     * <p>Return basic metadata for a token: name, symbol, logo, decimals, creator address, creation
     * time, and tag info.
     *
     * @throws ApiException if the Api call fails
     */
    public void getTokenBasicInfoExample() throws ApiException {
        String binanceChainId = "1";
        String tokenContractAddress = "0xdac17f958d2ee523a2206206994597c13d831ec7";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        GeneralDataApi.GetTokenBasicInfoRequest request =
                new GeneralDataApi.GetTokenBasicInfoRequest(binanceChainId, tokenContractAddress);
        ApiResponse<GetTokenBasicInfoResponse> response = getApi().getTokenBasicInfo(request);
        System.out.println(response.getData());
    }
}
