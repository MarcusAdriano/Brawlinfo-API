FROM openjdk:8-alpine
COPY build/install/bscomparatorapi /var/app
WORKDIR /var/app

EXPOSE 8080

ENTRYPOINT ["./bin/bscomparatorapi"]
