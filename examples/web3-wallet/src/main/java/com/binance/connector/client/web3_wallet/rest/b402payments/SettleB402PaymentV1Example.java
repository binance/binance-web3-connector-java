package com.binance.connector.client.web3_wallet.rest.b402payments;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.SettleB402PaymentV1Request;
import com.binance.connector.client.web3_wallet.rest.model.SettleB402PaymentV1Response;

/** API examples for B402PaymentsApi */
public class SettleB402PaymentV1Example {
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
     * Settle B402 Payment V1
     *
     * <p>Legacy V1 on-chain settlement endpoint. New integrations should use V2. This operation can
     * move real funds and is irreversible. V1 additionally returns &#x60;confirmations&#x60; in the
     * settlement result.
     *
     * @throws ApiException if the Api call fails
     */
    public void settleB402PaymentV1Example() throws ApiException {
        SettleB402PaymentV1Request settleB402PaymentV1Request = new SettleB402PaymentV1Request();
        settleB402PaymentV1Request.body(null);
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        ApiResponse<SettleB402PaymentV1Response> response =
                getApi().settleB402PaymentV1(settleB402PaymentV1Request, recvWindow, nonce);
        System.out.println(response.getData());
    }
}
