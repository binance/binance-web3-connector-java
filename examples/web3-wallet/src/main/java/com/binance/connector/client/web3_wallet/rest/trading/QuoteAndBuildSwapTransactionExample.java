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
import com.binance.connector.client.web3_wallet.rest.model.GasLevel;
import com.binance.connector.client.web3_wallet.rest.model.QuoteAndBuildSwapTransactionResponse;
import com.binance.connector.client.web3_wallet.rest.model.Vendor;

/** API examples for TradingApi */
public class QuoteAndBuildSwapTransactionExample {
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
     * Quote and Build Swap Transaction (Flash API)
     *
     * <p>Combines quoting and swap-transaction construction into a single call. Unlike the two-step
     * &#x60;/quote&#x60; + &#x60;/swap&#x60; flow, this endpoint does not require a prior
     * &#x60;/quote&#x60; call or a &#x60;quoteId&#x60; — it returns the executable calldata /
     * swapTransaction directly, eliminating one HTTP round-trip. Use this endpoint for
     * latency-sensitive trading when the vendor is known upfront. The response shape is identical
     * to &#x60;/swap&#x60;, so clients can reuse the same response parsing logic for both
     * endpoints.
     *
     * @throws ApiException if the Api call fails
     */
    public void quoteAndBuildSwapTransactionExample() throws ApiException {
        String binanceChainId = "56";
        String amount = "1000000";
        String fromTokenAddress = "0x55d398326f99059fF775485246999027B3197955";
        String toTokenAddress = "0x8AC76a51cc950d9822D68b83fE1Ad97B32Cd580d";
        String userWalletAddress = "0xd8dA6BF26964aF9D7eEd9e03E53415D37aA96045";
        Vendor vendor = Vendor.LiquidMesh;
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
        TradingApi.QuoteAndBuildSwapTransactionRequest request =
                new TradingApi.QuoteAndBuildSwapTransactionRequest(
                        binanceChainId,
                        amount,
                        fromTokenAddress,
                        toTokenAddress,
                        userWalletAddress,
                        vendor);
        ApiResponse<QuoteAndBuildSwapTransactionResponse> response =
                getApi().quoteAndBuildSwapTransaction(request);
        System.out.println(response.getData());
    }
}
