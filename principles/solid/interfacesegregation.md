## Interface Segregation

[TODO]

### Bad example:


Suppose we have an interface `ICar` that has methods `accelerate()`, `brake()` and `turnLights()`. However, in a new update, it is required to add a new method called `navigateGPS()`, which is not necessary for all `IAutomovil` implementations. Instead of creating a new interface, this new method is added to the `IAutomovil` interface.
~~~java:
public interface IAutomovil {
    void acelerar();
    void frenar();
    void encenderLuces();
    void navegarGPS();
}

public class Automovil implements IAutomovil {
    public void acelerar() {
        // código para acelerar el automóvil
    }

    public void frenar() {
        // código para frenar el automóvil
    }

    public void encenderLuces() {
        // código para encender las luces del automóvil
    }

    public void navegarGPS() {
        // código para navegar por GPS (no es necesario en todos los automóviles)
    }
}

public class Camion implements IAutomovil {
    public void acelerar() {
        // código para acelerar el camión
    }

    public void frenar() {
        // código para frenar el camión
    }

    public void encenderLuces() {
        // código para encender las luces del camión
    }

    public void navegarGPS() {
        // código para navegar por GPS (no es necesario en todos los camiones)
    }
}
~~~
In this example, the `IAutomovil` interface has too many methods that not all implementations need. Also, implementations of `IAutomovil` must implement the `navigateGPS()` method, even if they don't need it, which violates the principle of interface segregation. This makes code reuse and maintainability difficult in the future.


### Good example:
Suppose we have an interface `IFood` that has a cooking method, `cook()`. However, it is later required to add a serving method, `serve()`, which not all classes that implement `IFood` need. Instead of adding `serve()` to `IFood`, it is best to create a separate interface called `IServe` with the `serve()` method and have classes that need the `serve()` method implement the interface `IServe`.
~~~java:
public interface IComida {
    void cocinar();
}

public interface IServir {
    void servir();
}

public class Hamburguesa implements IComida, IServir {
    public void cocinar() {
        // código para cocinar hamburguesa
    }

    public void servir() {
        // código para servir hamburguesa
    }
}

public class Ensalada implements IComida {
    public void cocinar() {
        // código para cocinar ensalada
    }
}
~~~
In this example, `IFood` only contains the `cook()` method, ensuring that no additional functions are required for your implementations. `IServe` contains the `serve()` method, which can be implemented by classes that need it, such as `Hamburger`.


### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)