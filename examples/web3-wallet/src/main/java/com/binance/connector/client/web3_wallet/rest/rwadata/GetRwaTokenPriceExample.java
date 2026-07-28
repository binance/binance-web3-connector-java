package com.binance.connector.client.web3_wallet.rest.rwadata;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.RwaDataApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetRwaTokenPriceResponse;

/** API examples for RwaDataApi */
public class GetRwaTokenPriceExample {
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
     * Get RWA Token Price
     *
     * <p>Batch query RWA token prices, including on-chain price and underlying reference price.
     *
     * @throws ApiException if the Api call fails
     */
    public void getRwaTokenPriceExample() throws ApiException {
        String binanceChainId = "56";
        String tokenContractAddresses = "0x8755c5c39b1aa9053a83ac731242a2cf4d04b0fe";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        RwaDataApi.GetRwaTokenPriceRequest request =
                new RwaDataApi.GetRwaTokenPriceRequest(binanceChainId, tokenContractAddresses);
        ApiResponse<GetRwaTokenPriceResponse> response = getApi().getRwaTokenPrice(request);
        System.out.println(response.getData());
    }
}
