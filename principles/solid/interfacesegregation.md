## Interface Segregation

Is a software engineering principle that states that no client should be forced to depend on methods it does not use. It suggests that a class or module should have only one responsibility and that the methods it exposes should be relevant to that responsibility. This principle helps to reduce the complexity of the code, improve maintainability, and facilitate reusability by ensuring that interfaces are focused and cohesive.

### Bad example:

```
public interface Trabajo {
    void codificar();
    void testear();
    void documentar();
}

public class Programador implements Trabajo {
    public void codificar() {
        // Implementación del método
    }
    public void testear() {
        // Implementación del método
    }
    public void documentar() {
        // Implementación del método
    }
}

public class Tester implements Trabajo {
    public void codificar() {
        // Implementación del método
    }
    public void testear() {
        // Implementación del método
    }
    public void documentar() {
        // Implementación del método
    }
}

public class GerenteProyecto {
    public void asignarTrabajo(Programador programador) {
        programador.codificar();
        programador.testear();
        programador.documentar();
    }
    
    public void asignarTrabajo(Tester tester) {
        tester.codificar();
        tester.testear();
        tester.documentar();
    }
}
```
In this example, the Trabajo interface has three methods: codificar(), testear(), and documentar(). The Programador class and the Tester class implement this interface and provide an implementation for each of the methods.

The problem is that the documentar() method is not relevant for the Tester class, as testers generally do not document code. However, because the Trabajo interface requires that all classes implementing it provide an implementation for this method, the Tester class must implement it, resulting in unnecessary and possibly confusing code.

In addition, the GerenteProyecto class has two asignarTrabajo() methods, one for the Programador class and one for the Tester class, but both methods call the same three methods of the Trabajo interface, which can result in a lack of coherence and flexibility in task assignment.

Overall, this example violates the Interface Segregation Principle by making the Trabajo interface too general and not specific to the needs of each class that implements it. This leads to unnecessary code overhead and a lack of coherence in implementation.

### Good example:

```

```

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)