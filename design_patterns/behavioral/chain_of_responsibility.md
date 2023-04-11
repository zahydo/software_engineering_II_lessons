# Chain of responsibility pattern

## Description
The Chain of Responsibility is a behavioral design pattern that enables an object to pass a request through a chain of handlers until the request is handled. This pattern creates a chain of objects, each of which can handle the request or pass it to the next object in the chain.

## Problem
You are implementing a simple online shopping system. When a customer places an order, the system needs to calculate the total price of the order based on the items selected and any applicable discounts or taxes. However, there are different types of discounts and taxes that can be applied, depending on the items in the order and the customer's location. For example, there may be a percentage discount for orders over a certain amount, or a sales tax that varies by state.

To make the system flexible and maintainable, you want to use the Chain of Responsibility pattern to handle the calculation of discounts and taxes. Each discount or tax rule can be implemented as a separate handler in the chain, and the system can dynamically assemble the chain based on the customer's location and the items in the order. The chain should be able to handle requests in a way that is efficient and avoids duplicating code or logic.

## Solution
```java
public interface OrderHandler {
    void setNext(OrderHandler nextHandler);
    double handle(Order order);
}

public class DiscountHandler implements OrderHandler {
    private OrderHandler nextHandler;
    
    public void setNext(OrderHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    public double handle(Order order) {
        // calculate any applicable discounts based on the order
        double discount = 0.0;
        if (order.getTotalPrice() >= 100.0) {
            discount = 0.1 * order.getTotalPrice();
        }
        
        // pass the order to the next handler in the chain
        if (nextHandler != null) {
            discount += nextHandler.handle(order);
        }
        
        return discount;
    }
}

public class TaxHandler implements OrderHandler {
    private OrderHandler nextHandler;
    
    public void setNext(OrderHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    public double handle(Order order) {
        // calculate any applicable taxes based on the order and customer location
        double tax = 0.0;
        if (order.getCustomerLocation().equals("CA")) {
            tax = 0.08 * order.getTotalPrice();
        }
        
        // pass the order to the next handler in the chain
        if (nextHandler != null) {
            tax += nextHandler.handle(order);
        }
        
        return tax;
    }
}

public class Order {
    private List<Item> items;
    private String customerLocation;
    
    public Order(List<Item> items, String customerLocation) {
        this.items = items;
        this.customerLocation = customerLocation;
    }
    
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    
    public String getCustomerLocation() {
        return customerLocation;
    }
}

public class Item {
    private String name;
    private double price;
    
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
}

// example usage
public static void main(String[] args) {
    // create some items and an order
    List<Item> items = new ArrayList<>();
    items.add(new Item("Widget A", 10.0));
    items.add(new Item("Widget B", 20.0));
    Order order = new Order(items, "CA");
    
    // create the chain of responsibility
    OrderHandler discountHandler = new DiscountHandler();
    OrderHandler taxHandler = new TaxHandler();
    discountHandler.setNext(taxHandler);
    
    // process the order using the chain
    double totalDiscount = discountHandler.handle(order);
    double totalTax = taxHandler.handle(order);
    double totalPrice = order.getTotalPrice() - totalDiscount + totalTax;
    
    System.out.println("Total price: " + totalPrice);
}

```

In this solution, OrderHandler is the interface for the handlers in the chain, which have a setNext() method to set the next handler in the chain and a handle() method to process the order and return any discounts or taxes. DiscountHandler and TaxHandler are concrete implementations of the OrderHandler interface, which calculate discounts and taxes, respectively. The Order class represents an order in the system, with a list of items and a customer location. Finally, the main() method creates an order, creates the chain of responsibility with a DiscountHandler followed by



