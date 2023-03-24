## Dependency Injection

It states that dependencies must be on the abstractions, not the concretions. That is to say:

- High level modules should not depend on low level modules. Both should depend on abstractions.  
- Abstractions should not depend on details. Details should depend on abstractions.

At some point our program or application will be made up of many modules. When this happens, it is when we must use dependency injection, which will allow us to control the functionalities from a specific place instead of having them scattered throughout the program. In addition, this isolation will allow us to test much more easily.

### Bad example

Suppose we have a class to access data, and we do it through a DB:

```JAVA:
    class DatabaseService{
        //...
        void getData(){ //... }
    }

    class DataAccess {

        private DatabaseService databaseService;

        public DataAccess(DatabaseService databaseService){
            this.databaseService = databaseService;
        }

        Data getData(){
            databaseService.getData();
            //...
        }
    }
```

Let's imagine that in the future we want to change the DB service for a service that connects with an API. We would have to modify all the instances of the AccesoADatos class, one by one.

This is because our high level module (DataAccess) depends on a lower level module (DatabaseService), thus violating the dependency inversion principle. The top level module should depend on abstractions.

### Good example

To fix this, we can make the DataAccess module depend on a more generic abstraction. Thus, regardless of the type of connection that is passed to the DataAccess module, neither it nor its instances will have to change, so we will save a lot of work and each service that we want to pass to DataAccess must implement the Connection interface like this:

```JAVA:
    interface connection {
        Data getData();
        void setData();
    }

    class DataAccess {

        private connection connection;

        public DataAccess(Connection connection){
            this.connection = connection;
        }

        Data getData(){
            connection.getData();
        }
    }
    class DatabaseService implements Connection {

        @Override
        public Data getData() { //... }

        @Override
        public void setData() { //... }
    }

    class APIService implements Connection{

        @Override
        public Data getData() { //... }

        @Override
        public void setData() { //... }
    }
```

Thus, both the high-level module and the low-level module depend on abstractions, so we comply with the principle of dependency inversion. In addition, this will force us to comply with the Liskov principle, since the types derived from Connection (DatabaseService and APIService) are replaceable by their abstraction (Connection interface).

### Related principles

- Code For The Maintainer.
- Composition Over Inheritance 

---
[Back to the list](./README.md)