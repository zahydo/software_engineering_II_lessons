## Liskov Substitution

The Liskov substitution principle says that if class A is a subtype of the
class B, then we should be able to replace B with A without affecting the
behavior of our program.

### Bad example:
~~~JAVA:
public class Animal {
    public boolean esCarnivoro() {
        return true;
    }
}

public class Perro extends Animal {
    @Override
    public boolean esCarnivoro() {
        return false;
    }
}
~~~
### Good example:
~~~JAVA:
public class Figura {
    public int area() {
        return 0;
    }
}

public class Circulo extends Figura {
    private int radio;
    
    public Circulo(int radio) {
        this.radio = radio;
    }
    
    public int getRadio() {
        return radio;
    }
    
    @Override
    public int area() {
        return (int) (Math.PI * Math.pow(radio, 2));
    }
}

public class Cuadrado extends Figura {
    private int lado;
    
    public Cuadrado(int lado) {
        this.lado = lado;
    }
    
    public int getLado() {
        return lado;
    }
    
    @Override
    public int area() {
        return lado * lado;
    }
}
~~~

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)