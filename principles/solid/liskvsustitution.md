## Liskov Substitution

This principle states that objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program. In other words, a subclass should be able to substitute for its parent class without changing the behavior of the program.

The LSP addresses the problem of using inheritance in a way that introduces new behaviors or side-effects. If a subclass introduces new behaviors that are not expected by the clients of its parent class, this can lead to bugs and other unexpected behavior.

To solve this problem, the LSP proposes that subclasses should not introduce new behaviors or side-effects that are not already defined by their parent class. Instead, they should be designed in a way that allows them to extend or refine the behavior of their parent class.

### Bad Example
Suppose we have a class 'Bird' that represents any type of bird. The class has a fly() method that allows the bird to fly.
``` java
public class Bird {
    public void fly() {
        System.out.println("The bird is flying");
    }
}
```
Now, suppose we want to create a subclass Penguin that inherits from Bird, but we know that penguins cannot fly. In this case, we could think of overriding the fly() method so that it does nothing, since penguins cannot fly.
```java
public class Penguin extends Bird {
    @Override
    public void fly() {
        // Does nothing
    }
}
```
At first glance, this seems to work correctly. However, this implementation violates Liskov's substitution principle. If some other code depends on the Ave class and expects any instance of Ave to be able to fly, then this implementation of the Penguin class would cause problems, since calling the fly() method on an object of the Penguin class would do nothing.
For example, if we have the following method that takes an instance of Ave and calls the fly() method:
``` java
public void doFly(Bird bird) {
    bird.fly();
}

```
When passing a 'Penguin' object to this method, it would do nothing because the fly() method in the 'Penguin' class does nothing. This can cause unexpected behavior and program errors.

### Good Example
To solve this, we could use a Flyer interface that implements the classes that can fly, and have the Ave class implement this interface:
``` java
public interface Flyer {
    void fly();
}

public class Bird implements Flyer {
    @Override
    public void fly() {
        System.out.println("The bird is flying.");
    }
}

public class Penguin extends Bird {
    // It is not necessary to implement the fly() method
}
```
In this way, any object that implements the 'Flyer' interface can be passed as a parameter to the doFly() method, and we will know that any instance of a class that implements this interface can fly. Also, if we need to add a new type of bird that cannot fly, we can simply create a subclass of 'Bird' without implementing the 'Flyer' interface, and this subclass will not be treated as an error by the rest of the program that depends on the 'Flyer' interface.

## Related principles
- [Code for the maintainer](../general/codeformantainer.md)

[Back to the list](./README.md)