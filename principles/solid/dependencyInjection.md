## Dependency Injection

Dependency Injection is a design pattern that consists of supplying dependencies to an object from the outside, rather than having the object create them internally. This allows for greater flexibility and facilitates code modularity.

### Bad Example

In this example, it shows a bad practice when creating a instance of the class EmailNotifier inside the constructor of the class Client, which causes the Client class depends on a specific implementation and makes it difficult to change it in the future without modifying the Client class.

```Java
public class Client {
    private INotifier notifier = new EmailNotifier();

    public void performAction() {
        notifier.notificate("Action performed.");
    }
}

public interface INotifier {
    void notificate(String message);
}

public class SMSNotifier implements INotifier {
    public void notificate(String message) {
        // Implementation of SMS notification
    }
}

public class EmailNotifier implements INotifier {
    public void notificate(String message) {
        // Implementation of email notification
    }
}
```

### Good example

In this example, the Client class depends on a implementation of the INotifier interface which is supplied through the constructor.
In this way, we can use different implementations of INotifier interface without having to modify the Client class.

```Java
public class Client {
    private INotifier notifier;

    public Client(INotifier notifier) {
        this.notifier = notifier;
    }

    public void performAction() {
        notifier.notificate("Action performed.");
    }
}

public interface INotifier {
    void notificate(String message);
}

public class SMSNotifier implements INotifier {
    public void notificate(String message) {
        // Implementation of SMS notification
    }
}

public class EmailNotifier implements INotifier {
     public void notificate(String message) {
        // Implementation of Email notification
    }
}
```

### Related principles

- [Separation of Concerns](../../principles/general/separationofconcerns.md)
- [Code For The Maintainer](../../principles/general/codeformantainer.md)
- [Boy-Scout Rule](../../principles/general/boyscoutrule.md)

### Related patterns

- Separation of Concerns
- DRY (Don't Repeat Yourself)
- Code For The Maintainer
- Composition Over Inheritance

---

[Back to the list](./README.md)
