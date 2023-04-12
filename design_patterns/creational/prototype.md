# Prototype Patterns

The Prototype pattern allows us to hide the complexity of creating new instances for the client. Instead of creating a new instance from scratch, which can involve expensive operations, an existing object is copied as a prototype, containing the state of the object. The copied object can then modify the same properties only if necessary. This approach saves valuable resources and time, especially in situations where object creation is a heavy process.

The Prototype pattern is considered a creational design pattern and is used when object creation is slow and expensive. Copying existing objects using the "clone()" method is one of the simplest ways to implement the Prototype pattern. However, it's important to note that the way of copying existing objects may vary depending on the specific business model.

## 🏗️ Estructure 
<p align="center">
<img src="https://i.postimg.cc/26PLpLLt/prototype-Estructure-drawio.png" alt="mypic" width="75%">
</p>

## 😟 Problem

We want to store information about different animals in our application. For this, we define a parent class called "Animal" and two child classes called "Cat" and "Dog". These child classes extend from the "Animal" class. Then, we create instances of these classes in the main class of our application. However, a problem arises: we want to create exact copies of the already created objects, as we need to have identical objects for performing additional operations. In other words, we need to duplicate existing objects in our application in order to work with them independently.
~~~java
// Animal Class
abstract class Animal {
    protected String type;

    public Animal(String type) {
        this.type = type;
    }

    public abstract void makeSound();
}

// Dog Class that inherits from Animal
class Dog extends Animal {
    public Dog() {
        super("Dog");
    }

    @Override
    public void makeSound() {
        System.out.println("The dog says: Woof Woof");
    }
}

// Cat Class that inherits from Animal
class Cat extends Animal {
    public Cat() {
        super("Cat");
    }

    @Override
    public void makeSound() {
        System.out.println("The cat says: Meow Meow");
    }
}

// Main Class
public class AnimalApp {
    public static void main(String[] args) {
        // Create instances
        Dog dog1 = new Dog();
        Cat cat1 = new Cat();

        // Use instances of Dog and Cat
        dog1.makeSound();
        cat1.makeSound();
    }
}
~~~
## 🙂 Solution

The "Animal" class implements the Prototype pattern using a "clone()" method. The "Dog" and "Cat" classes inherit from "Animal" and provide their own implementation of the abstract method "makeSound()". Then, objects of Dog and Cat are created using the new keyword, and the objects are cloned using the clone() method implemented in the Animal class. The cloned objects can be used in the same way as the original objects.

~~~java
import java.util.HashMap;
import java.util.Map;

// Abstract prototype class
abstract class Animal implements Cloneable {
    protected String type;

    public Animal(String type) {
        this.type = type;
    }

    public abstract void makeSound();

    @Override
    public Animal clone() {
        try {
            return (Animal) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// Concrete class that implements the prototype
class Dog extends Animal {
    public Dog() {
        super("Dog");
    }

    @Override
    public void makeSound() {
        System.out.println("The dog says: Woof Woof");
    }
}

// Concrete class that implements the prototype
class Cat extends Animal {
    public Cat() {
        super("Cat");
    }

    @Override
    public void makeSound() {
        System.out.println("The cat says: Meow Meow");
    }
}

// Class that uses the Prototype pattern
public class AnimalPrototype {
    private static Map<String, Animal> animals = new HashMap<>();

    static {
        // Create prototype objects and add them to the map
        Dog dog = new Dog();
        Cat cat = new Cat();
        animals.put("Dog", dog);
        animals.put("Cat", cat);
    }

    public static Animal getAnimal(String type) {
        // Get the prototype object from the map and clone it
        Animal animal = animals.get(type);
        if (animal != null) {
            return animal.clone();
        }
        return null;
    }

    public static void main(String[] args) {
        // Get cloned objects and use them
        Animal dog1 = getAnimal("Dog");
        Animal dog2 = getAnimal("Dog");
        Animal cat1 = getAnimal("Cat");
        Animal cat2 = getAnimal("Cat");

        dog1.makeSound();
        dog2.makeSound();
        cat1.makeSound();
        cat2.makeSound();
    }
}
~~~