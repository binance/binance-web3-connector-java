package com.binance.connector.client.web3_wallet.rest.transaction;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.TransactionApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetBroadcastOrdersResponse;

/** API examples for TransactionApi */
public class GetBroadcastOrdersExample {
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
     * Get Broadcast Orders
     *
     * <p>Look up broadcast orders previously submitted via
     * &#x60;/pre-transaction/broadcast-transaction&#x60;. Filter by &#x60;txStatus&#x60; or
     * &#x60;orderId&#x60;, paginate with &#x60;cursor&#x60;.
     *
     * @throws ApiException if the Api call fails
     */
    public void getBroadcastOrdersExample() throws ApiException {
        String address = "0xd8dA6BF26964aF9D7eEd9e03E53415D37aA96045";
        String binanceChainId = "1";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        String txStatus = "success";
        String orderId = "1812345678901234567";
        String cursor = "eyJ0aW1lIjoxNzQ4NjAwMDAwMDAwLCJpZCI6MTIzfQ==";
        Integer limit = 20;
        TransactionApi.GetBroadcastOrdersRequest request =
                new TransactionApi.GetBroadcastOrdersRequest(address, binanceChainId);
        ApiResponse<GetBroadcastOrdersResponse> response = getApi().getBroadcastOrders(request);
        System.out.println(response.getData());
    }
}
