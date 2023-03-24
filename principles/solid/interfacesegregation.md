## Interface Segregation

It is a design principle that states that a class should not depend on interfaces that it does not use. That is, a class should have a specific interface that corresponds exactly to the needs of the clients that use it.

Similar to the [Single Responsibility](./singleresponsibility.md) Principle, the goal of the Interface Segregation Principle is to reduce the side effects and frequency of required changes by splitting the software into multiple, independent parts.


### Bad example:

~~~java
interface IPrinter {
    void print();
    void scan();
    void copy();
    void fax();
}

class LaserPrinter implements IPrinter {
    // Implements all IPrinter methods, even if not needed
}

class InkjetPrinter implements IPrinter {
    // Implements all IPrinter methods, even if not needed
}

class FaxMachine implements IPrinter {
    // Implements all IPrinter methods, even if not needed
}

~~~
In this example, all classes implement all methods of the IPrinter interface, even if they don't need them. This makes the code less modular and harder to maintain, as classes have unnecessary dependencies on the IPrinter interface. If the IPrinter interface is changed to add a new method that is not relevant to printers, then all classes will be affected by this addition. It is better to avoid implementing unnecessary interfaces.

</br>

### Good example:


~~~java
interface IPrint {
    void print();
}

interface IScan {
    void scan();
}

interface ICopy {
    void copy();
}

interface IFax {
    void fax();
}

class LaserPrinter implements IPrint, ICopy {
    // Implements only IPrint and ICopy methods
}

class InkjetPrinter implements IPrint, IScan, ICopy {
    // Implements only IPrint, IScan, and ICopy methods
}

class FaxMachine implements IPrint, IFax {
    // Implements only IPrint and IFax methods
}
~~~

In this example, Instead of having a single interface with methods that may not be relevant to all classes that implement that interface, separate interfaces containing specific methods have been created. Each class only implements the interfaces that are relevant to its functionality and does not have to implement unnecessary methods.

Furthermore, by having smaller and more specific interfaces, it is easier for the classes that implement them to comply with interface contracts and not have to worry about implementing methods that are not relevant to their functionality. This makes the code easier to maintain and extend in the future.

### Related principles

* [Separation of Concerns](../general/separationofconcerns.md)
* [Composition Over Inheritance](../general/compositionoverinheritance.md)
* [KISS (Keep It Simple, Stupid)](../general/kiss.md)

---
[Back to the list](./README.md)