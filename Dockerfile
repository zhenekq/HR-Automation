FROM openjdk:8
EXPOSE 8080
ADD target/mifort-automation-api.jar mifort-automation-api.jar
ENTRYPOINT ["java", "-jar", "/mifort-automation-api.jar"]