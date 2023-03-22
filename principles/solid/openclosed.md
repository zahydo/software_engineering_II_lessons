## Open/Closed

Open/closed principle is a software design principle that states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that you should be able to add new functionality to a system without having to modify the existing code.

### Bad example:
```java
public class Vehicle {

private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void drive() {
        if (type.equals("Car")) {
            System.out.println("Driving a car");
        } else if (type.equals("Truck")) {
            System.out.println("Driving a truck");
        }
    }
}

```
In this code, the Drive method violates the OCP because it has to be modified every time a new type of vehicle is added.

### Good example:
```java
public abstract class Shape {
    public abstract double getArea();
}

public abstract class Vehicle {
    public abstract void drive();
}

public class Car extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}

public class Truck extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a truck");
    }
}

```
When we want to add a new type of vehicle, we just need to create a new class that derives from Vehicle and implements the Drive method. This way, our code is open for extension but closed for modification, and we can add new types of vehicles without having to modify the existing code.

### Related principles

- [Separation of Concerns](/principles/general/separationofconcerns.md)
- [DRY](/principles/general/dry.md)
- [KISS](/principles/general/kiss.md)
- [Composition Over Inheritance](/principles/general/compositionoverinheritance.md)
- [Code For The Maintainer](/principles/general/codeformantainer.md)
- [Boy-Scout Rule](/principles/general/boyscoutrule.md)

### Related patterns


[Back to the list](./README.md)