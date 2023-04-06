# Builder pattern

The "Builder" design pattern solves the problem of creating complex objects with multiple parts that must be built in a specific order. The pattern allows building objects step by step, which facilitates the construction of complex objects without having to provide a large number of arguments to a constructor.

The "Builder" pattern is implemented by creating a "Builder" class that contains the methods needed to build the complex object. These methods define each part of the object and are used to set the values of the attributes. In addition, the "Builder" class can also include methods that validate the set values and ensure the consistency of the constructed object.

The "Builder" class can be complemented by a "Director" class that uses the methods of the "Builder" class to construct the complex object. The "Director" is responsible for the construction sequence and uses the methods of the "Builder" class to set the values of the attributes. This allows the creation of complex objects in a more flexible and structured way.

## Example

![ClassDiagram](../creational/classDiagrams/)

A real example of implementation of the "Builder" pattern in Java could be the construction of a "User" object for an authentication system. The "User" object is complex and has many attributes, such as first name, last name, email, password, date of birth, among others. Using the "Builder" pattern, we can create a constructor that receives each of the attributes and sets them in the "User" object incrementally.

First, we create the class "User", which is the class we want to build:
```java
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthdate;

    public User(String firstName, String lastName, String email, String password, LocalDate birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }

    // getters and setters
}
```
Then, we create the "UserBuilder" class, which is in charge of building the "User" object:
```java
public class UserBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthdate;

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public User build() {
        return new User(firstName, lastName, email, password, birthdate);
    }
}
```
Finally, we can use the "UserBuilder" class to build a "User" object with different combinations of attributes:
```java
User user1 = new UserBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("johndoe@example.com")
                .setPassword("password123")
                .setBirthdate(LocalDate.of(1990, 1, 1))
                .build();

User user2 = new UserBuilder()
                .setFirstName("Jane")
                .setLastName("Doe")
                .setEmail("janedoe@example.com")
                .setPassword("password456")
                .setBirthdate(LocalDate.of(1995, 5, 5))
                .build();
```
In this example, we can see how the "UserBuilder" class is in charge of building the "User" object in a gradual and flexible way, allowing the creation of objects with different combinations of attributes. In addition, the "UserBuilder" class can also include methods to validate the attribute values and ensure that the constructed object is consistent.