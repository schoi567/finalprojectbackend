#FROM openjdk:11-jre-slim
#ADD target/*.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]

#FROM openjdk:11 
##ADD target/user-mysql1.jar user-mysql1.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "user-mysql1.jar"]


FROM openjdk:11 
ADD target/backend-0.0.1-SNAPSHOT.jar backend-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]



#FROM openjdk:11-jre-slim
#ADD target/*.user-mysql1.jar user-mysql1.jar
#ENTRYPOINT ["java", "-jar", "user-mysql1.jar"]


#FROM maven:3.6.0-jdk-11-slim AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package

 
#FROM openjdk:11-jre-slim
#COPY --from=build /home/app/target/user-mysql1.jar /usr/local/lib/user-mysql1.jar
#EXPOSE 8089
#ENTRYPOINT ["java","-Djava.security.egd=file:dockdev/./urandom","-jar","/usr/local/lib/ user-mysql1.jar"]

