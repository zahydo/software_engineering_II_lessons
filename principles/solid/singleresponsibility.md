## Single Responsibility

It states that a class should have only one responsibility, meaning one reason to change.
By following this principle, code modularity, cohesion, and maintainability can be improved.

### Bad example:

```
public class Usuario {
    private String nombre;
    private String correoElectronico;
    private String contrasena;
    private boolean estaActivo;

    public void guardarUsuario() {
        // Código para guardar el usuario en la base de datos
    }

    public void enviarCorreoElectronico(String mensaje) {
        // Código para enviar un correo electrónico al usuario
    }
}
```

In this example, the User class has two responsibilities: storing and retrieving user information and sending emails. This makes the class hard to understand, maintain, and modify, as different concepts and functionalities are mixed in a single class. To apply the SRP principle, the email sending functionality should be separated into a separate class, so that each class has a single responsibility.

### Good example:
```
public class Usuario {
    private String nombre;
    private String correoElectronico;
    private String contrasena;
    private boolean estaActivo;
    
    // Constructor, getters y setters
    
    // Método para guardar el usuario en la base de datos
    public void guardarUsuario() {
        // Código para guardar el usuario en la base de datos
    }
}
```
"In this example, the User class has only one responsibility: storing and retrieving user information. The email sending functionality has been separated into a separate class, complying with the SRP principle."

[Back to the list](./README.md)