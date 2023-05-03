## Dependency Injection

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

```
In this example, the UserService class is tightly coupled to the UserRepository class. If the implementation of the UserRepository changes, the UserService class would also need to change.
### Good example

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

 

### Related patterns

- Separation of Concerns
- Composition Over Inheritance
- Code For The Maintainer
- Boy-Scout Rule


[Back to the list](./README.md)