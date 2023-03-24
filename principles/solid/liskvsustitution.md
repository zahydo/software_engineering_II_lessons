## Liskov Substitution

The Liskov Substitution Principle states that, in an object-oriented program, if we substitute a superclass object reference with an object of any of its subclasses, the program should not break.

This principle is applicable when there is a supertype-subtype inheritance relationship, either through class extension or interface implementation. We can think of the methods defined in the supertype as the definition of a contract. It is expected that each subtype adheres to this contract. If a subclass does not adhere to the contract of the superclass, it would be violating the Liskov Substitution.

### Bad example:

~~~java
public class Animal {
  public void fly() {
    System.out.println("I'm flying!");
  }
}

public class Bird extends Animal {
  public void fly() {
    System.out.println("I'm flying!");
  }
}

public class Fish extends Animal {
  public void fly() {
    //"Error: I can't fly!";
  }
}
~~~
In this example, the Animal class has a fly method, and the Bird and Fish classes inherit from it. However, this causes a problem in the Fish class since fish are animals but cannot fly.


### Good example:

~~~java
public abstract class Animal {
  public abstract void displacement();
}

public class Bird extends Animal {
  public void displacement() {
    System.out.println("I'm flying!");
  }
}

public class Fish extends Animal {
  public void displacement() {
    System.out.println("I'm swimming!");
  }
}

~~~
In this example, To solve this problem, one could consider creating an abstract class called Animal that contains an abstract method called desplazamiento instead of fly. This way, each subclass of Animal could implement its own displacement behavior, allowing for more flexible creation of new types of animals.


### Related principles

* [Separation of Concerns](../general/separationofconcerns.md)
* [Composition Over Inheritance](../general/compositionoverinheritance.md)


---
[Back to the list](./README.md)