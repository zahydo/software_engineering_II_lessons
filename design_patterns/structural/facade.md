# Facade pattern 
The Facade structural pattern is a design pattern that provides a simplified interface to a set of more complex interfaces in a system. This pattern is used to hide the complexity of a system and provide a simpler interface to the client.

The Facade pattern is useful in large and complex systems, where the client does not need to know all the internal details of the system. Instead of exposing all the complex interfaces of the system to the client, the Facade pattern provides a simplified interface that hides the underlying complexity of the system.

## 🏗️ Estructure
<p align="center">
<img src="https://res.cloudinary.com/dilrruxyx/image/upload/v1681007235/facade_jjbp6a.png" alt="mypic" width="75%">
</p>

## 😟 Problem
Suppose we have an application that uses multiple libraries to perform complex tasks. Each library has its own interface and set of classes. To perform a task, the application must interact with several different libraries and call various methods in each of them. This can be complicated and difficult to maintain.

java
Copy code
public class LibraryA {
    public void methodA() {
        System.out.println("Method A of Library A");
    }
}

public class LibraryB {
    public void methodB() {
        System.out.println("Method B of Library B");
    }
}

public class LibraryC {
    public void methodC() {
        System.out.println("Method C of Library C");
    }
}

public class ComplexClass {
    private final LibraryA libraryA;
    private final LibraryB libraryB;
    private final LibraryC libraryC;

    public ComplexClass(LibraryA libraryA, LibraryB libraryB, LibraryC libraryC) {
        this.libraryA = libraryA;
        this.libraryB = libraryB;
        this.libraryC = libraryC;
    }

    public void doSomething() {
        libraryA.methodA();
        libraryB.methodB();
        libraryC.methodC();
    }
}
## 🙂 Solution
A facade is an abstraction that provides a simple interface to access a complex subsystem composed of multiple moving parts. Although a facade may offer limited functionality compared to directly interacting with the subsystem, it focuses only on the essential functions for the clients.

The usefulness of a facade lies in its ability to integrate an application with a sophisticated library that has dozens of functions, of which only a small part is required.

Here's an example of how the Facade pattern can be used to simplify interaction with the libraries:

java
Copy code
public class Facade {
    private final LibraryA libraryA;
    private final LibraryB libraryB;
    private final LibraryC libraryC;

    public Facade() {
        this.libraryA = new LibraryA();
        this.libraryB = new LibraryB();
        this.libraryC = new LibraryC();
    }

    public void doSomething() {
        libraryA.methodA();
        libraryB.methodB();
        libraryC.methodC();
    }
}
In this example, the ComplexClass has been simplified to the Facade class, which provides a simplified interface to perform the task.
