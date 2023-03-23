## Dependency Injection

The dependency injection principle suggests that objects should receive dependencies from external sources instead of creating them internally. 
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

To apply the Dependency Injection principle, you would inject the UserRepository dependency into the UserService class:
``` java
public class UserService {
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public User getUser(String email) {
		return userRepository.findByEmail(email);
	}
}

```

In this example, the `UserRepository` dependency is passed in through the constructor of the `UserService` class. If the implementation of the `UserRepository` changes, only the code that creates the `UserRepository` object needs to be modified.


### Related principles

- [Composition over inheritance](../general/compositionoverinheritance.md).

 

### Related patterns

- [Pattern names]


[Back to the list](./README.md)