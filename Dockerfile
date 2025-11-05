# Use official Maven image with JDK 17
FROM maven:3.9.9-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies first (better caching)
COPY pom.xml .

RUN mvn dependency:go-offline -B

# Copy the entire project
COPY . .

# Set environment variables (optional, browser can be overridden at runtime)
ENV BROWSER=edge

# Default command (can be overridden in docker-compose.yml)
CMD ["mvn", "clean", "test", "-Psmoke", "-Dbrowser=${BROWSER}"]
