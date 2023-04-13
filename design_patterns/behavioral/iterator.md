## Iterator Patter

It is a behavior design pattern, which allows us to have information about the traversal of a collection of objects, either the number of objects in the collection, or how many elements are needed to traverse. We find this pattern useful for accessing objects in an array or a collection of objects without exposing their underlying representation.

## Class Diagram of example:

![classDiagram](http://www.plantuml.com/plantuml/png/bL1DIyGm4BtdLyonPSd-W1wMlGgoUXSFQNPq8yb4CXCGrlvtszYIjdYnXp8ytiTxEREO93buvKWmlHcBy30UHcA2kuBnEzmCN_1BchQ3FaQFXdvnci6d_WEjg44fwmqpN7BeCJqwbjb1Kq6uWp7avRLWvNSFABTu7U1GDKtXm2nfTxntbANU5BtSDNoos0tGDgU49C-HdRX8fSPV9TRQfltl-DNiu_5KNx43cz08yfgXzQbMtR8siDRV6oiNFZq6965rHhhcu7y0)

## Example
Suppose we have a list of numbers that we need to iterate through. In this list, all objects can be traversed in different ways, even up to objects that have been traversed before. It is necessary to implement a way to repeat the list without repeating elements already traversed.

To implement the iterator pattern, we are first going to declare an interface called ``Iiterator``.

```Java
public interface Iiterator {
    public boolean hasNext();
    public Object next();
}
```
Now, inside a class called ``listNumbers``, create an inner class that implements ``Iiterator`` interface. This class must have a reference to the list of numbers and an index to keep track of the current iterator position.

```Java
public class NumberList {
    private int[] numbers;
    
    // constructor, getters, setters, etc.
    
    private class ListIterator implements Iterator {
        private int currentPosition;
        
        public ListIterator() {
            currentPosition = 0;
        }
        
        public boolean hasNext() {
            return currentPosition < numbers.length;
        }
        
        public Object next() {
            if (hasNext()) {
                int number = numbers[currentPosition];
                currentPosition++;
                return number;
            }
            throw new NoSuchElementException();
        }
    }
    
    public Iterator getIterator() {
        return new ListIterator();
    }
}
```
Finally, in the main program, the iterator can be used to traverse the list without the inconvenience of traversing the same objects over and over again.

```Java
ListNumbers lista = new ListNumbers(new int[]{1, 2, 3, 4, 5});
Iiterator iterator = lista.getIterator();

while (iterator.hasNext()) {
    int number = (int) iterator.next();
    System.out.println(numero);
}
```
In this solution, the ``getIterator()`` method of the ``NumberList`` class returns an instance of the ``ListIterator`` class, which is capable of traversing the list of numbers and returning each element one by one. Then, in the main program, a ``while`` loop is used to traverse the list and the ``next()`` method of the iterator is called to get each number.



[Back](../behavioral/README.md)