## Open/Closed

Open/Closed" is a principle that tells us that software entities (classes, modules, functions, etc.) must be open for extension but closed for modification. The aim is to maintain and protect the code, because if we fail to comply with the principle we may have to change parts of the code that depend on the entity, introducing new bugs. Instead we must write new code and not modify it, this can be done with inheritance, polymorphism and other mechanisms.

### Bad example:

```
public class Shape {
   private String type;
   private double width;
   private double height;

   public Shape(String type, double width, double height) {
      this.type = type;
      this.width = width;
      this.height = height;
   }

   public double area() {
      if (type.equals("rectangle")) {
         return width * height;
      } else if (type.equals("triangle")) {
         return 0.5 * width * height;
      } else {
         return 0.0;
      }
   }
}
```

In this example we calculate areas of a geometric shape and we see that inside the class the area is calculated and if we want a new shape, then we must modify the code of the area method, therefore, we are not complying with the principle

### Good example:

```
public class Shape {
   // métodos y propiedades de Shape

   public double area() {
      // código para calcular el área de la forma
   }
}

public class Triangle extends Shape {
   private double base;
   private double height;

   public Triangle(double base, double height) {
      this.base = base;
      this.height = height;
   }

   @Override
   public double area() {
      return 0.5 * base * height;
   }
}
```

In this example, we are extending the Shape class to add a new geometric shape, a triangle. The Triangle class provides an implementation of the area() method that calculates the area of the triangle without directly modifying the Shape class. In this way, we can add new geometric shapes without having to modify the Shape class, complying with the open-closed principle.

### Related principles

- [Code For The Maintainer](../general/codeformantainer.md) 
- [Separation of Concerns](../general/separationofconcerns.md)

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)