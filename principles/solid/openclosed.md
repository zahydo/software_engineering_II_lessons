## Open/Closed
The Open-Closed Principle (OCP) states that objects or entities in software must be designed in such a way that they are open for extension but closed for modification. This principle helps to avoid unnecessary code changes and to improve the scalability of the software to make it more efficient. In other words, the OCP means that upon requests for changes to our program, we must be able to add new functionality without modifying existing ones, whenever possible.

In an inappropriate design, modifying a feature during the software life cycle can lead to a series of changes in dependent modules, which can lead to a cascade of negative effects if the code is tightly coupled.

The most common way to follow the OCP principle is by using interfaces or abstract classes on which concrete implementations are based. In this way, the implementation of a concrete class can be changed without modifying the interface, which allows an extension of the software without affecting its basic structure.

### Bad example:
This example presents a class consisting of three attributes: name, age, and type. In addition, the class has a constructor that receives these three parameters and a method called MakeSound() that sets the sound the pet makes based on its type.

The implementation of the class is shown below:
~~~java
public class Pet {
    private String name;
    private int age;
    private String type;

    public Mascota(String name, int age, String tipo) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public String makeSound() {
        if (type.equals("dog")) {
            return "Woof!";
        } else if (type.equals("cat")) {
            return "Meow!";
        } else {
            return "Unknown sound!";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Pet dog = new Pet("Fido", 5, "dog");
        Pet cat = new Pet("Tom", 3, "cat");

        System.out.println(dog.getName() + " says: " + dog.makeSound());
        System.out.println(cat.getName() + " says: " + cat.makeSound());
    }
}
~~~

The problem is that the function currently sets a number of specific sounds for pets, which means that if you want to add a new pet, such as a snake or bird, you'll need to modify the "makeSound()" method to add a new pet. new item.

### Good example:
~~~java

public class Mascota {
    private String name;
    private int age;
    private TipoMascota tipo;

    public Mascota(String name, int age, TipoMascota tipo) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public TypePet getType() {
        return type;
    }

    public String makeSound() {
        return type.makeSound();
    }
}

public interface PetType {
    String makeSound();
}

public class Dog implements PetType {
    public String makeSound() {
        return "Wow!"
    }
}

public class Cat implements PetType {
    public String makeSound() {
        return "Meow!"
    }
}

public class Main {
    public static void main(String[] args) {
        Pet dog = new Pet("Fido", 5, new Dog());
        Pet cat = new Pet("Tom", 3, new Cat());

        System.out.println(dog.getName() + " says: " + dog.makeSound());
        System.out.println(cat.getName() + " says: " + cat.makeSound());
    }
}
~~~
In this case, we define an interface called PetType, which contains a method called makeSound(). The Mascota class now has an attribute called PetType, which is initialized in the constructor with an instance of a class such as Dog or Cat that implements the PetType interface. Within these classes, the makeSound() method is implemented with the corresponding sound.

In this way, if we want to add more pets, we only need to create a new class that implements the PetType interface.

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)