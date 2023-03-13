## Avoid Premature Optimization

The principle of "Avoid Premature Optimization" emphasizes the importance of writing code that is simple and easy to understand, rather than focusing on performance optimization. Premature optimization can lead to code that is more complex, harder to read and understand, and harder to modify or maintain. In many cases, the performance gains achieved through premature optimization may not be worth the cost in terms of code complexity and maintainability.

### Bad example

```
public class ArrayUtils {
    public static <T> boolean contains(T[] array, T value) {
        Arrays.sort(array);
        int index = Arrays.binarySearch(array, value);
        return index >= 0;
    }
}
```

This code violates the "Avoid Premature Optimization" principle by prematurely optimizing the `contains` method. The `contains` method uses the `Arrays.sort` method to sort the array, and then uses the `Arrays.binarySearch` method to quickly search for the value. While this code may be faster for large arrays, it is more complex and harder to understand than the not-optimized method.

### Good example

```
public class ArrayUtils {
    public static <T> boolean contains(T[] array, T value) {
        for (T element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
```

In this example, the code is written to be simple and easy to understand. The `contains` method simply checks whether a given value exists in an array. This code is not optimized for performance, but it is easy to read, write, and test.



------
[Back to the list](./README.md)