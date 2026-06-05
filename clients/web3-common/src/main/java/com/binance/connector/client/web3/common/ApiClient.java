package com.binance.connector.client.web3.common;

import com.binance.connector.client.common.auth.Authentication;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.common.dtos.RateLimitType;
import com.binance.connector.client.web3.common.auth.BinanceAuthenticationFactory;
import com.binance.connector.client.web3.common.dtos.RateLimit;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ApiClient extends com.binance.connector.client.common.ApiClient {
    private static final String BINANCE_WEB3_SIGNATURE = "binanceWeb3Signature";

    public ApiClient(ClientConfiguration configuration) {
        super(configuration, new BinanceAuthenticationFactory(), null);
    }

    public ApiClient(
            ClientConfiguration configuration,
            BinanceAuthenticationFactory binanceAuthenticationFactory) {
        super(configuration, binanceAuthenticationFactory, null);
    }

    public ApiClient(ClientConfiguration configuration, OkHttpClient okHttpClient) {
        super(configuration, new BinanceAuthenticationFactory(), okHttpClient);
    }

    protected Map<String, Authentication> getCustomAuthentications(com.binance.connector.client.common.auth.BinanceAuthenticationFactory binanceAuthenticationFactory, SignatureConfiguration signatureConfiguration) {
        Map<String, Authentication> authentications = new HashMap<>();
        Authentication authentication =
                binanceAuthenticationFactory.getAuthentication(signatureConfiguration);
        if (authentication != null) {
            authentications.put(BINANCE_WEB3_SIGNATURE, authentication);
        }
        return authentications;
    }

    protected boolean isRequiredAuth(String authName) {
        return BINANCE_WEB3_SIGNATURE.equals(authName);
    }

    protected Map<RateLimitType, RateLimit> getRateLimit(Integer responseCode, Headers headers) {
        RateLimit rateLimit = new RateLimit();
        Integer limit = parseAsInteger(headers.get("x-oc-ratelimit-limit"));
        if (limit != null) {
            rateLimit.setLimit(limit);
        }
        Integer remaining = parseAsInteger(headers.get("x-oc-ratelimit-remaining"));
        if (remaining != null) {
            rateLimit.setRemaining(remaining);
        }
        Integer usedWeight = parseAsInteger(headers.get("x-oc-used-weight"));
        if (usedWeight != null) {
            rateLimit.setUsedWeight(usedWeight);
        }
        Integer retryAfter = parseAsInteger(headers.get("retry-after"));
        if (retryAfter != null) {
            rateLimit.setRetryAfter(retryAfter);
        }

        HashMap<RateLimitType, RateLimit> rateLimitMap = new HashMap<>();
        rateLimitMap.put(RateLimitType.DEFAULT, rateLimit);
        return rateLimitMap;
    }

    private Integer parseAsInteger(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }

        try {
            return Integer.parseInt(str);
        } catch (RuntimeException e) {
            return null;
        }
    }
}
