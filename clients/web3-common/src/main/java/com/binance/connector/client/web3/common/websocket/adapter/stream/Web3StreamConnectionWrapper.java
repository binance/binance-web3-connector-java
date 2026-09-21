package com.binance.connector.client.web3.common.websocket.adapter.stream;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.websocket.adapter.stream.StreamConnectionWrapper;
import com.binance.connector.client.web3.common.ApiClient;
import com.binance.connector.client.web3.common.dtos.GetWebSocketAuthTokenResponse;
import com.binance.connector.client.web3.common.websocket.configuration.Web3WebSocketClientConfiguration;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.Call;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.jetbrains.annotations.Nullable;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class Web3StreamConnectionWrapper extends StreamConnectionWrapper {
    private final ApiClient apiClient;
    private final String tokenBaseUrl;
    private final String tokenEndpoint;
    private String userToken = null;

    public Web3StreamConnectionWrapper(Web3WebSocketClientConfiguration configuration, Gson json) {
        super(configuration, json);
        this.apiClient = new ApiClient(configuration);
        this.tokenBaseUrl = configuration.getTokenBaseUrl();
        this.tokenEndpoint = configuration.getTokenEndpoint();
    }

    public Web3StreamConnectionWrapper(Web3WebSocketClientConfiguration configuration, Gson json, String userToken) {
        super(configuration, json);
        this.apiClient = new ApiClient(configuration);
        this.tokenBaseUrl = configuration.getTokenBaseUrl();
        this.tokenEndpoint = configuration.getTokenEndpoint();
        this.userToken = userToken;
    }

    public Web3StreamConnectionWrapper(Web3WebSocketClientConfiguration configuration, WebSocketClient websocketClient, ApiClient apiClient) {
        super(configuration, websocketClient);
        this.apiClient = apiClient;
        this.tokenBaseUrl = configuration.getTokenBaseUrl();
        this.tokenEndpoint = configuration.getTokenEndpoint();
    }

    @Override
    public URI getUri(String uri) throws URISyntaxException {
        URI oldUri = new URI(uri);
        String newQuery = oldUri.getQuery();

        String token = getUserToken();

        String appendQuery = "token=" + token;
        if (newQuery == null) {
            newQuery = appendQuery;
        } else {
            newQuery += "&" + appendQuery;
        }

        return new URI(
                oldUri.getScheme(),
                oldUri.getAuthority(),
                oldUri.getPath(),
                newQuery,
                oldUri.getFragment());
    }

    @Nullable
    private String getUserToken() {
        String token;
        if (this.userToken != null) {
            token = this.userToken;
        } else {
            ApiResponse<GetWebSocketAuthTokenResponse> webSocketAuthToken = getWebSocketAuthToken();
            if (webSocketAuthToken == null ||
                    webSocketAuthToken.getData() == null ||
                    webSocketAuthToken.getData().getData() == null ||
                    webSocketAuthToken.getData().getData().getToken() == null
            ) {
                throw new IllegalStateException("Missing token from the api response");
            }
            token = webSocketAuthToken.getData().getData().getToken();
        }
        return token;
    }

    private ApiResponse<GetWebSocketAuthTokenResponse> getWebSocketAuthToken()
            throws ApiException {

        Map<String, String> localVarHeaderParams = new HashMap<>();

        final String[] localVarAccepts = {"application/json"};
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        Set<String> localVarAuthNames = new HashSet<>();
        localVarAuthNames.add("binanceWeb3Signature");

        Call buildCall = apiClient.buildCall(
                tokenBaseUrl,
                tokenEndpoint,
                "GET",
                new ArrayList<>(),
                new ArrayList<>(),
                null,
                localVarHeaderParams,
                new HashMap<>(),
                new HashMap<>(),
                localVarAuthNames);

        java.lang.reflect.Type localVarReturnType =
                new TypeToken<GetWebSocketAuthTokenResponse>() {
                }.getType();
        return apiClient.execute(buildCall, localVarReturnType);
    }
}
