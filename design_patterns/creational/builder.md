# Builder
Builder is a creational design pattern that is used to create complex objects step-by-step and to create different representations of an object without modifying its underlying code. The Builder pattern separates the creation of a complex object from its representation and allows the same construction process to create different representations of the object.

In the Builder pattern, an interface for building complex objects is defined and a concrete implementation of the interface is provided to build the object. The build interface allows different parts of the object to be defined and a concrete implementation allows the object to be constructed from the parts.

Los componentes son:
director 
producto  


## Example:

```Java 
public abstract class PizzaBuilder{
    protected Pizza pizza;
    
    public Pizza getPizza(){
        return pizza;
    }
    
    public void crearNuevaPizza(){
        pizza = new Pizza;
    }
    
    //The classes responsible for implementing the methods are HawaiPizzaBuilder and PicantePizzaBuilder
    public abstract void buildMasa();
    public abstract void buildSalsa();
    public abstract void buildRelleno();
}
```

```Java 
public class HawaiPizzaBuilder extends PizzaBuilder{
    @Override
    public void buildMasa(){
        pizza.setMasa("suave");
    }
    
    @Override
    public void buildSalsa(){
        pizza.setSalsa("dulce");
    }
    
    @Override
    public void buildRelleno(){
        pizza.setRelleno("chorizo + alcachofas");
    }
}
```

```Java 
public class PicantePizzaBuilder extends PizzaBuilder{
    @Override
    public void buildMasa(){
        pizza.setMasa("cocida");
    }
    
    @Override
    public void buildSalsa(){
        pizza.setSalsa("picante");
    }
    
    @Override
    public void buildRelleno(){
        pizza.setRelleno("pimineta + salchichon");
    }
}
```

```Java 
//Product class
//This design pattern allows the creation of objects of this unique class.
public class Pizza{
    private String masa = "";
    private String salsa = "";
    private String relleno = "";
    
    public void setMasa(String masa){
        this.masa = masa;
    }
    
    public void setSalsa(String salsa){
        this.salsa = salsa;
    }
    
    public void setRelleno(){
        this.relleno = relleno;
    }
}
```

```Java 
//Director se encaga de gestionar la creacion del producto
public class Cocina{
    private PizzaBuilder pizzaBuilder;
    
    public void setPizzaBuilder(PizzaBuilder pb){
        pizza = pb;
    }
    
    public Pizza getPizza(){
        return PizzaBuilder.getPizza();
    }
    
    public void construirPizza(){
        pizzaBuilder.crearNuevaPizza();
        pizzaBuilder.buildMasa();
        pizzaBuilder.buildSalsa();
        pizzaBuilder.buildRelleno();
    }
}
```

```Java 
public class App{
    public static void main (String[] args) {
        Cocina cocina = new Cocina();   //Director
        PizzaBuilder hawaiPB = new HawaiPizzaBuilder();
        PizzaBuilder picantePB = new PicantePizzaBuilder();
        
        cocina.setPizzaBuilder(hawaiPB);
        cocina.construirPizza();
        
        Pizza pizza = cocina.getPizza();
        
    }
}
```