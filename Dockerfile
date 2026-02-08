# Use JRE for runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy the pre-built jar file
# You need to build the jar first using: mvn clean package
COPY target/nextround-api-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
