package com.binance.connector.client.web3_wallet.rest.wallet;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenBalancesByAddressRequest;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenBalancesByAddressResponse;

/** API examples for WalletApi */
public class GetTokenBalancesByAddressExample {
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
     * Get Token Balances by Address
     *
     * <p>Return token balances for a specific list of (chain, contract) pairs. Up to 20 entries per
     * request. Set &#x60;excludeRiskToken&#x3D;\&quot;0\&quot;&#x60; to exclude risk-flagged tokens
     * (default), or &#x60;\&quot;1\&quot;&#x60; to include them.
     *
     * @throws ApiException if the Api call fails
     */
    public void getTokenBalancesByAddressExample() throws ApiException {
        GetTokenBalancesByAddressRequest getTokenBalancesByAddressRequest =
                new GetTokenBalancesByAddressRequest();
        getTokenBalancesByAddressRequest.address("0x50c476a139aab23fdaf9bca12614cdd54a4244e3");
        getTokenBalancesByAddressRequest.tokenContractAddresses(null);
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        ApiResponse<GetTokenBalancesByAddressResponse> response =
                getApi().getTokenBalancesByAddress(
                                getTokenBalancesByAddressRequest, recvWindow, nonce);
        System.out.println(response.getData());
    }
}
