# Builder pattern
## Description
The Builder pattern is useful when we want to create objects that require multiple steps to construct, or when we want to create objects with different configurations. It allows us to build objects in a step-by-step manner, with each step providing more detail until the object is fully constructed.

In the Builder pattern, we have two main components: the Builder class and the Director class. The Builder class provides the interface for creating the complex object, and the Director class controls the construction process, using the Builder to create the object.

## Problem
Let's consider a scenario where we are developing an online food ordering system. Customers can choose from different types of foods, and each type of food can have different customization options, such as the amount of ingredients or portion size.

To efficiently implement this, we could use the Builder pattern to create complex and customized food objects step by step. Instead of having a food class with many instance variables and many constructors, we could have a Builder class that allows us to add customization options one by one.

## Solution

```java
// Product class
public class Food {
    private String type;
    private String size;
    private int numIngredients;

    public Food(String type, String size, int numIngredients) {
        this.type = type;
        this.size = size;
        this.numIngredients = numIngredients;
    }

    // Getters and setters
}

// Builder interface
public interface FoodBuilder {
    void setType(String type);
    void setSize(String size);
    void setNumIngredients(int numIngredients);
    Food getFood();
}

// Concrete builder
public class CustomFoodBuilder implements FoodBuilder {
    private String type;
    private String size;
    private int numIngredients;

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setNumIngredients(int numIngredients) {
        this.numIngredients = numIngredients;
    }

    public Food getFood() {
        return new Food(type, size, numIngredients);
    }
}

// Director
public class FoodOrderManager {
    private FoodBuilder builder;

    public FoodOrderManager(FoodBuilder builder) {
        this.builder = builder;
    }

    public void constructFood() {
        builder.setType("Pizza");
        builder.setSize("Large");
        builder.setNumIngredients(5);
    }

    public Food getFood() {
        return builder.getFood();
    }
}

// Example of using the Builder pattern
public class BuilderPatternDemo {
    public static void main(String[] args) {
        FoodBuilder builder = new CustomFoodBuilder();
        FoodOrderManager orderManager = new FoodOrderManager(builder);
        orderManager.constructFood();
        Food food = orderManager.getFood();
        System.out.println(food);
    }
} 
```
In this example, the Food class is the product that we want to create. The FoodBuilder interface defines the steps to build the food, and the CustomFoodBuilder class implements those steps to build a complex and customized Food object. The FoodOrderManager class acts as the Director, which controls the food building process using the custom constructor.

By using the Builder pattern in this way, we can create complex and customized food objects step by step, making the building process more flexible and easier to maintain. It also allows customers to customize their food more efficiently, as they can add customization options one at a time.