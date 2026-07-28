package com.binance.connector.client.web3_wallet.rest.transaction;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.SimulateTransactionsRequest;
import com.binance.connector.client.web3_wallet.rest.model.SimulateTransactionsResponse;

/** API examples for TransactionApi */
public class SimulateTransactionsExample {
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
     * Simulate Transactions
     *
     * <p>Simulate transaction execution off-chain to predict its outcome before broadcasting. The
     * response includes the predicted execution status, balance changes per affected account/token,
     * and ERC-20 allowance changes (EVM chains). Provide either &#x60;evmTx&#x60; (EVM chains),
     * &#x60;solTx&#x60; (Solana), or &#x60;tronTx&#x60; (Tron \&quot;CT_195\&quot;) matching
     * &#x60;binanceChainId&#x60;. On Tron, &#x60;allowanceChanges&#x60; is returned as an empty
     * array. Note: Metis (chainId 1088) is not supported by this endpoint.
     *
     * @throws ApiException if the Api call fails
     */
    public void simulateTransactionsExample() throws ApiException {
        SimulateTransactionsRequest simulateTransactionsRequest = new SimulateTransactionsRequest();
        simulateTransactionsRequest.binanceChainId("1");
        simulateTransactionsRequest.evmTx(null);
        simulateTransactionsRequest.solTx(null);
        simulateTransactionsRequest.tronTx(null);
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        ApiResponse<SimulateTransactionsResponse> response =
                getApi().simulateTransactions(simulateTransactionsRequest, recvWindow, nonce);
        System.out.println(response.getData());
    }
}
