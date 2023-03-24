## Dependency Injection

Dependency Injection is a design pattern used in object-oriented programming to decouple dependencies between objects. Instead of an object creating and maintaining its own dependencies, the dependencies are provided by an external object.

The Dependency Inversion Principle is composed of two main parts. The first part states that high-level modules and low-level modules should not depend on each other directly. Instead, both should depend on abstractions, which act as a mediator between them. The second part of the principle states that the details should depend on the abstractions, not the other way around.

It's worth noting that the principle doesn't simply change the direction of the dependency, as its name might suggest. Rather, it introduces an abstraction layer between the high-level and low-level modules, effectively splitting the dependency between them. This results in two distinct dependencies: the high-level module depends on the abstraction, and the low-level module also depends on the same abstraction. By doing so, the Dependency Inversion Principle promotes a decoupled, flexible design that can be easily maintained and extended over time.

### Bad example

~~~java
public class MyClass {
    private Connection database;

    public MyClass() {
        this.database = // code to create database connection
    }
}
~~~

In this example, the MyClass class depends on a global instance of the database connection. This makes the MyClass class less modular and harder to test, as the database connection cannot be replaced with a fake connection during testing.

### Good example

~~~java
public class Database {
    private Connection connection;

    public Database() {
        this.connection = // code to create database connection
    }
}

public class MyClass {
    private Database database;

    public MyClass(Database database) {
        this.database = database;
    }

}

~~~

In this example,MyClass takes an instance of Database as an argument in its constructor and does not create a new instance within its body. In other words, the database dependency is passed to the MyClass object instead of MyClass creating its own dependency. This makes MyClass more flexible and easy to test, as a simulated database instance can be injected during testing instead of a real instance. 

### Related principles

* [Separation of Concerns](../general/separationofconcerns.md)
* [Composition Over Inheritance](../general/compositionoverinheritance.md)

---
[Back to the list](./README.md)