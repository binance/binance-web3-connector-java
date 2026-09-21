package com.binance.connector.client.web3_wallet.websocket.stream.market;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.common.websocket.service.StreamBlockingQueueWrapper;
import com.binance.connector.client.web3.common.websocket.configuration.Web3WebSocketClientConfiguration;
import com.binance.connector.client.web3_wallet.websocket.stream.Web3WalletWebSocketStreamsUtil;
import com.binance.connector.client.web3_wallet.websocket.stream.api.Web3WalletWebSocketStreams;
import com.binance.connector.client.web3_wallet.websocket.stream.model.CandlestickStreamRequest;
import com.binance.connector.client.web3_wallet.websocket.stream.model.CandlestickStreamResponse;

/** API examples for MarketApi */
public class CandlestickStreamExample {
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
     * Candlestick Stream
     *
     * <p>Push token candlestick (K-line) data in real time. The current (unclosed) candle keeps
     * updating as new trades occur. Update Speed: Real-time
     *
     * @throws ApiException if the Api call fails
     */
    public void candlestickStreamExample() throws ApiException, InterruptedException {
        CandlestickStreamRequest candlestickStreamRequest = new CandlestickStreamRequest();
        candlestickStreamRequest.id("e9d6b4349871b40611412680b3445fac");
        candlestickStreamRequest.bar("1s");
        candlestickStreamRequest.chainId("CT_501");
        candlestickStreamRequest.contractAddress("C3DwDjT17gDvvCYC2nsdGHxDHVmQRdhKfpAdqQ29pump");
        StreamBlockingQueueWrapper<CandlestickStreamResponse> response =
                getApi().candlestickStream(candlestickStreamRequest);
        while (true) {
            System.out.println(response.take());
        }
    }
}
