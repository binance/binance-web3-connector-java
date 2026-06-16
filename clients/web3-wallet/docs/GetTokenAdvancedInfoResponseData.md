

# GetTokenAdvancedInfoResponseData


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**binanceChainId** | **String** | Unique chain identifier. |  [optional] |
|**tokenContractAddress** | **String** | Token contract address. |  [optional] |
|**isInternal** | **Integer** | Whether the token is internal to the platform. 0 &#x3D; no, 1 &#x3D; yes. |  [optional] |
|**protocolId** | **Integer** | Protocol ID the token belongs to. Null when no protocol is associated. |  [optional] |
|**progress** | **String** | Token launch progress for inner-market tokens, range 0–100. |  [optional] |
|**createTime** | **Long** | Token creation time, Unix millisecond timestamp. |  [optional] |
|**creatorAddress** | **String** | Token creator wallet address. |  [optional] |
|**devCreatedTokenCount** | **Long** | Total tokens the developer has ever created. |  [optional] |
|**devMigratedTokenCount** | **Long** | Total tokens the developer has successfully launched (migrated). |  [optional] |
|**devMigratedTokenPercent** | **String** | Developer launch success rate. \&quot;53.5\&quot; means 53.5%. |  [optional] |
|**top10HoldingPercent** | **String** | Top 10 addresses combined holding percentage. \&quot;40.08\&quot; means 40.08%. |  [optional] |
|**devHoldingPercent** | **String** | Developer holding percentage. \&quot;5.23\&quot; means 5.23%. |  [optional] |
|**smartMoneyHoldingPercent** | **String** | Smart money holding percentage. \&quot;2.15\&quot; means 2.15%. |  [optional] |
|**kolHoldingPercent** | **String** | KOL holding percentage. \&quot;1.5\&quot; means 1.5%. |  [optional] |
|**bundlerHoldingPercent** | **String** | Bundler holding percentage. \&quot;12.3\&quot; means 12.3%. |  [optional] |
|**proHoldingPercent** | **String** | Professional holder percentage. \&quot;4.2\&quot; means 4.2%. |  [optional] |
|**freshWalletHoldingPercent** | **String** | Fresh wallet holding percentage. \&quot;3.8\&quot; means 3.8%. |  [optional] |
|**sniperHoldingPercent** | **String** | Sniper holding percentage. \&quot;3.1\&quot; means 3.1%. |  [optional] |
|**insiderHoldingPercent** | **String** | Insider holding percentage. \&quot;2.5\&quot; means 2.5%. |  [optional] |
|**holders** | **Long** | Number of holding addresses. |  [optional] |
|**bnHolderCount** | **Long** | Number of Binance MPC wallets holding this token. |  [optional] |
|**bnTraderCount7D** | **Long** | Number of Binance MPC wallets that traded via Binance Web3 DEX in the last 7 days. |  [optional] |
|**tokenTags** | **List&lt;String&gt;** | Token tags. Returns tags matched by the token. Possible values:  - &#x60;alpha&#x60; — Binance Alpha - &#x60;tge&#x60; — Binance TGE - &#x60;communityRecognized&#x60; — Highly recognized by community - &#x60;devSellAll&#x60; — Developer sold entire holding - &#x60;devSell&#x60; — Developer sold partial holding - &#x60;devBuy&#x60; — Developer bought tokens - &#x60;smartMoneyBuy&#x60; — Smart money buying - &#x60;smartMoneySell&#x60; — Smart money selling - &#x60;devRemoveLiquidity&#x60; — Developer removed liquidity - &#x60;devAddLiquidity&#x60; — Developer added liquidity - &#x60;devBurnToken&#x60; — Developer burned tokens - &#x60;dexScreenerPaid&#x60; — DexScreener paid - &#x60;volumeSurge&#x60; — Volume surge - &#x60;volumePlunge&#x60; — Volume plunge - &#x60;lowLiquidity&#x60; — Low liquidity - &#x60;washTrading&#x60; — Wash trading detected - &#x60;devWashTrading&#x60; — Developer wash trading detected - &#x60;insiderWashTrading&#x60; — Insider wash trading detected  |  [optional] |



