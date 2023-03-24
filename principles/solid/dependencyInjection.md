## Dependency Injection

This principle states that dependencies should be on abstract classes and interfaces rather than concrete classes and functions.
That is, the high-level module should not depend on the low-level module, but on abstractions. 

### Bad example

```Java
class DatabaseService{
    //...
    void getData(){ 
        //... 
    }
}

class DataAccess {

    private DatabaseService databaseService;

    public DataAccess(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

 Data getData(){
        databaseService. getData();
        //...
    }
}
```
Taking into account the previous implementation, let's imagine that we want to change the database service for an API, so all instances of DataAccess would have to be modified. This is because DataAccess () (high-level module), depends on DatabaseService() (low-level module), seeing the beginning.  

### Good example

In this case, the DataAccess () module depends on a  more generic abstraction, such as an interface:

```Java
interface connection {
    Data getData();
    void setData();
}
  
class DataAccess {
  
   private Connection connection;
  
   public DataAccess(Connection connection){
        this.connection = connection;
    }
  
    Data getData(){
        connection. getData();
    }
}
```

No matter what type of connection is passed to DataAccess(), neither it nor its instances will have to change. Now, each service that you want to pass to the DataAccess () module will have to implement a connection interface. 

```Java
class DatabaseService implements Connection {

    @Override
    public Data getData() { 
        //... 
    }

    @Override
    public void setData() { 
        //...
    }
}

class APIService implements Connection{

    @Override
    public Data getData() { 
        //... 
    }

    @Override
    public void setData() { 
        //... 
    }
}

```
In this way, the high and low level modules depend on abstractions, thus fulfilling the principle of dependency inversion. 

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)