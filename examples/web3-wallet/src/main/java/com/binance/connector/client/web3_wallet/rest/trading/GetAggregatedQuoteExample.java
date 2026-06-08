package com.binance.connector.client.web3_wallet.rest.trading;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetAggregatedQuoteResponse;

/** API examples for TradingApi */
public class GetAggregatedQuoteExample {
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
     * Get Aggregated Quote
     *
     * <p>Query multiple DEX vendors in parallel and return the priced routes sorted by
     * &#x60;toTokenAmount&#x60; (descending). Each route carries an independent &#x60;quoteId&#x60;
     * (TTL ~30s) that the swap endpoint consumes to construct calldata for the chosen route.
     *
     * @throws ApiException if the Api call fails
     */
    public void getAggregatedQuoteExample() throws ApiException {
        String binanceChainId = "56";
        String amount = "1000000";
        String fromTokenAddress = "0x55d398326f99059fF775485246999027B3197955";
        String toTokenAddress = "0x8AC76a51cc950d9822D68b83fE1Ad97B32Cd580d";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        TradingApi.GetAggregatedQuoteRequest request =
                new TradingApi.GetAggregatedQuoteRequest(
                        binanceChainId, amount, fromTokenAddress, toTokenAddress);
        ApiResponse<GetAggregatedQuoteResponse> response = getApi().getAggregatedQuote(request);
        System.out.println(response.getData());
    }
}
