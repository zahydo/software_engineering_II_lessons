## Dependency Injection

El principio de "Dependency Injection" es una tecnica utilizada para reducir las interdependencias entre objetos en un sistema donde nos permite que los objetos se creen e inicialicen de manera independiente de sus dependencias. No cumplir con el principio nos puede generar problemas en acoplamiento excesivo, dificultad para realizar pruebas unitarias, codigo dificil de mantener, etc. 

Para evitar estos problemas se sugiere que los objetos deben recibir dependencias de fuentes externas en lugar de crearlas internamente.

### Bad example

```
public class Cliente {
    private ServicioDeCorreo servicioDeCorreo;

    public Cliente() {
        this.servicioDeCorreo = new ServicioDeCorreo();
    }

    public void enviarCorreo(String asunto, String mensaje, String destinatario) {
        servicioDeCorreo.enviar(asunto, mensaje, destinatario);
    }
}
```
In this example, the Client class creates an instance of the MailService class in its constructor and uses it to send emails. This means that the Client class directly depends on the MailService class. The principle is not fulfilled because we are creating an instance within the same class and the dependency is not received externally.

### Good example

```
public class Client {
    private MailService mailService;

    public Client(MailService mailService) {
        this.mailService = mailService;
    }

    public void sendEmail(String subject, String message, String recipient) {
        mailService.send(subject, message, recipient);
    }
}
```
In this example, the Client class receives an instance of the MailService class through its constructor. Now, the dependency is being injected from the outside, which complies with the Dependency Injection principle and makes the code more modular and easier to maintain.

### Related principles

- [Composition over Inheritance](../general/compositionoverinheritance.md) 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)