## Interface Segregation

This principle states that clients should not be forced to depend on interfaces they do not use.

In other words, when a client depends on a class that implements an interface whose functionality this client does not use, but which other clients do use, this client will be affected by changes forced by other clients on that interface.

### Bad example:

```JAVA:
    interface IAve {
        void fly();
        void eat();
    }

    class Parrot implements IAve{

        @Override
        public void fly() {
            //...
        }

        @Override
        public void eat() {
            //..
        }
    }

    class Tucan implements IAve{
        @Override
        public void fly() {
            //...
        }

        @Override
        public void eat() {
            //..
        }
    }
```

Now let's imagine we want to add the penguins. These are birds, but they also have the ability to swim. The problem is that the parrot doesn't swim, and the penguin doesn't fly, so we'd have to add an exception or warning if we try to call these methods. Furthermore, if we wanted to add another method to the IAve interface, we would have to go through each of the classes that implement it and add the implementation of said method in all of them. This violates the principle of interface segregation, since these classes (the clients) don't have to depend on methods they don't use.

### Good example:

The most correct thing would be to further segregate the interfaces, as much as necessary. In this case we could do the following:

```JAVA:
    interface IAve {
        void eat();
    }
    interface FlyingBird {
        void fly();
    }

    interface IAveSwimmer {
        void swim();
    }

    class Parrot implements Bird AI, Flying AI Bird {

        @Override
        public void fly() {
            //...
        }

        @Override
        public void eat() {
            //...
        }
    }

    class Penguin implements IAve, AISwimmer{

        @Override
        public void swim() {
            //...
        }

        @Override
        public void eat() {
            //...
        }
    }
```

Thus, each class implements the interfaces of the one that actually needs to implement its methods. When adding new features, this will save us a lot of time, and also, we comply with the first principle (Sole Responsibility).

### Related principles

- Do the Simplest Thing That Could Possibly Work
- YAGNI
- Avoid Premature Optimization

---
[Back to the list](./README.md)