## Liskov Substitution

The Liskov Substitution Principle is a fundamental tenet of object-oriented programming, where any subclass should be able to be used in place of its parent class without impacting the correctness of the program, the problem that it aims to solve is the violation of Open/Closed principle when a subtype cannot be used as a substitute for its base type, forcing the client code to check the type of the object and modify its behavior accordingly, it does so by defining a set of rules that a subclass must follow in order to be used as a substitute for its base class, including: 
- Substitutability
- Preservation of invariants 
- Respect for preconditions and postconditions.

The benefits of applying it are: 
- Improved maintainability
- Increased flexibility
- Better testability
- Reduced coupling.
### Bad example:

Imagine you have a class hierarchy for shapes, with a `Shape` superclass and `Rectangle` and `Triangle` subclasses. The `Shape` class has a `getArea` method that calculates the area of the shape.

``` java
public class Shape {
    public double getArea() {
        return 0;
    }
}

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be greater than 0");
        }
        return (base * height) / 2;
    }
}

```

Now suppose you have a method that expects a `Shape` object and calculates its area:

``` java
public double calculateArea(Shape shape) {
    return shape.getArea();
}
```

However, if you try to pass a `Triangle` object with a base of 0 to this method, it will throw an exception, because the base must be greater than 0 for the `Triangle` to have a non-zero area.
``` java
Triangle triangle = new Triangle(0, 10);
calculateArea(triangle); // throws an exception

```
### Good example:

To apply the Liskov Substitution Principle, you should ensure that subclasses behave correctly when used in place of their superclass. In this case, you could add preconditions to the constructor of the `Triangle` class to ensure that the base and height are greater than 0.
``` java
public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be greater than 0");
        }
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return (base * height) / 2;
    }
}

```
Now, when you try to pass a `Triangle` object with a base of 0 to the `calculateArea` method, it will throw an exception at the point of object creation, before the object is passed to the method.

``` java
Triangle triangle = new Triangle(0, 10); // throws an exception
calculateArea(triangle); // not reached

```
This ensures that the `Triangle` class can be used interchangeably with the `Shape` class, without affecting the correctness of the program.
### Related principles

- [Composition over inheritance](../general/compositionoverinheritance.md)

### Related patterns

- [Pattern names]


[Back to the list](./README.md)