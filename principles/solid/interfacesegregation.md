## Interface Segregation (ISP)

The Interface Segregation Principle (ISP) advises that it is preferable to have many client-specific interfaces rather than one general-purpose interface. In other words, it is important not to give a class a method that it will not use.

By adhering to the ISP, we can create more flexible and maintainable software. Instead of creating one large interface that may have many methods that are irrelevant to some classes, we can create smaller, more focused interfaces that are tailored to specific clients' needs. This allows us to avoid unnecessary dependencies and makes it easier to modify the interfaces and the classes that implement them without impacting the system's overall functionality.

Overall, the ISP encourages us to think carefully about how we design our interfaces and prioritize the specific needs of our clients over a one-size-fits-all approach.

### Bad example:

```
public interface Animal{
    public void eat();
    public void sleep();
    public void breed();
    public void walk();
}

public class fish implements Animal{
    @Override
    public void eat(){
    }

    @Override
    public void Sleep(){
    }

    @Override
    public void breed(){
    }

    @Override
    public void walk(){
    }
}


```
As we can see, the Animal interface requires the Fish class to implement the method "walk," even though the Fish class will never use this method.

This can be seen as a violation of the Interface Segregation Principle (ISP), which recommends that interfaces should only require classes to implement methods that are relevant to them. In this case, the "walk" method is not relevant to the Fish class, and requiring it to implement the method can introduce unnecessary dependencies and complicate the codebase.

### Good example:

```
public interface VitalFunctions{
    public void eat();
    public void sleep();
    public void breed();
}

public Interface TerrestrialAnimal{
    public void walk();
    public void run();
}

public interface AquaticAnimal{
    public void Swim();
}

public class fish Implements VitalFunctions,AquaticAnimal{
    @Override
    public void eat(){
    }

    @Override
    public void Sleep(){
    }

    @Override
    public void breed(){
    }

    @Override
    public void swim(){
    }
}
```

By creating more specialized interfaces, we have split the Animal interface into three separate interfaces, resulting in the Fish class no longer having to implement a method it does not use.

This approach not only adheres to the Interface Segregation Principle (ISP) but also makes our code more flexible and extensible. With the new specialized interfaces, different types of animals can now implement only the methods that are relevant to their physical capacities. This makes it easier to modify and extend our codebase without affecting the overall functionality of the system.



### Related principles

- [Separation of Concerns](../general/separationofconcerns.md)
- [Code For The Maintainer](../general/codeformantainer.md)
- [Boy-Scout Rule](../general/boyscoutrule.md)
- [Separation of Concerns](../general/separationofconcerns.md)

### Related patterns

- [Pattern names]


[Back to the list](./README.md)