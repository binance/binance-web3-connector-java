package com.binance.connector.client.web3_wallet.rest.b402payments;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.SettleB402PaymentV2Request;
import com.binance.connector.client.web3_wallet.rest.model.SettleB402PaymentV2Response;

/** API examples for B402PaymentsApi */
public class SettleB402PaymentV2Example {
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
     * Settle B402 Payment V2
     *
     * <p>Submit a verified x402 V2 authorization on-chain. This operation can move real funds and
     * is irreversible. For &#x60;permit2-upto&#x60;, provide &#x60;settleAmount&#x60; in atomic
     * units. Business failure is returned as HTTP 200 with &#x60;data.success&#x3D;false&#x60;;
     * reconcile any non-empty transaction hash before retrying.
     *
     * @throws ApiException if the Api call fails
     */
    public void settleB402PaymentV2Example() throws ApiException {
        SettleB402PaymentV2Request settleB402PaymentV2Request = new SettleB402PaymentV2Request();
        settleB402PaymentV2Request.body(null);
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        ApiResponse<SettleB402PaymentV2Response> response =
                getApi().settleB402PaymentV2(settleB402PaymentV2Request, recvWindow, nonce);
        System.out.println(response.getData());
    }
}
