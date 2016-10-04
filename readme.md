**Building App:**
>mvn clean install

**Running App:**
>Run locally, requires mongodb instance up and running  
>App starts inside embedded tomcat with below command executed from root directory  
>"java -Dspring.data.mongodb.uri=mongodb://{hostname}:{port}/micros -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8086 -jar ./target/customer*.war"  

**Run App via DOCKER**
>use docker files from (/src/main/docker/customerwebapp/)
>run docker-compose up

**Documentation**
    http://{hostname:port}//swagger-ui.html
