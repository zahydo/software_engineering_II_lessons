## Dependency Injection

Dependency Injection (DI) is a design pattern in which an object receives its dependencies from an external source rather than creating them itself. The purpose of DI is to increase modularity, flexibility, and testability of the code.

### Bad example

```c#
public class Order
{
    private readonly Database _database;

    public Order()
    {
        _database = new Database();
    }

    public void Save()
    {
        _database.Save(this);
    }
}

public class Database
{
    public void Save(Order order)
    {
        // save the order to the database
    }
}
```
In this example, the Order class is tightly coupled to the Database class, which makes it difficult to test and change the implementation of Database. If we want to use a different database implementation, we need to modify the Order class.
### Good example

```c#
public class Order
{
    private readonly IDatabase _database;

    public Order(IDatabase database)
    {
        _database = database;
    }

    public void Save()
    {
        _database.Save(this);
    }
}

public interface IDatabase
{
    void Save(Order order);
}

public class SqlDatabase : IDatabase
{
    public void Save(Order order)
    {
        // save the order to the SQL database
    }
}

public class OracleDatabase : IDatabase
{
    public void Save(Order order)
    {
        // save the order to the Oracle database
    }
}
```
In this example, the Order class no longer creates the Database object itself. Instead, it receives an instance of an object that implements the IDatabase interface through its constructor. This allows us to swap different implementations of IDatabase without changing the Order class. We have also introduced an interface for Database, which makes it easier to test and change its implementation. This is a good example of how DI can increase the flexibility and testability of the code.

### Related principles

- [Separation of Concerns](/principles/general/separationofconcerns.md)
- [Composition Over Inheritance](/principles/general/compositionoverinheritance.md)
- [Do the Simplest Thing That Could Possibly Work](/principles/general/dothesimplestthing.md)
- [Code For The Maintainer](/principles/general/codeformantainer.md)
- [Avoid Premature Optimization](/principles/general/avoidprematureopt.md)
### Related patterns


[Back to the list](./README.md)