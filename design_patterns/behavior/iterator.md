# Iterator pattern

Iterator is a behavioral design pattern that allows you to traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.).

The Iterator pattern is composed of two main elements: the iterator and the collection. The iterator is responsible for providing a method to access the elements of the collection one by one, while the collection is responsible for providing a method to obtain an iterator to traverse its elements.

## 🏗️ Estructure
<p align="center">
<img src="https://res.cloudinary.com/dz5pw4p7y/image/upload/v1681088167/design_patterns/iterator_pcy9mx.png" alt="mypic" width="75%">
</p>

## 😟 Problem

Imagine that we have a book shelf, which contains a list of books and we want to access each of the books correctly and efficiently.

```java
import java.util.ArrayList;

public class Bookshelf {

    private ArrayList<Book> books = new ArrayList<>();

    public Book getNextBook() {
        if (!books.isEmpty()) {
            Book book = books.get(0);
            books.remove(0);
            return book;
        } else {
            return null;
        }
    }
}
```

In this example, the `Bookshelf` class does not implement the `Iterator` interface nor does it provide a separate iterator class. Instead, it provides a single method called `getNextBook()` that iterates through the ArrayList of books and returns the next book.

This implementation violates the Iterator pattern because it does not provide a safe and consistent way to iterate through the ArrayList of books. For example, if the calling code calls `getNextBook()` more times than there are books in the list, the method will return `null` and the calling code may have run-time errors. Also, this implementation does not allow iterating over the list in reverse order or modifying the list while iterating.

## 🙂 Solution

To solve this, a separate `Iterator` interface should be implemented for the `Bookshelf` class, with the standard `hasNext()`, `next()` and `remove()` methods to iterate safely through the list of books.
```java
import java.util.ArrayList;
import java.util.Iterator;

public class Bookshelf implements Iterable<Book> {

    private ArrayList<Book> books = new ArrayList<>();

    private class BookIterator implements Iterator<Book> {
        private int index = 0;

        public boolean hasNext() {
            return index < books.size();
        }

        public Book next() {
            return books.get(index++);
        }

        public void remove() {
            books.remove(index - 1);
            index--;
        }
    }

    public Iterator<Book> iterator() {
        return new BookIterator();
    }
}
```
In this implementation, the `Bookshelf` class implements the `Iterable` interface and provides an inner class called `BookIterator` that implements the `Iterator` interface. The `BookIterator` class has the standard `hasNext()`, `next()` and `remove()` methods to iterate safely through the list of books.

The `iterator()` method of the `Bookshelf` class returns an instance of the `BookIterator` inner class, allowing the calling code to iterate safely through the list of books using a `for-each` loop or other iteration approach.

