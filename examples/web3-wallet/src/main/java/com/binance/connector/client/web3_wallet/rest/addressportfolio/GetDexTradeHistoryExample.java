package com.binance.connector.client.web3_wallet.rest.addressportfolio;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.AddressPortfolioApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetDexTradeHistoryResponse;
import com.binance.connector.client.web3_wallet.rest.model.OrderType;

/** API examples for AddressPortfolioApi */
public class GetDexTradeHistoryExample {
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
     * Get DEX Trade History
     *
     * <p>Return swap trade history for a specific address. Supports filtering by time range, token,
     * and trade type.
     *
     * @throws ApiException if the Api call fails
     */
    public void getDexTradeHistoryExample() throws ApiException {
        String binanceChainId = "1";
        String walletAddress = "0x28c6c06298d514db089934071355e5743bf21d60";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        String begin = "1714000000000";
        String end = "1748601600000";
        String tokenContractAddress = "0x6982508145454ce325ddbe47a25d4ec3d2311933";
        OrderType type = OrderType.TYPE_1;
        String cursor = "";
        String limit = "20";
        AddressPortfolioApi.GetDexTradeHistoryRequest request =
                new AddressPortfolioApi.GetDexTradeHistoryRequest(binanceChainId, walletAddress);
        ApiResponse<GetDexTradeHistoryResponse> response = getApi().getDexTradeHistory(request);
        System.out.println(response.getData());
    }
}
