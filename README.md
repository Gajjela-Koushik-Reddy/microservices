# Microservices Project

## Overview
This project is a collection of microservices built using Spring Boot and follows the MVC (Model-View-Controller) architecture. Each microservice is designed to handle a specific domain or functionality and communicates with others through RESTful APIs.

## Table of Contents
- [Overview](#overview)
- [Architecture](#architecture)
- [Microservices](#microservices)
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Architecture
The project consists of the following microservices:
- **User Service**: Manages user-related operations.
- **Account Service**: Handles account-related functionalities.
- **Loan Service**: Manages loan processing and information.

Each microservice follows the MVC pattern:
- **Controller**: Handles HTTP requests and responses.
- **Service**: Contains business logic.
- **Repository**: Manages data persistence.

## Microservices
1. **User Service**
    - Manages user-related operations.
    - Exposes APIs for user registration, authentication, and profile management.
    
2. **Account Service**
    - Handles account management.
    - Provides endpoints for creating, updating, and viewing accounts.
    
3. **Loan Service**
    - Manages loan processing and information.
    - Offers APIs for applying for loans, viewing loan status, and payment processing.

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6.0+
- Docker (optional, for containerization)
- Kubernetes (optional, for orchestration)

### Installation
1. Clone the repository:
    ```sh
    git clone git@github.com:Gajjela-Koushik-Reddy/microservices.git
    cd your-repo-name
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

### Running the Application
1. Start the microservices:
    ```sh
    cd user-service
    mvn spring-boot:run

    cd ../account-service
    mvn spring-boot:run

    cd ../loan-service
    mvn spring-boot:run
    ```

2. Alternatively, you can run all services using Docker Compose:
    ```sh
    docker-compose up
    ```

### API Documentation
API documentation is available via Swagger. Once the services are running, you can access the Swagger UI at:
- **User Service**: `http://localhost:8080/swagger-ui.html`
- **Account Service**: `http://localhost:8081/swagger-ui.html`
- **Loan Service**: `http://localhost:8082/swagger-ui.html`

## Testing
To run the test cases for each service, use the following command:
```sh
mvn test

