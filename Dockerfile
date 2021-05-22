FROM openjdk:11-jdk-slim as builder
COPY . /src/java
WORKDIR /src/java
CMD ["/bin/bash"]
EXPOSE 8081
RUN apt-get update && apt-get install librrds-perl rrdtool -y
ENTRYPOINT [ "java","-jar","/app/build/libs/spring-project-0.1.0.jar" ]
