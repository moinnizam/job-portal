# Use OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and source code
COPY . .

# Give permission to mvnw (important for Linux containers)
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the default Spring Boot port
EXPOSE 8080

# Run the built jar file
CMD ["java", "-jar", "target/job-portal-0.0.1-SNAPSHOT.jar"]
