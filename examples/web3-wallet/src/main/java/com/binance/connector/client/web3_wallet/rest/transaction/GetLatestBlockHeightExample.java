package com.binance.connector.client.web3_wallet.rest.transaction;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.TransactionApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetLatestBlockHeightResponse;

/** API examples for TransactionApi */
public class GetLatestBlockHeightExample {
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
     * Get Latest Block Height
     *
     * <p>Return the latest block height that the Binance Web3 node has synced to for the specified
     * chain. Callers can use this to monitor node sync progress for risk control and detect when
     * the node lags behind the canonical chain head.
     *
     * @throws ApiException if the Api call fails
     */
    public void getLatestBlockHeightExample() throws ApiException {
        String binanceChainId = "1";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        TransactionApi.GetLatestBlockHeightRequest request =
                new TransactionApi.GetLatestBlockHeightRequest(binanceChainId);
        ApiResponse<GetLatestBlockHeightResponse> response = getApi().getLatestBlockHeight(request);
        System.out.println(response.getData());
    }
}
