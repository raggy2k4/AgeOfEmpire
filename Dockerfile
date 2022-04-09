FROM openjdk:11
EXPOSE 8080
ADD target/spring-boot-aoe.jar spring-boot-aoe.jar
CMD ["java", "-jar", "spring-boot-aoe.jar"]