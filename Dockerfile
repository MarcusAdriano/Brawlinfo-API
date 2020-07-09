FROM openjdk:8-alpine
COPY build/install/brawlinfo-api /bsapp
WORKDIR /bsapp

EXPOSE 8080

ENTRYPOINT ["./bin/brawlinfo-api"]
