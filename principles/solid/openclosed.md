## Open/Closed

The open/closed principle says that every class, module, method, etc. ought
be open to extend but must be closed to be modified. Which
we want is to prevent our code from being modified unintentionally causing
errors or unexpected functionality. perform in JAVA a good example and a bad example

### Bad example:
~~~JAVA:
public class LectorArchivo {
    public String leerArchivo(String ruta) {
        try {
            FileReader archivo = new FileReader(ruta);
            BufferedReader lector = new BufferedReader(archivo);
            String linea;
            StringBuilder texto = new StringBuilder();
            while ((linea = lector.readLine()) != null) {
                texto.append(linea);
            }
            lector.close();
            return texto.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
~~~
### Good example:
~~~JAVA:
public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    
    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }
    
    public abstract void acelerar();
    
    public abstract void frenar();
    
    public String getMarca() {
        return marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public int getAnio() {
        return anio;
    }
}

public class Automovil extends Vehiculo {
    public Automovil(String marca, String modelo, int anio) {
        super(marca, modelo, anio);
    }
    
    @Override
    public void acelerar() {
        System.out.println("El automóvil está acelerando.");
    }
    
    @Override
    public void frenar() {
        System.out.println("El automóvil está frenando.");
    }
}

public class Camioneta extends Vehiculo {
    public Camioneta(String marca, String modelo, int anio) {
        super(marca, modelo, anio);
    }
    
    @Override
    public void acelerar() {
        System.out.println("La camioneta está acelerando.");
    }
    
    @Override
    public void frenar() {
        System.out.println("La camioneta está frenando.");
    }
}
~~~
### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)