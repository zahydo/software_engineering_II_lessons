## DRY (Don't Repeat Yourself)

DRY advocates for avoiding repetition of code in order to improve code quality, reduce the risk of errors, and make code easier to maintain. The principle can be summarized as "Every piece of knowledge or logic should have a single, unambiguous, authoritative representation within a system." This means that if there is a piece of code that is repeated in multiple places, it should be abstracted into a reusable function or class.

### Bad example

```
public class Example {
    public void calculateSum(int a, int b) {
        int sum = a + b;
        System.out.println("The sum is: " + sum);
    }
    
    public void calculateDifference(int a, int b) {
        int difference = a - b;
        System.out.println("The difference is: " + difference);
    }
    
    public void calculateProduct(int a, int b) {
        int product = a * b;
        System.out.println("The product is: " + product);
    }
    
    public void calculateQuotient(int a, int b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero.");
            return;
        }
        
        int quotient = a / b;
        System.out.println("The quotient is: " + quotient);
    }
}


```
In this example, all the operations do almost the same. So this could be resumed in a unique function.

### Good example:

```
public class Example {
    public void calculate(int a, int b, String operation) {
        int result = 0;
        
        switch (operation) {
            case "sum":
                result = a + b;
                break;
            case "difference":
                result = a - b;
                break;
            case "product":
                result = a * b;
                break;
            case "quotient":
                if (b == 0) {
                    System.out.println("Cannot divide by zero.");
                    return;
                }
                result = a / b;
                break;
            default:
                System.out.println("Invalid operation.");
                return;
        }
        
        System.out.println("The " + operation + " is: " + result);
    }
}
```





[Back to the list](./README.md)