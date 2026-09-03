package com.binance.connector.client.web3_wallet.rest.b402payments;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.VerifyB402PaymentV1Request;
import com.binance.connector.client.web3_wallet.rest.model.VerifyB402PaymentV1Response;

/** API examples for B402PaymentsApi */
public class VerifyB402PaymentV1Example {
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
     * Verify B402 Payment V1
     *
     * <p>Legacy V1 off-chain verification endpoint. New integrations should use V2. Portal identity
     * is resolved from the API Key project, so &#x60;merchantId&#x60; is omitted from the external
     * request.
     *
     * @throws ApiException if the Api call fails
     */
    public void verifyB402PaymentV1Example() throws ApiException {
        VerifyB402PaymentV1Request verifyB402PaymentV1Request = new VerifyB402PaymentV1Request();
        verifyB402PaymentV1Request.body(null);
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        ApiResponse<VerifyB402PaymentV1Response> response =
                getApi().verifyB402PaymentV1(verifyB402PaymentV1Request, recvWindow, nonce);
        System.out.println(response.getData());
    }
}
