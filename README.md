# NextRound-API

NextRound is a Spring Boot application that generates Tournament Brackets for Sports. This API provides endpoints for managing tournament brackets and related functionality.

## Technologies

- Java 21 (LTS)
- Spring Boot 4.0.2
- Maven 3.9+
- Docker

## Installation Guide

Before you can run this application, you need to install the required tools. Follow the instructions for your operating system below.

### Windows Installation

#### 1. Install Java 21

**Option A: Using Installer (Recommended)**
1. Download Eclipse Temurin JDK 21 from [Adoptium](https://adoptium.net/temurin/releases/?version=21)
2. Select:
   - Operating System: Windows
   - Architecture: x64 (or arm64 if you have ARM-based Windows)
   - Package Type: JDK
3. Download the `.msi` installer and run it
4. Follow the installation wizard (keep default settings)
5. Verify installation by opening Command Prompt and running:
   ```cmd
   java -version
   ```

**Option B: Using Package Manager (Chocolatey)**
1. Open PowerShell as Administrator
2. If Chocolatey is not installed, install it first:
   ```powershell
   Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
   ```
3. Install Java 21:
   ```powershell
   choco install temurin21
   ```

#### 2. Install Maven

**Option A: Manual Installation**
1. Download Maven from [Apache Maven](https://maven.apache.org/download.cgi)
2. Extract the archive to `C:\Program Files\Apache\maven`
3. Add Maven to PATH:
   - Open System Properties → Environment Variables
   - Under System Variables, edit `Path`
   - Add: `C:\Program Files\Apache\maven\bin`
4. Verify installation:
   ```cmd
   mvn -version
   ```

**Option B: Using Chocolatey**
```powershell
choco install maven
```

#### 3. Install Docker Desktop (Optional)

1. Download Docker Desktop from [Docker](https://www.docker.com/products/docker-desktop/)
2. Run the installer and follow the setup wizard
3. Restart your computer if prompted
4. Start Docker Desktop
5. Verify installation:
   ```cmd
   docker --version
   ```

### macOS Installation

#### 1. Install Java 21

**Option A: Using Homebrew (Recommended)**
1. Open Terminal
2. Install Homebrew if not already installed:
   ```bash
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```
3. Install Java 21:
   ```bash
   brew install openjdk@21
   ```
4. Link the Java installation:
   ```bash
   sudo ln -sfn $(brew --prefix)/opt/openjdk@21/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-21.jdk
   ```
5. Verify installation:
   ```bash
   java -version
   ```

**Option B: Using Installer**
1. Download Eclipse Temurin JDK 21 from [Adoptium](https://adoptium.net/temurin/releases/?version=21)
2. Select:
   - Operating System: macOS
   - Architecture: x64 or aarch64 (for Apple Silicon)
   - Package Type: JDK
3. Download the `.pkg` installer and run it
4. Follow the installation wizard

#### 2. Install Maven

**Using Homebrew (Recommended)**
```bash
brew install maven
```

**Verify installation:**
```bash
mvn -version
```

#### 3. Install Docker Desktop (Optional)

1. Download Docker Desktop from [Docker](https://www.docker.com/products/docker-desktop/)
2. Open the `.dmg` file and drag Docker to Applications
3. Launch Docker Desktop from Applications
4. Follow the setup wizard
5. Verify installation:
   ```bash
   docker --version
   ```

## Prerequisites

### Running Without Docker
- Java 21 or higher
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
