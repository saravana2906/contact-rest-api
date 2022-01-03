FROM maven:3.6-jdk-11 as builder
WORKDIR /usr/src
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:11-jre-buster
WORKDIR /home/user
COPY Dockerfile /Dockerfile
COPY --from=builder /usr/src/target/contact.jar .
EXPOSE 7000
ENV JAVA_OPTS="-Djdbc.url=jdbc:postgresql://172.17.0.1:5432/learn -Djdbc.password=sars2906 -Djdbc.username=saravana -Djwt.issuer-uri=http://127.0.0.1:8080/auth/realms/learn -Djwt.jwk-uri=http://172.17.0.1:8080/auth/realms/learn/protocol/openid-connect/certs"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /home/user/contact.jar" ]
