package com.binance.connector.client.web3_wallet.rest.wallet;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.WalletApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetTransactionsByAddressResponse;

/** API examples for WalletApi */
public class GetTransactionsByAddressExample {
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
     * Get Transactions by Address
     *
     * <p>Return on-chain transaction history for a wallet address across one or more chains.
     * Results are limited to the most recent 6 months and sorted by time (descending). Supports
     * cursor pagination, time-range filtering, and token-contract filtering.
     *
     * @throws ApiException if the Api call fails
     */
    public void getTransactionsByAddressExample() throws ApiException {
        String address = "0xd8dA6BF26964aF9D7eEd9e03E53415D37aA96045";
        String chains = "1,56";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        String tokenContractAddress = "0xdAC17F958D2ee523a2206206994597C13D831ec7";
        Long begin = 1746000000000L;
        Long end = 1748601600000L;
        String cursor = "eyJ0aW1lIjoxNzQ4NjAwMDAwMDAwLCJpZCI6MTIzfQ==";
        Integer limit = 20;
        WalletApi.GetTransactionsByAddressRequest request =
                new WalletApi.GetTransactionsByAddressRequest(address, chains);
        ApiResponse<GetTransactionsByAddressResponse> response =
                getApi().getTransactionsByAddress(request);
        System.out.println(response.getData());
    }
}
