FROM gradle:6.7.1-jdk:15
EXPOSE 8080
ADD target/cdc-data.jar cdc-data.jar
ENTRYPOINT ["java","-jar","/cdc-data.jar"]
