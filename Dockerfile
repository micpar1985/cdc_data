FROM openjdk:11
ADD build/libs/*.jar /cdc-data.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/cdc-data.jar"]
