maven-setup:
	./mvnw clean
	./mvnw dependency:go-offline
	./mvnw package

maven-run-tests:
	./mvnw test

maven-start-app-h2: maven-setup
	./mvnw spring-boot:run -Dspring-boot.run.profiles=dnodb

maven-start-app-postgres: maven-setup
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

docker-start-app: docker-build-app docker-run-app

docker-first-start-app: docker-init-db docker-start-app-server

docker-compose-app:
	docker-compose up -d --build

docker-decompose-app:
	docker-compose down

docker-build-n-push-2hub:
	docker build -t pythagoreantree/drones-project:v.3.0 --target development .
	docker push pythagoreantree/drones-project:v.3.0

k8s-start-minikube:
	minikube start --vm-driver=hyperkit
	eval $(minikube docker-env)

k8s-start-db:
	kubectl apply -f db-configMap.yaml
	kubectl apply -f db-secrets.yaml
	kubectl apply -f db-persistentVolumeClaim.yaml
	kubectl apply -f db-deployment.yaml
	kubectl apply -f db-service.yaml

k8s-start-app:
	kubectl apply -f app-deployment.yaml
	kubectl apply -f app-service.yaml

k8s-unset-minikube:
	minikube stop
	eval $(minikube docker-env -u)

k8s-delete-minikube:
	minikube delete

k8s-start: k8s-start-minikube k8s-start-db k8s-start-app



