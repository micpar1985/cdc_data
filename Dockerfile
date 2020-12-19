FROM openjdk:14-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","/app.jar"]
