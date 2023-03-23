## Single Responsibility

One class, one responsibility. This is because you lose the independence of each object, it means that you will have a cascading effect every time you are going to change an object within the class. Therefore it is better to leave each class independent with its respective responsibility.

### Bad example:

In an application, a class that handles login logic is also in charge of user data validation. This makes the class have more than one responsibility.

```Java
public class LoginUser {
    public void login(String username, String password) {
        // iniciar sesión
        // validar usuario
    }
}
```

### Good example:

The login class should have only the responsibility of handling user login, while user data validation should be moved to a separate class.

```Java
public class LoginUser {
    public void login(String username, String password) {
        //iniciar sesión
    }
}

public class ValidateUser {
    public boolean validate(String username, String password) {
        //validar usuario
    }
}
```

### Related principles

- [Separation of Concerns](~/principles/general/separationofconcerns.md)
- [KISS](~/principles/general/kiss.md)
- [Do the Simplest Thing That Could Possibly Work](~/principles/general/dothesimplestthing.md)

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)