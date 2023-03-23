## Interface Segregation

If an interface grows too much it loses its objective and violates the first principle (SRP). This principle goes hand in hand with "Divide and conquer", because if an interface is growing, it is necessary to rethink its objective, divide, organize and group the methods again. 

### Bad example:

In an application, an interface that defines methods for saving and loading data also includes a method for sending e-mails. If a client only needs the methods for saving and loading data, it is forced to implement the method for sending e-mails.

```Java
public interface DataManager {
    void saveData(Object data);
    void loadData();
    void sendEmail(String receiver, String message);
}

public class MyClient implements DataManager {
    @Override
    public void saveData(Object data) {
        // Guardar datos
    }

    @Override
    public void loadData() {
        // Cargar datos
    }

    @Override
    public void sendEmail(String receiver, String message) {
        // Enviar correo electrónico
    }
}
```

### Good example:

Interfaces can be divided into two: one for saving and loading data and one for sending e-mails. In this way, clients only implement the interfaces they need.

```Java
public interface DataSaver {
    void saveData(Object data);
    void loadData();
}

public interface EmailSender {
    void sendEmail(String receiver, String message);
}

public class MyClient implements DataSaver {
    @Override
    public void saveData(Object data) {
        // Guardar datos
    }

    @Override
    public void loadData() {
        // Cargar datos
    }
}

```

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)