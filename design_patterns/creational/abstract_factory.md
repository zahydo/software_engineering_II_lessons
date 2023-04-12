# Abstract Factory pattern
## Description
The Abstract Factory pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. In other words, the Abstract Factory pattern allows us to create objects that are related to each other in a way that we can change the entire family of objects by changing a single object.

The Abstract Factory pattern consists of the following components:

Abstract Factory: an interface that defines the methods for creating the abstract product objects.
Concrete Factory: a class that implements the Abstract Factory interface to create the concrete product objects.
Abstract Product: an interface that defines the common methods that the concrete products must implement.
Concrete Product: a class that implements the Abstract Product interface to provide specific functionality.

## Problem
Suppose you are working on a project that involves creating and managing different types of pizzas. Each pizza has various attributes such as size, crust type, toppings, etc. You want to be able to create different types of pizzas with different combinations of attributes easily.


## Solution
```java
public class Pizza {
    private String size;
    private String crustType;
    private List<String> toppings;

    public Pizza(String size, String crustType, List<String> toppings) {
        this.size = size;
        this.crustType = crustType;
        this.toppings = toppings;
    }

    // getters and setters for size, crustType, and toppings
}

public class PizzaBuilder {
    private String size;
    private String crustType;
    private List<String> toppings;

    public PizzaBuilder() {
        this.toppings = new ArrayList<>();
    }

    public PizzaBuilder size(String size) {
        this.size = size;
        return this;
    }

    public PizzaBuilder crustType(String crustType) {
        this.crustType = crustType;
        return this;
    }

    public PizzaBuilder toppings(List<String> toppings) {
        this.toppings = toppings;
        return this;
    }

    public Pizza build() {
        return new Pizza(size, crustType, toppings);
    }
}

Pizza pizza = new PizzaBuilder()
    .size("large")
    .crustType("thin")
    .toppings(Arrays.asList("pepperoni", "mushrooms", "onions"))
    .build();
```
This code creates a PizzaBuilder object and uses its methods to set the size, crust type, and toppings of the pizza. Finally, it calls the build() method to create the pizza with the specified attributes.

Using the Builder pattern in this way makes it easy to create different types of pizzas with different combinations of attributes without having to write a separate constructor for each one.