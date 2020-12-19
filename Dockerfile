FROM openjdk:14-jdk-alpine
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","/app.jar"]
