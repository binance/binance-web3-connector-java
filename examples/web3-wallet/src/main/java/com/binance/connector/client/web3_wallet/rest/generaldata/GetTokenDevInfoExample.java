package com.binance.connector.client.web3_wallet.rest.generaldata;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenDevInfoResponse;

/** API examples for GeneralDataApi */
public class GetTokenDevInfoExample {
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
     * Get Token Dev Info
     *
     * <p>Return developer profile for a token, including historical token launch stats, current
     * holding percentage, and initial funding source.
     *
     * @throws ApiException if the Api call fails
     */
    public void getTokenDevInfoExample() throws ApiException {
        String binanceChainId = "CT_501";
        String tokenContractAddress = "EPjFWdd5AufqSSqeM2qN1xzybapC8G4wEGGkZwyTDt1v";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        GeneralDataApi.GetTokenDevInfoRequest request =
                new GeneralDataApi.GetTokenDevInfoRequest(binanceChainId, tokenContractAddress);
        ApiResponse<GetTokenDevInfoResponse> response = getApi().getTokenDevInfo(request);
        System.out.println(response.getData());
    }
}
