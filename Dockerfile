FROM openjdk:11
ADD build/libs/*.jar /cdc-data.jar
COPY run.sh /run.sh
EXPOSE 8080
ENTRYPOINT ["/run.sh"]
