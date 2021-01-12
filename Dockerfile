FROM gradle:6.7.1-jdk11
ADD build/libs/*.jar cdc-data.jar
EXPOSE 8080
CMD ["echo","Hello World"]
