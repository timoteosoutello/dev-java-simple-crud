## Brief Description

This is simple API using:

- Spring Boot
- Spring Data 
- spring Data Rest 
- Spring Actuator 
- Swagger 
- Open JDK 11 version

## Configure environment
1. Installing Java 11 - Download JDK 
   1. Set JAVA_HOME env based on where the JDK will be installed. Add to PATH as JAVA_HOME\bin. 
   2. To know if the java is installed, run *java -version* command on prompt should work 
2. Installing Maven
   1. Download the latest version on https://maven.apache.org/download.cgi
   2. Define the variable MVN_HOME on your OS pointing to the extracted directory. Add to the PATH variable the MVN_HOME\bin.
   3. To know if the mvn is installed, run the command *mvn --version* and check if its recognition by the SO or not;
3. Installing a database
   1. Currently H2, but if other is used, change the pom dependency and the spring parameters *spring.datasource.url / spring.datasource.driver-class-name* as necessary 

## Running the App

**1-) Via Maven**
mvn spring-boot:run

**2-) Via Docker**

**Building up**:

docker build --no-cache -t dev-java-simple-crud .

docker run -d --restart always -p 8787:8787 --name dev-java-simple-crud -t dev-java-simple-crud

**Publishing (with tag version)**:

docker build --no-cache -t tsoutello/dev-java-simple-crud:1.0.0 --tag tsoutello/dev-java-simple-crud:1.0.0 .

docker push tsoutello/dev-java-simple-crud:1.0.0

**Killing the container**:

docker container kill dev-java-simple-crud

docker container prune

**Using Docker Swarm / Docker Compose**

docker-compose up

docker stack deploy --prune --compose-file docker-compose.yml dev-java-simple-crud

**3-) Via Kubernetes**

kubectl apply -f deployment.yaml

kubectl port-forward svc/spring 8787:8787


**Kubernetes - Deployment YAML creation:**

kubectl create deployment demo --image=spring-backend --dry-run -o=yaml > deployment.yaml 

kubectl create service clusterip demo --tcp=9797:9797 --dry-run -o=yaml >> deployment.yaml


## Accessing application by swagger-UI

- App: http://localhost:9797/spring-data-rest/api  
- Swagger: http://localhost:9797/spring-data-rest/api/swagger-ui.html#/
- curl localhost:9797/spring-data-rest/api/actuator/health