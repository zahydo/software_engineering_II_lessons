## Single Responsibility

The "Single Responsibility" (SRP) principle in software development states that each class or module should have a single responsibility or function within the system.

In other words, a class or module should have only one reason to change, meaning its design should be consistent and focused on a single task, without mixing multiple responsibilities or concerns into a single entity.

### Bad example:

´´´
public class Employee {
    private String name;
    private String address;
    private double salary;
    private String department;

    public void saveEmployee(Employee e) {
        // Save employee details to database
    }

    public void sendNotification(Employee e, String message) {
        // Send notification to employee
    }
}
´´´

In this example, the Employee class has two methods, saveEmployee and sendNotification, that perform two different tasks: saving employee details to the database and sending notifications to the employee. This violates the SRP principle, as the class has two distinct responsibilities.


### Good example:

´´´
public class Employee {
    private String name;
    private String address;
    private double salary;
    private String department;

    // constructor, getters, setters

}

public class EmployeeRepository {
    public void saveEmployee(Employee e) {
        // Save employee details to database
    }
}

public class NotificationService {
    public void sendNotification(Employee e, String message) {
        // Send notification to employee
    }
}
´´´

In this case, we have created two new classes: EmployeeRepository and NotificationService. The Employee class now only has the responsibility of representing an employee with its attributes, while the EmployeeRepository class is responsible for storing and retrieving the employee details in the database, and the NotificationService class is responsible for sending notifications to the employees.

This way, each class has a single responsibility and there is no mixing of different tasks in a single class, thus fulfilling the SRP principle.

### Related principles

- [Separation of concerns](../general/separationofconcerns.md) 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)