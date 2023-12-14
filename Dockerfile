FROM eclipse-temurin:17

ADD target/bigcicdback-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]