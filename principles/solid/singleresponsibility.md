## Single Responsibility

The Single Responsibility Principle (SRP) states that a class should have only one reason to change. In other words, a class should have only one responsibility or job to do, the problem it aims to solve is that a class, interface or module with multiple responsibilities is difficult to understand, test, and maintain, the way it tries to solve it is by designing classes, interfaces and modules that have only one responsibility, meaning that they have only one reason to change.

The benefits that it brings are:
- Improved maintainability
- Easier testing
- Promotes better organization and modularity of code.

### Bad example:

<<<<<<< HEAD
Suppose you have a class called `Student` that has the responsibility of managing student information and calculating their grades. 
=======
```java
public class Vehicle {
    public void printDetails() {}
    public double calculateValue() {}
    public void addVehicleToDB() {}
}
```
>>>>>>> 6814cdd (Some changes added)

``` java
public class Student {
	private String name;
	private int age;
	private int grade;

	public Student(String name, int age, int grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}

	// getters and setters
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public double calculateGPA() {
		// logic to calculate GPA
	}
}

```

This code violates the SRP because the `Student` class has two responsibilities: managing student information and calculating grades. If either of these responsibilities changes, we would need to modify the `Student` class, which violates the SRP.

### Good example:
To apply the SRP, we can create two separate classes: `Student` for managing student information and `GradeCalculator` for calculating grades. This way, each class has only one responsibility and can be changed independently of the other:

<<<<<<< HEAD
``` java
public class Student {
	private String name;
	private int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// getters and setters
	public void setName(String name) {
		this.name = name;
	}
=======
```java
public class VehicleDetails{
    //TODO
}

public class VehicleValues {
    //TODO
}

public class VehicleDB{
    //TODO
}
```
>>>>>>> 6814cdd (Some changes added)

	public void setAge(int age) {
		this.age = age;
	}
}

public class GradeCalculator {
	public double calculateGPA(Student student) {
		// logic to calculate GPA
	}
}

```
This code separates the responsibilities of managing student information and calculating grades into two separate classes, Student and GradeCalculator, respectively.
### Related principles

<<<<<<< HEAD
- [Links to other principles] 
=======
- [Open/Closed](./openclosed.md)
>>>>>>> 6814cdd (Some changes added)

### Related patterns

- [Separation of Concerns](../general/separationofconcerns.md)
- [KISS](../general/kiss.md)
- [Do The Simplest Thing That Could Possibly Work](../general/dothesimplestthing.md)
- [Boy-Scout Rule](../general/boyscoutrule.md)


[Back to the list](./README.md)