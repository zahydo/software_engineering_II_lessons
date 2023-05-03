## Interface Segregation

The Interface Segregation Principle (ISP) states that classes should not be forced to depend on interfaces they do not use. This principle emphasizes that interfaces should be designed to be cohesive and focused on a specific set of related functions, the problem that it aims to solve is the creation of large and bloated interfaces that force the implementation of unnecessary methods, the way it solves this problem is by promoting the creation of interfaces that are specific to the needs of the classes that will use them, the benefits that it brings are a better maintainabilty (the interfaces are smaller), extensibility, and testability (the code is more isolated)

### Bad example:

Suppose you have an interface for a shape, which includes methods for calculating area and perimeter:
``` java
public interface Shape {
    double calculateArea();
    double calculatePerimeter();
}

```
Now suppose you have a class that only needs to calculate the area of a shape, but does not need to calculate its perimeter. This class is forced to implement both methods of the `Shape` interface, even though it only needs one:
``` java
public class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}

```

This violates the ISP, as the `AreaCalculator` class is forced to depend on the entire `Shape` interface, even though it only needs the `calculateArea()` method.

### Good example:

To apply the ISP, you must design smaller and more focused interfaces that are specific to the needs of each class that needs it:
``` java
public interface Area {
    double calculateArea();
}

public interface Perimeter {
    double calculatePerimeter();
}

```

Now the `Shape` interface can be refactored to implement these smaller interfaces, allowing classes to depend only on the interfaces they need:

``` java
public interface Shape extends Area, Perimeter {
}

public class AreaCalculator {
    public double calculateArea(Area shape) {
        return shape.calculateArea();
    }
}

```

This code separates the `Shape` interface into smaller, more focused interfaces that classes can depend on independently.
### Related principles

- [Separation of concerns](../general/separationofconcerns.md).



### Related patterns

- YAGNI 
- KISS 
- Separation of Concerns
- Boy-Scout Rule


[Back to the list](./README.md)