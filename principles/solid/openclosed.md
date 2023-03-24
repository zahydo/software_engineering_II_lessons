## Open/Closed

It establishes that software entities (classes, modules and functions) should be open for extension, but closed for modification.

Continuing with the Car class:

```JAVA:
    class Car {
        String mark;

        Car(String make){ this.make = make; }

        String getCarMake(){ return make; }
     }
```

### Bad example:

If we wanted to iterate through a list of cars and print their makes to the screen:

```JAVA:
    public static void main(String[] args) {
        Car[] arrayCars = {
            new Car("Renault"),
            new Car("Audi")
        };
        printAverageCarPrice(arrayCars);
    }

    public static void printAveragePriceCar(Car[] arrayCars){
        for (Car car : arrayCars) {
            if(car.make.equals("Renault")) System.out.println(18000);
            if(car.make.equals("Audi")) System.out.println(25000);
        }
    }
```

This would not comply with the open/closed principle, since if we decided to add a new car from another brand we would also have to modify the method we created earlier.

### Good example:

To comply with this principle we could do the following:

```JAVA:
    abstract class Car {
        // ...
        abstract int averageCarPrice();
    }

    class Renault extends Car {
        @Override
        int MediaCarPrice() { return 18000; }
    }

    class Audi extends Car {
        @Override
        int MediaCarPrice() { return 25000; }
    }

    class Mercedes extends Car {
        @Override
        int MediaCarPrice() { return 27000; }
    }

    public static void main(String[] args) {

        Car[] arrayCars = {
            newRenault(),
            newAudi(),
            newMercedes()
        };

        printAverageCarPrice(arrayCars);
    }

    public static void printAveragePriceCar(Car[] arrayCars){
        for (Car car : arrayCars) {
            System.out.println(car.AverageCarPrice());
        }
    }
```

Each car extends the abstract class Car and implements the abstract method averageCarPrice(). Thus, each car has its own implementation of the method averageCarPrice(), so the method printAverageCarPrice() iterates the array of cars and only calls the method averageCarPrice().

Now, if we add a new car, averageCarPrice() will not have to be modified. We will only have to add the new car to the array, thus fulfilling the open/closed principle

### Related principles

- Do the Simplest Thing That Could Possibly Work
- Composition Over Inheritance

---
[Back to the list](./README.md)