FROM openjdk:11
EXPOSE 8080:8080
RUN mkdir /app
COPY ./../kotlin/build/libs/kotlin-0.0.1-all.jar /app/ktor-docker-sample.jar
ENTRYPOINT ["java","-jar","/app/ktor-docker-sample.jar"]