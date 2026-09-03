package com.binance.connector.client.web3_wallet.rest.b402payments;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.VerifyB402PaymentV2Request;
import com.binance.connector.client.web3_wallet.rest.model.VerifyB402PaymentV2Response;

/** API examples for B402PaymentsApi */
public class VerifyB402PaymentV2Example {
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
     * Verify B402 Payment V2
     *
     * <p>Validate an x402 V2 payment authorization off-chain without spending funds or broadcasting
     * a transaction. Portal identity is resolved from the authenticated API Key project; omit
     * &#x60;merchantId&#x60;. A validation failure is returned as HTTP 200 with
     * &#x60;data.isValid&#x3D;false&#x60;.
     *
     * @throws ApiException if the Api call fails
     */
    public void verifyB402PaymentV2Example() throws ApiException {
        VerifyB402PaymentV2Request verifyB402PaymentV2Request = new VerifyB402PaymentV2Request();
        verifyB402PaymentV2Request.body(null);
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        ApiResponse<VerifyB402PaymentV2Response> response =
                getApi().verifyB402PaymentV2(verifyB402PaymentV2Request, recvWindow, nonce);
        System.out.println(response.getData());
    }
}
