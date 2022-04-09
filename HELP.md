# Getting Started
**Run this 3 commands in terminal**

./mvnw clean install
docker build -t spring-aoe .
docker run --rm -p 8080:8080 --name spring-aoe spring-aoe


**endpoint**
http://127.0.0.1:8080/units