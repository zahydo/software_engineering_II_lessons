## Interface Segregation

The Interface Segregation Principle (ISP) is a design principle that states that clients should not be forced to depend on interfaces they do not use. In other words, interfaces should be small and focused on a single responsibility, rather than having a large, monolithic interface.

### Bad example:
```c#
public interface IAnimal
{
    void Eat();
    void Sleep();
    void Fly();
    void Swim();
}

public class Bird : IAnimal
{
    public void Eat()
    {
        Console.WriteLine("I'm eating.");
    }

    public void Sleep()
    {
        Console.WriteLine("I'm sleeping.");
    }

    public void Fly()
    {
        Console.WriteLine("I'm flying.");
    }

    public void Swim()
    {
        throw new NotImplementedException("I cannot swim.");
    }
}

public class Fish : IAnimal
{
    public void Eat()
    {
        Console.WriteLine("I'm eating.");
    }

    public void Sleep()
    {
        Console.WriteLine("I'm sleeping.");
    }

    public void Fly()
    {
        throw new NotImplementedException("I cannot fly.");
    }

    public void Swim()
    {
        Console.WriteLine("I'm swimming.");
    }
}
```
In this example, we have an IAnimal interface with four methods: Eat, Sleep, Fly, and Swim. The Bird and Fish classes implement the IAnimal interface, but they do not implement all of its methods. The Bird class can fly but cannot swim, while the Fish class can swim but cannot fly. This violates the ISP because clients that only care about animals that can swim or fly will be forced to depend on the methods they do not need.
### Good example:

```c#
public interface IEatable
{
    void Eat();
}

public interface ISleepable
{
    void Sleep();
}

public interface IFlyable
{
    void Fly();
}

public interface ISwimmable
{
    void Swim();
}

public class Bird : IEatable, ISleepable, IFlyable
{
    public void Eat()
    {
        Console.WriteLine("I'm eating.");
    }

    public void Sleep()
    {
        Console.WriteLine("I'm sleeping.");
    }

    public void Fly()
    {
        Console.WriteLine("I'm flying.");
    }
}

public class Fish : IEatable, ISleepable, ISwimmable
{
    public void Eat()
    {
        Console.WriteLine("I'm eating.");
    }

    public void Sleep()
    {
        Console.WriteLine("I'm sleeping.");
    }

    public void Swim()
    {
        Console.WriteLine("I'm swimming.");
    }
}
```
In this example, we have separated the IAnimal interface into four smaller, more focused interfaces: IEatable, ISleepable, IFlyable, and ISwimmable. The Bird and Fish classes now implement only the interfaces they need, so clients can depend on the interfaces they need without being forced to depend on the methods they do not need. This follows the ISP and makes the code more flexible and maintainable.

### Related principles

- [Separation of Concerns](/principles/general/separationofconcerns.md)
- [Do the Simplest Thing That Could Possibly Work](/principles/general/dothesimplestthing.md)

### Related patterns



[Back to the list](./README.md)