FROM openjdk:11
COPY target/agendatel-0.0.1-SNAPSHOT.jar agendatel-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/agendatel-0.0.1-SNAPSHOT.jar"]

