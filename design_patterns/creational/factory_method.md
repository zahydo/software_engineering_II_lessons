# Factory Method pattern
## Description
The Factory Method pattern is a creational pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. In other words, it defines an interface for creating objects, but lets the subclasses decide which class to instantiate. This allows for more flexibility and makes the code more extensible, since new classes can be added without modifying the existing code.

The Factory Method pattern is useful in situations where a class cannot anticipate the type of objects it needs to create, or when a class wants to delegate the responsibility of object creation to its subclasses.

To implement the Factory Method pattern, you would typically define an abstract factory class with a method for creating objects. Subclasses of the factory class would then implement the method to create objects of their choice.

## Problem
Suppose you are developing a car dealership application and you need to create different types of cars with different features, such as a sports car, a family car, and an SUV. How can you create these cars without tightly coupling your code to specific implementations?


## Solution
```java
// Car interface
public interface Car {
    void drive();
}

// SportsCar concrete class
public class SportsCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a sports car!");
    }
}

// FamilyCar concrete class
public class FamilyCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a family car!");
    }
}

// SUV concrete class
public class SUV implements Car {
    @Override
    public void drive() {
        System.out.println("Driving an SUV!");
    }
}

// Car factory
public class CarFactory {
    public static Car createCar(String type) {
        switch (type) {
            case "sports":
                return new SportsCar();
            case "family":
                return new FamilyCar();
            case "suv":
                return new SUV();
            default:
                throw new IllegalArgumentException("Invalid car type: " + type);
        }
    }
}

Car sportsCar = CarFactory.createCar("sports");
sportsCar.drive(); 

Car familyCar = CarFactory.createCar("family");
familyCar.drive(); 

Car suv = CarFactory.createCar("suv");
suv.drive(); 
``` 
You can use the Factory Method pattern to decouple the creation of the car objects from the rest of your code. First, define an abstract class or interface for the car with methods that describe its behavior. Then, create concrete classes that implement the car interface for each specific car type. Finally, create a factory class with a method that returns an instance of the appropriate concrete class based on some input.