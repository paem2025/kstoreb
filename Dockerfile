FROM eclipse-temurin:23-jdk AS build
WORKDIR /workspace

COPY .mvn .mvn
COPY mvnw mvnw
COPY pom.xml pom.xml
RUN chmod +x mvnw

COPY src src
RUN ./mvnw -B -DskipTests clean package

FROM eclipse-temurin:23-jre
WORKDIR /app

ENV PORT=8080

COPY --from=build /workspace/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75.0", "-jar", "/app/app.jar"]
