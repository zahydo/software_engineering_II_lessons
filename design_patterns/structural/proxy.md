# Proxy pattern

The Proxy pattern is a structural design pattern that provides a much higher security layer or level of security in the communication between two classes.
A small example to understand the definition of this pattern is when we are going to make a transfer within some application, we have to think if we want to add certain business rules at the time of making a transfer or a layer of security is necessary. 
The proxy pattern will help to solve this and other problems, to be able to give solution to this type of cases it is necessary to analyze if the project needs more business rules or if we need a security layer and thus to be able to implement this pattern. 


An example of the Proxy pattern using Java code could be:


Suppose we have a library application and we want to restrict access to certain functions only to users with valid credentials. We could have a RealLibrary class that has methods for borrowing and returning books, but only allow access to those methods if the user is logged in. In this case, we can create a class BibliotecaProxy that has an instance of BibliotecaReal and a method prestarLibro that first checks if the user is logged in before calling the corresponding BibliotecaReal method. If the user is not logged in, the user will be prompted to log in first.


```Java
interface Library {
    void lendBook(String book);
    void returnBook(String book);
}

class LibraryReal implements Library {
    public void lendBook(String book) {
        // lógica para prestar el libro
    }
    public void returnBook(String libro) {
        // lógica para devolver el libro
    }
}

class LibraryProxy implements Library {
    private LibraryReal libraryReal;
    private String userCurrent;

    public LibraryProxy(LibraryReal libraryReal) {
        this.libraryReal = libraryReal;
    }

    public void lendBook(String book) {
        if (userCurrent != null) {
            libraryReal.lendBook(book);
        } else {
            System.out.println("Debe iniciar sesión antes de prestar un libro.");
        }
    }

    public void returnBook(String book) {
        if (userCurrent != null) {
            libraryReal.returnBook(book);
        } else {
            System.out.println("Debe iniciar sesión antes de devolver un libro.");
        }
    }

    public void login(String user, String password) {
        // lógica para verificar credenciales de usuario
        userCurrent = user;
    }
}
```

In this example the `Library` interface defines two methods, `lendBook` and `returnBook`, which represent the operations that can be performed on a library. The `LibraryReal` class is the actual implementation of the `Library` interface, this class contains the actual logic for lending and returning a book. The class `LibraryProxy` is a class that acts as a proxy for the `LibraryReal`. The proxy has a reference to the `LibraryReal` and can call the methods of the actual library. Before calling the methods of the `LibraryReal`, the proxy checks if the user is logged in. If the user is not logged in, the proxy displays an error message. The proxy also provides a `login` method for the user to log in before calling the real library methods.

```Java
Library library = new LibraryProxy(new LibraryReal());
library.login("William Diaz", "123456");
library.lendBook("El principito"); // esto funcionará
library.returnBook("El principito"); // esto también funcionará
library.lendBook("El mundo de Sofía"); // esto no funcionará sin iniciar sesión primero
```

In this example, `LibraryProxy` acts as a security layer that controls access to certain functions in `LibraryReal`. Access is only allowed if the user is logged in first.