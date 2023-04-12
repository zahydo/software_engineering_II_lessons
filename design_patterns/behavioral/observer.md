# Observer

Is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

Imagine that you have two types of objects: a Customer and a Store. The customer is very interested in a particular brand of product (say, it’s a new model of the iPhone) which should become available in the store very soon.

The customer could visit the store every day and check product availability. But while the product is still en route, most of these trips would be pointless.

On the other hand, the store could send tons of emails (which might be considered spam) to all customers each time a new product becomes available. This would save some customers from endless trips to the store. At the same time, it’d upset other customers who aren’t interested in new products.

It looks like we’ve got a conflict. Either the customer wastes time checking product availability or the store wastes resources notifying the wrong customers.

The object that has some interesting state is often called subject, but since it’s also going to notify other objects about the changes to its state, we’ll call it publisher. All other objects that want to track changes to the publisher’s state are called subscribers.

The Observer pattern suggests that you add a subscription mechanism to the publisher class so individual objects can subscribe to or unsubscribe from a stream of events coming from that publisher. Fear not! Everything isn’t as complicated as it sounds. In reality, this mechanism consists of:
- an array field for storing a list of references to subscriber objects and 
- several public methods which allow adding subscribers to and removing them from that list.

## Class Diagram of example:

![ClassDiagram](http://www.plantuml.com/plantuml/png/hL7BQeKm4DtdAx9Kn1y8HIwKxWejk2nTvCRHMZHUCcDfAVttniUWXWOtNGWwSnvpZXSaxMZiEz5Q0bTh0x8Sh-zWI7wBJ1DfyvOCLmJt0Kx9f_Kj5La5yPqTgAs_U819Adx4pe4NayLugpJ1WZ2THfJtWpKE2BOxye6Lb7niaUvOe12v3q2Wf1SNMGDKqgos3f076ohztrJ1pRjaEIxtgp2Go49q4eEcntwuaRpOAbHoFgi5b8K8gykFo5xx0lopX_9wnePy9HTxJ-2aZ7_MHE3imwVkRnrCVt9IJxHhKCcIN6kRbzVvwWZZJpl_kTgTinXne0MI4Ro36XnOSrfQuExxG8YqTqwwWAt6lli5)

## Example

In this example the Subject interface that defines the methods to attach, detach, and notify observers.

```Java

import java.util.ArrayList;
import java.util.List;

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

```

The ConcreteSubject class that implements the Subject interface and maintains a list of observers.

```Java

class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
```

The Observer interface that defines the update method that the observers implement.
```Java

interface Observer {
    void update();
}
```
The ConcreteObserver class that implements the Observer interface and maintains a reference to the subject.
```java

class ConcreteObserver implements Observer {
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        int state = subject.getState();
        System.out.println("Observer: State changed to " + state);
    }
}
```
When the update method is called, it retrieves the current state of the subject and displays a message indicating that the state has changed.

The main class that uses the Observer pattern.
Finally, the ObserverPatternExample class demonstrates how to use the Observer pattern. It creates a ConcreteSubject object and two ConcreteObserver objects. It attaches both observers to the subject and then updates the state twice. After the second update, it detaches one of the observers and updates the state again.

```Java
public class ObserverPatternExample {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver observer1 = new ConcreteObserver(subject);
        ConcreteObserver observer2 = new ConcreteObserver(subject);

        subject.attach(observer1);
        subject.attach(observer2);

        subject.setState(1);

        subject.detach(observer2);

        subject.setState(2);
    }
}
```
[Back](../behavioral/README.md)