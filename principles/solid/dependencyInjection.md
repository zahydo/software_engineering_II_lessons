## Dependency Injection

Dependency Injection
This principle establishes that dependencies must be in the
abstractions and not in the concretions, in other words, they ask us that the
classes never depend on other classes and that this entire relationship must be in one
abstraction. This principle has two rules:
• High level modules should not depend on low level modules.
This logic must be in an abstraction.
• Abstractions should not depend on details. The details should
rely on abstractions.

### Bad example
~~~JAVA:
public class Pedido {
    private String idPedido;
    private List<ItemPedido> items = new ArrayList<ItemPedido>();
    
    public void addItem(ItemPedido item) {
        items.add(item);
    }
    
    public void guardar() {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedidos", "root", "");
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO pedidos (id, items) VALUES (" + idPedido + ", " + items.toString() + ")");
        statement.close();
        connection.close();
    }
}

public class ItemPedido {
    private String idProducto;
    private int cantidad;
    
    public ItemPedido(String idProducto, int cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }
    
    public String getIdProducto() {
        return idProducto;
    }
    
    public int getCantidad() {
        return cantidad;
    }
}
~~~
### Good example
~~~JAVA:
public interface Adivinanza {
    int obtenerNumeroAdivinar();
    boolean verificarAdivinanza(int numero);
}

public class AdivinanzaNumero implements Adivinanza {
    private int numeroAdivinar;
    
    public AdivinanzaNumero() {
        Random random = new Random();
        numeroAdivinar = random.nextInt(100);
    }
    
    public int obtenerNumeroAdivinar() {
        return numeroAdivinar;
    }
    
    public boolean verificarAdivinanza(int numero) {
        return (numero == numeroAdivinar);
    }
}

public class Jugador {
    private Adivinanza adivinanza;
    
    public Jugador(Adivinanza adivinanza) {
        this.adivinanza = adivinanza;
    }
    
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        int intento = scanner.nextInt();
        boolean adivinado = adivinanza.verificarAdivinanza(intento);
        while (!adivinado) {
            intento = scanner.nextInt();
            adivinado = adivinanza.verificarAdivinanza(intento);
        }
        scanner.close();
        System.out.println("¡Adivinaste!");
    }
}

public class Juego {
    public static void main(String[] args) {
        Adivinanza adivinanza = new AdivinanzaNumero();
        Jugador jugador = new Jugador(adivinanza);
        jugador.jugar();
    }
}
~~~
### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)