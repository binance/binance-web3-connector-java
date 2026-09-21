package com.binance.connector.client.web3_wallet.websocket.stream.market;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.common.websocket.service.StreamBlockingQueueWrapper;
import com.binance.connector.client.web3.common.websocket.configuration.Web3WebSocketClientConfiguration;
import com.binance.connector.client.web3_wallet.websocket.stream.Web3WalletWebSocketStreamsUtil;
import com.binance.connector.client.web3_wallet.websocket.stream.api.Web3WalletWebSocketStreams;
import com.binance.connector.client.web3_wallet.websocket.stream.model.RealTimeTradesStreamRequest;
import com.binance.connector.client.web3_wallet.websocket.stream.model.RealTimeTradesStreamResponse;

/** API examples for MarketApi */
public class RealTimeTradesStreamExample {
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
     * Real-Time Trades Stream
     *
     * <p>Push real-time token trade history. Triggered on every new transaction. Update Speed:
     * Real-time
     *
     * @throws ApiException if the Api call fails
     */
    public void realTimeTradesStreamExample() throws ApiException, InterruptedException {
        RealTimeTradesStreamRequest realTimeTradesStreamRequest = new RealTimeTradesStreamRequest();
        realTimeTradesStreamRequest.id("e9d6b4349871b40611412680b3445fac");
        realTimeTradesStreamRequest.chainId("CT_501");
        realTimeTradesStreamRequest.contractAddress("C3DwDjT17gDvvCYC2nsdGHxDHVmQRdhKfpAdqQ29pump");
        StreamBlockingQueueWrapper<RealTimeTradesStreamResponse> response =
                getApi().realTimeTradesStream(realTimeTradesStreamRequest);
        while (true) {
            System.out.println(response.take());
        }
    }
}
