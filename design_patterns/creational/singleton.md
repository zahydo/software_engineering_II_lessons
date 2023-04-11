# Singleton 
## Description
The Singleton design pattern is a creational design pattern that ensures that a class has only one instance, and provides a global point of access to that instance. It guarantees that the object is initialized only once, and that all subsequent calls to that object return the same instance.

## Problem:
In some scenarios, we need to ensure that a class has only one instance and that this instance is globally accessible. For example, we may need to create a logging or database connection object that is shared across the entire application. Creating multiple instances of these objects can result in unexpected behavior and consume unnecessary resources.

## Solution:
The Singleton pattern provides a solution to the above problem by defining a class that has only one instance and a global point of access to that instance. The Singleton class ensures that its constructor is private, so that it cannot be instantiated from outside the class. It provides a static method to access the singleton instance, which creates the instance if it does not exist, or returns the existing instance if it has already been created.

By using the Singleton pattern, we can ensure that a class has only one instance, and that this instance is globally accessible. This pattern also promotes encapsulation, by hiding the creation of the singleton instance from the client code. It is useful in scenarios where we need to manage limited resources, such as connections to a database, or in situations where we need to maintain a single global state, such as in a configuration object.
## Example: 
Let's say we have a class DatabaseConnection that represents a connection to a database. We want to ensure that there is only one instance of this class throughout the lifetime of the application, to avoid having multiple connections to the same database.

### Structure
<p align="center">
    <img src="./diagrams/singleton.svg"/>
</p>

### Implementation

To implement this, we can use the Singleton pattern. Here's an example implementation:

``` Java
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        // Initialize the connection
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

```

In the above code, we have a private static variable instance that holds the single instance of the `DatabaseConnection` class, a private constructor that initializes the connection to the database, and a public static method `getInstance()` that returns the instance of the class. The `getInstance()` method checks if the instance is null, and if it is, creates a new instance of the class. Otherwise, it simply returns the existing instance.

We also have a public method `getConnection()` that returns the connection object.

Now, in the client code, we can get the instance of the `DatabaseConnection` class using the `getInstance()` method, and then use the `getConnection()` method to get the connection object. For example:


``` Java
DatabaseConnection connection = DatabaseConnection.getInstance();
Connection dbConnection = connection.getConnection();

```

This way, we ensure that only one instance of the `DatabaseConnection` class is created throughout the lifetime of the application, and we can use it to get the connection object to the database.



