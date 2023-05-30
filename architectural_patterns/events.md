# Event-Oriented Architecture (EOA)

Event-Oriented Architecture (EOA) is a software architectural style that focuses on the communication and coordination of components through the use of events. In EOA, components are decoupled from one another and communicate asynchronously by producing and consuming events. An event represents a significant occurrence or change of state within a system.

## Key Concepts

### Events:

An event is a lightweight, immutable message that carries information about a specific occurrence or state change. It represents a discrete unit of communication between components.

### Producers:

Components that generate and emit events are known as event producers. They publish events to a centralized event bus or a distributed messaging system.

### Consumers:

Components that subscribe to and process events are called event consumers. They receive events from the event bus and react to them accordingly.
### Event Bus:

The event bus acts as a central hub or a messaging backbone, facilitating the exchange of events between producers and consumers. It ensures loose coupling and enables decoupled communication.

## Advantages of EOA:
### Loose Coupling: 

EOA promotes loose coupling between components, as they interact solely through events. This decoupling allows for flexibility, scalability, and easier maintenance of the system.
### Scalability: 

With EOA, you can scale the system by adding more event producers or consumers without affecting the existing components. This makes it well-suited for building distributed and highly scalable systems.
### Flexibility and Extensibility: 

Since components are independent and communicate through events, it becomes easier to introduce new features or modify existing ones without affecting the entire system.
### Asynchronous Communication: 

EOA supports asynchronous communication, enabling components to operate independently and process events at their own pace. This improves system responsiveness and overall performance.

## Getting Started

### RabbitMQ - examples

Run RabbitMQ server

**Docker:**
```
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 -d rabbitmq:3.9-management
```

**Windows:**

1. Install Erlang https://erlang.org/download/otp_versions_tree.html

2. Install RabbitMQ https://www.rabbitmq.com/install-windows.html#installer

 
    Consider the requirements of RabbitMQ related to Erlang https://www.rabbitmq.com/which-erlang.html

 
3. Start RabbitMQ service
    
    Go to Windows home and search RabbitMQ Service and press Start


**RabbitMQ UI Management**

http://localhost:15672


### Examples Using CLI

Clean, install and build the .jar:
```bash
mvn clean install package
```


#### Run Example 1: 
https://www.rabbitmq.com/tutorials/tutorial-one-java.html

Consumer
```bash
java -cp target/RabbitMQ-Examples-1.0-SNAPSHOT.jar co.unicauca.rabbitmq.example1.Recv
```

Producer
```bash
java -cp target/RabbitMQ-Examples-1.0-SNAPSHOT.jar co.unicauca.rabbitmq.example1.Send
```

#### Run Example 2: 
https://www.rabbitmq.com/tutorials/tutorial-two-java.html

Worker 1 
```bash
java -cp target/RabbitMQ-Examples-1.0-SNAPSHOT.jar co.unicauca.rabbitmq.example2.Worker
```
Worker 2 (open new terminal)
```bash
java -cp target/RabbitMQ-Examples-1.0-SNAPSHOT.jar co.unicauca.rabbitmq.example2.Worker
```
Task 1
```bash
java -cp target/RabbitMQ-Examples-1.0-SNAPSHOT.jar co.unicauca.rabbitmq.example2.NewTask hola mensaje1…
```
Task 2
```bash
java -cp target/RabbitMQ-Examples-1.0-SNAPSHOT.jar co.unicauca.rabbitmq.example2.NewTask hola mensaje2…..
```
Task 3
```bash
java -cp target/RabbitMQ-Examples-1.0-SNAPSHOT.jar co.unicauca.rabbitmq.example2.NewTask hola mensaje3…….
```
Task 4
```bash
java -cp target/RabbitMQ-Examples-1.0-SNAPSHOT.jar co.unicauca.rabbitmq.example2.NewTask hola mensaje4……….
```

#### Run Example 3: 
https://www.rabbitmq.com/tutorials/tutorial-three-java.html

Suscriptor 1
```bash
java -cp target/RabbitMQ-Examples-1.0-SNAPSHOT.jar co.unicauca.rabbitmq.example3.ReceiveLogs
```
Suscriptor 2 (open new terminal)
```bash
java -cp target/RabbitMQ-Examples-1.0-SNAPSHOT.jar co.unicauca.rabbitmq.example3.ReceiveLogs > logs_from_rabbit.log
```

Producer
```bash
java -cp target/RabbitMQ-Examples-1.0-SNAPSHOT.jar co.unicauca.rabbitmq.example3.EmitLog
```