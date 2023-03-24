## Open/Closed

The Open/Closed Principle states that software entities, such as classes, should be open for extension but closed for direct modification of their source code. This means that we should design our classes in such a way that they can be extended with new functionality without needing to modify the original source code.

* Being open for extension means that we can add new functionality to the class by creating new subclasses or by adding new methods and properties. The original class is not affected by these extensions.

* Being closed for modification means that the source code of the original class is not modified to add new functionality. Instead, techniques such as inheritance, composition, and design patterns are used to extend its behavior.

### Bad example:

~~~java
public class CalculadoraAreas {
    public double areaCuadrado(double lado) {
        return lado * lado;
    }
    
    public double areaCirculo(double radio) {
        return 3.14 * radio * radio;
    }
    
    public double areaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }
}
~~~

This class calculates the area of different geometric shapes. Every time a new geometric shape needs to be added, the CalculadoraAreas class has to be modified to add a new method.

### Good example:

~~~java
public abstract class FiguraGeometrica {
    public abstract double area();
}

public class Cuadrado extends FiguraGeometrica {
    private double lado;
    
    public Cuadrado(double lado) {
        this.lado = lado;
    }
    
    public double area() {
        return this.lado * this.lado;
    }
}

public class Circulo extends FiguraGeometrica {
    private double radio;
    
    public Circulo(double radio) {
        this.radio = radio;
    }
    
    public double area() {
        return 3.14 * this.radio * this.radio;
    }
}

public class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;
    
    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    public double area() {
        return (this.base * this.altura) / 2;
    }
}

~~~

In this example, an abstract class FiguraGeometrica has been created that defines an area method. Then, child classes have been created for each geometric shape for which we want to calculate the area. This way, a new geometric shape can be added simply by creating a new child class that inherits from the FiguraGeometrica class and defines the area method for that geometric shape.

### Related principles

* [Separation of Concerns](../general/separationofconcerns.md)
* [Composition Over Inheritance](../general/compositionoverinheritance.md)
* [Code For The Maintainer](../general/codeformantainer.md)

---
[Back to the list](./README.md)