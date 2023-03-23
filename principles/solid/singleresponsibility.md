## Single Responsibility

Every class in Java should have a single job to do. To be precise, there should only 
be one reason to change a class. Here’s an example of a Java class that does not follow 
the single responsibility principle (SRP):

### Bad example:

```java
public class Vehicle {
    public void printDetails() {}
    public double calculateValue() {}
    public void addVehicleToDB() {}
}
```

The Vehicle class has three separate responsibilities: reporting, calculation, and database.
By applying SRP, we can separate the above class into three classes with separate responsibilities.

### Good example:

```java
public class VehicleDetails{
    //TODO
}

public class VehicleValues {
    //TODO
}

public class VehicleDB{
    //TODO
}
```

### Related principles

- [Open/Closed](./openclosed.md)

### Related patterns

- [Separation of Concerns](../general/separationofconcerns.md)
- [KISS](../general/kiss.md)
- [Do The Simplest Thing That Could Possibly Work](../general/dothesimplestthing.md)
- [Boy-Scout Rule](../general/boyscoutrule.md)

---
[Back to the list](./README.md)