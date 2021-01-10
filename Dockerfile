FROM gradle:6.7.1-jdk15 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon


FROM openjdk:15
EXPOSE 8080
ADD target/cdc-data.jar cdc-data.jar
ENTRYPOINT ["java","-jar","/cdc-data.jar"]
