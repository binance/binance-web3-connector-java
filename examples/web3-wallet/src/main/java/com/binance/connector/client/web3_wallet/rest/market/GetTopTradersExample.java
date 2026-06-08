package com.binance.connector.client.web3_wallet.rest.market;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.MarketApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetTopTradersResponse;

/** API examples for MarketApi */
public class GetTopTradersExample {
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
     * Get Top Traders
     *
     * <p>Return the top profit-making addresses for a token, ranked by realized PnL descending.
     * Includes holding amount, average buy/sell price, realized PnL, and funding source. Up to 100
     * records. Pagination is not supported.
     *
     * @throws ApiException if the Api call fails
     */
    public void getTopTradersExample() throws ApiException {
        String binanceChainId = "1";
        String tokenContractAddress = "0x6982508145454ce325ddbe47a25d4ec3d2311933";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        Integer tagFilter = null;
        MarketApi.GetTopTradersRequest request =
                new MarketApi.GetTopTradersRequest(binanceChainId, tokenContractAddress);
        ApiResponse<GetTopTradersResponse> response = getApi().getTopTraders(request);
        System.out.println(response.getData());
    }
}
