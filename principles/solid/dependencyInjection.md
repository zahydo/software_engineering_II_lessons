## Dependency Injection

is a programming principle that states that objects should not create their own dependencies, but rather they should be provided by other objects through constructor arguments or specific methods. In summary, instead of an object building and controlling all of its dependencies internally, it is expected that the dependencies be "injected" from outside for greater flexibility and maintainability of the code.

### Bad example

    const char* MESSAGE = "Hola mundo";
    void print_message() {
        printf("%s\n", MESSAGE);
    }

### Good example

    void print_message(const char* message) {
        printf("%s\n", message);
    }   

### Related principles

---Dependency inversion principle
---Single responsibility principle
---Liskov substitution principle

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)