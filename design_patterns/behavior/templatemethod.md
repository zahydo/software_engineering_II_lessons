# Template method
The Template Method pattern is a behavioral pattern that allows a developer to create a new, more specialized class without having to rewrite the code of an existing class. It is often used when designing classes that are similar in form but differ in their implementation details.

It is a design pattern used to create an interface for classes that contain certain common functionality and also other specific functionality. It also allows the creation of subclasses with different implementations of this common functionality.

The Template Method pattern consists of two main components: the abstract class and the concrete subclasses. The abstract class defines the skeleton of the algorithm and the abstract methods that must be implemented by the concrete subclasses. The concrete subclasses provide the specific implementations for each abstract method defined in the abstract class.

<p align="center">
<img src="https://res.cloudinary.com/dilrruxyx/image/upload/v1681006609/plantilla_ujtsn6.png" alt="mypic" width="75%">
</p>

## 😟 Problem
Suppose we have a class called "Car" that has two methods called "drive" and "brake". We also have a class called "Motorcycle" that implements the same methods with different behaviors. At some point, you realize that the two classes have a lot of similar code. Wouldn't it be great to get rid of the code duplication while leaving the structure of the algorithm intact?

~~~java
class Car {
    public void drive() {
        System.out.println("Driving car...");
    }
    public void brake() {
        System.out.println("Braking car...");
    }
}

class Motorcycle {
    public void drive() {
        System.out.println("Driving motorcycle...");
    }
    public void brake() {
        System.out.println("Braking motorcycle...");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
        car.brake();

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.drive();
        motorcycle.brake();
    }
}
~~~
## 🙂 Solution
To solve the problem of how to drive and brake a vehicle, we can use the Template Method pattern. In this pattern, we define an abstract method called "driveVehicle" in the abstract class "Vehicle". Then, we implement this method in the "Car" and "Motorcycle" subclasses. The "driveVehicle" method calls the abstract "drive" and "brake" methods, which are implemented by the subclasses.

~~~java
abstract class Vehicle {
    public void driveVehicle() {
        drive();
        brake();
    }
    public abstract void drive();
    public abstract void brake();
}

class Car extends Vehicle {
    public void drive() {
        System.out.println("Driving car...");
    }
    public void brake() {
        System.out.println("Braking car...");
    }
}

class Motorcycle extends Vehicle {
    public void drive() {
        System.out.println("Driving motorcycle...");
    }
    public void brake() {
        System.out.println("Braking motorcycle...");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.driveVehicle();

        Vehicle motorcycle = new Motorcycle();
        motorcycle.driveVehicle();
    }
}
~~~
In conclusion, the Template Method pattern provides an effective solution to the problem of how to drive and brake a vehicle. This pattern allows us to define an abstract method in the abstract class "Vehicle" that is implemented by the "Car" and "Motorcycle" subclasses. By calling the "driveVehicle" method, the "drive" and "brake" methods defined in the subclasses are executed. This allows us to efficiently create instances of the subclasses and use them to drive and brake a vehicle. Overall, the Template Method pattern is a useful tool for defining algorithms with