FROM openjdk

COPY ./target/Extract-metadata-mp3-0.0.1-SNAPSHOT.jar Extract-metadata-mp3-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "Extract-metadata-mp3-0.0.1-SNAPSHOT.jar"]