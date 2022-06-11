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

####Run the Postgres

To run the postgres database:

```
make docker-run-db type=init
```

When you do it for the first time, use type=init. 
Afterwards run it without a type.

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

###Docker with H2

To start the application:

```
make docker-start-app-h2
```

###Docker with Postgres

Before starting the application you need to perform Run the Postgres step.

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

___

All the instructions above are made for initial launch of the application (from scratch).
If you need to dive deeper and start/stop the application, you should have some knowledge in maven, docker or kubernetes.

If you have any questions, contact me in Skype or Telegram: @pythagoreantree