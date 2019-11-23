FROM openjdk:8
EXPOSE 8080
VOLUME /tmp
COPY target/*.jar elasticsearch-service-1.0.jar
ENTRYPOINT ["java","-jar","/elasticsearch-service-1.0.jar"]