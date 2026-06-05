package com.binance.connector.client.web3.common.auth;

import com.binance.connector.client.common.ApiException;
import com.binance.connector.client.common.Pair;
import com.binance.connector.client.common.auth.BinanceBaseAuthentication;
import com.binance.connector.client.common.sign.SignatureGenerator;
import okhttp3.internal.http.HttpMethod;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.crypto.CryptoException;

import java.net.URI;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class SignatureAuthentication extends BinanceBaseAuthentication {

    private final String apiKey;
    private final SignatureGenerator generator;

    public SignatureAuthentication(String apiKey, SignatureGenerator generator) {
        this.apiKey = apiKey;
        this.generator = generator;
    }

    @Override
    public void applyToParams(
            List<Pair> queryParams,
            Map<String, String> headerParams,
            Map<String, String> cookieParams,
            String payload,
            String method,
            URI uri)
            throws ApiException {
        String timestamp = buildTimestamp();
        headerParams.put("X-OC-APIKEY", apiKey);
        headerParams.put("X-OC-TIMESTAMP", timestamp);
        String allParametersAsString = joinQueryParameters(queryParams);
        if (HttpMethod.requiresRequestBody(method) && StringUtils.isNotEmpty(payload)) {
            allParametersAsString += payload;
        }

        String preHash = timestamp + method + uri.getPath() + "?" + allParametersAsString;
        try {
            headerParams.put("X-OC-SIGN", Base64.getEncoder().encodeToString(generator.sign(preHash)));
        } catch (CryptoException e) {
            throw new RuntimeException(e);
        }
    }

    public String buildTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .withZone(ZoneOffset.UTC);

        return formatter.format(Instant.now());
    }
}
