FROM maven AS MAVEN_BUILD
COPY ./ ./
RUN mvn clean package

FROM openjdk:11
COPY --from=MAVEN_BUILD /target/*.jar ./
ENTRYPOINT ["java", "-jar", "/application-1.0.0.jar"]
