# Prototype

The "Prototype" design pattern is a software design technique that belongs to the group of creational patterns. This pattern solves the inefficient creation of objects by creating them from an existing cloned object. In more detail, instead of creating an object from scratch, we clone an existing object and customize it as needed.

To implement the "Prototype" pattern, it is necessary to create a prototype class that implements the "Cloneable" interface. This interface has no methods, but serves as a flag to indicate that the class can be cloned. Next, the "clone()" method of the class, which is responsible for creating an exact copy of the object, must be implemented.

Once the prototype class has been created, instances of this class can be created and cloned when necessary. In this way, complex objects with many attributes can be created in a more efficient way, since it is not necessary to create each object from scratch. The "Prototype" pattern is particularly useful when many similar objects are needed, but with small differences in their attributes. By cloning an existing object, you can save a lot of resources and time in creating new objects.

## Diagram class of example

![ClassDiagram](http://www.plantuml.com/plantuml/png/VP71JiCm38RlUOf8N8f6Ns2Qq2Gui0DYejmG1o-9sg8qAROBGi2xayLgjrA9dkhFzb__VxV4W3nqNi616C6mDXw8TDL0x_INqkafMxlM5MCRwbnVy6VlPcHLEtvAiBXSu9tz2ob38Qdr7bih3OlmKSo8yJ5aqOV3gpEiVfIIynvJ1Q7suuch4QJffTXfhteR0ASbgVxTa21km3HJ6dGazz2lzHrGarusukLAPgydwxaiylXE4XJ7cSkKZs2p-FB3UumSZqdlWTbXk7LT70_le0q5O4sZwlFBsRxykyrtMPvoEeTYMsrTi4FdVm40)

## Example

In this example, the `Shape` class is the abstract prototype class that defines the basic structure of a shape. The classes "Rectangle" and "Square" are the concrete classes that implement the prototype class "Shape". These classes have their own specific attributes and methods.

``` java
public abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract void draw();

    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}

public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

public class Square extends Shape {
    public Square() {
        type = "Square";
    }

    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
```

The "ShapeCache" class is the class that is responsible for maintaining a cache of the cloned shapes. When the "getShape()" method is called with a shape identifier, the "ShapeCache" class searches its map of cloned shapes and returns a copy of the corresponding shape. The "PrototypePatternDemo" class is the main class that creates the shapes and clones them as needed.

``` java
public class ShapeCache {
    private static HashMap<String, Shape> shapeMap = new HashMap<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}

public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}
```
In summary, the "Prototype" design pattern allows us to create complex objects from existing objects by cloning. This allows us to create objects more efficiently and also allows us to modify cloned objects as needed without having to create new objects from scratch. In Java, to implement this pattern, we need to create a prototype class that implements the "Cloneable" interface and then implement the "clone()" method of the class. We can then create instances of this class and clone them as needed.

[Back](../creational/README.md)