## Dependency Injection

<<<<<<< HEAD
The dependency injection principle suggests that objects should receive dependencies from external sources instead of creating them internally, the problem that it solves is the tight coupling between objects and their dependencies, it does it by supplying its dependencies from an external source, the benefits of applying this are that the classes that receive those dependencies do not need to know how they are implemented, thus decoupling the interaction of them.

### Bad example

Suppose you have a UserService class that requires a UserRepository object to perform database operations. Instead of injecting the dependency, the UserService class creates the UserRepository object internally:
``` java
public class UserService {
	private UserRepository userRepository = new UserRepository();

	public void addUser(User user) {
		userRepository.save(user);
	}

	public User getUser(String email) {
		return userRepository.findByEmail(email);
	}
}
=======
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
>>>>>>> 6814cdd (Some changes added)

```
In this example, the UserService class is tightly coupled to the UserRepository class. If the implementation of the UserRepository changes, the UserService class would also need to change.
### Good example

<<<<<<< HEAD
To apply the Dependency Injection principle, you would inject the UserRepository dependency into the UserService class using an interface (we'll discuss why later):
``` java

public interface IUserRepository{
	boolean save(User user);
	User findByEmail(String email);

}
public class UserService {
	private IUserRepository userRepository;

	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public boolean addUser(User user) {
		return userRepository.save(user);
	}

	public User getUser(String email) {
		return userRepository.findByEmail(email);
	}
}

```

In this example, the `IUserRepository` dependency is passed in through the constructor of the `UserService` class. If the implementation of the class that implements `IUserRepository` changes, only the code of the class that implements `IUserRepository`  needs to be modified, using interfaces is a better option because you can do thigs like this:


``` java
	public class OracleUserRepository implements IUserRespository{
		@Override
		boolean save(User user){
			// Do Something with user and return something
		}

		@Override
		User findByEmail(String email){
			// Do something with email and return something
		}
	}

	public class MongoUserRepository implements IUserRespository{
		@Override
		boolean save(User user){
			// Do Something with user and return something
		}

		@Override
		User findByEmail(String email){
			// Do something with email and return something
		}
	}	

```
This allows you to easily inject an implementation of those databases as dependency of the `UserService` class, thus allowing you to write code without modifying the class itself.



### Related principles

- [Composition over inheritance](../general/compositionoverinheritance.md).

 
=======
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
>>>>>>> 6814cdd (Some changes added)

### Related patterns

- [Separation of Concerns](../general/separationofconcerns.md)
- [Composition Over Inheritance](../general/compositionoverinheritance.md)
- [Code For Mantainer](../general/codeformantainer.md)
- [Boy-Scout Rule](../general/boyscoutrule.md)


[Back to the list](./README.md)