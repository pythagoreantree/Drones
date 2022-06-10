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

###Docker

To start the application:

```
make docker-start-app
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

###Kubernetes
