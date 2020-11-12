FROM maven:3.6-jdk-11 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk11:alpine-slim
COPY --from=builder /app/target/devops-exam-*.jar /devops-exam-0.01-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/devops-exam-0.01-SNAPSHOT.jar"]