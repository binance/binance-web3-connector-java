package com.binance.connector.client.web3_wallet.rest;

import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.web3.common.ApiClient;

public class Web3WalletRestApiUtil {
    private static final String BASE_URL = "https://web3.binance.com/build";
    private static final boolean HAS_TIME_UNIT = false;

    public static ClientConfiguration getClientConfiguration() {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        if (!HAS_TIME_UNIT) {
            clientConfiguration.setTimeUnit(null);
        }
        clientConfiguration.setUrl(BASE_URL);
        return clientConfiguration;
    }

    public static ApiClient getDefaultClient(ClientConfiguration configuration) {
        ApiClient apiClient = new ApiClient(configuration);
        apiClient.setJson(JSON.getGson());

        return apiClient;
    }
}
