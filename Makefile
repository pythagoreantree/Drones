maven-setup:
	./mvnw clean
	./mvnw dependency:go-offline
	./mvnw package

maven-run-tests:
	./mvnw test

maven-start-app: maven-setup
	./mvnw spring-boot:run -Dspring-boot.run.profiles=dev

docker-init:
	docker volume create postgres_data
	docker network create drones-net

docker-run-db:
	docker run -it --rm -d -v postgres_data:/var/lib/postgresql/data \
    --network drones-net \
    --name postgres-db \
    -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres \
    -e POSTGRES_DB=postgres \
    -p 5432:5432 postgres

docker-init-db: docker-init docker-run-db

docker-build-app:
	docker build -t java-drones --target development .

docker-run-app:
	docker run --rm -d \
    --name drones-app \
    --network drones-net \
    -e POSTGRES_HOST=postgres-db \
    -e POSTGRES_DB=postgres \
    -e POSTGRES_USERNAME=postgres -e POSTGRES_PASSWORD=postgres \
    -p 8080:8080 java-drones

docker-start-app-server: docker-build-app docker-run-app

docker-first-start-app: docker-init-db docker-start-app-server

docker-start-app: docker-run-db docker-start-app-server

docker-compose-app:
	docker-compose up -d --build

docker-compose-down:
	docker-compose down

