## Open/Closed

This principle tells us that all software entities are open to extension and closed to modification. What is meant is that if  we  are going to perform new functions to the class, we should not touch the code that is already established, because we could create potential errors every time we make modifications to the existing code. 
Take for example the following class:

```Java
class Car {
    String mark;

    Car(String brand){ this.brand = brand; }

    String getCarMake(){ return make; }
}
```

### Bad example:

Wanting to implement the iteration of a list of cars saved in an array, and print their brands, we have the following implementation:

```Java
public static void main(String[] args) {
    Car[] arrayCars = {
    newCar("Renault"),
                new Car("Audi")
        };
        printPriceMediumCar(arrayCars);
    }
   
    public static void printPriceMediumCar(Car[] arrayCars){
    for (Car Car : arrayCars) {
    if(Car.brand.equals("Renault"))System.out.println(18000);
    if(Car.brand.equals("Audi"))System.out.println(25000);
        }
    }
```
We can see that this implementation does not comply with the principle, since if you needed to add a new car, we would have to modify the code of the method printPriceMediumCar. When you want to add a new cart, you would have to be modifying the method mentioned above.

### Good example:

In order to comply with the principle, the following is implemented:

```Java
abstract class Car {
    // ...
    abstract int priceMediumCar ();
}

class Renault extends Car {
    @Override
    int priceMediumCar () { return 18000; }
}

class Audi extends Car {
    @Override
    int priceMediumCar () { return 25000; }
}

class Mercedes extends Car {
    @Override
    int priceMediumCar () { return 27000; }
}

public static void main(String[] args) {

Car[] arrayCars = {
            new Renault(),
            new Audi(),
            new Mercedes()
    };

    printPriceMediumCar(arrayCars);
}

public static void printPriceMediumCar(Car[] arrayCars){
    for (Car Car : arrayCars) {
        System.out.println(Car.priceMediumCar());
    }
}
```
Now, with this implementation, each car extends the Cart abstract class and implements the priceMediumCarprice abstract method. Thus, each cart has its own implementation of the abstract method, so  the printMediumCart method is only responsible for iterating in the car array and only calls the priceMediumCart method. If  a new cart is added, MedioCarro price will  not have to be modified, only the new cart will have to be added to the arrangement.  

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)