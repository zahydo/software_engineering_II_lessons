# OPEN/CLOSED

This principle of software development tells us that software should be open to extension but closed to modification. This means that developers should be able to add new features to the software without changing the existing code, but at the same time, they should not be able to change the source code of the software directly. It seeks to encourage modularity and code reuse. When this principle is followed, software is created that is easier to maintain, since modifications are limited to the specific parts that are designed to be extended.

## Bad Example
```
class Figura {
    // Atributos y métodos para el cálculo de áreas de distintas figuras
    double calculateArea() { 
        // Calculation of the area of a triangle
    }

    double calculateTriangleArea() {
        // Calculation of the area of a triangle
    }
}
```
In this example, we are violating the "Open/Closed" principle because we are directly modifying the "Figure" class to add the triangle functionality. Instead, we should have created a new "Triangle" class that extends Figure and has its own method to calculate the area.


## Good Example
```
class Figure {
    // Atributos y métodos para el cálculo de áreas de distintas figuras
    double calculateArea() { 
        // Calculation of the area of a triangle
    }
}

class Triangle extends Figure {
    double calculateArea() { 
        // Calculation of the area of a triangle
    }
}
```
Having created a new class that extends the "Figure" class and allows us to add the "calculateArea" functionality to the "triangle" class without modifying the original class ("Figure").

## Related principles
- Do the simplest thing that could possibly work
- Separation of Concerns