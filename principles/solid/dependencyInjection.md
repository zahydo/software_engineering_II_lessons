## Dependency Injection
The principle of dependency inversion is an important principle in software design that states that high-level entities should depend on abstractions, rather than on concretizations or implementation details of low-level entities.

This principle holds that high-level entities, such as modules or classes, should not depend directly on low-level entities, but rather on abstractions that represent the essential and general concepts on which those entities are based.

By relying on abstractions instead of concretions, the modularity, flexibility and reusability of the code is improved. In addition, this facilitates the evolution of the system, since changes in low-level entities do not directly affect high-level entities.

### Bad example
~~~java
public class ServicioNotificacionEmail {
    public void sendEmailNotification(String message) {
        System.out.println("Email notification: " + message);
    }
}

public class ServicioNotificacionSMS {
    public void sendNotificationSMS(String message) {
        System.out.println("Notification by text message: " + message);
    }
}

public class Client {
    private ServicioNotificacionEmail servicioNotificacionEmail servicioNotificacionEmail;

    public Client(ServiceNotificationEmail serviceNotificationEmail service) {
        this.serviceNotificationEmail = serviceNotificationEmail;
    }

    public void makePurchase() {
        serviceNotificationEmail.sendNotificationEmail("Thank you for your purchase");
    }
}

public class Main {
    public static void main(String[] args) {
        ServicioNotificacionEmail servicioNotificacionEmail = new ServicioNotificacionEmail();
        Customer customer = new Customer(serviceNotificationEmail);
        client.checkout();
    }
}
~~~
the Client class depends directly on the ServiceNotificationEmail class instead of depending on an interface. This makes the code more coupled and less flexible. If in the future you want to change the notification service to ServicioNotificacionSMS, you would have to modify the Client class. This violates the Dependency Inversion principle, since the lower level class depends on the higher level class.

### Good example

~~~java
public interface IServiceNotification {
    void notify(String message);
}

public class ServicioNotificacionEmail implements IServicioNotificacion {
    public void notify(String message) {
        System.out.println("Email notification: " + message);
    }
}

public class ServicioNotificacionSMS implements IServicioNotificacion {
    public void notify(String message) {
        System.out.println("Notification by text message: " + message);
    }
}

public class Customer {
    private IServiceNotification serviceNotification service;

    public Client(IServiceNotification serviceNotification service) {
        this.serviceNotification = serviceNotification;
    }

    public void makePurchase() {
        serviceNotification.notify("Thank you for your purchase");
    }
}

public class Main {
    public static void main(String[] args) {
        IServiceNotification serviceNotificacion = new ServicioNotificacionEmail();
        Customer customer = new Customer(serviceNotification);
        client.checkout();
    }
}

~~~
The Client class depends on the IServiceNotification interface instead of a concrete implementation such as ServiceNotificationEmail or ServiceNotificationSMS. This allows decoupling the notification implementation and makes the Client class more flexible and easier to maintain. Also, in the "main" method you can change the implementation of IServiceNotification without affecting the Client class.
### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)