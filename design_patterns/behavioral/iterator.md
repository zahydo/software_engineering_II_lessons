# Iterator

The Iterator design pattern is a behavioral design pattern used to provide an efficient and standardized way to access and iterate through elements in a collection of objects without exposing the collection's internal structure. This pattern is based on separating the access and traversal responsibilities of collection elements from the structure of the collection itself. Instead of allowing the client to directly access the elements of the collection, the Iterator provides an object that is responsible for traversing the collection and providing access to each element in a controlled manner. The Iterator is typically implemented by an interface that defines the methods needed to traverse the collection, such as "hasNext()" and "next()". The collection, in turn, must provide a method that returns an Iterator object that the client can use to loop through the elements. This pattern is especially useful in situations where the collection structure changes frequently or when you want to loop through a collection in a custom fashion without having to modify the collection structure. Additionally, using an Iterator can improve application performance by allowing access to collection items to be performed more efficiently.


[TODO ejemplo]
Suppose we have a "Library" class that stores a list of books and we want to traverse this list of books without exposing the internal structure of the list to the client. To do this, we define an "Iterator" interface that defines the methods needed to traverse the list of books and a "LibreriaIterator" class that implements this interface:
~~~java
// Interfaz Iterator
public interface Iterator {
    public boolean hasNext();
    public Object next();
}

// Clase LibreriaIterator
public class LibreriaIterator implements Iterator {
    private Libro[] libros;
    private int posicion;

    public LibreriaIterator(Libro[] libros) {
        this.libros = libros;
        this.posicion = 0;
    }

    public boolean hasNext() {
        return posicion < libros.length && libros[posicion] != null;
    }

    public Object next() {
        Libro libro = libros[posicion];
        posicion++;
        return libro;
    }
}
~~~
Then, in the "Library" class we define a "createIterator()" method that returns an "Iterator" object that the client can use to iterate through the elements of the list of books:
~~~java
// Clase Libreria
public class Libreria {
    private Libro[] libros;

    public Libreria() {
        libros = new Libro[10];
        libros[0] = new Libro("El principito");
        libros[1] = new Libro("Cien años de soledad");
        libros[2] = new Libro("La casa de los espíritus");
        libros[3] = new Libro("El nombre de la rosa");
        libros[4] = new Libro("Rayuela");
        libros[5] = new Libro("Pedro Páramo");
        libros[6] = new Libro("Crónica de una muerte anunciada");
        libros[7] = new Libro("La ciudad y los perros");
        libros[8] = new Libro("La fiesta del chivo");
        libros[9] = new Libro("La muerte de Artemio Cruz");
    }

    public Iterator crearIterator() {
        return new LibreriaIterator(libros);
    }
}
~~~
Finally, the client can use the "Iterator" object to iterate through the list of books without having to know the internal structure of the list:
~~~java
// Cliente
public class Cliente {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Iterator iterator = libreria.crearIterator();
        while (iterator.hasNext()) {
            Libro libro = (Libro) iterator.next();
            System.out.println(libro.getTitulo());
        }
    }
}
~~~
In this example, the Iterator design pattern allows us to traverse the list of books in a controlled manner and without exposing the internal structure of the list to the client.

# Diagrama Iterator

![Diagrama Iterator](.png)