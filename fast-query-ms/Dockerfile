FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} fast-query-ms.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/fast-query-ms.jar"]