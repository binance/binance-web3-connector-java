

# MarketStatsStreamResponse

TX data event payload.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**pLowerCase** | **String** | Latest price in USD. |  [optional] |
|**tLowerCase** | **Long** | Price timestamp in milliseconds. |  [optional] |
|**pc5m** | **String** | 5-minute price change, as a percentage (e.g. \&quot;1.25\&quot; means +1.25%). |  [optional] |
|**pc1h** | **String** | 1-hour price change, as a percentage (e.g. \&quot;1.25\&quot; means +1.25%). |  [optional] |
|**pc4h** | **String** | 4-hour price change, as a percentage (e.g. \&quot;1.25\&quot; means +1.25%). |  [optional] |
|**pc24h** | **String** | 24-hour price change, as a percentage (e.g. \&quot;1.25\&quot; means +1.25%). |  [optional] |
|**vol5m** | **String** | 5-minute total trading volume in USD. |  [optional] |
|**vol1h** | **String** | 1-hour total trading volume in USD. |  [optional] |
|**vol4h** | **String** | 4-hour total trading volume in USD. |  [optional] |
|**vol24h** | **String** | 24-hour total trading volume in USD. |  [optional] |
|**volB5m** | **String** | 5-minute buy volume in USD. |  [optional] |
|**volS5m** | **String** | 5-minute sell volume in USD. |  [optional] |
|**volB1h** | **String** | 1-hour buy volume in USD. |  [optional] |
|**volS1h** | **String** | 1-hour sell volume in USD. |  [optional] |
|**volB4h** | **String** | 4-hour buy volume in USD. |  [optional] |
|**volS4h** | **String** | 4-hour sell volume in USD. |  [optional] |
|**volB24h** | **String** | 24-hour buy volume in USD. |  [optional] |
|**volS24h** | **String** | 24-hour sell volume in USD. |  [optional] |
|**txs5m** | **Integer** | 5-minute total transaction count. |  [optional] |
|**txs1h** | **Integer** | 1-hour total transaction count. |  [optional] |
|**txs4h** | **Integer** | 4-hour total transaction count. |  [optional] |
|**txs24h** | **Integer** | 24-hour total transaction count. |  [optional] |
|**txsB5m** | **Integer** | 5-minute buy transaction count. |  [optional] |
|**txsS5m** | **Integer** | 5-minute sell transaction count. |  [optional] |
|**txsB1h** | **Integer** | 1-hour buy transaction count. |  [optional] |
|**txsS1h** | **Integer** | 1-hour sell transaction count. |  [optional] |
|**txsB4h** | **Integer** | 4-hour buy transaction count. |  [optional] |
|**txsS4h** | **Integer** | 4-hour sell transaction count. |  [optional] |
|**txsB24h** | **Integer** | 24-hour buy transaction count. |  [optional] |
|**txsS24h** | **Integer** | 24-hour sell transaction count. |  [optional] |
|**cs** | **String** | Circulating supply. |  [optional] |
|**mc** | **String** | Market cap in USD. |  [optional] |
|**liq** | **String** | Liquidity in USD. |  [optional] |
|**holders** | **Integer** | Number of holder addresses. |  [optional] |
|**bnVol5m** | **String** | Binance MPC wallet (trading via Binance Web3 DEX) 5-minute total volume in USD. |  [optional] |
|**bnVol1h** | **String** | Binance MPC wallet (trading via Binance Web3 DEX) 1-hour total volume in USD. |  [optional] |
|**bnVol4h** | **String** | Binance MPC wallet (trading via Binance Web3 DEX) 4-hour total volume in USD. |  [optional] |
|**bnVol24h** | **String** | Binance MPC wallet (trading via Binance Web3 DEX) 24-hour total volume in USD. |  [optional] |
|**bnVolB5m** | **String** | Binance MPC wallet (trading via Binance Web3 DEX) 5-minute buy volume in USD. |  [optional] |
|**bnVolS5m** | **String** | Binance MPC wallet (trading via Binance Web3 DEX) 5-minute sell volume in USD. |  [optional] |
|**bnVolB1h** | **String** | Binance MPC wallet (trading via Binance Web3 DEX) 1-hour buy volume in USD. |  [optional] |
|**bnVolS1h** | **String** | Binance MPC wallet (trading via Binance Web3 DEX) 1-hour sell volume in USD. |  [optional] |
|**bnVolB4h** | **String** | Binance MPC wallet (trading via Binance Web3 DEX) 4-hour buy volume in USD. |  [optional] |
|**bnVolS4h** | **String** | Binance MPC wallet (trading via Binance Web3 DEX) 4-hour sell volume in USD. |  [optional] |
|**bnVolB24h** | **String** | Binance MPC wallet (trading via Binance Web3 DEX) 24-hour buy volume in USD. |  [optional] |
|**bnVolS24h** | **String** | Binance MPC wallet (trading via Binance Web3 DEX) 24-hour sell volume in USD. |  [optional] |
|**bnTxs5m** | **Integer** | Binance MPC wallet (trading via Binance Web3 DEX) 5-minute total transaction count. |  [optional] |
|**bnTxs1h** | **Integer** | Binance MPC wallet (trading via Binance Web3 DEX) 1-hour total transaction count. |  [optional] |
|**bnTxs4h** | **Integer** | Binance MPC wallet (trading via Binance Web3 DEX) 4-hour total transaction count. |  [optional] |
|**bnTxs24h** | **Integer** | Binance MPC wallet (trading via Binance Web3 DEX) 24-hour total transaction count. |  [optional] |
|**bnTxsB5m** | **Integer** | Binance MPC wallet (trading via Binance Web3 DEX) 5-minute buy transaction count. |  [optional] |
|**bnTxsS5m** | **Integer** | Binance MPC wallet (trading via Binance Web3 DEX) 5-minute sell transaction count. |  [optional] |
|**bnTxsB1h** | **Integer** | Binance MPC wallet (trading via Binance Web3 DEX) 1-hour buy transaction count. |  [optional] |
|**bnTxsS1h** | **Integer** | Binance MPC wallet (trading via Binance Web3 DEX) 1-hour sell transaction count. |  [optional] |
|**bnTxsB4h** | **Integer** | Binance MPC wallet (trading via Binance Web3 DEX) 4-hour buy transaction count. |  [optional] |
|**bnTxsS4h** | **Integer** | Binance MPC wallet (trading via Binance Web3 DEX) 4-hour sell transaction count. |  [optional] |
|**bnTxsB24h** | **Integer** | Binance MPC wallet (trading via Binance Web3 DEX) 24-hour buy transaction count. |  [optional] |
|**bnTxsS24h** | **Integer** | Binance MPC wallet (trading via Binance Web3 DEX) 24-hour sell transaction count. |  [optional] |



