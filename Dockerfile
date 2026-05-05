
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy all files
COPY . .

# Build the project
RUN ./mvnw clean package -DskipTests

# Run the app (UPDATE JAR NAME)
CMD ["java", "-jar", "target/portfolio-0.0.1-SNAPSHOT.jar"]