## Open/Closed

The Open/Closed Principle (OCP) is a software design principle that states that a software entity (for example, a class, module, or function) should be open for extension, but closed for modification.

This means that it must be possible to extend or extend the functionality of a software entity without having to modify its original source code. In other words, a software entity must be designed in such a way that new features or behavior can be added without having to change existing code.

### Bad example:
Suppose we have a Calculator class that has a calculate() method that performs simple arithmetic operations. We also have a requirement to add a new functionality that calculates the square of a number. Instead of extending existing functionality, the original code is directly modified to add the new functionality. This violates the Open/Closed principle as the original code was directly modified rather than extended.

```
class Calculadora:
    def calcular(self, operacion, num1, num2):
        if operacion == "suma":
            return num1 + num2
        elif operacion == "resta":
            return num1 - num2
        elif operacion == "multiplicacion":
            return num1 * num2
        elif operacion == "division":
            return num1 / num2
        elif operacion == "cuadrado":
            return num1 ** 2  # Se modifica directamente el código original

resultado = Calculadora().calcular("cuadrado", 5, None)  # Calcula el cuadrado de 5
print(f"El resultado es: {resultado}")

```

### Good example:

Suppose we have a Shape class that has a calculateArea() method and two subclasses, Rectangle and Circle, which inherit from Shape and override the calculateArea() method to calculate the area of ​​each specific geometric shape. We can apply the Open/Closed principle as follows:

```
class Forma:
    def calcularArea(self):
        pass

class Rectangulo(Forma):
    def __init__(self, ancho, alto):
        self.ancho = ancho
        self.alto = alto

    def calcularArea(self):
        return self.ancho * self.alto

class Circulo(Forma):
    def __init__(self, radio):
        self.radio = radio

    def calcularArea(self):
        return 3.14 * self.radio ** 2

def calcularAreaTotal(formas):
    areaTotal = 0
    for forma in formas:
        areaTotal += forma.calcularArea()
    return areaTotal

# Creamos objetos de las clases Rectangulo y Circulo y los pasamos a la función calcularAreaTotal
rectangulo = Rectangulo(4, 5)
circulo = Circulo(3)

areaTotal = calcularAreaTotal([rectangulo, circulo])  # Calcula el área total de ambas formas
print(f"El área total es: {areaTotal}")

```

### Related principles

- Single Responsability
- Liskov Substitution 

### Related patterns

- Code For The Maintainer
- Boy-Scout Rule

---
[Back to the list](./README.md)