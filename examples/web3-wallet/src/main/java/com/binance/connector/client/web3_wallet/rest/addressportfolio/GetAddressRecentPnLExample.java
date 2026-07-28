package com.binance.connector.client.web3_wallet.rest.addressportfolio;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.AddressPortfolioApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetAddressRecentPnLResponse;

/** API examples for AddressPortfolioApi */
public class GetAddressRecentPnLExample {
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
     * Get Address Recent PnL
     *
     * <p>Return recent realized PnL list for an address.
     *
     * @throws ApiException if the Api call fails
     */
    public void getAddressRecentPnLExample() throws ApiException {
        String binanceChainId = "1";
        String walletAddress = "0x28c6c06298d514db089934071355e5743bf21d60";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        String cursor = "";
        String limit = "20";
        AddressPortfolioApi.GetAddressRecentPnLRequest request =
                new AddressPortfolioApi.GetAddressRecentPnLRequest(binanceChainId, walletAddress);
        ApiResponse<GetAddressRecentPnLResponse> response = getApi().getAddressRecentPnL(request);
        System.out.println(response.getData());
    }
}
