package com.binance.connector.client.web3_wallet.websocket.stream.api;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.SystemUtil;
import com.binance.connector.client.common.websocket.adapter.stream.StreamConnectionInterface;
import com.binance.connector.client.common.websocket.service.StreamBlockingQueueWrapper;
import com.binance.connector.client.web3.common.websocket.adapter.stream.Web3StreamConnectionPoolWrapper;
import com.binance.connector.client.web3.common.websocket.adapter.stream.Web3StreamConnectionWrapper;
import com.binance.connector.client.web3.common.websocket.configuration.Web3WebSocketClientConfiguration;
import com.binance.connector.client.web3_wallet.websocket.stream.JSON;
import com.binance.connector.client.web3_wallet.websocket.stream.model.CandlestickStreamRequest;
import com.binance.connector.client.web3_wallet.websocket.stream.model.CandlestickStreamResponse;
import com.binance.connector.client.web3_wallet.websocket.stream.model.MarketStatsStreamRequest;
import com.binance.connector.client.web3_wallet.websocket.stream.model.MarketStatsStreamResponse;
import com.binance.connector.client.web3_wallet.websocket.stream.model.PriceStreamRequest;
import com.binance.connector.client.web3_wallet.websocket.stream.model.PriceStreamResponse;
import com.binance.connector.client.web3_wallet.websocket.stream.model.RealTimeTradesStreamRequest;
import com.binance.connector.client.web3_wallet.websocket.stream.model.RealTimeTradesStreamResponse;
import java.util.UUID;

public class Web3WalletWebSocketStreams {
    private static final String USER_AGENT =
            String.format(
                    "binance-web3-wallet/5.0.0 (Java/%s; %s; %s)",
                    SystemUtil.getJavaVersion(), SystemUtil.getOs(), SystemUtil.getArch());

    private final StreamConnectionInterface connection;

    private MarketApi marketApi;

    public Web3WalletWebSocketStreams(Web3WebSocketClientConfiguration configuration) {
        this(
                configuration.getUsePool()
                        ? new Web3StreamConnectionPoolWrapper(configuration, JSON.getGson())
                        : new Web3StreamConnectionWrapper(configuration, JSON.getGson()));
    }

    public Web3WalletWebSocketStreams(Web3WebSocketClientConfiguration configuration, String userToken) {
        this(
                configuration.getUsePool()
                        ? new Web3StreamConnectionPoolWrapper(configuration, JSON.getGson(), userToken)
                        : new Web3StreamConnectionWrapper(configuration, JSON.getGson(), userToken));
    }

    public Web3WalletWebSocketStreams(StreamConnectionInterface connection) {
        connection.setUserAgent(USER_AGENT);
        if (!connection.isConnected()) {
            connection.connect();
        }
        this.connection = connection;

        this.marketApi = new MarketApi(connection);
    }

    public void stop() throws Exception {
        if (connection != null && connection.isConnected()) {
            connection.stop();
        }
    }

    public StreamBlockingQueueWrapper<CandlestickStreamResponse> candlestickStream(
            CandlestickStreamRequest candlestickStreamRequest) throws ApiException {
        return marketApi.candlestickStream(candlestickStreamRequest);
    }

    public StreamBlockingQueueWrapper<MarketStatsStreamResponse> marketStatsStream(
            MarketStatsStreamRequest marketStatsStreamRequest) throws ApiException {
        return marketApi.marketStatsStream(marketStatsStreamRequest);
    }

    public StreamBlockingQueueWrapper<PriceStreamResponse> priceStream(
            PriceStreamRequest priceStreamRequest) throws ApiException {
        return marketApi.priceStream(priceStreamRequest);
    }

    public StreamBlockingQueueWrapper<RealTimeTradesStreamResponse> realTimeTradesStream(
            RealTimeTradesStreamRequest realTimeTradesStreamRequest) throws ApiException {
        return marketApi.realTimeTradesStream(realTimeTradesStreamRequest);
    }

    public String getRequestID() {
        return UUID.randomUUID().toString();
    }
}
