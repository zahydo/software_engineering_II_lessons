## Code For The Maintainer

The principle of "Code For The Maintainer" emphasizes the importance of designing code that is easy to modify and maintain. This involves making code modular, loosely coupled, and easy to test. By designing code with maintainability in mind, developers can reduce the risk of introducing bugs or errors, and make it easier to adapt to changing requirements.

### Bad example

```
public class PaymentProcessor {
    public void processPayment(double amount, String currency, String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        // Validate payment details
        if (cardNumber.length() != 16) {
            throw new IllegalArgumentException("Invalid card number");
        }

        // Process payment
        String result = processPaymentUsingPayPal(amount, currency, cardNumber, cardHolderName, expiryDate, cvv);
        if (!result.equals("SUCCESS")) {
            throw new RuntimeException("Payment processing failed");
        }
    }

    private String processPaymentUsingPayPal(double amount, String currency, String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        // Process payment using PayPal API
        return "SUCCESS";
    }
}
```

This code violates the "Code For The Maintainer" principle because it is tightly coupled and difficult to modify or extend. The PaymentProcessor class contains both validation and processing logic, making it difficult to modify either without affecting the other. Additionally, the code relies on a specific payment gateway implementation, making it difficult to change the gateway used.

### Good example

```
public class PaymentProcessor {
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(Payment payment) {
        // Validate payment details
        if (!isValid(payment)) {
            throw new IllegalArgumentException("Invalid payment details");
        }

        // Process payment
        paymentGateway.processPayment(payment);
    }

    private boolean isValid(Payment payment) {
        // Check if payment details are valid
        return true;
    }
}

public interface PaymentGateway {
    void processPayment(Payment payment);
}

public class PayPalGateway implements PaymentGateway {
    @Override
    public void processPayment(Payment payment) {
        // Process payment using PayPal API
    }
}

public class Payment {
    private String id;
    private double amount;
    private String currency;
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    // Getters and setters omitted for brevity
}
```

In this example, the code is designed with maintainability in mind. The PaymentProcessor class has a single responsibility of processing payments and is designed to be easy to modify or extend. It is easy to change the payment gateway used by modifying the constructor parameter, without needing to modify the processPayment method. The code is also easy to test because the PaymentGateway interface allows for easy mocking of dependencies.