FROM openjdk:14

WORKDIR /app

COPY target/hoodpresenter.jar .

EXPOSE 8080

CMD java -jar hoodfiller.jar
