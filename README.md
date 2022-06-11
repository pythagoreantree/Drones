## Drones
___

This is a simple REST API Spring Boot application that simulates the delivery of medicines by drones.  

The full list of requirements for the project you can find in the requirements.md file.

---

There are four ways to launch the application: 
+ ***Maven***
+ ***Docker***
+ ***docker-compose***
+ ***Kubernetes***

I've created commands in a Makefile to make the process easier.

You may configure the application to use in-memory H2 database or Postgres in a docker container. 
You may install docker from [here](https://docs.docker.com/desktop/).

If you use in-memory database, you do not need any additional configurations.
If you use postgres, you need to pre-configure docker to launch a database in a container.

####Docker Init

To start the application with Postgres:

> first you need to pre-configure docker. Do it one time for the project.
Otherwise data will be lost. It creates volume to store your database data.

```
make docker-init
```

####Run the Postgres
> then run the postgres database

```
make docker-run-db
```

###Maven 

####Maven General 

To package the application:

```
make maven-setup
```

To run tests:

```
make maven-run-tests
```

####Maven with H2

To start the application with H2 database:

```
make maven-start-app-h2
```

####Maven with Postgres

To start the application with postgres database:

```
make maven-start-app-postgres
```

Reach the application:

```
http://localhost:8080/ or http://localhost:8080/home
```

###Docker

Before starting the application you need to perform Docker Init and Run the Postgres steps.

To start the application:

```
make docker-start-app
```

Reach the application:

```
http://localhost:8080/ or http://localhost:8080/home
```

###docker-compose

You do not need any pre-configurations for this type of launch.
The project will be set with an instance of Postgres database.
No docker-init is needed. Just start the application.

To start the application:

```
make docker-compose-app
```

To stop the application:

```
make docker-decompose-app
```

Reach the application:

```
http://localhost:8080/ or http://localhost:8080/home
```

###Kubernetes

To start working with Kubernetes you need
+ [kubectl](https://kubernetes.io/docs/tasks/tools/)
+ kubernetes cluster, for example [minikube](https://kubernetes.io/ru/docs/tasks/tools/install-minikube/)

No Docker Init or Run Postgres is need. Just run the command.

After all installation you may launch the application in cluster with command:

```
make k8s-start
```

Some time pass before pods will be up.
After that you find out the server ip with command in your Terminal:

```
minikube ip
```

And you need the port. You can find it in PORT(s) after '8080:'

```
kubectl get service drones-app-service
```

With this ip and port you can reach the application:

```
http://ip:port/ or http://ip:port/home
```

If you can't do it, check the vm-driver for minikube and/or the app image in the app-deployments file.