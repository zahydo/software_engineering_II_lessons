## Liskov Substitution

The Liskov substitution principle is an important principle of object-oriented programming that states that, in a software program, if S is a subtype of T, then objects of type T can be replaced with objects of type S without altering program correction.

In other words, if a class A is a subclass of a class B, then objects of class A must be able to seamlessly replace objects of class B in any context where objects of class B are expected to appear, without affecting the behavior of the program.

This principle ensures that objects of a derived class or subclass are compatible with objects of the base class or superclass and that inheritance is used correctly. Violation of this principle can lead to errors and unexpected behavior in the program.


### Bad example:

Suppose we have a Rectangle class that has two attributes width and height and an area() method that calculates the area of ​​the rectangle. We also have a subclass Square that inherits from Rectangle and overrides the area() method to calculate the area of ​​a square based on its side length. However, the code violates the Liskov Substitution principle, since a Square object does not behave in the same way as a Rectangle object, and the area() method does not behave as expected when working with objects of the subclass Square.

```
class Rectangulo:
    def __init__(self, ancho, alto):
        self.ancho = ancho
        self.alto = alto

    def area(self):
        return self.ancho * self.alto

class Cuadrado(Rectangulo):
    def __init__(self, lado):
        self.ancho = lado
        self.alto = lado

    def area(self):
        return self.ancho ** 2

def imprimirArea(rectangulo):
    print(f"El área es: {rectangulo.area()}")

# Creamos un objeto de la clase Rectangulo y otro de la clase Cuadrado
rectangulo = Rectangulo(4, 5)
cuadrado = Cuadrado(5)

imprimirArea(rectangulo)  # Imprime "El área es: 20"
imprimirArea(cuadrado)  # Imprime "El área

```
### Good example:

Suppose we have a class Animal that has a makeSound() method and two subclasses, Dog and Cat, which inherit from Animal and override the makeSound() method to produce the characteristic sounds of each animal. We can use the Liskov Substitution principle as follows:
```
class Animal:
    def hacerSonido(self):
        pass

class Perro(Animal):
    def hacerSonido(self):
        return "Guau!"

class Gato(Animal):
    def hacerSonido(self):
        return "Miau!"

def hacerSonarAnimal(animal):
    print(animal.hacerSonido())

# Creamos objetos de las clases Perro y Gato y los pasamos al método hacerSonarAnimal
perrito = Perro()
gatito = Gato()

hacerSonarAnimal(perrito)  # Imprime "Guau!"
hacerSonarAnimal(gatito)  # Imprime "Miau!"

```

### Related principles

- Open/Closed

### Related patterns

- Code For The Maintainer
- Boy-Scout Rule

---
[Back to the list](./README.md)