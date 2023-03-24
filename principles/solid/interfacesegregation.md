## Interface Segregation

The principle of "Interface Segregation" tells us that interfaces should be specific and focused on the needs of individual customers, instead of having to try to cover every possible use case in the same. When we fail to comply with this principle we can generate problems of excessive coupling, duplicate code or difficulty to test and all this due to having unnecessary functionalities and the best thing is to separate in specific interfaces.

### Bad example:

```
public interface Animal {
    void eat();
    void sleep();
    void fly();
    void swim();
}
```
In this example, the Animal interface contains the fly() and swim() methods, but not all animals can fly or swim. If a Cat class implements the Animal interface, then the fly() and swim() method implementation would be useless and redundant. This can lead to problems of excessive coupling and code duplication in the implementation of the Cat class.

### Good example:

```
public interface IAnimal {
    void eat();
    void sleep();
}

public interface IFlyingAnimal {
    void fly();
}

public interface ISwimmingAnimal {
    void swim();
}

public class Cat implements IAnimal {
    public void eat() {
        // implementación
    }
    public void sleep() {
        // implementación
    }
}
```
In this way, the principle of Interface Segregation can be fulfilled, and each class implements only the interfaces it needs, avoiding code duplication and excessive coupling.

### Related principles

- [Separation of Concerns](../general/separationofconcerns.md)

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)