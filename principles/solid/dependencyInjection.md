## Dependency Injection

Dependency Injection is a design pattern used in object-oriented programming to decouple dependencies between objects. Instead of an object creating and maintaining its own dependencies, the dependencies are provided by an external object.

### Bad example

~~~java
public class MyClass {
    private Connection database;

    public MyClass() {
        this.database = // code to create database connection
    }

    public void myMethod() {
        // use this.database to perform operations on the database
    }
}
~~~

In this example, the MyClass class depends on a global instance of the database connection. This makes the MyClass class less modular and harder to test, as the database connection cannot be replaced with a fake connection during testing. Additionally, the global instance can cause concurrency issues in multi-user applications.

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

    public void myMethod() {
        // use this.database to perform operations on the database
    }
}

~~~

In this example, the MyClass class depends on the Database class to perform operations on the database. Instead of creating the database connection within the MyClass class, Dependency Injection is used to provide the connection from the outside. This makes the MyClass class more modular and easier to test, as the database connection can be replaced with a fake connection during testing.

### Related principles

* Separation of Concerns
* Composition Over Inheritance

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)