FROM openjdk:14-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /tmp
WORKDIR /tmp
ENTRYPOINT ["java","Main"]
