# TradingApi

All URIs are relative to *https://web3.binance.com/build*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**buildSolanaSwapInstructions**](TradingApi.md#buildSolanaSwapInstructions) | **GET** /api/v1/dex/aggregator/swap-instruction | Build Solana Swap Instructions |
| [**buildSwapTransaction**](TradingApi.md#buildSwapTransaction) | **GET** /api/v1/dex/aggregator/swap | Build Swap Transaction |
| [**getAggregatedQuote**](TradingApi.md#getAggregatedQuote) | **GET** /api/v1/dex/aggregator/quote | Get Aggregated Quote |
| [**getAggregatorSupportedChains**](TradingApi.md#getAggregatorSupportedChains) | **GET** /api/v1/dex/aggregator/supported/chain | Get Aggregator Supported Chains |
| [**getErc20ApproveTransaction**](TradingApi.md#getErc20ApproveTransaction) | **GET** /api/v1/dex/aggregator/approve-transaction | Get ERC-20 Approve Transaction |
| [**getRfqOrderStatus**](TradingApi.md#getRfqOrderStatus) | **GET** /api/v1/dex/aggregator/order/{orderId} | Get RFQ Order Status |
| [**getTransactionStatus**](TradingApi.md#getTransactionStatus) | **GET** /api/v1/dex/aggregator/history | Get Transaction Status |
| [**quoteAndBuildSwapTransaction**](TradingApi.md#quoteAndBuildSwapTransaction) | **GET** /api/v1/dex/aggregator/quote-and-swap | Quote and Build Swap Transaction (Flash API) |
| [**submitRfqOrder**](TradingApi.md#submitRfqOrder) | **POST** /api/v1/dex/aggregator/order/submit | Submit RFQ Order |


<a id="buildSolanaSwapInstructions"></a>
# **buildSolanaSwapInstructions**
> BuildSolanaSwapInstructionsResponse buildSolanaSwapInstructions(binanceChainId, amount, fromTokenAddress, toTokenAddress, slippagePercent, userWalletAddress, quoteId).recvWindow(recvWindow).nonce(nonce).priceImpactProtectionPercent(priceImpactProtectionPercent).autoSlippage(autoSlippage).maxAutoSlippagePercent(maxAutoSlippagePercent).computeUnitLimit(computeUnitLimit).computeUnitPrice(computeUnitPrice).gasLevel(gasLevel).tips(tips).feePercent(feePercent).fromTokenReferrerWalletAddress(fromTokenReferrerWalletAddress).toTokenReferrerWalletAddress(toTokenReferrerWalletAddress).execute();

Build Solana Swap Instructions

Solana-only counterpart to &#x60;/swap&#x60;. Shares the full quote → route → vendor &#x60;buildSwapTx&#x60; → priceImpact → minReceive → instruction-assembly pipeline; the only difference is the response: instead of returning a signed-and-serialized base64 transaction, this endpoint returns the **uncompiled** instruction list plus the address-lookup-table (ALT) address list, leaving v0-transaction compilation, signing, and submission to the caller.  Use this when the caller needs to: - prepend / append their own instructions (e.g. fee splitting, custom   logging) before signing;  - reuse the platform-curated route, slippage, PS-variant rewriting, ALT   injection, ComputeBudget overwrite, and ATA batching while still   controlling the final wire format.   Only supports &#x60;binanceChainId&#x3D;CT_501&#x60; (Solana). Other chains return &#x60;CHAIN_NOT_SUPPORTED&#x60; (40411). Parameters mirror the Solana subset of &#x60;/swap&#x60; (no EVM-only &#x60;approveTransaction&#x60; / &#x60;approveAmount&#x60; / &#x60;gasLimit&#x60;). Supports the custom-fee (Add Fee / referral fee) parameters (&#x60;feePercent&#x60; + &#x60;fromTokenReferrerWalletAddress&#x60; / &#x60;toTokenReferrerWalletAddress&#x60;), with the same semantics as &#x60;/swap&#x60; — the fee instructions are injected into the returned uncompiled instruction list.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TradingApi apiInstance = new TradingApi(defaultClient);
    BinanceChainId binanceChainId = BinanceChainId.fromValue("CT_501"); // BinanceChainId | Chain identifier. Only `CT_501` (Solana) is accepted; other values return `CHAIN_NOT_SUPPORTED` (40411).
    String amount = "12000000"; // String | Sell-token amount in the token's smallest unit (positive integer string, no decimals).
    String fromTokenAddress = "EPjFWdd5AufqSSqeM2qN1xzybapC8G4wEGGkZwyTDt1v"; // String | Sell-token mint address (Solana Base58, case-sensitive).
    String toTokenAddress = "So11111111111111111111111111111111111111112"; // String | Buy-token mint address (Solana Base58, case-sensitive).
    String slippagePercent = "0.5"; // String | Maximum slippage as a percentage. Solana range 0 to less than 100. \"0.5\" means 0.5%.
    String userWalletAddress = "J5CBzXpcYn6WR2JBah8zU4Yxct985CAFGwXRcFaX2pbS"; // String | User wallet address (Solana Base58); becomes the v0 transaction's `feePayer`.
    String quoteId = "a1b2c3d4e5f64a8b9c0d1e2f3a4b5c6d"; // String | quoteId returned from `/quote` for the route to execute. TTL ~30s; expired entries return `QUOTE_EXPIRED` (40401).
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String priceImpactProtectionPercent = "90"; // String | Maximum allowed price impact percentage (0–100). Defaults to 90; set to 100 to disable.
    AutoSlippage autoSlippage = AutoSlippage.fromValue("true"); // AutoSlippage | When \"true\", slippage is auto-derived from market data and overrides `slippagePercent`. Defaults to false.
    String maxAutoSlippagePercent = "3"; // String | Cap on auto-derived slippage (only applies when `autoSlippage=true`).
    String computeUnitLimit = "1400000"; // String | Maximum compute units the transaction may consume (analogous to EVM gasLimit). Defaults to the platform value when omitted.
    String computeUnitPrice = "1000"; // String | Priority fee per compute unit (micro-lamports). When omitted, the platform computes a value either from the `gasLevel` tier or from chain-side defaults.
    GasLevel gasLevel = GasLevel.fromValue("slow"); // GasLevel | Priority-fee tier; consulted only when `computeUnitPrice` is omitted. Defaults to \"average\".
    String tips = "0.001"; // String | Jito tips in SOL for MEV protection. Valid range [0.000000001, 2] (minimum 1 lamport). When specified, it is recommended to set `computeUnitPrice=0`. The platform picks one of Jito's tip accounts at random per request.
    String feePercent = "1.5"; // String | Custom fee (referral fee / Add Fee) percentage as a decimal string. Must be paired with exactly one of `fromTokenReferrerWalletAddress` or `toTokenReferrerWalletAddress` (the two referrer addresses are mutually exclusive). Same semantics as `/swap`.  **Range (Solana):** `(0, 10]` — greater than 0, up to 10 inclusive, max 2 decimal places. `\"1.5\"` means 1.5%. Values exceeding 2 decimal places are rejected with `INVALID_FEE_PERCENT` (40466).  **`four.meme` tokens are not supported** — do not pass fee parameters when either side of the pair is a `four.meme` token.
    String fromTokenReferrerWalletAddress = "J5CBzXpcYn6WR2JBah8zU4Yxct985CAFGwXRcFaX2pbS"; // String | Wallet address that receives the fee deducted from the sell token (`FROM_TOKEN` direction). Mutually exclusive with `toTokenReferrerWalletAddress` — providing both returns `CONFLICT_REFERRER_PARAMS` (40468). Solana requires a Base58 pubkey; an invalid format returns `INVALID_REFERRER_ADDRESS` (40467). Must be paired with `feePercent`.
    String toTokenReferrerWalletAddress = "J5CBzXpcYn6WR2JBah8zU4Yxct985CAFGwXRcFaX2pbS"; // String | Wallet address that receives the fee deducted from the buy-token output (`TO_TOKEN` direction). Mutually exclusive with `fromTokenReferrerWalletAddress` — providing both returns `CONFLICT_REFERRER_PARAMS` (40468). Solana requires a Base58 pubkey; an invalid format returns `INVALID_REFERRER_ADDRESS` (40467). Must be paired with `feePercent`. The referrer must already be activated (funded with some SOL) or the request returns `REFERRER_NOT_ACTIVATED` (40469).
    try {
      BuildSolanaSwapInstructionsResponse result = apiInstance.buildSolanaSwapInstructions(binanceChainId, amount, fromTokenAddress, toTokenAddress, slippagePercent, userWalletAddress, quoteId)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .priceImpactProtectionPercent(priceImpactProtectionPercent)
            .autoSlippage(autoSlippage)
            .maxAutoSlippagePercent(maxAutoSlippagePercent)
            .computeUnitLimit(computeUnitLimit)
            .computeUnitPrice(computeUnitPrice)
            .gasLevel(gasLevel)
            .tips(tips)
            .feePercent(feePercent)
            .fromTokenReferrerWalletAddress(fromTokenReferrerWalletAddress)
            .toTokenReferrerWalletAddress(toTokenReferrerWalletAddress)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TradingApi#buildSolanaSwapInstructions");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **binanceChainId** | [**BinanceChainId**](.md)| Chain identifier. Only &#x60;CT_501&#x60; (Solana) is accepted; other values return &#x60;CHAIN_NOT_SUPPORTED&#x60; (40411). | [enum: CT_501] |
| **amount** | **String**| Sell-token amount in the token&#39;s smallest unit (positive integer string, no decimals). | |
| **fromTokenAddress** | **String**| Sell-token mint address (Solana Base58, case-sensitive). | |
| **toTokenAddress** | **String**| Buy-token mint address (Solana Base58, case-sensitive). | |
| **slippagePercent** | **String**| Maximum slippage as a percentage. Solana range 0 to less than 100. \&quot;0.5\&quot; means 0.5%. | |
| **userWalletAddress** | **String**| User wallet address (Solana Base58); becomes the v0 transaction&#39;s &#x60;feePayer&#x60;. | |
| **quoteId** | **String**| quoteId returned from &#x60;/quote&#x60; for the route to execute. TTL ~30s; expired entries return &#x60;QUOTE_EXPIRED&#x60; (40401). | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **priceImpactProtectionPercent** | **String**| Maximum allowed price impact percentage (0–100). Defaults to 90; set to 100 to disable. | [optional] |
| **autoSlippage** | [**AutoSlippage**](.md)| When \&quot;true\&quot;, slippage is auto-derived from market data and overrides &#x60;slippagePercent&#x60;. Defaults to false. | [optional] [enum: true, false] |
| **maxAutoSlippagePercent** | **String**| Cap on auto-derived slippage (only applies when &#x60;autoSlippage&#x3D;true&#x60;). | [optional] |
| **computeUnitLimit** | **String**| Maximum compute units the transaction may consume (analogous to EVM gasLimit). Defaults to the platform value when omitted. | [optional] |
| **computeUnitPrice** | **String**| Priority fee per compute unit (micro-lamports). When omitted, the platform computes a value either from the &#x60;gasLevel&#x60; tier or from chain-side defaults. | [optional] |
| **gasLevel** | [**GasLevel**](.md)| Priority-fee tier; consulted only when &#x60;computeUnitPrice&#x60; is omitted. Defaults to \&quot;average\&quot;. | [optional] [enum: slow, average, fast] |
| **tips** | **String**| Jito tips in SOL for MEV protection. Valid range [0.000000001, 2] (minimum 1 lamport). When specified, it is recommended to set &#x60;computeUnitPrice&#x3D;0&#x60;. The platform picks one of Jito&#39;s tip accounts at random per request. | [optional] |
| **feePercent** | **String**| Custom fee (referral fee / Add Fee) percentage as a decimal string. Must be paired with exactly one of &#x60;fromTokenReferrerWalletAddress&#x60; or &#x60;toTokenReferrerWalletAddress&#x60; (the two referrer addresses are mutually exclusive). Same semantics as &#x60;/swap&#x60;.  **Range (Solana):** &#x60;(0, 10]&#x60; — greater than 0, up to 10 inclusive, max 2 decimal places. &#x60;\&quot;1.5\&quot;&#x60; means 1.5%. Values exceeding 2 decimal places are rejected with &#x60;INVALID_FEE_PERCENT&#x60; (40466).  **&#x60;four.meme&#x60; tokens are not supported** — do not pass fee parameters when either side of the pair is a &#x60;four.meme&#x60; token. | [optional] |
| **fromTokenReferrerWalletAddress** | **String**| Wallet address that receives the fee deducted from the sell token (&#x60;FROM_TOKEN&#x60; direction). Mutually exclusive with &#x60;toTokenReferrerWalletAddress&#x60; — providing both returns &#x60;CONFLICT_REFERRER_PARAMS&#x60; (40468). Solana requires a Base58 pubkey; an invalid format returns &#x60;INVALID_REFERRER_ADDRESS&#x60; (40467). Must be paired with &#x60;feePercent&#x60;. | [optional] |
| **toTokenReferrerWalletAddress** | **String**| Wallet address that receives the fee deducted from the buy-token output (&#x60;TO_TOKEN&#x60; direction). Mutually exclusive with &#x60;fromTokenReferrerWalletAddress&#x60; — providing both returns &#x60;CONFLICT_REFERRER_PARAMS&#x60; (40468). Solana requires a Base58 pubkey; an invalid format returns &#x60;INVALID_REFERRER_ADDRESS&#x60; (40467). Must be paired with &#x60;feePercent&#x60;. The referrer must already be activated (funded with some SOL) or the request returns &#x60;REFERRER_NOT_ACTIVATED&#x60; (40469). | [optional] |

### Return type

[**BuildSolanaSwapInstructionsResponse**](BuildSolanaSwapInstructionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Uncompiled Solana instruction list and ALT addresses returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="buildSwapTransaction"></a>
# **buildSwapTransaction**
> BuildSwapTransactionResponse buildSwapTransaction(binanceChainId, amount, fromTokenAddress, toTokenAddress, userWalletAddress, quoteId).recvWindow(recvWindow).nonce(nonce).slippagePercent(slippagePercent).approveTransaction(approveTransaction).approveAmount(approveAmount).gasLimit(gasLimit).gasLevel(gasLevel).priceImpactProtectionPercent(priceImpactProtectionPercent).autoSlippage(autoSlippage).maxAutoSlippagePercent(maxAutoSlippagePercent).computeUnitLimit(computeUnitLimit).computeUnitPrice(computeUnitPrice).tips(tips).feePercent(feePercent).fromTokenReferrerWalletAddress(fromTokenReferrerWalletAddress).toTokenReferrerWalletAddress(toTokenReferrerWalletAddress).execute();

Build Swap Transaction

Build the on-chain swap calldata for a previously quoted route. The request is matched against the cached quote by &#x60;quoteId&#x60; (TTL ~30s); if the entry has expired, &#x60;QUOTE_EXPIRED&#x60; (40401) is returned, and if the request parameters disagree with the cached quote, &#x60;SWAP_QUOTE_MISMATCH&#x60; (40462) is returned.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TradingApi apiInstance = new TradingApi(defaultClient);
    String binanceChainId = "56"; // String | Unique chain identifier (e.g. \"56\"=BSC, \"1\"=Ethereum, \"CT_501\"=Solana).
    String amount = "1000000"; // String | Sell-token amount in the token's smallest unit (positive integer string, no decimals).
    String fromTokenAddress = "0x55d398326f99059fF775485246999027B3197955"; // String | Sell-token contract address.
    String toTokenAddress = "0x8AC76a51cc950d9822D68b83fE1Ad97B32Cd580d"; // String | Buy-token contract address.
    String userWalletAddress = "0xd8dA6BF26964aF9D7eEd9e03E53415D37aA96045"; // String | User wallet address (transaction sender).
    String quoteId = "a1b2c3d4e5f64a8b9c0d1e2f3a4b5c6d"; // String | quoteId returned from `/quote` for the route to execute. TTL ~30s; expired entries return `QUOTE_EXPIRED` (40401).
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String slippagePercent = "0.5"; // String | Maximum slippage tolerance as a percentage string. Required unless `autoSlippage=true`.  **Range by chain:** - EVM chains (BSC, Ethereum, Base, etc.): `0` to `100` (inclusive) - Solana (`CT_501`): `0` to less than `100` (i.e. `< 100`)  **Range by vendor:** - 1inch, PancakeSwap: `0` to `50` (values above 50 are rejected) - LiFi, LiquidMesh: `0` to `100` (EVM) or `0` to `< 100` (Solana) - Jupiter (Solana): `0` to less than `100`; the value is converted to basis points (`slippageBps = ceil(slippagePercent × 100)`) and applied to the on-chain swap  `\"0.5\"` means 0.5% maximum slippage. When `autoSlippage=true` this field is overridden by the auto-computed value.
    ApproveTransaction approveTransaction = ApproveTransaction.fromValue("true"); // ApproveTransaction | When \"true\", `signatureData` includes the spender address and approve calldata so the client can submit it before the swap. Defaults to false.
    String approveAmount = "1000000"; // String | Override approve amount (smallest unit, positive integer string). Defaults to the swap amount.
    String gasLimit = "200000"; // String | Gas limit override (positive integer string). EVM only.
    GasLevel gasLevel = GasLevel.fromValue("slow"); // GasLevel | Gas price tier. Defaults to \"average\".
    String priceImpactProtectionPercent = "90"; // String | Maximum allowed price impact percentage (0–100). Defaults to 90; set to 100 to disable.
    AutoSlippage autoSlippage = AutoSlippage.fromValue("true"); // AutoSlippage | When `\"true\"`, slippage is auto-derived from market data and overrides `slippagePercent`. Either `slippagePercent` or `autoSlippage=true` must be provided — omitting both returns a parameter error. Defaults to `\"false\"`.
    String maxAutoSlippagePercent = "3"; // String | Cap on auto-derived slippage (only applies when `autoSlippage=true`).
    String computeUnitLimit = "1400000"; // String | Solana only — maximum compute units the transaction may consume (analogous to EVM gasLimit). Applies only when `binanceChainId=CT_501`.
    String computeUnitPrice = "1000"; // String | Solana only — priority fee per compute unit (micro-lamports), analogous to EVM gasPrice. When omitted, the platform computes a value dynamically. Applies only when `binanceChainId=CT_501`.
    String tips = "0.001"; // String | Solana only — Jito tips in SOL for MEV protection. Valid range [0.000000001, 2] (minimum 1 lamport). When specified, it is recommended to set `computeUnitPrice=0`. Applies only when `binanceChainId=CT_501`.
    String feePercent = "1.5"; // String | Custom fee (referral fee / Add Fee) percentage as a decimal string. Must be paired with exactly one of `fromTokenReferrerWalletAddress` or `toTokenReferrerWalletAddress` (the two referrer addresses are mutually exclusive).  **Range by chain:** `(0, 5]` for EVM chains (BSC, Ethereum, Base, etc.) and `(0, 10]` for Solana (`CT_501`) — greater than 0, up to the chain-specific maximum inclusive, max 2 decimal places. `\"1.5\"` means 1.5%. Values exceeding 2 decimal places are rejected with `INVALID_FEE_PERCENT` (40466).  **`four.meme` tokens are not supported** — do not pass fee parameters when either side of the pair is a `four.meme` token.
    String fromTokenReferrerWalletAddress = "0xCbF2B6E6e3D7e9e4e4e4e4e4e4e4e4e4e4e4e4e4"; // String | Wallet address that receives the fee deducted from the sell token (`FROM_TOKEN` direction). Mutually exclusive with `toTokenReferrerWalletAddress` — providing both returns `CONFLICT_REFERRER_PARAMS` (40468). Address format depends on the chain: EVM chains require `0x` + 40 hex chars; Solana (`CT_501`) requires a Base58 pubkey. An invalid format returns `INVALID_REFERRER_ADDRESS` (40467). Must be paired with `feePercent`.
    String toTokenReferrerWalletAddress = "0xCbF2B6E6e3D7e9e4e4e4e4e4e4e4e4e4e4e4e4e4"; // String | Wallet address that receives the fee deducted from the buy-token output (`TO_TOKEN` direction). Mutually exclusive with `fromTokenReferrerWalletAddress` — providing both returns `CONFLICT_REFERRER_PARAMS` (40468). Address format depends on the chain: EVM chains require `0x` + 40 hex chars; Solana (`CT_501`) requires a Base58 pubkey. An invalid format returns `INVALID_REFERRER_ADDRESS` (40467). Must be paired with `feePercent`. On Solana, the referrer must already be activated (funded with some SOL) or the request returns `REFERRER_NOT_ACTIVATED` (40469).
    try {
      BuildSwapTransactionResponse result = apiInstance.buildSwapTransaction(binanceChainId, amount, fromTokenAddress, toTokenAddress, userWalletAddress, quoteId)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .slippagePercent(slippagePercent)
            .approveTransaction(approveTransaction)
            .approveAmount(approveAmount)
            .gasLimit(gasLimit)
            .gasLevel(gasLevel)
            .priceImpactProtectionPercent(priceImpactProtectionPercent)
            .autoSlippage(autoSlippage)
            .maxAutoSlippagePercent(maxAutoSlippagePercent)
            .computeUnitLimit(computeUnitLimit)
            .computeUnitPrice(computeUnitPrice)
            .tips(tips)
            .feePercent(feePercent)
            .fromTokenReferrerWalletAddress(fromTokenReferrerWalletAddress)
            .toTokenReferrerWalletAddress(toTokenReferrerWalletAddress)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TradingApi#buildSwapTransaction");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **binanceChainId** | **String**| Unique chain identifier (e.g. \&quot;56\&quot;&#x3D;BSC, \&quot;1\&quot;&#x3D;Ethereum, \&quot;CT_501\&quot;&#x3D;Solana). | |
| **amount** | **String**| Sell-token amount in the token&#39;s smallest unit (positive integer string, no decimals). | |
| **fromTokenAddress** | **String**| Sell-token contract address. | |
| **toTokenAddress** | **String**| Buy-token contract address. | |
| **userWalletAddress** | **String**| User wallet address (transaction sender). | |
| **quoteId** | **String**| quoteId returned from &#x60;/quote&#x60; for the route to execute. TTL ~30s; expired entries return &#x60;QUOTE_EXPIRED&#x60; (40401). | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **slippagePercent** | **String**| Maximum slippage tolerance as a percentage string. Required unless &#x60;autoSlippage&#x3D;true&#x60;.  **Range by chain:** - EVM chains (BSC, Ethereum, Base, etc.): &#x60;0&#x60; to &#x60;100&#x60; (inclusive) - Solana (&#x60;CT_501&#x60;): &#x60;0&#x60; to less than &#x60;100&#x60; (i.e. &#x60;&lt; 100&#x60;)  **Range by vendor:** - 1inch, PancakeSwap: &#x60;0&#x60; to &#x60;50&#x60; (values above 50 are rejected) - LiFi, LiquidMesh: &#x60;0&#x60; to &#x60;100&#x60; (EVM) or &#x60;0&#x60; to &#x60;&lt; 100&#x60; (Solana) - Jupiter (Solana): &#x60;0&#x60; to less than &#x60;100&#x60;; the value is converted to basis points (&#x60;slippageBps &#x3D; ceil(slippagePercent × 100)&#x60;) and applied to the on-chain swap  &#x60;\&quot;0.5\&quot;&#x60; means 0.5% maximum slippage. When &#x60;autoSlippage&#x3D;true&#x60; this field is overridden by the auto-computed value. | [optional] |
| **approveTransaction** | [**ApproveTransaction**](.md)| When \&quot;true\&quot;, &#x60;signatureData&#x60; includes the spender address and approve calldata so the client can submit it before the swap. Defaults to false. | [optional] [enum: true, false] |
| **approveAmount** | **String**| Override approve amount (smallest unit, positive integer string). Defaults to the swap amount. | [optional] |
| **gasLimit** | **String**| Gas limit override (positive integer string). EVM only. | [optional] |
| **gasLevel** | [**GasLevel**](.md)| Gas price tier. Defaults to \&quot;average\&quot;. | [optional] [enum: slow, average, fast] |
| **priceImpactProtectionPercent** | **String**| Maximum allowed price impact percentage (0–100). Defaults to 90; set to 100 to disable. | [optional] |
| **autoSlippage** | [**AutoSlippage**](.md)| When &#x60;\&quot;true\&quot;&#x60;, slippage is auto-derived from market data and overrides &#x60;slippagePercent&#x60;. Either &#x60;slippagePercent&#x60; or &#x60;autoSlippage&#x3D;true&#x60; must be provided — omitting both returns a parameter error. Defaults to &#x60;\&quot;false\&quot;&#x60;. | [optional] [enum: true, false] |
| **maxAutoSlippagePercent** | **String**| Cap on auto-derived slippage (only applies when &#x60;autoSlippage&#x3D;true&#x60;). | [optional] |
| **computeUnitLimit** | **String**| Solana only — maximum compute units the transaction may consume (analogous to EVM gasLimit). Applies only when &#x60;binanceChainId&#x3D;CT_501&#x60;. | [optional] |
| **computeUnitPrice** | **String**| Solana only — priority fee per compute unit (micro-lamports), analogous to EVM gasPrice. When omitted, the platform computes a value dynamically. Applies only when &#x60;binanceChainId&#x3D;CT_501&#x60;. | [optional] |
| **tips** | **String**| Solana only — Jito tips in SOL for MEV protection. Valid range [0.000000001, 2] (minimum 1 lamport). When specified, it is recommended to set &#x60;computeUnitPrice&#x3D;0&#x60;. Applies only when &#x60;binanceChainId&#x3D;CT_501&#x60;. | [optional] |
| **feePercent** | **String**| Custom fee (referral fee / Add Fee) percentage as a decimal string. Must be paired with exactly one of &#x60;fromTokenReferrerWalletAddress&#x60; or &#x60;toTokenReferrerWalletAddress&#x60; (the two referrer addresses are mutually exclusive).  **Range by chain:** &#x60;(0, 5]&#x60; for EVM chains (BSC, Ethereum, Base, etc.) and &#x60;(0, 10]&#x60; for Solana (&#x60;CT_501&#x60;) — greater than 0, up to the chain-specific maximum inclusive, max 2 decimal places. &#x60;\&quot;1.5\&quot;&#x60; means 1.5%. Values exceeding 2 decimal places are rejected with &#x60;INVALID_FEE_PERCENT&#x60; (40466).  **&#x60;four.meme&#x60; tokens are not supported** — do not pass fee parameters when either side of the pair is a &#x60;four.meme&#x60; token. | [optional] |
| **fromTokenReferrerWalletAddress** | **String**| Wallet address that receives the fee deducted from the sell token (&#x60;FROM_TOKEN&#x60; direction). Mutually exclusive with &#x60;toTokenReferrerWalletAddress&#x60; — providing both returns &#x60;CONFLICT_REFERRER_PARAMS&#x60; (40468). Address format depends on the chain: EVM chains require &#x60;0x&#x60; + 40 hex chars; Solana (&#x60;CT_501&#x60;) requires a Base58 pubkey. An invalid format returns &#x60;INVALID_REFERRER_ADDRESS&#x60; (40467). Must be paired with &#x60;feePercent&#x60;. | [optional] |
| **toTokenReferrerWalletAddress** | **String**| Wallet address that receives the fee deducted from the buy-token output (&#x60;TO_TOKEN&#x60; direction). Mutually exclusive with &#x60;fromTokenReferrerWalletAddress&#x60; — providing both returns &#x60;CONFLICT_REFERRER_PARAMS&#x60; (40468). Address format depends on the chain: EVM chains require &#x60;0x&#x60; + 40 hex chars; Solana (&#x60;CT_501&#x60;) requires a Base58 pubkey. An invalid format returns &#x60;INVALID_REFERRER_ADDRESS&#x60; (40467). Must be paired with &#x60;feePercent&#x60;. On Solana, the referrer must already be activated (funded with some SOL) or the request returns &#x60;REFERRER_NOT_ACTIVATED&#x60; (40469). | [optional] |

### Return type

[**BuildSwapTransactionResponse**](BuildSwapTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Swap transaction data returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getAggregatedQuote"></a>
# **getAggregatedQuote**
> GetAggregatedQuoteResponse getAggregatedQuote(binanceChainId, amount, fromTokenAddress, toTokenAddress).recvWindow(recvWindow).nonce(nonce).vendor(vendor).userWalletAddress(userWalletAddress).feePercent(feePercent).feeSource(feeSource).execute();

Get Aggregated Quote

Query multiple DEX vendors in parallel and return the priced routes sorted by &#x60;toTokenAmount&#x60; (descending). Each route carries an independent &#x60;quoteId&#x60; (TTL ~30s) that the swap endpoint consumes to construct calldata for the chosen route.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TradingApi apiInstance = new TradingApi(defaultClient);
    String binanceChainId = "56"; // String | Unique chain identifier (e.g. \"56\"=BSC, \"1\"=Ethereum, \"CT_501\"=Solana).
    String amount = "1000000"; // String | Sell-token amount in the token's smallest unit (positive integer string, no decimals). Example \"1000000\" = 1 USDT (decimals=6).
    String fromTokenAddress = "0x55d398326f99059fF775485246999027B3197955"; // String | Sell-token contract address. EVM chains require 0x + 40 hex chars; non-EVM chains use the chain's native address format.
    String toTokenAddress = "0x8AC76a51cc950d9822D68b83fE1Ad97B32Cd580d"; // String | Buy-token contract address. Must differ from `fromTokenAddress`.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    Vendor vendor = Vendor.fromValue("LiquidMesh"); // Vendor | Optional vendor selector. When provided, only the specified vendor is queried through the single-vendor fast path; the request bypasses the multi-vendor dual-window, early-return, and price-check logic. Values are case-sensitive and must be one of `LiquidMesh`, `Pancake`, or `Jupiter`. The vendor must also support the requested chain. An unsupported value or unavailable vendor/chain returns `PARAM_ERROR` (40001). When omitted, the API queries all applicable vendors in parallel and returns the aggregated routes.
    String userWalletAddress = "0xd8dA6BF26964aF9D7eEd9e03E53415D37aA96045"; // String | User wallet address. Required when quoting RFQ routes (equity / RWA tokens such as Ondo and BStock). This address is used as the receiver in the RFQ order and must match the wallet that signs `rfq.typedDataToSign` in the subsequent `/swap` call.
    String feePercent = "1.5"; // String | Custom fee (referral fee / Add Fee) percentage as a decimal string. Must be paired with `feeSource` — either both present or both absent.  **Range by chain:** `(0, 5]` for EVM chains (BSC, Ethereum, Base, etc.) and `(0, 10]` for Solana (`CT_501`) — greater than 0, up to the chain-specific maximum inclusive, max 2 decimal places. `\"1.5\"` means 1.5%. Values exceeding 2 decimal places are rejected with `INVALID_FEE_PERCENT` (40466).  **`four.meme` tokens are not supported** — do not pass fee parameters when either side of the pair is a `four.meme` token.
    FeeSource feeSource = FeeSource.fromValue("FROM_TOKEN"); // FeeSource | Fee deduction direction. `FROM_TOKEN` = deduct the fee from the sell token (the amount passed to the DEX is reduced to a net amount); `TO_TOKEN` = deduct the fee from the buy-token output (the user's actual received amount is reduced). Must be paired with `feePercent`.
    try {
      GetAggregatedQuoteResponse result = apiInstance.getAggregatedQuote(binanceChainId, amount, fromTokenAddress, toTokenAddress)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .vendor(vendor)
            .userWalletAddress(userWalletAddress)
            .feePercent(feePercent)
            .feeSource(feeSource)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TradingApi#getAggregatedQuote");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **binanceChainId** | **String**| Unique chain identifier (e.g. \&quot;56\&quot;&#x3D;BSC, \&quot;1\&quot;&#x3D;Ethereum, \&quot;CT_501\&quot;&#x3D;Solana). | |
| **amount** | **String**| Sell-token amount in the token&#39;s smallest unit (positive integer string, no decimals). Example \&quot;1000000\&quot; &#x3D; 1 USDT (decimals&#x3D;6). | |
| **fromTokenAddress** | **String**| Sell-token contract address. EVM chains require 0x + 40 hex chars; non-EVM chains use the chain&#39;s native address format. | |
| **toTokenAddress** | **String**| Buy-token contract address. Must differ from &#x60;fromTokenAddress&#x60;. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **vendor** | [**Vendor**](.md)| Optional vendor selector. When provided, only the specified vendor is queried through the single-vendor fast path; the request bypasses the multi-vendor dual-window, early-return, and price-check logic. Values are case-sensitive and must be one of &#x60;LiquidMesh&#x60;, &#x60;Pancake&#x60;, or &#x60;Jupiter&#x60;. The vendor must also support the requested chain. An unsupported value or unavailable vendor/chain returns &#x60;PARAM_ERROR&#x60; (40001). When omitted, the API queries all applicable vendors in parallel and returns the aggregated routes. | [optional] [enum: LiquidMesh] |
| **userWalletAddress** | **String**| User wallet address. Required when quoting RFQ routes (equity / RWA tokens such as Ondo and BStock). This address is used as the receiver in the RFQ order and must match the wallet that signs &#x60;rfq.typedDataToSign&#x60; in the subsequent &#x60;/swap&#x60; call. | [optional] |
| **feePercent** | **String**| Custom fee (referral fee / Add Fee) percentage as a decimal string. Must be paired with &#x60;feeSource&#x60; — either both present or both absent.  **Range by chain:** &#x60;(0, 5]&#x60; for EVM chains (BSC, Ethereum, Base, etc.) and &#x60;(0, 10]&#x60; for Solana (&#x60;CT_501&#x60;) — greater than 0, up to the chain-specific maximum inclusive, max 2 decimal places. &#x60;\&quot;1.5\&quot;&#x60; means 1.5%. Values exceeding 2 decimal places are rejected with &#x60;INVALID_FEE_PERCENT&#x60; (40466).  **&#x60;four.meme&#x60; tokens are not supported** — do not pass fee parameters when either side of the pair is a &#x60;four.meme&#x60; token. | [optional] |
| **feeSource** | [**FeeSource**](.md)| Fee deduction direction. &#x60;FROM_TOKEN&#x60; &#x3D; deduct the fee from the sell token (the amount passed to the DEX is reduced to a net amount); &#x60;TO_TOKEN&#x60; &#x3D; deduct the fee from the buy-token output (the user&#39;s actual received amount is reduced). Must be paired with &#x60;feePercent&#x60;. | [optional] [enum: FROM_TOKEN, TO_TOKEN] |

### Return type

[**GetAggregatedQuoteResponse**](GetAggregatedQuoteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Quote routes returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getAggregatorSupportedChains"></a>
# **getAggregatorSupportedChains**
> GetAggregatorSupportedChainsResponse getAggregatorSupportedChains().recvWindow(recvWindow).nonce(nonce).binanceChainId(binanceChainId).execute();

Get Aggregator Supported Chains

Return blockchain networks supported by the DEX aggregator. The supported list is dynamically configured server-side and may change over time. Pass &#x60;binanceChainId&#x60; to filter to a single chain; omit it to get the full list.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TradingApi apiInstance = new TradingApi(defaultClient);
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String binanceChainId = "56"; // String | Optional chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC, \"CT_501\"=Solana). When set, only that chain is returned.
    try {
      GetAggregatorSupportedChainsResponse result = apiInstance.getAggregatorSupportedChains()
            .recvWindow(recvWindow)
            .nonce(nonce)
            .binanceChainId(binanceChainId)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TradingApi#getAggregatorSupportedChains");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **binanceChainId** | **String**| Optional chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC, \&quot;CT_501\&quot;&#x3D;Solana). When set, only that chain is returned. | [optional] |

### Return type

[**GetAggregatorSupportedChainsResponse**](GetAggregatorSupportedChainsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Supported chains returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getErc20ApproveTransaction"></a>
# **getErc20ApproveTransaction**
> GetErc20ApproveTransactionResponse getErc20ApproveTransaction(binanceChainId, tokenContractAddress, approveAmount).recvWindow(recvWindow).nonce(nonce).vendor(vendor).execute();

Get ERC-20 Approve Transaction

Build the on-chain transaction data needed to approve the DEX router to spend a user&#39;s ERC-20 token before a swap. Calldata is encoded per the ERC-20 ABI standard (&#x60;approve()&#x60; selector + spender + amount).

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TradingApi apiInstance = new TradingApi(defaultClient);
    String binanceChainId = "1"; // String | Unique chain identifier (e.g. \"1\"=Ethereum, \"56\"=BSC).
    String tokenContractAddress = "0xdAC17F958D2ee523a2206206994597C13D831ec7"; // String | ERC-20 token contract address to approve (0x + 40 hex chars).
    String approveAmount = "1000000"; // String | Approval amount in the token's smallest unit (positive integer string). Example \"1000000\" = 1 USDT (decimals=6).
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String vendor = "PcsXRfq"; // String | RFQ vendor name. **Required for equity / RWA tokens (Ondo, BStock)**; pass the `vendorName` from the `/quote` response (e.g. `InchFusion`, `CowSwap`, `PcsXRfq`). When provided, the backend returns approve calldata targeting the vendor-specific spender contract (e.g. 1inch Router, PcsX Permit2, CowSwap VaultRelayer) instead of the default DEX router.  For regular (non-RWA) tokens, this parameter is optional. If omitted, the backend uses the standard DEX router. If a valid RFQ vendor is passed, the backend resolves that vendor's spender — used when buying Ondo/BStock with a stablecoin, where the from-token (e.g. USDT) itself is not an RFQ token but must be approved to the RFQ vendor's router.
    try {
      GetErc20ApproveTransactionResponse result = apiInstance.getErc20ApproveTransaction(binanceChainId, tokenContractAddress, approveAmount)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .vendor(vendor)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TradingApi#getErc20ApproveTransaction");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **binanceChainId** | **String**| Unique chain identifier (e.g. \&quot;1\&quot;&#x3D;Ethereum, \&quot;56\&quot;&#x3D;BSC). | |
| **tokenContractAddress** | **String**| ERC-20 token contract address to approve (0x + 40 hex chars). | |
| **approveAmount** | **String**| Approval amount in the token&#39;s smallest unit (positive integer string). Example \&quot;1000000\&quot; &#x3D; 1 USDT (decimals&#x3D;6). | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **vendor** | **String**| RFQ vendor name. **Required for equity / RWA tokens (Ondo, BStock)**; pass the &#x60;vendorName&#x60; from the &#x60;/quote&#x60; response (e.g. &#x60;InchFusion&#x60;, &#x60;CowSwap&#x60;, &#x60;PcsXRfq&#x60;). When provided, the backend returns approve calldata targeting the vendor-specific spender contract (e.g. 1inch Router, PcsX Permit2, CowSwap VaultRelayer) instead of the default DEX router.  For regular (non-RWA) tokens, this parameter is optional. If omitted, the backend uses the standard DEX router. If a valid RFQ vendor is passed, the backend resolves that vendor&#39;s spender — used when buying Ondo/BStock with a stablecoin, where the from-token (e.g. USDT) itself is not an RFQ token but must be approved to the RFQ vendor&#39;s router. | [optional] |

### Return type

[**GetErc20ApproveTransactionResponse**](GetErc20ApproveTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Approve transaction data returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getRfqOrderStatus"></a>
# **getRfqOrderStatus**
> GetRfqOrderStatusResponse getRfqOrderStatus(orderId).recvWindow(recvWindow).nonce(nonce).execute();

Get RFQ Order Status

Query the settlement status of an RFQ order by its platform &#x60;orderId&#x60; (returned by &#x60;POST /order/submit&#x60;). Poll this endpoint until &#x60;status&#x60; reaches a terminal state: &#x60;FILLED&#x60; (settled on-chain) or &#x60;FAILED&#x60; (settlement failed).

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TradingApi apiInstance = new TradingApi(defaultClient);
    String orderId = "oc-o-abc123def456"; // String | Platform order ID returned by `POST /order/submit`.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetRfqOrderStatusResponse result = apiInstance.getRfqOrderStatus(orderId)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TradingApi#getRfqOrderStatus");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **orderId** | **String**| Platform order ID returned by &#x60;POST /order/submit&#x60;. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetRfqOrderStatusResponse**](GetRfqOrderStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Order status returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="getTransactionStatus"></a>
# **getTransactionStatus**
> GetTransactionStatusResponse getTransactionStatus(binanceChainId, txHash).recvWindow(recvWindow).nonce(nonce).execute();

Get Transaction Status

Look up the on-chain status of a DEX swap by &#x60;binanceChainId&#x60; + &#x60;txHash&#x60;. Response semantics: - Transaction not found: &#x60;data&#x60; is &#x60;null&#x60; (not HTTP 404). - Transaction failed: &#x60;status&#x3D;failed&#x60; with &#x60;errorMsg&#x60;; aggregator   business fields (&#x60;txType&#x60;, &#x60;dexRouter&#x60;, &#x60;fromTokenDetails&#x60;,   &#x60;toTokenDetails&#x60;) are &#x60;null&#x60;.  - Transaction succeeded: &#x60;status&#x3D;success&#x60; with full token details   when an aggregator event is present.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TradingApi apiInstance = new TradingApi(defaultClient);
    String binanceChainId = "56"; // String | Unique chain identifier (e.g. \"56\"=BSC, \"1\"=Ethereum, \"CT_501\"=Solana).
    String txHash = "0xabc123def4567890abc123def4567890abc123def4567890abc123def4567890"; // String | On-chain transaction hash.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetTransactionStatusResponse result = apiInstance.getTransactionStatus(binanceChainId, txHash)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TradingApi#getTransactionStatus");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **binanceChainId** | **String**| Unique chain identifier (e.g. \&quot;56\&quot;&#x3D;BSC, \&quot;1\&quot;&#x3D;Ethereum, \&quot;CT_501\&quot;&#x3D;Solana). | |
| **txHash** | **String**| On-chain transaction hash. | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetTransactionStatusResponse**](GetTransactionStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Transaction details. &#x60;data&#x60; is null when no record is found. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="quoteAndBuildSwapTransaction"></a>
# **quoteAndBuildSwapTransaction**
> QuoteAndBuildSwapTransactionResponse quoteAndBuildSwapTransaction(binanceChainId, amount, fromTokenAddress, toTokenAddress, userWalletAddress, vendor).recvWindow(recvWindow).nonce(nonce).slippagePercent(slippagePercent).approveTransaction(approveTransaction).approveAmount(approveAmount).gasLimit(gasLimit).gasLevel(gasLevel).priceImpactProtectionPercent(priceImpactProtectionPercent).autoSlippage(autoSlippage).maxAutoSlippagePercent(maxAutoSlippagePercent).computeUnitLimit(computeUnitLimit).computeUnitPrice(computeUnitPrice).tips(tips).feePercent(feePercent).fromTokenReferrerWalletAddress(fromTokenReferrerWalletAddress).toTokenReferrerWalletAddress(toTokenReferrerWalletAddress).execute();

Quote and Build Swap Transaction (Flash API)

Combines quoting and swap-transaction construction into a single call. Unlike the two-step &#x60;/quote&#x60; + &#x60;/swap&#x60; flow, this endpoint does not require a prior &#x60;/quote&#x60; call or a &#x60;quoteId&#x60; — it returns the executable calldata / swapTransaction directly, eliminating one HTTP round-trip. Use this endpoint for latency-sensitive trading when the vendor is known upfront. The response shape is identical to &#x60;/swap&#x60;, so clients can reuse the same response parsing logic for both endpoints.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TradingApi apiInstance = new TradingApi(defaultClient);
    String binanceChainId = "56"; // String | Unique chain identifier (e.g. \"56\"=BSC, \"1\"=Ethereum, \"CT_501\"=Solana).
    String amount = "1000000"; // String | Sell-token amount in the token's smallest unit (positive integer string, no decimals).
    String fromTokenAddress = "0x55d398326f99059fF775485246999027B3197955"; // String | Sell-token contract address.
    String toTokenAddress = "0x8AC76a51cc950d9822D68b83fE1Ad97B32Cd580d"; // String | Buy-token contract address.
    String userWalletAddress = "0xd8dA6BF26964aF9D7eEd9e03E53415D37aA96045"; // String | User wallet address (transaction sender). For Solana, a Base58 system-account address with sufficient SOL for gas.
    Vendor vendor = Vendor.fromValue("LiquidMesh"); // Vendor | Swap vendor to use for this request. **Required** — case-sensitive; must match one of the enum values. Any other value returns `PARAM_ERROR` (40001). For multi-vendor aggregation, use `/swap` with a `quoteId` instead.
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    String slippagePercent = "0.5"; // String | Maximum slippage tolerance as a percentage string. Required unless `autoSlippage=true`.  **Range by chain:** - EVM chains (BSC, Ethereum, Base, etc.): `0` to `100` (inclusive) - Solana (`CT_501`): `0` to less than `100` (i.e. `< 100`)  `\"0.5\"` means 0.5% maximum slippage. When `autoSlippage=true` this field is overridden by the auto-computed value.
    ApproveTransaction approveTransaction = ApproveTransaction.fromValue("true"); // ApproveTransaction | When \"true\", `signatureData` includes the spender address and approve calldata so the client can submit it before the swap. Defaults to false.
    String approveAmount = "1000000"; // String | Override approve amount (smallest unit, positive integer string). Defaults to the swap amount.
    String gasLimit = "200000"; // String | Gas limit override (positive integer string). EVM only.
    GasLevel gasLevel = GasLevel.fromValue("slow"); // GasLevel | Gas price tier. Defaults to \"average\".
    String priceImpactProtectionPercent = "90"; // String | Maximum allowed price impact percentage (0–100). Defaults to 90; set to 100 to disable.
    AutoSlippage autoSlippage = AutoSlippage.fromValue("true"); // AutoSlippage | When `\"true\"`, slippage is auto-derived from market data and overrides `slippagePercent`. Either `slippagePercent` or `autoSlippage=true` must be provided — omitting both returns a parameter error. Defaults to `\"false\"`.
    String maxAutoSlippagePercent = "3"; // String | Cap on auto-derived slippage (only applies when `autoSlippage=true`).
    String computeUnitLimit = "1400000"; // String | Solana only — maximum compute units the transaction may consume (analogous to EVM gasLimit). Applies only when `binanceChainId=CT_501`.
    String computeUnitPrice = "1000"; // String | Solana only — priority fee per compute unit (micro-lamports), analogous to EVM gasPrice. When omitted, the platform computes a value dynamically. Applies only when `binanceChainId=CT_501`.
    String tips = "0.001"; // String | Solana only — Jito tips in SOL for MEV protection. Valid range [0.000000001, 2] (minimum 1 lamport). When specified, it is recommended to set `computeUnitPrice=0`. Applies only when `binanceChainId=CT_501`.
    String feePercent = "1.5"; // String | Custom fee (referral fee / Add Fee) percentage as a decimal string. Must be paired with exactly one of `fromTokenReferrerWalletAddress` or `toTokenReferrerWalletAddress` (the two referrer addresses are mutually exclusive).  **Range by chain:** `(0, 5]` for EVM chains (BSC, Ethereum, Base, etc.) and `(0, 10]` for Solana (`CT_501`) — greater than 0, up to the chain-specific maximum inclusive, max 2 decimal places. `\"1.5\"` means 1.5%. Values exceeding 2 decimal places are rejected with `INVALID_FEE_PERCENT` (40466).  **`four.meme` tokens are not supported** — do not pass fee parameters when either side of the pair is a `four.meme` token.
    String fromTokenReferrerWalletAddress = "0xCbF2B6E6e3D7e9e4e4e4e4e4e4e4e4e4e4e4e4e4"; // String | Wallet address that receives the fee deducted from the sell token (`FROM_TOKEN` direction). Mutually exclusive with `toTokenReferrerWalletAddress` — providing both returns `CONFLICT_REFERRER_PARAMS` (40468). Address format depends on the chain: EVM chains require `0x` + 40 hex chars; Solana (`CT_501`) requires a Base58 pubkey. An invalid format returns `INVALID_REFERRER_ADDRESS` (40467). Must be paired with `feePercent`.
    String toTokenReferrerWalletAddress = "0xCbF2B6E6e3D7e9e4e4e4e4e4e4e4e4e4e4e4e4e4"; // String | Wallet address that receives the fee deducted from the buy-token output (`TO_TOKEN` direction). Mutually exclusive with `fromTokenReferrerWalletAddress` — providing both returns `CONFLICT_REFERRER_PARAMS` (40468). Address format depends on the chain: EVM chains require `0x` + 40 hex chars; Solana (`CT_501`) requires a Base58 pubkey. An invalid format returns `INVALID_REFERRER_ADDRESS` (40467). Must be paired with `feePercent`. On Solana, the referrer must already be activated (funded with some SOL) or the request returns `REFERRER_NOT_ACTIVATED` (40469).
    try {
      QuoteAndBuildSwapTransactionResponse result = apiInstance.quoteAndBuildSwapTransaction(binanceChainId, amount, fromTokenAddress, toTokenAddress, userWalletAddress, vendor)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .slippagePercent(slippagePercent)
            .approveTransaction(approveTransaction)
            .approveAmount(approveAmount)
            .gasLimit(gasLimit)
            .gasLevel(gasLevel)
            .priceImpactProtectionPercent(priceImpactProtectionPercent)
            .autoSlippage(autoSlippage)
            .maxAutoSlippagePercent(maxAutoSlippagePercent)
            .computeUnitLimit(computeUnitLimit)
            .computeUnitPrice(computeUnitPrice)
            .tips(tips)
            .feePercent(feePercent)
            .fromTokenReferrerWalletAddress(fromTokenReferrerWalletAddress)
            .toTokenReferrerWalletAddress(toTokenReferrerWalletAddress)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TradingApi#quoteAndBuildSwapTransaction");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **binanceChainId** | **String**| Unique chain identifier (e.g. \&quot;56\&quot;&#x3D;BSC, \&quot;1\&quot;&#x3D;Ethereum, \&quot;CT_501\&quot;&#x3D;Solana). | |
| **amount** | **String**| Sell-token amount in the token&#39;s smallest unit (positive integer string, no decimals). | |
| **fromTokenAddress** | **String**| Sell-token contract address. | |
| **toTokenAddress** | **String**| Buy-token contract address. | |
| **userWalletAddress** | **String**| User wallet address (transaction sender). For Solana, a Base58 system-account address with sufficient SOL for gas. | |
| **vendor** | [**Vendor**](.md)| Swap vendor to use for this request. **Required** — case-sensitive; must match one of the enum values. Any other value returns &#x60;PARAM_ERROR&#x60; (40001). For multi-vendor aggregation, use &#x60;/swap&#x60; with a &#x60;quoteId&#x60; instead. | [enum: LiquidMesh] |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |
| **slippagePercent** | **String**| Maximum slippage tolerance as a percentage string. Required unless &#x60;autoSlippage&#x3D;true&#x60;.  **Range by chain:** - EVM chains (BSC, Ethereum, Base, etc.): &#x60;0&#x60; to &#x60;100&#x60; (inclusive) - Solana (&#x60;CT_501&#x60;): &#x60;0&#x60; to less than &#x60;100&#x60; (i.e. &#x60;&lt; 100&#x60;)  &#x60;\&quot;0.5\&quot;&#x60; means 0.5% maximum slippage. When &#x60;autoSlippage&#x3D;true&#x60; this field is overridden by the auto-computed value. | [optional] |
| **approveTransaction** | [**ApproveTransaction**](.md)| When \&quot;true\&quot;, &#x60;signatureData&#x60; includes the spender address and approve calldata so the client can submit it before the swap. Defaults to false. | [optional] [enum: true, false] |
| **approveAmount** | **String**| Override approve amount (smallest unit, positive integer string). Defaults to the swap amount. | [optional] |
| **gasLimit** | **String**| Gas limit override (positive integer string). EVM only. | [optional] |
| **gasLevel** | [**GasLevel**](.md)| Gas price tier. Defaults to \&quot;average\&quot;. | [optional] [enum: slow, average, fast] |
| **priceImpactProtectionPercent** | **String**| Maximum allowed price impact percentage (0–100). Defaults to 90; set to 100 to disable. | [optional] |
| **autoSlippage** | [**AutoSlippage**](.md)| When &#x60;\&quot;true\&quot;&#x60;, slippage is auto-derived from market data and overrides &#x60;slippagePercent&#x60;. Either &#x60;slippagePercent&#x60; or &#x60;autoSlippage&#x3D;true&#x60; must be provided — omitting both returns a parameter error. Defaults to &#x60;\&quot;false\&quot;&#x60;. | [optional] [enum: true, false] |
| **maxAutoSlippagePercent** | **String**| Cap on auto-derived slippage (only applies when &#x60;autoSlippage&#x3D;true&#x60;). | [optional] |
| **computeUnitLimit** | **String**| Solana only — maximum compute units the transaction may consume (analogous to EVM gasLimit). Applies only when &#x60;binanceChainId&#x3D;CT_501&#x60;. | [optional] |
| **computeUnitPrice** | **String**| Solana only — priority fee per compute unit (micro-lamports), analogous to EVM gasPrice. When omitted, the platform computes a value dynamically. Applies only when &#x60;binanceChainId&#x3D;CT_501&#x60;. | [optional] |
| **tips** | **String**| Solana only — Jito tips in SOL for MEV protection. Valid range [0.000000001, 2] (minimum 1 lamport). When specified, it is recommended to set &#x60;computeUnitPrice&#x3D;0&#x60;. Applies only when &#x60;binanceChainId&#x3D;CT_501&#x60;. | [optional] |
| **feePercent** | **String**| Custom fee (referral fee / Add Fee) percentage as a decimal string. Must be paired with exactly one of &#x60;fromTokenReferrerWalletAddress&#x60; or &#x60;toTokenReferrerWalletAddress&#x60; (the two referrer addresses are mutually exclusive).  **Range by chain:** &#x60;(0, 5]&#x60; for EVM chains (BSC, Ethereum, Base, etc.) and &#x60;(0, 10]&#x60; for Solana (&#x60;CT_501&#x60;) — greater than 0, up to the chain-specific maximum inclusive, max 2 decimal places. &#x60;\&quot;1.5\&quot;&#x60; means 1.5%. Values exceeding 2 decimal places are rejected with &#x60;INVALID_FEE_PERCENT&#x60; (40466).  **&#x60;four.meme&#x60; tokens are not supported** — do not pass fee parameters when either side of the pair is a &#x60;four.meme&#x60; token. | [optional] |
| **fromTokenReferrerWalletAddress** | **String**| Wallet address that receives the fee deducted from the sell token (&#x60;FROM_TOKEN&#x60; direction). Mutually exclusive with &#x60;toTokenReferrerWalletAddress&#x60; — providing both returns &#x60;CONFLICT_REFERRER_PARAMS&#x60; (40468). Address format depends on the chain: EVM chains require &#x60;0x&#x60; + 40 hex chars; Solana (&#x60;CT_501&#x60;) requires a Base58 pubkey. An invalid format returns &#x60;INVALID_REFERRER_ADDRESS&#x60; (40467). Must be paired with &#x60;feePercent&#x60;. | [optional] |
| **toTokenReferrerWalletAddress** | **String**| Wallet address that receives the fee deducted from the buy-token output (&#x60;TO_TOKEN&#x60; direction). Mutually exclusive with &#x60;fromTokenReferrerWalletAddress&#x60; — providing both returns &#x60;CONFLICT_REFERRER_PARAMS&#x60; (40468). Address format depends on the chain: EVM chains require &#x60;0x&#x60; + 40 hex chars; Solana (&#x60;CT_501&#x60;) requires a Base58 pubkey. An invalid format returns &#x60;INVALID_REFERRER_ADDRESS&#x60; (40467). Must be paired with &#x60;feePercent&#x60;. On Solana, the referrer must already be activated (funded with some SOL) or the request returns &#x60;REFERRER_NOT_ACTIVATED&#x60; (40469). | [optional] |

### Return type

[**QuoteAndBuildSwapTransactionResponse**](QuoteAndBuildSwapTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Swap transaction data returned successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

<a id="submitRfqOrder"></a>
# **submitRfqOrder**
> SubmitRfqOrderResponse submitRfqOrder(submitRfqOrderRequest).recvWindow(recvWindow).nonce(nonce).execute();

Submit RFQ Order

Submit a signed RFQ order to the backend for on-chain settlement via the corresponding vendor relayer. Only used when &#x60;executionMode&#x3D;RFQ&#x60; (equity / RWA tokens such as Ondo and BStock).  **Flow**: &#x60;GET /quote&#x60; → pick an RFQ route → &#x60;GET /swap&#x60; → sign &#x60;rfq.typedDataToSign&#x60; with EIP-712 (&#x60;eth_signTypedData_v4&#x60;) → call this endpoint → poll &#x60;GET /order/{orderId}&#x60; until &#x60;FILLED&#x60; or &#x60;FAILED&#x60;.  **Idempotency**: Submitting with the same &#x60;requestId&#x60; within 30 minutes returns the original result without re-calling the vendor. Use a new UUID for each distinct order; reuse the same UUID when retrying.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.TradingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    TradingApi apiInstance = new TradingApi(defaultClient);
    SubmitRfqOrderRequest submitRfqOrderRequest = new SubmitRfqOrderRequest(); // SubmitRfqOrderRequest | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      SubmitRfqOrderResponse result = apiInstance.submitRfqOrder(submitRfqOrderRequest)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TradingApi#submitRfqOrder");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **submitRfqOrderRequest** | [**SubmitRfqOrderRequest**](SubmitRfqOrderRequest.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**SubmitRfqOrderResponse**](SubmitRfqOrderResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | RFQ order submitted successfully. |  -  |
| **401** | Unauthorized. The request is missing or contains an invalid API key. |  -  |
| **403** | Forbidden. The API key does not have permission to access this endpoint. |  -  |
| **404** | Not Found. The requested resource or endpoint does not exist. |  -  |

