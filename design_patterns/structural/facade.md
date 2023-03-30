# Facade pattern

In software development, a facade is a design pattern that provides a simplified interface to a set of more complex subsystems. The facade acts as an abstraction layer that hides the complexity of the underlying system and provides an easy-to-use interface for the client. In other words, the facade is a class that wraps a set of more complex classes and provides a simple, easy-to-use interface for interacting with them.

We have a complex library with multiple classes and methods, such as ClassA, ClassB, ClassC, etc. Each class has its own methods and communicates with each other in a complex way. But for the client using this library, all that really matters is a simple functionality, such as methodX().

To simplify the complexity of the library for the client, we can create a Facade class that provides a simple interface for the functionality the client needs. The Facade class hides the complexity of the library behind a simple and easy-to-use interface.

Here's an example of what the Facade class might look like:

```java
public class Facade {
    private ClassA classA;
    private ClassB classB;
    private ClassC classC;

    public Facade() {
        classA = new ClassA();
        classB = new ClassB();
        classC = new ClassC();
    }

    public void methodX() {
        classA.methodA();
        classB.methodB();
        classC.methodC();
    }
}
```

The Facade class creates instances of the ClassA, ClassB, and ClassC classes. The methodX() method calls methods of each of these classes to provide the functionality required by the client. This way, the client only has to interact with the Facade class and doesn't have to worry about the complexity of the underlying library.

Here's an example of how the Facade class can be used:

```java
public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodX(); // calls methods of the ClassA, ClassB, and ClassC classes
    }
}
```

This way, we have used the Facade design pattern to simplify the complexity of the library for the client and provide a simple and easy-to-use interface.

[Back to the list](./README.md)