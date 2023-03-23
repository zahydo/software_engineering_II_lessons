## Interface Segregation

The Interface Segregation Principle (ISP) is a design principle that states that clients should not be forced to depend on interfaces they do not use. In other words, interfaces should be small and focused on a single responsibility, rather than having a large, monolithic interface.

### Bad example:
```java
public interface IAnimal {
    void eat();
    void sleep();
    void fly();
    void swim();
}

public class Bird implements IAnimal {
    @Override
    public void eat() {
        System.out.println("I'm eating.");
    }

    @Override
    public void sleep() {
        System.out.println("I'm sleeping.");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying.");
    }

    @Override
    public void swim() {
        throw new UnsupportedOperationException("I cannot swim.");
    }
}

public class Fish implements IAnimal {
    @Override
    public void eat() {
        System.out.println("I'm eating.");
    }

    @Override
    public void sleep() {
        System.out.println("I'm sleeping.");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("I cannot fly.");
    }

    @Override
    public void swim() {
        System.out.println("I'm swimming.");
    }
}

```
In this example, we have an IAnimal interface with four methods: Eat, Sleep, Fly, and Swim. The Bird and Fish classes implement the IAnimal interface, but they do not implement all of its methods. The Bird class can fly but cannot swim, while the Fish class can swim but cannot fly. This violates the ISP because clients that only care about animals that can swim or fly will be forced to depend on the methods they do not need.
### Good example:

```java
public interface IEatable {
    void eat();
}

public interface ISleepable {
    void sleep();
}

public interface IFlyable {
    void fly();
}

public interface ISwimmable {
    void swim();
}

public class Bird implements IEatable, ISleepable, IFlyable {
    @Override
    public void eat() {
        System.out.println("I'm eating.");
    }

    @Override
    public void sleep() {
        System.out.println("I'm sleeping.");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying.");
    }
}

public class Fish implements IEatable, ISleepable, ISwimmable {
    @Override
    public void eat() {
        System.out.println("I'm eating.");
    }

    @Override
    public void sleep() {
        System.out.println("I'm sleeping.");
    }

    @Override
    public void swim() {
        System.out.println("I'm swimming.");
    }
}

```
In this example, we have separated the IAnimal interface into four smaller, more focused interfaces: IEatable, ISleepable, IFlyable, and ISwimmable. The Bird and Fish classes now implement only the interfaces they need, so clients can depend on the interfaces they need without being forced to depend on the methods they do not need. This follows the ISP and makes the code more flexible and maintainable.

### Related principles

- [Separation of Concerns](/principles/general/separationofconcerns.md)
- [Do the Simplest Thing That Could Possibly Work](/principles/general/dothesimplestthing.md)

### Related patterns


[Back to the list](./README.md)