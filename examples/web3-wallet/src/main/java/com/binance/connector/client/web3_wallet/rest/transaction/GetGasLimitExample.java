package com.binance.connector.client.web3_wallet.rest.transaction;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetGasLimitRequest;
import com.binance.connector.client.web3_wallet.rest.model.GetGasLimitResponse;

/** API examples for TransactionApi */
public class GetGasLimitExample {
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
     * Get Gas Limit
     *
     * <p>Estimate the gas limit (or compute-unit ceiling on Solana) for an unsigned transaction.
     * Provide either &#x60;evmTx&#x60; for EVM chains, &#x60;solTx&#x60; for Solana, or
     * &#x60;tronTx&#x60; for Tron (\&quot;CT_195\&quot;), matching the value of
     * &#x60;binanceChainId&#x60;. On Tron the response carries energy/bandwidth fields instead of a
     * single gas limit; &#x60;gasLimit&#x60; is the fee limit (in sun) and the energy/bandwidth
     * fields describe resource consumption and pricing.
     *
     * @throws ApiException if the Api call fails
     */
    public void getGasLimitExample() throws ApiException {
        GetGasLimitRequest getGasLimitRequest = new GetGasLimitRequest();
        getGasLimitRequest.binanceChainId("1");
        getGasLimitRequest.evmTx(null);
        getGasLimitRequest.solTx(null);
        getGasLimitRequest.tronTx(null);
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        ApiResponse<GetGasLimitResponse> response =
                getApi().getGasLimit(getGasLimitRequest, recvWindow, nonce);
        System.out.println(response.getData());
    }
}
