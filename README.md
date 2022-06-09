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

As a database for this project is configured in a docker container only, you need to have docker installed on your local machine to run the application. 
You may install docker from [here](https://docs.docker.com/desktop/).


I've created commands in a Makefile to make the process easier.

###Database Initialization 

Do it before maven or docker commands (not docker-compose).

To init a posgres database for the project

```
make docker-init-db
```

###Maven

To package the application:

```
make maven-setup
```

To run tests:

```
make maven-run-tests
```

To start the application (without tests):

```
make maven-start-app
```

###Docker

To start the application:

```
make docker-start-app
```

###docker-compose

To start the application:

```
make docker-compose-app
```

To stop the application:

```
make docker-decompose-app
```

###Kubernetes
