## Liskov Substitution

The Liskov Substitution Principle (LSP) is a software design principle that states that if class A is a subtype of class B, then objects of class B can be replaced with objects of class A without affecting the correctness of the program.

In other words, the Liskov Substitution Principle states that subtypes should be substitutable for their base types without affecting the functionality of the program. This means that any property that can be proven for the base type should also be true for the subtype.


### Bad example:

´´´
public class Rectangle {
    private int height;
    private int width;

    public void setHeight(int h) {
        this.height = h;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    public int getArea() {
        return height * width;
    }
}

public class Square extends Rectangle {
    @Override
    public void setHeight(int h) {
        super.setHeight(h);
        super.setWidth(h);
    }

    @Override
    public void setWidth(int w) {
        super.setHeight(w);
        super.setWidth(w);
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle r = new Square();
        r.setHeight(5);
        r.setWidth(3);
        System.out.println("Area: " + r.getArea()); // expected output: 15, actual output: 25
    }
}
´´´

In this example, we create an object "Square" and assign it to a variable of type "Rectangle". Then, we set the height and width of the rectangle using the "setHeight()" and "setWidth()" methods. However, since the "Square" class overrides these methods to ensure that the height and width are always equal, we have actually created a square instead of a rectangle. As a result, the calculation of the area in the "getArea()" method is not correct.

This example shows how the Liskov Substitution Principle is not fulfilled, since an object of the "Square" class cannot be safely substituted for an object of the "Rectangle" class in all situations.


### Good example:

´´´
public abstract class Shape {
    public abstract int getArea();
}

public class Rectangle extends Shape {
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void setHeight(int h) {
        this.height = h;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    @Override
    public int getArea() {
        return height * width;
    }
}

public class Square extends Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public void setSide(int s) {
        this.side = s;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape r = new Rectangle(5, 3);
        System.out.println("Rectangle area: " + r.getArea()); // expected output: 15
        
        Shape s = new Square(5);
        System.out.println("Square area: " + s.getArea()); // expected output: 25
    }
}
´´´

In this new implementation, we have created an abstract class "Shape" that defines the "getArea()" method and the "Rectangle" and "Square" classes that inherit from it. Each of these classes implements the "getArea()" method according to its own geometry, and there are no "setHeight()" and "setWidth()" methods in the "Square" class, since in a square the side is always equal.

Then, in the "main()" function, we create an object of the "Rectangle" class and another of the "Square" class, and treat them as objects of type "Shape". This fulfills the Liskov Substitution Principle, since we can use objects of both classes interchangeably anywhere an object of type "Shape" is expected.

In this way, we have achieved a safer and more consistent implementation in accordance with the Liskov Substitution Principle.

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)