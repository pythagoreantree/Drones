## Drones
___

This is a simple REST API Spring Boot application that simulates the delivery of medicines by drones.  

The full list of requirements for the project you can find in the requirements.md file.

---

There are four ways to launch the application: 
+ ***Maven***
+ ***Docker***
+ with ***docker-compose***.yml file
+ ***Kubernetes*** cluster

As database foo this project is configured only in a docker container, you need to have docker installed on your local machine to run the application. 
You may install docker from [here](https://docs.docker.com/desktop/).


I've created commands in a Makefile to make the process easier.

###Database Initialization

To init the posgres database for the project

```
make docker-init-db
```

###Maven

To **package** the application:

```
make maven-setup
```

To **test** the application:

```
make maven-run-tests
```

To **start** the application (without tests):

```
make maven-start-app
```


###Docker

###docker-compose

###Kubernetes
