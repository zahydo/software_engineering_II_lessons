## Open/Closed

Establishes that a class should be open for extension but closed for modification. That is to say, new functionalities should be able to be added without having to modify existing code.

### Bad example:

```
public class Calculadora {
    public double sumar(double num1, double num2) {
        return num1 + num2;
    }
    
    public double restar(double num1, double num2) {
        return num1 - num2;
    }
    
    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }
    
    public double dividir(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        
        return num1 / num2;
    }
}
```
In this example, the Calculator class has concrete methods to perform basic mathematical operations. If a new functionality, such as calculating square root or logarithm, needs to be added, the Calculator class would have to be modified. This violates the OCP principle since the Calculator class is not closed for modification.
### Good example:

```
public interface Calculadora {
    double calcular(double num1, double num2);
}


public class Suma implements Calculadora {
    @Override
    public double calcular(double num1, double num2) {
        return num1 + num2;
    }
}
public class Resta implements Calculadora {
    @Override
    public double calcular(double num1, double num2) {
        return num1 - num2;
    }
}
public class Multiplicacion implements Calculadora {
    @Override
    public double calcular(double num1, double num2) {
        return num1 * num2;
    }
}
public class Division implements Calculadora {
    @Override
    public double calcular(double num1, double num2) {
        return num1 / num2;
    }
}
```
This is an interface that represents a generic calculator that can perform basic mathematical operations. Now, classes can be created that implement this interface to add new functionalities without having to modify the original interface.

---
[Back to the list](./README.md)