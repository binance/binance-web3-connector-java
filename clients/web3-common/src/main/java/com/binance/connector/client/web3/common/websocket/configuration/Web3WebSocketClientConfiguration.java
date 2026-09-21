package com.binance.connector.client.web3.common.websocket.configuration;

import com.binance.connector.client.common.websocket.configuration.WebSocketClientConfiguration;

public class Web3WebSocketClientConfiguration extends WebSocketClientConfiguration {
    public static final int DEFAULT_RECONNECT_INTERVAL_TIME = (6 * 24 * 60 * 60 * 1000);

    public static final String WEB3_TOKEN_API_BASE_URL = "https://web3.binance.com/build";
    public static final String WEB3_TOKEN_API_PATH = "/api/v1/dex/market/wss/auth/token";

    protected String url = "wss://web3-stream.binance.com/w3w/stream";
    protected String tokenBaseUrl = WEB3_TOKEN_API_BASE_URL;
    protected String tokenEndpoint = WEB3_TOKEN_API_PATH;

    public Integer getReconnectIntervalTime() {
        return DEFAULT_RECONNECT_INTERVAL_TIME;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public String getTokenBaseUrl() {
        return tokenBaseUrl;
    }

    public void setTokenBaseUrl(String tokenBaseUrl) {
        this.tokenBaseUrl = tokenBaseUrl;
    }

    public String getTokenEndpoint() {
        return tokenEndpoint;
    }

    public void setTokenEndpoint(String tokenEndpoint) {
        this.tokenEndpoint = tokenEndpoint;
    }
}
