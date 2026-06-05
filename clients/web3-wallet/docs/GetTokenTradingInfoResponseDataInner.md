

# GetTokenTradingInfoResponseDataInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Chain unique identifier. |  [optional] |
|**tokenContractAddress** | **String** | Token contract address. |  [optional] |
|**price** | **String** | Latest token price, denominated in USD. |  [optional] |
|**time** | **Long** | Token price observation time, Unix millisecond timestamp. |  [optional] |
|**marketCap** | **String** | Token market cap, denominated in USD. |  [optional] |
|**priceChange5M** | **String** | 5-minute price change percentage. \&quot;0.12\&quot; means a 0.12% increase. |  [optional] |
|**priceChange1H** | **String** | 1-hour price change percentage. \&quot;1.05\&quot; means a 1.05% increase. |  [optional] |
|**priceChange4H** | **String** | 4-hour price change percentage. \&quot;2.30\&quot; means a 2.30% increase. |  [optional] |
|**priceChange24H** | **String** | 24-hour price change percentage. \&quot;-0.85\&quot; means a 0.85% decrease. |  [optional] |
|**volume5M** | **String** | Trading volume in the last 5 minutes, denominated in USD. |  [optional] |
|**volume1H** | **String** | Trading volume in the last 1 hour, denominated in USD. |  [optional] |
|**volume4H** | **String** | Trading volume in the last 4 hours, denominated in USD. |  [optional] |
|**volume24H** | **String** | Trading volume in the last 24 hours, denominated in USD. |  [optional] |
|**buyVolume5M** | **String** | Buy volume in the last 5 minutes, denominated in USD. |  [optional] |
|**buyVolume1H** | **String** | Buy volume in the last 1 hour, denominated in USD. |  [optional] |
|**buyVolume4H** | **String** | Buy volume in the last 4 hours, denominated in USD. |  [optional] |
|**buyVolume24H** | **String** | Buy volume in the last 24 hours, denominated in USD. |  [optional] |
|**sellVolume5M** | **String** | Sell volume in the last 5 minutes, denominated in USD. |  [optional] |
|**sellVolume1H** | **String** | Sell volume in the last 1 hour, denominated in USD. |  [optional] |
|**sellVolume4H** | **String** | Sell volume in the last 4 hours, denominated in USD. |  [optional] |
|**sellVolume24H** | **String** | Sell volume in the last 24 hours, denominated in USD. |  [optional] |
|**txs5M** | **Long** | Number of transactions in the last 5 minutes. |  [optional] |
|**txs1H** | **Long** | Number of transactions in the last 1 hour. |  [optional] |
|**txs4H** | **Long** | Number of transactions in the last 4 hours. |  [optional] |
|**txs24H** | **Long** | Number of transactions in the last 24 hours. |  [optional] |
|**buyTxs5M** | **Long** | Number of buy transactions in the last 5 minutes. |  [optional] |
|**buyTxs1H** | **Long** | Number of buy transactions in the last 1 hour. |  [optional] |
|**buyTxs4H** | **Long** | Number of buy transactions in the last 4 hours. |  [optional] |
|**buyTxs24H** | **Long** | Number of buy transactions in the last 24 hours. |  [optional] |
|**sellTxs5M** | **Long** | Number of sell transactions in the last 5 minutes. |  [optional] |
|**sellTxs1H** | **Long** | Number of sell transactions in the last 1 hour. |  [optional] |
|**sellTxs4H** | **Long** | Number of sell transactions in the last 4 hours. |  [optional] |
|**sellTxs24H** | **Long** | Number of sell transactions in the last 24 hours. |  [optional] |
|**maxPrice** | **String** | 24-hour high price, denominated in USD. |  [optional] |
|**minPrice** | **String** | 24-hour low price, denominated in USD. |  [optional] |
|**circSupply** | **String** | Current circulating supply of the token. |  [optional] |
|**liquidity** | **String** | Token liquidity, denominated in USD. |  [optional] |
|**holders** | **Long** | Number of holding addresses. |  [optional] |
|**bnVolume5M** | **String** | Trading volume from Binance MPC wallets via Binance Web3 DEX in the last 5 minutes, denominated in USD. |  [optional] |
|**bnVolume1H** | **String** | Trading volume from Binance MPC wallets via Binance Web3 DEX in the last 1 hour, denominated in USD. |  [optional] |
|**bnVolume4H** | **String** | Trading volume from Binance MPC wallets via Binance Web3 DEX in the last 4 hours, denominated in USD. |  [optional] |
|**bnVolume24H** | **String** | Trading volume from Binance MPC wallets via Binance Web3 DEX in the last 24 hours, denominated in USD. |  [optional] |
|**bnBuyVolume5M** | **String** | Buy volume from Binance MPC wallets via Binance Web3 DEX in the last 5 minutes, denominated in USD. |  [optional] |
|**bnBuyVolume1H** | **String** | Buy volume from Binance MPC wallets via Binance Web3 DEX in the last 1 hour, denominated in USD. |  [optional] |
|**bnBuyVolume4H** | **String** | Buy volume from Binance MPC wallets via Binance Web3 DEX in the last 4 hours, denominated in USD. |  [optional] |
|**bnBuyVolume24H** | **String** | Buy volume from Binance MPC wallets via Binance Web3 DEX in the last 24 hours, denominated in USD. |  [optional] |
|**bnSellVolume5M** | **String** | Sell volume from Binance MPC wallets via Binance Web3 DEX in the last 5 minutes, denominated in USD. |  [optional] |
|**bnSellVolume1H** | **String** | Sell volume from Binance MPC wallets via Binance Web3 DEX in the last 1 hour, denominated in USD. |  [optional] |
|**bnSellVolume4H** | **String** | Sell volume from Binance MPC wallets via Binance Web3 DEX in the last 4 hours, denominated in USD. |  [optional] |
|**bnSellVolume24H** | **String** | Sell volume from Binance MPC wallets via Binance Web3 DEX in the last 24 hours, denominated in USD. |  [optional] |
|**bnTxs5M** | **Long** | Number of transactions from Binance MPC wallets via Binance Web3 DEX in the last 5 minutes. |  [optional] |
|**bnTxs1H** | **Long** | Number of transactions from Binance MPC wallets via Binance Web3 DEX in the last 1 hour. |  [optional] |
|**bnTxs4H** | **Long** | Number of transactions from Binance MPC wallets via Binance Web3 DEX in the last 4 hours. |  [optional] |
|**bnTxs24H** | **Long** | Number of transactions from Binance MPC wallets via Binance Web3 DEX in the last 24 hours. |  [optional] |
|**bnBuyTxs5M** | **Long** | Number of buy transactions from Binance MPC wallets via Binance Web3 DEX in the last 5 minutes. |  [optional] |
|**bnBuyTxs1H** | **Long** | Number of buy transactions from Binance MPC wallets via Binance Web3 DEX in the last 1 hour. |  [optional] |
|**bnBuyTxs4H** | **Long** | Number of buy transactions from Binance MPC wallets via Binance Web3 DEX in the last 4 hours. |  [optional] |
|**bnBuyTxs24H** | **Long** | Number of buy transactions from Binance MPC wallets via Binance Web3 DEX in the last 24 hours. |  [optional] |
|**bnSellTxs5M** | **Long** | Number of sell transactions from Binance MPC wallets via Binance Web3 DEX in the last 5 minutes. |  [optional] |
|**bnSellTxs1H** | **Long** | Number of sell transactions from Binance MPC wallets via Binance Web3 DEX in the last 1 hour. |  [optional] |
|**bnSellTxs4H** | **Long** | Number of sell transactions from Binance MPC wallets via Binance Web3 DEX in the last 4 hours. |  [optional] |
|**bnSellTxs24H** | **Long** | Number of sell transactions from Binance MPC wallets via Binance Web3 DEX in the last 24 hours. |  [optional] |



