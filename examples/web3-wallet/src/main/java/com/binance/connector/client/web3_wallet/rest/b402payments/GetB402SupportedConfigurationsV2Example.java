package com.binance.connector.client.web3_wallet.rest.b402payments;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetB402SupportedConfigurationsV2Request;
import com.binance.connector.client.web3_wallet.rest.model.GetB402SupportedConfigurationsV2Response;

/** API examples for B402PaymentsApi */
public class GetB402SupportedConfigurationsV2Example {
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
     * Get B402 Supported Configurations V2
     *
     * <p>Return the live x402 V2 payment kinds available to the authenticated Developer Portal
     * project. Use the result to construct HTTP 402 payment requirements. Copy the selected
     * &#x60;extra&#x60; object verbatim and refresh cached configuration periodically.
     *
     * @throws ApiException if the Api call fails
     */
    public void getB402SupportedConfigurationsV2Example() throws ApiException {
        GetB402SupportedConfigurationsV2Request getB402SupportedConfigurationsV2Request =
                new GetB402SupportedConfigurationsV2Request();
        getB402SupportedConfigurationsV2Request.body(null);
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        ApiResponse<GetB402SupportedConfigurationsV2Response> response =
                getApi().getB402SupportedConfigurationsV2(
                                getB402SupportedConfigurationsV2Request, recvWindow, nonce);
        System.out.println(response.getData());
    }
}
