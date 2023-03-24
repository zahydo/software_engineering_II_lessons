# Dependency Injection

Dependency Injection is a software design pattern in which an object's dependencies are provided to it by an external entity, rather than the object itself creating or managing those dependencies. In other words, instead of an object creating its own dependencies or tightly coupling itself to other objects, those dependencies are "injected" into the object by another component, often referred to as an "injector" or "container".

This approach promotes loose coupling between components and makes it easier to modify, replace or test individual components in isolation without affecting the rest of the system. Dependency Injection is commonly used in modern software development, especially in frameworks such as Spring, Angular, and others.

### Bad example

Suppose we have an Order class that needs to send email notifications to the user and the support team when an order is placed. Instead of injecting an EmailService instance, we create an instance inside the Order class
```
public class Order {
   private EmailService emailService = new EmailService();
   
   public void placeOrder() {
      // logica del pedido
      emailService.sendEmail(userEmail, "Order Confirmation");
      emailService.sendEmail(supportEmail, "New Order Received");
   }
}

```
### Good example

Suppose we have an Order class that needs to send email notifications to the user and the support team when an order is placed. Instead of instantiating the EmailService class inside the Order class, we can inject an EmailService instance via a constructor:

```
public class Order {
   private EmailService emailService;
   
   public Order(EmailService emailService) {
      this.emailService = emailService;
   }
   
   public void placeOrder() {
      // logica del pedido
      emailService.sendEmail(userEmail, "Order Confirmation");
      emailService.sendEmail(supportEmail, "New Order Received");
   }
}
```

### Related principles

- Interface Segregation

### Related patterns

- Boy-Scout Rule
- Code For The Maintainer
- Composition Over Inheritance
- Separation of Concerns

---
[Back to the list](./README.md)