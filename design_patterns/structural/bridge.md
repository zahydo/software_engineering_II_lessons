# Bridge

The Bridge design pattern is used to decouple an abstraction from its implementation, so that both can vary independently without affecting the other. In other words, this pattern allows separating the user interface from the underlying implementation so that both can evolve separately.

The Bridge pattern consists of two main parts: the abstraction and the implementation. The abstraction defines the user interface, while the implementation provides the underlying implementation. Both parts are separated by a common interface, which is used to connect and communicate them.

Instead of having a class that combines abstraction and implementation into a single entity, the Bridge pattern suggests dividing them into two separate hierarchies. This way, any combination of abstraction and implementation can be achieved by connecting any implementation with any abstraction. This makes the code more flexible and easier to maintain, as any of the two parts can be changed without affecting the other.

A common example of using the Bridge pattern is in operating systems, where the user interface (abstraction) is separated from device drivers (implementation). This way, different types of devices can be used by the user interface without changing the user interface code.

The creation of a program that allows sending different types of messages (for example, email, text message, voice message) from a mobile device.

Instead of creating separate classes for each message type and mobile device, we can use the Bridge pattern. We can define an "Message" interface with an "send" method and a "Device" interface with a "connect" method. Then, we can create concrete classes for each message type and mobile device and have them implement the respective interfaces.

Finally, we can create a "MessageBridge" class that accepts both a message and a mobile device, and calls the "send" and "connect" methods respectively, using the concrete objects. This way, we can send different types of messages from any mobile device, without having to create separate classes for each message-device combination.

## Class Diagram of example:

![ClassDiagram](http://www.plantuml.com/plantuml/png/fPB1wW8X4CRlFeN7_v_O5-Yqr7RSMtGNdM92dKLDekZTMzY6PY689I-AyttVRvHfSp6fN89N60kaex6WUuZPd47VbHxN2c95a_x-rxeIElLGGjfX7YXZmKeijnJ1bhd1UfEptb9AG3i_bXD5jAGn31u2n9A_G3c3PHtiuLf-2ZZGRRbTFhYdYbv6BFaCvcqIkXDJ6suYJFjqAMFT-opxVFa4PHvFJSF03nK1K2r4Dqx34m00)

# Example

```java
// Interfaz para los mensajes
interface Mensaje {
void enviar();
}

// Clase abstracta para los dispositivos móviles
abstract class Dispositivo {
protected Mensaje mensaje;

csharp
Copy code
public Dispositivo(Mensaje mensaje) {
    this.mensaje = mensaje;
}

public abstract void conectar();
}

// Clase concreta para el dispositivo móvil "Teléfono"
class Telefono extends Dispositivo {
public Telefono(Mensaje mensaje) {
super(mensaje);
}

csharp
Copy code
public void conectar() {
    System.out.println("Conectando el teléfono...");
}
}

// Clase concreta para el dispositivo móvil "Tablet"
class Tablet extends Dispositivo {
public Tablet(Mensaje mensaje) {
super(mensaje);
}

csharp
Copy code
public void conectar() {
    System.out.println("Conectando la tablet...");
}
}

// Clase concreta para el tipo de mensaje "Correo electrónico"
class CorreoElectronico implements Mensaje {
public void enviar() {
System.out.println("Enviando correo electrónico...");
}
}

// Clase concreta para el tipo de mensaje "Mensaje de texto"
class MensajeDeTexto implements Mensaje {
public void enviar() {
System.out.println("Enviando mensaje de texto...");
}
}

// Clase concreta para el tipo de mensaje "Mensaje de voz"
class MensajeDeVoz implements Mensaje {
public void enviar() {
System.out.println("Enviando mensaje de voz...");
}
}

// Clase que actúa como puente entre el mensaje y el dispositivo móvil
class MensajeBridge {
private Mensaje mensaje;
private Dispositivo dispositivo;

csharp
Copy code
public MensajeBridge(Mensaje mensaje, Dispositivo dispositivo) {
    this.mensaje = mensaje;
    this.dispositivo = dispositivo;
}

public void enviarMensaje() {
    dispositivo.conectar();
    mensaje.enviar();
}
}

// Clase principal para probar el programa
public class Main {
public static void main(String[] args) {
Mensaje mensaje1 = new CorreoElectronico();
Mensaje mensaje2 = new MensajeDeTexto();
Mensaje mensaje3 = new MensajeDeVoz();

scss
Copy code
    Dispositivo telefono = new Telefono(mensaje1);
    Dispositivo tablet = new Tablet(mensaje2);

    MensajeBridge bridge1 = new MensajeBridge(mensaje1, telefono);
    MensajeBridge bridge2 = new MensajeBridge(mensaje2, telefono);
    MensajeBridge bridge3 = new MensajeBridge(mensaje3, tablet);

    bridge1.enviarMensaje();
    bridge2.enviarMensaje();
    bridge3.enviarMensaje();
}
}
```
[Back](../structural/README.md)