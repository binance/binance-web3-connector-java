package com.binance.connector.client.web3_wallet.rest.wallet;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.WalletApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetWalletSupportedChainsResponse;

/** API examples for WalletApi */
public class GetWalletSupportedChainsExample {
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
     * Get Wallet Supported Chains
     *
     * <p>Return blockchain networks for which the Wallet service can return balances. The supported
     * list is dynamically configured server-side and may change over time. Pass
     * &#x60;binanceChainId&#x60; to filter to a single chain; omit to get the full list.
     *
     * @throws ApiException if the Api call fails
     */
    public void getWalletSupportedChainsExample() throws ApiException {
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        String binanceChainId = "1";
        WalletApi.GetWalletSupportedChainsRequest request =
                new WalletApi.GetWalletSupportedChainsRequest();
        ApiResponse<GetWalletSupportedChainsResponse> response =
                getApi().getWalletSupportedChains(request);
        System.out.println(response.getData());
    }
}
