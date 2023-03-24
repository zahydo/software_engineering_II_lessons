## Open/Closed

The Open/Closed principle is a fundamental principle of object-oriented programming that states that software entities (such as classes, modules, etc.) should be open for extension but closed for modification.

This means that a software entity should be easily extensible so that new functionalities can be added without modifying the existing code. At the same time, a software entity should be resistant to modification, which means that changes to a software entity should not negatively affect other parts of the system.

### Bad example:

Let's say we have a Vehicle class that represents a generic vehicle, and we want to add a new functionality that allows us to calculate fuel consumption. One way to do this without following the Open/Closed principle would be to directly modify the Vehicle class to add the new method:

´´´
public class Vehicle {
    private String make;
    private String model;
    private int year;
    private double fuelCapacity;
    private double fuelLevel;

    // Constructor, getters, setters, etc.

    public double calculateFuelConsumption(double distance) {
        double fuelConsumption = distance / (100.0 / fuelCapacity);
        fuelLevel -= fuelConsumption;
        return fuelConsumption;
    }
}
´´´

In this example, the calculateFuelConsumption() method has been added directly to the Vehicle class. However, this breaks the Open/Closed principle, as we are modifying an existing class instead of extending it

### Good example:

One way to apply the Open/Closed principle in this example would be to create a new class that extends the Vehicle class and adds the new functionality:

´´´
public class FuelConsumptionVehicle extends Vehicle {
    public double calculateFuelConsumption(double distance) {
        double fuelConsumption = distance / (100.0 / getFuelCapacity());
        setFuelLevel(getFuelLevel() - fuelConsumption);
        return fuelConsumption;
    }
}
´´´

In this example, a new class called FuelConsumptionVehicle has been created that extends the Vehicle class and adds the functionality to calculate fuel consumption. This way, the Vehicle class remains closed for modification and open for extension, as a new class has been created to extend its functionality without modifying its source code.

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)