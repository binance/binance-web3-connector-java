package com.binance.connector.client.web3_wallet.rest.trading;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.ApproveTransaction;
import com.binance.connector.client.web3_wallet.rest.model.AutoSlippage;
import com.binance.connector.client.web3_wallet.rest.model.BuildSwapTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.GasLevel;

/** API examples for TradingApi */
public class BuildSwapTransactionExample {
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
     * Build Swap Transaction
     *
     * <p>Build the on-chain swap calldata for a previously quoted route. The request is matched
     * against the cached quote by &#x60;quoteId&#x60; (TTL ~30s); if the entry has expired,
     * &#x60;QUOTE_EXPIRED&#x60; (40401) is returned, and if the request parameters disagree with
     * the cached quote, &#x60;SWAP_QUOTE_MISMATCH&#x60; (40462) is returned.
     *
     * @throws ApiException if the Api call fails
     */
    public void buildSwapTransactionExample() throws ApiException {
        String binanceChainId = "56";
        String amount = "1000000";
        String fromTokenAddress = "0x55d398326f99059fF775485246999027B3197955";
        String toTokenAddress = "0x8AC76a51cc950d9822D68b83fE1Ad97B32Cd580d";
        String userWalletAddress = "0xd8dA6BF26964aF9D7eEd9e03E53415D37aA96045";
        String quoteId = "a1b2c3d4e5f64a8b9c0d1e2f3a4b5c6d";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        String slippagePercent = "0.5";
        ApproveTransaction approveTransaction = ApproveTransaction.TRUE;
        String approveAmount = "1000000";
        String gasLimit = "200000";
        GasLevel gasLevel = GasLevel.slow;
        String priceImpactProtectionPercent = "90";
        AutoSlippage autoSlippage = AutoSlippage.TRUE;
        String maxAutoSlippagePercent = "3";
        String computeUnitLimit = "1400000";
        String computeUnitPrice = "1000";
        String tips = "0.001";
        String feePercent = "1.5";
        String fromTokenReferrerWalletAddress = "0xCbF2B6E6e3D7e9e4e4e4e4e4e4e4e4e4e4e4e4e4";
        String toTokenReferrerWalletAddress = "0xCbF2B6E6e3D7e9e4e4e4e4e4e4e4e4e4e4e4e4e4";
        TradingApi.BuildSwapTransactionRequest request =
                new TradingApi.BuildSwapTransactionRequest(
                        binanceChainId,
                        amount,
                        fromTokenAddress,
                        toTokenAddress,
                        userWalletAddress,
                        quoteId);
        ApiResponse<BuildSwapTransactionResponse> response = getApi().buildSwapTransaction(request);
        System.out.println(response.getData());
    }
}
