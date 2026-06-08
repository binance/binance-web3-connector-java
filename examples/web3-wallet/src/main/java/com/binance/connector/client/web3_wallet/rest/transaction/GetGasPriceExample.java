package com.binance.connector.client.web3_wallet.rest.transaction;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.TransactionApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetGasPriceResponse;

/** API examples for TransactionApi */
public class GetGasPriceExample {
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
     * Get Gas Price
     *
     * <p>Query the current network gas price for the specified chain. The response shape varies by
     * chain family: - EVM chains return both &#x60;evmLegacyGasPrice&#x60; (legacy gasPrice) and
     * &#x60;eip1559GasPrice&#x60; (baseFee + priority/max fees) when EIP-1559 is supported. -
     * Solana returns &#x60;solanaGasPrice&#x60; (compute-unit prices and Jito tips). Fields not
     * applicable to the chain family are returned as &#x60;null&#x60;.
     *
     * @throws ApiException if the Api call fails
     */
    public void getGasPriceExample() throws ApiException {
        String binanceChainId = "1";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        TransactionApi.GetGasPriceRequest request =
                new TransactionApi.GetGasPriceRequest(binanceChainId);
        ApiResponse<GetGasPriceResponse> response = getApi().getGasPrice(request);
        System.out.println(response.getData());
    }
}
