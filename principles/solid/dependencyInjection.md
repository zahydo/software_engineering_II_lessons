## Dependency Injection

Dependency Injection is a software design pattern used to improve modularity and flexibility of an application. Instead of creating objects within a class, the dependency is passed through an interface.

The basic principle of Dependency Injection is that a class should not create its dependencies, but should receive them from an external source. In other words, dependent classes should be constructed from their dependencies, rather than building their own dependencies. This makes the code more modular and easier to maintain.

### Bad example

Let's say we have a Java class called Car that requires an instance of the Engine class to operate. Without using Dependency Injection, we could construct an instance of Engine directly inside the Car class, as shown below:

´´´
public class Car {
   private Engine engine;
  
   public Car() {
      // create an instance of Engine directly in the Car constructor
      this.engine = new Engine();
   }
  
   public void start() {
      engine.start();
      // other car start-up code
   }
}
´´´

In this example, the Car class constructs an instance of Engine directly inside the constructor. This means that the Car class has a strong dependency on the Engine class, which can make it difficult to modify the class in the future.

For example, if we wanted to use an ElectricEngine class instead of the Engine class in the future, we would have to modify the Car class to create an instance of ElectricEngine instead of Engine. This can be tedious and error-prone, especially if the Car class is used in many parts of the application.

### Good example

´´´
public class Car {
   private Engine engine;
  
   public Car(Engine engine) {
      this.engine = engine;
   }
  
   public void start() {
      engine.start();
      // other car start-up code
   }
}
´´´

Engine engine = new Engine();
Car car = new Car(engine);
car.start();

Now, if in the future we want to use an ElectricEngine class instead of the Engine class, we can simply create an instance of ElectricEngine and pass it to the constructor of the Car class, without having to modify the Car class itself.

This is a more flexible and modular way to implement the functionality of Car using Dependency Injection in Java.

### Related principles

- [Composition over inheritance][../general/compositionoverinheritance.md] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)

