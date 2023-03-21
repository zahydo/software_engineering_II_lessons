## Liskov Substitution

We should be able to use a child class to replace a parent class without getting errors.

### Bad example:

The Square class inherits from the Shape class and redefines the calculateArea() method. However, the implementation of the calculateArea() method in Square does not comply with the definition of a square, since a square has all its sides equal. Therefore, passing an instance of Square to the printArea() method will result in an incorrect result.

```Kotlin
class Shape {
    fun calculateArea(): Double {
         return 0.0
    }
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun calculateArea(): Double {
        return width * height
    }
}

class Square(val side: Double) : Shape() {
    override fun calculateArea(): Double {
        return side * side
    }
}

fun printArea(shape: Shape) {
    val area = shape.calculateArea()
    println("El area es: $area")
}
```

### Good example:

The Square class is modified to inherit from the Rectangle class and the implementation of the calculateArea() method in Square is eliminated. This ensures that the implementation of Square complies with the definition of a square, since Square inherits the implementation of the calculateArea() method of Rectangle. By doing this, it does not violate the Liskov Substitution Principle (LSP), since instances of Square can be used in place of instances of Rectangle without affecting the result of the program.

```Kotlin
 class Shape {
     fun calculateArea(): Double {
        return 0.0
    }
}

 class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun calculateArea(): Double {
        return width * height
    }
}

class Square(side: Double) : Rectangle(side, side)

fun printArea(shape: Shape) {
    val area = shape.calculateArea()
    println("El area es: $area")
}
```

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)