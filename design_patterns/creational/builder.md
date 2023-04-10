# Builder pattern

Builder is a creative design pattern that allows us to build complex objects step by step. The pattern allows us to produce different types and representations of an object using the same building code.

The Builder pattern consists of two main parts: the director and the builder. The manager is responsible for coordinating the construction process and uses the builder to build the object step by step. The builder, on the other hand, is responsible for the construction of each part of the object.

<p align="center">
<img src="https://res.cloudinary.com/dz5pw4p7y/image/upload/v1681086544/design_patterns/builder_npms8f.png" alt="mypic" width="75%">
</p>

## 😟 Problem

Imagine that we want to build a class to represent a pizza with all its ingredients, and for this we use the Builder pattern

```java
public class Pizza {
    private String size;
    private String sauce;
    private String[] toppings;

    public Pizza(String size, String sauce, String[] toppings) {
        this.size = size;
        this.sauce = sauce;
        this.toppings = toppings;
    }

    public String getSize() {
        return size;
    }

    public String getSauce() {
        return sauce;
    }

    public String[] getToppings() {
        return toppings;
    }
}

public class PizzaBuilder {
    private Pizza pizza;

    public PizzaBuilder() {
        pizza = new Pizza();
    }

    public void setSize(String size) {
        pizza.setSize(size);
    }

    public void setSauce(String sauce) {
        pizza.setSauce(sauce);
    }

    public void setToppings(String[] toppings) {
        pizza.setToppings(toppings);
    }

    public Pizza build() {
        return pizza;
    }
}
```
The constructor of the `Pizza` class receives all the necessary parameters to build the pizza. In the `PizzaBuilder`, you have a method to set each of the attributes of the `Pizza` class.

The problem with this implementation is that the `Pizza` constructor is publicly exposed, which allows creating instances of `Pizza` without using the `PizzaBuilder`. In addition, the `PizzaBuilder` does not perform any validation of the data provided before building the pizza, which can lead to errors if incorrect values are provided.

## 🙂 Solution

A better implementation would be to use a private constructor in the `Pizza` class and use methods in the `PizzaBuilder` to set the attributes, as shown below:

```java
public class Pizza {
    private String size;
    private String sauce;
    private String[] toppings;

    private Pizza(String size, String sauce, String[] toppings) {
        this.size = size;
        this.sauce = sauce;
        this.toppings = toppings;
    }

    public String getSize() {
        return size;
    }

    public String getSauce() {
        return sauce;
    }

    public String[] getToppings() {
        return toppings;
    }

    public static class PizzaBuilder {
        private String size;
        private String sauce;
        private String[] toppings;

        public PizzaBuilder() {}

        public PizzaBuilder setSize(String size) {
            this.size = size;
            return this;
        }

        public PizzaBuilder setSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder setToppings(String[] toppings) {
            this.toppings = toppings;
            return this;
        }

        public Pizza build() {
            if (size == null || sauce == null || toppings == null) {
                throw new IllegalStateException("Missing required parameters");
            }
            return new Pizza(size, sauce, toppings);
        }
    }
}
```

In this implementation, the constructor of the `Pizza` class is private, so you cannot create an instance directly. The `PizzaBuilder` uses chained methods to set the pizza attributes and performs validations before building the pizza to ensure that all necessary values are provided. This makes the code more robust and easier to use.

