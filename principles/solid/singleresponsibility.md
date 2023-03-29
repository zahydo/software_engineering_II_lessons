## Single Responsibility

[TODO]

### Bad example:

Suppose we have a class `Employee` with the responsibility of storing an employee's personal information and calculating their salary. However, it also contains methods for sending emails and managing your work schedule.
~~~java:

public class Empleado {
    private String nombre;
    private String apellido;
    private String correo;
    private double salario;
    // otros atributos

    public Empleado(String nombre, String apellido, String correo, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.salario = salario;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public double calcularSalario() {
        // código para calcular salario
        return salario;
    }

    public void enviarCorreo(String asunto, String mensaje) {
        // código para enviar correo electrónico
    }

    public void administrarHorario(Date fechaInicio, Date fechaFin) {
        // código para administrar el horario de trabajo
    }
}

public class Programa {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Juan", "Pérez", "juan.perez@gmail.com", 1500.0);

        empleado.calcularSalario();
        empleado.enviarCorreo("Asunto", "Mensaje de prueba");
        empleado.administrarHorario(new Date(), new Date());
    }
}
~~~
In this example, `Employee` has multiple responsibilities, such as storing an employee's personal information, calculating their salary, sending emails, and managing work schedules, which violates the Single Responsibility principle. This can make moderation and maintenance difficult in the future and affect the scalability of the code.

### Good example:


Suppose we have a `FileHandler` class with the responsibility of reading and writing text files. The methods of the class align with this responsibility and abstract the complexity of reading and writing files to the rest of the program.
~~~java:
public class ManejadorArchivo {
    public String leerArchivo(String nombreArchivo) {
        // código para leer archivo
        return contenidoArchivo;
    }

    public void escribirArchivo(String nombreArchivo, String contenido) {
        // código para escribir archivo
    }
}

public class Programa {
    public static void main(String[] args) {
        ManejadorArchivo manejador = new ManejadorArchivo();

        String contenido = manejador.leerArchivo("archivo.txt");
        System.out.println("Contenido del archivo: " + contenido);

        manejador.escribirArchivo("archivo2.txt", "texto de prueba");
    }
}
~~~
In this example, `FileHandler` has a single responsibility: reading and writing text files. The methods of the class align with this responsibility and abstract the complexity of reading and writing files to the rest of the program.

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)