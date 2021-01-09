## Brief Description

This is simple API using:

- Spring Boot
- Spring Data 
- spring Data Rest 
- Spring Actuator 
- Swagger 
- Open JDK 11 version
- Okta Integration
- Oauth2

## Configure environment
1. Installing Java 11 - Download JDK 
   1. Set JAVA_HOME env based on where the JDK will be installed. Add to PATH as JAVA_HOME\bin. 
   2. To know if the java is installed, run *java -version* command on prompt should work 
2. Installing Maven
   1. Download the latest version on https://maven.apache.org/download.cgi
   2. Define the variable MVN_HOME on your OS pointing to the extracted directory. Add to the PATH variable the MVN_HOME\bin.
   3. To know if the mvn is installed, run the command *mvn --version* and check if its recognition by the SO or not;
3. Installing a database
   1. Currently **H2** is being used, but if other db is used, change the pom dependency and the spring parameters *spring.datasource.url / spring.datasource.driver-class-name* as required

## Running the App

**1-) Via Maven**
mvn spring-boot:run

**2-) Via Docker**

**Building up**:

docker build --compress --force-rm --no-cache -t dev-java-simple-crud:latest .

docker run -d --restart always -p 8787:8787 --name dev-java-simple-crud -t dev-java-simple-crud

**Publishing (with tag version)**:

docker build --compress --force-rm --no-cache -t tsoutello/dev-java-simple-crud:1.0.0 .

docker push tsoutello/dev-java-simple-crud:1.0.0

**Killing the container**:

docker container kill dev-java-simple-crud

docker container prune

**3-) Via Kubernetes**

kubectl apply -f deployment.yaml

kubectl port-forward svc/spring 8787:8787


**Kubernetes - Deployment YAML creation:**

kubectl create deployment demo --image=spring-backend --dry-run -o=yaml > deployment.yaml 

kubectl create service clusterip demo --tcp=8787:8787--dry-run -o=yaml >> deployment.yaml


## Accessing application

- App: [http://localhost:8787/dev-java-simple-crud/api](http://localhost:8787/dev-java-simple-crud/api) 
- Swagger: [http://localhost:8787/dev-java-simple-crud/api/swagger-ui.html#/](http://localhost:8787/dev-java-simple-crud/api/swagger-ui.html#/)
- Health Spring Actuator endpoint [http://localhost:8787/dev-java-simple-crud/api/actuator/health](http://localhost:8787/dev-java-simple-crud/api/actuator/health)
