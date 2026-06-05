package com.binance.connector.client.web3.common.dtos;

/** DTOs for rate limits */
public class RateLimit extends com.binance.connector.client.common.dtos.RateLimit {
    private Integer limit;
    private Integer remaining;
    private Integer usedWeight;
    private Integer retryAfter;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public Integer getUsedWeight() {
        return usedWeight;
    }

    public void setUsedWeight(Integer usedWeight) {
        this.usedWeight = usedWeight;
    }

    public Integer getRetryAfter() {
        return retryAfter;
    }

    public void setRetryAfter(Integer retryAfter) {
        this.retryAfter = retryAfter;
    }
}
