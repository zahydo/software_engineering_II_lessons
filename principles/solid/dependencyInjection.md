## Dependency Injection

Dependency Injection is a software engineering technique that allows managing the dependencies between components of a software system, decoupling the components and allowing them to be easily replaced or modified without affecting the rest of the system. This is achieved by designing components to depend on interfaces rather than concrete implementations, and then providing the appropriate implementations at runtime through a dependency injector. Dependency Injection is considered a best practice for creating maintainable, testable, and scalable software systems.

### Bad example

```
public class CustomerService {
    private CustomerDao customerDao;

    public CustomerService() {
        this.customerDao = new CustomerDao();
    }

    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }
}

public class CustomerDao {
    // métodos y atributos de la clase CustomerDao
}
```
In this example, the class CustomerService is directly creating an instance of the CustomerDao class in its constructor. This tightly couples both classes and makes the CustomerService class dependent on the CustomerDao class. This makes it difficult to modify and test in the future, as any changes to the CustomerDao class would require changes to the CustomerService class.

Additionally, the above code does not follow the principle of Inversion of Dependency, as the higher-level class CustomerService directly depends on a lower-level class CustomerDao.

### Good example

```
public class CustomerService {
    private CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }
}

public class CustomerDao {
    // métodos y atributos de la clase CustomerDao
}
```
In this case, the CustomerService class receives an instance of CustomerDao through its constructor instead of directly creating it. This separates the creation of objects from their use, making the classes more modular, easier to test, and easier to maintain in the future. Additionally, the code follows the principle of Inversion of Dependency, as the higher-level CustomerService class depends on a CustomerDao abstraction, rather than a concrete CustomerDao class.

---
[Back to the list](./README.md)