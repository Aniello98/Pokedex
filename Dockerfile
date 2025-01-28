FROM openjdk:17-jdk
COPY target/demo-1.0.0.jar pokemon-api-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/pokemon-api-server-1.0.0.jar"]