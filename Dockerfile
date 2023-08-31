# べースイメージ
FROM openjdk:11

WORKDIR /src

COPY pom.xml .

# Install required dependencies
RUN apt-get update && apt-get install -y curl

# Download and extract Maven
RUN curl -fsSL -o /tmp/apache-maven.tar.gz https://apache.osuosl.org/maven/maven-3/3.8.8/binaries/apache-maven-3.8.8-bin.tar.gz \
    && tar -xzf /tmp/apache-maven.tar.gz -C /opt \
    && rm /tmp/apache-maven.tar.gz

# Set Maven environment variables
ENV MAVEN_HOME=/opt/apache-maven-3.8.8
ENV PATH=$MAVEN_HOME/bin:$PATH
RUN chmod +x /opt/apache-maven-3.8.8/bin/mvn


RUN mvn dependency:resolve

COPY src ./src
RUN mvn package

CMD ["java", "-jar", "target/apigateway-0.0.1-SNAPSHOT.jar"]