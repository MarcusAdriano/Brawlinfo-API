./gradlew clean
./gradlew build
./gradlew installDist
docker build -t marcusadriano/proxy-bs-api:0.0.1 .