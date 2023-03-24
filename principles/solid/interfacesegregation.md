# Interface Segregation

The Interface Segregation Principle (ISP) states that clients should not be forced to depend on interfaces that they do not use. In other words, a class should not be forced to implement methods that it does not need or use. Instead, the interface should be broken down into smaller and more focused interfaces that are specific to the needs of each client. This promotes the decoupling of interfaces and reduces the impact of changes to one interface on other clients that depend on it. The ISP is one of the SOLID principles of object-oriented design.

### Bad example:

Suppose we have the same Printable interface that defines a print() method to print an object to the console. Instead of creating more specific interfaces, all printable classes implement the Printable interface:
```
public interface Printable {
    void print();
}

public class Invoice implements Printable {
    // implementacion de los metodos
}

public class Receipt implements Printable {
    // implementacion de los metodos
}

public class ShippingLabel implements Printable {
    // implementacion de los metodos
}
```


### Good example:

Suppose we have a Printable interface that defines a print() method to print an object to the console. Instead of making all printable classes implement the Printable interface, we can create more specific interfaces for each type of printable object:

```
public interface Printable {
    void print();
}

public interface InvoicePrintable {
    void printInvoice();
}

public interface ReceiptPrintable {
    void printReceipt();
}

public class Invoice implements Printable, InvoicePrintable {
    // implementacion de los metodos
}

public class Receipt implements Printable, ReceiptPrintable {
    // implementacion de los metodos
}
```

### Related principles

- Dependency Injection 

### Related patterns

- YAGNI 
- KISS 
- Separation of Concerns
- Boy-Scout Rule

---
[Back to the list](./README.md)