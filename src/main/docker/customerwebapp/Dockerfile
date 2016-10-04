FROM java:8

MAINTAINER PRUTHVI DINTAKURTHI (pruduc@gmail.com)

# update dpkg repositories
RUN apt-get update

# install wget
RUN apt-get install -y wget

# get maven 3.2.2
RUN wget --no-verbose -O /tmp/apache-maven-3.2.2.tar.gz http://archive.apache.org/dist/maven/maven-3/3.2.2/binaries/apache-maven-3.2.2-bin.tar.gz

# verify checksum
RUN echo "87e5cc81bc4ab9b83986b3e77e6b3095 /tmp/apache-maven-3.2.2.tar.gz" | md5sum -c

# install maven
RUN tar xzf /tmp/apache-maven-3.2.2.tar.gz -C /opt/
RUN ln -s /opt/apache-maven-3.2.2 /opt/maven
RUN ln -s /opt/maven/bin/mvn /usr/local/bin
RUN rm -f /tmp/apache-maven-3.2.2.tar.gz
ENV MAVEN_HOME /opt/maven

# install git
RUN apt-get install -y git

# install vim
RUN apt-get install -y vim

# remove download archive files
RUN apt-get clean
RUN java -version
RUN mvn -version

# setting up git
RUN mkdir /root/.ssh
ADD id_rsa /root/.ssh/id_rsa
RUN chmod 700 /root/.ssh/id_rsa
RUN chown -R root:root /root/.ssh
RUN touch /root/.ssh/known_hosts
RUN ssh-keyscan github.com >> /root/.ssh/known_hosts
RUN mkdir /root/workspace
WORKDIR /root/workspace

# clone customer app repository
RUN git clone https://github.com/pruv/customer.git

# build app
WORKDIR /root/workspace/customer
RUN mvn clean install
EXPOSE 8080
RUN bash -c 'touch /root/workspace/customer/target/customer-webapp.war'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/micros", "-Djava.security.egd=file:/dev/./urandom","-jar","/root/workspace/customer/target/customer-webapp.war"]
