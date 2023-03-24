## Liskov Substitution

"Derived classes must be substitutable for their base classes." 
This means that a subclass must be substitutable for its superclass, and if by doing this, the program fails, we will be violating this principle. So, if class B is of a subtype of class A, then we should be able to replace A with B without affecting the behavior of our program.

### Bad example:

// ...
public static void imprimirNumAsientos(Auto[] arrayAutos){  
    for (Auto auto : arrayAutos) {
        if(auto instanceof BMW)
            System.out.println(numAsientosBMW(auto));
        if(auto instanceof Mercedes)
            System.out.println(numAsientosMercedes(auto));
        if(auto instanceof Audi)
            System.out.println(numAsientosAudi(auto));
    }
}
imprimirNumAsientos(arrayAutos);  

This violates the Liskov substitution principle as well as the open/closed principle. The program must know each type of Auto and call its associated numSeats() method. Thus, if we add a new car, the method must be modified to accept it.
In order to comply with the principle, these principles must be followed:
- If the superclass (Auto) has a method that accepts a parameter of the type of the superclass (Auto), then its subclass (BMW) should accept as an argument a type of the superclass (Auto) or a type of the subclass (BMW).
- If the superclass returns a type of itself (Auto), then its subclass (BMW) should return a type of the superclass (Auto) or a type of the subclass (BMW). 

### Good example:

Re-implementing the above method we have:

public static void imprimirNumAsientos(Auto[] arrayAutos){  
        for (Auto auto : arrayAutos) {
            System.out.println(auto.numAsientos());
        }
    }

imprimirNumAsientos(arrayAutos);  

Now the method does not care about the type of the class, it simply calls the numSeats() method of the superclass. It only knows that the parameter is of type auto, either Auto or one of the subclasses. For this, now the Auto class must define the new method:

abstract class Auto {

    // ...
    abstract int numAsientos();
}

And the subclasses must implement this method:

class BMW extends Auto {

    // ...
    @Override
    int numAsientos() {
        return 4;
    }
}
// ...

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)