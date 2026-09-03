package com.binance.connector.client.web3_wallet.rest.websocket;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.api.WebSocketApi;
import com.binance.connector.client.web3_wallet.rest.model.GetWebSocketAuthTokenResponse;

/** API examples for WebSocketApi */
public class GetWebSocketAuthTokenExample {
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
     * Get WebSocket Auth Token
     *
     * <p>Get a WebSocket auth token before connecting to the WebSocket stream service.
     *
     * @throws ApiException if the Api call fails
     */
    public void getWebSocketAuthTokenExample() throws ApiException {
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        WebSocketApi.GetWebSocketAuthTokenRequest request =
                new WebSocketApi.GetWebSocketAuthTokenRequest();
        ApiResponse<GetWebSocketAuthTokenResponse> response =
                getApi().getWebSocketAuthToken(request);
        System.out.println(response.getData());
    }
}
