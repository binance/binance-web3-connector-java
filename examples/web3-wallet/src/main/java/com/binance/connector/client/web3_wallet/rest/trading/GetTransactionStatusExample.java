package com.binance.connector.client.web3_wallet.rest.trading;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetTransactionStatusResponse;

/** API examples for TradingApi */
public class GetTransactionStatusExample {
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
     * Get Transaction Status
     *
     * <p>Look up the on-chain status of a DEX swap by &#x60;binanceChainId&#x60; +
     * &#x60;txHash&#x60;. Response semantics: - Transaction not found: &#x60;data&#x60; is
     * &#x60;null&#x60; (not HTTP 404). - Transaction failed: &#x60;status&#x3D;failed&#x60; with
     * &#x60;errorMsg&#x60;; aggregator business fields (&#x60;txType&#x60;, &#x60;dexRouter&#x60;,
     * &#x60;fromTokenDetails&#x60;, &#x60;toTokenDetails&#x60;) are &#x60;null&#x60;. - Transaction
     * succeeded: &#x60;status&#x3D;success&#x60; with full token details when an aggregator event
     * is present.
     *
     * @throws ApiException if the Api call fails
     */
    public void getTransactionStatusExample() throws ApiException {
        String binanceChainId = "56";
        String txHash = "0xabc123def4567890abc123def4567890abc123def4567890abc123def4567890";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        TradingApi.GetTransactionStatusRequest request =
                new TradingApi.GetTransactionStatusRequest(binanceChainId, txHash);
        ApiResponse<GetTransactionStatusResponse> response = getApi().getTransactionStatus(request);
        System.out.println(response.getData());
    }
}
