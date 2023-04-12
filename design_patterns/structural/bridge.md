## Bridge pattern

## Description

The Bridge pattern is a design pattern in object-oriented programming that allows you to decouple an abstraction 
from its implementation so that both can vary independently. It involves creating two separate class hierarchies: 
one for the abstraction and one for the implementation, and then providing a bridge between the two hierarchies. 
This allows changes to be made to either the abstraction or implementation without affecting the other. The Bridge 
pattern is useful in situations where you want to be able to vary the implementation of an abstraction dynamically 
or where you want to separate the interface of an abstraction from its implementation.

## Problem

Suppose we have a product sales system that can be used both in a physical store and in an online store. However, 
the way payments are handled is different in each case. In the physical store, payments are processed at a cash 
register, while online different electronic payment methods are used.

## Solution

In this case, we can use the Bridge pattern to separate the abstraction from the payment processing implementation 
details. First, we define a payment interface that represents the abstraction. We then create two concrete classes, 
one for in-store payment processing and one for online payment processing, each implementing the payment interface. 
Finally, we create a bridge class that connects the abstraction and the implementation.

Below is the Java code for this solution:

```Java: 

    // Payment interface (abstraction)
    public interface Payment {
        public void processPayment();
    }

    // Concrete class for processing payments in the physical store (implementation)
    public class CashPayment implements Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing cash payment...");
        }
    }

    // Concrete class for online payment processing (implementation)
    public class OnlinePayment implements Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing online payment...");
        }
    }

    // Bridge class connecting abstraction and implementation
    public abstract class Product {
        protected Payment payment;

        public Product(Payment payment) {
            this.payment = payment;
        }

        public abstract void seal();
    }

    // Class that represents a product sold in the physical store
    public class PhysicalProduct extends Product {
        public PhysicalProduct(Payment payment) {
            super(payment);
        }

        @Override
        public void seal() {
            System.out.println("Product sold in the physical store.");
            payment.processPayment();
        }
    }

    // Class representing a product sold online
    public class OnlineProduct extends Product {
        public OnlineProduct(Payment payment) {
            super(payment);
        }

        @Override
        public void seal() {
            System.out.println("Product sold online.");
            payment.processPayment();
        }
    }

    // Usage example
    public class Main {
        public static void main(String[] args) {
            Payment cashPayment = new CashPayment();
            Payment onlinePayment = new OnlinePayment();

            Product physicalProduct = new PhysicalProduct(cashPayment);
            physicalProduct. sell();

            Product onlineProduct = new OnlineProduct(onlinePayment);
            onlineProduct. sell();
        }
    }    

```

In this example, the payment interface represents the abstraction and the CashPayment and OnlinePayment classes 
represent the implementation. The Product class is the bridge class that connects the abstraction and the 
implementation. The PhysicalProduct and OnlineProduct classes are subclasses of Product that represent products sold
in the physical store and online, respectively.

When a PhysicalProduct or OnlineProduct object is created, it is passed an instance of CashPayment or OnlinePayment,
respectively, as an argument to the Product constructor. Then when called