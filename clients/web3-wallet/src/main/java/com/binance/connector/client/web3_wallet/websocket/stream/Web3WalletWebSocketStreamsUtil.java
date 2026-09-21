package com.binance.connector.client.web3_wallet.websocket.stream;

import com.binance.connector.client.web3.common.websocket.configuration.Web3WebSocketClientConfiguration;

public class Web3WalletWebSocketStreamsUtil {
    private static final boolean HAS_TIME_UNIT = false;

    public static Web3WebSocketClientConfiguration getClientConfiguration() {
        return getClientConfiguration("");
    }

    public static Web3WebSocketClientConfiguration getClientConfiguration(String path) {
        Web3WebSocketClientConfiguration clientConfiguration =
                new Web3WebSocketClientConfiguration();
        if (!HAS_TIME_UNIT) {
            clientConfiguration.setTimeUnit(null);
        }
        clientConfiguration.setAutoLogon(false);
        return clientConfiguration;
    }
}
