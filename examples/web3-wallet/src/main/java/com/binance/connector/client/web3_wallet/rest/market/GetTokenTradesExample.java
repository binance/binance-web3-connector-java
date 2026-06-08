package com.binance.connector.client.web3_wallet.rest.market;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.MarketApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenTradesResponse;

/** API examples for MarketApi */
public class GetTokenTradesExample {
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
     * Get Token Trades
     *
     * <p>Return on-chain trade history for a token. Supports tag filtering and wallet address
     * filtering.
     *
     * @throws ApiException if the Api call fails
     */
    public void getTokenTradesExample() throws ApiException {
        String binanceChainId = "1";
        String tokenContractAddress = "0x6982508145454ce325ddbe47a25d4ec3d2311933";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        String cursor = "eyJ0aW1lIjoxNzQ4NjAwMDAwMDAwLCJpZCI6MTIzfQ==";
        Integer limit = 100;
        Integer tagFilter = null;
        String walletAddressFilter = "0x28c6c06298d514db089934071355e5743bf21d60";
        MarketApi.GetTokenTradesRequest request =
                new MarketApi.GetTokenTradesRequest(binanceChainId, tokenContractAddress);
        ApiResponse<GetTokenTradesResponse> response = getApi().getTokenTrades(request);
        System.out.println(response.getData());
    }
}
