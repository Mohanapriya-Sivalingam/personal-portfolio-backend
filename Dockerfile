FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY target/portfolio-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]