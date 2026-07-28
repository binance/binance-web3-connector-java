package com.binance.connector.client.web3_wallet.rest.addressportfolio;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.AddressPortfolioApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetAddressPnLForSpecificTokenResponse;

/** API examples for AddressPortfolioApi */
public class GetAddressPnLForSpecificTokenExample {
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
     * Get Address PnL for Specific Token
     *
     * <p>Return the latest realized PnL detail for a specific token held by an address, including
     * buy/sell stats, current balance, and holding duration.
     *
     * @throws ApiException if the Api call fails
     */
    public void getAddressPnLForSpecificTokenExample() throws ApiException {
        String binanceChainId = "1";
        String walletAddress = "0x28c6c06298d514db089934071355e5743bf21d60";
        String tokenContractAddress = "0x6982508145454ce325ddbe47a25d4ec3d2311933";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        AddressPortfolioApi.GetAddressPnLForSpecificTokenRequest request =
                new AddressPortfolioApi.GetAddressPnLForSpecificTokenRequest(
                        binanceChainId, walletAddress, tokenContractAddress);
        ApiResponse<GetAddressPnLForSpecificTokenResponse> response =
                getApi().getAddressPnLForSpecificToken(request);
        System.out.println(response.getData());
    }
}
