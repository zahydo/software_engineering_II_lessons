# Adapter pattern

The Adapter pattern, also known as the Wrapper pattern, is a well-established software design pattern that facilitates the integration of disparate components within an application by enabling the interface of an existing class to be utilized as a different interface.

This pattern is particularly valuable when there is a need to combine existing classes or components with new ones without making any changes to the existing code, thus promoting reusability and maintainability.

<p align="center">
<img src="https://res.cloudinary.com/dzxhdnqm4/image/upload/v1681170223/uml_adapter_lps08h.png" alt="uml-composite" width="75%">
</p>

## 😟 Problem

Imagine you are developing an application that uses a third-party library for processing payments. The library has a specific interface for processing payments, but your application uses a different interface.

Without an appropriate solution, you'll face:

1. Incompatibility between interfaces
2. The need to modify existing code to work with the new interface
3. Difficulty in maintaining and extending the application

Here is the problematic code without using the Adapter pattern:

```java
public interface PaymentProcessor {
    void processPayment(double amount);
}

public class ThirdPartyPaymentProcessor {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via ThirdPartyPaymentProcessor");
    }
}
```

In this example, the PaymentProcessor interface is used by your application, while the ThirdPartyPaymentProcessor class is part of a third-party library. The ThirdPartyPaymentProcessor class has a different method signature, makePayment(), which is incompatible with the processPayment() method in the PaymentProcessor interface.

## 🙂 Solution

The Adapter pattern addresses these issues by creating a new class that implements the desired interface and contains an instance of the class with the incompatible interface. This new class acts as an adapter, allowing the two interfaces to work together.

Here is an implementation of the Adapter pattern in Java:

```java
public class PaymentProcessorAdapter implements PaymentProcessor {
    private ThirdPartyPaymentProcessor thirdPartyPaymentProcessor;

    public PaymentProcessorAdapter(ThirdPartyPaymentProcessor thirdPartyPaymentProcessor) {
        this.thirdPartyPaymentProcessor = thirdPartyPaymentProcessor;
    }

    public void processPayment(double amount) {
        thirdPartyPaymentProcessor.makePayment(amount);
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        ThirdPartyPaymentProcessor thirdPartyPaymentProcessor = new ThirdPartyPaymentProcessor();
        paymentProcessor.processPayment(100.00);
    }
}
```

In this example, we create a new class `PaymentProcessorAdapter` that implements the `PaymentProcessor` interface. It has an instance of `ThirdPartyPaymentProcessor` and delegates the `processPayment()` method to the `makePayment()` method of `ThirdPartyPaymentProcessor`.

With the Adapter pattern, we can now use the `ThirdPartyPaymentProcessor` in our application without modifying its code or the code of our application.

In summary, the Adapter pattern allows incompatible interfaces to work together by creating a new class that adapts one interface to another. In this example, the `PaymentProcessorAdapter` class adapts the `ThirdPartyPaymentProcessor` to the `PaymentProcessor` interface.
