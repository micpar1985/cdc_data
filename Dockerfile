FROM gradle:6.7.1-jdk11
ADD build/libs/*.jar cdc-data.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","cdc-data.jar"]
