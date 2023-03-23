# LISKOV SUBSTITUTION

This principle states that if class A is a subtype of class B, then an object of class A can be used whenever an object of class B is expected, without changing the behavior of the program. In other words, if a subclass is a subtype of a superclass, then the subclass must be interchangeable with the superclass without changing the behavior of the program.

## Bad Example
```
// Base Class
public class Shape
{
    public virtual int GetArea() { return 0; }
}

// Inherite class violating Liskov's substitution principle
public class Rectangle : Shape
{
    private int _width;
    private int _height;
    
    public Rectangle(int width, int height)
    {
        _width = width;
        _height = height;
    }
    
    public override int GetArea()
    {
        return _width * _height;
    }
    
    public void SetWidth(int width)
    {
        _width = width;
    }
    
    public void SetHeight(int height)
    {
        _height = height;
    }
}

// Function that uses objects of the Shape class
public void PrintArea(Shape shape)
{
    Console.WriteLine("Area: " + shape.GetArea());
}

// Use of classes
Rectangle rectangle = new Rectangle(5, 10);
PrintArea(rectangle);  // Salida: Area: 50

// Width change without maintaining the aspect ratio
rectangle.SetWidth(20);
PrintArea(rectangle);  // Output: Area: 200
```
In this example, the class "Rectangle" is a subclass of "Shape" and overrides the GetArea() method to return the area of a rectangle. However, it also has SetWidth() and SetHeight() methods to change the width and height of the rectangle respectively. The problem with this is that, if you use an object of class "Rectangle" instead of an object of class "Shape", you can change the width and height of the rectangle, which may result in the object no longer representing a valid rectangle. This violates Liskov's substitution principle, since the object of class "Rectangle" cannot be used in place of an object of class "Shape" without affecting the behavior of the program.

## Good Example
```
// Base Class
public class Shape
{
    public virtual int GetArea() { return 0; }
}

// Inherit class
public class Square : Shape
{
    private int _sideLength;
    
    public Square(int sideLength)
    {
        _sideLength = sideLength;
    }
    
    public override int GetArea()
    {
        return _sideLength * _sideLength;
    }
}

// Function that uses objects of the Shape class
public void PrintArea(Shape shape)
{
    Console.WriteLine("Area: " + shape.GetArea());
}

// Use of classes
Shape square = new Square(5);
PrintArea(square);  // Output: Area: 25
```

The Square class is a child class of "Shape" and overrides the GetArea() method to return the area of a square. The "Square" class can be used instead of the "Shape" class without affecting the behavior of the PrintArea() function.

## Related principles
- Code for the maintainer