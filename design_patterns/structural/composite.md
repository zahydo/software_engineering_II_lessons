# Composite

The Composite pattern is used to build complex objects from other simpler and similar objects, thanks to recursive composition and a tree structure.
This simplifies the treatment of the objects created, since they all have a common interface and are treated in the same way. Depending on the implementation, procedures can be applied to the whole or one of the parts of the composite structure as if it were a final node, even if that part is itself composed of many others.

An example:
It is desired to implement a system to model a menu of options in an application. The menu will have simple options and compound options containing other options, forming a tree structure. Each option will have a name and a method to perform an action associated with it.

To implement this menu, the composite pattern in Java will be used. A "Component" class will be created to represent both simple and compound options. This class will have the following methods:

add(Component Component): This method will allow adding a component as a child of another component.
remove(Component component): This method will allow to remove a component as a child of another component.
getChild(int index): This method will allow to get a child component from its index.
getName(): This method will allow to obtain the name of the component.
performAction(): This method will allow performing the action associated to the option.
In addition, the following classes will be used:

SimpleOption" class: It will represent a simple option within the menu. This class will extend the "Component" class and will implement the specific methods of a simple option.
Class "CompoundOption": It will represent a compound option within the menu. This class will also extend the "Component" class and will implement the specific methods of a compound option.


```java
// Clase Componente
public abstract class Componente {
    private String nombre;

    public Componente(String nombre) {
        this.nombre = nombre;
    }

    public abstract void agregar(Componente componente);
    public abstract void remover(Componente componente);
    public abstract Componente getChild(int index);
    public abstract void realizarAccion();

    public String getNombre() {
        return nombre;
    }
}

// Clase OpcionSimple
public class OpcionSimple extends Componente {
    public OpcionSimple(String nombre) {
        super(nombre);
    }

    @Override
    public void agregar(Componente componente) {
        // Las opciones simples no pueden tener hijos, por lo que no se implementa este método
    }

    @Override
    public void remover(Componente componente) {
        // Las opciones simples no pueden tener hijos, por lo que no se implementa este método
    }

    @Override
    public Componente getChild(int index) {
        // Las opciones simples no pueden tener hijos, por lo que no se implementa este método
        return null;
    }

    @Override
    public void realizarAccion() {
        // Realizar acción asociada a la opción simple
        System.out.println("Se realizó la acción asociada a la opción simple " + getNombre());
    }
}

// Clase OpcionCompuesta
public class OpcionCompuesta extends Componente {
    private List<Componente> opciones;

    public OpcionCompuesta(String nombre) {
        super(nombre);
        opciones = new ArrayList<>();
    }

    @Override
    public void agregar(Componente componente) {
        opciones.add(componente);
    }

    @Override
    public void remover(Componente componente) {
        opciones.remove(componente);
    }

    @Override
    public Componente getChild(int index) {
        return opciones.get(index);
    }

    @Override
    public void realizarAccion() {
        // Realizar acción asociada a la opción compuesta
        System.out.println("Se realizó la acción asociada a la opción compuesta " + getNombre());

        // Realizar acción en cada una de las opciones hijas
        for (Componente opcion : opciones) {
            opcion.realizarAccion();
        }
    }
}

// Uso del patrón compuesto
public class Menu {
    public static void main(String[] args) {
        // Crear opciones simples
        OpcionSimple opcion1 = new OpcionSimple("Opción 1");
        OpcionSimple opcion2 = new OpcionSimple("Opción 2");

        // Crear opciones compuestas
        OpcionCompuesta opcion3 = new OpcionCompuesta("Opción 3");
        OpcionCompuesta opcion4 = new OpcionCompuesta("Opción 4");

        // Agregar opciones a la opción compuesta 3
        opcion3.agregar(opcion1);
        opcion3.agregar(opcion2);

        // Agregar opciones a la opción compuesta 4
        opcion4.agregar(opcion3);

        // Realizar acción en la opción compuesta 4
        opcion4.realizarAccion();
    }
}
```




# Diagrama Composite

![Diagrama Composite](DiagramaCompositePattern.png)