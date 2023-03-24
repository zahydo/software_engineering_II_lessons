## Liskov Substitution

"Liskov Substitution" this principle tells us that a subclass should be able to be used in place of its superclass without causing errors or unexpected behavior. 

It facilitates code reuse, since subclasses can inherit and extend the behavior of their parent classes, while maintaining the interface and behavior of the superclass. 
behavior of their parent classes, while maintaining the interface and behavior of the superclass. Violations of the principle can lead to errors, bugs and unexpected behavior in a software system. Therefore, it is important to design and implement classes and their inheritance relationships in a way that follows this principle.

### Bad example:

```
import java.util.ArrayList;

class ListofNumbers {
    ArrayList<Integer> numbers = new ArrayList<Integer>();

    public void addNumber(int number) {
        numbers.add(number);
    }
}

class ListofEvenNumbers extends ListofNumbers {
    @Override
    public void addNumber(int number) {
        if (number % 2 != 0) {
            throw new IllegalArgumentException("Only even numbers are allowed.");
        }
        super.addNumber(number);
    }
}
```
In this example, the ListofEvenNumbers class inherits from the ListofNumbers class and overrides the addNumber method to only accept even numbers. However, if we try to add an odd number to the ListofEvenNumbers list, an exception would be thrown, violating the Liskov Substitution Principle.

### Good example:

```
import java.util.ArrayList;

class ListofNumbers {
    ArrayList<Integer> numbers = new ArrayList<Integer>();

    public void addNumber(int number) {
        numbers.add(number);
    }
}

class ListofEvenNumbers {
    ListofNumbers listofNumbers = new ListofNumbers();

    public void addEvenNumber(int number) {
        if (number % 2 != 0) {
            throw new IllegalArgumentException("Only even numbers are allowed.");
        }
        listofNumbers.addNumber(number);
    }
}
```
In this example, the ListofEvenNumbers class contains an instance of ListofNumbers inside it, using composition instead of inheritance. The ListofEvenNumbers class also defines a new method addEvenNumber that only accepts even numbers and adds them to the internal list of numbers. This solution satisfies the Liskov Substitution Principle, as the ListofEvenNumbers class can be used in place of ListofNumbers without changing its behavior.

### Related principles

- [Composition Over Inheritance](../general/compositionoverinheritance.md)

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)