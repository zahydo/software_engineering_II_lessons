## Single Responsibility

This principle establishes that each class should have a unique responsibility
within our software and this responsibility must be defined and be
concrete. All methods must be aligned with the purpose of the class.

### Bad example:

~~~JAVA:
public class Empleado {
    private String nombre;
    private int edad;
    private String correo;
    private String departamento;
    
    public Empleado(String nombre, int edad, String correo, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.departamento = departamento;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public String getDepartamento() {
        return departamento;
    }
    
    public void enviarCorreo(String mensaje) {
        ServidorEmail email = new ServidorEmail("smtp.gmail.com", "usuario", "contraseña");
        email.enviarCorreo(correo, "Notificación del departamento " + departamento, mensaje);
    }
}

~~~


### Good example:

~~~JAVA:
public class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }
    
    public int restar(int a, int b) {
        return a - b;
    }
    
    public int multiplicar(int a, int b) {
        return a * b;
    }
    
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir entre 0.");
        }
        return a / b;
    }
}

~~~

### Related principles

- Separation of concerns

### Related patterns

- Code For The Maintainer

---
[Back to the list](./README.md)