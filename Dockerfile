FROM openjdk:8u212-jdk-slim as builder

WORKDIR /source
COPY . /source

RUN ./gradlew shadowJar

FROM openjdk:8u212-jre-slim
WORKDIR /app
COPY --from=builder /source/dropwizard-template/root.jar /source/dropwizard-template/local.yaml ./

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "root.jar", "server", "local.yaml"]
