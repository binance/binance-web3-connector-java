package com.binance.connector.client.web3_wallet.rest.b402payments;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetB402SupportedConfigurationsV1Request;
import com.binance.connector.client.web3_wallet.rest.model.GetB402SupportedConfigurationsV1Response;

/** API examples for B402PaymentsApi */
public class GetB402SupportedConfigurationsV1Example {
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
     * Get B402 Supported Configurations V1
     *
     * <p>Legacy V1 compatibility endpoint. New integrations should use V2. V1 returns
     * &#x60;x402Version&#x3D;1&#x60;, method-specific &#x60;facilitatorAddress&#x60;, and V1
     * signer-map semantics.
     *
     * @throws ApiException if the Api call fails
     */
    public void getB402SupportedConfigurationsV1Example() throws ApiException {
        GetB402SupportedConfigurationsV1Request getB402SupportedConfigurationsV1Request =
                new GetB402SupportedConfigurationsV1Request();
        getB402SupportedConfigurationsV1Request.body(null);
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        ApiResponse<GetB402SupportedConfigurationsV1Response> response =
                getApi().getB402SupportedConfigurationsV1(
                                getB402SupportedConfigurationsV1Request, recvWindow, nonce);
        System.out.println(response.getData());
    }
}
