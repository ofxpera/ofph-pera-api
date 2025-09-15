# OpenFinance PERA API Mock Server

A Spring Boot server implementing the OpenFinance API for the Philippine Equity and Retirement Account (PERA) that adheres to FAPI (Financial-grade API) standards.

## Overview

This project serves as a mock implementation of the OpenFinance PERA API, providing endpoints for:

- Participant registration and management
- Product registration and management
- OAuth flows and consent management
- PERA-specific operations

The API is defined according to OpenAPI 3.0.3 specifications and follows FAPI security standards, including JWT-based authentication and required FAPI headers.

## Technology Stack

- Java 21
- Spring Boot 3.4.4
- SpringDoc OpenAPI 2.8.6
- Jakarta EE
- Maven

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.8 or higher

### Building the Project

```bash
mvn clean package
```

### Running the Server

```bash
mvn spring-boot:run
```

The server will start on port 8080 with the context path `/voyager-innovation/OFxPERA/1.0.0`.

## API Documentation

The API documentation is available through SpringDoc's Swagger UI:

- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI Specification: http://localhost:8080/api-docs

## Key Features

1. **FAPI Compliance**: Implements security headers and authentication flows according to Financial-grade API specifications.

2. **Participant Management**: APIs for registering and managing financial institutions participating in the PERA ecosystem.

3. **Product Management**: APIs for registering and managing PERA products offered by participants.

4. **Mock Implementation**: Provides simulated responses for testing client applications without connecting to actual financial systems.

## Project Structure

- `src/main/java/io/swagger/api`: API controllers implementing the endpoints
- `src/main/java/io/swagger/model`: Data models representing API requests and responses
- `src/main/java/io/swagger/configuration`: Configuration classes for Spring Boot and Jackson
- `src/main/resources`: Application properties and other resources

## Contributing

Please follow standard Git workflow for contributions:

1. Create a feature branch
2. Make your changes
3. Submit a pull request

## License

Copyright 2024-2025 OFxPERA Contributors

Licensed under the Apache License 2.0 - See LICENSE file for details