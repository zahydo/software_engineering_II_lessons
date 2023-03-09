## Boy-Scout Rule

The Boy-Scout Rule is a principle that encourages software developers to leave the codebase in a better state than they found it. It suggests that developers should take small steps to improve the codebase as they work on it, such as cleaning up code, improving naming conventions, and removing redundant code.

### Bad example:

```
public class OrderProcessor {
    public void process(Order order) {
        int variable1;
        // rest of code
    }
    private void clean(Order order) {
        // rest of code
    }
}
```

### Good example:

```
public class OrderProcessor {
    /**
    * This method process the order ...(explain what is processed)
    * {order} Order
    */
    public void process(Order order) {
        int orderNumber;
    }

    /**
    * This method cleans the order ... (explain what is cleaned)
    * {order} Order
    */
    private void clean(Order order) {
        // rest of code
    }
}
```




[Back to the list](./README.md)