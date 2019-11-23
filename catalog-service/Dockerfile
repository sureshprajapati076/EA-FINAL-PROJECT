FROM openjdk:8
EXPOSE 8080
VOLUME /tmp
COPY target/*.jar catalog-service-1.0.jar
ENTRYPOINT ["java","-jar","/catalog-service-1.0.jar"]