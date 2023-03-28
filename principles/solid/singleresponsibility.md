## Single Responsibility

States that a class or module must have only one reason to change. In other words, a class or module must have only one responsibility.

The problem it solves is that a class with multiple responsibilities becomes difficult to maintain, test and evolve, since any change in one of its responsibilities can affect the others. Therefore, by applying the SRP principle, the cohesion and coupling of the system can be improved, making it easier to understand and maintain.

### Bad example:

``` java
public class ReportGenerator {
    public void generateSalesReport(Date startDate, Date endDate) {
        // code to generate a sales report
    }
    
    public void sendReportByEmail(String email, String report) {
        // code to send the report by email
    }
}
```
In this example, the ReportGenerator class has two responsibilities: to generate a sales report and to send that report by e-mail. This violation of the SRP principle makes it difficult to understand and maintain this class, and any change in one responsibility may affect the other.

### Good example:

``` java
public class ReportGenerator {
    public void generateSalesReport(Date startDate, Date endDate) {
        // code to generate a sales report
    }
}

public class EmailSender {
    public void sendReportByEmail(String email, String report) {
        // code to send the report by email
    }
}
```
In this case, the ReportGenerator class has only one responsibility: to generate a sales report, and the EmailSender class has the responsibility to send the report by email. By separating these responsibilities into different classes, we make it easier to understand and maintain each class separately. In addition, we can change or enhance each class without affecting the other.

### Related principles

- [Separation of Concerns](../general/separationofconcerns.md)
- [KISS](../general/kiss.md)
- [Do the simplest thing that Could Possibly work](../general/dothesimplestthing.md)

[Back to the list](./README.md)