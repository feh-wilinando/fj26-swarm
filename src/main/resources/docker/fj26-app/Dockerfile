FROM maven:3.3.9-alpine


RUN apk add --no-cache git && git clone https://github.com/feh-wilinando/fj26-swarm.git

WORKDIR "/fj26-swarm"

ENV DB_HOST=mysql

EXPOSE 8080

CMD ["mvn", "wildfly-swarm:run"]
