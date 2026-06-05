# Binance Java Connectors

[![Build Status](https://img.shields.io/github/actions/workflow/status/binance/binance-web3-connector-java/java.yml)](https://github.com/binance/binance-web3-connector-java/actions)
[![Open Issues](https://img.shields.io/github/issues/binance/binance-web3-connector-java)](https://github.com/binance/binance-web3-connector-java/issues)
[![Code Style: Spotless](https://img.shields.io/badge/code%20style-spotless-ff69b4)](https://github.com/diffplug/spotless)
![Java Version](https://img.shields.io/badge/Java-%3E=11-brightgreen)
[![Known Vulnerabilities](https://snyk.io/test/github/binance/binance-web3-connector-java/badge.svg)](https://snyk.io/test/github/binance/binance-web3-connector-java)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Collection of auto-generated java connectors for Binance APIs.

## Prerequisites

Before using the connectors, ensure you have:

- **Java** (version >= 11)

## Available Connectors
- [binance-web3-wallet](clients/web3-wallet) - Web3 Wallet connector

## Documentation

For detailed information, refer to the [Binance API Documentation](https://web3.binance.com/en/dev-docs).

## Installation

Each connector is published as a separate maven dependency. For example:

```xml
<dependency>
  <groupId>io.github.binance</groupId>
  <artifactId>binance-web3-wallet</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Contributing

Since this repository contains auto-generated code using OpenAPI Generator, we encourage you to:

1. Open a GitHub issue to discuss your ideas or report bugs
2. Allow maintainers to implement necessary changes through the code generation process

## Examples
**Wallet**: [Rest API](clients/web3-wallet/example_rest.md)

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.
