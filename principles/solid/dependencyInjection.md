## Dependency Injection

The principle of dependency inversion refers to the decoupling of software modules. 
This way, instead of high-level modules depending on low-level modules, both will depend on abstractions.

Consider the example below. We have a Car class that depends on the concrete Engine class; therefore, it is not obeying DIP.

### Bad example

    public class Car {
        private Engine engine;

        public Car(Engine e) {
            engine = e;
        }

        public void start() {
            engine.start();
        }
    }

    public class Engine {
        public void start() {...}
    }

The code will work, for now, but what if we wanted to add another engine type, let’s say a diesel engine? 
This will require refactoring the Car class. However, we can solve this by introducing a layer of abstraction. 
Instead of Car depending directly on Engine, let’s add an interface:

### Good example

    public interface Engine {
        public void start();
    }

Now we can connect any type of Engine that implements the Engine interface to the Car class:

    public class Car {
        private Engine engine;

        public Car(Engine e) {
            engine = e;
        }

        public void start() {
            engine.start();
        }
    }
    public class PetrolEngine implements Engine {
        public void start() {...}
    }
    public class DieselEngine implements Engine {
        public void start() {...}
    }

### Related principles

- Interface Segregation

### Related patterns

- Separation of Concerns
- Composition Over Inheritance
- Code For The Maintainer
- Boy-Scout Rule

---
[Back to the list](./README.md)