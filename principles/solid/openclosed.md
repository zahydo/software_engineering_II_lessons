## Open/Closed

Software entities (e.g., classes, modules, functions) should be open for an extension, 
but closed for modification. Consider the below method of the class VehicleCalculations:

### Bad example:

```java
public class VehicleCalculations {

    public double calculateValue(Vehicle v) {
        if (v instanceof Car) {
            return v.getValue() * 0.8;
        }

        if (v instanceof Bike) {
            return v.getValue() * 0.5;
        }
    }
}
```

Suppose we now want to add another subclass called Truck. We would have to modify 
the above class by adding another if statement, which goes against the Open-Closed 
Principle. A better approach would be for the subclasses Car and Truck to override 
the calculateValue method:

### Good example:

```java
public class Vehicle {
    public double calculateValue() {...}
}

public class Car extends Vehicle {
    public double calculateValue() {
        return this.getValue() * 0.8;
    }
}

public class Truck extends Vehicle{
    public double calculateValue() {
        return this.getValue() * 0.9;
    }
}
```

Adding another Vehicle type is as simple as making another subclass and extending 
from the Vehicle class.

### Related principles

- [Single Responsability](./singleresponsibility.md)
- [Liskov Substitution](./liskvsustitution.md)

### Related patterns

- [Code For Mantainer](../general/codeformantainer.md)
- [Boy-Scout Rule](../general/boyscoutrule.md)
---
[Back to the list](./README.md)