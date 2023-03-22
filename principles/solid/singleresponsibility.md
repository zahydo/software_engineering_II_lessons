## Single Responsibility

Single Responsibility Principle (SRP) es un principio de diseño de software que establece que una clase o módulo debería tener una única responsabilidad y que esta debería ser la única razón para cambiar su código. En otras palabras, una clase o módulo debería tener una única razón para existir y solo debería tener la responsabilidad de realizar una tarea específica.

### Bad example:
In this example, the "Calculator" class has the responsibility of performing mathematical operations and also printing the results:
```c#
public class Calculator
{
    public double Add(double num1, double num2)
    {
        double result = num1 + num2;
        Console.WriteLine($"The sum of {num1} and {num2} is {result}");
        return result;
    }
    
    public double Subtract(double num1, double num2)
    {
        double result = num1 - num2;
        Console.WriteLine($"The difference of {num1} and {num2} is {result}");
        return result;
    }
    
    public double Multiply(double num1, double num2)
    {
        double result = num1 * num2;
        Console.WriteLine($"The product of {num1} and {num2} is {result}");
        return result;
    }
    
    public double Divide(double num1, double num2)
    {
        if (num2 == 0)
        {
            throw new ArgumentException("Cannot divide by zero");
        }
        double result = num1 / num2;
        Console.WriteLine($"The quotient of {num1} and {num2} is {result}");
        return result;
    }
}
```
This violates the SRP principle because the class has more than one responsibility. If we needed to change the way results are printed, we would have to modify the "Calculator" class code, which means the class has more than one reason to change.

### Good example:

```c#
public class Calculator
{
    public double Add(double num1, double num2)
    {
        return num1 + num2;
    }
    
    public double Subtract(double num1, double num2)
    {
        return num1 - num2;
    }
    
    public double Multiply(double num1, double num2)
    {
        return num1 * num2;
    }
    
    public double Divide(double num1, double num2)
    {
        if (num2 == 0)
        {
            throw new ArgumentException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}

public class ResultPrinter
{
    public void PrintSum(double num1, double num2, double result)
    {
        Console.WriteLine($"The sum of {num1} and {num2} is {result}");
    }
    
    public void PrintDifference(double num1, double num2, double result)
    {
        Console.WriteLine($"The difference of {num1} and {num2} is {result}");
    }
    
    public void PrintProduct(double num1, double num2, double result)
    {
        Console.WriteLine($"The product of {num1} and {num2} is {result}");
    }
    
    public void PrintQuotient(double num1, double num2, double result)
    {
        Console.WriteLine($"The quotient of {num1} and {num2} is {result}");
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

- Factory

[Back to the list](./README.md)