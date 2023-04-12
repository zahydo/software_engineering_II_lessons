# Observer pattern

The Observer pattern is a design pattern that establishes a one-to-many relationship between objects, such that when an object (subject) changes its state, all its dependents (observers) are automatically notified and updated.

This pattern is useful for maintaining synchronization and consistency between related objects without them being tightly coupled, facilitating scalability, maintainability and modularity of the code.

<p align="center">
<img src="https://res.cloudinary.com/dzxhdnqm4/image/upload/v1681008518/UML_Observer_aczpve.png" alt="uml-observer" width="70%">
</p>

## 😟 Problem

Imagine that you are developing an application where multiple components need to be notified of state changes. In this scenario, not implementing the Observer pattern would result in tight coupling, difficulties in adding or modifying observers, and code duplication. Consequently, the code would become less flexible, harder to maintain, and more error-prone.

```java
public class ConcreteSubject {
    private List<ConcreteObserver> observers;
    private String state;

    public ConcreteSubject() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(ConcreteObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ConcreteObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (ConcreteObserver observer : observers) {
            observer.update(state);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}
```

```Java
public class ConcreteObserver {
    private String observerName;

    public ConcreteObserver(String observerName) {
        this.observerName = observerName;
    }

    public void update(String message) {
        System.out.println(observerName + " received message: " + message);
    }
}
```

The `ConcreteSubject` and `ConcreteObserver` classes are directly coupled, which causes the aforementioned problems related to coupling, difficulty in adding or modifying observers and code duplication.

## 🙂 Solution

To solve this problem, we can implement the Observer pattern using interfaces for `Subject` and `Observer`.

This allows decoupling the `ConcreteSubject` and `ConcreteObserver` classes, which facilitates the addition or modification of observers and avoids code duplication. The Observer pattern also improves code flexibility and maintainability, since changes to the `Subject` or `Observer` will not directly affect the other parts of the code.

```Java
// Interfaz Observer
public interface Observer {
    void update(String message);
}

// Interfaz Subject
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
```

For this example we have two interfaces:
`Observer` and `Subject` interfaces.

The `Observer` interface, which defines the update method to be implemented by all observers.

The `Subject` interface, which defines the methods for adding, removing and notifying observers.

```java
public class ConcreteSubject implements Subject {
    private List<Observer> observers;
    private String state;

    public ConcreteSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}
```

The `ConcreteSubject` class, which implements the `Subject` interface, maintains a list of observers and notifies all observers when their status changes.

```java
public class ConcreteObserver implements Observer {
    private String observerName;

    public ConcreteObserver(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(String message) {
        System.out.println(observerName + " received message: " + message);
    }
}
```

The `ConcreteObserver` class, which implements the `Observer` interface and performs some action when it receives a notification.

```java
public class ObserverPatternExample {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver observer1 = new ConcreteObserver("Observer 1");
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.setState("New State 1");
        subject.setState("New State 2");
    }
}
```

The `ObserverPatternExample` class contains the main method, which creates an instance of `ConcreteSubject`, adds two observers and changes the state of the subject to demonstrate how observers are notified.
