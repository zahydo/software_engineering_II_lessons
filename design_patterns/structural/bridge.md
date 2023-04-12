# Bridge pattern

Bridge is a structural design pattern that allows you to split a large class, or a group of closely related classes, into two separate hierarchies (abstraction and implementation) that can be developed independently of each other.

In this pattern, two hierarchies of classes are created: one representing the abstraction (the interface or API that the client uses) and one representing the implementation (the class that provides the actual functionality). The abstraction communicates with the implementation through an interface, allowing the implementation to be changed without affecting the abstraction.

## 🏗️ Estructure
<p align="center">
<img src="https://res.cloudinary.com/dz5pw4p7y/image/upload/v1681075873/design_patterns/bridge_irha1h.png" alt="mypic" width="75%">
</p>

## 😟 Problem

Suppose we have a `Shape` interface that defines the basic behavior of a geometric figure. In addition, we have two classes that implement this interface: `Circle` and `Square`.

Now, we want to add a drawing behavior for these shapes, we could make a bad implementation by creating a separate class for each combination of shape and drawer.

```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        new CircleDrawer().drawCircle();
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        new SquareDrawer().drawSquare();
    }
}

class CircleDrawer {
    public void drawCircle() {
        System.out.println("Drawing circle");
    }
}

class SquareDrawer {
    public void drawSquare() {
        System.out.println("Drawing square");
    }
}
```

Here are several disadvantages: 
* The drawing implementation is tightly coupled to the shape implementation, which makes it difficult to change the way shapes are drawn without modifying the shape classes themselves.
* If we need to add a new shape or drawing type, we should create a new class, which leads to a combinatorial explosion of classes.

Instead, we could have applied the Bridge pattern by creating two separate class hierarchies for shapes and drawers, and linking the two hierarchies through an implementation interface.

## 🙂 Solution

First, we create a `DrawingAPI` interface that defines methods for drawing shapes. Then, we create an abstract `Shape` class that has a reference to a `DrawingAPI` implementation and abstract methods for drawing and resizing the shape. Next, we implement the `Circle` and `Square` shapes by extending the Shape class and providing concrete implementations for the abstract methods. Finally, we create the `DrawingAPI` implementations for the different drawers, such as `DrawingAPI1` and `DrawingAPI2`.

`Shape drawing interface`
```java
interface DrawingAPI {
    void drawCircle(double x, double y, double radius);
    void drawSquare(double x, double y, double side);
}
```
`Abstract Shape class with a reference to DrawingAPI`
```java
abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw();
    public abstract void resize(double factor);
}
```
`Shape implementations`
```java
class Circle extends Shape {
    private double x, y, radius;

    public Circle(double x, double y, double radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }

    @Override
    public void resize(double factor) {
        radius *= factor;
    }
}

class Square extends Shape {
    private double x, y, side;

    public Square(double x, double y, double side, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.side = side;
    }

    @Override
    public void draw() {
        drawingAPI.drawSquare(x, y, side);
    }

    @Override
    public void resize(double factor) {
        side *= factor;
    }
}
```
`DrawingAPI implementations`
```java
class DrawingAPI1 implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("API1.drawCircle at %f:%f radius %f\n", x, y, radius);
    }

    @Override
    public void drawSquare(double x, double y, double side) {
        System.out.printf("API1.drawSquare at %f:%f side %f\n", x, y, side);
    }
}

class DrawingAPI2 implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("API2.drawCircle at %f:%f radius %f\n", x, y, radius);
    }

    @Override
    public void drawSquare(double x, double y, double side) {
        System.out.printf("API2.drawSquare at %f:%f side %f\n", x, y, side);
    }
}
```
In this example, the abstract class `Shape` has a reference to an implementation of `DrawingAPI`. Then, the concrete implementations of `Circle` and `Square` provide the implementations for the `draw()` method by calling the corresponding `DrawingAPI` methods. In addition, an implementation for the `resize()` method is also provided. 
