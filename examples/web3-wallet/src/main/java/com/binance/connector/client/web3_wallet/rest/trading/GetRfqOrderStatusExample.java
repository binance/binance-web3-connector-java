package com.binance.connector.client.web3_wallet.rest.trading;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetRfqOrderStatusResponse;

/** API examples for TradingApi */
public class GetRfqOrderStatusExample {
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
     * Get RFQ Order Status
     *
     * <p>Query the settlement status of an RFQ order by its platform &#x60;orderId&#x60; (returned
     * by &#x60;POST /order/submit&#x60;). Poll this endpoint until &#x60;status&#x60; reaches a
     * terminal state: &#x60;FILLED&#x60; (settled on-chain) or &#x60;FAILED&#x60; (settlement
     * failed).
     *
     * @throws ApiException if the Api call fails
     */
    public void getRfqOrderStatusExample() throws ApiException {
        String orderId = "oc-o-abc123def456";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        TradingApi.GetRfqOrderStatusRequest request =
                new TradingApi.GetRfqOrderStatusRequest(orderId);
        ApiResponse<GetRfqOrderStatusResponse> response = getApi().getRfqOrderStatus(request);
        System.out.println(response.getData());
    }
}
