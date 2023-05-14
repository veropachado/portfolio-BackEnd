FROM amazoncorretto:11-alpine-jdk
EXPOSE 8080
MAINTAINER veronicapachado
COPY target/vp-0.0.1-SNAPSHOT.jar vp-app.jar
ENTRYPOINT ["java","-jar","/vp-app.jar"]


