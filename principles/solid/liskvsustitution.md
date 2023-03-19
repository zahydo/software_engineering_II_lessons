## Liskov Substitution

Is a principle in software engineering that states that objects of a superclass should be able to be replaced with objects of its subclasses without affecting the correctness of the program. In other words, any instance of a parent class should be able to be replaced with an instance of one of its child classes without causing errors or unexpected behaviors. This principle is important for creating software that is flexible, maintainable, and extensible.

### Bad example:

```
public class Rectangulo {
    protected int ancho;
    protected int altura;
    
    public Rectangulo(int ancho, int altura) {
        this.ancho = ancho;
        this.altura = altura;
    }

    public int getAncho() {
        return ancho;
    }
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public int area() {
        return ancho * altura;
    }
}

public class Cuadrado extends Rectangulo {
    public Cuadrado(int lado) {
        super(lado, lado);
    }
    
    @Override
    public void setAncho(int ancho) {
        super.setAncho(ancho);
        super.setAltura(ancho);
    }
    
    @Override
    public void setAltura(int altura) {
        super.setAltura(altura);
        super.setAncho(altura);
    }
}

public class Principal {
    public static void main(String[] args) {
        Rectangulo rectangulo = new Cuadrado(5);
        rectangulo.setAncho(10);
        rectangulo.setAltura(20);
        System.out.println(rectangulo.area()); // El resultado debería ser 200, pero es 400
    }
}
```
In this example, there is a Rectangle class which has width and height properties, and a method to calculate its area. The Square class extends the Rectangle class and has a constructor that takes the size of one side. However, in the Square class, the setWidth() and setHeight() methods are overridden to ensure that width and height are always equal, which is not the expected behavior for the Rectangle class.

In the main() method, an object of the Square class is created and assigned to a variable of type Rectangle. Then, width and height values are set for the object, which should change the area of the object to 200. However, since the object is actually a Square, the incorrect implementation of setWidth() and setHeight() results in an area of 400.

This example violates the LSP principle, since an instance of the Square class cannot be used interchangeably with an instance of the Rectangle class. The expected behavior of the setWidth() and setHeight() methods of the Rectangle class is not maintained in the Square class, leading to unexpected results.

### Good example:

```
public class Rectangulo {
    protected double ancho;
    protected double alto;
    
    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }
    
    public double getAncho() {
        return ancho;
    }
    
    public double getAlto() {
        return alto;
    }
    
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    
    public void setAlto(double alto) {
        this.alto = alto;
    }
    
    public double area() {
        return ancho * alto;
    }
}

public class Cuadrado extends Rectangulo {
    
    public Cuadrado(double lado) {
        super(lado, lado);
    }
    
    @Override
    public void setAncho(double ancho) {
        super.setAncho(ancho);
        super.setAlto(ancho);
    }
    
    @Override
    public void setAlto(double alto) {
        super.setAncho(alto);
        super.setAlto(alto);
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangulo r = new Rectangulo(4, 5);
        System.out.println("Area del rectangulo: " + r.area());
        
        Cuadrado c = new Cuadrado(4);
        System.out.println("Area del cuadrado: " + c.area());
        
        r = c;
        System.out.println("Area del rectangulo (cuadrado): " + r.area());
    }
}
```

In this example, the Square class extends the Rectangle class and is used to represent a square. The Square class overrides the setWidth and setHeight methods to ensure that they always have the same value.

In the main method, two objects are created: one of the Rectangle class and one of the Square class. The area of each object is calculated and the results are printed. Then, the c object of the Square class is assigned to the r object of the Rectangle class. The area of r is calculated and the result is printed.

As can be seen, the c object of the Square class can be used in place of the r object of the Rectangle class without any changes to the program. This demonstrates that the Liskov Substitution Principle is being followed.

---
[Back to the list](./README.md)