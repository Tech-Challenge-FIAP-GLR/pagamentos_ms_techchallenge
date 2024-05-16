FROM openjdk:21
EXPOSE 8181
COPY target/pagamentos_ms_techchallenge-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]