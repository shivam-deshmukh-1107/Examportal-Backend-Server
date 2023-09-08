FROM maven:3.8.3-openjdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests


FROM maven:3.8.1-openjdk-17-slim
COPY --from=build /target/examserver-0.0.1-SNAPSHOT.jar examserver.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "examserver.jar"]
