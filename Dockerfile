FROM openjdk:11-jdk-slim
COPY "./target/spring-jeccs-1.0.war" "app.war"
EXPOSE 9000
ENTRYPOINT ["java","-jar", "app.war"]
