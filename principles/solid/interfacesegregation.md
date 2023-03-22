## Interface Segregation

It is a design principle that states that a class should not depend on interfaces that it does not use. That is, a class should have a specific interface that corresponds exactly to the needs of the clients that use it.


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

In this example, each type of printer implements only the interfaces it needs, which makes the code more modular and easier to maintain.

### Related principles

* [Separation of Concerns](../general/separationofconcerns.md)
* [Composition Over Inheritance](../general/compositionoverinheritance.md)
* [KISS (Keep It Simple, Stupid)](../general/kiss.md)

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)