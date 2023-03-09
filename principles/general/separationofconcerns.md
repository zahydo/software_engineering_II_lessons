## Separation of Concerns

The principle of "Separation of Concerns" encourages developers to divide their code into smaller, more focused units of functionality, where each unit has a single responsibility or concern. By separating concerns, the code becomes easier to understand, test, and modify, and reduces the risk of introducing bugs or errors.

### Bad example

```
public class UserController {
    public void createUser(String username, String password) {
        // Create user in database
    }

    public void deleteUser(String username) {
        // Delete user from database
    }

    public void updateUser(String username, String password) {
        // Update user in database
    }

    public void getUser(String username) {
        // Get user from database
    }
}
```

This code violates the "Separation of Concerns" principle by combining multiple responsibilities in a single class. The UserController class is responsible for handling HTTP requests, but it also contains logic for creating, updating, deleting, and retrieving users from the database. This makes the code more difficult to understand, test, and modify, and increases the risk of introducing bugs or errors.

### Good example:

```
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(String username, String password) {
        User user = new User(username, password);
        userService.createUser(user);
    }

    public void deleteUser(String username) {
        userService.deleteUser(username);
    }
}

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            userRepository.delete(user);
        }
    }
}

public class UserRepository {
    public void save(User user) {
        // Save user to database
    }

    public void delete(User user) {
        // Delete user from database
    }

    public User findByUsername(String username) {
        // Find user by username in database
        return null;
    }
}

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
```

In this example, the code is organized according to the "Separation of Concerns" principle, which means that each class has a single responsibility or concern. The UserController class is responsible for handling HTTP requests related to user management, while the UserService class is responsible for business logic related to user management, and the UserRepository class is responsible for database interactions related to user management. By separating these concerns, the code is easier to understand, test, and modify.

In the good example, the UserController, UserService, UserRepository, and User classes each have a single responsibility related to user management, and are loosely coupled through dependencies. This makes it easier to modify or replace any individual component without affecting the others.

In the bad example, the UserController class violates the principle by combining multiple responsibilities into a single class, which makes the code more difficult to understand, test, and modify. To apply the "Separation of Concerns" principle, you should identify the different responsibilities in your code and create separate classes or components to handle each one.





[Back to the list](./README.md)