FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY ./e16095-assignment/e16095-assignment-0.0.1-SNAPSHOT.jar web_app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/web_app.jar"]
