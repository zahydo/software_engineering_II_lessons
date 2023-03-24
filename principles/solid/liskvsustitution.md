## Liskov Substitution

Liskov's substitution principle states that any object of a child class should be able to be used in place of an object of the parent class without problems. This ensures safety in class inheritance and makes the code more flexible and scalable.

### Bad example:

In the bad example, the child class "Dog" has an additional method that is not present in the parent class, which violates Liskov's substitution principle and may cause runtime errors when trying to use objects of the class "Dog" as if they were objects of the class "Animal".

```Java
public class Animal {
   public void makeSound() {
      System.out.println("An animal makes a sound");
   }
}

public class Dog extends Animal {
   public void makeSound() {
      System.out.println("A dog barks");
   }

   public void bite() {
      System.out.println("The dog bites");
   }
}

public class Main {
   public static void main(String[] args) {
      Animal myAnimal = new Animal();
      Animal myDog = new Dog();
      Dog myDog2 = new Dog();

      myAnimal.makeSound(); // Prints "An animal makes a sound"
      myDog.makeSound(); // Prints "A dog barks"
      myDog2.bite(); // Prints "The dog bites"

      Animal myNewDog = new Animal();
      myNewDog = myDog2;
      myNewDog.makeSound(); // Prints "A dog barks"
      myNewDog.bite(); // This generates a runtime error
   }
}
```

### Good example:

The child class "Dog" replaces the "makeSound()" method of the parent class "Animal" with an implementation of its own that fulfills the same expected behavior. This means that objects of the class "Dog" can be safely used instead of objects of the class "Animal". Liskov's substitution principle is fulfilled, which makes the code safer and more flexible.

```Java
public class Animal {
   public void makeSound() {
      System.out.println("An animal makes a sound");
   }
}

public class Dog extends Animal {
   public void makeSound() {
      System.out.println("A dog barks");
   }
}

public class Main {
   public static void main(String[] args) {
      Animal myAnimal = new Animal();
      Animal myDog = new Dog();

      myAnimal.makeSound(); // Prints "An animal makes a sound"
      myDog.makeSound(); // Prints "A dog barks"
   }
}
```

### Related principles

- [Separation of Concerns](../../principles/general/separationofconcerns.md)
- [Code For The Maintainer](../../principles/general/codeformantainer.md)

### Related patterns

- DRY (Don't Repeat Yourself)
- Composition Over Inheritance

---

[Back to the list](./README.md)
