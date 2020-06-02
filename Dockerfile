FROM openjdk:8-alpine
COPY build/install/bscomparatorapi /bsapp
WORKDIR /bsapp

EXPOSE 8080

ENTRYPOINT ["./bin/bscomparatorapi"]
