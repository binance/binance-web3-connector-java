package com.binance.connector.client.web3_wallet.rest.wallet;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.WalletApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetTransactionDetailByHashResponse;

/** API examples for WalletApi */
public class GetTransactionDetailByHashExample {
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
     * Get Transaction Detail by Hash
     *
     * <p>Look up the full on-chain transaction detail by &#x60;binanceChainId&#x60; +
     * &#x60;txHash&#x60;. Returns one or more entries describing transaction inputs, outputs,
     * internal calls, and token transfers.
     *
     * @throws ApiException if the Api call fails
     */
    public void getTransactionDetailByHashExample() throws ApiException {
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        String binanceChainId = "1";
        String txHash = "0xabc123def4567890abc123def4567890abc123def4567890abc123def4567890";
        String itype = "0";
        WalletApi.GetTransactionDetailByHashRequest request =
                new WalletApi.GetTransactionDetailByHashRequest();
        ApiResponse<GetTransactionDetailByHashResponse> response =
                getApi().getTransactionDetailByHash(request);
        System.out.println(response.getData());
    }
}
