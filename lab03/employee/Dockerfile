FROM openjdk:11
COPY /target/employee-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=k8s","-jar", "app.jar"]