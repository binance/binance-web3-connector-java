package com.binance.connector.client.web3_wallet.websocket.stream.market;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.common.websocket.service.StreamBlockingQueueWrapper;
import com.binance.connector.client.web3.common.websocket.configuration.Web3WebSocketClientConfiguration;
import com.binance.connector.client.web3_wallet.websocket.stream.Web3WalletWebSocketStreamsUtil;
import com.binance.connector.client.web3_wallet.websocket.stream.api.Web3WalletWebSocketStreams;
import com.binance.connector.client.web3_wallet.websocket.stream.model.PriceStreamRequest;
import com.binance.connector.client.web3_wallet.websocket.stream.model.PriceStreamResponse;

/** API examples for MarketApi */
public class PriceStreamExample {
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
     * Price Stream
     *
     * <p>Push token price updates. Triggered every time a token&#39;s price changes. Update Speed:
     * Real-time
     *
     * @throws ApiException if the Api call fails
     */
    public void priceStreamExample() throws ApiException, InterruptedException {
        PriceStreamRequest priceStreamRequest = new PriceStreamRequest();
        priceStreamRequest.id("e9d6b4349871b40611412680b3445fac");
        priceStreamRequest.chainId("CT_501");
        priceStreamRequest.contractAddress("C3DwDjT17gDvvCYC2nsdGHxDHVmQRdhKfpAdqQ29pump");
        StreamBlockingQueueWrapper<PriceStreamResponse> response =
                getApi().priceStream(priceStreamRequest);
        while (true) {
            System.out.println(response.take());
        }
    }
}
