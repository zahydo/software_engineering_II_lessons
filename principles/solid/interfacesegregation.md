## Interface Segregation

The Interface Segregation principle states that interfaces should be cohesive and specific to prevent classes from implementing unnecessary methods. This reduces coupling and improves code flexibility and reusability.

### Bad example:

In this example, the Vehicle interface includes all possible methods, which means that the classes that implement it, such as Car, Motorcycle and Bike, must provide an implementation for all methods, even if some of them are not relevant to the vehicle type. This makes the interface difficult to use and maintain, and can lead to redundant or inefficient code in some classes.

```Java
public interface Vehicle {
    void accelerate();
    void brake();
    void turnLeft();
    void turnRight();
    void startEngine();
    void stopEngine();
}

public class Car implements Vehicle {
    // implementation of all Vehicle methods
}

public class Motorcycle implements Vehicle {
    // implementation of all Vehicle methods
}

public class Bicycle implements Vehicle {
    // implementation of all Vehicle methods
}
```

### Good example:

In this example, each interface represents functionality relevant to vehicles, such as accelerating, braking, turning, etc. Classes that implement these interfaces need only provide an implementation for the methods that are relevant to their vehicle type, which makes the interfaces easier to use and maintain. In addition, redundant or inefficient code is avoided in classes that do not need certain functionality.

```Java
public interface Accelerable {
    void accelerate();
    void decelerate();
}

public interface Brakable {
    void brake();
}

public interface Turnable {
    void turnLeft();
    void turnRight();
}

public interface Startable {
    void startEngine();
    void stopEngine();
}

public class Car implements Accelerable, Brakable, Turnable, Startable {
    // implementation of each interface method
}

public class Motorcycle implements Accelerable, Brakable, Turnable, Startable {
    // implementation of each interface method
}

public class Bicycle implements Accelerable, Turnable {
    // implementation of each interface method
}
```

### Related principles

- [Separation of Concerns](../../principles/general/separationofconcerns.md)
- [Code For The Maintainer](../../principles/general/codeformantainer.md)
- [Boy-Scout Rule](../../principles/general/boyscoutrule.md)

### Related patterns

- Separation of Concerns
- DRY (Don't Repeat Yourself)
- Code For The Maintainer
- Composition Over Inheritance

---

[Back to the list](./README.md)
