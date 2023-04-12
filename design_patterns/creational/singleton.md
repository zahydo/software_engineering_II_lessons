# Singleton pattern
## Description
A singleton is a design pattern in software development that ensures only one instance of a particular class exists in a program, and provides a global point of access to that instance. This means that the singleton class can be used to represent a single resource, such as a database connection, a hardware device, or a configuration object, and can be accessed by any part of the program that needs it.

The singleton pattern is often used to provide a centralized point of control or coordination in an application, and to simplify the management of shared resources or global state. However, it is important to use the singleton pattern judiciously, as it can introduce tight coupling and make the code harder to test and maintain.

## Problem
Suppose we are developing a point-of-sale application and need a class that handles access to a receipt printer. We only want to have one instance of this class in our program since there is only one physical printer connected to the system. Additionally, we want to ensure that the instance of the class is available to any part of the program that needs to print receipts.

We can implement this functionality using the Singleton pattern. We create a Printer class that has a private constructor and a static getInstance() method that returns the single instance of the class. The getInstance() method checks if an instance of Printer already exists and, if so, returns it. If not, it creates a new instance and returns it.

## Solution
```java
public class Printer {
    private static Printer instance;
    
    private Printer() {
        // Private constructor to prevent direct instantiation
    }
    
    public static Printer getInstance() {
        if (instance == null) {
            instance = new Printer();
        }
        return instance;
    }
    
    public void printReceipt(String receipt) {
        // Method to print the receipt
    }
}

```
In this example, the Printer class has only a private constructor, which means it can only be instantiated from within the class. The getInstance() method is static and returns the single instance of the Printer class. The printReceipt() method is used to print a receipt on the printer.