# Abstract Singleton 
## Description
The Singleton design pattern is a creational design pattern that ensures that a class has only one instance, and provides a global point of access to that instance. It guarantees that the object is initialized only once, and that all subsequent calls to that object return the same instance.

## Problem:
In some scenarios, we need to ensure that a class has only one instance and that this instance is globally accessible. For example, we may need to create a logging or database connection object that is shared across the entire application. Creating multiple instances of these objects can result in unexpected behavior and consume unnecessary resources.

## Solution:
The Singleton pattern provides a solution to the above problem by defining a class that has only one instance and a global point of access to that instance. The Singleton class ensures that its constructor is private, so that it cannot be instantiated from outside the class. It provides a static method to access the singleton instance, which creates the instance if it does not exist, or returns the existing instance if it has already been created.

By using the Singleton pattern, we can ensure that a class has only one instance, and that this instance is globally accessible. This pattern also promotes encapsulation, by hiding the creation of the singleton instance from the client code. It is useful in scenarios where we need to manage limited resources, such as connections to a database, or in situations where we need to maintain a single global state, such as in a configuration object.
## Example: 
### Structure
<p align="center">
    <img src="./diagrams/singleton.svg"/>
</p>
### Implementation