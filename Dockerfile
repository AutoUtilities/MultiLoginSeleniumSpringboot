# Use official Java 17 JDK as base
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first for caching
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Download dependencies (offline to speed up builds)
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

# Copy the rest of the backend source code
COPY src ./src

# Build the Spring Boot application
RUN ./mvnw clean package -DskipTests

# Expose port Spring Boot runs on
EXPOSE 8080

# Default command to run the jar
CMD ["java", "-jar", "target/MultiLoginSeleniumSpringboot-0.0.1-SNAPSHOT.jar"]
