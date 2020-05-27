FROM openjdk:8-alpine
COPY build/install/bscomparatorapi /home/bscomparatorapi
WORKDIR /home/bscomparatorapi

EXPOSE 8080

ENTRYPOINT ["./bin/bscomparatorapi"]
