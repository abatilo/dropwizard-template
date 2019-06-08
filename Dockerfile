FROM openjdk:11-jdk as builder

WORKDIR /source
COPY . /source

RUN ./gradlew shadowJar

FROM openjdk:11-jdk
WORKDIR /app
COPY --from=builder /source/dropwizard-template/root.jar /source/dropwizard-template/local.yaml ./

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "root.jar", "server", "local.yaml"]
