# NextRound-API

NextRound is a Spring Boot application that generates Tournament Brackets for Sports. This API provides endpoints for managing tournament brackets and related functionality.

## Technologies

- Java 17
- Spring Boot 3.2.0
- Maven 3.9+
- Docker

## Prerequisites

### Running Without Docker
- Java 17 or higher
- Maven 3.9 or higher

### Running With Docker
- Docker installed and running

## Getting Started

### Running Without Docker

1. **Clone the repository:**
   ```bash
   git clone https://github.com/jwlai/NextRound-API.git
   cd NextRound-API
   ```

2. **Build the application:**
   ```bash
   mvn clean package
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```
   
   Or run the JAR directly:
   ```bash
   java -jar target/nextround-api-0.0.1-SNAPSHOT.jar
   ```

4. **Verify the application is running:**
   
   Open your browser or use curl to test the endpoints:
   ```bash
   curl http://localhost:8080/api/
   curl http://localhost:8080/api/health
   ```

### Running With Docker

1. **Clone the repository:**
   ```bash
   git clone https://github.com/jwlai/NextRound-API.git
   cd NextRound-API
   ```

2. **Build the application first:**
   ```bash
   mvn clean package
   ```

3. **Build the Docker image:**
   ```bash
   docker build -t nextround-api .
   ```

4. **Run the Docker container:**
   ```bash
   docker run -p 8080:8080 nextround-api
   ```
   
   Or run in detached mode:
   ```bash
   docker run -d -p 8080:8080 --name nextround-api nextround-api
   ```

5. **Verify the application is running:**
   
   Open your browser or use curl to test the endpoints:
   ```bash
   curl http://localhost:8080/api/
   curl http://localhost:8080/api/health
   ```

6. **Stop the container:**
   
   If running in foreground, press `Ctrl+C`.
   
   If running in detached mode:
   ```bash
   docker stop nextround-api
   docker rm nextround-api
   ```

## API Endpoints

- `GET /api/` - Welcome message and API information
- `GET /api/health` - Health check endpoint

## Development

### Running Tests

```bash
mvn test
```

### Building for Production

```bash
mvn clean package -DskipTests
```

## Project Structure

```
NextRound-API/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/nextround/api/
│   │   │       ├── NextRoundApiApplication.java
│   │   │       └── controller/
│   │   │           └── HealthController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/nextround/api/
│               └── NextRoundApiApplicationTests.java
├── Dockerfile
├── pom.xml
└── README.md
```

## License

This project is licensed under the MIT License.
