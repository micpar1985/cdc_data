FROM gradle:6.7.1-jdk11
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
