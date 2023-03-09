## Composition Over Inheritance

The principle of "Composition Over Inheritance" emphasizes the importance of preferring object composition over class inheritance when designing software. Inheritance can create tight coupling between classes, making it difficult to change the behavior of one class without affecting other classes. Composition, on the other hand, allows for greater flexibility and reuse, as objects can be composed of other objects with different behavior.

### Bad example:

```
public class Car {
    public void drive() {
        System.out.println("Driving a car");
    }
}

public class Driver extends Car {
    // Additional methods and fields
}
```

In this example, we have a `Car` class that defines a `drive` method. We then have a `Driver` class that extends the `Car` class. While this may seem like a natural way to model a driver and a car, it violates the "Composition Over Inheritance" principle. The `Driver` class is tightly coupled to the `Car` class and cannot drive any other type of vehicle without additional code.

### Good example

```
public interface Driveable {
    void drive();
}

public class Car implements Driveable {
    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}

public class Driver {
    private Driveable vehicle;
    
    public Driver(Driveable vehicle) {
        this.vehicle = vehicle;
    }
    
    public void driveVehicle() {
        vehicle.drive();
    }
}
```

In this example, we have an interface called `Driveable` that defines a method called `drive`. We also have a concrete class `Car` that implements the `Driveable` interface. Instead of inheriting from a `Vehicle` base class, we compose the Driver class with a `Driveable` instance. The `Driver` class can drive any vehicle that implements the `Driveable` interface, not just cars.