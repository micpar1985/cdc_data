FROM openjdk:11.0.9-buster@sha256:c669a7370b96d3276f669334a937a48a0334c93ced2a1a77b0e961a393aa737c
ADD build/libs/*.jar /cdc-data.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/cdc-data.jar"]
