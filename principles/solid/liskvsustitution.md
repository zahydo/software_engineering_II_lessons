## Liskov Substitution

[TODO]

### Bad example:
Supongamos que tenemos una clase `Coche` con un método `acelerar()` que aumenta la velocidad del coche en 10 km/h. A partir de esta clase, creamos una subclase llamada `CocheAutonomo` que tiene un método `acelerar()` que aumenta la velocidad del coche en 20 km/h y también realiza ciertas funcionalidades adicionales. Sin embargo, no deberíamos poder reemplazar una instancia de `Coche` con una instancia de `CocheAutonomo` en todas las situaciones, sin afectar el comportamiento del programa.
~~~java:
public class Coche {
    private int velocidad;

    public void acelerar() {
        velocidad += 10;
    }

    public int getVelocidad() {
        return velocidad;
    }
}

public class CocheAutonomo extends Coche {
    public void acelerar() {
        super.acelerar();
        super.acelerar();
        // otras funcionalidades adicionales para el coche autónomo
    }
}

public class Programa {
    public static void main(String[] args) {
        Coche coche = new Coche();
        CocheAutonomo cocheAutonomo = new CocheAutonomo();

        coche.acelerar();
        cocheAutonomo.acelerar();

        System.out.println("Velocidad del coche: " + coche.getVelocidad());
        System.out.println("Velocidad del coche autónomo: " + cocheAutonomo.getVelocidad());
    }
}
~~~
In this example, `DriverCar` is a subtype of `Car`, but you cannot replace an instance of `Car` with an instance of `DriverCar` in all situations without changing the behavior of the program. This violates the Liskov substitution principle.



### Good example:



### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)