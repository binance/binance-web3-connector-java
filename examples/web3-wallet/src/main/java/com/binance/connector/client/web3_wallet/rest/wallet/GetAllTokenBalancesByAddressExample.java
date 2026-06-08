package com.binance.connector.client.web3_wallet.rest.wallet;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.WalletApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetAllTokenBalancesByAddressResponse;

/** API examples for WalletApi */
public class GetAllTokenBalancesByAddressExample {
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
     * Get All Token Balances by Address
     *
     * <p>Return all token balances held by an address across one or more chains, with pagination
     * support. Set &#x60;excludeRiskToken&#x3D;true&#x60; to filter out airdrop-risk and honeypot
     * tokens (honeypot detection currently applies only to ETH / BSC / SOL / BASE).
     *
     * @throws ApiException if the Api call fails
     */
    public void getAllTokenBalancesByAddressExample() throws ApiException {
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        String address = "0xed0c6079229e2d407672a117c22b62064f4a4312";
        String chains = "1,56";
        Boolean excludeRiskToken = true;
        Long page = 1L;
        Integer pageSize = 20;
        WalletApi.GetAllTokenBalancesByAddressRequest request =
                new WalletApi.GetAllTokenBalancesByAddressRequest();
        ApiResponse<GetAllTokenBalancesByAddressResponse> response =
                getApi().getAllTokenBalancesByAddress(request);
        System.out.println(response.getData());
    }
}
