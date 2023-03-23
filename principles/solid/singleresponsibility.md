## Single Responsibility

The Single Responsibility Principle (SRP) states that a class should have only one reason to change. In other words, a class should have only one responsibility or job to do. 

### Bad example:

Suppose you have a class called `Student` that has the responsibility of managing student information and calculating their grades. 

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

- [Separation of concerns](../general/separationofconcerns.md)
### Related patterns

- [Pattern names]


[Back to the list](./README.md)