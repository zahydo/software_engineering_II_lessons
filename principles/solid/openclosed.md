## Open/Closed

This principle states that: "You should be able to extend a classes behavior, without modifying it".
From the above it can be said that each class should be open for extension, but closed for modification.
Understanding modification as changes in the code of an existing class and extension as the addition of new functionality. So, what this principle means is that we should be able to add new functionality without touching the existing code for a class.

### Bad example:

class Auto {  
    String marca;
    String modelo;
    String color;

    Auto(String marca, String modelo, String color){ 
        this.marca = marca; 
        this.modelo = modelo; 
        this.color = color; 
    }

    String getMarcaAuto(){ 
        return marca;
    }
    String getModeloAuto(){ 
        return marca;
    }
    String getColorAuto(){ 
        return marca;
    }
}

public static void main(String[] args) {  
    Auto[] arrayAutos = {
            new Auto("BMW"),
            new Auto("Mercedes")
    };
    imprimirPrecioAuto(arrayAutos);
}

public static void imprimirPrecioAutos(Auto[] arrayAutos){  
    for (Auto auto : arrayAutos) {
        if(auto.marca.equals("BMW")) System.out.println(34000);
        if(auto.marca.equals("Mercedes")) System.out.println(28000);
    }
}

Starting from the class Auto if we want to iterate from a list of cars and print their brands we would have what we have seen before but with this code we would be in breach of the open/closed principle. with this code we would be violating the open/closed principle because if we want to add a car of another brand as shown below:


Auto[] arrayAutos = { 
    new Auto("BMW"),
    new Auto("Mercedes"),
    new Auto("Audi")  
};

The method printPriceAutos should also be modified as follows: 

public static void imprimirPrecioAutos(Auto[] arrayAutos){  
    for (Auto auto : arrayAutos) {
        if(auto.marca.equals("BMW")) System.out.println(34000);
        if(auto.marca.equals("Mercedes")) System.out.println(28000);
        if(auto.marca.equals("Audi")) System.out.println(24000);
    }
}

### Good example:

To correct all of the above, the following could be done: 

abstract class Auto {  
    // ...
    abstract int precioAuto();
}

class BMW extends Auto {  
    @Override
    int precioAuto() { return 34000; }
}

class Mercedes extends Auto {  
    @Override
    int precioAuto() { return 28000; }
}

class Audi extends Auto {  
    @Override
    int precioAuto() { return 24000; }
}

public static void main(String[] args) {

    Auto[] arrayAutos = { 
            new BMW(),
            new Mercedes(),
            new Audi()
    };

    imprimirPrecioAutos(arrayAutos);
}

public static void imprimirPrecioAutos(Auto[] arrayAutos){  
    for (Auto auto : arrayAutos) {
        System.out.println(auto.precioAuto());
    }
}

Each car extends the abstract class Auto and implements the abstract method priceAuto(). Thus, each car has its own implementation of the priceAuto() method, so the printPriceAuto() method iterates the array of cars and just calls the priceAuto() method. Now, if we add a new car, the precioAuto() method will not have to be modified. will not have to be modified. We will just have to add the new car to the array, thus fulfilling the open/closed principle.

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)