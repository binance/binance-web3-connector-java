package com.binance.connector.client.web3_wallet.rest.transaction;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.TransactionApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetTransactionSupportedChainsResponse;

/** API examples for TransactionApi */
public class GetTransactionSupportedChainsExample {
    private Web3WalletRestApi api;

    public Web3WalletRestApi getApi() {
        if (api == null) {
            ClientConfiguration clientConfiguration =
                    Web3WalletRestApiUtil.getClientConfiguration();
            SignatureConfiguration signatureConfiguration = new SignatureConfiguration();
            signatureConfiguration.setApiKey("apiKey");
            signatureConfiguration.setPrivateKey("path/to/private.key");
            clientConfiguration.setSignatureConfiguration(signatureConfiguration);
            api = new Web3WalletRestApi(clientConfiguration);
        }
        return api;
    }

    /**
     * Get Transaction Supported Chains
     *
     * <p>Return the blockchain networks supported by the Transaction service for gas estimation,
     * simulation, and broadcasting. The list is dynamically configured server-side and may change
     * over time.
     *
     * @throws ApiException if the Api call fails
     */
    public void getTransactionSupportedChainsExample() throws ApiException {
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        TransactionApi.GetTransactionSupportedChainsRequest request =
                new TransactionApi.GetTransactionSupportedChainsRequest();
        ApiResponse<GetTransactionSupportedChainsResponse> response =
                getApi().getTransactionSupportedChains(request);
        System.out.println(response.getData());
    }
}
