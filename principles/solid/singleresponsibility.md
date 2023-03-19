## Single Responsibility

The Single Responsibility Principle states that a class should have only one responsibility, meaning that there should only be one reason for the class to change.

### Bad example:

~~~java
public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void printData() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Grade: " + this.grade);
    }

    public void updateData(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void saveData() {
        // Code to save student data in a database
    }

    public void sendEmail(String message) {
        // Code to send an email to the student
    }
}
~~~

In this example, the Student class has multiple responsibilities: printing student data, updating student data, saving student data to a database, and sending an email to the student. This makes the class difficult to maintain and extend.


### Good example:

~~~java
public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void printData() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Grade: " + this.grade);
    }

    public void updateData(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

class StudentDAO {
    public void saveData(Student student) {
        // Code to save student data in a database
    }
}

class EmailSender {
    public void sendEmail(String recipient, String message) {
        // Code to send an email to the recipient
    }
}
~~~

In this example, the Student class only has the responsibility of representing a student and handling the updating of their data. Two additional classes have been created to handle the responsibilities of saving student data to a database and sending emails. The StudentDAO class is responsible for saving student data to a database, while the EmailSender class is responsible for sending emails. This way, each class has only one responsibility, making them easy to maintain and extend.


### Related principles

* Separation of Concerns
* Code For The Maintainer
* KISS (Keep It Simple, Stupid)

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)