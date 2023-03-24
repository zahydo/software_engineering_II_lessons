## Single Responsibility

The principle of "Single Responsibility" indicates that a class should have a single defined responsibility, as this makes it easier to understand, test and maintain. A class that violates this principle makes it difficult to change, reuse, understand or test, due to coupling with other classes and when this happens it should be divided into multiple classes.

### Bad example:

```
public class Order {
   private String name;
   private int quantity;
   private double unitPrice;

   public Order(String name, int quantity, double unitPrice) {
      this.name = name;
      this.quantity = quantity;
      this.unitPrice = unitPrice;
   }

   public double calculateTotalPrice() {
      double totalPrice = quantity * unitPrice;
      return totalPrice;
   }

   // getters and setters
}
```
This code violates the principle because we see that a single class called order collects the product information, and calculates the total order, therefore, this class has multiple responsibilities and to fix it we must separate by classes

### Good example:

```
public class Order {
   private Product product;
   private int quantity;

   public Order(Product product, int quantity) {
      this.product = product;
      this.quantity = quantity;
   }

   // getters and setters
}

public class Product {
    private String name;
    private int unitPrice;

    public Product(String name, int unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    // getters and setters
}

public class OrderPriceCalculator {
   public double calculatePrice(Order order) {
      Product product = order.getProduct();
      int quantity = order.getQuantity();
      double unitPrice = product.getPrice();
      double totalPrice = quantity * unitPrice;
      return totalPrice;
   }

   // getters and setters
}
```
In this code we can already see that the responsibilities that had a single class are separated, now the order class is responsible for receiving already created a product object and the quantity, where the OrderPriceCalculator class is already responsible for calculating the total order with the objects of the other classes and their methods.

### Related principles

- [Separation of Concerns](../general/separationofconcerns.md)

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)