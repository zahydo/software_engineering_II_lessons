## Dependency Injection

The dependency inversion principle states that our classes should depend on interfaces or abstract classes instead of concrete classes and functions. abstract classes rather than on concrete classes and functions. "Depend on abstractions, not on concretions."
It is recommended that: 
1 - High-level modules should not depend on low-level modules. Both should depend on abstractions.
2 - Abstractions should not depend on concretions. Details should depend on abstractions.
At some point our program or application will come to consist of many modules. When this happens, is when we must use dependency injection, which will allow us to control the functionalities from a specific place instead of having them spread all over the program. In addition, this isolation will allow us to 
will allow us to perform testing much more easily.

### Bad example

Suppose we have a class to perform data access, and we do it through a DB:

class DatabaseService{  
    //...
    void getDatos(){ //... }
}

class AccesoADatos {

    private DatabaseService databaseService;

    public AccesoADatos(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    Dato getDatos(){
        databaseService.getDatos();
        //...
    }
}

Let's imagine that in the future we want to change the DB service for a service that connects to an API. We would have to modify all the instances of the class of the DataAccess class, one by one. This is because our high-level module (DataAccess) depends on a lower-level module (DatabaseService), thus violating the dependency inversion principle. The high-level module should depend on abstractions.

### Good example

To fix this, we can make the DataAccess module depend on a more generic abstraction:

interface Conexion {  
    Dato getDatos();
    void setDatos();
}

class AccesoADatos {

    private Conexion conexion;

    public AccesoADatos(Conexion conexion){
        this.conexion = conexion;
    }

    Dato getDatos(){
        conexion.getDatos();
    }
}

Thus, no matter what type of connection is passed to the DataAccess module, neither it nor its instances will have to change, saving us a lot of work. Now, each service that we want to pass to AccesoADatos will have to implement the interface Conexion:

class DatabaseService implements Conexion {

    @Override
    public Dato getDatos() { //... }

    @Override
    public void setDatos() { //... }
}

class APIService implements Conexion{

    @Override
    public Dato getDatos() { //... }

    @Override
    public void setDatos() { //... }
}

Thus, both the high-level module and the low-level module depend on abstractions, so we comply with the principle of dependency inversion. 

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)