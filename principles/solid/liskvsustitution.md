## Liskov Substitution

The Liskov Substitution Principle (LSP) is a software design principle that states that objects of a superclass should be able to be replaced with objects of its subclass without affecting the correctness of the program. In other words, a subclass should be able to be used wherever its parent class is used.

### Bad example:

In this example, we have a Animal base class with a virtual MakeSound method, and two subclasses Dog and Cat that override the MakeSound method to make a specific sound:

```java
public class Animal {
    public void makeSound() {
        System.out.println("Animal is making a sound.");
    }
}

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

```

However, this violates the Liskov Substitution Principle because if we have code that expects an Animal object, we might call the MakeSound method on it assuming that it makes a generic animal sound. If we pass a Dog or Cat object to this code, the MakeSound method would print a specific sound, which might break the code.

### Good example:
```java
public interface IAnimal {
    void makeSound();
}

public abstract class Animal implements IAnimal {
    public abstract void makeSound();
}

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

```
Now, the Animal class is abstract and implements the IAnimal interface, which provides a common MakeSound method that all animals must implement. The Dog and Cat classes inherit from Animal and override the MakeSound method to provide a specific sound for each animal. This allows us to use an Animal object interchangeably with any other object that implements the IAnimal interface, without violating the Liskov Substitution Principle.

### Related principles

- [Separation of Concerns](/principles/general/separationofconcerns.md)
- [DRY](/principles/general/dry.md)
- [KISS](/principles/general/kiss.md)
- [Composition Over Inheritance](/principles/general/compositionoverinheritance.md)
- [Do the Simplest Thing That Could Possibly Work](/principles/general/dothesimplestthing.md)
- [Code For The Maintainer](/principles/general/codeformantainer.md)
- [Avoid Premature Optimization](/principles/general/avoidprematureopt.md)

### Related patterns


[Back to the list](./README.md)