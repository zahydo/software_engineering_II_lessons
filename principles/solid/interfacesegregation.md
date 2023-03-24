## Interface Segregation
The interface segregation principle states that it is important to avoid forcing clients to implement or depend on interfaces they do not use. If a client is forced to use an interface that it does not fully use, it may be affected by changes to that interface that other clients do use. This unnecessary coupling between clients can be avoided by splitting the interfaces into smaller, more specific interfaces.

Therefore, it is important to ensure that interfaces are as specific as possible to prevent clients from being affected by changes to functionality that they do not use. An example of this would be if a class implements an interface with multiple methods, but a client only uses one of them. If the other clients need changes to unused methods, the client that only uses one method will also be affected. To avoid this, you should separate the interfaces into smaller, more specific interfaces, so that each client only depends on what it needs.

### Bad example:
~~~java
public interface PetOwnerInterface {
  void feed();
  void bathe();
  void play();
  void takeToVet();
}

public class PetOwner implements PetOwnerInterface {
  @Override
  public void feed() {
    System.out.println("Pet is being fed.");
  }
  
  @Override
  public void bathe() {
    System.out.println("The pet is being bathed.");
  }
  
  @Override
  public void play() {
    System.out.println("The pet is being played with.");
  }
  
  @Override
  public void takeAlVeterinarian() {
    System.out.println("The pet is being taken to the vet.");
  }
  
}
~~~
In this example, the interface "PetOwnerInterface" includes the necessary methods for the management of both pets and owners. The class "PetOwner" implements this interface and all the methods including those that are specific to owners. We can see that the principle of interface segregation is not fulfilled since the interface includes methods that are not relevant for pet management and that should only be implemented by the class that manages owners.

### Good example:

Each interface includes only the necessary methods for the specific management it represents, and the classes Pet and Owner implement only the interface they need. This avoids the inclusion of irrelevant methods for each management, and complies with the SOLID principle of interface segregation.
~~~java

public interface PetInterface {
  void feed();
  void bathe();
  void play();
}

public interface OwnerInterface {
  void takeToVet();
}

public class Mascota implements MascotaInterface {
  @Override
  public void feed() {
    System.out.println("Pet is being fed.");
  }
  
  @Override
  public void bathe() {
    System.out.println("The pet is being bathed.");
  }
  
  @Override
  public void play() {
    System.out.println("The pet is being played with.");
  }
  
 
}

public class Owner implements OwnerInterface {
  @Override
  public void takeAlVeterinarian() {
    System.out.println("The pet is being taken to the vet.");
  }
  
  
}
~~~
### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)