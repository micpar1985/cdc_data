FROM openjdk:14-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} cdc_data.jar
ENTRYPOINT ["java","-jar","/cdc_data.jar"]