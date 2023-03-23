## Interface Segregation

The Interface Segregation Principle (ISP) states that classes should not be forced to depend on interfaces they do not use. This principle emphasizes that interfaces should be designed to be cohesive and focused on a specific set of related functions, the problem that it aims to solve is the creation of large and bloated interfaces that force the implementation of unnecessary methods, the way it solves this problem is by promoting the creation of interfaces that are specific to the needs of the classes that will use them, the benefits that it brings are a better maintainabilty (the interfaces are smaller), extensibility, and testability (the code is more isolated)

### Bad example:

<<<<<<< HEAD
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
=======
```java
public interface Vehicle {
    public void drive();
    public void stop();
    public void refuel();
    public void openDoors();
}

public class Bike implements Vehicle {

    // Can be implemented
    public void drive() {...}
    public void stop() {...}
        
    // Can not be implemented
    public void refuel() {...}
    public void openDoors() {...}
}
```

As you can see, it does not make sense for a Bike class to implement the openDoors() method as a bike does not have any doors! To fix this, 
ISP proposes that the interfaces be broken down into multiple, small cohesive interfaces so that no class is forced to implement any interface,
and therefore methods, that it does not need.

### Good example:

```java
//Different interface
public interface DriveVehicle {
    public void drive();
}

public interface StopVehicle {
    public void stop();
}

public interface RefuelVehicle {
    public void refuel();
}

public interface OpenDoorsVehicle {
    public void openDoors();
}

//Different usage
//Car
public class car implements DriveVehicle, StopVehicle, RefuelVehicle, OpenDoorsVehicle{
    public public void drive() {...}
    public public void stop() {...}
    public public void refuel() {...}
    public public void openDoors() {...}
}

//Bike
public class Bike implements DriveVehicle,  StopVehicle{
    public public void drive() {...}
    public public void stop() {...}
}
```
>>>>>>> 6814cdd (Some changes added)

```

This code separates the `Shape` interface into smaller, more focused interfaces that classes can depend on independently.
### Related principles

<<<<<<< HEAD
- [Separation of concerns](../general/separationofconcerns.md).


=======
- [Dependency Injection](./dependencyInjection.md)
>>>>>>> 6814cdd (Some changes added)

### Related patterns

- [YAGNI](../general/yagni.md)
- [KISS](../general/kiss.md)
- [Separation of Concerns](../general/separationofconcerns.md)
- [Boy-Scout Rule](../general/boyscoutrule.md)


[Back to the list](./README.md)