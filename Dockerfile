# syntax=docker/dockerfile:1
FROM amazoncorretto:8-alpine3.13 as base

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline

COPY src ./src

FROM base as test
RUN ["./mvnw", "test"]

FROM base as development
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.profiles=devd"]

FROM base as build
RUN ./mvnw package

FROM openjdk:11-jre-slim as production
EXPOSE 8080

COPY --from=build /app/target/drones-*.war /drones.war

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/drones.war"]