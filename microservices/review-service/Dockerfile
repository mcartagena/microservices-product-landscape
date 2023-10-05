FROM openjdk:17.0.2-jdk

EXPOSE 8080

ADD ./build/libs/*SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]