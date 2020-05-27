./gradlew clean
./gradlew build
./gradlew installDist
docker build -t proxy-bs-api .
docker tag proxy-bs-api marcusadriano/proxy-bs-api:0.0.1