## Dependency Injection

is a programming principle that states that objects should not create their own dependencies, but rather they should be provided by other objects through constructor arguments or specific methods. In summary, instead of an object building and controlling all of its dependencies internally, it is expected that the dependencies be "injected" from outside for greater flexibility and maintainability of the code.

### Bad example

    public class Main {
    static final String MESSAGE = "Hola mundo";
    
    public static void main(String[] args) {
        printMessage();
    }
    
    static void printMessage() {
        System.out.println(MESSAGE);
    }
}

### Good example

  public class Main {
    public static void main(String[] args) {
        String message = "Hola mundo";
        printMessage(message);
    }
    
    static void printMessage(String message) {
        System.out.println(message);
    }
}

### Related principles

- Dependency inversion principle
- Single responsibility principle
- Liskov substitution principle



---
[Back to the list](./README.md)