# INTERFACES SEGREGATION

It states that a class should not be forced to implement interfaces that it does not use. In other words, a class should be able to implement only the methods it needs from an interface and not the others. This principle helps prevent classes from becoming too coupled and rigid, which can make code difficult to understand and maintain.

## Bad Example
```
// Interface for a printer that can print, scan and photocopy
public interface MultifunctionPrinter {
    void Print();
    void Scan();
    void Photocopy();
}

// A class that implements all the interface methods, but does not need to photocopy
public class Printer implements MultifunctionPrinter {
    @Override
    public void Print() {
        // Print logic
    }
    @Override
    public void Scan() {
        // Scan logic
    }
    @Override
    public void Photocopy() {
        // Photocopy logic
    }
}
```

In this example, the Printer class implements all the methods of the "PrinterMultifunction" interface, but does not need to implement the photocopy() method. This means that the class is forced to implement a method that it does not need, which makes it more complex and rigid. If the interface is updated in the future and more methods are added, the Printer class will have to implement all of them, which may result in an overloaded and unnecessarily complex class.

## Good Example
```
// Interface for a printer that can print, scan and photocopy
public interface MultifunctionPrinter {
    void Print();
    void Scan();
    void Photocopy();
}

// A class implementing only the print methods
public class Printer implements MultifunctionPrinter {
    @Override
    public void Print() {
        // Print logic
    }
}
```
On the other hand, in this other example, the "Printer" class implements the "PrinterMultifunction" interface, but only implements the print() method and not the scan() and photocopy() methods. This way, the class only cares about what it needs to do, which makes the code easier to understand and maintain.

## Related principles
- KISS
- YAGNI
- Boy-Scout Rule