# Singleton pattern

The Singleton pattern is a creational design pattern that is a single instance for an entire application and provides a global access point to this instance.
A small example to understand a little more this design pattern is when a single instance of something is needed, it can be when a user makes login, the application already has this data of the user at the moment of making login, this data could be needed in several flows of the screens, if the case is not made use of this pattern it would be necessary to instantiate by each flow of screen where this information of the user is needed and it would be very expensive the processing of this. To give solution to this is to create a Singleton that we can access to that single instance and this makes that the information provided by the user is the same for all the flows. 
In this pattern it must be taken into account that the data must be the most important and the most used in the application. 
The benefits of this pattern are:
- There will be a single instance: which means that we do not have to create a different instance every time we need the data. 
- It can be accessed from anywhere: as mentioned above this instance is global so it can be accessed from anywhere in the app.

# Class Diagram of example:

![ClassDiagram](http://www.plantuml.com/plantuml/png/RO-noiCm38JtF8L6Xv__1JAbb0vTkfG-W8X5CDWgI4gNqdTlcheu66ky--uuZMeejgJOJH5LuRY84DjDIU3PmNh_m9XeWAj9u3bBb334IaFlXLGhDR0QyaJ3ldhp_c0cEsVRzIr0oIwOoEqNhE3Z7dofs8Z-PvVawRFHbQMDR6OQuSFt6LSzLHKKhbIykf7OBoc-0G00)

# Example

An example of the Proxy pattern using Java code could be:

Suppose we have an online shopping application that requires users to login in order to make purchases and access their personal data. In this case, we can create a Singleton class called CurrentUser that has the data of the logged-in user. This class can have methods to set and get the user's data, such as their name, email, address, and so on. In this way, in different parts of the application we can get the instance of CurrentUser and access the logged-in user's data without having to create a new instance every time we need this data. In addition, being a single global instance, we can ensure that the user data is consistent and up-to-date in all parts of the application.

```Java
public class CurrentUser {
    private static CurrentUser instance = null;
    private String name;
    private String email;
    private String address;

    // Private constructor ensures that no instances of CurrentUser can be created from outside the class
    private CurrentUser() {}

    // Method to get the single instance of CurrentUser.
    public static CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser();
        }
        return instance;
    }

    // Methods to set and get the user's data.
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
```

In this example, the `CurrentUser` class has a private constructor, which means that instances of it cannot be created from outside the class. Instead, the static method `getInstance()` is used to get the single instance of `CurrentUser`. Within this method, it checks if an instance already exists and, if not, a new instance is created and returned. The class also has methods to set and get the user's data, such as name, email and address. These methods can be used in different parts of the application to access the current user's data without having to create a new instance of the class each time.

[Back](../creational/README.md)