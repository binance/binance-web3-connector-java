package com.binance.connector.client.web3_wallet.rest.trading;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.AutoSlippage;
import com.binance.connector.client.web3_wallet.rest.model.BinanceChainId;
import com.binance.connector.client.web3_wallet.rest.model.BuildSolanaSwapInstructionsResponse;
import com.binance.connector.client.web3_wallet.rest.model.GasLevel;

/** API examples for TradingApi */
public class BuildSolanaSwapInstructionsExample {
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
     * Build Solana Swap Instructions
     *
     * <p>Solana-only counterpart to &#x60;/swap&#x60;. Shares the full quote → route → vendor
     * &#x60;buildSwapTx&#x60; → priceImpact → minReceive → instruction-assembly pipeline; the only
     * difference is the response: instead of returning a signed-and-serialized base64 transaction,
     * this endpoint returns the **uncompiled** instruction list plus the address-lookup-table (ALT)
     * address list, leaving v0-transaction compilation, signing, and submission to the caller. Use
     * this when the caller needs to: - prepend / append their own instructions (e.g. fee splitting,
     * custom logging) before signing; - reuse the platform-curated route, slippage, PS-variant
     * rewriting, ALT injection, ComputeBudget overwrite, and ATA batching while still controlling
     * the final wire format. Only supports &#x60;binanceChainId&#x3D;CT_501&#x60; (Solana). Other
     * chains return &#x60;CHAIN_NOT_SUPPORTED&#x60; (40411). Parameters mirror the Solana subset of
     * &#x60;/swap&#x60; (no EVM-only &#x60;approveTransaction&#x60; / &#x60;approveAmount&#x60; /
     * &#x60;gasLimit&#x60;).
     *
     * @throws ApiException if the Api call fails
     */
    public void buildSolanaSwapInstructionsExample() throws ApiException {
        BinanceChainId binanceChainId = BinanceChainId.CT_501;
        String amount = "12000000";
        String fromTokenAddress = "EPjFWdd5AufqSSqeM2qN1xzybapC8G4wEGGkZwyTDt1v";
        String toTokenAddress = "So11111111111111111111111111111111111111112";
        String slippagePercent = "0.5";
        String userWalletAddress = "J5CBzXpcYn6WR2JBah8zU4Yxct985CAFGwXRcFaX2pbS";
        String quoteId = "a1b2c3d4e5f64a8b9c0d1e2f3a4b5c6d";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        String priceImpactProtectionPercent = "90";
        AutoSlippage autoSlippage = AutoSlippage.TRUE;
        String maxAutoSlippagePercent = "3";
        String computeUnitLimit = "1400000";
        String computeUnitPrice = "1000";
        GasLevel gasLevel = GasLevel.slow;
        String tips = "0.001";
        TradingApi.BuildSolanaSwapInstructionsRequest request =
                new TradingApi.BuildSolanaSwapInstructionsRequest(
                        binanceChainId,
                        amount,
                        fromTokenAddress,
                        toTokenAddress,
                        slippagePercent,
                        userWalletAddress,
                        quoteId);
        ApiResponse<BuildSolanaSwapInstructionsResponse> response =
                getApi().buildSolanaSwapInstructions(request);
        System.out.println(response.getData());
    }
}
