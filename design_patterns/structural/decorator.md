# Decorator pattern

The Decorator pattern is a structural design pattern that allows behavior to be added to an individual object, either statically or dynamically, without affecting the behavior of other objects from the same class.

The pattern involves a set of decorator classes that are used to wrap concrete components. The decorator classes have the same interface as the components they wrap, so that the client can interact with the object in the same way as before. However, the decorator adds its own behavior before or after the method call to the wrapped object.

The Decorator pattern is useful when you want to add responsibilities to individual objects dynamically and transparently, without affecting other objects. It is also useful when you have a lot of similar objects that differ only in the way they handle some specific behavior.

An example of the Decorator pattern using Java code could be:

```java
// Component interface
public interface Pizza {
    public String getDescription();
    public double getCost();
}

// Concrete component
public class Margherita implements Pizza {
    public String getDescription() {
        return "Margherita";
    }

    public double getCost() {
        return 5.99;
    }
}

// Decorator
public abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription();
    }

    public double getCost() {
        return pizza.getCost();
    }
}

// Concrete decorator
public class Pepperoni extends ToppingDecorator {
    public Pepperoni(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", pepperoni";
    }

    public double getCost() {
        return pizza.getCost() + 1.5;
    }
}
```

In this example, we have a Pizza interface that defines the basic methods for a pizza. The Margherita class implements this interface as a concrete component. We also have a ToppingDecorator abstract class that also implements the Pizza interface, and a concrete decorator class, Pepperoni, which extends ToppingDecorator and adds the behavior of adding pepperoni to the pizza.

Now, the client can create a pizza object and wrap it with the decorator classes dynamically to add new behavior, without affecting the behavior of other pizza objects. For example:

```java
Pizza pizza = new Margherita(); // create a Margherita pizza
pizza = new Pepperoni(pizza); // add pepperoni to the pizza dynamically
```

This creates a Margherita pizza object and wraps it with a Pepperoni decorator, adding the behavior of adding pepperoni to the pizza.

## Workshop

Suppose you have a UserController class that handles user authentication and authorization for a web application. The UserController has a method called authenticateUser() that takes a username and password as input and returns a JWT token if the user is authenticated.

To add additional behavior to the authenticateUser() method, you can use the Decorator pattern. For example, suppose you want to log each authentication attempt to a log file. You can create a LoggingDecorator class that wraps the UserController and adds logging behavior to the authenticateUser() method.

Here's an example implementation:

```java
// Component interface
public interface UserController {
    public String authenticateUser(String username, String password);
}

// Concrete component
public class BasicUserController implements UserController {
    public String authenticateUser(String username, String password) {
        // Authenticate the user and return a JWT token
        // ...
    }
}

// Decorator
public abstract class UserControllerDecorator implements UserController {
    protected UserController userController;

    public UserControllerDecorator(UserController userController) {
        this.userController = userController;
    }

    public String authenticateUser(String username, String password) {
        return userController.authenticateUser(username, password);
    }
}

// Concrete decorator
public class LoggingDecorator extends UserControllerDecorator {
    public LoggingDecorator(UserController userController) {
        super(userController);
    }

    public String authenticateUser(String username, String password) {
        // Log the authentication attempt to a file
        logToFile("User " + username + " is attempting to authenticate.");

        // Call the wrapped object to authenticate the user
        String token = userController.authenticateUser(username, password);

        // Log the result of the authentication attempt to a file
        logToFile("Authentication attempt for user " + username + " " + 
            (token != null ? "succeeded." : "failed."));

        // Return the JWT token
        return token;
    }

    private void logToFile(String message) {
        // Log the message to a file
        // ...
    }
}
```

In this example, we have a UserController interface that defines the basic methods for user authentication. The BasicUserController class implements this interface as a concrete component. We also have a UserControllerDecorator abstract class that also implements the UserController interface, and a concrete decorator class, LoggingDecorator, which extends UserControllerDecorator and adds the behavior of logging authentication attempts to a file.

Now, you can create a UserController object and wrap it with the decorator classes dynamically to add new behavior, without affecting the behavior of other UserController objects. For example:

```java
UserController basicUserController = new BasicUserController(); // create a basic user controller
UserController loggingUserController = new LoggingDecorator(basicUserController); // add logging behavior to the user controller
```

This creates a BasicUserController object and wraps it with a LoggingDecorator, adding the behavior of logging authentication attempts to a file. Now, when you call the authenticateUser() method on the loggingUserController object, it will first log the authentication attempt to a file before calling the wrapped object to authenticate the user.