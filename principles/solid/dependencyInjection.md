## Dependency Injection

In object-oriented programming, a class may rely on objects of other classes. A dependency injection is a strategy that is used to separate the creation of dependency objects from the class that needs them.

To help you understand, the following code snippet shows no dependency injection:

### Bad example

```java
class Question {
    private Answer answer;

    public Question(){
      answer = new Answer();
    }
}
```

*Dependency Injection not implemented since Question is responsible for the creation of Answer.*

As opposed to this, the following shows a dependency injection:

### Good example

```java
class Question {
    private Answer answer;

    public Question(Answer ans){
      this.answer = ans;
    }
}
```

*Dependency injection implemented since Question does not have to worry about the creation of Answer.*

There are three different types of dependency injections:

### Constructor injection
Constructor injection is shown in the first code example. The dependent class receives the object it requires as a parameter of the constructor.

### Setter injection
The dependent class has a public setter method through which the dependency is injected. An example is given in the code below:

```java
class Building {
    private Room room;

    public setRoom(Room room){
        this.room = room;
    }
}
```

### Interface injection
An interface provides an injector method that is responsible for injecting the dependency to any class that may require it. The client class has to implement the interface and override the injector method. For example

```java
public interface Injector {
  public void injectDependency(Dependency object);
}

public class Client implements Injector {
  private Dependency dependentObject;

  @Override
  public void injectDependency(Dependency object){
    this.dependentObject = object;
  }
}
```

### Related principles

- [Interface Segregation](./interfacesegregation.md)
- [Open/Closed](./openclosed.md)

### Related patterns

- [Separation of Concerns](../general/separationofconcerns.md)
- [Composition Over Inheritance](../general/compositionoverinheritance.md)
- [Code For Mantainer](../general/codeformantainer.md)
- [Boy-Scout Rule](../general/boyscoutrule.md)

---
[Back to the list](./README.md)