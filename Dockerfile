FROM amazoncorretto:15
EXPOSE 8080
ADD target/cdc-data.jar cdc-data.jar
ENTRYPOINT ["java","-jar","/cdc-data.jar"]
