## Dependency Injection

This principle establishes that the dependencies must be in the abstractions and 
not in the concretions, in other words, they ask us that the classes never depend 
on other classes and that all this relationship must be in an abstraction. This 
principle has two rules:
- High level modules should not depend on low level modules. This logic must be in an abstraction.
- Abstractions should not depend on details. Details should depend on abstractions.


### Bad example

In this example you can see that the rule is being broken, since the mail class 
depends on the service provider

```JAVA:
class Correo{
    provider;

    constructor(){
        this.provider= gmail.api.createService();
    }

    enviar(mensaje){
        this.provider.send(mensaje);
    }
    
    var correo= new Correo();
    correo.enviar('hola!');
}
```

### Good example

To fix this we need to remove that dependency and add it as an abstraction.

```JAVA:
class GmailProveedor{
    constructor(){
        this.provider= gmail.api.createService();
    }

    enviar(mensaje){
        this.provider.sendAsText(mensaje);
    }
}
    
class Correo{
    constructor(proveedor){
        this.proveedor= proveedor;
    }

    enviar(mensaje){
        this.proveedor.send(mensaje);
    }
    
    var gmail= new GmailProveedor();
    var correo= new Correo(gmail);
    correo.enviar('hola!');
}
```

This way we no longer care about the provider or how the provider 
implements mailing, the Mail class only does one thing, asking the provider 
to send a mail.

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)