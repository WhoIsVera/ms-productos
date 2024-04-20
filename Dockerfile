FROM openjdk:17-jdk-alpine 
COPY "./target/ms-productos-0.0.1-SNAPSHOT.jar" "app.jar"   
EXPOSE 8095   
ENTRYPOINT ["java","-jar","app.jar"]