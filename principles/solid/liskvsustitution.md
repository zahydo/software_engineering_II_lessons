## Liskov Substitution

we should be able to use a child class to replace a parent class without getting errors. 
In other words, if we have an object 1 of type S and there is an object 2 of type T such that for all programs P defined in terms of T, the behavior of P does not change when 1 is replaced by 2, then S is a subtype of T.

### Bad example:

The Square class inherits from the Shape class and redefines the calculateArea() method. However, the implementation of the calculateArea() method in Square does not comply with the definition of a square, since a square has all its sides equal. Therefore, passing an instance of Square to the printArea() method will result in an incorrect result.

```Java
public class Shape {
    public double calculateArea() {
         return 0.0;
    }
}

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

public class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}

public class ShapePrinter {
    public static void printArea(Shape shape) {
        double area = shape.calculateArea();
        System.out.println("El area es: " + area);
    }
}
```

### Good example:

The Square class is modified to inherit from the Rectangle class and the implementation of the calculateArea() method in Square is eliminated. This ensures that the implementation of Square complies with the definition of a square, since Square inherits the implementation of the calculateArea() method of Rectangle. By doing this, it does not violate the Liskov Substitution Principle (LSP), since instances of Square can be used in place of instances of Rectangle without affecting the result of the program.

```Java
public class Shape {
    public double calculateArea() {
        return 0.0;
    }
}

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

public class ShapePrinter {
    public static void printArea(Shape shape) {
        double area = shape.calculateArea();
        System.out.println("El area es: " + area);
    }
}
```

### Related principles

- [Code For The Maintainer](~/principles/general/codeformantainer.md) 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)