## Open/Closed

The Open/Closed Principle (OCP) states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that you should be able to extend the behavior of a software entity without modifying its source code, the problem that it aims to solve is the need to modify existing code when adding new functionality, which can introduce bugs and make the code more difficult to maintain, the way it does so is by designing software entities (classes, modules, etc.) that are open for extension but closed for modification, meaning that new functionality can be added by extending existing code without modifying it.

The benefits that it brings are:

- Improved maintainability
- Easier testing (The base code is the same, only the extensions need to be tested)
- Reduced risk of introducing bugs or breaking existing functionality.
### Bad example:

Suppose you have a class `Shape` that represents various geometric shapes, and you want to calculate the area of each shape. 

``` java
public class Shape {
    // fields and methods
    public double calculateArea() {
        // code to calculate area
    }
}
```

Later, you realize that you need to add a new shape, a `Triangle`, to your system. However, the formula for calculating the area of a triangle is different from that of other shapes. To accommodate this new shape, you need to modify the `Shape` class by adding a conditional statement inside the `calculateArea()` method:

``` java
public class Shape {
    // fields and methods
    public double calculateArea() {
        if (this instanceof Triangle) {
            // code to calculate area of a triangle
        } else {
            // code to calculate area of other shapes
        }
    }
}

```

This violates the OCP because the `Shape` class is no longer closed for modification. Adding a new shape requires modifying the `Shape` class, which can lead to bugs and make the code harder to maintain.
### Good example:

To apply the OCP, you can use inheritance and create a new class `Triangle` that extends the `Shape` class:

``` java
public class Triangle extends Shape {
    // fields and methods specific to triangles
    public double calculateArea() {
        // code to calculate area of a triangle
    }
}

```

Now, you can add new shapes to the system by creating new classes that extend the `Shape` class, without modifying the existing code:

``` java
public class Circle extends Shape {
    // fields and methods specific to circles
    public double calculateArea() {
        // code to calculate area of a circle
    }
}

public class Rectangle extends Shape {
    // fields and methods specific to rectangles
    public double calculateArea() {
        // code to calculate area of a rectangle
    }
}

```

This implementation is closed for modification because you can add new shapes to the system without modifying the existing code. At the same time, it is open for extension because you can extend the behavior of each shape by implementing its own `calculateArea()` method in its respective class.

### Related principles

- [Do the Do the Simplest Thing That Could Possibly Work](../general/dothesimplestthing.md)
- [KISS](../general/kiss.md)
- [YAGNI](../general/yagni.md)

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)