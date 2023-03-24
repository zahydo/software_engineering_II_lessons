## Liskov Substitution
The Liskov principle is a fundamental rule in object-oriented programming that states that if S is a subtype of T, then objects of type T can be final with objects of type S altered without program behavior.

In other words, if a class S is a subtype of a class T, then any object of class T can be replaced by an object of class S without affecting the operation of the program. This is because class S has all the characteristics and behaviors of class T, and can also have additional behaviors of its own.

The Liskov principle has several benefits, including the ability to write more flexible and reusable code. It allows programmers to design more robust and scalable applications, since new subtypes can be added without having to modify existing code.

In addition, the Liskov principle helps to avoid common programming mistakes, such as subtype dependency, where code is designed to work with a specific subtype instead of the superclass. This can lead to errors when new subtypes are introduced or the class hierarchy is changed.

### Bad example:
~~~java
public class Square {
    private int side1;
    private int side2;
    
    public void setSide1(int side) {
        this.side1 = side
        this.side2 = side;
    }
    
    public void setSide2(int side) {
        this.side2 = this.side1;
    }
    
    public int getSide1() {
        return this.side1;
    }
    
    public int getSide2() {
        return this.side2;
    }
    
    public int calculateArea() {
        return this.side1 * this.side2;
    }
}

public class Rectangle {
    private int side1;
    private int side2;
    
    public void setSide1(int side) {
        this.side1 = side;
    }
    
    public void setSide2(int side) {
        this.side2 = side;
    }
    
    public int getSide1() {
        return this.side1;
    }
    
    public int getSide2() {
        return this.side2;
    }
    
    public int calculateArea() {
        return this.side1 * this.side2;
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setSide1(3);
        rectangle.setSide2(5);
        System.out.println("Area of rectangle: " + rectangle.calculateArea());
        
        Square square = new Square();
        square.setSide1(3);
        square.setSide2(5);
        System.out.println("Area of square: " + square.calculateArea());
    }
}
~~~
As you can see, when trying to calculate the area of ​​the Square with the same sides as the Rectangle, we get an incorrect result since the setSide2() method in the Square class does not set the second side as expected.
### Good example:
~~~java
public abstract class Figure {
    public abstract double calculateArea();
}

public class Rectangle extends Figure {
    private double base;
    private double height;
    
    public Rectangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return base * height;
    }
}

public class Square extends Figure {
    private double side;
    
    public Square(double side) {
        this.side = side;
    }
    
    @Override
    public double calculateArea() {
        return side * side;
    }
}

public class Triangle extends Figure {
    private double base;
    private double height;
    
    public Triangulo(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return (base * height) / 2;
    }
}
~~~
In this solution, the abstract class Figure defines the abstract method calculateArea(). The concrete classes Rectangle, Square, and Triangle extend the Shape class and implement its abstract method.

In this way, any instance of Shape can be used anywhere a shape is expected, regardless of its subtype. By calculatingArea() on each object, we get a valid and expected result in each case

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)