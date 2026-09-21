package com.binance.connector.client.web3_wallet.websocket.stream.market;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.common.websocket.service.StreamBlockingQueueWrapper;
import com.binance.connector.client.web3.common.websocket.configuration.Web3WebSocketClientConfiguration;
import com.binance.connector.client.web3_wallet.websocket.stream.Web3WalletWebSocketStreamsUtil;
import com.binance.connector.client.web3_wallet.websocket.stream.api.Web3WalletWebSocketStreams;
import com.binance.connector.client.web3_wallet.websocket.stream.model.MarketStatsStreamRequest;
import com.binance.connector.client.web3_wallet.websocket.stream.model.MarketStatsStreamResponse;

/** API examples for MarketApi */
public class MarketStatsStreamExample {
    private Web3WalletWebSocketStreams api;

    public Web3WalletWebSocketStreams getApi() {
        if (api == null) {
            Web3WebSocketClientConfiguration clientConfiguration =
                    Web3WalletWebSocketStreamsUtil.getClientConfiguration();
            SignatureConfiguration signatureConfiguration = new SignatureConfiguration();
            signatureConfiguration.setApiKey("apiKey");
            signatureConfiguration.setSecretKey("secretKey");
            clientConfiguration.setSignatureConfiguration(signatureConfiguration);
            api = new Web3WalletWebSocketStreams(clientConfiguration);
        }
        return api;
    }

    /**
     * Market Stats Stream
     *
     * <p>Push token market data. Rate-limited to at most once per second per token: if a
     * token&#39;s data changes within a 1-second window, the latest snapshot is pushed once
     * (multiple changes are coalesced into the latest value); if there is no change, nothing is
     * pushed. Update Speed: Real-time
     *
     * @throws ApiException if the Api call fails
     */
    public void marketStatsStreamExample() throws ApiException, InterruptedException {
        MarketStatsStreamRequest marketStatsStreamRequest = new MarketStatsStreamRequest();
        marketStatsStreamRequest.id("e9d6b4349871b40611412680b3445fac");
        marketStatsStreamRequest.chainId("CT_501");
        marketStatsStreamRequest.contractAddress("C3DwDjT17gDvvCYC2nsdGHxDHVmQRdhKfpAdqQ29pump");
        StreamBlockingQueueWrapper<MarketStatsStreamResponse> response =
                getApi().marketStatsStream(marketStatsStreamRequest);
        while (true) {
            System.out.println(response.take());
        }
    }
}
