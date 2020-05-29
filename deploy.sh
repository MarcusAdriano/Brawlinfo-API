./gradlew clean
./gradlew build
./gradlew installDist
docker build -t marcusadriano/proxy-bs-api:0.0.1 .
docker push marcusadriano/proxy-bs-api:0.0.1