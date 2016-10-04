Building App
mvn clean install

Running App

App starts inside embedded tomcat with below command executed from root directory
java -Dspring.data.mongodb.uri=mongodb://{hostname}:{port}/micros -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8086 -jar ./target/customer*.war

Documentation

http://{hostname:port}//swagger-ui.html