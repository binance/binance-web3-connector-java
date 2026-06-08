package com.binance.connector.client.web3_wallet.rest.market;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.MarketApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetTokenAdvancedInfoResponse;

/** API examples for MarketApi */
public class GetTokenAdvancedInfoExample {
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
     * Get Token Advanced Info
     *
     * <p>Return comprehensive metrics for a token, including creator and launch info, holding
     * percentages by address type (smart money, KOL, sniper, bundler, fresh wallet, etc.), and
     * token tags.
     *
     * @throws ApiException if the Api call fails
     */
    public void getTokenAdvancedInfoExample() throws ApiException {
        String binanceChainId = "1";
        String tokenContractAddress = "0x6982508145454ce325ddbe47a25d4ec3d2311933";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        MarketApi.GetTokenAdvancedInfoRequest request =
                new MarketApi.GetTokenAdvancedInfoRequest(binanceChainId, tokenContractAddress);
        ApiResponse<GetTokenAdvancedInfoResponse> response = getApi().getTokenAdvancedInfo(request);
        System.out.println(response.getData());
    }
}
