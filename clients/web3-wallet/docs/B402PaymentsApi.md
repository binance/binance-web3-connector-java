# B402PaymentsApi

All URIs are relative to *https://web3.binance.com/build*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getB402SupportedConfigurationsV1**](B402PaymentsApi.md#getB402SupportedConfigurationsV1) | **POST** /api/v1/b402/supported | Get B402 Supported Configurations V1 |
| [**getB402SupportedConfigurationsV2**](B402PaymentsApi.md#getB402SupportedConfigurationsV2) | **POST** /api/v2/b402/supported | Get B402 Supported Configurations V2 |
| [**settleB402PaymentV1**](B402PaymentsApi.md#settleB402PaymentV1) | **POST** /api/v1/b402/settle | Settle B402 Payment V1 |
| [**settleB402PaymentV2**](B402PaymentsApi.md#settleB402PaymentV2) | **POST** /api/v2/b402/settle | Settle B402 Payment V2 |
| [**verifyB402PaymentV1**](B402PaymentsApi.md#verifyB402PaymentV1) | **POST** /api/v1/b402/verify | Verify B402 Payment V1 |
| [**verifyB402PaymentV2**](B402PaymentsApi.md#verifyB402PaymentV2) | **POST** /api/v2/b402/verify | Verify B402 Payment V2 |


<a id="getB402SupportedConfigurationsV1"></a>
# **getB402SupportedConfigurationsV1**
> GetB402SupportedConfigurationsV1Response getB402SupportedConfigurationsV1(getB402SupportedConfigurationsV1Request).recvWindow(recvWindow).nonce(nonce).execute();

Get B402 Supported Configurations V1

Legacy V1 compatibility endpoint. New integrations should use V2. V1 returns &#x60;x402Version&#x3D;1&#x60;, method-specific &#x60;facilitatorAddress&#x60;, and V1 signer-map semantics.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.B402PaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    B402PaymentsApi apiInstance = new B402PaymentsApi(defaultClient);
    GetB402SupportedConfigurationsV1Request getB402SupportedConfigurationsV1Request = new GetB402SupportedConfigurationsV1Request(); // GetB402SupportedConfigurationsV1Request | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetB402SupportedConfigurationsV1Response result = apiInstance.getB402SupportedConfigurationsV1(getB402SupportedConfigurationsV1Request)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling B402PaymentsApi#getB402SupportedConfigurationsV1");
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
| **getB402SupportedConfigurationsV1Request** | [**GetB402SupportedConfigurationsV1Request**](GetB402SupportedConfigurationsV1Request.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetB402SupportedConfigurationsV1Response**](GetB402SupportedConfigurationsV1Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Legacy supported configurations or a B402 business error envelope. |  -  |
| **401** | Unauthorized. The request is missing or contains invalid Web3 API credentials. |  -  |
| **403** | Forbidden. Check the API Key&#39;s B402 Payments permission, IP whitelist, and endpoint allowlist. |  -  |
| **429** | Rate limit exceeded. |  -  |
| **503** | B402 is temporarily unavailable. |  -  |

<a id="getB402SupportedConfigurationsV2"></a>
# **getB402SupportedConfigurationsV2**
> GetB402SupportedConfigurationsV2Response getB402SupportedConfigurationsV2(getB402SupportedConfigurationsV2Request).recvWindow(recvWindow).nonce(nonce).execute();

Get B402 Supported Configurations V2

Return the live x402 V2 payment kinds available to the authenticated Developer Portal project. Use the result to construct HTTP 402 payment requirements. Copy the selected &#x60;extra&#x60; object verbatim and refresh cached configuration periodically.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.B402PaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    B402PaymentsApi apiInstance = new B402PaymentsApi(defaultClient);
    GetB402SupportedConfigurationsV2Request getB402SupportedConfigurationsV2Request = new GetB402SupportedConfigurationsV2Request(); // GetB402SupportedConfigurationsV2Request | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      GetB402SupportedConfigurationsV2Response result = apiInstance.getB402SupportedConfigurationsV2(getB402SupportedConfigurationsV2Request)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling B402PaymentsApi#getB402SupportedConfigurationsV2");
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
| **getB402SupportedConfigurationsV2Request** | [**GetB402SupportedConfigurationsV2Request**](GetB402SupportedConfigurationsV2Request.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**GetB402SupportedConfigurationsV2Response**](GetB402SupportedConfigurationsV2Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Supported configurations returned, or a B402 business error envelope. |  -  |
| **401** | Unauthorized. The request is missing or contains invalid Web3 API credentials. |  -  |
| **403** | Forbidden. Check the API Key&#39;s B402 Payments permission, IP whitelist, and endpoint allowlist. |  -  |
| **429** | Rate limit exceeded. |  -  |
| **503** | B402 is temporarily unavailable. |  -  |

<a id="settleB402PaymentV1"></a>
# **settleB402PaymentV1**
> SettleB402PaymentV1Response settleB402PaymentV1(settleB402PaymentV1Request).recvWindow(recvWindow).nonce(nonce).execute();

Settle B402 Payment V1

Legacy V1 on-chain settlement endpoint. New integrations should use V2. This operation can move real funds and is irreversible. V1 additionally returns &#x60;confirmations&#x60; in the settlement result.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.B402PaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    B402PaymentsApi apiInstance = new B402PaymentsApi(defaultClient);
    SettleB402PaymentV1Request settleB402PaymentV1Request = new SettleB402PaymentV1Request(); // SettleB402PaymentV1Request | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      SettleB402PaymentV1Response result = apiInstance.settleB402PaymentV1(settleB402PaymentV1Request)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling B402PaymentsApi#settleB402PaymentV1");
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
| **settleB402PaymentV1Request** | [**SettleB402PaymentV1Request**](SettleB402PaymentV1Request.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**SettleB402PaymentV1Response**](SettleB402PaymentV1Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Legacy settlement result or a B402 business error envelope. |  -  |
| **401** | Unauthorized. The request is missing or contains invalid Web3 API credentials. |  -  |
| **403** | Forbidden. Check the API Key&#39;s B402 Payments permission, IP whitelist, and endpoint allowlist. |  -  |
| **429** | Rate limit exceeded. |  -  |
| **503** | B402 is temporarily unavailable. |  -  |

<a id="settleB402PaymentV2"></a>
# **settleB402PaymentV2**
> SettleB402PaymentV2Response settleB402PaymentV2(settleB402PaymentV2Request).recvWindow(recvWindow).nonce(nonce).execute();

Settle B402 Payment V2

Submit a verified x402 V2 authorization on-chain. This operation can move real funds and is irreversible. For &#x60;permit2-upto&#x60;, provide &#x60;settleAmount&#x60; in atomic units. Business failure is returned as HTTP 200 with &#x60;data.success&#x3D;false&#x60;; reconcile any non-empty transaction hash before retrying.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.B402PaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    B402PaymentsApi apiInstance = new B402PaymentsApi(defaultClient);
    SettleB402PaymentV2Request settleB402PaymentV2Request = new SettleB402PaymentV2Request(); // SettleB402PaymentV2Request | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      SettleB402PaymentV2Response result = apiInstance.settleB402PaymentV2(settleB402PaymentV2Request)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling B402PaymentsApi#settleB402PaymentV2");
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
| **settleB402PaymentV2Request** | [**SettleB402PaymentV2Request**](SettleB402PaymentV2Request.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**SettleB402PaymentV2Response**](SettleB402PaymentV2Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Settlement result, or a B402 business error envelope. |  -  |
| **401** | Unauthorized. The request is missing or contains invalid Web3 API credentials. |  -  |
| **403** | Forbidden. Check the API Key&#39;s B402 Payments permission, IP whitelist, and endpoint allowlist. |  -  |
| **429** | Rate limit exceeded. |  -  |
| **503** | B402 is temporarily unavailable. |  -  |

<a id="verifyB402PaymentV1"></a>
# **verifyB402PaymentV1**
> VerifyB402PaymentV1Response verifyB402PaymentV1(verifyB402PaymentV1Request).recvWindow(recvWindow).nonce(nonce).execute();

Verify B402 Payment V1

Legacy V1 off-chain verification endpoint. New integrations should use V2. Portal identity is resolved from the API Key project, so &#x60;merchantId&#x60; is omitted from the external request.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.B402PaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    B402PaymentsApi apiInstance = new B402PaymentsApi(defaultClient);
    VerifyB402PaymentV1Request verifyB402PaymentV1Request = new VerifyB402PaymentV1Request(); // VerifyB402PaymentV1Request | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      VerifyB402PaymentV1Response result = apiInstance.verifyB402PaymentV1(verifyB402PaymentV1Request)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling B402PaymentsApi#verifyB402PaymentV1");
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
| **verifyB402PaymentV1Request** | [**VerifyB402PaymentV1Request**](VerifyB402PaymentV1Request.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**VerifyB402PaymentV1Response**](VerifyB402PaymentV1Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Legacy verification result or a B402 business error envelope. |  -  |
| **401** | Unauthorized. The request is missing or contains invalid Web3 API credentials. |  -  |
| **403** | Forbidden. Check the API Key&#39;s B402 Payments permission, IP whitelist, and endpoint allowlist. |  -  |
| **429** | Rate limit exceeded. |  -  |
| **503** | B402 is temporarily unavailable. |  -  |

<a id="verifyB402PaymentV2"></a>
# **verifyB402PaymentV2**
> VerifyB402PaymentV2Response verifyB402PaymentV2(verifyB402PaymentV2Request).recvWindow(recvWindow).nonce(nonce).execute();

Verify B402 Payment V2

Validate an x402 V2 payment authorization off-chain without spending funds or broadcasting a transaction. Portal identity is resolved from the authenticated API Key project; omit &#x60;merchantId&#x60;. A validation failure is returned as HTTP 200 with &#x60;data.isValid&#x3D;false&#x60;.

### Example
```java
// Import classes:
import com.binance.connector.client.web3_wallet.ApiClient;
import com.binance.connector.client.web3_wallet.ApiException;
import com.binance.connector.client.web3_wallet.Configuration;
import com.binance.connector.client.web3_wallet.models.*;
import com.binance.connector.client.web3_wallet.rest.api.B402PaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web3.binance.com/build");

    B402PaymentsApi apiInstance = new B402PaymentsApi(defaultClient);
    VerifyB402PaymentV2Request verifyB402PaymentV2Request = new VerifyB402PaymentV2Request(); // VerifyB402PaymentV2Request | 
    Long recvWindow = 5000L; // Long | Allowed time deviation in milliseconds (default: 5000, max: 60000).
    String nonce = "unique-nonce-string"; // String | Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted.
    try {
      VerifyB402PaymentV2Response result = apiInstance.verifyB402PaymentV2(verifyB402PaymentV2Request)
            .recvWindow(recvWindow)
            .nonce(nonce)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling B402PaymentsApi#verifyB402PaymentV2");
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
| **verifyB402PaymentV2Request** | [**VerifyB402PaymentV2Request**](VerifyB402PaymentV2Request.md)|  | |
| **recvWindow** | **Long**| Allowed time deviation in milliseconds (default: 5000, max: 60000). | [optional] |
| **nonce** | **String**| Unique request identifier for anti-replay; falls back to X-OC-SIGN if omitted. | [optional] |

### Return type

[**VerifyB402PaymentV2Response**](VerifyB402PaymentV2Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Verification result, or a B402 business error envelope. |  -  |
| **401** | Unauthorized. The request is missing or contains invalid Web3 API credentials. |  -  |
| **403** | Forbidden. Check the API Key&#39;s B402 Payments permission, IP whitelist, and endpoint allowlist. |  -  |
| **429** | Rate limit exceeded. |  -  |
| **503** | B402 is temporarily unavailable. |  -  |

