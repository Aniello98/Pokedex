FROM maven:3.8.8-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk
COPY --from=build target/demo-1.0.0.jar pokemon-api-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/pokemon-api-server-1.0.0.jar"]