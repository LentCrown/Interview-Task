FROM adoptopenjdk/openjdk11
ADD target/Interview-0.0.1.jar Interview.jar
EXPOSE 80
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Interview.jar"]