# Use official Maven + JDK 17
FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /app

# Cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy project files
COPY . .

# This CMD is overridden by docker-compose
CMD ["bash", "-c", "echo 'Use docker-compose to run specific test runner'"]
