## Liskov Substitution

The Liskov Substitution Principle is about ensuring that any instance of a subtype can be used as an instance of its parent type without any unexpected behavior. In other words, a subtype should be able to replace its parent type without changing the correctness of the program.

### Bad example:

´´´
public class Rectangle {
    private int width;
    private int height;
    
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getArea() {
        return width * height;
    }
}

public class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }
    
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }
    
    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

public class AreaCalculator {
    public static int calculateArea(Rectangle r) {
        r.setWidth(5);
        r.setHeight(4);
        return r.getArea();
    }
}
´´´
In this example, the Square class extends the Rectangle class, but it violates the Liskov Substitution Principle because the setWidth() and setHeight() methods behave differently in Square than they do in Rectangle. This can lead to unexpected behavior when instances of Square are used in place of instances of Rectangle.

### Good example:

´´´
public interface Shape {
    int getArea();
}

public class Rectangle implements Shape {
    private int width;
    private int height;
    
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public int getArea() {
        return width * height;
    }
}

public class Square implements Shape {
    private int side;
    
    public Square(int side) {
        this.side = side;
    }
    
    public int getSide() {
        return side;
    }
    
    public void setSide(int side) {
        this.side = side;
    }
    
    @Override
    public int getArea() {
        return side * side;
    }
}

public class AreaCalculator {
    public static int calculateArea(Shape shape) {
        return shape.getArea();
    }
}
´´´

In this example, the Shape interface defines a common getArea() method that is implemented by both Rectangle and Square. This ensures that any instance of either type can be used interchangeably with no unexpected behavior. This design follows the Liskov Substitution Principle.




### Related principles
 -[Code For The Maintainer](../general/codeformantainer.md)
- [Boy-Scout Rule](../general/boyscoutrule.md)

### Related patterns

- [Pattern names]


[Back to the list](./README.md)