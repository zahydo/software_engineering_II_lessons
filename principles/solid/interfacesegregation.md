## Interfaces Segregation

It states that a class should not be forced to implement interfaces that it does not use. That is, interfaces should be designed so that clients only depend on the methods they need and not on those they do not need.
The ISP addresses the problem of excessive coupling and unnecessary dependency between classes. When a class implements an interface it does not need, it is forced to provide empty implementations or throw exceptions on methods it does not use. This can increase complexity and confusion in the code, and can result in code that is unnecessary, inefficient and difficult to maintain.

To solve this problem, the ISP proposes to split larger interfaces into smaller, more specific interfaces, allowing classes to implement only what they need. In this way, unnecessary dependencies can be avoided and complexity and coupling between classes can be reduced.

### Bad Example
For example, suppose we have a Printable interface that defines a print() method. If a class only needs to print to one printer, it doesn't make sense for it to implement all the other methods of the Printable interface. Instead, we can split the Printable interface into two smaller, more specific interfaces: PrintableOnPrinter and PrintableOnScreen. This way, a class that only needs to print to a printer only implements PrintableOnPrinter and does not have to worry about the methods of PrintableOnScreen.
``` java
// Large interface violating the ISP
public interface Printable {
    void print();
    void fax();
    void email();
    void printToPrinter();
    void printToScreen();
}
// A class that implements all the interface methods, but does not need to photocopy
public class Invoice implements Printable {
    @Override
    public void print() {
        // Print logic
    }
    @Override
    public void fax() {
        // Scan logic
    }
    @Override
    public void email() {
        // Photocopy logic
    }
    @Override
    public void printToPrinter() {
        // Photocopy logic
    }
    @Override
    public void printToScreen() {
        // Photocopy logic
    }
}
```

### Good Example
In this example, we see how a large interface Printable is divided into two smaller, more specific interfaces: PrintableToPrinter and PrintableToScreen. We also have two classes Invoice and Report that implement only the interface they need.

```java
// Smaller, specific interfaces fulfilling the ISP
public interface PrintableToPrinter {
    void printToPrinter();
}

public interface PrintableToScreen {
    void printToScreen();
}

public class Invoice implements PrintableToPrinter {
    public void printToPrinter() {
        // Printer printing logic
    }
}

public class Report implements PrintableToScreen {
    public void printToScreen() {
        // Screen printing logic
    }
}
```

## Related principles
- [KISS](../general/kiss.md)
- [YAGNI](../general/yagni.md)
- [Boy-Scout Rule](../general/boyscoutrule.md)

[Back to the list](./README.md)