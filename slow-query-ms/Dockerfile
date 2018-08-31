FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} slow-query-ms.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/slow-query-ms-ms.jar"]