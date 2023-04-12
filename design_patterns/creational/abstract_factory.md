# Abstract Factory

The Abstract Factory design pattern (also known as Abstract Factory) is a creational pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. In this pattern, an abstract factory defines a set of abstract methods that are used to create interrelated objects. Each concrete factory that implements the abstract factory provides concrete implementations for these methods, thus creating different families of related objects. This pattern is useful in situations where a system needs to be independent of how its objects are created and represented, or when you need to have multiple families of related objects available and be able to switch between them at runtime. For example, in an RPG, the Abstract Factory pattern could be used to create different types of characters, each with different abilities and attributes. A particular factory might create warrior characters with fighting abilities, while another factory might create wizard characters with spellcasting abilities.


[TODO ejemplo]
Suppose we are developing an e-commerce application that sells products in different countries. Each country has different rules and regulations for the products that are sold, so we need a way to create different product objects depending on the country in which they are sold.

First, we'll define an abstract interface ProductFactory that defines the abstract methods for creating different types of products:

~~~java
public interface ProductFactory {
   public Product createProductA();
   public Product createProductB();
}
~~~
Next, we define two concrete implementations of ProductFactory for two different countries: USProductFactory for the United States and CANProductFactory for Canada.

~~~java
public class USProductFactory implements ProductFactory {
    public Product createProductA() {
        return new USProductA();
    }
    public Product createProductB() {
        return new USProductB();
    }
}

public class CANProductFactory implements ProductFactory {
    public Product createProductA() {
        return new CANProductA();
    }
    public Product createProductB() {
        return new CANProductB();
    }
}
~~~
Each of these concrete factories implements the createProductA() and createProductB() methods to create ProductA and ProductB objects specific to its country.

Finally, we define the Product class and its ProductA and ProductB subclasses, which are the objects that are created using the Abstract Factory pattern:
~~~java
public interface Product {
    public void print();
}

public class USProductA implements Product {
    public void print() {
        System.out.println("This is US Product A");
    }
}

public class USProductB implements Product {
    public void print() {
        System.out.println("This is US Product B");
    }
}

public class CANProductA implements Product {
    public void print() {
        System.out.println("This is CAN Product A");
    }
}

public class CANProductB implements Product {
    public void print() {
        System.out.println("This is CAN Product B");
    }
}

~~~

We can now create different product objects based on the country using the Abstract Factory pattern as follows:

~~~java
public static void main(String[] args) {
    ProductFactory factory = new USProductFactory();
    Product productA = factory.createProductA();
    Product productB = factory.createProductB();
    productA.print();
    productB.print();
    
    factory = new CANProductFactory();
    productA = factory.createProductA();
    productB = factory.createProductB();
    productA.print();
    productB.print();
}

~~~
In this example, we create two product objects (ProductA and ProductB) for the United States and Canada using different concrete factories (USProductFactory)and (CANProductFactory).

# Diagrama Abstract Factory

![Diagrama Abstract Factory]("aqui va el nombre de la imagen".png)
