## Open/Closed

"The Open/Closed Principle (OCP) is an object-oriented design principle that states that classes should be open for extension but closed for modification. This means that a class should be able to extend its behavior without changing its original source code. In other words, new functionalities should be added to a class without modifying its existing implementation. This ensures greater stability and reliability of the system as a whole, as changes made to a class will not affect its current operation or that of other components that depend on it."

### Bad example:

import java.util.Date;

public class Main {
    
    public static void printMessage(String message) {
        System.out.println(message);
    }
    
    public static void printMessageWithTime(String message) {
        Date currentDate = new Date();
        System.out.printf("%s: %s\n", currentDate.toString(), message);
    }
    
    public static void main(String[] args) {
        printMessage("Hello, world!");
        printMessageWithTime("Hello, world with time!");
    }
    
}

### Good example:

public class Main {
    
    public static void main(String[] args) {
        String message = "Hola mundo";
        printMessage(message);
        printMessageUppercase(message);
    }
    
    public static void printMessage(String message) {
        System.out.println(message);
    }
    
    public static void printMessageUppercase(String message) {
        String uppercaseMessage = message.toUpperCase();
        printMessage(uppercaseMessage);
    }
}
public static String uppercaseString(String message) {
    StringBuilder sb = new StringBuilder();
    for (char c : message.toCharArray()) {
        sb.append(Character.toUpperCase(c));
    }
    return sb.toString();
}
Luego se puede utilizar esta función en lugar de toUpperCase en la función printMessageUppercase.


### Related principles

- Separación de intereses


---
[Back to the list](./README.md)