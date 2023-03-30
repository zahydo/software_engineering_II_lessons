# Proxy pattern

The proxy pattern is a design pattern that provides a substitute or placeholder for another object to control its access, creation, or behavior. A proxy object allows the client to interact with the original object through an interface and provides an additional layer of abstraction for handling the requests and responses to the original object

The class RealSubject that implements an expensive operation, and we want to control access to it by creating a Proxy class. The Proxy class will provide a simplified interface to the RealSubject class, while also adding some additional functionality, such as caching the results of the expensive operation.

Here's an example of what the RealSubject class might look like:

```java
public class RealSubject implements Subject {
    public void doOperation() {
        // perform an expensive operation
    }
}
```

The RealSubject class implements the Subject interface, which defines the doOperation() method.

Here's an example of what the Proxy class might look like:

```java
public class Proxy implements Subject {
    private RealSubject realSubject;
    private Object cache;

    public void doOperation() {
        if (cache == null) {
            cache = new Object(); // perform expensive operation and cache the result
            realSubject.doOperation();
        }
        else {
            // return the cached result
        }
    }
}
```

The Proxy class creates an instance of the RealSubject class and caches the result of the expensive operation in the cache variable. The doOperation() method checks whether the result is already cached; if it is, the cached result is returned, otherwise, the expensive operation is performed and the result is cached for future use.

Here's an example of how the Proxy class can be used:

```java
public class Main {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.doOperation(); // performs the expensive operation and caches the result
        proxy.doOperation(); // returns the cached result
    }
}
```

This way, we have used the Proxy design pattern to control access to the expensive operation and provide additional functionality, such as caching the results.

[Back to the list](./README.md)