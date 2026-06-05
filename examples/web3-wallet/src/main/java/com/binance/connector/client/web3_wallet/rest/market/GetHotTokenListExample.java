package com.binance.connector.client.web3_wallet.rest.market;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.web3_wallet.rest.Web3WalletRestApiUtil;
import com.binance.connector.client.web3_wallet.rest.api.MarketApi;
import com.binance.connector.client.web3_wallet.rest.api.Web3WalletRestApi;
import com.binance.connector.client.web3_wallet.rest.model.GetHotTokenListResponse;

/** API examples for MarketApi */
public class GetHotTokenListExample {
    private Web3WalletRestApi api;

    public Web3WalletRestApi getApi() {
        if (api == null) {
            ClientConfiguration clientConfiguration =
                    Web3WalletRestApiUtil.getClientConfiguration();
            SignatureConfiguration signatureConfiguration = new SignatureConfiguration();
            signatureConfiguration.setApiKey("apiKey");
            signatureConfiguration.setPrivateKey("path/to/private.key");
            clientConfiguration.setSignatureConfiguration(signatureConfiguration);
            api = new Web3WalletRestApi(clientConfiguration);
        }
        return api;
    }

    /**
     * Get Hot Token List
     *
     * <p>Get hot token ranking list. Supports sorting by volume, price change, market cap, etc.,
     * with filters for holding distribution, developer behavior, liquidity, and more.
     *
     * @throws ApiException if the Api call fails
     */
    public void getHotTokenListExample() throws ApiException {
        Long recvWindow = 5000L;
        String nonce = "unique-nonce-string";
        String binanceChainId = "1";
        Integer rankBy = null;
        Integer rankingTimeFrame = null;
        String priceChangePercentMin = "5";
        String priceChangePercentMax = "100";
        String volumeMin = "10000";
        String volumeMax = "1000000";
        String txsMin = "100";
        String txsMax = "10000";
        String marketCapMin = "100000";
        String marketCapMax = "100000000";
        String liquidityMin = "10000";
        String liquidityMax = "10000000";
        String devHoldingPercentMin = "0";
        String devHoldingPercentMax = "10";
        String inflowUsdMin = "0";
        String inflowUsdMax = "1000000";
        String holdersMin = "100";
        String holdersMax = "100000";
        String bnHolderCountMin = "0";
        String bnHolderCountMax = "10000";
        String top10HoldingPercentMin = "0";
        String top10HoldingPercentMax = "100";
        String sniperHoldingPercentMin = "0";
        String sniperHoldingPercentMax = "100";
        String smartMoneyHoldingPercentMin = "0";
        String smartMoneyHoldingPercentMax = "100";
        String kolHoldingPercentMin = "0";
        String kolHoldingPercentMax = "100";
        String proHoldingPercentMin = "0";
        String proHoldingPercentMax = "100";
        String freshWalletHoldingPercentMin = "0";
        String freshWalletHoldingPercentMax = "100";
        String insiderHoldingPercentMin = "0";
        String insiderHoldingPercentMax = "100";
        String bundlerHoldingPercentMin = "0";
        String bundlerHoldingPercentMax = "100";
        String devCreatedTokenCountMin = "0";
        String devCreatedTokenCountMax = "100";
        String devMigratedTokenCountMin = "0";
        String devMigratedTokenCountMax = "100";
        String devMigratedTokenPercentMin = "0";
        String devMigratedTokenPercentMax = "100";
        Boolean isDevSoldAll = false;
        Boolean isDevBurned = false;
        Boolean isMint = false;
        Boolean isFreeze = false;
        Boolean isHideWashTradingTokens = true;
        Boolean isHideDevWashTradingTokens = true;
        Boolean isHideInternalWashTradingTokens = true;
        Integer pageId = 1;
        Integer size = 100;
        MarketApi.GetHotTokenListRequest request = new MarketApi.GetHotTokenListRequest();
        ApiResponse<GetHotTokenListResponse> response = getApi().getHotTokenList(request);
        System.out.println(response.getData());
    }
}
