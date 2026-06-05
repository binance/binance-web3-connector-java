package com.binance.connector.client.web3_wallet.rest.trading;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetErc20ApproveTransactionResponse;

/** API examples for TradingApi */
public class GetErc20ApproveTransactionExample {
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
     * Get ERC-20 Approve Transaction
     *
     * <p>Build the on-chain transaction data needed to approve the DEX router to spend a user&#39;s
     * ERC-20 token before a swap. Calldata is encoded per the ERC-20 ABI standard
     * (&#x60;approve()&#x60; selector + spender + amount).
     *
     * @throws ApiException if the Api call fails
     */
    public void getErc20ApproveTransactionExample() throws ApiException {
        String binanceChainId = "1";
        String tokenContractAddress = "0xdAC17F958D2ee523a2206206994597C13D831ec7";
        String approveAmount = "1000000";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        TradingApi.GetErc20ApproveTransactionRequest request =
                new TradingApi.GetErc20ApproveTransactionRequest(
                        binanceChainId, tokenContractAddress, approveAmount);
        ApiResponse<GetErc20ApproveTransactionResponse> response =
                getApi().getErc20ApproveTransaction(request);
        System.out.println(response.getData());
    }
}
