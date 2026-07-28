package com.binance.connector.client.web3_wallet.rest.generaldata;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.GeneralDataApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetHoldersRankingResponse;
import com.binance.connector.client.web3_wallet.rest.model.TagFilter;

/** API examples for GeneralDataApi */
public class GetHoldersRankingExample {
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
     * Get Holders Ranking
     *
     * <p>Return the holders ranking list for a token, including holding amount, holding percentage,
     * native-token balance, average buy/sell price, realized PnL, and funding source. Up to 100
     * records. Pagination is not supported.
     *
     * @throws ApiException if the Api call fails
     */
    public void getHoldersRankingExample() throws ApiException {
        String binanceChainId = "1";
        String tokenContractAddress = "0x6982508145454ce325ddbe47a25d4ec3d2311933";
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        TagFilter tagFilter = TagFilter.TAG_FILTER_1;
        GeneralDataApi.GetHoldersRankingRequest request =
                new GeneralDataApi.GetHoldersRankingRequest(binanceChainId, tokenContractAddress);
        ApiResponse<GetHoldersRankingResponse> response = getApi().getHoldersRanking(request);
        System.out.println(response.getData());
    }
}
