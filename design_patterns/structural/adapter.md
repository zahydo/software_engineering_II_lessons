# Adapter pattern

The Adapter design pattern is a structural pattern that allows objects with incompatible interfaces to collaborate. It acts as a wrapper or translator, converting the interface of one class into another interface that clients expect. This pattern is useful when you want to reuse existing code that doesn't quite fit with the rest of your application. By using an adapter, you can make the code work without modifying the original source.

The Adapter pattern consists of three main components: the Adaptee, the Adapter, and the Target. The Adaptee is the class that needs to be adapted, but it's not compatible with the Target interface. The Adapter is the class that converts the Adaptee's interface into the Target interface. The Target is the interface that the client code expects to use.

Overall, the Adapter pattern provides a way to make existing code work with new code without changing either one. This can be a valuable tool in software development, especially when dealing with legacy code or third-party libraries.

An example of the adapter pattern using Java code could be:

Think that your application has a client class that expects to work with a certain interface called TargetInterface. However, you have a legacy class called AdapteeClass that has a different interface that is not compatible with TargetInterface. you need to use AdapteeClass in our application without modifying the existing code. You can use the Adapter pattern to create a new class called AdapterClass that acts as a wrapper for AdapteeClass and implements the TargetInterface. This will allow you to use AdapteeClass in your application without modifying the original source code.

```java 
// AdapteeClass - the legacy class with an incompatible interface
public class AdapteeClass {
    public void specificMethod() {
        // implementation
    }
}

// TargetInterface - the interface expected by the client code
public interface TargetInterface {
    void method();
}

// AdapterClass - the adapter that converts AdapteeClass to TargetInterface
public class AdapterClass implements TargetInterface {
    private AdapteeClass adaptee;

    public AdapterClass(AdapteeClass adaptee) {
        this.adaptee = adaptee;
    }

    public void method() {
        adaptee.specificMethod();
    }
}

// ClientClass - the client code that expects to work with TargetInterface
public class ClientClass {
    public void doSomething(TargetInterface target) {
        target.method();
    }
}

// Usage example
public class Main {
    public static void main(String[] args) {
        AdapteeClass adaptee = new AdapteeClass();
        AdapterClass adapter = new AdapterClass(adaptee);
        ClientClass client = new ClientClass();

        client.doSomething(adapter);
    }
}
```
In this example, you create an AdapterClass that takes an instance of AdapteeClass as a parameter and implements the TargetInterface. The method() implementation in the adapter simply calls the specificMethod() of the AdapteeClass. Then, you can pass the adapter to the ClientClass and call its doSomething() method, which expects an instance of TargetInterface. By using the Adapter pattern, you're able to use AdapteeClass in your application without modifying the existing code.