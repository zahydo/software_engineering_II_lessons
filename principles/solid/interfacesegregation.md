## Interface Segregation

This principle says that customers should not be affected to rely on interfaces they do not use. This means that you should not depend on a general purpose interface, but to establish several interfaces of specific use  for each client.

### Bad example:

Now, let's look at an example of the poor implementation of the principle.

```Java
interface IBird {
    void fly();
    void eat();
    void swim();
}

class Parrot implements IBird{

    @Override
    public void fly() {
        //...
    }

    @Override
    public void eat() {
        //...
    }

    @Override
    public void swim() {
        //...
    }
}

class Penguin implements IBird{

    @Override
    public void fly() {
       
    }

    @Override
    public void eat() {
       
    }

    @Override
    public void swim() {
       
    }
}
```
We have  an  Ave interface, which has 3 methods indicated. When we look at the classes that implement the interface, we see that the penguin class has a method that it cannot implement, which is the fly() method, so it would be violating the principle. 

### Good example:

What can be done is to segregate the interfaces as much as possible, as in the following implementation:

```Java
interface IBird {
    void eat();
}
interface IFlyingBird {
    void fly();
}

interface ISwimmerbird {
    void swim();
}

class Parrot implements IBird, IFlyingBird{

    @Override
    public void fly() {
       
    }

    @Override
    public void eat() {
       
    }
}

class Penguin implements IBird, ISwimmerbird{

    @Override
    public void swim() {
       
    }

    @Override
    public void eat() {
       
    }
}
```
### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)