## Liskov Substitution

It declares that a subclass must be replaceable by its superclass, and if by doing this, the program crashes, we will be violating this principle.

Adhering to this principle will confirm that our program has an easy-to-understand class hierarchy and reusable code.

### Bad example:

```JAVA:
    public static void printNumSeats(Car[] arrayCars){
    for (Car car : arrayCars) {
        if(instanceof Renault car)
            System.out.println(numSeatsRenault(car));
        if(instanceof Audi car)
            System.out.println(numSeatsAudi(car));
        if(instanceof Mercedes car)
            System.out.println(numSeatsMercedes(car));
    }
    }
    printNumSeats(arrayCars);
```

This violates both the Liskov substitution principle and the open/closed principle. The program must know each type of Car and call its associated numSeats() method. So if we add a new car, the method must be modified to accept it.

### Good example:

For this method to comply with the principle, we will follow these principles:

- If the superclass (Car) has a method that accepts a parameter of the type of the superclass (Car), then its subclass
  (Renault) should accept a type of the superclass (Car) or a type of the subclass (Renault) as its argument.
- If the superclass returns a type of itself (Car), then its subclass (Renault) should either return a type of the
  superclass (Car) or a type of the subclass (Renault).

```JAVA:
    abstract class Car {

        // ...
        abstract int numSeats();
    }

    class Renault extends Car {

        // ...
        @Override
        int numSeats() {
            return 5;
        }
    }
    // ...

    public static void printNumSeats(Car[] arrayCars){
            for (Car car : arrayCars) {
                System.out.println(car.numSeats());
            }
        }

    printNumSeats(arrayCars);
```

As we can see, now the printNumSeats() method does not need to know what type of car it is going to perform its logic with, it simply calls the numSeats() method of the Car type, since by contract, a subclass of Car must implement said method.

### Related principles

- Do the Simplest Thing That Could Possibly Work
- Composition Over Inheritance
- KISS

---
[Back to the list](./README.md)