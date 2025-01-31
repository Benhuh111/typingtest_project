This project is a Spring Boot application that allows users to submit and retrieve typing test results.

## Features
- Submit typing test results
- Retrieve typing test results by user ID

## Technologies
- Java
- Spring Boot
- Maven
- Docker

## Setup
1. Clone the repository
2. Build the project: `./mvnw clean install`
3. Run the application: `./mvnw spring-boot:run`

## Docker
To build and run the Docker container:
1. Build the Docker image: `docker build -t typing_test_project .`
2. Run the Docker container: `docker run -p 8080:8080 typing_test_project`

## CI/CD
This project uses GitHub Actions for Continuous Integration. The workflow file is located at `.github/workflows/ci.yml`.