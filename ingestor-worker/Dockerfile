FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} ingestor-worker.jar
EXPOSE 5005
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ingestor-worker.jar"]