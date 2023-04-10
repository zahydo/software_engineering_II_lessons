# Factory Method

The "Factory Method" design pattern solves the problem of creating objects without explicitly specifying the specific class to be created. Instead of directly creating an object from a class, a factory is used to create objects through a factory method. This allows for greater flexibility and extensibility in object creation, since the object creation logic is separated from the object usage logic.

The idea behind this pattern is to define an abstract class that has a method for creating objects. Subclasses can implement that method to create different types of objects. In this way, the abstract class can provide a generic interface for object creation, while the subclasses can customize object creation as needed.

The "Factory Method" pattern is implemented by creating an abstract class that defines the "Factory Method" method for creating objects. Then, several subclasses are created that implement the "Factory Method" method to create different types of objects.

## Example

![ClassDiagram](http://www.plantuml.com/plantuml/png/fP71IWCn48RlUOevLefvW21I4Bs9X_e2OpBQXJG9CnEmgEzktBL8RBpOqsxop_yD_v-DABBMVJHJKk9dz0JRtLJAb5xkINSvm9jPUuo-HbGwIZTPT9Kv43ju-FfSW8EGwrCays6CZoW2MyKKaCFHz7_IxMjX4ZaVr4UxGw-P3pEEgR5wUINVnyT38TVYSFjlr5-K7_gyjj4kHyPsszbECElPFbxwLzu-Om-4gtThJnvXEDJtEvnPmWsLOQbcASFQwx4E3fREnMmeXRgFdm00)

A real example of the implementation of the "Factory Method" design pattern would be in an order management system in an online store. Suppose the store has different types of shipping, such as express shipping, standard shipping, economy shipping, etc. To implement the "Factory Method" pattern, we could create an interface called "ShippingMethod" that defines the "calculateShippingCost()" method to calculate the shipping cost of an order.

``` java
public interface ShippingMethod {
    public double calculateShippingCost(Order order);
}
```

Then, we could create different classes that implement the "ShippingMethod" interface, each of which would provide a different implementation for the "calculateShippingCost()" method. For example, a "StandardShipping" class might implement the method one way, while an "ExpressShipping" class might implement it another way.

``` java
public class StandardShipping implements ShippingMethod {
    public double calculateShippingCost(Order order) {
        // Calculation of shipping cost for standard shipping
    }
}

public class ExpressShipping implements ShippingMethod {
    public double calculateShippingCost(Order order) {
        // Calculation of shipping cost for express shipping
    }
}
```

Finally, in our main class that handles orders, instead of having a long block of code that calculates the shipping cost for each type of shipping, we could create a shipping factory that allows us to create an instance of the appropriate class based on the type of shipping selected. This way, our code is easier to read and maintain, and the responsibility of creating objects is delegated to the factory.

``` java
public class ShippingMethodFactory {
    public static ShippingMethod createShippingMethod(String shippingType) {
        if (shippingType.equalsIgnoreCase("standard")) {
            return new StandardShipping();
        } else if (shippingType.equalsIgnoreCase("express")) {
            return new ExpressShipping();
        } else {
            throw new IllegalArgumentException("Tipo de envío no válido");
        }
    }
}
```
In this example, the class "Order" represents an order in the online store. The class has a "shippingType" attribute that indicates the type of shipping selected by the customer and a "shippingMethod" attribute that represents the implementation of the appropriate shipping method.

In the constructor of the "Order" class, we create an instance of the appropriate class using the shipping factory "ShippingMethodFactory". In the "calculateShippingCost()" method, we call the "calculateShippingCost()" method of the appropriate "ShippingMethod" class instance to calculate the shipping cost of the order.

In this way, we can easily add new shipping types by simply adding new classes that implement the "ShippingMethod" interface and updating the "ShippingMethodFactory" shipping factory.

```java
public class Order {
    private String shippingType;
    private ShippingMethod shippingMethod;

    public Order(String shippingType) {
        this.shippingType = shippingType;
        this.shippingMethod = ShippingMethodFactory.createShippingMethod(shippingType);
    }

    public double calculateShippingCost() {
        return shippingMethod.calculateShippingCost(this);
    }
}
```
