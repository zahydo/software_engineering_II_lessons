# Composite

The Composite design pattern is a structural pattern that allows you to compose objects into tree structures and treat both the individual objects and the composed objects in a uniform manner. It allows you to create hierarchical structures where each node can have zero or more sub-nodes.

The pattern consists of two main components: the component and the composite. The component is the base class for all objects in the hierarchy, whether they are individual objects or composed objects. It defines the common interface for all objects and specifies the default behavior for all methods.

The composite represents the composed objects in the hierarchy. It contains a collection of child components and implements the same interface as the component. The composite forwards requests to its child components and performs additional operations on the results.

This pattern is useful when dealing with complex structures that can be represented as a tree-like hierarchy. It allows you to treat individual objects and groups of objects in a uniform manner, simplifying the client code. It also allows you to add or remove objects from the hierarchy at runtime, without affecting the rest of the structure.


Suppose we want to create a system to manage the information of the company, including employee information. Each employee can be an individual object or a composite object that represents a whole department, with several employees working in it.

To solve this problem, we can use the Composite design pattern. In this case, the component would be the base class Employee, which defines the common attributes and methods for all employees. The Employee class can have different subclasses for different types of employees, such as full-time employees, part-time employees, managers, etc.

The Composite class, on the other hand, would represent the company's departments, which could contain several employees (Employee objects) and other departments (Composite objects) within them. The Composite class would implement the same methods as the Employee class, which would allow treating both individual employees and entire departments as a single entity.

This way, when adding or removing an employee or department, the hierarchical structure of the organization can be easily updated without affecting the rest of the system. Operations can also be performed at different levels of the hierarchy, such as generating reports or calculating salaries, in a uniform and simplified manner.

## Diagram class of example
![ClassDiagram](http://www.plantuml.com/plantuml/png/pL7BQiCm4BplL-Xee-W7J0Y1Fg1GUab_O1CjHg27aTO1q_RVMwLMxBgK-DYZPcSqixFxn1YvTnRmc3ZYYSN9OahYmNKs34JY3PH7HuquS3I-1MLq8undK0ajng4HElH7Io2Bf9hpDsBaRyHFVWso9Nv1HrLTo1VeIMSWE-JNuIBAIB6v1aMjAnezcslWB-Ov63tZHNBXJAkeBN4PfkpvR19l2xA33u3lTkwfmyYEFET-g4X-2UH4NDtAZRLkRxDsYSVUsbVZQ7PgkSJ-N-gxu3hqG-uzXi3JJo37KLM3xABni_-AYrhWV-R9VWKIstUbPYTV39QL0PI8IkscT7lokdVs4m00)
# Example
```java
// Component
public abstract class Employee {
    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public abstract void add(Employee employee);
    public abstract void remove(Employee employee);
    public abstract List<Employee> getEmployees();
}

// Composite
public class Department extends Employee {
    private List<Employee> employees;

    public Department(String name, int id, double salary) {
        super(name, id, salary);
        employees = new ArrayList<>();
    }

    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void remove(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }
}

// Leaf
public class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void add(Employee employee) {
        // No action required
    }

    @Override
    public void remove(Employee employee) {
        // No action required
    }

    @Override
    public List<Employee> getEmployees() {
        // No employees to return
        return Collections.emptyList();
    }
}

// Client code
public class Company {
    private Employee root;

    public Company() {
        // Creating the hierarchy
        Department engineering = new Department("Engineering", 1, 0);
        engineering.add(new FullTimeEmployee("Alice", 101, 50000));
        engineering.add(new FullTimeEmployee("Bob", 102, 55000));

        Department sales = new Department("Sales", 2, 0);
        sales.add(new FullTimeEmployee("Charlie", 201, 45000));

        Department marketing = new Department("Marketing", 3, 0);
        marketing.add(new FullTimeEmployee("David", 301, 60000));
        marketing.add(sales);

        Department company = new Department("Company", 0, 0);
        company.add(engineering);
        company.add(marketing);

        root = company;
    }

    public void printEmployees() {
        printEmployees(root);
    }

    private void printEmployees(Employee employee) {
        System.out.println(employee.getName() + " - " + employee.getSalary());

        for (Employee e : employee.getEmployees()) {
            printEmployees(e);
        }
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        company.printEmployees();
    }
}
```
[Back](../structural/README.md)