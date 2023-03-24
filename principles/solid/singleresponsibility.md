## Single Responsibility
The Single Responsibility Principle (SRP) is one of the fundamental practices of object-oriented software design. Its goal is to ensure that each class or module in the program has a single responsibility or task, which means that each class should have only one job to do.

This principle is of great importance in software development, as it promotes simplicity, cohesion, and low maintenance among system components. By having a single responsibility, each class becomes easier to understand, maintain, and modify in the future, reducing development time and cost.

In addition, the single responsibility principle promotes code reuse, as classes that have a single task can easily be used in different parts of the system, increasing development efficiency and reducing code duplication.


### Bad example:
Let's imagine that a registration system for pets and their owners is being developed at a veterinarian. It is requested that the name and age of the pet be recorded, as well as the name and age of the owner. It is decided to instantiate the pet within the function itself. However, there is a problem with this implementation, since when instantiating the pet within the function, not only will the pet's attributes be passed, but the pet owner's attributes will also have to be passed in order to create a pet. full instance.
~~~java
public class Pet {
    private String name;
    private int age;
    private Owner owner;

    public Pet(String name, int age, String nameOwner, int ageOwner) {
        this.name = name;
        this.age = age;
        this.owner = new Owner(ownerName, ownerAge);
    }

    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Owner getOwner() {
        return owner;
    }
}


class Owner {
    private String name;
    private int age;

    public Owner(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public static void main(String[] args) {
        Pet pet = new Pet("Fido", 5, "Juan", 30);
        System.out.println("My pet is named " + pet.getName() + " and its owner is named " + pet.getOwner().getName());
    }

~~~
### Good example:
To apply the Single Responsibility Principle we will separate in each class their corresponding responsibilities:
~~~java
public class Pet {
    private String name;
    private int age;
    private Owner owner;

    public Pet(String name, int age, Owner owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Owner getOwner() {
        return owner;
    }
}
public class Owner {
    private String name;
    private int age;

    public Owner(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Main {
    public static void main(String[] args) {
        Owner owner = new Owner("John", 30);
        Pet pet = new Pet("Fido", 5, owner);
        System.out.println("My pet's name is " + pet.getName() + " and its owner's name is " + pet.getOwner().getName()));
    }
}


~~~

In this case, the "Pet" class and the "Owner" class will implement separate functions. This is done so that each class has a different responsibility and is not coupled to a single function. This is because they are two different concepts: on the one hand, a "Pet" object is created and on the other hand, an "Owner" object is created.

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)