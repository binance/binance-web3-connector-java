package com.binance.connector.client.web3_wallet.rest.transaction;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.BroadcastTransactionsRequest;
import com.binance.connector.client.web3_wallet.rest.model.BroadcastTransactionsResponse;

/** API examples for TransactionApi */
public class BroadcastTransactionsExample {
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
     * Broadcast Transactions
     *
     * <p>Broadcast a client-signed transaction to the chain via the OnchainOS relay. Returns the
     * transaction hash and an internal &#x60;orderId&#x60; you can use to track on-chain status via
     * the post-transaction service. Optional MEV protection (EVM chains only) routes the
     * transaction through a private mempool to mitigate front-running and sandwich attacks.
     *
     * @throws ApiException if the Api call fails
     */
    public void broadcastTransactionsExample() throws ApiException {
        BroadcastTransactionsRequest broadcastTransactionsRequest =
                new BroadcastTransactionsRequest();
        broadcastTransactionsRequest.binanceChainId("1");
        broadcastTransactionsRequest.signedTransaction(
                "0xf86c808504a817c80082520894d8da6bf26964af9d7eed9e03e53415d37aa96045880de0b6b3a76400008025a0...");
        broadcastTransactionsRequest.address("0xd8dA6BF26964aF9D7eEd9e03E53415D37aA96045");
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        ApiResponse<BroadcastTransactionsResponse> response =
                getApi().broadcastTransactions(broadcastTransactionsRequest, recvWindow, nonce);
        System.out.println(response.getData());
    }
}
