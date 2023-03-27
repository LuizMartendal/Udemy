FROM openjdk:19
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 80:80
ENTRYPOINT ["java","-jar","app.jar"]