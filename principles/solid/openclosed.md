## Open/Closed

States that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that a software entity should be designed in a way that allows for new functionality to be added without modifying its source code.

The OCP addresses the problem of making changes to a codebase that has already been deployed. If we modify the source code of a class that is already in production, we risk introducing new bugs or breaking existing functionality. This can be a significant problem, especially in large codebases, where changes can have unpredictable consequences.

To solve this problem, the OCP proposes designing software entities in a way that allows for extension without modification. This can be achieved by using techniques such as inheritance, composition, and design patterns such as the Strategy pattern.

### Bad Example
In this example, we see the Order class violates the OCP because it's not open for extension. If we want to add a new type of discount, we would have to modify the applyDiscount() method. This can be problematic if the Order class is already in production, as modifying its source code can introduce bugs or break existing functionality.

``` java
// The Order class violates the OCP
public class Order {
    private int id;
    private String customerName;
    private double total;
    
    // Method to calculate the total order value
    public double calculateTotal() {
        // Calculation logic
    }
    
    // Method to apply a discount to the order
    public void applyDiscount(double discount) {
        // Discount logic
    }
}

// Another class that uses the Order class
public class OrderProcessor {
    public void processOrder(Order order) {
        double total = order.calculateTotal();
        order.applyDiscount(0.1); // Apply 10% discount
        // Process order logic
    }
}

```

### Good Example
Now, we see how the 'Order' class is designed to be open for extension, as we can add new types of discounts by creating new classes that implement the 'Discount' interface. The 'OrderProcessor' class also uses the 'Discount' interface to apply discounts to the order, rather than modifying the 'Order' class directly.

``` java
// The Order class respects the OCP
public class Order {
    private int id;
    private String customerName;
    private double total;
    
    // Method to calculate the total order value
    public double calculateTotal() {
        // Calculation logic
    }
}

// A separate class for applying discounts
public interface Discount {
    double apply(double total);
}

public class TenPercentDiscount implements Discount {
    public double apply(double total) {
        return total * 0.1;
    }
}

public class TwentyPercentDiscount implements Discount {
    public double apply(double total) {
        return total * 0.2;
    }
}

// Another class that uses the Order class and the Discount interface
public class OrderProcessor {
    private Discount discount;
    
    public OrderProcessor(Discount discount) {
        this.discount = discount;
    }
    
    public void processOrder(Order order) {
        double total = order.calculateTotal();
        double discountAmount = discount.apply(total);
        // Process order logic
    }
}

```

## Related principles
- [Do the simplest thing that could possibly work](../general/dothesimplestthing.md)
- [Separation of Concerns](../general/separationofconcerns.md)

[Back to the list](./README.md)