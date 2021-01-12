FROM gradle:6.7.1-jdk11
EXPOSE 8080
ADD build/libs/*.jar cdc-data.jar
ENTRYPOINT ["echo","Hello World"]
