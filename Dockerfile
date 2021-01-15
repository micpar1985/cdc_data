FROM openjdk:15-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /app.jar
RUN chmod +x /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
