## Dependency Injection

[TODO]

### Bad example

Suppose we have a class called `App` that needs to access a file called "config.properties" to get certain configuration values. Instead of using an interface and applying the principle of Dependency Inversion, the `Properties` class in `App` is directly used.
~~~java:
public class App {
    private Properties properties;

    public App() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            // manejo de la excepción
        }
    }

    public void ejecutar() {
        // realizar lógica para utilizar los valores de configuración de properties
        String valor = properties.getProperty("clave");
        // más código...
    }
}
~~~

### Good example

Suppose we have the `DatabaseManager` class that needs to access a MySQL database. Rather than directly instantiating a database connection in `DatabaseManager`, it is best to create an interface called `DBConnection` with the methods required by `DatabaseManager` and have the MySQL connection class implement that interface. Then, in the `DatabaseManager` class, we pass the `DBConnection` instance as an argument in the class's constructor or method, avoiding coupling directly with the concrete MySQL class.

En este ejemplo, `GestorDeBaseDeDatos` no está directamente relacionado con `ConexionMySQL`, 
sino que usa la interfaz `ConexionBD` que es una abstracción de la conexión a la base de datos.
~~~java
public interface ConexionBD {
    void conectar();
    void desconectar();
}

public class ConexionMySQL implements ConexionBD {
    public void conectar() {
        // código para conectar a la base de datos MySQL
    }

    public void desconectar() {
        // código para desconectar de la base de datos MySQL
    }
}

public class GestorDeBaseDeDatos {
    private ConexionBD conexion;

    public GestorDeBaseDeDatos(ConexionBD conexion) {
        this.conexion = conexion;
    }

    public void realizarConsulta(String consulta) {
        conexion.conectar();
        // realizar lógica para realizar la consulta
        conexion.desconectar();
    }
}
~~~

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)