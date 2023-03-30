# Adapter pattern

The Adapter pattern is a design pattern in software engineering that allows objects with incompatible interfaces to collaborate by acting as a bridge between them. It converts the interface of a class into another interface that clients expect, thereby making two incompatible interfaces compatible. This pattern is useful in situations where existing code needs to be reused, but the interface of the code is not compatible with the new system or framework. The Adapter pattern helps to ensure that the code remains modular and reusable, which is important for software development.

Let's say we have a Motorcycle class with a ride() method:

```java
public class Motorcycle {
    public void ride() {
        System.out.println("Riding motorcycle...");
    }
}
```

And we also have another class called Car with a drive() method:

```java
public class Car {
    public void drive() {
        System.out.println("Driving car...");
    }
}
```

Now, let's imagine we have an interface Vehicle that requires all implementing classes to have a use() method:

```java
public interface Vehicle {
    void use();
}
```

To be able to use both the Motorcycle and Car classes as a Vehicle, we can create a VehicleAdapter class that implements the Vehicle interface and has a reference to either the Motorcycle or Car class. In this example, we'll create an adapter for the Motorcycle class:

```java
public class MotorcycleAdapter implements Vehicle {
    private Motorcycle motorcycle;

    public MotorcycleAdapter(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    public void use() {
        this.motorcycle.ride();
    }
}
```

This way, we can create an instance of MotorcycleAdapter and call the use() method to call the ride() method of the Motorcycle class:

```java
public class Main {
    public static void main(String[] args) {
        Motorcycle motorcycle = new Motorcycle();
        Vehicle vehicle = new MotorcycleAdapter(motorcycle);
        vehicle.use(); // Output: Riding motorcycle...
    }
}
```

Thus, we have used the Adapter design pattern to adapt the Motorcycle class to the Vehicle interface.

[Back to the list](./README.md)