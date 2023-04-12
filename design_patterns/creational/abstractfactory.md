# Abstract factory pattern

Abstract Factory is a creative design pattern that allows us to produce families of related objects without specifying their concrete classes.
The pattern separates the creation of objects from their use, which allows for greater flexibility and easier code maintenance.

In the abstract factory pattern, an abstract factory defines a set of methods for creating abstract products, and each concrete factory subclass implements these methods to create concrete products. Client code then uses the factory to create the products, without knowing the specific classes of the objects being created.

## 🏗️ Estructure
<p align="center">
<img src="https://res.cloudinary.com/dz5pw4p7y/image/upload/v1681170732/design_patterns/refact_abstract_t09dsh.png" alt="mypic" width="75%">
</p>

## 😟 Problem

Imagine that there is a software application that needs to draw different types of geometric shapes, such as rectangles, circles, etc. 

In this example, the concrete factory `ShapeFactory` has the responsibility to create instances of concrete objects of classes `Rectangle` and `Circle`. This goes against the abstract factory pattern, since the concrete factory should not know or create instances of the concrete product classes directly.

`abstract product`
```java
interface Shape {
    void draw();
}
```
`Specific type of product`
```java
class Rectangle implements Shape {
    public void draw() {
        System.out.println("draw a rectangle");
    }
}
```
`Specific type of product`
```java
class Circle implements Shape {
    public void draw() {
        System.out.println("draw a circle");
    }
}
```
`concrete factory`
```java
class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }
        return null;
    }
}
```
`Customer class`
```java
public class Client {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape1 = factory.createShape("RECTANGLE");
        shape1.draw();
        Shape shape2 = factory.createShape("CIRCLE");
        shape2.draw();
    }
}
```
Any change to the product classes would require modifying the object creation logic in the concrete factory, which is a bad practice in terms of code maintainability and scalability.

## 🙂 Solution

In a correct implementation of the abstract factory pattern, the concrete factory is implemented as a subclass of the abstract factory, which defines the methods to create abstract products, and the concrete factory implements these methods to create concrete products.

`Abstract product`
```java
interface Shape {
    void draw();
}
```
`Specific type of product`
```java
class Rectangle implements Shape {
    public void draw() {
        System.out.println("Se dibuja un rectángulo");
    }
}
```
`Specific type of product`
```java
class Circle implements Shape {
    public void draw() {
        System.out.println("Se dibuja un círculo");
    }
}
```
`Abstract factory`
```java
interface ShapeFactory {
    Shape createShape();
}
```
`Concrete factory to create rectangles`
```java
class RectangleFactory implements ShapeFactory {
    public Shape createShape() {
        return new Rectangle();
    }
}
```
`Concrete factory to create circles`
```java
class CircleFactory implements ShapeFactory {
    public Shape createShape() {
        return new Circle();
    }
}
```
`Customer class`
```java
public class Client {
    public static void main(String[] args) {
        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw();

        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();
    }
}
```
We create an abstract `ShapeFactory`, which defines the `createShape()` method to create objects of type `Shape`. The `RectangleFactory` and `CircleFactory` implement the `ShapeFactory` interface to create objects of type `Rectangle` and `Circle` respectively.

In this way, the customer can create different types of geometric shapes without knowing the specific classes of the objects being created. In addition, any change in the product classes will require modifying only the corresponding concrete factories, which provides greater ease of maintenance and scalability in the code.
