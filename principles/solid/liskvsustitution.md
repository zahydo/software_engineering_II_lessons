## Liskov Substitution

It is an object-oriented programming principle that states that if a class A is a subclass of a class B, then objects of class A should be able to be used anywhere objects of class B are expected, without affecting the correctness of the program.

### Bad example:

~~~java
class Animal {
    String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void makeSound() {
        // implementation details
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
        
    public void makeSound() {
        System.out.println("Bark bark!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
        
    public void makeSound() {
        System.out.println("Meow meow!");
    }
}

class Fish extends Animal {
    public Fish(String name) {
        super(name);
    }
        
    public void swim() {
        System.out.println("Swimming...");
    }
}
~~~

In this example, the Fish class is a subclass of the Animal class, but it introduces a swim() method that is not present in the base class. This violates the Liskov Substitution principle, as instances of Fish cannot replace instances of Animal in all situations. For example, if an object of type Animal is expected to make a sound, an error will occur if the makeSound() method is called on an instance of Fish.

### Good example:

~~~java
class Animal {
    String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void makeSound() {
        // implementation details
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
        
    public void makeSound() {
        System.out.println("Bark bark!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
        
    public void makeSound() {
        System.out.println("Meow meow!");
    }
}


~~~

In this example, all subclasses of Animal implement the same set of methods as the base class, and no new methods are added that can violate the Liskov Substitution principle. This means that instances of the subclasses can seamlessly replace instances of the base class in any situation.

### Related principles

* Composition Over Inheritance
* Separation of Concerns


### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)