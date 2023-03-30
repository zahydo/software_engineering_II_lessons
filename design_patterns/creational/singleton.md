# Singleton pattern

The Singleton design pattern is a software design pattern that restricts the instantiation of a class to a single instance and provides global access to that instance. This means that there can only be one instance of a Singleton class throughout the entire application, and that instance is shared by all parts of the application that need to use it.

The Singleton pattern is commonly used in situations where having multiple instances of a class could cause problems, such as conflicting data or excessive resource usage. By limiting the number of instances to one, the Singleton pattern ensures that the data and resources are managed efficiently and consistently.

To implement the Singleton pattern, a class typically has a private constructor to prevent direct instantiation, and a static method to provide access to the single instance of the class. The first time the static method is called, it creates the single instance of the class and returns it. On subsequent calls, the static method simply returns the existing instance.

Overall, the Singleton pattern is a useful way to ensure that there is only one instance of a class in an application, which can help to manage resources and prevent conflicts.

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private constructor to prevent direct instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        // Business logic here
    }
}
```

The Singleton class has a private constructor to prevent direct instantiation, and a getInstance() method that returns the single instance of the class. The getInstance() method checks whether the instance has already been created, and if not, creates it.

Here's an example of how the Singleton class can be used:

```java
public class Main {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2); // Output: true
        singleton1.doSomething();
    }
}
```

We create two instances of the Singleton class using the getInstance() method. Since the getInstance() method always returns the same instance, singleton1 and singleton2 are equal, as confirmed by the output of the comparison. We then call the doSomething() method on singleton1.

Overall, this example demonstrates how the Singleton pattern ensures that only one instance of a class is created and used throughout the application.

[Back to the list](./README.md)