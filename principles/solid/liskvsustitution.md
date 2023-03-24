## Liskov Substitution

This principle states that a subclass must be substitutable for its superclass. That means that given classes A (superclass) and B (subclass), you should be able to pass an object of class B to any method that expects an object of class A and you would not drink any kind of inconvenience. 
This is the behavior that would be expected when using inheritance, because when using it, we assume that the base class inherits all the attributes and methods that the superclass has. 

### Bad example:

```Java
// ...
public static void printNumSeats(Car[] arrayCars){
    for (Car car : arrayCars) {
        if(car instanceof Renault)
            System.out.println(numSeatsRenault(car));
        if(instanceof Audi car)
            System.out.println(numSeatsAudi(car));
        if(instanceof Mercedes car)
            System.out.println(numSeatsMercedes(car));
        }
    }
printNumSeats(arrayCars);
```
In the bad example, we can and that it is violating, both the principle of liskop, as the open/closed, since the program must know each type of Cart and calls its own method numSeats().
And in the open/closed one, if you want to add a new cart, you will have to modify the existing code. 

### Good example:

Correcting these errors, the printNumSaets() method would look like this:

```Java
public static void printNumSeats(Car[] arrayCars){
    for (Car car : arrayCars) {
        System.out.println(car.numSeats());
    }
}  
printNumSeats(arrayCars);
```
With this, the method is no longer interested in the type of class that comes to it as a parameter, now it will only call the numAseats() method of the superclass. All you know is that the parameter is of type carro, either of the superclass or of one of its derived classes.  
To do this, the Carriage class must define the numAseats() method:

```Java
abstract class Car {

    // ...
    abstract int numSeats();
}
```
And subclasses must implement it

```Java
class Renault extends Car {

    // ...
    @Override
    int numSeats() {
        return 5;
    }
}
```

Now the printNumSeats() method does not need to know with what type of cart it will implement its logic. 

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)