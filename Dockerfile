FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/portfolio-0.0.1-SNAPSHOT.jar"]