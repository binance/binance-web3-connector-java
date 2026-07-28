package com.binance.connector.client.web3_wallet.rest.trading;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.SubmitRfqOrderRequest;
import com.binance.connector.client.web3_wallet.rest.model.SubmitRfqOrderResponse;

/** API examples for TradingApi */
public class SubmitRfqOrderExample {
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
     * Submit RFQ Order
     *
     * <p>Submit a signed RFQ order to the backend for on-chain settlement via the corresponding
     * vendor relayer. Only used when &#x60;executionMode&#x3D;RFQ&#x60; (equity / RWA tokens such
     * as Ondo and BStock). **Flow**: &#x60;GET /quote&#x60; → pick an RFQ route → &#x60;GET
     * /swap&#x60; → sign &#x60;rfq.typedDataToSign&#x60; with EIP-712
     * (&#x60;eth_signTypedData_v4&#x60;) → call this endpoint → poll &#x60;GET
     * /order/{orderId}&#x60; until &#x60;FILLED&#x60; or &#x60;FAILED&#x60;. **Idempotency**:
     * Submitting with the same &#x60;requestId&#x60; within 30 minutes returns the original result
     * without re-calling the vendor. Use a new UUID for each distinct order; reuse the same UUID
     * when retrying.
     *
     * @throws ApiException if the Api call fails
     */
    public void submitRfqOrderExample() throws ApiException {
        SubmitRfqOrderRequest submitRfqOrderRequest = new SubmitRfqOrderRequest();
        submitRfqOrderRequest.requestId("550e8400-e29b-41d4-a716-446655440000");
        submitRfqOrderRequest.userSignature("0x1234abcd...5678ef");
        submitRfqOrderRequest.vendor("PcsXRfq");
        submitRfqOrderRequest.quoteId("a1b2c3d4e5f64a8b9c0d1e2f3a4b5c6d");
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        ApiResponse<SubmitRfqOrderResponse> response =
                getApi().submitRfqOrder(submitRfqOrderRequest, recvWindow, nonce);
        System.out.println(response.getData());
    }
}
