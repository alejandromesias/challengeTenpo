FROM amazoncorretto:21-alpine
WORKDIR /tenpo
COPY ./target/tenpoChallenge-0.0.1-SNAPSHOT.jar /tenpo
ENTRYPOINT ["java", "-jar", "./tenpoChallenge-0.0.1-SNAPSHOT.jar"]