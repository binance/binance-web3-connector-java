# Changelog

## 4.0.0 - 2026-07-29

### Changed (8)

- Added parameter `feePercent`
  - affected methods:
    - `getAggregatedQuote()` (`GET /api/v1/dex/aggregator/quote`)
    - `quoteAndBuildSwapTransaction()` (`GET /api/v1/dex/aggregator/quote-and-swap`)
    - `buildSwapTransaction()` (`GET /api/v1/dex/aggregator/swap`)
    - `buildSolanaSwapInstructions()` (`GET /api/v1/dex/aggregator/swap-instruction`)
- Added parameter `feeSource`
  - affected methods:
    - `getAggregatedQuote()` (`GET /api/v1/dex/aggregator/quote`)
- Added parameter `fromTokenReferrerWalletAddress`
  - affected methods:
    - `quoteAndBuildSwapTransaction()` (`GET /api/v1/dex/aggregator/quote-and-swap`)
    - `buildSwapTransaction()` (`GET /api/v1/dex/aggregator/swap`)
    - `buildSolanaSwapInstructions()` (`GET /api/v1/dex/aggregator/swap-instruction`)
- Added parameter `toTokenReferrerWalletAddress`
  - affected methods:
    - `quoteAndBuildSwapTransaction()` (`GET /api/v1/dex/aggregator/quote-and-swap`)
    - `buildSwapTransaction()` (`GET /api/v1/dex/aggregator/swap`)
    - `buildSolanaSwapInstructions()` (`GET /api/v1/dex/aggregator/swap-instruction`)
- Modified response for `getAggregatedQuote()` (`GET /api/v1/dex/aggregator/quote`):
  - `data`.items: property `feeAmount` added
  - `data`.items: property `feeToken` added
  - `data`.items: property `actualSwapAmount` added
  - `data`.items: item property `feeAmount` added
  - `data`.items: item property `feeToken` added
  - `data`.items: item property `actualSwapAmount` added

- Modified response for `quoteAndBuildSwapTransaction()` (`GET /api/v1/dex/aggregator/quote-and-swap`):
  - `data`.`routerResult`: property `actualSwapAmount` added
  - `data`.`routerResult`: property `feeAmount` added
  - `data`.`routerResult`: property `feeToken` added

- Modified response for `buildSwapTransaction()` (`GET /api/v1/dex/aggregator/swap`):
  - `data`.`routerResult`: property `feeAmount` added
  - `data`.`routerResult`: property `feeToken` added
  - `data`.`routerResult`: property `actualSwapAmount` added

- Modified response for `buildSolanaSwapInstructions()` (`GET /api/v1/dex/aggregator/swap-instruction`):
  - `data`.`routerResult`: property `feeToken` added
  - `data`.`routerResult`: property `feeAmount` added
  - `data`.`routerResult`: property `actualSwapAmount` added

## 1.0.0 - 2026-07-24

### Changed (1)

- Modified response for `getGasLimit()` (`POST /api/v1/dex/pre-transaction/gas-limit`):
  - `data`: property `energyFee` added
  - `data`: property `energyRequired` added
  - `data`: property `freeBandwidth` added
  - `data`: property `freeEnergy` added
  - `data`: property `bandwidthFee` added
  - `data`: property `bandwidthRequired` added
