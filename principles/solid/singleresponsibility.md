## Single Responsibility

The Single Responsibility principle states that a class should have a single responsibility, which helps to avoid complexity and increase code cohesion. By having a single responsibility, classes are easier to understand, maintain and reuse in other projects.

### Bad example:

The "Product" class has multiple responsibilities, which violates the Single Responsibility principle. In addition to representing a product, it also has the responsibility of calculating the discounted price. This makes the class more complex and difficult to understand, and any change in one part of the class can have unpredictable effects on other parts of the class. This increases the risk of introducing errors into the code and makes the class less flexible and reusable in other projects.

```Java
public class Product {
    private String name;
    private String description;
    private double price;

    // Constructor
    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        // Calculate discounted price
        double discountedPrice = price * 0.9;
        return discountedPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
```

### Good example:

The "Product" class has a single responsibility to represent a product. This makes the class more cohesive and easier to understand. In addition, the functionality to calculate the discounted price has been moved to a separate class called "DiscountCalculator", which complies with the Single Responsibility principle. This means that if we ever need to change the way the discount is calculated, we can do so without having to modify the "Product" class, which reduces the risk of errors and increases the flexibility of the code.

```Java
public class Product {
    private String name;
    private String description;
    private double price;

    // Constructor
    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
```

### Related principles

- [Separation of Concerns](../../principles/general/separationofconcerns.md)
- [Code For The Maintainer](../../principles/general/codeformantainer.md)

### Related patterns

- Code For The Maintainer
- Composition Over Inheritance

---

[Back to the list](./README.md)
