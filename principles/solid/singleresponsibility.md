## Single Responsibility

Single Responsibility Principle (SRP) es un principio de diseño de software que establece que una clase o módulo debería tener una única responsabilidad y que esta debería ser la única razón para cambiar su código. En otras palabras, una clase o módulo debería tener una única razón para existir y solo debería tener la responsabilidad de realizar una tarea específica.

### Bad example:
In this example, the "Calculator" class has the responsibility of performing mathematical operations and also printing the results:
```java
public class Calculator {

    public double add(double num1, double num2) {
        double result = num1 + num2;
        System.out.println("The sum of " + num1 + " and " + num2 + " is " + result);
        return result;
    }

    public double subtract(double num1, double num2) {
        double result = num1 - num2;
        System.out.println("The difference of " + num1 + " and " + num2 + " is " + result);
        return result;
    }

    public double multiply(double num1, double num2) {
        double result = num1 * num2;
        System.out.println("The product of " + num1 + " and " + num2 + " is " + result);
        return result;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        double result = num1 / num2;
        System.out.println("The quotient of " + num1 + " and " + num2 + " is " + result);
        return result;
    }
}

```
This violates the SRP principle because the class has more than one responsibility. If we needed to change the way results are printed, we would have to modify the "Calculator" class code, which means the class has more than one reason to change.

### Good example:

```java
public class Calculator {

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}

public class ResultPrinter {

    public void printResult(String operation, double num1, double num2, double result) {
        System.out.println("The " + operation + " of " + num1 + " and " + num2 + " is " + result);
    }
}


```
The "Calculator" class has the sole responsibility of performing mathematical operations, while the "ResultPrinter" class has the sole responsibility of printing the results. If we needed to change the way results are printed, we would only have to modify the "ResultPrinter" class code, without affecting the "Calculator" class. This means each class has a single reason to change, and we follow the SRP principle.
### Related principles

- [Separation of Concerns](/principles/general/separationofconcerns.md)
- [DRY](/principles/general/dry.md)
- [KISS](/principles/general/kiss.md)
- [Composition Over Inheritance](/principles/general/compositionoverinheritance.md)
- [Boy-Scout Rule](/principles/general/boyscoutrule.md)

### Related patterns


[Back to the list](./README.md)