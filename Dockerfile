FROM openjdk:8-jre
COPY target/backend-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT java -jar ${JAVA_OPTS} /app.jar
